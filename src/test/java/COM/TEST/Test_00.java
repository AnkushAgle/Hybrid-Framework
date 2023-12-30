package COM.TEST;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pageobject.Materials;
import com.pageobject.loginpom;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Library;
import com.utility.RetryAnalyzer;
import com.utility.Takescrnshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import net.bytebuddy.utility.RandomString;

public class Test_00 extends BaseClass {
	
	@Test(enabled=false,groups="Functional")
	public void m1() throws Exception {
		ConfigDataProvider config=new ConfigDataProvider();
		ExcelDataProvider excel=new ExcelDataProvider("NH");
                   Library.login();
String rm=RandomString.make(2);
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

	JavascriptExecutor js = (JavascriptExecutor)driver;
		Materials ele=PageFactory.initElements(driver,Materials.class);
		wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
		js.executeScript("arguments[0].click()", ele.getMaterialsModule());
		wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
		js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
		js.executeScript("arguments[0].click()", ele.getADDNEWBTN());
		ele.getItemcode().sendKeys(config.getconfigdata("Itemcode")+rm);
		
	    ele.getItemDescription().sendKeys(config.getconfigdata("ItemDesc"));
	    ele.getItemDetailDescription().sendKeys(config.getconfigdata("ItemDetailDesc"));
	    ele.getItemaddDetailDesc().sendKeys(config.getconfigdata("ItemaddDetailDesc"));
	    Thread.sleep(9000);
	    
	   
	    WebElement mainclass = driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[5]/div/ng-select/div/div/div[3]/input"));
	   
	    Thread.sleep(9000);
	    Library.Comboclick(mainclass,config.getconfigdata("selectclass"),"Select main  Class");
	    
	    Thread.sleep(5000);
	    
	   WebElement subcass= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[6]/div/ng-select/div/div/div[3]/input"));
	    Library.Comboclick(subcass,config.getconfigdata("selectsubclass"),"Select subclass");
	    Thread.sleep(5000);
	   WebElement MOC= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[7]/div/ng-select/div/div/div[3]/input"));
	  
	   Library.Comboclick(MOC,config.getconfigdata("MOC"),"material of construction");

	   WebElement itemtype=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[9]/div/ng-select/div/div/div[3]/input"));
	  Thread.sleep(5000);
	   Library.Comboclick(itemtype,config.getconfigdata("Itemtype"),"Item Type");
	   js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(2000);

	  WebElement uom=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[13]/div/ng-select/div/div/div[3]/input"));
	  
	  Library.Comboclick(uom, config.getconfigdata("UOM"),"Unit of measurement");
 
     Thread.sleep(2000);

    js.executeScript("arguments[0].click()",ele.getSavebutton());
	  

    wait.until(ExpectedConditions.visibilityOf(ele.getADDNEWBTN()));
    Thread.sleep(9000);
    Takescrnshot.screenshot(config.getconfigdata("Itemcode")+rm);
	
	}

	
	
	
	
	
	
	
@Test(enabled=false,groups="Functional")

public void material() throws Exception {
	ExcelDataProvider excel=new ExcelDataProvider("NH");
	 ConfigDataProvider config=new ConfigDataProvider();
	Library.login();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

	JavascriptExecutor js = (JavascriptExecutor)driver;
		Materials ele=PageFactory.initElements(driver,Materials.class);
		wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
		js.executeScript("arguments[0].click()", ele.getMaterialsModule());
		wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
		js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
		//js.executeScript("arguments[0].click()", ele.getADDNEWBTN());
		
		
			
			String rm=RandomString.make(10);
			js.executeScript("arguments[0].click()", ele.getADDNEWBTN());
		ele.getItemcode().sendKeys(config.getconfigdata("Itemcode")+rm);
		
	    ele.getItemDescription().sendKeys(config.getconfigdata("ItemDesc"));
	    ele.getItemDetailDescription().sendKeys(config.getconfigdata("ItemDetailDesc"));
	    ele.getItemaddDetailDesc().sendKeys(config.getconfigdata("ItemaddDetailDesc"));
	    Thread.sleep(9000);
	    
	    WebElement mainclass = driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[5]/div/ng-select/div/div/div[3]/input"));
	   
	    Thread.sleep(9000);
	    Library.Comboclick(mainclass,config.getconfigdata("selectclass"),"Select Class");
	    
	    Thread.sleep(5000);
	    
	   WebElement subcass= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[6]/div/ng-select/div/div/div[3]/input"));
	    Library.Comboclick(subcass,config.getconfigdata("selectsubclass"),"Subclass");
	    Thread.sleep(5000);
	   WebElement MOC= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[7]/div/ng-select/div/div/div[3]/input"));
	  
	   Library.Comboclick(MOC,config.getconfigdata("MOC"),"MOC");
            //Reporter.log(rm);
	   WebElement itemtype=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[9]/div/ng-select/div/div/div[3]/input"));
	  Thread.sleep(5000);
	   Library.Comboclick(itemtype,config.getconfigdata("Itemtype"),"Item Type");
	   js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(2000);

	  WebElement uom=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[13]/div/ng-select/div/div/div[3]/input"));
	  
	  Library.Comboclick(uom, config.getconfigdata("UOM"),"UOM");
	  Thread.sleep(2000);

	  
	    js.executeScript("arguments[0].click()",ele.getSavebutton());
		  

	    wait.until(ExpectedConditions.visibilityOf(ele.getADDNEWBTN()));
	    Thread.sleep(12000);
	    Takescrnshot.screenshot(config.getconfigdata("Itemcode")+rm);
		}


@Test(priority=1) 

public void additm() throws Exception {
	ExcelDataProvider excel=new ExcelDataProvider("NH");
	
	
	ConfigDataProvider config=new ConfigDataProvider();
	// Test Script to Adding 4 item of Different type of materials
	Library.login();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

	JavascriptExecutor js = (JavascriptExecutor)driver;
		Materials ele=PageFactory.initElements(driver,Materials.class);
		wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
		//js.executeScript("arguments[0].click()", ele.getMaterialsModule());
		Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
		wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
		//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
		Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
		
			
			
			String rm=RandomString.make(3);
			Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
		ele.getItemcode().sendKeys(config.getconfigdata("Itemcode")+rm);
	Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
	Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
	 Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
	
	    Thread.sleep(5000);
	    
	    WebElement mainclass = driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[5]/div/ng-select/div/div/div[3]/input"));
	   
	    Thread.sleep(5000);
	    Library.Comboclick(mainclass,config.getconfigdata("selectclass"),"Class");
	    
	    Thread.sleep(5000);
	    
	   WebElement subcass= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[6]/div/ng-select/div/div/div[3]/input"));
	    Library.Comboclick(subcass,config.getconfigdata("selectsubclass"),"Subclass");
	    Thread.sleep(5000);
	   WebElement MOC= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[7]/div/ng-select/div/div/div[3]/input"));
	  
	   Library.Comboclick(MOC,config.getconfigdata("MOC"),"MOC");

	   WebElement itemtype=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[9]/div/ng-select/div/div/div[3]/input"));
	  Thread.sleep(5000);
	   Library.Comboclick(itemtype,excel.getStringdata("Sheet1", 17, 2),"ItemType");
	   js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(2000);
	  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
	  Thread.sleep(2000);
	  Thread.sleep(2000);
       Library.custom_click(ele.getSavebutton(), "Save Button");
	   // js.executeScript("arguments[0].click()",ele.getSavebutton());
		  

	    wait.until(ExpectedConditions.visibilityOf(ele.getADDNEWBTN()));
	    Thread.sleep(10000);
	    Takescrnshot.screenshot(config.getconfigdata("Itemcode")+rm);
	    
}
}

