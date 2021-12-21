package ui.viewFilmData;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTabbedPane;

import program.FilmManager;
import ui.viewFilmData.TechnicalPanels.TechnicalDataPanel;

public class ViewPanel extends JTabbedPane implements Observer{

	private static final long serialVersionUID = 1L;

	private Map<String, String> language;
	private FilmManager filmManager;
	
	private GenericInfoPanel genericInfoPanel;
	private ReviewsPanel reviewsPanel;
	private TechnicalDataPanel technicalDataPanel;
	
	public ViewPanel(Map<String, String> language, FilmManager filmManager) {
		super();
		this.filmManager = filmManager;
		filmManager.addObserver(this);
		this.language = language;
		realize();
	}
	
	public void setEditable(boolean value) {
		genericInfoPanel.setEditable(value);
		reviewsPanel.setEditable(value);
		technicalDataPanel.setEditable(value);
	}
	
	private void realize(){
		genericInfoPanel = new GenericInfoPanel(language);
		reviewsPanel = new ReviewsPanel(language);
		technicalDataPanel = new TechnicalDataPanel(language);
		this.addTab(language.get("ViewPanelTabGenericsInfo"), null, genericInfoPanel, language.get("ViewPanelTabGenericsInfoDescription"));
		this.addTab(language.get("ViewPanelTabReviews"), null, reviewsPanel, language.get("ViewPanelTabReviewsDescription"));
		this.addTab(language.get("ViewPanelTabTechnicalData"), null, technicalDataPanel, language.get("ViewPanelTabTechnicalDataDescription"));
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		genericInfoPanel.setSelectedFilm(filmManager.getSelectedFilm());
		reviewsPanel.setSelectedFilm(filmManager.getSelectedFilm());
		technicalDataPanel.setSelectedFilm(filmManager.getSelectedFilm());
	}
}
