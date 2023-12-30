package UTILITY;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utility.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod
	public void BM() {
		String excelpath = System.getProperty("user.dir") +"\\ExcelFiles\\LOGIN.xlsx";
		ExcelReader Ecel = new ExcelReader(excelpath);
//		String Browser = Ecel.getCellData("LOGIN", "value", 6);
	String URL = Ecel.getCellData("LOGIN", "value", 7);

	String Browser=	 Ecel.getCellData("LOGIN", "value", 7);

		//String browser="chrome";
		
		if (Browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}
		
		

		else if (Browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
		System.out.println("Test case Exceution Started");	
	}
	

	@AfterMethod
	
	public void AM() {
		
		System.out.println("Test Case Complited");
		driver.close();
	}

}
