package COM.TEST1;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.ExcelDataProvider;
 
/**
 * @author Admin
 *
 */
public class ReadWriteExcel
{
    WebDriver driver;
    WebDriverWait wait;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
 
 @BeforeTest(enabled=false)
 public void TestSetup()
{
    // Set the path of the Firefox driver.
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
    driver = new FirefoxDriver();
     
    // Enter url.
    driver.get("http://www.linkedin.com/");
    driver.manage().window().maximize();
     
    wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
  
 @Test(enabled=false)
 public void ReadData() throws IOException
 {
     // Import excel sheet.
     File src=new File("D:\\Users\\Ankush\\eclipse-workspace\\NEW_HORIZON\\ExcelFiles\\ITEMMST.xlsx");
      
     // Load the file.
     FileInputStream finput = new FileInputStream(src);
      
     // Load he workbook.
    workbook = new XSSFWorkbook(finput);
      
     // Load the sheet in which data is stored.
     sheet= workbook.getSheetAt(0);
      
     for(int i=1; i<=sheet.getLastRowNum(); i++)
     {
    	 
         // Import data for Email.
         cell = sheet.getRow(i).getCell(1);
         //cell.setCellType(Cell.CELL_TYPE_STRING);
        // driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
          System.out.println(cell.getStringCellValue());
         // Import data for password.
         cell = sheet.getRow(i).getCell(2);
        // cell.setCellType(Cell.CELL_TYPE_STRING);
       //  driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
         System.out.println(cell.getStringCellValue());       
    	 
    	 
    	 }
  } 
 
 @Test
 
 public void m1() throws Exception {
	 
	 
	 ExcelDataProvider excel=new ExcelDataProvider("itemmaster");
	 
	 
	 for (int i = 1; i < 9; i++) {excel.getStringdata("Sheet1", i, 11);
	 
	 System.out.println(excel.getStringdata("Sheet1", i, 11));
	 
	 
	 }
	 
	 
	 
	 
	 
	 
	 for (int i = 1; i < 9; i++) {
		  System.out.println(i);
		
		 
		 
		 excel.getStringdata("Sheet1", i, 5);//For Item Code
		System.out.println(excel.getStringdata("Sheet1", i, 5));
		 excel.getStringdata("Sheet1", i, 6);//itemdesciption
			System.out.println(excel.getStringdata("Sheet1", i, 6));
		 excel.getStringdata("Sheet1", i, 7);//ItemDetailDesc
			System.out.println(excel.getStringdata("Sheet1",i, 7));
		 excel.getStringdata("Sheet1", i, 8);//itemdetaildescription
			System.out.println(excel.getStringdata("Sheet1",i, 8));
		 excel.getStringdata("Sheet1", i, 9);//selectclass
			System.out.println(excel.getStringdata("Sheet1", i, 9));
		 excel.getStringdata("Sheet1", i, 10);//selectsubclass
			System.out.println(excel.getStringdata("Sheet1", i, 10));
		 excel.getStringdata("Sheet1", i, 11);//MOC
			System.out.println(excel.getStringdata("Sheet1", i, 11));
		 excel.getStringdata("Sheet1", i, 12);//ItemType
			System.out.println(excel.getStringdata("Sheet1",i, 12));
		 excel.getStringdata("Sheet1", i, 13);//UOM
			System.out.println(excel.getStringdata("Sheet1", i, 13));
	 
		 
	 }
	
 
 }
 
 
}