package commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String readExcelData(String elementName) throws IOException {
		String elementPath = "";
		String path = System.getProperty("user.dir")+"/src/test/resources/testData/LoginObjects.xlsx";
		FileInputStream fin = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet loginSheet = workbook.getSheet("loginPage");
		
		int numRows = loginSheet.getLastRowNum();
		System.out.println("Last Row Number " +numRows);
		for(int i = 1; i <=numRows; i ++) {
			
			XSSFRow row = loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(elementName)) {
				elementPath = row.getCell(1).getStringCellValue();
				break;
			}
			
		}
		
		
		return elementPath;
		
	}
	
}
