package tests;

import java.util.Map;

import program.ExcelDBInterpreter;
import database.Film;

public class TestExcelDBInterpreter {

	public static void main(String[] args) {
		ExcelDBInterpreter dbInterpreter = new ExcelDBInterpreter();

		Map<String, Film> db = dbInterpreter.loadDBData("Catalogo film.xlsx");
		for (Map.Entry<String, Film> entry  : db.entrySet()) {
			System.err.println(entry.getValue());
		}
	}
}
