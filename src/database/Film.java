package database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import database.settings.Settings;


public class Film implements IFilm {

	private ArrayList<String> cellDescriptions = Settings.getSettings().getCellDescriptions();
	
	private GenericInformations generics = new GenericInformations();
	private TechnicalData technicalData = new TechnicalData();
	private DataDiVisioneECommento reviews = new DataDiVisioneECommento();

	@Override
	public void setValue(String valueName, Object value) {
		//System.err.println(valueName+" is "+value);
		if (valueName.equals("Titolo:")) generics.setTitle(String.valueOf(value));
		if (valueName.equals("Anno:")) generics.setYearOfRelease((int)(double)value);
		if (valueName.equals("Rating:")) generics.setRating((int)(double)value);
		if (valueName.equals("Genere:")) generics.setGenres((String)value);
		if (valueName.equals("Durata:")) generics.setDuration((Date)value);
		if (valueName.equals("Risoluzione video:")) technicalData.setVideoResolution((String)value);
		if (valueName.equals("Fps:")) technicalData.setFpsVideo(String.valueOf(value));
		if (valueName.equals("Bitrate video (kbps):")) technicalData.setBitrateVideo((int)(double)value);
		if (valueName.equals("Codec video:")) technicalData.setCodecVideo((String)value);
		if (valueName.equals("Bitrate audio (kbps):")) technicalData.setBitrateAudio((int)(double)value);
		if (valueName.equals("Frequenza (kHz):")) technicalData.setAudioFrequency((double)value);
		if (valueName.equals("Canali:")) technicalData.setAudioChannels((int)(double)value);
		if (valueName.equals("Codec audio:")) technicalData.setCodecAudio((String)value);
		if (valueName.equals("Dimensione (MB):")) technicalData.setSize((double)value);
		if (valueName.equals("Contenitore:")) technicalData.setContainer((String)value);
		if (valueName.equals("Note tecniche:")) technicalData.setTechnicalNotes((String)value);
		if (valueName.startsWith("Data")) reviews.setDate((Date)value);
		if (valueName.startsWith("Commento")) reviews.setComment((String)value);
		
		/*if (valueName.equals("Data 2012:")) reviews.setDate((Date)value);
		if (valueName.equals("Commento 2012:")) reviews.setComment((String)value);
		if (valueName.equals("Data 2013:")) reviews.setDate((Date)value);
		if (valueName.equals("Commento 2013:")) reviews.setComment((String)value);
		if (valueName.equals("Data 2014:")) reviews.setDate((Date)value);
		if (valueName.equals("Commento 2014:")) reviews.setComment((String)value);*/
	}
	
	@Override
	public GenericInformations getGenerics() {
		return generics;
	}
	@Override
	public Map<Date, String> getReviews() {
		return reviews.getReviews();
	}
	@Override
	public TechnicalData getTechnicalData() {
		return technicalData;
	}

	@Override
	public String toString() {
		SimpleDateFormat duration = new SimpleDateFormat("hh:mm:ss");
		String result = generics.getTitle()+" "+
						generics.getYearOfRelease()+" "+
						generics.getRating()+" "+
						generics.getGenres()+" "+
						duration.format(generics.getDuration());
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Map<Date, String> reviewsMap = getReviews();
		for (Map.Entry<Date, String> entry  : reviewsMap.entrySet()) {
			System.err.println(entry.getKey());
			try {
				result = result+" "+data.format(entry.getKey())+" "+entry.getValue();
			} catch (Exception e) {
				SimpleDateFormat data2 = new SimpleDateFormat("yyyy");
				result = result+" "+data2.format(entry.getKey())+" "+entry.getValue();
			}			
		}
		return result;
	}
}
