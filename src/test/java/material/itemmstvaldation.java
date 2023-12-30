package material;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Random;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crmpom.LeadEntry;
import com.pageobject.Materials;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Library;

import net.bytebuddy.utility.RandomString;

public class itemmstvaldation extends BaseClass {
	
	
	@Test
	public void itmvaldn() throws Exception {

		String testcasename="Item master Basic Entry Validation of Duplicate Entry";
 		Library.login("material","itmvaldn", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
		Library.filelocationConfigreport("material","itmvaldn");
        ConfigDataProvider config=new ConfigDataProvider("material","itmvaldn");
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor)driver;
			Materials ele=PageFactory.initElements(driver,Materials.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
			//js.executeScript("arguments[0].click()", ele.getMaterialsModule());
			Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
			Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
			
				Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
				Library.custom_Sendkeys(ele.getItemcode(),config.getconfigdata("Itemcode"),"Item Code ");
			//ele.getItemcode().sendKeys(config.getconfigdata("Itemcode"));
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
	      
	       
	       String msg=config.getconfigdata("Itemcode")+"=="+"Item Master already exists.Enter Different item code ";
		   
		   Library.validation(ele.getITEMINFO(), msg,"Item code");
	

}
	@Test(invocationCount=1,priority=1)
	public void itmmstclssubclsvaldn() throws Exception {
		

		String testcasename="Item master Basic Entry  Error Validation After Entering Wrong Class Name";
	
		
		
		Library.login("material","itmmstclssubclsvaldn", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
        ConfigDataProvider config=new ConfigDataProvider("material","itmmstclssubclsvaldn");
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor)driver;
			Materials ele=PageFactory.initElements(driver,Materials.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
			//js.executeScript("arguments[0].click()", ele.getMaterialsModule());
			Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
			Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
			
				Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
			//ele.getItemcode().sendKeys(config.getconfigdata("Itemcode"));
			
			Library.custom_Sendkeys(ele.getItemcode(), config.getconfigdata("itemcode"),"Item code");
			   Thread.sleep(3000);
		Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
		   Thread.sleep(3000);
		Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
		   Thread.sleep(3000);
		Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
		
		    Thread.sleep(3000);

		    Thread.sleep(7000);
		    js.executeScript("window.scrollBy(0,50)");
		    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
//		    Robot robot = new Robot();
//		    robot.keyPress(KeyEvent.VK_ENTER);
//		    robot.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(1000);
		   Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
		    Thread.sleep(2000);
	       Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");
		  Thread.sleep(2000);
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
		  
//	       String msg=config.getconfigdata("Itemcode")+"=="+"Item Master already exists.Enter Different item code ";
//		   
//		   Library.validation(ele.getITEMINFO(), msg,"Item code");
	
		
		
	}
	
	
	
	
	
	
	
	
	
	@Test (invocationCount=1,priority=2)
	
	public void eightentryadd() throws Exception {
		
		
		
		String testcasename="Item master Basic Entry Validation of Duplicate Entry By Adding 8 item in itemaster";
		
			
		Library.login("material","eightentryadd", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
        ConfigDataProvider config=new ConfigDataProvider("material","eightentryadd");
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
    	 ExcelDataProvider excel=new ExcelDataProvider("itemmaster");
		JavascriptExecutor js = (JavascriptExecutor)driver;
			Materials ele=PageFactory.initElements(driver,Materials.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
			//js.executeScript("arguments[0].click()", ele.getMaterialsModule());
			Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
			Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
			
			
			
			
			 for (int i = 1; i < 9; i++) {
				 Random random = new Random();
				 int number = random.nextInt(50);
			        System.out.println(number);
			        String str1 = Integer.toString(number);
			        System.out.println(str1 );
				 Thread.sleep(3000);
				Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
				 excel.getStringdata("Sheet1", i, 5);//For Item Code
		Library.custom_Sendkeys(ele.getItemcode(), excel.getStringdata("Sheet1", i, 5)+str1,"Item code");
		
		Library.custom_Sendkeys(ele.getItemDescription(),excel.getStringdata("Sheet1", i, 6),"ItemDesc");
		
		Library.custom_Sendkeys( ele.getItemDetailDescription(), excel.getStringdata("Sheet1", i, 7), "ItemDetailDesc");
		 Library.custom_Sendkeys( ele.getItemaddDetailDesc(),excel.getStringdata("Sheet1", i, 8),"ItemaddDetailDesc" );
		
		    

		    Thread.sleep(2000);
		    js.executeScript("window.scrollBy(0,50)");
		    Library.Comboclick(ele.getItemclass(),excel.getStringdata("Sheet1", i, 9),"Class");
		    
		    Thread.sleep(2000);
		   Library.Comboclick(ele.getSubclass(),excel.getStringdata("Sheet1", i, 10),"Subclass");
		    Thread.sleep(2000);
	       Library.Comboclick(ele.getMaterial_Of_Construction(),excel.getStringdata("Sheet1", i, 11),"MOC");
		  Thread.sleep(2000);
		  
		  Library.Comboclick(ele.getItemtype(), excel.getStringdata("Sheet1", i, 12),"ItemType");
		
		  
		  Library.Comboclick(ele.getUnitOfMeasurement(), excel.getStringdata("Sheet1", i, 13),"UOM");
		  Thread.sleep(2000);
		  Library.Scrolldown(0,-200);
	       Library.custom_click(ele.getSavebutton(), "Save Button");
	       
	       try {
	    	   
	    	   Library.custom_click(ele.getSavebutton(), "Save Button");   
	    	   Library.ActionClick(ele.getSavebutton(), "Save Button");
	    	   
	    	
	       }
	       
	       catch(Exception e) {
	    	 System.out.println(e.getMessage());  
	    	   
	       }
	       try {
	    	//   Library.ActionDoubleClick(ele.getSavebutton(), testcasename);
	    WebElement classmsg=driver.findElement(By.xpath("//div[text()=' Item Class is required. ']"));
	    Library.Ertrormassage(classmsg);
	       }
		  catch(Exception e) {
			  
			  
		  }
	      
	       
	       String msg=excel.getStringdata("Sheet1", i, 5)+str1+"=="+"Item Master already exists.Enter Different item code ";
		   
		   Library.validation(ele.getITEMINFO(), msg,"Item code");
	
		  // Thread.sleep(7000);
		
		
		
	}
	
	
	
	}
	
	
	@Test(invocationCount=1,priority=3)
	
	public void itemmasteruom() throws Exception {
		

		String testcasename="Item master Basic Entry Validation Error Validation all field are Empty and try to save";
	
		
		
		Library.login("material","itemmasteruom", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
        ConfigDataProvider config=new ConfigDataProvider("material","itemmasteruom");
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor)driver;
			Materials ele=PageFactory.initElements(driver,Materials.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
			//js.executeScript("arguments[0].click()", ele.getMaterialsModule());
			Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
			Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
			
				Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
			
				
				//ele.getItemcode().sendKeys(config.getconfigdata("Itemcode"));
			
			Library.custom_Sendkeys(ele.getItemcode(), config.getconfigdata("Itemcode"),"Item code");
			   Thread.sleep(3000);
		Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
		   Thread.sleep(3000);
		Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
		   Thread.sleep(3000);
		Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
		
		    Thread.sleep(3000);

		    Thread.sleep(7000);
		    js.executeScript("window.scrollBy(0,50)");
		    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
//		    Robot robot = new Robot();
//		    robot.keyPress(KeyEvent.VK_ENTER);
//		    robot.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(1000);
		   Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
		    Thread.sleep(2000);
	       Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");
		  Thread.sleep(2000);
		  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
		  Thread.sleep(2000);
		  Library.Scrolldown(0,-200);
				 Thread.sleep(5000);
	       Library.custom_click(ele.getSavebutton(), "Save Button");
	       try {
	    	   
	   	    WebElement classmsg=driver.findElement(By.xpath("//div[text()=' Item Class is required. ']"));
	   	    Library.Ertrormassage(classmsg);
	   	       }
	   		  catch(Exception e) {
	   			  
	   			  System.out.println(e.getMessage());
	   		  }
	
	           
	
	   try {
    	   
	   	    WebElement UOMmsg=driver.findElement(By.xpath("//div[contains(text(),' Unit')]"));
	   	    Library.Ertrormassage(UOMmsg);
	   	       }
	   		  catch(Exception e1) {
	   			  System.out.println(e1.getMessage());
	   			  
	   		  }
	
	           
	

	   try {
 	   
	   	    WebElement itmcodemsg=driver.findElement(By.xpath("//div[contains(text(),' Item Code is required. ')]"));
	   	    Library.Ertrormassage(itmcodemsg);
	   	       }
	   		  catch(Exception e1) {
	   			  System.out.println(e1.getMessage());
	   			  
	   		  }
	

	   try {
 	   
	   	    WebElement itmcodedesc=driver.findElement(By.xpath("//div[contains(text(),' Item Description is required')]"));
	   	    Library.Ertrormassage(itmcodedesc);
	   	       }
	   		  catch(Exception e1) {
	   			  System.out.println(e1.getMessage());
	   			  
	   		  }

      String msg=config.getconfigdata("Itemcode")+"=="+"Item Master already exists.Enter Different item code ";	   
   Library.validation(ele.getITEMINFO(), msg,"Item code");

	
	 }
	
	
	
	
	
	
	
@Test(invocationCount=1,priority=4)

public void itemupdate() throws Exception {


	String testcasename="Item master Basic Entry update item code description ";

	
	
	Library.login("material","itemupdate", testcasename);
	Thread.sleep(2000);
	LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
    ConfigDataProvider config=new ConfigDataProvider("material","itemupdate");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Materials ele=PageFactory.initElements(driver,Materials.class);
	wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
	//js.executeScript("arguments[0].click()", ele.getMaterialsModule());
	Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
	wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
	//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
	Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
	Thread.sleep(3000);
   //   Library.custom_Sendkeys(ele.getSEARCHITEMCODE(),config.getconfigdata("Itemcode"),"Search Item Code Field");
    
	
	
	
	
	try {
    	 Library.custom_Sendkeys(ele.getSEARCHITEMCODE(),config.getconfigdata("Itemcode"),"Search Item Code Field");
      ele.getSEARCHITEMCODE().submit();
     }
     
     catch(Exception z) {
    	 
    	 System.out.println(z.getMessage());
     }
     Thread.sleep(3000);
     WebElement servccode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("Itemcode")+"')]"));
     Library.Explicitlywait(servccode);
     Library.ActionDoubleClick(servccode,"Item code");
     
     
     
     //Library.custom_click(servccode,"Itemcode");
	 Thread.sleep(3000);
	 
	 WebElement Editbtn=driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	 Library.Explicitlywait(Editbtn);
	 Library.custom_click(Editbtn,"Item Edit Button");
	 Thread.sleep(3000);
	
		Library.custom_Sendkeys(ele.getItemcode(), config.getconfigdata("Itemcode"),"Item code");
		   Thread.sleep(3000);
		   ele.getItemDescription().clear();
	Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
	
	   Thread.sleep(3000);
	   ele.getItemDescription().clear();
	Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
	   Thread.sleep(3000);
	   ele.getItemDescription().clear();
	Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
	
	    Thread.sleep(3000);

	    Thread.sleep(7000);
	    js.executeScript("window.scrollBy(0,50)");
	    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
//	    Robot robot = new Robot();
//	    robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	   Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
	    Thread.sleep(2000);
     Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");
	  Thread.sleep(2000);
	  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
	  Thread.sleep(2000);
	  Library.Scrolldown(0,-200);
			 Thread.sleep(5000);
     Library.custom_click(ele.getSavebutton(), "Save Button");
     try {
  	   
 	    WebElement classmsg=driver.findElement(By.xpath("//div[text()=' Item Class is required. ']"));
 	    Library.Ertrormassage(classmsg);
 	       }
 		  catch(Exception e) {
 			  
 			  System.out.println(e.getMessage());
 		  }

         

 try {
	   
 	    WebElement UOMmsg=driver.findElement(By.xpath("//div[contains(text(),' Unit')]"));
 	    Library.Ertrormassage(UOMmsg);
 	       }
 		  catch(Exception e1) {
 			  System.out.println(e1.getMessage());
 			  
 		  }

         


 try {
  
 	    WebElement itmcodemsg=driver.findElement(By.xpath("//div[contains(text(),' Item Code is required. ')]"));
 	    Library.Ertrormassage(itmcodemsg);
 	       }
 		  catch(Exception e1) {
 			  System.out.println(e1.getMessage());
 			  
 		  }


 try {
  
 	    WebElement itmcodedesc=driver.findElement(By.xpath("//div[contains(text(),' Item Description is required')]"));
 	    Library.Ertrormassage(itmcodedesc);
 	       }
 		  catch(Exception e1) {
 			  System.out.println(e1.getMessage());
 			  
 		  }
try {
String msg=config.getconfigdata("Itemcode")+"=="+"Item Master already exists.Enter Different item code ";	   
Library.validation(ele.getITEMINFO(), msg,"Item code");
}

catch(Exception x) {}

}

	

	
	
	
	
	
	
	
	
public  WebElement SEARCHITEMCODESt(String Itemcode) {
	
	WebElement servccode=driver.findElement(By.xpath("//div[contains(text(),'"+Itemcode+"')]"));
	
	return servccode;
}	
	
	
	
	
	
	
	
	
	
	
}