package database;

import java.text.SimpleDateFormat;
import java.util.Date;

import program.ErrorsManager;

public class GenericInformations {

	private ErrorsManager errorManager = ErrorsManager.getErrorsManager();
	
	private String title;
	private int yearOfRelease;
	private int rating;
	private String genres;
	private Date duration;
	
	/*
	 * Per convertire il valore float della durata in hh:mm:ss bisogna fare cosi:
	 * il valore*24 e la parte prima della virgola sono le ore
	 * la parte decimale*60 e ottengo nella parte prima della virgola i minuti
	 * la parte decimale*60 e ottengo i secondi
	 * 
	 * Quando va riscritto l'excel, bisogna riconvertire il double... ossia sostituire al . la: RISOLTO LEGGENDO IL TESTO FORMATTATO
	 */
	
	protected GenericInformations() {
		super();
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
		/*try {
			if (yearOfRelease.equals("")) {
				this.yearOfRelease = 0;
			}else {
				this.yearOfRelease = Integer.valueOf(yearOfRelease);
			}
		} catch (Exception e) {
			catchErrors("yearOfRelease "+yearOfRelease+" di "+title);
		}*/
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
		/*try {
			if (rating.equals("")) {
				this.rating = 0;
			}else {
				this.rating = Integer.valueOf(rating);
			}
		} catch (Exception e) {
			catchErrors("rating "+rating+" di "+title);
		}*/
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
		/*SimpleDateFormat durationFormat = new SimpleDateFormat("HH.mm.ss a");
		try {
			if (duration.equals("")) {
				SimpleDateFormat durationFormat2 = new SimpleDateFormat("HH:mm:ss");
				this.duration = durationFormat2.parse("00:00:00");
			}else {
				this.duration = durationFormat.parse(duration);
			}
		} catch (Exception e) {
			catchErrors("durata "+duration+" di "+title);
		}*/
	}
	
	private void catchErrors(String causedBy) {
		errorManager.addErrorMessage("Errore di conversione del valore "+causedBy);
	}
}
