package database;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class Film {

	private GenericInformations genericInfos = new GenericInformations();
	private TechnicalData technicalData = new TechnicalData();
	private DateAndComments dateAndComments = new DateAndComments();
	
	public GenericInformations getGenericInfos() {
		return genericInfos;
	}
	public TechnicalData getTechnicalData() {
		return technicalData;
	}
	public DateAndComments getDateAndComments() {
		return dateAndComments;
	}
	public String getValue(String value) {
		if (value.equals("Anno")) {
			return String.valueOf(genericInfos.getYearOfRelease());
		}else if (value.equals("Rating")) {
			return String.valueOf(genericInfos.getRating());
		}else {
			return null;
		}
	}
	@Override
	public String toString() {
		SimpleDateFormat duration = new SimpleDateFormat("HH:mm:ss");
		String result = genericInfos.getTitle()+" "+
					genericInfos.getYearOfRelease()+" "+
					genericInfos.getRating()+" "+
					genericInfos.getGenres()+" "+
						duration.format(genericInfos.getDuration());
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Map<Date, String> reviewsMap = dateAndComments.getReviews();
		for (Map.Entry<Date, String> entry  : reviewsMap.entrySet()) {
			try {
				result = result+" "+data.format(entry.getKey())+" "+entry.getValue();
			} catch (Exception e) {
				//Non ci entrerà mai...
			}			
		}
		return result;
	}
}
