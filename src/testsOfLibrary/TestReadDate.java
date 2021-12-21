package testsOfLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Un test per verificare il funzionamento della libreria
 */
public class TestReadDate {
/*
	public static void main(String[] args) throws Exception {
		WorkBook workBook = new WorkBook();
		workBook.readXLSX("Catalogo film.xlsx");
		System.err.println(workBook.getFormattedText(3, 4));
		SimpleDateFormat ora = new SimpleDateFormat("hh.mm.ss a");
//		System.err.println(ora.format("20:17:34"));
		System.err.println(ora.parse(workBook.getFormattedText(3, 4)*//*.replaceAll("\\.", ":")*//*));
		Date date = ora.parse(workBook.getFormattedText(3, 4));
		System.err.println(date);
		System.err.println(ora.format(ora.parse(workBook.getFormattedText(3, 4)*//*.replaceAll("\\.", ":")*//*)));
	}*/
}
