package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {

        public static String getData(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new  FileInputStream("C:\\Users\\I COMPUTER\\eclipse-workspace\\Javaprogrm\\KiteZerodha\\src\\test\\resources\\TEST.xlsx");
		
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
        
		return value;
		

	}

}
