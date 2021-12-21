package database.settings;

import java.util.ArrayList;

public class Settings {

	//Singleton
	private static Settings settings = new Settings();
	private Settings() {
		super();
	}
	public static Settings getSettings() {
		return settings;
	}
	
	//Class
	//TODO Come in future!
	//private int nColumnSupported = 20;
	private ArrayList<String> cellDescriptions;
	public void setCellDescriptions(ArrayList<String> cellDescriptions) {
		this.cellDescriptions = cellDescriptions;
	}
	public ArrayList<String> getCellDescriptions() {
		return cellDescriptions;
	}
}
