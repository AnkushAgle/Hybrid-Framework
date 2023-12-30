package roughwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ExcelReader;
import com.utility.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LOGIN {
	
	public static void main(String[] args) {
	//	String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\" + "\\" + Filename + ".xlsx";
		
		//String excelpath="C:\\Users\\HP\\Downloads\\NEW_HORIZON\\ExcelFiles\\LOGIN.xlsx";
		
		
		String excelpath=System.getProperty("user.dir")+"\\ExcelFiles\\LOGIN.xlsx";
		ExcelReader Ecel = new ExcelReader(excelpath);
		
		String USENAME= Ecel.getCellData("LOGIN", "Username", 1);
		System.out.println(USENAME);
	String Password= Ecel.getCellData("LOGIN", "value", 1);
		
		System.out.println(Password);
	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		WebElement username=driver.findElement(By.xpath(""));
	
		username.sendKeys(USENAME);
		
	
	}

}
