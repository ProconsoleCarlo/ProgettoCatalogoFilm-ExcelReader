package tests;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.UIManager;

import program.ErrorsManager;
import program.FilmManager;
import ui.languagePack.UILanguage;
import ui.viewFilmData.GenericInfoPanel;
import ui.viewFilmData.ReviewsPanel;
import ui.viewFilmData.ViewPanel;
import ui.viewFilmData.TechnicalPanels.AudioPanel;
import ui.viewFilmData.TechnicalPanels.OthersDataPanel;
import ui.viewFilmData.TechnicalPanels.VideoPanel;
import database.DateAndComments;
import database.Film;
import database.TechnicalData;

/**
 * DIARIO DI SVILUPPO:
 * DONE Passaggio al manager
 * DONE Inserita la bozza di interfaccia grafica
 * DONE 20/09/2014 Cambiate le recensioni in modo di avere una data associata un commento,
 * DONE 26/09/2014 Se aggiungo una nuova coppia di colonne Data e Commento per il nuovo anno in fondo alle colonne,
 * 					questa viene letta correttamente e subito aggiunta ai commenti senza dover fare modifiche
 * DONE 26/09/2014 LanguagePack per poter cambiare facilmente la lingua
 * DONE 27/09/2014 TechnicalDataPanel, VideoPanel, AudioPanel, OthersDataPanel
 * DONE 27/09/2014 Test di riempimento di tutti i campi con valori presi a caso dal database completato
 * 
 * WORK IN PROGRESS:
 * 
 * TODO:
 * Gestiore degli errori:
 * @see TechnicalData il metodo catchErrors
 * @see ErrorsManager aggiungere i warning e stampare gli errori su un file di log e visualizzarli con una JOptionPane
 * @see FilmManager gestire bene gli errori che possono presentarsi con ErrorsManager
 * 
 * Ritocchi finali:
 * @see FilmManager rimuovere il limite delle righe in loadDB()
 * 
 * Implementare:
 * @see ViewPanel implementare metodo update
 * @see FilmManager implementare metodo update
 * 
 * Interfaccia grafica:
 * @see GenericInfoPanel visualizzare la lista di generi del film
 * @see GenericInfoPanel dimensioni dinamiche contenuto componenti
 * @see ReviewsPanel dimensioni dinamiche contenuto componenti
 * @see AudioPanel dimensioni dinamiche contenuto componenti
 * @see VideoPanel dimensioni dinamiche contenuto componenti
 * @see OthersDataPanel dimensioni dinamiche contenuto componenti
 * @see OthersDataPanel visualizzare correttamente le note tecniche
 * @see ReviewsPanel trovare un modo decente di visualizzare le date di visione con accanto le recensioni
 * 
 * Migliorie future:
 * @see DateAndComments il metodo setComment
 * 
 * BUG:
 * Se aggiungo colonne all'interno del catalogo, il programma scrive i valori dove non vanno
 * 
 * 
 */
public class TestMain01 {

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		FilmManager filmManager = new FilmManager("Catalogo film.xlsx");
		filmManager.loadDB();
		Map<String, Film> db = filmManager.getDb();
		for (Map.Entry<String, Film> entry  : db.entrySet()) {
			System.err.println(entry.getValue());
		}
		UILanguage uiLanguage = new UILanguage();
		ViewPanel viewPanel = new ViewPanel(uiLanguage.getLanguage(), filmManager);
		JFrame frame = new JFrame();
		//TODO Sarà da spostare nel mainPanel così il pack funzionerà perfettamente!
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(viewPanel);
		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());
		frame.setVisible(true);
	}
	
	

}
