package ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import program.FilmManager;
import ui.searchEngine.SearchPanel;
import ui.viewFilmData.ViewPanel;
import utils.GridBagBuilder;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private FilmManager filmManager;
	private Map<String, String> language;
	
	private ViewPanel viewPanel;
		
	public MainPanel(Map<String, String> language, FilmManager filmManager) {
		super();
		this.language = language;
		this.filmManager = filmManager;
		realize();
	}
	
	/*
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {
		SearchPanel searchPanel = new SearchPanel(language, filmManager);
		bagBuilder.add(searchPanel, 0, 0, 1, 1, 0, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		viewPanel = new ViewPanel(language, filmManager);
		viewPanel.setEditable(false);
		bagBuilder.add(viewPanel, 1, 0, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	
		JButton modifyButton = new JButton(language.get("MainPanelModifyButton"));
		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewPanel.setEditable(true);
			}
		});
		bagBuilder.add(modifyButton, 0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JButton saveButton = new JButton(language.get("MainPanelSaveButton"));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewPanel.setEditable(false);
			}
		});
		bagBuilder.add(saveButton, 1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JButton newButton = new JButton(language.get("MainPanelNewButton"));
		bagBuilder.add(newButton, 2, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
}
