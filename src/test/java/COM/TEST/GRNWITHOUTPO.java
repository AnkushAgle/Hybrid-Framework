package COM.TEST;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.storesandinventory.grnwithoutpo;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class GRNWITHOUTPO extends BaseClass {
	 String Documentnumber;
	@Test(enabled=false)
	public void Grnwithoutpo() throws Exception {
		
		
		Library.login("GRNWITHOUTPO");
		
		ConfigDataProvider config=new ConfigDataProvider("GRNWITHOUTPO");
		
		grnwithoutpo element=PageFactory.initElements( driver,grnwithoutpo.class);
		
		Library.custom_click(element.getStoresInventory(),"Stores & Inventory Module");
		Library.custom_click(element.getGrnwithoutpo(),"Grn without Po");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbtn(),"Add New Button");
	                 Thread.sleep(10000);
	                  Library.Explicitlywait(element.getGnrwopoGroup());
		//Library.Comboclick(element.getGnrwopoGroup(),config.getconfigdata("gnrwopoGroup"), "Group Field");
		System.out.println(config.getconfigdata("gnrwopoGroup"));
		Thread.sleep(3000);
		//Library.Comboclick(element.getGnrwopoSite(),config.getconfigdata("gnrwopoSite"), "Group Site  Field");
		Thread.sleep(6000);
		Library.Scrolldown(0, 50);
		//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-imms jqx-icon-arrow-left jqx-icon-arrow-left-imms']
	 	Library.Explicitlywait(element.getCalendor());
		Library.dClick(element.getCalendor(),"Calendor Field");
		WebElement prebtn=driver.findElement(By.xpath("//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-imms jqx-icon-arrow-left jqx-icon-arrow-left-imms']"));
	//WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
	    Library.dClick(date);
//calendar.daypicker(element.getCalendor(),config.getconfigdata("DATE"), config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
		Thread.sleep(6000);
          Library.searchwindowpopup(element.getVendorsearchbtn(),config.getconfigdata("vendor"));
      	Thread.sleep(6000);
          Library.Comboclick(element.getRateStructure(),config.getconfigdata("ratestucture"), "RAte Stucture Field");
      	Thread.sleep(6000);
          Library.Comboclick(element.getWarehouse(),config.getconfigdata("warehouse"),"WareHouse Field");
      	Thread.sleep(3000);
          Library.dClick(element.getGrnNEXTBTN(),"GRN field NExt Button");
      	Thread.sleep(6000);
          Library.dClick(element.getTransportNEXTBTN(),"Transport Next Button");
          
          Library.dClick(element.getItemAddNewbtn(), "Item Add New Button");
          
          JQXGRID.JQXDIRECTITEM(element.getAddnewitemsearchbtn(),config.getconfigdata("itemcode"));
          Thread.sleep(4000);
          JQXGRID.JQXDropdown(element.getPUOM(), config.getconfigdata("PUOM"));
          Thread.sleep(4000);
          
          Library.dClick(element.getPUOMQty(), "PUOM Quantity Field");
          
          WebElement puomQty=driver.findElement(By.xpath("  //div[contains(@id,'puomQty')]/input"));
          Library.Explicitlywait(puomQty);
              Thread.sleep(5000);
              System.out.println(config.getconfigdata("serielnumber"));
              Library.custom_Sendkeys(puomQty, config.getconfigdata("PUOMQty"), "Seriel Numbeer Field");
          
              Robot robot = new Robot();
              robot.keyPress(KeyEvent.VK_ENTER);
              robot.keyRelease(KeyEvent.VK_ENTER);
              Thread.sleep(1000);
       //   JQXGRID.JQXDropdown(element.getPUOMQty(), config.getconfigdata("PUOM"));
          Thread.sleep(6000);
//         WebElement closebtn= driver.findElement(By.xpath("//button[@aria-label='Close button']"));
//         Library.Explicitlywait(closebtn);
//         
//          Thread.sleep(6000);
//          Library.dClick(closebtn,"Close btn Field");
//    WebElement serielnumber=driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='11'])[3]"));   
//    Thread.sleep(6000);
//    Library.Explicitlywait(serielnumber);
//    
//         if(serielnumber.isEnabled()) {
//        	 
//    System.out.println("Seriwl Number Field is Enablde");
//    
//    Actions act=new Actions(driver);
//    
//    act.moveToElement(serielnumber).click().build().perform();
//    Library.Explicitlywait(serielnumber);
//          Thread.sleep(6000);
//         // Library.dClick(serielnumber,"Seriel Number Field");
//         
//        Thread.sleep(3000);
//       WebElement serielnumbertxt=driver.findElement(By.xpath("//input[contains(@id,'serialNo')]"));
//      Library.Explicitlywait(serielnumbertxt);
//          Thread.sleep(5000);
//          System.out.println(config.getconfigdata("serielnumber"));
//          Library.custom_Sendkeys(serielnumbertxt, config.getconfigdata("serielnumber"), "Seriel Numbeer Field");
//          
//        serielnumber.sendKeys(Keys.ENTER);
//         }
//          
//          driver.findElement(By.xpath("//button[text()=' Ok ']")).click();
//          Thread.sleep(3000);
          
         
//         Thread.sleep(3000);
//        WebElement serielnumbertxt=driver.findElement(By.xpath("//div[contains(@id,'puomQty')]/input"));
//       Library.Explicitlywait(serielnumbertxt);
//           Thread.sleep(5000);
//           
//           Library.custom_Sendkeys(serielnumbertxt, config.getconfigdata("serielnumber"), "Seriel Numbeer Field");
           
        //serielnumber.sendKeys(Keys.ENTER);
         Thread.sleep(10000);
         Library.Scrolldown(300, 0);
         
         WebElement horizontalscroll=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
         
         for (int i=0; i<50;i++) {
        	 Library.Explicitlywait(horizontalscroll);
        	 Library.dClick(horizontalscroll, "Horizontal Scroll Button");
        	
        	}
         
         Thread.sleep(5000);
         WebElement basicprize=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='18']"));
          Library.Explicitlywait(basicprize);
          Library.dClick(basicprize,"BAsic Prize");
          Thread.sleep(2000);
          WebElement basicprizefield= driver.findElement(By.xpath("//div[contains(@id,'basicPrice')]/input"));
          
          Library.Explicitlywait(basicprizefield);
          Library.custom_Sendkeys(basicprizefield,config.getconfigdata("basicprize"),"basicprize text field");
          Thread.sleep(4000);
          
          Robot robot1 = new Robot();
          robot1.keyPress(KeyEvent.VK_ENTER);
          robot1.keyRelease(KeyEvent.VK_ENTER);
          Thread.sleep(1000);
          
         Library.Scrolldown(0, -300);
          
          WebElement SAvebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
          
          Thread.sleep(3000);
          Library.custom_click(SAvebtn,"Save Button");
//          
//         WebElement baseprizetextbox= driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));
//          
//          
//          Library.Explicitlywait(baseprizetextbox);
//          Thread.sleep(3000);
//          Library.custom_Sendkeys(baseprizetextbox,config.getconfigdata("BASICPRICE"),"BASIC PRIZE FIELD");
//         
          Thread.sleep(5000);
             // driver.navigate().refresh();
       
          WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
         
         Library.Explicitlywait(checkbox);
         Actions act=new Actions(driver);
   
   act.moveToElement(checkbox).click().build().perform();
        
     //   Library.dClick(checkbox, "Autorization Check box Field");
        Thread.sleep(3000);
      
                    Thread.sleep(5000);
        WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
        Library.Explicitlywait(Authorizebtn);
        act.moveToElement(Authorizebtn).click().build().perform();
       // wait.until(ExpectedConditions.textToBePresentInElement(Authorizebtn, Documentnumber));
        System.out.println("Authorization Button Is Displayed  Enabled");
        
        Thread.sleep(4000);
        WebElement text= driver.findElement(By.xpath("(//div[@class='jqx-grid-cell-left-align'])[4]"));
        Library.info(text,"Document Number ");
        Thread.sleep(4000);
      Documentnumber=  text.getText();
      System.out.println(Documentnumber);

	}
//--------------------------------------------------------------------------------------------------------	
	@Test(enabled=false)
	public void grnwithoutpoedit() throws Exception {
		
		String testcasename="Test Script to View GRN without Po of Latest Generated Document Number";
		
		
                   Library.login("GRNWITHOUTPO",testcasename);
		
		ConfigDataProvider config=new ConfigDataProvider("GRNWITHOUTPO");
		
grnwithoutpo element=PageFactory.initElements( driver,grnwithoutpo.class);

Library.custom_click(element.getStoresInventory(),"Stores & Inventory Module");
Library.custom_click(element.getGrnwithoutpo(),"Grn without Po");
		Thread.sleep(3000);
		//driver.navigate().refresh();
		String Documentnumber1="000031";
		String dnumber="//div[text()='"+Documentnumber1+"']";
		System.out.println(Documentnumber1);
		WebElement DNUM=driver.findElement(By.xpath(dnumber));
		try {
		Library.Explicitlywait(DNUM);
		Library.ActionClick(DNUM, "Documentnumber");
		Library.dClick(DNUM, "Documentnumber");
		Library.dClick(DNUM, "Documentnumber");
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		Thread.sleep(5000);
		for (int i = 0; i <15; i++) {
			Thread.sleep(700);
			Library.Scrolldown(0,30);
		}
		
		

		
		for (int i = 0; i<15; i++) {
			Thread.sleep(700);
			Library.Scrolldown(0,-30);
			
			
			}
		
	}

	
	//_______________________________________________________________________________________________________________________
	@Test(enabled=false)
	
	public void grnwithout() throws Exception {
		String testcasename=" GRN with item with IUOM = PUOM\r\n"
				+ "GRN 2 with item with IUOM <> PUOM\r\n"
				+ "GRN 3 with 1 item QC required = No,   2nd item with QC required = Yes";

		Library.login("GRNWITHOUTPO",testcasename);
		
		ConfigDataProvider config=new ConfigDataProvider("GRNWITHOUTPO");
		
		grnwithoutpo element=PageFactory.initElements( driver,grnwithoutpo.class);
		
		Library.custom_click(element.getStoresInventory(),"Stores & Inventory Module");
		Library.custom_click(element.getGrnwithoutpo(),"Grn without Po");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbtn(),"Add New Button");
	                 Thread.sleep(10000);
	                  Library.Explicitlywait(element.getGnrwopoGroup());
		//Library.Comboclick(element.getGnrwopoGroup(),config.getconfigdata("gnrwopoGroup"), "Group Field");
		System.out.println(config.getconfigdata("gnrwopoGroup"));
		Thread.sleep(3000);
		//Library.Comboclick(element.getGnrwopoSite(),config.getconfigdata("gnrwopoSite"), "Group Site  Field");
		Thread.sleep(6000);
		Library.Scrolldown(0, 50);
		//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-imms jqx-icon-arrow-left jqx-icon-arrow-left-imms']
	 	Library.Explicitlywait(element.getCalendor());
		Library.dClick(element.getCalendor(),"Calendor Field");
		WebElement prebtn=driver.findElement(By.xpath("//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-imms jqx-icon-arrow-left jqx-icon-arrow-left-imms']"));

	Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
	    Library.dClick(date);

		Thread.sleep(6000);
          Library.searchwindowpopup(element.getVendorsearchbtn(),config.getconfigdata("vendor"));
      	Thread.sleep(6000);
          Library.Comboclick(element.getRateStructure(),config.getconfigdata("ratestucture"), "RAte Stucture Field");
      	Thread.sleep(6000);
          Library.Comboclick(element.getWarehouse(),config.getconfigdata("warehouse"),"WareHouse Field");
      	Thread.sleep(3000);
          Library.dClick(element.getGrnNEXTBTN(),"GRN field NExt Button");
      	Thread.sleep(6000);
          Library.dClick(element.getTransportNEXTBTN(),"Transport Next Button");
        //  -------------------------------------------------------------------------------------------------------------------
          //First Item Add Started
          
          Library.dClick(element.getItemAddNewbtn(), "Item Add New Button");
          
          JQXGRID.JQXDIRECTITEM(element.getAddnewitemsearchbtn(),config.getconfigdata("itemcode"));
          Thread.sleep(4000);
          JQXGRID.JQXDropdown(element.getPUOM(), config.getconfigdata("PUOM"));
          Thread.sleep(4000);
          
          Library.dClick(element.getPUOMQty(), "PUOM Quantity Field");
          
          WebElement puomQty=driver.findElement(By.xpath("  //div[contains(@id,'puomQty')]/input"));
          Library.Explicitlywait(puomQty);
              Thread.sleep(5000);
              System.out.println(config.getconfigdata("serielnumber"));
              Library.custom_Sendkeys(puomQty, config.getconfigdata("PUOMQty"), "Seriel Numbeer Field");
          
              Robot robot = new Robot();
              robot.keyPress(KeyEvent.VK_ENTER);
              robot.keyRelease(KeyEvent.VK_ENTER);
              Thread.sleep(1000);
       
          Thread.sleep(6000);
          Thread.sleep(10000);
          Library.Scrolldown(300, 0);
          
          WebElement horizontalscroll=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
          
          for (int i=0; i<50;i++) {
         	 Library.Explicitlywait(horizontalscroll);
         	 Library.dClick(horizontalscroll, "Horizontal Scroll Button");
         	
         	}
          
          Thread.sleep(5000);
          WebElement basicprize=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='18']"));
           Library.Explicitlywait(basicprize);
           Library.dClick(basicprize,"BAsic Prize");
           Thread.sleep(2000);
           WebElement basicprizefield= driver.findElement(By.xpath("//div[contains(@id,'basicPrice')]/input"));
           
           Library.Explicitlywait(basicprizefield);
           Library.custom_Sendkeys(basicprizefield,config.getconfigdata("basicprize"),"basicprize text field");
           Thread.sleep(4000);
           
           Robot robot1 = new Robot();
           robot1.keyPress(KeyEvent.VK_ENTER);
           robot1.keyRelease(KeyEvent.VK_ENTER);
           Thread.sleep(1000);
           
           WebElement horizontalscrollback1=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnUphorizontalScrollBarjqxWidget')]"));
           
           for (int i=0; i<50;i++) {
          	 Library.Explicitlywait(horizontalscrollback1);
          	 Library.dClick(horizontalscrollback1, "Horizontal Scroll Button");
          	
          	}
           //I st Item Add Complited 
           
           //2 nd Add Item
           //--------------------------------------------------------------------------------------------------------
         
           
           Library.dClick(element.getItemAddNewbtn(), "Item Add New Button");
           
           JQXGRID.JQXDIRECTITEM(element.getAddnewitemsearchbtn(),config.getconfigdata("itemcode2"));
           Thread.sleep(4000);
           WebElement PUOM2=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5']"));
           JQXGRID.JQXDropdown(PUOM2, config.getconfigdata("PUOM2"));
           Thread.sleep(4000);
           WebElement PUOMQTY2=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='10']"));
           Library.dClick(PUOMQTY2, "PUOM Quantity Field");
           
           WebElement puomQty2=driver.findElement(By.xpath("//div[contains(@id,'puomQty')]/input"));
           Library.Explicitlywait(puomQty2);
               Thread.sleep(5000);
             //  System.out.println(config.getconfigdata("serielnumber"));
               Library.custom_Sendkeys(puomQty2, config.getconfigdata("PUOMQty2"), "Seriel Numbeer Field");
           
              
               robot.keyPress(KeyEvent.VK_ENTER);
               robot.keyRelease(KeyEvent.VK_ENTER);
               Thread.sleep(1000);
        
           Thread.sleep(6000);
           Thread.sleep(10000);
           Library.Scrolldown(300, 0);
           
           WebElement horizontalscroll2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
           
           for (int i=0; i<50;i++) {
          	 Library.Explicitlywait(horizontalscroll2);
          	 Library.dClick(horizontalscroll2, "Horizontal Scroll Button");
          	
          	}
           
           Thread.sleep(5000);
           WebElement basicprize2=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='18']"));
            Library.Explicitlywait(basicprize2);
            Library.dClick(basicprize2,"BAsic Prize");
            Thread.sleep(2000);
            WebElement basicprizefield2= driver.findElement(By.xpath("//div[contains(@id,'basicPrice')]/input"));
            
            Library.Explicitlywait(basicprizefield2);
            Library.custom_Sendkeys(basicprizefield2,config.getconfigdata("basicprize2"),"basicprize text field");
            Thread.sleep(4000);
            
            Robot robot2 = new Robot();
            robot2.keyPress(KeyEvent.VK_ENTER);
            robot2.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            
            WebElement horizontalscrollback2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnUphorizontalScrollBarjqxWidget')]"));
            
            for (int i=0; i<50;i++) {
           	 Library.Explicitlywait(horizontalscrollback2);
           	 Library.dClick(horizontalscrollback2, "Horizontal Scroll Button");
           	
           	}
           //--------------------------------------------------------------------------------------------------
        //Third Item 
            
            
            
            Library.dClick(element.getItemAddNewbtn(), "Item Add New Button");
            
            JQXGRID.JQXDIRECTITEM(element.getAddnewitemsearchbtn(),config.getconfigdata("itemcode3"));
            Thread.sleep(4000);
            WebElement PUOM3=driver.findElement(By.xpath("//div[contains(@id,'row2jqxWidget')]//div[@columnindex='5']"));
            JQXGRID.JQXDropdown(PUOM3, config.getconfigdata("PUOM3"));
            Thread.sleep(4000);
            WebElement PUOMQTY3=driver.findElement(By.xpath("//div[contains(@id,'row2jqxWidget')]//div[@columnindex='10']"));
            Library.dClick(PUOMQTY3, "PUOM Quantity Field");
            
            WebElement puomQty3=driver.findElement(By.xpath("//div[contains(@id,'puomQty')]/input"));
            Library.Explicitlywait(puomQty3);
                Thread.sleep(5000);
              //  System.out.println(config.getconfigdata("serielnumber"));
                Library.custom_Sendkeys(puomQty3, config.getconfigdata("PUOMQty3"), "Seriel Numbeer Field");
            
               
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(1000);
         
            Thread.sleep(6000);
            Thread.sleep(10000);
            Library.Scrolldown(300, 0);
            
            WebElement horizontalscroll3=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
            
            for (int i=0; i<50;i++) {
           	 Library.Explicitlywait(horizontalscroll3);
           	 Library.dClick(horizontalscroll3, "Horizontal Scroll Button");
           	
           	}
            
            Thread.sleep(5000);
            WebElement basicprize3=driver.findElement(By.xpath("//div[contains(@id,'row2jqxWidget')]//div[@columnindex='18']"));
             Library.Explicitlywait(basicprize3);
             Library.dClick(basicprize3,"BAsic Prize");
             Thread.sleep(2000);
             WebElement basicprizefield3= driver.findElement(By.xpath("//div[contains(@id,'basicPrice')]/input"));
             
             Library.Explicitlywait(basicprizefield3);
             Library.custom_Sendkeys(basicprizefield3,config.getconfigdata("basicprize3"),"basicprize text field");
             Thread.sleep(4000);
             
             Robot robot3 = new Robot();
             robot2.keyPress(KeyEvent.VK_ENTER);
             robot2.keyRelease(KeyEvent.VK_ENTER);
             Thread.sleep(1000);
            
             
             WebElement horizontalscrollback3=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnUphorizontalScrollBarjqxWidget')]"));
             
             for (int i=0; i<50;i++) {
            	 Library.Explicitlywait(horizontalscrollback3);
            	 Library.dClick(horizontalscrollback3, "Horizontal Scroll Button");
            	
            	}
             
            
          //------------------------------------------------------------------------------------------------------  
            
            Library.Scrolldown(0, -300);
           
           WebElement SAvebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
           
           Thread.sleep(3000);
           Library.custom_click(SAvebtn,"Save Button");

  
           Thread.sleep(5000);
         
        
           WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
          
          Library.Explicitlywait(checkbox);
          Actions act=new Actions(driver);
    
    act.moveToElement(checkbox).click().build().perform();
         
   
         Thread.sleep(3000);
       
                     Thread.sleep(5000);
         WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
         Library.Explicitlywait(Authorizebtn);
         act.moveToElement(Authorizebtn).click().build().perform();
   
         System.out.println("Authorization Button Is Displayed  Enabled");
         
         Thread.sleep(4000);
         WebElement text= driver.findElement(By.xpath("(//div[@class='jqx-grid-cell-left-align'])[4]"));
         Library.info(text,"Document Number ");
         Thread.sleep(4000);
       Documentnumber=  text.getText();
       System.out.println(Documentnumber);

	}
	
	
	
	//_______________________________________________________________________________________________________
	
	@Test
	public void GrnWithoutPoedit() throws Exception {
		
		String testcasename="Test Script To Edit GRN without Po Basic Prize=10 after Edit Basic prize=20 for a single item ";

		Library.login("GRNWITHOUTPO",testcasename);
		
		ConfigDataProvider config=new ConfigDataProvider("GRNWITHOUTPO");
		
		grnwithoutpo element=PageFactory.initElements( driver,grnwithoutpo.class);
		
		Library.custom_click(element.getStoresInventory(),"Stores & Inventory Module");
		Library.custom_click(element.getGrnwithoutpo(),"Grn without Po");
		Thread.sleep(3000);
		Library.custom_click(element.getAddnewbtn(),"Add New Button");
	                 Thread.sleep(10000);
	                  Library.Explicitlywait(element.getGnrwopoGroup());
		//Library.Comboclick(element.getGnrwopoGroup(),config.getconfigdata("gnrwopoGroup"), "Group Field");
		System.out.println(config.getconfigdata("gnrwopoGroup"));
		Thread.sleep(3000);
		//Library.Comboclick(element.getGnrwopoSite(),config.getconfigdata("gnrwopoSite"), "Group Site  Field");
		Thread.sleep(6000);
		Library.Scrolldown(0, 50);
		//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-imms jqx-icon-arrow-left jqx-icon-arrow-left-imms']
	 	Library.Explicitlywait(element.getCalendor());
		Library.dClick(element.getCalendor(),"Calendor Field");
		WebElement prebtn=driver.findElement(By.xpath("//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-imms jqx-icon-arrow-left jqx-icon-arrow-left-imms']"));

	Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
	    Library.dClick(date);

		Thread.sleep(6000);
          Library.searchwindowpopup(element.getVendorsearchbtn(),config.getconfigdata("vendor"));
      	Thread.sleep(6000);
          Library.Comboclick(element.getRateStructure(),config.getconfigdata("ratestucture"), "RAte Stucture Field");
      	Thread.sleep(6000);
          Library.Comboclick(element.getWarehouse(),config.getconfigdata("warehouse"),"WareHouse Field");
      	Thread.sleep(3000);
          Library.dClick(element.getGrnNEXTBTN(),"GRN field NExt Button");
      	Thread.sleep(6000);
          Library.dClick(element.getTransportNEXTBTN(),"Transport Next Button");
       
          Library.dClick(element.getItemAddNewbtn(), "Item Add New Button");
          
          JQXGRID.JQXDIRECTITEM(element.getAddnewitemsearchbtn(),config.getconfigdata("itemcode"));
          Thread.sleep(4000);
          JQXGRID.JQXDropdown(element.getPUOM(), config.getconfigdata("PUOM"));
          Thread.sleep(4000);
          
          Library.dClick(element.getPUOMQty(), "PUOM Quantity Field");
          
          WebElement puomQty=driver.findElement(By.xpath("  //div[contains(@id,'puomQty')]/input"));
          Library.Explicitlywait(puomQty);
              Thread.sleep(5000);
              System.out.println(config.getconfigdata("serielnumber"));
              Library.custom_Sendkeys(puomQty, config.getconfigdata("PUOMQty"), "Seriel Numbeer Field");
          
              Robot robot = new Robot();
              robot.keyPress(KeyEvent.VK_ENTER);
              robot.keyRelease(KeyEvent.VK_ENTER);
              Thread.sleep(1000);
       
          Thread.sleep(6000);
          Thread.sleep(10000);
          Library.Scrolldown(300, 0);
          
          WebElement horizontalscroll=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
          
          for (int i=0; i<50;i++) {
         	 Library.Explicitlywait(horizontalscroll);
         	 Library.dClick(horizontalscroll, "Horizontal Scroll Button");
         	
         	}
          
          Thread.sleep(5000);
          WebElement basicprize=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='18']"));
           Library.Explicitlywait(basicprize);
           Library.dClick(basicprize,"BAsic Prize");
           Thread.sleep(2000);
           WebElement basicprizefield= driver.findElement(By.xpath("//div[contains(@id,'basicPrice')]/input"));
           
           Library.Explicitlywait(basicprizefield);
           Library.custom_Sendkeys(basicprizefield,config.getconfigdata("basicprize"),"basicprize text field");
           Thread.sleep(4000);
           
           Robot robot1 = new Robot();
           robot1.keyPress(KeyEvent.VK_ENTER);
           robot1.keyRelease(KeyEvent.VK_ENTER);
           Thread.sleep(1000);
           
           WebElement horizontalscrollback1=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnUphorizontalScrollBarjqxWidget')]"));
           
           for (int i=0; i<50;i++) {
          	 Library.Explicitlywait(horizontalscrollback1);
          	 Library.dClick(horizontalscrollback1, "Horizontal Scroll Button");
          		}
           
           
           Library.Scrolldown(0, -300);
            
            WebElement SAvebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
            
            Thread.sleep(3000);
            Library.custom_click(SAvebtn,"Save Button");
           
            Thread.sleep(6000);
            
          WebElement edit=driver.findElement(By.xpath("//a[contains(@id,'jqxWidget')]"));
          Library.Explicitlywait(edit);
          
          Library.ActionClick(edit,"Edit Button");
          
          Thread.sleep(6000);
          Library.Scrolldown(0, 45);
          WebElement GRNnextbtn=element.getGrnNEXTBTN();
          Library.dClick(GRNnextbtn,"GRN field NExt Button");
      	Thread.sleep(6000);
      WebElement TransportNEXTBTN=element.getTransportNEXTBTN();
          Library.dClick(TransportNEXTBTN,"Transport Next Button");
          
          Thread.sleep(10000);
        //  Library.Scrolldown(300, 0);
          
          WebElement horizontalscroll2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));
          
          for (int i=0; i<50;i++) {
         	 Library.Explicitlywait(horizontalscroll2);
         	 Library.dClick(horizontalscroll2, "Horizontal Scroll Button");
         	
         	}
          
          Thread.sleep(5000);
          WebElement basicprize2=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='18']"));
           Library.Explicitlywait(basicprize2);
           Library.dClick(basicprize2,"BAsic Prize");
           Thread.sleep(2000);
           WebElement basicprizefield2= driver.findElement(By.xpath("//div[contains(@id,'basicPrice')]/input"));
           
           Library.Explicitlywait(basicprizefield2);
           Library.custom_Sendkeys(basicprizefield2,config.getconfigdata("editbasicprize"),"basicprize text field");
           Thread.sleep(4000);
           
           Robot robot2 = new Robot();
           robot2.keyPress(KeyEvent.VK_ENTER);
           robot2.keyRelease(KeyEvent.VK_ENTER);
           Thread.sleep(1000);
           
           WebElement horizontalscrollback2=  driver.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnUphorizontalScrollBarjqxWidget')]"));
           
           for (int i=0; i<50;i++) {
          	 Library.Explicitlywait(horizontalscrollback2);
          	 Library.dClick(horizontalscrollback2, "Horizontal Scroll Button");
          	
          	
          	}
  Library.Scrolldown(0, -300);
           
           WebElement SAvebtn1=driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
           
           Thread.sleep(3000);
           Library.custom_click(SAvebtn1,"Save Button");

  
           Thread.sleep(5000);
         
        
           WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
          
          Library.Explicitlywait(checkbox);
          Actions act=new Actions(driver);
    
    act.moveToElement(checkbox).click().build().perform();
         
   
         Thread.sleep(3000);
       
                     Thread.sleep(5000);
         WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
         Library.Explicitlywait(Authorizebtn);
         act.moveToElement(Authorizebtn).click().build().perform();
   
         System.out.println("Authorization Button Is Displayed  Enabled");
         
         Thread.sleep(4000);
         WebElement text= driver.findElement(By.xpath("(//div[@class='jqx-grid-cell-left-align'])[4]"));
         Library.info(text,"Document Number ");
         Thread.sleep(4000);
       Documentnumber=  text.getText();
       System.out.println(Documentnumber);

	}
}
