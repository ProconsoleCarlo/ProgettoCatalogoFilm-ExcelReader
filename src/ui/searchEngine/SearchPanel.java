package ui.searchEngine;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import program.FilmManager;
import utils.GridBagBuilder;

public class SearchPanel extends JPanel implements Observer{

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
		searchEngine.addObserver(this);
	}
	
	/*
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(200, (int)searchField.getPreferredSize().getHeight()));
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
		bagBuilder.add(searchField, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JButton advancedSearchButton = new JButton("Advanced search");
		advancedSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdvancedSearchPanel(searchEngine);
			}
		});
		bagBuilder.add(advancedSearchButton, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		searchList = new JList<>();
		JScrollPane searchScrollPane = new JScrollPane(searchList);
		searchScrollPane.setPreferredSize(new Dimension(300, (int)searchScrollPane.getPreferredSize().getHeight()));
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
		bagBuilder.add(searchScrollPane, 0, 1, 2, 1, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		update();
	}

	public void update() {
		//searchEngine.searchValue(searchField.getText());
		searchResultsList = searchEngine.getSearchResults();
		searchList.setListData(searchResultsList.toArray(new String[searchResultsList.size()]));
		searchList.repaint();
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		searchResultsList = searchEngine.getSearchResults();
		searchList.setListData(searchResultsList.toArray(new String[searchResultsList.size()]));
		searchList.repaint();
	}

}
