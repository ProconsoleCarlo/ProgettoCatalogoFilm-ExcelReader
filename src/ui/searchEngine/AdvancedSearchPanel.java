package ui.searchEngine;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JDialog;

import utils.GridBagBuilder;

public class AdvancedSearchPanel extends JDialog{

	private static final long serialVersionUID = 1L;
	private SearchEngine searchEngine;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	private ArrayList<String> filtersNames = new ArrayList<>();
	private ArrayList<String> filtersOptions = new ArrayList<>();
	
	public AdvancedSearchPanel(SearchEngine searchEngine) {
		super();
		this.searchEngine = searchEngine;
		Collections.addAll(filtersNames, "Titolo", 
				"Anno", 
				"Rating", 
				"Genere", 
				"Durata", 
				"Risoluzione video", 
				"Fps", 
				"Bitrate video (kbps)", 
				"Codec video",
				"Bitrate audio (kbps)",
				"Frequenza (kHz)",
				"Canali",
				"Codec audio",
				"Dimensione (MB)",
				"Contenitore",
				"Data");
		//Occorre fare una hashMap di corrispondenza tra il valore visualizzato e quello passato come parametro con il filtro
		//Per uniformare il search engine
		Collections.addAll(filtersOptions, "contiene,uguale",
				"prima di,uguale a,dopo il",
				"minore di,uguale a,maggiore di",
				"",
				"minore di,uguale a,maggiore di",
				"minore di,uguale a,maggiore di",
				"minore di,uguale a,maggiore di",
				"minore di,uguale a,maggiore di",
				"",
				"minore di,uguale a,maggiore di",
				"minore di,uguale a,maggiore di",
				"minore di,uguale a,maggiore di",
				"",
				"minore di,uguale a,maggiore di",
				"",
				"prima di,uguale a,dopo il");
		realize();
		this.pack();
		this.setVisible(true);
	}
	
	private void realize() {
		final ArrayList<FilterPanel> filters = new ArrayList<>();
		for (int i = 0; i < filtersNames.size(); i++) {
			FilterPanel filterPanel = new FilterPanel(filtersNames.get(i)+":"+filtersOptions.get(i));
			bagBuilder.add(filterPanel, 0, i, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
			filters.add(filterPanel);
		}
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] outputfilters = new String[filters.size()];
				for (int i = 0; i < filters.size(); i++) {
					outputfilters[i] = filters.get(i).getFilterValue();
					//System.err.println(filters.get(i).getFilterValue()+" lenght "+filters.get(i).getFilterValue().split(":").length);
				}
				searchEngine.filterFilms(outputfilters);
				aggiorna();
			}
		});
		bagBuilder.add(searchButton, 0, filtersNames.size()+1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}
	
	private void aggiorna() {
		searchEngine.update();

	}

}
