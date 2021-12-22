package ui.viewFilmData.TechnicalPanels;

import java.awt.GridBagConstraints;
import java.util.Map;

import javax.swing.JPanel;

import utils.GridBagBuilder;
import database.Film;

public class TechnicalDataPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private Map<String, String> language;

	private VideoPanel videoPanel;
	private AudioPanel audioPanel;
	private OthersDataPanel othersDataPanel;
	
	public TechnicalDataPanel(Map<String, String> language) {
		super();
		this.language = language;
		realize();
	}
	
	public void setEditable(boolean value) {
		videoPanel.setEditable(value);
		audioPanel.setEditable(value);
		othersDataPanel.setEditable(value);
	}
	
	public void setSelectedFilm(Film film) {
		updateFilmData(film);
	}

	/*
	 * TODO
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {
		videoPanel = new VideoPanel(language);
		bagBuilder.add(videoPanel, 0, 0, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		audioPanel = new AudioPanel(language);
		bagBuilder.add(audioPanel, 0, 1, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		othersDataPanel = new OthersDataPanel(language);
		bagBuilder.add(othersDataPanel, 0, 2, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	private void updateFilmData(Film film) {
		videoPanel.setSelectedFilm(film);
		audioPanel.setSelectedFilm(film);
		othersDataPanel.setSelectedFilm(film);
	}
}
