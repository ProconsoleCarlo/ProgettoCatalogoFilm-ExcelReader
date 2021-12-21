package ui.searchEngine;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import program.FilmManager;
import utils.GridBagBuilder;

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private FilmManager filmManager;
	private Map<String, String> language;
	private SearchEngine searchEngine;
	private JList<String> searchList;
	private java.util.List<String> searchResultsList;
	
	private JTextField searchField;
		
	public SearchPanel(Map<String, String> language, FilmManager filmManager) {
		super();
		this.language = language;
		this.filmManager = filmManager;
		searchEngine = new SearchEngine(filmManager);
		realize();
		this.setMinimumSize(this.getPreferredSize());
	}
	
	/*
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {		
		JLabel searchLabel = new JLabel(language.get("SearchPanelSearchLabel"));
		bagBuilder.add(searchLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(100, (int)searchField.getPreferredSize().getHeight()));
		searchField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				update();
			}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		bagBuilder.add(searchField, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel filler1 = new JLabel();
		bagBuilder.add(filler1, 3, 0, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		searchList = new JList<>();
		JScrollPane searchScrollPane = new JScrollPane(searchList);
		searchList.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					filmManager.setSelectedFilm(filmManager.getDb().get(searchList.getSelectedValue()));
					filmManager.update();
				} catch (NullPointerException e2) {
					System.err.println("Niente caricato!");
				}
			}
		});
		bagBuilder.add(searchScrollPane, 0, 1, 4, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		update();
	}

	private void update() {
		searchResultsList = searchEngine.searchValue(searchField.getText());
		searchList.setListData(searchResultsList.toArray(new String[searchResultsList.size()]));
		searchList.repaint();
	}
}
