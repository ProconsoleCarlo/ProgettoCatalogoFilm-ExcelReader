package ui.searchEngine;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

import program.FilmManager;
import database.Film;

public class SearchEngine extends Observable{

	private FilmManager filmManager;
	
	private ArrayList<String> searchResults = new ArrayList<>();
	private String stringSearched;
		
	public SearchEngine(FilmManager filmManager) {
		super();
		this.filmManager = filmManager;
	}

	public ArrayList<String> getSearchResults() {
		return searchResults;
	}
	

	//Ottimizzazione per evitare che cerchi a prescindere appena premo un qlss tasto
	public ArrayList<String> searchValue(String stringToSearch) {
		if (!stringToSearch.equals(stringSearched)) {
			searchResults.clear();
			System.err.println("Searching: "+stringToSearch);
			for (Map.Entry<String, Film> entry  : filmManager.getDb().entrySet()) {
				if (entry.getKey().toLowerCase().startsWith(stringToSearch.toLowerCase())) {
					searchResults.add(entry.getKey());
				}
			}
			stringSearched = stringToSearch;
		}
		return searchResults;
	}
	
	public void filterFilms(String[] filters) {
		searchResults.clear();
		for (int i = 0; i < filters.length; i++) {
			String[] filterToApply = filters[i].split(":");
			if (filterToApply.length == 3) {
				System.err.println("searching: "+filterToApply[0]+" "+filterToApply[1]+" "+filterToApply[2]);
				for (Map.Entry<String, Film> entry  : filmManager.getDb().entrySet()) {
					if (filterToApply[1].equals("prima di") || filterToApply[1].equals("minore di")) {
						if (entry.getValue().getValue(filterToApply[0]).compareTo(filterToApply[2]) < 0) {
							searchResults.add(entry.getKey());
						}
					}else if (filterToApply[1].equals("dopo il") || filterToApply[1].equals("maggiore di")) {
						if (entry.getValue().getValue(filterToApply[0]).compareTo(filterToApply[2]) > 0) {
							searchResults.add(entry.getKey());
						}
					}else if (filterToApply[1].equals("uguale a")) {
						if (entry.getValue().getValue(filterToApply[0]).compareTo(filterToApply[2]) == 0) {
							searchResults.add(entry.getKey());
						}
					}
					
				}	
			}else {
				//Non fare un cazzo!
			}
		}
	}
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}
