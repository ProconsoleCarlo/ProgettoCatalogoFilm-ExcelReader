package program;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import database.Film;
import database.settings.DBSettings;

public class ExcelDBInterpreter implements IDBInterpreter{
	
	private DBSettings dbSettings = DBSettings.getSettings();
	
	@Override
	public Map<String, Film> loadDBData(String dbPath) {
		Map<String, Film> db = new HashMap<>();
		SimpleDateFormat durationFormatter = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			InputStream inp = new FileInputStream(dbPath);
			Workbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row valueNamesRow = (Row) sheet.getRow(2);
			//TODO togliere il limite
			for (int i = 3; i < sheet.getLastRowNum(); i++) {
				Film entrata = new Film();
				Row row = (Row) sheet.getRow(i);
				boolean setDate = false;
				for (int j = 0; j < row.getLastCellNum(); j++) {
					String valueName = valueNamesRow.getCell(j).getStringCellValue();
					Cell cell = row.getCell(j);
					if (valueName.equals("Titolo:")) entrata.getGenericInfos().setTitle(cell.getStringCellValue());
					if (valueName.equals("Anno:")) entrata.getGenericInfos().setYearOfRelease((int)cell.getNumericCellValue());
					if (valueName.equals("Rating:")) entrata.getGenericInfos().setRating((int)cell.getNumericCellValue());
					if (valueName.equals("Genere:")) entrata.getGenericInfos().setGenres(cell.getStringCellValue());
					if (valueName.equals("Durata:")) {
						if (cell.getDateCellValue() != null) {
							entrata.getGenericInfos().setDuration(cell.getDateCellValue());
						}else {
							entrata.getGenericInfos().setDuration(durationFormatter.parse("00:00:00"));
						}
					}
					if (valueName.equals("Risoluzione video:")) entrata.getTechnicalData().setVideoResolution(cell.getStringCellValue());
					if (valueName.equals("Fps:")) entrata.getTechnicalData().setFpsVideo(cell.getNumericCellValue());
					if (valueName.equals("Bitrate video (kbps):")) entrata.getTechnicalData().setBitrateVideo((int)cell.getNumericCellValue());
					if (valueName.equals("Codec video:")) entrata.getTechnicalData().setCodecVideo(cell.getStringCellValue());
					if (valueName.equals("Bitrate audio (kbps):")) entrata.getTechnicalData().setBitrateAudio((int)cell.getNumericCellValue());
					if (valueName.equals("Frequenza (kHz):")) entrata.getTechnicalData().setAudioFrequency(cell.getNumericCellValue());
					if (valueName.equals("Canali:")) entrata.getTechnicalData().setAudioChannels((int)cell.getNumericCellValue());
					if (valueName.equals("Codec audio:")) entrata.getTechnicalData().setCodecAudio(cell.getStringCellValue());
					if (valueName.equals("Dimensione (MB):")) entrata.getTechnicalData().setSize(cell.getNumericCellValue());
					if (valueName.equals("Contenitore:")) entrata.getTechnicalData().setContainer(cell.getStringCellValue());
					if (valueName.equals("Note tecniche:")) entrata.getTechnicalData().setTechnicalNotes(cell.getStringCellValue());
					if (valueName.startsWith("Data")) {
						if (cell.getDateCellValue() != null) {
							if (DateUtil.isCellDateFormatted(cell)) {
								entrata.getDateAndComments().setDate(cell.getDateCellValue());
							}else {
								entrata.getDateAndComments().setDate(dateFormatter.parse(dbSettings.getGeneric2012Data()));
							}
							setDate = true;
						}						
					}
					if (valueName.startsWith("Commento") && setDate) {
						entrata.getDateAndComments().setComment(cell.getStringCellValue());
						setDate=false;
					}
				}
				db.put(entrata.getGenericInfos().getTitle(), entrata);
			}
		} catch (IOException | ParseException e) {
			//Nel parse exception non ci andrà MAI per come lo ho fatto!
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}

	@Override
	public boolean saveDBData(String dbPath, Map<String, Film> db) {
		// TODO Ci vorrà parecchio tempo prima di arrivare qui credo...
		return false;
	}

}
