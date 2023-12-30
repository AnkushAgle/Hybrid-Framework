package COM.TEST;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pageobject.POMaintenanceNew;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class pomaintenancedirect extends BaseClass {
//	public static ExtentTest test;
	//Please do automation for PO entry (Direct i.e. without indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with 1 delivery schedule).
	//Once finished, we will check
	
	@Test(enabled=false)
	
	public void Test_00() throws Exception {
		//test.log(Status.INFO, "Please do automation for PO entry (Direct i.e. without indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with 1 delivery schedule Once finished, we will check");

		ConfigDataProvider config=new ConfigDataProvider("pomaintenancedirect");
	      Library.login("pomaintenancedirect");
		
		POMaintenanceNew element=PageFactory.initElements(driver,POMaintenanceNew.class);
		
		Library.custom_click(element.getPurchasemodule(),"Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(),"Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(),"Add New Btn");
		Library.Explicitlywait(element.getPOBASIS());
		Library.Comboclick(element.getPOBASIS(), config.getconfigdata("POBASIS"),"PO BAsis");
		Thread.sleep(5000);
		Library.Explicitlywait(element.getPODATE());
		
		calendar.daypicker(element.getPODATE(),config.getconfigdata("DAY"),config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
		
		 Library.dClick(element.getPOINFONEXTBTN(),"PO Next Button");
			//Library.dClick(element.getVendoraddsearchbtn());
		 Thread.sleep(5000);
		 WebElement vendorsearch=driver.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		 Library.Explicitlywait(vendorsearch);
		 Thread.sleep(5000);
		 vendorsearch.click();
		 vendorsearch.sendKeys(config.getconfigdata("Vendor"));
		 vendorsearch.sendKeys(Keys.ENTER);
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
	     Thread.sleep(5000);
	       Library.Scrolldown(0, 30);
//	 		Library.Explicitlywait(element.getVendoraddsearchbtn());
//	 		
//			Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
//			
//			
//			
//			Library.Explicitlywait(element.getBuyer());
			Library.Comboclick(element.getBuyer(),config.getconfigdata("Buyer"),"buyer");
			Library.dClick(element.getVendorInfoNextBtn(),"VendorInfoNextBtn()");
			Library.Explicitlywait(element.getRateStructure());
			Library.Comboclick(element.getRateStructure(),config.getconfigdata("RateStructure"), "Structure rate");
			Thread.sleep(3000);
			Library.dClick(element.getRateStryctureNextBtn(),"RateStryctureNextBtn");
			
			Thread.sleep(5000);
			Library.dClick(element.getItemandindentaddnewbtn(),"Add New BTN");
//			
//			WebElement itemsearchbocfiellld=driver.findElement(By.xpath("//input[@class='jqx-input-imms jqx-widget-content-imms jqx-widget-content jqx-input-widget jqx-input jqx-widget jqx-rc-all jqx-grid-cell-edit']"));
//			Library.Explicitlywait(itemsearchbocfiellld);
//			itemsearchbocfiellld.sendKeys(config.getconfigdata("ITEMCODE"));
			
//			//div[contains(@id,'row0jqxWidget')]/div[6]/input
			Thread.sleep(3000);
			WebElement FirstItembtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
			Library.Explicitlywait(FirstItembtn);
			Thread.sleep(6000);
			FirstItembtn.click();
		//Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
			String itemcode="19021997MCB";
			
			JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
//			WebElement Itemcode=driver.findElement(By.xpath("//div[text()='19021997MCB']"));
//			Library.Explicitlywait(Itemcode);
//			Thread.sleep(6000);
//		
//			Itemcode.click();
//			Itemcode.click();
//			Itemcode.sendKeys(Keys.ENTER);
		Thread.sleep(6000);
		
		WebElement warehousecode=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']"));
			Library.Explicitlywait(warehousecode);
			
			Thread.sleep(12000);
			JQXGRID.JQXDropdown(warehousecode,"MYWAR");
			Thread.sleep(6000);
			
//			WebElement actbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidge')]/div[1]/input"));
//			Library.Explicitlywait(actbtn);
//			actbtn.click();
			
			
			
		
		WebElement Qty=	driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]/div[6]"));
		Library.Explicitlywait(Qty);
		Thread.sleep(3000);
		Actions Act=new Actions(driver);
		if(Qty.isEnabled()) {
			Thread.sleep(3000);
		Act.moveToElement(Qty).click().perform();
		}

		WebElement childadd=	driver.findElement(By.xpath("//button[@id='childadd']"));
		Library.Explicitlywait(childadd);
		childadd.click();
		
		WebElement Qtytxtbox=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		Library.Explicitlywait(Qtytxtbox);
		Thread.sleep(2000);
		Qtytxtbox.sendKeys("10");
		Qtytxtbox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
//		WebElement fcalendor=driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
//		Library.Explicitlywait(fcalendor);
//		Thread.sleep(3000);
//		Library.dClick(fcalendor);
//		WebElement date=driver.findElement(By.xpath("//div[contains(@id,'date')]"));
//		Library.Explicitlywait(date);
//		date.sendKeys("27102022");
		//WebElement childadd=	driver.findElement(By.xpath("//button[@id='childadd']"));
		Library.Explicitlywait(childadd);
		childadd.click();
		Thread.sleep(2000);
		childadd.click();
		
        Thread.sleep(3000);
		WebElement Qtytxtbox1=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		Thread.sleep(3000);
		Library.Explicitlywait(Qtytxtbox1);
		Thread.sleep(2000);
		Qtytxtbox1.sendKeys("10");
		Qtytxtbox1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Library.Explicitlywait(childadd);
		childadd.click();
		Thread.sleep(2000);
		childadd.click();
		
		WebElement Qtytxtbox2=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		Library.Explicitlywait(Qtytxtbox2);
		Thread.sleep(2000);
		Qtytxtbox2.sendKeys("10");
		Qtytxtbox2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Library.Explicitlywait(childadd);
	
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		Library.dClick(element.getItemandindentaddnewbtn(),"Add New BTN");
		Thread.sleep(3000);
		WebElement secondItembtn=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]/div[7]"));
		Library.Explicitlywait(secondItembtn);
		Thread.sleep(6000);
		secondItembtn.click();
	//Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
		String itemcode2="19021997PB1";
		
		JQXGRID.JQXDIRECTITEM(secondItembtn, itemcode2);
           Thread.sleep(6000);
		Thread.sleep(3000);
		WebElement warehousecode1=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']"));
			Library.Explicitlywait(warehousecode1);
			
			Thread.sleep(12000);
			JQXGRID.JQXDropdown(warehousecode1,"MYWAR");
			Thread.sleep(6000);
		//childadd.click();

			//WebElement childadd=	driver.findElement(By.xpath("//button[@id='childadd']"));
			Library.Explicitlywait(childadd);
			childadd.click();
			
			WebElement Qtytxtbox3=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
			Library.Explicitlywait(Qtytxtbox3);
			Thread.sleep(2000);
			Qtytxtbox3.sendKeys("10");
			Qtytxtbox3.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
//		WebElement purrateinput=driver.findElement(By.xpath("//div[contains(@id,'purrate')]/input"));
//		Library.Explicitlywait(purrateinput);
//		purrateinput.sendKeys("1");
//		purrateinput.sendKeys(Keys.ENTER);
//		Thread.sleep(3000);	
//		WebElement disctype=driver.findElement(By.xpath("//div[contains(@id,'disctype')]"));
//		Library.Explicitlywait(disctype);
//        Thread.sleep(2000);
//       JQXGRID.JQXDropdown(disctype,"None");     
//       Thread.sleep(2500);
//       
//      WebElement Quantity= driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[4]"));
//			
//	WebElement FirstItembtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
//			Thread.sleep(6000);
//			Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
//		Thread.sleep(6000);
//			WebElement JQXDropdown=driver.findElement(By.xpath("//div[contains(@id,'dropdownlistWrapperdropdownlistedit')]"));
//			Thread.sleep(12000);
//			JQXGRID.JQXDropdown(JQXDropdown,"MYWAR");
//		    Library.Scrolldown(0, 100);
//		    Thread.sleep(3000);
//			
//			WebElement serchitmbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
//			
//			WebElement ele=driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[5]"));
//			System.out.println(config.getconfigdata("QtyPUOM"));
//			
//			JQXGRID.JQXDropdown(ele,"MYWAR");
		
		
		  Library.Scrolldown(0, -600);
	        
	        Library.dClick(element.getSAVEBTN(),"Save button");
	      Thread.sleep(8000);
//		
	      
	      WebElement Ponumber=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
	      Library.Explicitlywait(Ponumber);
	      Thread.sleep(2000);
	      Library.info(Ponumber, "PO NUmber");
	      WebElement Authorizecheckbox=driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

	      Thread.sleep(5000);
	      Thread.sleep(3000);
	      Authorizecheckbox.click();
	   //   Library.dClick(Authorizecheckbox,"Authorization check box");

	      Thread.sleep(5000);
	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	     Thread.sleep(5000);
	     //  Library.Explicitlywait(Authorizebtn);
	    //  Library.dClick(Authorizebtn,"Authorization Button");
	     Authorizebtn.click();
	}

	
	
	
	@Test
	
	public void Test_01() throws Exception {
		
		//test.log(Status.INFO, "Please do automation for PO entry (Direct i.e. without indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with 1 delivery schedule Once finished, we will check");

		
		String testcasename="automation for PO entry (Direct i.e. without indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with 1 delivery schedule";
				ConfigDataProvider config=new ConfigDataProvider("pomaintenancedirect");
			      Library.login("pomaintenancedirect",testcasename);
				
				POMaintenanceNew element=PageFactory.initElements(driver,POMaintenanceNew.class);
				
				Library.custom_click(element.getPurchasemodule(),"Purchasemodule");
				Library.custom_click(element.getPOMaintenanceNew(),"Po  mainteance New");
				Library.custom_click(element.getPOaddnewbutton(),"Add New Btn");
				Thread.sleep(4000);
				Library.Explicitlywait(element.getPOBASIS());
				Library.Comboclick(element.getPOBASIS(), config.getconfigdata("POBASIS"),"PO BAsis");
				Thread.sleep(5000);
				Library.Explicitlywait(element.getPODATE());
				
				calendar.daypicker(element.getPODATE(),config.getconfigdata("DAY"),config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
				
				 Library.dClick(element.getPOINFONEXTBTN(),"PO Next Button");
					//Library.dClick(element.getVendoraddsearchbtn());
				 Thread.sleep(5000);
				 WebElement vendorsearch=driver.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
				 Library.Explicitlywait(vendorsearch);
				 Thread.sleep(5000);
				 vendorsearch.click();
				 vendorsearch.sendKeys(config.getconfigdata("Vendor"));
				 vendorsearch.sendKeys(Keys.ENTER);
//				 JavascriptExecutor js = (JavascriptExecutor)driver;
			     Thread.sleep(5000);
			       Library.Scrolldown(0, 30);
//			 		Library.Explicitlywait(element.getVendoraddsearchbtn());
//			 		
//					Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
//					
//					
//					
//					Library.Explicitlywait(element.getBuyer());
					Library.Comboclick(element.getBuyer(),config.getconfigdata("Buyer"),"buyer");
					Library.dClick(element.getVendorInfoNextBtn(),"VendorInfoNextBtn()");
					Library.Explicitlywait(element.getRateStructure());
					Library.Comboclick(element.getRateStructure(),config.getconfigdata("RateStructure"), "Structure rate");
					Thread.sleep(3000);
					Library.dClick(element.getRateStryctureNextBtn(),"RateStryctureNextBtn");
					
					Thread.sleep(5000);
					Library.dClick(element.getItemandindentaddnewbtn(),"Add New BTN");
//					
//					WebElement itemsearchbocfiellld=driver.findElement(By.xpath("//input[@class='jqx-input-imms jqx-widget-content-imms jqx-widget-content jqx-input-widget jqx-input jqx-widget jqx-rc-all jqx-grid-cell-edit']"));
//					Library.Explicitlywait(itemsearchbocfiellld);
//					itemsearchbocfiellld.sendKeys(config.getconfigdata("ITEMCODE"));
					
//					//div[contains(@id,'row0jqxWidget')]/div[6]/input
					Thread.sleep(3000);
					WebElement FirstItembtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
					//Library.Explicitlywait(FirstItembtn);
					Thread.sleep(6000);
					FirstItembtn.click();
				//Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
					String itemcode=config.getconfigdata("ITEMCODE1");
					
					JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
//					WebElement Itemcode=driver.findElement(By.xpath("//div[text()='19021997MCB']"));
//					Library.Explicitlywait(Itemcode);
//					Thread.sleep(6000);
//				
//					Itemcode.click();
//					Itemcode.click();
//					Itemcode.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				
				WebElement warehousecode=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']"));
					Library.Explicitlywait(warehousecode);
					
					Thread.sleep(12000);
					JQXGRID.JQXDropdown(warehousecode,config.getconfigdata("WAREHOUSECODE"));
					Thread.sleep(6000);
					
//					WebElement actbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidge')]/div[1]/input"));
//					Library.Explicitlywait(actbtn);
//					actbtn.click();
					
					
					
				
				WebElement Qty=	driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]/div[6]"));
				Library.Explicitlywait(Qty);
				Thread.sleep(3000);
				Actions Act=new Actions(driver);
				if(Qty.isEnabled()) {
					Thread.sleep(3000);
				Act.moveToElement(Qty).click().perform();
				}

				WebElement childadd=	driver.findElement(By.xpath("//button[@id='childadd']"));
				Library.Explicitlywait(childadd);
				childadd.click();
				
				WebElement Qtytxtbox=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
				JQXGRID.Qtybox(Qtytxtbox,config.getconfigdata("Qty4"));
				Thread.sleep(3000);
//				
		WebElement fcalendor=driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				
				JQXGRID.Jcalendarsendkeys(fcalendor,config.getconfigdata("firstdate"));
//		Library.Explicitlywait(fcalendor);
//			Thread.sleep(3000);
//			Library.dClick(fcalendor);
//			Library.dClick(fcalendor);
//			
//			WebElement date=driver.findElement(By.xpath("//input[contains(@id,'date')]"));
//			Library.Explicitlywait(date);
//			date.sendKeys("27102022");
//			
//			date.sendKeys(Keys.ENTER);
//	WebElement childadd=	driver.findElement(By.xpath("//button[@id='childadd']"));
				Library.Explicitlywait(childadd);
				childadd.click();
				Thread.sleep(2000);
				childadd.click();
				
		        Thread.sleep(3000);
				WebElement Qtytxtbox1=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
				JQXGRID.Qtybox(Qtytxtbox1,config.getconfigdata("Qty1"));
				
				WebElement fcalendor1=driver.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[1]"));
						
				JQXGRID.Jcalendarsendkeys(fcalendor1,config.getconfigdata("seconddate"));
				Thread.sleep(3000);
				Library.Explicitlywait(childadd);
				childadd.click();
				Thread.sleep(2000);
				childadd.click();
				
				WebElement Qtytxtbox2=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
				JQXGRID.Qtybox(Qtytxtbox2,config.getconfigdata("Qty2"));
				
				WebElement fcalendor2=driver.findElement(By.xpath("(//div[contains(@id,'row2jqxWidget')]/div[8])[1]"));
						
						JQXGRID.Jcalendarsendkeys(fcalendor2,config.getconfigdata("thirddate"));
				Library.Explicitlywait(childadd);
			
				Thread.sleep(2000);
				
				Thread.sleep(5000);
				Library.dClick(element.getItemandindentaddnewbtn(),"Add New BTN");
				Thread.sleep(3000);
				WebElement secondItembtn=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]/div[7]"));
				//Library.Explicitlywait(secondItembtn);
				Thread.sleep(6000);
				//secondItembtn.click();
			//Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
				String itemcode2=config.getconfigdata("ITEMCODE2");
				
				JQXGRID.JQXDIRECTITEM(secondItembtn, itemcode2);
		           Thread.sleep(6000);
				Thread.sleep(3000);
				WebElement warehousecode1=driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']"));
					Library.Explicitlywait(warehousecode1);
					
					Thread.sleep(12000);
					JQXGRID.JQXDropdown(warehousecode1,"MYWAR");
					Thread.sleep(6000);
				//childadd.click();

					//WebElement childadd=	driver.findElement(By.xpath("//button[@id='childadd']"));
					Library.Explicitlywait(childadd);
					childadd.click();
					
					WebElement Qtytxtbox3=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
					JQXGRID.Qtybox(Qtytxtbox3,config.getconfigdata("Qty3"));
					Thread.sleep(3000);
					WebElement fcalendor4=driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					
					JQXGRID.Jcalendarsendkeys(fcalendor4,config.getconfigdata("fourthdate"));
//				WebElement purrateinput=driver.findElement(By.xpath("//div[contains(@id,'purrate')]/input"));
//				Library.Explicitlywait(purrateinput);
//				purrateinput.sendKeys("1");
//				purrateinput.sendKeys(Keys.ENTER);
//				Thread.sleep(3000);	
//				WebElement disctype=driver.findElement(By.xpath("//div[contains(@id,'disctype')]"));
//				Library.Explicitlywait(disctype);
//		        Thread.sleep(2000);
//		       JQXGRID.JQXDropdown(disctype,"None");     
//		       Thread.sleep(2500);
//		       
//		      WebElement Quantity= driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[4]"));
//					
//			WebElement FirstItembtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
//					Thread.sleep(6000);
//					Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
//				Thread.sleep(6000);
//					WebElement JQXDropdown=driver.findElement(By.xpath("//div[contains(@id,'dropdownlistWrapperdropdownlistedit')]"));
//					Thread.sleep(12000);
//					JQXGRID.JQXDropdown(JQXDropdown,"MYWAR");
//				    Library.Scrolldown(0, 100);
//				    Thread.sleep(3000);
//					
//					WebElement serchitmbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
//					
//					WebElement ele=driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[5]"));
//					System.out.println(config.getconfigdata("QtyPUOM"));
//					
//					JQXGRID.JQXDropdown(ele,"MYWAR");
				
				
				  Library.Scrolldown(0, -600);
			        
			        Library.dClick(element.getSAVEBTN(),"Save button");
			      Thread.sleep(8000);
//				
			      
			      WebElement Ponumber=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			      Library.Explicitlywait(Ponumber);
			      Thread.sleep(2000);
			      Library.info(Ponumber, "PO NUmber");
			      WebElement Authorizecheckbox=driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

			      //Library.Explicitlywait(Authorizecheckbox);
			      Thread.sleep(6000);
			      Authorizecheckbox.click();
			      //Library.dClick(Authorizecheckbox,"Authorization check box");

			      Thread.sleep(5000);
			     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
			     Thread.sleep(5000);
			     Authorizebtn.click(); 
			    //Library.dClick(Authorizebtn,"Authorization Button");
		
	}

}
