package ui.searchEngine;

import java.util.ArrayList;
import java.util.Map;

import database.IFilm;
import program.FilmManager;

public class SearchEngine {

	private FilmManager filmManager;
	
	private ArrayList<String> searchResults = new ArrayList<>();
		
	public SearchEngine(FilmManager filmManager) {
		super();
		this.filmManager = filmManager;
	}


	public ArrayList<String> searchValue(String stringToSearch) {
		searchResults.clear();
		System.err.println("Searching: "+stringToSearch);
		for (Map.Entry<String, IFilm> entry  : filmManager.getDb().entrySet()) {
			if (entry.getKey().toLowerCase().startsWith(stringToSearch.toLowerCase())) {
				//System.err.println(entry.getKey());
				searchResults.add(entry.getKey());
			}
		}
		return searchResults;
	}
}
