package ui.viewFilmData.TechnicalPanels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import utils.GridBagBuilder;
import database.IFilm;

public class AudioPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private Map<String, String> language;
	
	private JTextField bitrateField;
	private JTextField frequencyField;
	private JTextField channelsField;
	private JTextField codecField;
	
	protected AudioPanel(Map<String, String> language) {
		super();
		this.language = language;
		realize();
	}
	
	protected void setEditable(boolean value) {
		bitrateField.setEditable(value);
		frequencyField.setEditable(value);
		channelsField.setEditable(value);
		codecField.setEditable(value);
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
		this.setBorder(new TitledBorder(language.get("AudioPanelTitle")));
		
		JLabel bitrateLabel = new JLabel(language.get("AudioPanelBitrate"));
		bagBuilder.add(bitrateLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		bitrateField = new JTextField();
		bitrateField.setPreferredSize(new Dimension(100, (int)bitrateField.getPreferredSize().getHeight()));
		bagBuilder.add(bitrateField, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel filler1 = new JLabel();
		bagBuilder.add(filler1, 2, 0, 1, 4, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel frequencyLabel = new JLabel(language.get("AudioPanelFrequency"));
		bagBuilder.add(frequencyLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		frequencyField = new JTextField();
		frequencyField.setPreferredSize(new Dimension(100, (int)frequencyField.getPreferredSize().getHeight()));
		bagBuilder.add(frequencyField, 1, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel channelsLabel = new JLabel(language.get("AudioPanelChannels"));
		bagBuilder.add(channelsLabel, 0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		channelsField = new JTextField();
		channelsField.setPreferredSize(new Dimension(50, (int)frequencyField.getPreferredSize().getHeight()));
		bagBuilder.add(channelsField, 1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel codecLabel = new JLabel(language.get("AudioPanelCodec"));
		bagBuilder.add(codecLabel, 0, 3, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		codecField = new JTextField();
		codecField.setPreferredSize(new Dimension(100, (int)frequencyField.getPreferredSize().getHeight()));
		bagBuilder.add(codecField, 1, 3, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	private void updateFilmData(IFilm selectedFilm) {
		bitrateField.setText(String.valueOf(selectedFilm.getTechnicalData().getBitrateAudio()));
		frequencyField.setText(String.valueOf(selectedFilm.getTechnicalData().getAudioFrequency()));
		channelsField.setText(String.valueOf(selectedFilm.getTechnicalData().getAudioChannels()));
		codecField.setText(selectedFilm.getTechnicalData().getCodecAudio());
	}
}
