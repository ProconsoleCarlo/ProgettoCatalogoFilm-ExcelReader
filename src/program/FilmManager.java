package program;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import database.Film;
import database.IFilm;
import database.settings.Settings;

public class FilmManager extends Observable{

	private Workbook wb;
	private Map<String, IFilm> db = new HashMap<>();
	private IFilm selectedFilm;

	public FilmManager(String dbFileName) {
		super();
		initializeDB(dbFileName);
	}
	public Map<String, IFilm> getDb() {
		return db;
	}
	public void setSelectedFilm(IFilm selectedFilm) {
		this.selectedFilm = selectedFilm;
	}
	public IFilm getSelectedFilm() {
		return selectedFilm;
	}

	/**
	 * Metodo per caricare il database dei film in una mappa così fatta:
	 * Map<Title, entrata>
	 */
	public void loadDB() {
		//TODO alcune righe danno rogne per i valori nulli -> da rivedere
		try {
			Sheet sheet = wb.getSheetAt(0);
			Row valueNamesRow = (Row) sheet.getRow(2);;
			//TODO togliere il limite
			for (int i = 3; i < 350/*sheet.getLastRowNum()*/; i++) {
				IFilm entrata = new Film();
				Row row = (Row) sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
	        		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	        			entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getStringCellValue());
	    			}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	    				if (DateUtil.isCellDateFormatted(cell)) {
	    					entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getDateCellValue());	
	                    }else if (valueNamesRow.getCell(j).getStringCellValue().startsWith("Data")) {
	                		entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), new Date((int)cell.getNumericCellValue()-1900, 00, 01));
						}else {
							entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getNumericCellValue());
						}
	    			}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
	    				entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getNumericCellValue());
	    			}			
				}
				db.put(entrata.getGenerics().getTitle(), entrata);
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Catch "+e.getMessage());
		}
	}
	
	private void initializeDB(String dbFileName) {
		try {
			InputStream inp = new FileInputStream(dbFileName);
	        wb = new XSSFWorkbook(inp); // Declare XSSF WorkBook
	        Sheet sheet = wb.getSheetAt(0);
			//for (int i = 0; i < sheet.getLastRowNum(); i++) {
				ArrayList<String> cellDescriptions = new ArrayList<>();
				Row row = (Row) sheet.getRow(2);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					cellDescriptions.add(row.getCell(j).getStringCellValue());
				}
				Settings.getSettings().setCellDescriptions(cellDescriptions);
				inp.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update() {
		setChanged();
		notifyObservers();
	}
}
