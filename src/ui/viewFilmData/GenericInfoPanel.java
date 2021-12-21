package ui.viewFilmData;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import utils.GridBagBuilder;
import database.IFilm;

public class GenericInfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private Map<String, String> language;
	
	private JTextField titleField;
	private JTextField yearField;
	private JTextField ratingField;
	private JTextField durationField;
	private JList<String> genresList;
	
	public GenericInfoPanel(Map<String, String> language) {
		super();
		this.language = language;
		realize();
	}
	
	public void setEditable(boolean value) {
		titleField.setEditable(value);
		yearField.setEditable(value);
		ratingField.setEditable(value);
		durationField.setEditable(value);
		//TODO genresList
	}
	public void setSelectedFilm(IFilm selectedFilm) {
		updateFilmData(selectedFilm);
	}

	/*
	 * TODO
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {
		JLabel titleLabel = new JLabel(language.get("GenericInfoPanelLabelTitle"));
		bagBuilder.add(titleLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		titleField = new JTextField();
		bagBuilder.add(titleField, 1, 0, 7, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel yearLabel = new JLabel(language.get("GenericInfoPanelLabelYear"));
		bagBuilder.add(yearLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		yearField = new JTextField();
		yearField.setPreferredSize(new Dimension(100, (int)yearField.getPreferredSize().getHeight()));
		bagBuilder.add(yearField, 1, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel filler1 = new JLabel();
		bagBuilder.add(filler1, 2, 1, 1, 1, 0.5, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel ratingLabel = new JLabel(language.get("GenericInfoPanelLabelRating"));
		bagBuilder.add(ratingLabel, 3, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		ratingField = new JTextField();
		ratingField.setPreferredSize(new Dimension(50, (int)yearField.getPreferredSize().getHeight()));
		bagBuilder.add(ratingField, 4, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel filler2 = new JLabel();
		bagBuilder.add(filler2, 5, 1, 1, 1, 0.5, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel durationLabel = new JLabel(language.get("GenericInfoPanelLabelDuration"));
		bagBuilder.add(durationLabel, 6, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		durationField = new JTextField();
		durationField.setPreferredSize(new Dimension(100, (int)yearField.getPreferredSize().getHeight()));
		bagBuilder.add(durationField, 7, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel genreLabel = new JLabel(language.get("GenericInfoPanelLabelGenre"));
		bagBuilder.add(genreLabel, 0, 2, 8, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		genresList = new JList<>();
		JScrollPane genresScrollPane = new JScrollPane(genresList);
		bagBuilder.add(genresScrollPane, 0, 3, 8, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	
	private void updateFilmData(IFilm selectedFilm) {
		titleField.setText(selectedFilm.getGenerics().getTitle());
		yearField.setText(String.valueOf(selectedFilm.getGenerics().getYearOfRelease()));
		ratingField.setText(String.valueOf(selectedFilm.getGenerics().getRating()));
		SimpleDateFormat duration = new SimpleDateFormat("HH:mm:ss");
		durationField.setText(duration.format(selectedFilm.getGenerics().getDuration()));
		genresList.setListData(selectedFilm.getGenerics().getGenres().replaceAll(" ", "").split(","));
		genresList.repaint();
	}
}
