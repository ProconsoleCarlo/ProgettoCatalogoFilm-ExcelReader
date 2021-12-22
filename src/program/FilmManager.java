package program;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import database.Film;

public class FilmManager extends Observable{

	private Map<String, Film> db = new HashMap<>();
	private Film selectedFilm;
	private String dbFileName;

	public FilmManager(String dbFileName) {
		super();
		this.dbFileName = dbFileName;
	}
	public Map<String, Film> getDb() {
		return db;
	}
	public void setSelectedFilm(Film selectedFilm) {
		this.selectedFilm = selectedFilm;
	}
	public Film getSelectedFilm() {
		return selectedFilm;
	}

	/**
	 * Metodo per caricare il database dei film in una mappa così fatta:
	 * Map<Title, entrata>
	 */
	public void loadDB() {
		ExcelDBInterpreter dbInterpreter = new ExcelDBInterpreter();
		db = dbInterpreter.loadDBData(dbFileName);
	}
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}
