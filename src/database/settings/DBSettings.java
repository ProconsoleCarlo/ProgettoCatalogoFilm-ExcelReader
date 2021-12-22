package database.settings;


public class DBSettings {

	//Singleton
	private static DBSettings settings = new DBSettings();
	private DBSettings() {
		super();
	}
	public static DBSettings getSettings() {
		return settings;
	}
	
	//Class
	//TODO Come in future!
	//private int nColumnSupported = 20;
	private String generic2012Data = "01/01/2012";
	public String getGeneric2012Data() {
		return generic2012Data;
	}
}
