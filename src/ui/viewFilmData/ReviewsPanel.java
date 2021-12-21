package ui.viewFilmData;

import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.GridBagBuilder;
import database.IFilm;

public class ReviewsPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private Map<String, String> language;
	
	private JList<String> reviewsList;
	
	public ReviewsPanel(Map<String, String> language) {
		super();
		this.language = language;
		realize();
	}
	public void setEditable(boolean value) {
		//TODO reviewsList
	}

	public void setSelectedFilm(IFilm selectedFilm) {
		updateFilmData(selectedFilm);
	}
	
	/*
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {
		JLabel titleLabel = new JLabel(language.get("ReviewsPanelLabelTitle"));
		bagBuilder.add(titleLabel, 0, 0, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		reviewsList = new JList<>();
		JScrollPane reviewsScrollPane = new JScrollPane(reviewsList);
		//TODO generiList.setListData(lista);
		bagBuilder.add(reviewsScrollPane, 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel statisticData = new JLabel(language.get("ReviewsPanelLabelStatistics"));
		bagBuilder.add(statisticData, 0, 2, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	
	private void updateFilmData(IFilm selectedFilm) {
		ArrayList<String> reviewsArray = new ArrayList<>();
		reviewsArray.clear();
		Map<Date, String> reviews = selectedFilm.getReviews();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		for (Map.Entry<Date, String> entry  : reviews.entrySet()) {
			reviewsArray.add(date.format(entry.getKey())+" : "+entry.getValue());
		}
		reviewsList.setListData(reviewsArray.toArray(new String[reviewsArray.size()]));

		reviewsList.repaint();
	}
}
