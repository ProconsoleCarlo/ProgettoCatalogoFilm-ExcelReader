package database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataDiVisioneECommento {

	private Date date;
	private Map<Date, String> reviews = new HashMap<>();
	
	protected DataDiVisioneECommento() {
		super();
	}
	public void setDate(Date date) {
		this.date = date;
		reviews.put(date, "");
	}
	public void setComment(String comment) {
		reviews.put(date, comment);
	}
	public Map<Date, String> getReviews() {
		return reviews;
	}
}
