package crm;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crmpom.DCgeneralentry;
import com.crmpom.LeadEntry;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class leadentry extends BaseClass {
	
	
	@Test(enabled=false)
	
	public void basicleadentry() throws Exception {
		String testcasename=" Test script to add basic lead entry of 2 service item";
		Library.login("crm","Leadentry", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
        ConfigDataProvider config=new ConfigDataProvider("crm","Leadentry");
        Library.custom_click(element.getCRM(),"CRM Module");
        Library.custom_click(element.getLeadentry(),"Leadentry");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbutton(),"Add New Button");  
		Thread.sleep(8000);
		JQXGRID.JQXDIRECTITEMSearch(element.getCustomersearchbtn(),config.getconfigdata("customer"));
		Thread.sleep(3000);
		
		Library.Comboclick(element.getSalesmanControl(),config.getconfigdata("salesman"),"salesman");
		Thread.sleep(3000);
	Library.Comboclick(element.getSalesregControl(),config.getconfigdata("salesregControl"),"salesregControl");
	
	Thread.sleep(3000);
	Library.Scrolldown(0, 70);
	   Library.ActionClick(element.getCstmrandsalesDetailNextbtn(),"GRN field NExt Button");
	   Thread.sleep(3000);
	   Library.Scrolldown(0, 70);
		Library.Comboclick(element.getLEADGROUP(),config.getconfigdata("Leadgroup"),"Leadgroup");
		  Thread.sleep(3000);
		Library.Comboclick(element.getLEADsite(),config.getconfigdata("SITE"),"Lead site");
		 Thread.sleep(3000);
		 calendar.daypicker(element.getLEADdate(), config.getconfigdata("DATE"), config.getconfigdata("MONTH"), config.getconfigdata("YEAR"));
		 Thread.sleep(3000);
		 Library.Comboclick(element.getSourcesofLead(),config.getconfigdata("SourcesofLead"),"SourcesofLead");
		 Thread.sleep(3000);
		   Library.ActionClick(element.getLeadDetailNextbtn(),"Lead details NExt Button");
		   Thread.sleep(3000);
		   Library.ActionClick(element.getTendorinfoNextbtn(),"Tendor information  NExt Button");
		   Thread.sleep(3000);
		   Library.ActionClick(element.getFOLLOUPQUOTNextbtn(),"Follow up PQ UOT  NExt Button");
		   Thread.sleep(3000);
		   //1 st Item add into lead entry
		   
		   Library.ActionClick(element.getaDDNEWbtn(),"Add new  Button");
		   Thread.sleep(3000);
		 //  WebElement serchbtn=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));
		   searchwindowpopup1(element.getSalesitmserachbtn1(),config.getconfigdata("ITEM1"));
		   
		 //  Library.searchwindowpopup(element.getSalesitmserachbtn1(),serchbtn,config.getconfigdata("ITEM1"));
	//  JQXGRID.JQXDIRECTITEMSearch(element.getSalesitmserachbtn1(),config.getconfigdata("ITEM1"));
//		   WebElement element1=element.getSalesitmserachbtn1();
//		   Library.dClick(element1,"Item code searchbtn");
//			Thread.sleep(7000);
//			WebElement item=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
//			Library.Explicitlywait(item);
//			Thread.sleep(4000);
//			Library.custom_Sendkeys(item, config.getconfigdata("ITEM1"), "Item code Search Filed");
//			Thread.sleep(1000);
//			Robot robot = new Robot();
//			Thread.sleep(1000);
//			robot.getAutoDelay();
//	        robot.keyPress(KeyEvent.VK_ENTER);
//	        robot.keyRelease(KeyEvent.VK_ENTER);
//	        Thread.sleep(1000);
//
//			WebElement Itemcode=driver.findElement(By.xpath("//div[text()='"+config.getconfigdata("ITEM1")+"']"));
//			Library.Explicitlywait(Itemcode);
//			Thread.sleep(6000);
//		
//			Itemcode.click();
//			Itemcode.click();
			//Itemcode.sendKeys(Keys.ENTER);
			//test.log(Status.INFO, "Itemcode Sucessfully selected =="+config.getconfigdata("ITEM1"));
		   Thread.sleep(3000);
		   
		   
		   
		   WebElement horizontalscroll=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscroll);
	        	 Library.dClick(horizontalscroll, "Horizontal Scroll Button");
	        	
	        	}
		   Library.dClick(element.getQuantityField1(),"Quantity Field for 1st item");
		   Thread.sleep(3000);
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity1"));
		   
		   //2nd item add into Lead Entry 
		   
		   Library.ActionClick(element.getaDDNEWbtn(),"Add new  Button");
		   Thread.sleep(3000);
		  // WebElement serchbtn2=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[3]"));
		   searchwindowpopup2(element.getSalesitmserachbtn2(),config.getconfigdata("ITEM2"));
		//   JQXGRID.JQXDIRECTITEMSearch(element.getSalesitmserachbtn2(),config.getconfigdata("ITEM2"));
		   Thread.sleep(3000);
		   WebElement horizontalscrol2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscrol2);
	        	 Library.dClick(horizontalscrol2, "Horizontal Scroll Button");
	        	
	        	}
	         
	         Thread.sleep(3000);
		   Library.dClick(element.getQuantityField2(),"Quantity Field for 2st item");
		   Thread.sleep(3000);
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity2"));
		   Library.Scrolldown(0, 30);
		   Robot robot1 = new Robot();
			Thread.sleep(1000);
	        robot1.keyPress(KeyEvent.VK_ENTER);
	        robot1.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(1000);
		   Thread.sleep(3000);
		   Library.Scrolldown(0,-600);
		   Library.custom_click(element.getSAVEBUTTON(), "SaveButton");
		   Thread.sleep(10000);
		   
		   WebElement Leadnumber=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
		   
		//   Actions action =new Actions(driver);
		//   WebElement editbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[1]/div[1]/a[1]")) ;  
		   Library.info(Leadnumber,"Lead Number ");
		
		  // action.moveToElement( editbtn).doubleClick( editbtn).build().perform();
	        Thread.sleep(5000);
	        for (int i = 0; i<10; i++) {
	        	Thread.sleep(700);
	        	Library.Scrolldown(0, 30);
	        	}
	        
	        Thread.sleep(3000);
		  
		  
	}
	
	
	
	//test case 2nd statrted
	
	@Test(enabled=false)
	
	public void LeadEntryview() throws Exception {
		
		String testcasename=" Test script to add basic lead entry of 2 service item and view entry";
		Library.login("crm","Leadentry", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
        ConfigDataProvider config=new ConfigDataProvider("crm","Leadentry");
        Library.custom_click(element.getCRM(),"CRM Module");
        Library.custom_click(element.getLeadentry(),"Leadentry");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbutton(),"Add New Button");  
		Thread.sleep(8000);
		JQXGRID.JQXDIRECTITEMSearch(element.getCustomersearchbtn(),config.getconfigdata("customer"));
		Thread.sleep(3000);
		
		Library.Comboclick(element.getSalesmanControl(),config.getconfigdata("salesman"),"salesman");
		Thread.sleep(3000);
	Library.Comboclick(element.getSalesregControl(),config.getconfigdata("salesregControl"),"salesregControl");
	
	Thread.sleep(3000);
	Library.Scrolldown(0, 70);
	   Library.ActionClick(element.getCstmrandsalesDetailNextbtn(),"GRN field NExt Button");
	   Thread.sleep(3000);
	   Library.Scrolldown(0, 70);
		Library.Comboclick(element.getLEADGROUP(),config.getconfigdata("Leadgroup"),"Leadgroup");
		  Thread.sleep(3000);
		Library.Comboclick(element.getLEADsite(),config.getconfigdata("SITE"),"Lead site");
		 Thread.sleep(3000);
		 calendar.daypicker(element.getLEADdate(), config.getconfigdata("DATE"), config.getconfigdata("MONTH"), config.getconfigdata("YEAR"));
		 Thread.sleep(3000);
		 Library.Comboclick(element.getSourcesofLead(),config.getconfigdata("SourcesofLead"),"SourcesofLead");
		 Thread.sleep(3000);
		   Library.ActionClick(element.getLeadDetailNextbtn(),"Lead details NExt Button");
		   Thread.sleep(3000);
		   Library.ActionClick(element.getTendorinfoNextbtn(),"Tendor information  NExt Button");
		   Thread.sleep(3000);
		   Library.ActionClick(element.getFOLLOUPQUOTNextbtn(),"Follow up PQ UOT  NExt Button");
		   Thread.sleep(3000);
		   //1 st Item add into lead entry
		   
		   Library.ActionClick(element.getaDDNEWbtn(),"Add new  Button");
		   Thread.sleep(3000);
		 //  WebElement serchbtn=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));
		   searchwindowpopup1(element.getSalesitmserachbtn1(),config.getconfigdata("ITEM1"));
		   
		   Thread.sleep(3000);
		   
		   
		   
		   WebElement horizontalscroll=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscroll);
	        	 Library.dClick(horizontalscroll, "Horizontal Scroll Button");
	        	
	        	}
		   Library.dClick(element.getQuantityField1(),"Quantity Field for 1st item");
		   Thread.sleep(3000);
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity1"));
		   
		   //2nd item add into Lead Entry 
		   
		   Library.ActionClick(element.getaDDNEWbtn(),"Add new  Button");
		   Thread.sleep(3000);
		  // WebElement serchbtn2=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[3]"));
		   searchwindowpopup2(element.getSalesitmserachbtn2(),config.getconfigdata("ITEM2"));
		//   JQXGRID.JQXDIRECTITEMSearch(element.getSalesitmserachbtn2(),config.getconfigdata("ITEM2"));
		   Thread.sleep(3000);
		   WebElement horizontalscrol2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscrol2);
	        	 Library.dClick(horizontalscrol2, "Horizontal Scroll Button");
	        	
	        	}
	         
	         Thread.sleep(3000);
		   Library.dClick(element.getQuantityField2(),"Quantity Field for 2st item");
		   Thread.sleep(3000);
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity2"));
		   Library.Scrolldown(0, 30);
		   Robot robot1 = new Robot();
			Thread.sleep(1000);
	        robot1.keyPress(KeyEvent.VK_ENTER);
	        robot1.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(1000);
		   Thread.sleep(3000);
		   Library.Scrolldown(0,-600);
		   Library.custom_click(element.getSAVEBUTTON(), "SaveButton");
		   Thread.sleep(10000);

		   Actions action =new Actions(driver);
		
		   WebElement Leadnumber=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
		  Library.Explicitlywait(Leadnumber);
		   Library.info(Leadnumber,"Lead Number ");
		   action.moveToElement( Leadnumber).doubleClick( Leadnumber).build().perform();
		   Thread.sleep(3000);
		   
		   for (int i = 0; i<5; i++) {
	        	Thread.sleep(700);
	        	Library.Scrolldown(0, 30);
	        	}
		   
		 WebElement leadheader=  driver.findElement(By.xpath("//div[@id='ngb-panel-1-header']"));
		 Library.dClick(leadheader,"Lead Header hide Button");
		 for (int i = 0; i<6; i++) {
	        	Thread.sleep(700);
	        	Library.Scrolldown(0, 30);
	        	}
		   
			 WebElement tendar=  driver.findElement(By.xpath("//div[@id='ngb-panel-2-header']"));
			 Library.dClick(tendar,"Tendar hide Button");
		   
			 for (int i = 0; i<6; i++) {
		        	Thread.sleep(700);
		        	Library.Scrolldown(0, 30);
		        	}
			   
			 WebElement folloup=  driver.findElement(By.xpath("//div[@id='ngb-panel-3-header']"));
			 Library.dClick(folloup,"folloup Quotation hide Button");
			 
			 for (int i = 0; i<6; i++) {
		        	Thread.sleep(700);
		        	Library.Scrolldown(0, 30);
		        	}
			   
					 WebElement model=  driver.findElement(By.xpath("//div[@id='ngb-panel-4-header']"));
					 Library.dClick(model,"folloup Quotation hide Button");
					 
			 
			 
	        Thread.sleep(5000);
	        for (int i = 0; i<50; i++) {
	        	Thread.sleep(700);
	        	Library.Scrolldown(0, -30);
	        	}
	        
	      WebElement cancelbtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2 key key-m']"));
	        
	      Library.custom_click(cancelbtn, "Cancel button");
	        Thread.sleep(3000);
		  
		  

			   
//		      WebElement editbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[1]/div[1]/a[1]")) ;  
//		   
//		
//		   action.moveToElement( editbtn).doubleClick( editbtn).build().perform();
	}
	
	@Test
	
	public void LeadEntryEdit() throws Exception {
		

		String testcasename=" Test script to add basic lead entry of 2 service item and Edit entry";
		Library.login("crm","Leadentry", testcasename);
		Thread.sleep(2000);
		LeadEntry element= PageFactory.initElements(driver,LeadEntry.class);
        ConfigDataProvider config=new ConfigDataProvider("crm","Leadentry");
        Library.custom_click(element.getCRM(),"CRM Module");
        Library.custom_click(element.getLeadentry(),"Leadentry");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbutton(),"Add New Button");  
		Thread.sleep(8000);
		JQXGRID.JQXDIRECTITEMSearch(element.getCustomersearchbtn(),config.getconfigdata("customer"));
		Thread.sleep(3000);
		
		Library.Comboclick(element.getSalesmanControl(),config.getconfigdata("salesman"),"salesman");
		Thread.sleep(3000);
	Library.Comboclick(element.getSalesregControl(),config.getconfigdata("salesregControl"),"salesregControl");
	
	Thread.sleep(3000);
	Library.Scrolldown(0, 70);
	   Library.ActionClick(element.getCstmrandsalesDetailNextbtn(),"GRN field NExt Button");
	   Thread.sleep(3000);
	   Library.Scrolldown(0, 70);
		Library.Comboclick(element.getLEADGROUP(),config.getconfigdata("Leadgroup"),"Leadgroup");
		  Thread.sleep(3000);
		Library.Comboclick(element.getLEADsite(),config.getconfigdata("SITE"),"Lead site");
		 Thread.sleep(3000);
		 calendar.daypicker(element.getLEADdate(), config.getconfigdata("DATE"), config.getconfigdata("MONTH"), config.getconfigdata("YEAR"));
		 Thread.sleep(3000);
		 Library.Comboclick(element.getSourcesofLead(),config.getconfigdata("SourcesofLead"),"SourcesofLead");
		 Thread.sleep(3000);
		   Library.ActionClick(element.getLeadDetailNextbtn(),"Lead details NExt Button");
		   Thread.sleep(3000);
		   Library.ActionClick(element.getTendorinfoNextbtn(),"Tendor information  NExt Button");
		   Thread.sleep(3000);
		   Library.ActionClick(element.getFOLLOUPQUOTNextbtn(),"Follow up PQ UOT  NExt Button");
		   Thread.sleep(3000);
		   //1 st Item add into lead entry
		   
		   Library.ActionClick(element.getaDDNEWbtn(),"Add new  Button");
		   Thread.sleep(3000);
		 //  WebElement serchbtn=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));
		   searchwindowpopup1(element.getSalesitmserachbtn1(),config.getconfigdata("ITEM1"));
		   
		   Thread.sleep(3000);
		   
		   
		   
		   WebElement horizontalscroll=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscroll);
	        	 Library.dClick(horizontalscroll, "Horizontal Scroll Button");
	        	
	        	}
		   Library.dClick(element.getQuantityField1(),"Quantity Field for 1st item");
		   Thread.sleep(3000);
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity1"));
		   
		   //2nd item add into Lead Entry 
		   
		   Library.ActionClick(element.getaDDNEWbtn(),"Add new  Button");
		   Thread.sleep(3000);
		  // WebElement serchbtn2=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[3]"));
		   searchwindowpopup2(element.getSalesitmserachbtn2(),config.getconfigdata("ITEM2"));
		//   JQXGRID.JQXDIRECTITEMSearch(element.getSalesitmserachbtn2(),config.getconfigdata("ITEM2"));
		   Thread.sleep(3000);
		   WebElement horizontalscrol2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscrol2);
	        	 Library.dClick(horizontalscrol2, "Horizontal Scroll Button");
	        	
	        	}
	         
	         Thread.sleep(3000);
		   Library.dClick(element.getQuantityField2(),"Quantity Field for 2st item");
		   Thread.sleep(3000);
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity2"));
		   Library.Scrolldown(0, 30);
		   Robot robot1 = new Robot();
			Thread.sleep(1000);
	        robot1.keyPress(KeyEvent.VK_ENTER);
	        robot1.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(1000);
		   Thread.sleep(3000);
		   Library.Scrolldown(0,-600);
		   Library.custom_click(element.getSAVEBUTTON(), "SaveButton");
		   Thread.sleep(10000);

		   Actions action =new Actions(driver);
		
		   WebElement Leadnumber=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
		  Library.Explicitlywait(Leadnumber);
		   Library.info(Leadnumber,"Lead Number ");
		   action.moveToElement( Leadnumber).doubleClick( Leadnumber).build().perform();
		   Thread.sleep(3000);

//		  
		   Thread.sleep(3000);

			   
	      WebElement editbtn=driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']")) ;  
//		   
//		
               action.moveToElement( editbtn).doubleClick( editbtn).build().perform();
                        Thread.sleep(3000);
              Library.ActionClick(element.getCstmrandsalesDetailNextbtn(),"GRN field NExt Button");
	
         	 Library.Comboclick(element.getSourcesofLead(),config.getconfigdata("SourcesofLeadedit"),"SourcesofLead");
	
         	 Library.ActionClick(element.getLeadDetailNextbtn(),"Lead details NExt Button");
  		   Thread.sleep(3000);
  		   Library.ActionClick(element.getTendorinfoNextbtn(),"Tendor information  NExt Button");
  		   Thread.sleep(3000);
  		   Library.ActionClick(element.getFOLLOUPQUOTNextbtn(),"Follow up PQ UOT  NExt Button");
  		   Thread.sleep(3000);
  		   
  		 
		   WebElement horizontalscroll1=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
	         
	         for (int i=0; i<50;i++) {
	        	 Thread.sleep(100);
	        	 Library.Explicitlywait(horizontalscroll1);
	        	 Library.dClick(horizontalscroll1, "Horizontal Scroll Button");
	        	
	        	}
		   Library.dClick(element.getQuantityField1(),"Quantity Field for 1st item");
		   Thread.sleep(3000);
		   element.getQuantityFieldtxtbox().clear();
		   JQXGRID.Qtybox(element.getQuantityFieldtxtbox(),config.getconfigdata("Quantity1edit"));
		   Thread.sleep(1000);
	        robot1.keyPress(KeyEvent.VK_ENTER);
	        robot1.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(1000);
		   
	        Thread.sleep(3000);
			   Library.Scrolldown(0,-600);
			   Library.custom_click(element.getSAVEBUTTON(), "SaveButton");
			   Thread.sleep(10000);
			   
			   WebElement Leadnumber1=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));  
			   Library.Explicitlywait(Leadnumber1);
			   action.moveToElement(Leadnumber1);
			   Library.info(Leadnumber1,"Lead Number ");
			 //  action.moveToElement( Leadnumber1).doubleClick( Leadnumber1).build().perform();
			   Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Common Methods for test script
	
	public static void searchwindowpopup1(WebElement element,String optionname) {
		//Explicitlywait(element);
		
		try {
			
			Library.dClick(element);
			
			WebElement itemsearch=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
			Thread.sleep(6000);
			Library.custom_Sendkeys(itemsearch, optionname, "Item code Seacrch text box");
			Thread.sleep(6000);
			WebElement itemsearchbtn=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));
			Library.ActionClick(itemsearchbtn,"itemsearchbtn");
			//Library.dClick(itemsearchbtn);
			Thread.sleep(5000);
			WebElement selectitem=driver.findElement(By.xpath("//div[text()='"+optionname+"']"));
			Thread.sleep(6000);
			Library.dClick(selectitem);
			Library.dClick(selectitem);
			Library.test.log(Status.PASS,"option succesfully selected=="+selectitem.getText());
		}
		
		catch(Exception e) {
			//test.log(Status.FAIL, "No such option");
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void searchwindowpopup2(WebElement element,String optionname) {
		//Explicitlywait(element);
		
		try {
			
			Library.dClick(element);
			
			WebElement itemsearch=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
			Thread.sleep(6000);
			Library.custom_Sendkeys(itemsearch, optionname, "Item code Seacrch text box");
			Thread.sleep(6000);
			WebElement itemsearchbtn=driver.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));
			Library.ActionClick(itemsearchbtn,"itemsearchbtn");
			//Library.dClick(itemsearchbtn);
			Thread.sleep(5000);
			WebElement selectitem=driver.findElement(By.xpath("//div[text()='"+optionname+"']"));
			Thread.sleep(6000);
			Library.dClick(selectitem);
			Library.dClick(selectitem);
			Library.test.log(Status.PASS,"option succesfully selected=="+selectitem.getText());
		}
		
		catch(Exception e) {
			//test.log(Status.FAIL, "No such option");
			System.out.println(e.getMessage());
		}
	}


}
