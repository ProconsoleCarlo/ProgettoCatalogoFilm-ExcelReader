package database;

import java.util.Date;
import java.util.Map;

public interface IFilm {

	public abstract void setValue(String valueName, Object value);

	public abstract GenericInformations getGenerics();

	public abstract Map<Date, String> getReviews();

	public abstract TechnicalData getTechnicalData();

}