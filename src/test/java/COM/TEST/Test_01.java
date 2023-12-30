package COM.TEST;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobject.Materials;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Library;
import com.utility.Takescrnshot;

import net.bytebuddy.utility.RandomString;

public class Test_01 extends BaseClass {
	
@Test(enabled=false,groups="Functional")
public void m1() throws Exception {
	ExcelDataProvider excel=new ExcelDataProvider("NH");
	ConfigDataProvider config=new ConfigDataProvider("fouritemadd");
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
		
		for(int i=0;i>=3;i++) {	
			
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
	   Library.Comboclick(itemtype,excel.getStringdata("Sheet1", 17, i),"ItemType");
	   js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(2000);

	  WebElement uom=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[13]/div/ng-select/div/div/div[3]/input"));
	  
	  Library.Comboclick(uom, config.getconfigdata("UOM"),"UOM");
	  Thread.sleep(2000);
       Library.custom_click(ele.getSavebutton(), "Save Button");
	   // js.executeScript("arguments[0].click()",ele.getSavebutton());
		  

	    wait.until(ExpectedConditions.visibilityOf(ele.getADDNEWBTN()));
	    Thread.sleep(10000);
	    Takescrnshot.screenshot(config.getconfigdata("Itemcode")+rm);
	    
		}
		}

@Test ()
public void fouritem() throws Exception {
	ExcelDataProvider excel=new ExcelDataProvider("NH");
	 
	 ConfigDataProvider config=new ConfigDataProvider("fouritemadd");
	Date date4=new Date();
	String date1=date4.toString();
	System.out.println(date1);
	String date2=date1.replaceAll(":","_");
	String date=date2.replaceAll(" ","_");
	System.out.println(date);
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
		
		
		
		
		for(int i=1;i<=3;i++){
			ExcelDataProvider excel1=new ExcelDataProvider("NH");
			System.out.println(i);
			System.out.println(excel.getStringdata("Sheet1", 17, i));
		
		
			String rm=RandomString.make(1);
			Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
		ele.getItemcode().sendKeys(config.getconfigdata("Itemcode")+rm+date);
	Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
	Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
	 Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
	
	    Thread.sleep(5000);
	    
	   // WebElement mainclass = driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[5]/div/ng-select/div/div/div[3]/input"));
	   
	    Thread.sleep(7000);
	    js.executeScript("window.scrollBy(0,50)");
	    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
	    
	    Thread.sleep(7000);
	    
	   //WebElement subcass= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[6]/div/ng-select/div/div/div[3]/input"));
	    Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
	    Thread.sleep(5000);
	 //  WebElement MOC= driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[7]/div/ng-select/div/div/div[3]/input"));
	  
	   Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");

	   //WebElement itemtype=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[9]/div/ng-select/div/div/div[3]/input"));
	  Thread.sleep(5000);
	   Library.Comboclick(ele.getItemtype(),excel1.getStringdata("Sheet1", 17, i),"ItemType");
	   js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(2000);

	//  WebElement uom=driver.findElement(By.xpath("//*[@id=\"panel-1\"]/div/div/div[1]/div/div[13]/div/ng-select/div/div/div[3]/input"));
	//ng-select[@formcontrolname='itemUOM']
	 // WebElement uom=driver.findElement(By.xpath("//ng-select[@formcontrolname='itemUOM']"));
	  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
	  Thread.sleep(2000);
      Library.custom_click(ele.getSavebutton(), "Save Button");
	   // js.executeScript("arguments[0].click()",ele.getSavebutton());
		  
      Thread.sleep(10000);
	    wait.until(ExpectedConditions.visibilityOf(ele.getADDNEWBTN()));
	    Thread.sleep(5000);
	    Takescrnshot.screenshot(config.getconfigdata("Itemcode")+rm);
	    
		}
}
}



