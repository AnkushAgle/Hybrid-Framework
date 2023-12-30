package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@Parameters("Browser")
	@BeforeTest
	
	public void BM(String Browser) throws Exception {
			ConfigDataProvider config=new ConfigDataProvider();
		
	 	
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();	
		
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			
	 		WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			
		}
		
		else if(Browser.equalsIgnoreCase("Hchrome")) {
		
			WebDriverManager.chromedriver().setup();
		   ChromeOptions options = new ChromeOptions();
		    options.addArguments("headless");
		    
			 driver=new ChromeDriver(options);
			}
		driver.get(config.getURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("URL=="+config.getURL());
		
		
	}
	
	
	@BeforeMethod
	public void beforemethod(){
		
		System.out.println(" test case  Started");
		
	}
	
	
	@AfterMethod
	public void Aftermethod() throws Exception{
		
		Thread.sleep(4000);
		//driver.navigate().refresh();
		
		Thread.sleep(4000);
		System.out.println(" test case  complited");
		
	}
	
	
	
	
	
	
	
@AfterTest
public void AM() throws Exception {
	Thread.sleep(3000);
    // driver.close();
	
	
}

}
