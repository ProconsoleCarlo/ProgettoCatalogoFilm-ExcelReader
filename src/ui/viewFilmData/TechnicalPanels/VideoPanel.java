package ui.viewFilmData.TechnicalPanels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import utils.GridBagBuilder;
import database.Film;

public class VideoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private Map<String, String> language;
	
	private JTextField resolutionField;
	private JTextField fpsField;
	private JTextField bitrateField;
	private JTextField codecField;
	
	protected VideoPanel(Map<String, String> language) {
		super();
		this.language = language;
		realize();
	}
	
	protected void setEditable(boolean value) {
		resolutionField.setEditable(value);
		fpsField.setEditable(value);
		bitrateField.setEditable(value);
		codecField.setEditable(value);
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
		this.setBorder(new TitledBorder(language.get("VideoPanelTitle")));
		
		JLabel resolutionLabel = new JLabel(language.get("VideoPanelResolution"));
		bagBuilder.add(resolutionLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		resolutionField = new JTextField();
		resolutionField.setPreferredSize(new Dimension(100, (int)resolutionField.getPreferredSize().getHeight()));
		bagBuilder.add(resolutionField, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel filler1 = new JLabel();
		bagBuilder.add(filler1, 2, 0, 1, 4, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel fpsLabel = new JLabel(language.get("VideoPanelFps"));
		bagBuilder.add(fpsLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		fpsField = new JTextField();
		fpsField.setPreferredSize(new Dimension(100, (int)fpsField.getPreferredSize().getHeight()));
		bagBuilder.add(fpsField, 1, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel bitrateLabel = new JLabel(language.get("VideoPanelBitrate"));
		bagBuilder.add(bitrateLabel, 0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		bitrateField = new JTextField();
		bitrateField.setPreferredSize(new Dimension(50, (int)fpsField.getPreferredSize().getHeight()));
		bagBuilder.add(bitrateField, 1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel codecLabel = new JLabel(language.get("VideoPanelCodec"));
		bagBuilder.add(codecLabel, 0, 3, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		codecField = new JTextField();
		codecField.setPreferredSize(new Dimension(100, (int)fpsField.getPreferredSize().getHeight()));
		bagBuilder.add(codecField, 1, 3, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	private void updateFilmData(Film selectedFilm) {
		resolutionField.setText(selectedFilm.getTechnicalData().getVideoResolution());
		fpsField.setText(String.valueOf(selectedFilm.getTechnicalData().getFpsVideo()));
		bitrateField.setText(String.valueOf(selectedFilm.getTechnicalData().getBitrateVideo()));
		codecField.setText(selectedFilm.getTechnicalData().getCodecVideo());
	}
}
