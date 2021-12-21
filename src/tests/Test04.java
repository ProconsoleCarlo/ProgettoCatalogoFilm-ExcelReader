package tests;

import java.util.Map;

import program.FilmManager;
import database.IFilm;

/*
 * DIARIO DI SVILUPPO
 * Un test per verificare il funzionameto della libreria.
 * Test per iniziare ad estrarre i valori delle celle in modo sistematico.
 * Passaggio al manager
 * 
 * BUG
 * Possibili problemi NON gestiti: se cambio il numero di colonne nel catalogo, programma scrive i valori dove non deve
 * 
 */
public class Test04 {

	public static void main(String[] args) throws Exception {
		FilmManager filmManager = new FilmManager("Catalogo film.xlsx");
		filmManager.loadDB();
		Map<String, IFilm> db = filmManager.getDb();
		
		
		System.err.println("Leggo");
		for (Map.Entry<String, IFilm> entry  : db.entrySet()) {
/*			Map<Date, String> reviewsMap = entry.getValue().getReviews();
			int i = 0;
			System.err.println(entry.getKey());
			for (Map.Entry<Date, String> entry2  : reviewsMap.entrySet()) {
				System.err.println(i+" "+entry2.getKey()+" c "+entry2.getValue());
				i++;
			}*/
			System.err.println(entry.getValue());
		}
	}
	
	

}
