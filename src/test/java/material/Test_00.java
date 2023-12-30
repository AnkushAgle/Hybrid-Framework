package material;

import java.time.Duration;
import java.util.Random;

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

import com.crmpom.LeadEntry;
import com.material.ItemMasterBasicDetailEntry;
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
	
@Test(enabled=false,priority=1) 

public void additem() throws Exception {
	 Random random = new Random();
	 int number = random.nextInt(100);
        System.out.println(number);
        String str1 = Integer.toString(number);
        System.out.println(str1 );
        String testcasename="1)Adding simple item into the item master";
 		Library.login("material","additem", testcasename);
		Thread.sleep(2000);
		Library.filelocationConfigreport("material","additem");
        ConfigDataProvider config=new ConfigDataProvider("material","additem");
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		ItemMasterBasicDetailEntry ele=PageFactory.initElements(driver,ItemMasterBasicDetailEntry.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
	//1)Click On Material Module
			Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
			Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
		//2)click on Add new Button
			
				Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
				
				Library.custom_Sendkeys(ele.getItemcode(), config.getconfigdata("Itemcode")+str1, "Item Code Field");
		
		Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
		Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
		 Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
		
		    Thread.sleep(5000);

		    Thread.sleep(7000);
		    js.executeScript("window.scrollBy(0,50)");
		    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
		    
		    Thread.sleep(7000);
		   Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
		    Thread.sleep(5000);
	       Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");
		  Thread.sleep(5000);
		  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
		  Thread.sleep(2000);
		  Library.Scrolldown(0,-200);
	       Library.custom_click(ele.getSavebutton(), "Save Button");
	     
	       try {
	    	   
	    WebElement classmsg=driver.findElement(By.xpath("//div[text()=' Item Class is required. ']"));
	    Library.Ertrormassage(classmsg);
	       }
		  catch(Exception e) {
			  
			  
		  }
	      
	       
	       String msg=config.getconfigdata("Itemcode")+str1+"=="+"Item Master already exists.Enter Different item code ";
		   
		   Library.validation(ele.getITEMINFO(), msg,"Item code");
	

}

@Test

public void Itemaddeditview() throws Exception {
	 Random random = new Random();
	 int number = random.nextInt(100);
        System.out.println(number);
        String str1 = Integer.toString(number);
        System.out.println(str1 );
        String testcasename="Item master ADD Entry";
 		Library.login("material","Itemaddeditview", testcasename);
		Thread.sleep(2000);
		Library.filelocationConfigreport("material","Itemaddeditview");
        ConfigDataProvider config=new ConfigDataProvider("material","Itemaddeditview");
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		ItemMasterBasicDetailEntry ele=PageFactory.initElements(driver,ItemMasterBasicDetailEntry.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
	//1)Click On Material Module
			Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
			Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
		//2)click on Add new Button
			
				Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
				
				Library.custom_Sendkeys(ele.getItemcode(), config.getconfigdata("Itemcode")+str1, "Item Code Field");
		
		Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
		Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
		 Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
		
		    Thread.sleep(5000);

		    Thread.sleep(7000);
		    js.executeScript("window.scrollBy(0,50)");
		    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
		    
		    Thread.sleep(7000);
		   Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
		    Thread.sleep(5000);
	       Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");
		  Thread.sleep(5000);
		  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
		  Thread.sleep(2000);
		  Library.Scrolldown(0,-200);
	       Library.custom_click(ele.getSavebutton(), "Save Button");
	     
	       try {
	    	   
	   
	       }
		  catch(Exception e) {
			  
			  
		  }
	      
	       
	       String msg=config.getconfigdata("Itemcode")+str1+"=="+"Item Master already exists.Enter Different item code ";
		   
		   Library.validation(ele.getITEMINFO(), msg,"Item code");
		   Library.ActionDoubleClick(ele.getITEMINFO(),"Item Code ");
	Thread.sleep(3000);
	
	
	for (int i = 0; i < 10; i++) {
		Thread.sleep(700);
		Library.Scrolldown(0, 20);
		}
	

	for (int i = 0; i < 10; i++) {
		Thread.sleep(700);
		Library.Scrolldown(0, -20);
		}
	
	
	
	Library.custom_click(ele.getItemEditButton(),"Item Edit Button");
	
	Library.Scrolldown(0,50);
	Thread.sleep(3000);
	  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOMedit"),"UOM");
	
		   
	  Library.custom_click(ele.getSavebutton(), "Save Button");
	
	
	
	
}


}

