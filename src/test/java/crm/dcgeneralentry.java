package crm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.crmpom.DCgeneralentry;
import com.storesandinventory.grnwithoutpo;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class dcgeneralentry extends BaseClass {

	@Test
	public void dcGentry1item() throws Exception {
		
		String testcasename=" Test Script to add Direch challen general Entry for single item ,Returnable flag=OFF,Chargable flag=OFF";
		//Login application 
		
		
	
		Library.login("dcGentry1item", testcasename);
		Thread.sleep(2000);
		DCgeneralentry element= PageFactory.initElements(driver,DCgeneralentry.class);
        ConfigDataProvider config=new ConfigDataProvider("dcGentry1item");
        Library.custom_click(element.getCRM(),"CRM Module");
		Library.custom_click(element.getDCGeneralentry(),"DCGeneralentry");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbutton(),"Add New Button");  
		Thread.sleep(7000);
		Library.Explicitlywait(element.getDCGroup());
		Library.Comboclick(element.getDCGroup(),config.getconfigdata("DCgroup"),"DCGroup Field");
		Thread.sleep(3000); 	
		Library.Comboclick(element.getDCsite(),config.getconfigdata("DCsite"),"DCsite Field");
		Thread.sleep(3000); 
		
		calendar.daypicker(element.getDCcalendar(), config.getconfigdata("DATE"), config.getconfigdata("MONTH"), config.getconfigdata("YEAR"));
   Thread.sleep(3000); 
	    Library.Comboclick(element.getReasonForDC(),config.getconfigdata("ReasonForDC"),"ReasonForDC");
	    Thread.sleep(5000);
	    Library.Comboclick(element.getDCFOR(),config.getconfigdata("DCFOR"),"Dc for");
	    Thread.sleep(5000); 
	    Library.Customerselect(element.getCustomersearchbtn(),config.getconfigdata("Customer"));
	    Thread.sleep(3000); 
	   
	    Library.Scrolldown(0,150);
	     Library.Comboclick(element.getShipment(),config.getconfigdata("Shipment"),"Shipment COMBOBOX");
	     Thread.sleep(3000); 
	     Library.Comboclick(element.getEmployee(),config.getconfigdata("Employee"),"Employee COMBOBOX");
	     Thread.sleep(3000); 
	     Library.Comboclick(element.getRetestucture(),config.getconfigdata("Retestucture"),"Retestucture COMBOBOX");
	     Thread.sleep(3000);
	     Library.dClick(element.getEmployeeDetailNextbtn(),"GRN field NExt Button");
	     Thread.sleep(3000);
	     
	     // Adding First item 
	     Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
	     JQXGRID.JQXDIRECTITEMSearch(element.getItemcodesearchbutton(),config.getconfigdata("itemcode"));
	     Thread.sleep(3000);
	     JQXGRID.JQXDropdown(element.getWarehousecode(),config.getconfigdata("warehouse"));
	     Thread.sleep(3000);
         Library.dClick(element.getDispatchQuantity(),"DispatchQuantity");
        WebElement Qty= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty);
	      Thread.sleep(3000);
	     Library.dClick(Qty,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox,config.getconfigdata("dispatchqty"),"dispatch Quantity");
	     Robot robot = new Robot(); 
		 Thread.sleep(2000);	
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
         
       WebElement okbtn=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
       Library.Explicitlywait(okbtn);
	      
       Thread.sleep(3000);
       Actions act=new Actions(driver);
       act.moveToElement(okbtn).click(okbtn).build().perform();
     //  Library.dClick(okbtn,"OK BUTTON");
       Thread.sleep(3000);
       
     
       Library.Scrolldown(0, 100);
       Library.Explicitlywait(element.getItemdetailsnextbutton());
       act.moveToElement(element.getItemdetailsnextbutton()).click(element.getItemdetailsnextbutton()).build().perform();
	      //Library.dClick(element.getItemdetailsnextbutton(),"Item Details NExt Button");
	      Thread.sleep(3000);
	      Library.Comboclick(element.getModeofDispatch(),config.getconfigdata("ModeofDispatch"),"ModeofDispatch Combobox");
	      Thread.sleep(3000);
	      Library.Scrolldown(0, -300);
	      Thread.sleep(3000);
	      Library.custom_click(element.getSaveButton(),"SaveButton");

          Thread.sleep(5000);
        
       
          WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
         
         Library.Explicitlywait(checkbox);
         Actions action=new Actions(driver);
   
   action.moveToElement(checkbox).click().build().perform();
        
  
        Thread.sleep(3000);
      
                    Thread.sleep(5000);
        WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
        Library.Explicitlywait(Authorizebtn);
        act.moveToElement(Authorizebtn).click().build().perform();
  
        System.out.println("Authorization Button Is Displayed  Enabled");
        
        Thread.sleep(4000);
        WebElement text= driver.findElement(By.xpath("(//div[@class='jqx-grid-cell-left-align'])[4]"));
        Library.Explicitlywait(text);
        Library.info(text,"Challen Latest Number ");
        Thread.sleep(4000);
        String Documentnumber=  text.getText();
        System.out.println(Documentnumber);
 
	}
	
	
	
	
	
	
	
//Test Case 2 nd
	
	@Test
	public void dcgeneral2itemedit() throws Exception {
		
		String testcasename=" Test Script to add Direch challen general Entry for two item and After edit one item add and rate stucture change";

	
		//Login application 
		Library.login("dcGentry1item", testcasename);
		Thread.sleep(2000);
		DCgeneralentry element= PageFactory.initElements(driver,DCgeneralentry.class);
        ConfigDataProvider config=new ConfigDataProvider("dcGentry1item");
        Library.custom_click(element.getCRM(),"CRM Module");
		Library.custom_click(element.getDCGeneralentry(),"DCGeneralentry");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbutton(),"Add New Button");  
		Thread.sleep(7000);
		Library.Explicitlywait(element.getDCGroup());
		Library.Comboclick(element.getDCGroup(),config.getconfigdata("DCgroup"),"DCGroup Field");
		Thread.sleep(3000); 	
		Library.Comboclick(element.getDCsite(),config.getconfigdata("DCsite"),"DCsite Field");
		Thread.sleep(3000); 
		
		calendar.daypicker(element.getDCcalendar(), config.getconfigdata("DATE"), config.getconfigdata("MONTH"), config.getconfigdata("YEAR"));
   Thread.sleep(3000); 
	    Library.Comboclick(element.getReasonForDC(),config.getconfigdata("ReasonForDC"),"ReasonForDC");
	    Thread.sleep(5000);
	    Library.Comboclick(element.getDCFOR(),config.getconfigdata("DCFOR"),"Dc for");
	    Thread.sleep(5000); 
	    Library.Customerselect(element.getCustomersearchbtn(),config.getconfigdata("Customer"));
	    Thread.sleep(3000); 
	   
	    Library.Scrolldown(0,150);
	     Library.Comboclick(element.getShipment(),config.getconfigdata("Shipment"),"Shipment COMBOBOX");
	     Thread.sleep(3000); 
	     Library.Comboclick(element.getEmployee(),config.getconfigdata("Employee"),"Employee COMBOBOX");
	     Thread.sleep(3000); 
	     Library.Comboclick(element.getRetestucture(),config.getconfigdata("Retestucture"),"Retestucture COMBOBOX");
	     Thread.sleep(3000);
	     Library.dClick(element.getEmployeeDetailNextbtn(),"GRN field NExt Button");
	     Thread.sleep(3000);
	     
	     // Adding First item 
	     Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
	     JQXGRID.JQXDIRECTITEMSearch(element.getItemcodesearchbutton(),config.getconfigdata("itemcode"));
	     Thread.sleep(3000);
	     JQXGRID.JQXDropdown(element.getWarehousecode(),config.getconfigdata("warehouse"));
	     Thread.sleep(3000);
         Library.dClick(element.getDispatchQuantity(),"DispatchQuantity");
        WebElement Qty= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty);
	      Thread.sleep(3000);
	     Library.dClick(Qty,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox,config.getconfigdata("dispatchqty"),"dispatch Quantity");
	     Robot robot = new Robot(); 
		 Thread.sleep(2000);	
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
         
       WebElement okbtn=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
       Library.Explicitlywait(okbtn);
	      
       Thread.sleep(3000);
       Actions act=new Actions(driver);
       act.moveToElement(okbtn).click(okbtn).build().perform();
     //  Library.dClick(okbtn,"OK BUTTON");
       Thread.sleep(3000);
       
       
       // 2) add Second Item
       
       Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
	     WebElement Itemcodesearchbutton2=driver.findElement(By.xpath("(//div[@columnindex='2'])[2]"));
	     JQXGRID.JQXDIRECTITEMSearch(Itemcodesearchbutton2,config.getconfigdata("itemcode2"));
	     Thread.sleep(3000);
	     WebElement warehousecode2=driver.findElement(By.xpath("(//div[@columnindex='5'])[2]"));
	     JQXGRID.JQXDropdown(warehousecode2,config.getconfigdata("warehouse2"));
	     Thread.sleep(3000);
	     WebElement DispatchQuantity2=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[9]"));
       Library.dClick(DispatchQuantity2,"DispatchQuantity");
      WebElement Qty2= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty2);
	      Thread.sleep(3000);
	     Library.dClick(Qty2,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox2=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox2);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox2,config.getconfigdata("dispatchqty2"),"dispatch Quantity");
	    // Robot robot = new Robot(); 
		 Thread.sleep(2000);	
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(2000);
       
     WebElement okbtn2=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
     Library.Explicitlywait(okbtn2);
	      
     Thread.sleep(3000);
     //Actions act=new Actions(driver);
     act.moveToElement(okbtn2).click(okbtn2).build().perform();
   //  Library.dClick(okbtn,"OK BUTTON");
     Thread.sleep(3000);
     
       
       
       
       //
       
       Library.Scrolldown(0, 100);
       Library.Explicitlywait(element.getItemdetailsnextbutton());
       act.moveToElement(element.getItemdetailsnextbutton()).click(element.getItemdetailsnextbutton()).build().perform();
	      //Library.dClick(element.getItemdetailsnextbutton(),"Item Details NExt Button");
	      Thread.sleep(3000);
	      Library.Comboclick(element.getModeofDispatch(),config.getconfigdata("ModeofDispatch"),"ModeofDispatch Combobox");
	      Thread.sleep(3000);
	      Library.Scrolldown(0, -300);
	      Thread.sleep(3000);
	      Library.custom_click(element.getSaveButton(),"SaveButton");

          Thread.sleep(5000);
          Actions action=new Actions(driver);
          WebElement editbtn=  driver.findElement(By.xpath("//a[@class='edibutton1 gridactions jqx-rc-all jqx-button jqx-widget jqx-grid-widget jqx-fill-state-normal']"));
          Library.Explicitlywait(editbtn);
          Thread.sleep(5000);
          
          action.moveToElement(editbtn).click().build().perform();
          Thread.sleep(5000);
          Library.Scrolldown(0, 100);
       
          Thread.sleep(3000); 
 	     Library.Comboclick(element.getRetestucture(),config.getconfigdata("Retestuctureedit"),"Retestucture COMBOBOX");
 	     Thread.sleep(3000);
 	    Library.dClick(element.getEmployeeDetailNextbtn(),"GRN field NExt Button");
	     Thread.sleep(3000);
	     
	     // Adding Third item 
	     Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
          
          
	     WebElement Itemcodesearchbutton3=driver.findElement(By.xpath("(//div[@columnindex='2'])[3]"));
	     JQXGRID.JQXDIRECTITEMSearch(Itemcodesearchbutton3,config.getconfigdata("itemcode3"));
	     Thread.sleep(3000);
	     WebElement warehousecode3=driver.findElement(By.xpath("(//div[@columnindex='5'])[3]"));
	     JQXGRID.JQXDropdown(warehousecode3,config.getconfigdata("warehouse3"));
	     Thread.sleep(3000);
	     WebElement DispatchQuantity3=driver.findElement(By.xpath("//div[contains(@id,'row2jqxWidget')]//div[9]"));
       Library.dClick(DispatchQuantity3,"DispatchQuantity");
      WebElement Qty3= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty3);
	      Thread.sleep(3000);
	     Library.dClick(Qty3,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox3=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox3);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox3,config.getconfigdata("dispatchqty3"),"dispatch Quantity");
	    // Robot robot = new Robot(); 
		 Thread.sleep(2000);	
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(2000);
       
     WebElement okbtn3=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
     Library.Explicitlywait(okbtn3);
	      
     Thread.sleep(3000);
     //Actions act=new Actions(driver);
     act.moveToElement(okbtn3).click(okbtn3).build().perform();
   //  Library.dClick(okbtn,"OK BUTTON");
     Thread.sleep(3000);
     
          Library.Scrolldown(0, -300);
          
          Thread.sleep(3000);
	      Library.custom_click(element.getSaveButton(),"SaveButton");
         
          WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
         
         Library.Explicitlywait(checkbox);
         Thread.sleep(3000);
   
   action.moveToElement(checkbox).click().build().perform();
        
  
        Thread.sleep(3000);
      
                    Thread.sleep(5000);
        WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
        Library.Explicitlywait(Authorizebtn);
        action.moveToElement(Authorizebtn).click().build().perform();
  
        System.out.println("Authorization Button Is Displayed  Enabled");
        
        Thread.sleep(4000);
        WebElement text= driver.findElement(By.xpath("(//div[@class='jqx-grid-cell-left-align'])[4]"));
        Library.Explicitlywait(text);
        Library.info(text,"Challen Latest Number ");
        Thread.sleep(4000);
        String Documentnumber=  text.getText();
        System.out.println(Documentnumber);   
}
	
	
	
	
	
	
	///Test Case Third
	@Test
	public void editview() throws Exception {
		
		String testcasename=" Test Script to add Direch challen general Entry for two item and After edit one item add and rate stucture change";

		
		//Login application 
		Library.login("dcGentry1item", testcasename);
		Thread.sleep(2000);
		DCgeneralentry element= PageFactory.initElements(driver,DCgeneralentry.class);
        ConfigDataProvider config=new ConfigDataProvider("dcGentry1item");
        Library.custom_click(element.getCRM(),"CRM Module");
		Library.custom_click(element.getDCGeneralentry(),"DCGeneralentry");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbutton(),"Add New Button");  
		Thread.sleep(7000);
		Library.Explicitlywait(element.getDCGroup());
		Library.Comboclick(element.getDCGroup(),config.getconfigdata("DCgroup"),"DCGroup Field");
		Thread.sleep(3000); 	
		Library.Comboclick(element.getDCsite(),config.getconfigdata("DCsite"),"DCsite Field");
		Thread.sleep(3000); 
		
		calendar.daypicker(element.getDCcalendar(), config.getconfigdata("DATE"), config.getconfigdata("MONTH"), config.getconfigdata("YEAR"));
   Thread.sleep(3000); 
	    Library.Comboclick(element.getReasonForDC(),config.getconfigdata("ReasonForDC"),"ReasonForDC");
	    Thread.sleep(5000);
	    Library.Comboclick(element.getDCFOR(),config.getconfigdata("DCFOR"),"Dc for");
	    Thread.sleep(5000); 
	    Library.Customerselect(element.getCustomersearchbtn(),config.getconfigdata("Customer"));
	    Thread.sleep(3000); 
	   
	    Library.Scrolldown(0,150);
	     Library.Comboclick(element.getShipment(),config.getconfigdata("Shipment"),"Shipment COMBOBOX");
	     Thread.sleep(3000); 
	     Library.Comboclick(element.getEmployee(),config.getconfigdata("Employee"),"Employee COMBOBOX");
	     Thread.sleep(3000); 
	     Library.Comboclick(element.getRetestucture(),config.getconfigdata("Retestucture"),"Retestucture COMBOBOX");
	     Thread.sleep(3000);
	     Library.dClick(element.getEmployeeDetailNextbtn(),"GRN field NExt Button");
	     Thread.sleep(3000);
	     
	     // Adding First item 
	     Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
	     JQXGRID.JQXDIRECTITEMSearch(element.getItemcodesearchbutton(),config.getconfigdata("itemcode"));
	     Thread.sleep(3000);
	     JQXGRID.JQXDropdown(element.getWarehousecode(),config.getconfigdata("warehouse"));
	     Thread.sleep(3000);
         Library.dClick(element.getDispatchQuantity(),"DispatchQuantity");
        WebElement Qty= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty);
	      Thread.sleep(3000);
	     Library.dClick(Qty,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox,config.getconfigdata("dispatchqty"),"dispatch Quantity");
	     Robot robot = new Robot(); 
		 Thread.sleep(2000);	
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
         
       WebElement okbtn=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
       Library.Explicitlywait(okbtn);
	      
       Thread.sleep(3000);
       Actions act=new Actions(driver);
       act.moveToElement(okbtn).click(okbtn).build().perform();
     //  Library.dClick(okbtn,"OK BUTTON");
       Thread.sleep(3000);
       
       
       // 2) add Second Item
       
       Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
	     WebElement Itemcodesearchbutton2=driver.findElement(By.xpath("(//div[@columnindex='2'])[2]"));
	     JQXGRID.JQXDIRECTITEMSearch(Itemcodesearchbutton2,config.getconfigdata("itemcode2"));
	     Thread.sleep(3000);
	     WebElement warehousecode2=driver.findElement(By.xpath("(//div[@columnindex='5'])[2]"));
	     JQXGRID.JQXDropdown(warehousecode2,config.getconfigdata("warehouse2"));
	     Thread.sleep(3000);
	     WebElement DispatchQuantity2=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[9]"));
       Library.dClick(DispatchQuantity2,"DispatchQuantity");
      WebElement Qty2= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty2);
	      Thread.sleep(3000);
	     Library.dClick(Qty2,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox2=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox2);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox2,config.getconfigdata("dispatchqty2"),"dispatch Quantity");
	    // Robot robot = new Robot(); 
		 Thread.sleep(2000);	
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(2000);
       
     WebElement okbtn2=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
     Library.Explicitlywait(okbtn2);
	      
     Thread.sleep(3000);
     //Actions act=new Actions(driver);
     act.moveToElement(okbtn2).click(okbtn2).build().perform();
   //  Library.dClick(okbtn,"OK BUTTON");
     Thread.sleep(3000);
     
       
       
       
       //
       
       Library.Scrolldown(0, 100);
       Library.Explicitlywait(element.getItemdetailsnextbutton());
       act.moveToElement(element.getItemdetailsnextbutton()).click(element.getItemdetailsnextbutton()).build().perform();
	      //Library.dClick(element.getItemdetailsnextbutton(),"Item Details NExt Button");
	      Thread.sleep(3000);
	      Library.Comboclick(element.getModeofDispatch(),config.getconfigdata("ModeofDispatch"),"ModeofDispatch Combobox");
	      Thread.sleep(3000);
	      Library.Scrolldown(0, -300);
	      Thread.sleep(3000);
	      Library.custom_click(element.getSaveButton(),"SaveButton");

          //Thread.sleep(5000);
          
          Thread.sleep(10000);
//          
//          WebElement editbtnn=  driver.findElement(By.xpath("//a[@class='edibutton1 gridactions jqx-rc-all jqx-button jqx-widget jqx-grid-widget jqx-fill-state-normal']"));
//          Library.Explicitlywait(editbtnn);
//          
          
          Thread.sleep(5000);
        WebElement editbtnn=  driver.findElement(By.xpath("//a[@class='edibutton1 gridactions jqx-rc-all jqx-button jqx-widget jqx-grid-widget jqx-fill-state-normal']"));   
        Library.Explicitlywait(editbtnn);
        
        Actions action=new Actions(driver);
          Thread.sleep(1000);
          action.moveToElement(editbtnn).click(editbtnn).build().perform();
          Thread.sleep(5000);
          Library.Scrolldown(0, 100);
       
          Thread.sleep(3000); 
 	     Library.Comboclick(element.getRetestucture(),config.getconfigdata("Retestuctureedit"),"Retestucture COMBOBOX");
 	     Thread.sleep(3000);
 	    Library.dClick(element.getEmployeeDetailNextbtn(),"GRN field NExt Button");
	     Thread.sleep(3000);
	     
	     // Adding Third item 
	     Library.dClick(element.getAddNEWITEMBTN(), "Item Add New Button");
	     Thread.sleep(3000);
          
          
	     WebElement Itemcodesearchbutton3=driver.findElement(By.xpath("(//div[@columnindex='2'])[3]"));
	     JQXGRID.JQXDIRECTITEMSearch(Itemcodesearchbutton3,config.getconfigdata("itemcode3"));
	     Thread.sleep(3000);
	     WebElement warehousecode3=driver.findElement(By.xpath("(//div[@columnindex='5'])[3]"));
	     JQXGRID.JQXDropdown(warehousecode3,config.getconfigdata("warehouse3"));
	     Thread.sleep(3000);
	     WebElement DispatchQuantity3=driver.findElement(By.xpath("//div[contains(@id,'row2jqxWidget')]//div[9]"));
       Library.dClick(DispatchQuantity3,"DispatchQuantity");
      WebElement Qty3= driver.findElement(By.xpath("(//div[@columnindex='16'])[10]"));
	      Library.Explicitlywait(Qty3);
	      Thread.sleep(3000);
	     Library.dClick(Qty3,"Dispatch Quantity Qty Field");
	     WebElement Qtytxtbox3=  driver.findElement(By.xpath("//div[contains(@id,'qty')]//input"));
	     Library.Explicitlywait(Qtytxtbox3);
	      Thread.sleep(3000);
	     Library.custom_Sendkeys(Qtytxtbox3,config.getconfigdata("dispatchqty3"),"dispatch Quantity");
	    // Robot robot = new Robot(); 
		 Thread.sleep(2000);	
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(2000);
       
     WebElement okbtn3=  driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
     Library.Explicitlywait(okbtn3);
	      
     Thread.sleep(3000);
     //Actions act=new Actions(driver);
     act.moveToElement(okbtn3).click(okbtn3).build().perform();
   //  Library.dClick(okbtn,"OK BUTTON");
     Thread.sleep(3000);
     
          Library.Scrolldown(0, -300);
          
          Thread.sleep(3000);
	      Library.custom_click(element.getSaveButton(),"SaveButton");
         
          WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
         
         Library.Explicitlywait(checkbox);
         Thread.sleep(3000);
   
   action.moveToElement(checkbox).click().build().perform();
        
  
        Thread.sleep(3000);
      
                    Thread.sleep(5000);
        WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
        Library.Explicitlywait(Authorizebtn);
        action.moveToElement(Authorizebtn).click().build().perform();
  
        System.out.println("Authorization Button Is Displayed  Enabled");
        
        Thread.sleep(4000);
        WebElement text= driver.findElement(By.xpath("(//div[@class='jqx-grid-cell-left-align'])[4]"));
        Library.Explicitlywait(text);
        Library.info(text,"Challen Latest Number ");
        Thread.sleep(4000);
        String Documentnumber=  text.getText();
        System.out.println(Documentnumber);   
        action.moveToElement(text).doubleClick(text).build().perform();
        Thread.sleep(5000);
        for (int i = 0; i<6; i++) {
        	Thread.sleep(700);
        	Library.Scrolldown(0, 30);
        	}
        
        Thread.sleep(3000);
		WebElement itemdetailsbtn=driver.findElement(By.xpath("//button[@class='btn btn-link collapsed']"));
		Library.Explicitlywait(itemdetailsbtn);
		 for (int i = 0; i<3; i++) {
	        	Thread.sleep(700);
	        	Library.Scrolldown(0, 30);
	        	}
		Actions buttonclick=new Actions(driver);
		Thread.sleep(4000);
		buttonclick.moveToElement(itemdetailsbtn).click(itemdetailsbtn).build().perform();
	    Thread.sleep(3000);
			WebElement transportdetail=driver.findElement(By.xpath("//button[@class='btn btn-link collapsed']"));
			Library.Explicitlywait( transportdetail);
			
		//	Actions buttonclick=new Actions(driver);
			Thread.sleep(4000);
			buttonclick.moveToElement( transportdetail).click( transportdetail).build().perform();
			driver.navigate().back();
			Thread.sleep(5000);
		
	}
	
}
