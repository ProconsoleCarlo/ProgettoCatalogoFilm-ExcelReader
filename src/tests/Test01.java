package tests;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Un test per verificare il funzionamento della libreria
 */
public class Test01 {

	public static void main(String[] args) throws Exception {
		InputStream inp = new FileInputStream("Catalogo film.xlsx");
        Workbook wb = new XSSFWorkbook(inp); // Declare XSSF WorkBook
        Sheet sheet = wb.getSheetAt(0);
        System.err.println(sheet.getLastRowNum());
        Row row = (Row) sheet.getRow(2);
        System.err.println(row.getLastCellNum());
        for (int i = 0; i < row.getLastCellNum(); i++) {
        	System.err.println(row.getCell(i).toString());
		}
        inp.close();
	}
}
