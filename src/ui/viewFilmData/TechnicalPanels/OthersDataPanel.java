package ui.viewFilmData.TechnicalPanels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import utils.GridBagBuilder;
import database.IFilm;

public class OthersDataPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	
	private Map<String, String> language;
	
	private JTextField sizeField;
	private JTextField containerField;
	private JTextArea technicalNotesArea;
	
	protected OthersDataPanel(Map<String, String> language) {
		super();
		this.language = language;
		realize();
	}
	
	protected void setEditable(boolean value) {
		sizeField.setEditable(value);
		containerField.setEditable(value);
		technicalNotesArea.setEditable(value);
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
		this.setBorder(new TitledBorder(language.get("OthersDataPanelTitle")));
		
		JLabel sizeLabel = new JLabel(language.get("OthersDataPanelSize"));
		bagBuilder.add(sizeLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		sizeField = new JTextField();
		sizeField.setPreferredSize(new Dimension(100, (int)sizeField.getPreferredSize().getHeight()));
		bagBuilder.add(sizeField, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel sizeUnitLabel = new JLabel("MB");
		sizeUnitLabel.setPreferredSize(new Dimension(25, (int)sizeUnitLabel.getPreferredSize().getHeight()));
		bagBuilder.add(sizeUnitLabel, 2, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	
		JLabel containerLabel = new JLabel(language.get("OthersDataPanelContainer"));
		bagBuilder.add(containerLabel, 4, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		containerField = new JTextField();
		containerField.setPreferredSize(new Dimension(100, (int)containerField.getPreferredSize().getHeight()));
		bagBuilder.add(containerField, 5, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel filler2 = new JLabel();
		bagBuilder.add(filler2, 6, 0, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		JLabel techicalNotesLabel = new JLabel(language.get("OthersDataPanelTechnicalNotes"));
		bagBuilder.add(techicalNotesLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		technicalNotesArea = new JTextArea();
		JScrollPane techcnicalNotesScrollPane = new JScrollPane(technicalNotesArea);
		//TODO si dovrebbe risolvere facendo le misure di tutti i componenti proporzionali alla dimensione del pannello che li contiene
		techcnicalNotesScrollPane.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth(), 100));
		bagBuilder.add(techcnicalNotesScrollPane, 0, 2, 7, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	private void updateFilmData(IFilm selectedFilm) {
		sizeField.setText(String.valueOf(selectedFilm.getTechnicalData().getSize()));
		containerField.setText(selectedFilm.getTechnicalData().getContainer());
		technicalNotesArea.setText(selectedFilm.getTechnicalData().getTechnicalNotes());
	}
}
