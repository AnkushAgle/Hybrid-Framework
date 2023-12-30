package COM.TEST1;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.function.Function;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.BaseClass;

import com.utility.RetryAnalyzer;

public class ReadData {
	
	
	@Test
	
	public void data() throws Exception {
	String excelpath=System.getProperty("user.dir")+"\\ExcelFiles\\purchase\\POMaintenanceNew.xlsx";
		
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("testdata");
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
//		for(int r=0;r<=rows;r++) {
			
			XSSFRow row=sheet.getRow(0);
			
			for(int c=0;c<cols;c++) {
				
				XSSFCell cell=row.getCell(c);
				
				switch(cell.getCellType()) {
				case STRING:System.out.println(cell.getStringCellValue());break;
				case NUMERIC:System.out.println(cell.getStringCellValue()); break;
				
				
				}
				
			//}
		}
		
		
		
	}
}
