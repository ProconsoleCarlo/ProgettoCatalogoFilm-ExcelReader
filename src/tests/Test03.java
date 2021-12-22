package tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import database.Film;

/*
 * Un test per verificare il funzionameto della libreria.
 * Test per iniziare ad estrarre i valori delle celle in modo sistematico.
 * 
 * Possibili problemi NON gestiti: se cambio il numero di colonne nel catalogo, programma scrive i valori dove non deve
 * 
 */
public class Test03 {
/*
	public static void main(String[] args) throws Exception {
		InputStream inp = new FileInputStream("Catalogo film.xlsx");
        Workbook wb = new XSSFWorkbook(inp); // Declare XSSF WorkBook
        Sheet sheet = wb.getSheetAt(0);
        Row valueNamesRow = sheet.getRow(2);
        ArrayList<Film> entrateLette = new ArrayList<>();
        for (int i = 3; i < 8*//*sheet.getLastRowNum()*//*; i++) {
        	Row row = sheet.getRow(i);
        	Film entrata = new Film();
        	for (int j = 0; j < row.getLastCellNum(); j++) {
        		Cell cell = row.getCell(j);
        		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
        			entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getStringCellValue());
    			}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
    				if (DateUtil.isCellDateFormatted(cell)) {
    					entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getDateCellValue());	
                    }else if (valueNamesRow.getCell(j).getStringCellValue().startsWith("Data")) {
                    	@SuppressWarnings("deprecation")
						Date date = new Date(2012, 01, 01);
                		entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), date);
					}else {
						entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getNumericCellValue());
					}
    			}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
    				entrata.setValue(valueNamesRow.getCell(j).getStringCellValue(), cell.getNumericCellValue());
    			}				
			}
        	entrateLette.add(entrata);
		}
		for (int i = 0; i < entrateLette.size(); i++) {
			System.err.println(entrateLette.get(i));
		}
	}*/
}
