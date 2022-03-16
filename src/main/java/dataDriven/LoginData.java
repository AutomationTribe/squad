package dataDriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData {
	
	XSSFWorkbook workBook;
	
	XSSFSheet sheet;
	
	public LoginData(String fileLocation ) {
		
		try {
		
		File file =  new File(fileLocation);
		
		FileInputStream fis = new FileInputStream(file);
		
		 workBook = new XSSFWorkbook(fis);
				
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
	public String getData(int sheetNum, int row,int column) {
		
		Sheet sheet = workBook.getSheetAt(sheetNum);
		
		String data = sheet.getRow(row).getCell(column).getStringCellValue();	
		
		return data;
	}
	
	public int getRowCount(int sheetIndex) {
		
		int row = workBook.getSheetAt(sheetIndex).getLastRowNum();
		
		//row = row;
		
		return row;	
	}
	
}
