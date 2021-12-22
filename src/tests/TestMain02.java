package tests;

import javax.swing.JFrame;
import javax.swing.UIManager;

import program.ErrorsManager;
import program.FilmManager;
import ui.MainPanel;
import ui.languagePack.UILanguage;
import ui.searchEngine.SearchEngine;
import ui.searchEngine.SearchPanel;
import ui.viewFilmData.GenericInfoPanel;
import ui.viewFilmData.ReviewsPanel;
import ui.viewFilmData.TechnicalPanels.AudioPanel;
import ui.viewFilmData.TechnicalPanels.OthersDataPanel;
import ui.viewFilmData.TechnicalPanels.VideoPanel;

/**
 * DIARIO DI SVILUPPO:
 * DONE 			Passaggio al manager
 * DONE 			Inserita la bozza di interfaccia grafica
 * DONE 20/09/2014	Cambiate le recensioni in modo di avere una data associata un commento,
 * DONE 26/09/2014	Se aggiungo una nuova coppia di colonne Data e Commento per il nuovo anno in fondo alle colonne,
 * 					questa viene letta correttamente e subito aggiunta ai commenti senza dover fare modifiche
 * 					LanguagePack per poter cambiare facilmente la lingua
 * DONE 27/09/2014	TechnicalDataPanel, VideoPanel, AudioPanel, OthersDataPanel
 * 					Test di riempimento di tutti i campi con valori presi a caso dal database completato
 *					Passaggio ad un mainPanel con funzione di ricerca del film da visualizzare
 * 					Implementata la funzione di ricerca del film nel mainPanel
 * DONE 29/09/2014	Debug vari per la formattazione e gestione dei valori nulli
 * DONE 18/10/2014	Trovata la libreria sostitutiva: Apache POI
 * DONE 19/10/2014	Sistemazione del programma per la nuova libreria
 * 					Risolto il bug per cui il pannello di ricerca implodeva e quello dei dati esplodeva
 * 15/11/2014	Rifattorizzato interamente la lettura del database, con la creazione di un interprete decente:
 * 				ora i valori nulli delle date e delle durate non danno più problemi.
 * 				Interfaccia grafica messa orizzontale.
 * 				Ottimizzato il searchEngine
 * 16/11/2014	Implementata la advancedSearch, con la presenza di molti bug:
 * 				Bug1: i filtri non vengono applicati in cascata ma singolarmente (fa l'or invece dell'and)
 * 				Bug2: funziona solo per la ricerca su anno e rating
 * 				Bug3: la casella di ricerca nel searchPanel non funziona più, bisogna aggiornarla a funzionare con la nuova procedura
 * 				TODO1: il film deve essere esso stesso una hashMap
 * 				TODO2: fare la corrispondenza di valori per i criteri di filtro @see AdvancedSearchPanel
 * 
 * WORK IN PROGRESS:
 * Libreria:
 * TODO slegare il programma dalla libreria usata con un adapter
 * 
 * Gestiore degli errori:
 * @see ErrorsManager aggiungere i warning e stampare gli errori su un file di log e visualizzarli con una JOptionPane
 * @see FilmManager gestire bene gli errori che possono presentarsi con ErrorsManager
 * 
 * Ritocchi finali:
 * 
 * Implementare:
 * implementare correttamente observer observable per aggiornare a catena tutti i pannelli senza passare da metodi manuali come ora
 * @see SearchPanel implementare come Dio comanda che quando seleziono un film dalla lista dei risultati mi visualizza i dettagli sotto
 * 
 * Interfaccia grafica:
 * @see GenericInfoPanel dimensioni dinamiche contenuto componenti
 * @see ReviewsPanel dimensioni dinamiche contenuto componenti
 * @see AudioPanel dimensioni dinamiche contenuto componenti
 * @see VideoPanel dimensioni dinamiche contenuto componenti
 * @see OthersDataPanel dimensioni dinamiche contenuto componenti
 * 
 * Migliorie future:
 * @see ReviewsPanel trovare un modo decente di visualizzare le date di visione con accanto le recensioni
 * @see SearchEngine La ricerca funziona SOLO inserendo il titolo di un film dalla lettera iniziale (non anche dalle lettere parole che contiene)
 * 
 * BUG:
 * 
 */
public class TestMain02 {

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		FilmManager filmManager = new FilmManager("Catalogo film.xlsx");
		filmManager.loadDB();
		UILanguage uiLanguage = new UILanguage();
		MainPanel mainPanel = new MainPanel(uiLanguage.getLanguage(), filmManager);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());
		frame.setVisible(true);
	}
}
