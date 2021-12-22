package database;

import java.util.Date;

public class GenericInformations {

	private String title;
	private int yearOfRelease;
	private int rating;
	private String genres;
	private Date duration;
	
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
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
	}
}
