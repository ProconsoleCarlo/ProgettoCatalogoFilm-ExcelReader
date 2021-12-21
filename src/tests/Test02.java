package tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Un test per verificare il funzionameto della libreria.
 * Test per iniziare ad estrarre i valori delle celle in modo sistematico.
 */
public class Test02 {

	public static void main(String[] args) throws Exception {
		InputStream inp = new FileInputStream("Catalogo film.xlsx");
        Workbook wb = new XSSFWorkbook(inp); // Declare XSSF WorkBook
        Sheet sheet = wb.getSheetAt(0);
        Row rowTest = sheet.getRow(4);
        for (int i = 0; i < rowTest.getLastCellNum(); i++) {
			if (rowTest.getCell(i).getCellType() == Cell.CELL_TYPE_STRING) {
				System.err.println("Stringa "+rowTest.getCell(i));
			}else if (rowTest.getCell(i).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(rowTest.getCell(i))) {
                    if (i == 4 ) {
                    	//La durata
                    	SimpleDateFormat ora = new SimpleDateFormat("hh:mm:ss");
                    	String durata = ora.format(rowTest.getCell(i).getDateCellValue());
                    	System.err.println("Durata: "+durata);
					}else {
						//Le date
						SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
						String data2 = data.format(rowTest.getCell(i).getDateCellValue());
						System.err.println("Data "+data2);
					}
                } else {
                	if (rowTest.getCell(i).getNumericCellValue() == 2012) {
                		//Caso eccezionale, se so l'anno ma non la data completa
						System.err.println("2012");
					}else {
						//Numeri
						System.err.println("Numero "+rowTest.getCell(i).getNumericCellValue());
					}   
                }
			}else if (rowTest.getCell(i).getCellType() == Cell.CELL_TYPE_FORMULA) {
				//Formula e il risultato
				System.err.println("Formula "+rowTest.getCell(i).getCellFormula());
				System.err.println("Risultato = "+rowTest.getCell(i).getNumericCellValue());
			}
		}
	}
}
