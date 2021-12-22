package program;

import java.util.Map;

import database.Film;

public interface IDBInterpreter {

	public abstract Map<String, Film> loadDBData(String dbPath);
	
	public abstract boolean saveDBData(String dbPath, Map<String, Film> db);
}
