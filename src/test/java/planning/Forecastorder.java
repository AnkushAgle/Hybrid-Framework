package planning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageobject.Indententrypom;
import com.planningpom.ForecastOrder;
import com.utility.BaseClass;
import com.utility.ExcelDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.Takescrnshot;
import com.utility.calendar;

public class Forecastorder extends BaseClass {
	
	@Test(enabled=false)
	public void forecastorderbasicentry() throws Exception {
		
		
		String testcasename="test script for forecast entry of three items ";
		ExcelDataProvider excel=new ExcelDataProvider("planning","forecastorder");
	//1)Login into application	
		
		Library.login("planning","forecastorder",testcasename);
		
		ForecastOrder element=	PageFactory.initElements(driver, ForecastOrder.class);
	
	Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//planning main mopdule click
	Library.custom_click(element.getFORECASTORDER(),"Forecastorder");//Forecast Order module click
	Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
	Thread.sleep(8000);
	
	
	String Group=excel.getStringdata("Sheet1", 1, 1/* colum constatnt for group*/);//Group in first row
	Library.Comboclick(element.getGroupforecast(), Group," Forecast order Group");
	Thread.sleep(3000);
	

String Site=excel.getStringdata("Sheet1", 1, 2/* colum constatnt for site*/);//Site in first row
	System.out.println(excel.getStringdata("Sheet1", 1, 2));
	
	Thread.sleep(3000);
	Library.Comboclick(element.getSiteforecast(), Site, "Forecast Order Site");
		Thread.sleep(3000);
		String date=excel.getStringnumberdata("Sheet1", 1, 3/* colum constatnt for date*/);//Site in first row
	System.out.println(date);
		String month=excel.getStringdata("Sheet1", 1, 4/* colum constatnt for month*/);
		
		System.out.println(month);
		String Year=excel.getStringnumberdata("Sheet1", 1, 5/* colum constatnt for year*/);
		
		System.out.println(Year);
		Thread.sleep(3000);
		
		calendar.daypicker(element.getFCcalendar(), date, month,Year);
		
		Library.dClick(element.getForecastOrderDetailsNEXTBTUUTON(),"ForeCast  Order Next Button");
		Thread.sleep(3000);
		
		Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
		
		// 1st item adding in Forecast Order entry
		Thread.sleep(3000);
		JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn1(),excel.getStringdata("Sheet1", 1, 6));
			Thread.sleep(3000);
			
			try {
				
				WebElement closebtn=driver.findElement(By.xpath("//button[@class='close']"));
				closebtn.click();
			}
			catch(Exception e) {
				
				System.out.println(e.getMessage());
			}
			Library.dClick(element.getoRDERqUANTITY1(), "Order quantity 1");
			Thread.sleep(3000);
			String quantity1r=excel.getStringnumberdata("Sheet1", 1, 7/* colum constatnt for Quantity Field*/);
			Library.custom_Sendkeys(element.getQUANTITYINPUT(), quantity1r, "Quantity of 1st Item ");
			element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
			
			Library.horizontalscroll(7);
			Library.dClick(element.getOrderDeliveryDate1(), quantity1r);
			String deliverydate1=excel.getStringnumberdata("Sheet1", 1, 8/* colum constatnt for Quantity Field*/);
			
			WebElement Ddate1=driver.findElement(By.xpath("(//td[text()='"+deliverydate1+"'])[2]"));
			Library.dClick(Ddate1, "Delivery Date For 1 st Item");
	
		
		
		
		
			// 2nd item adding in Forecast Order entry	
			
			Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
			JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn2(),excel.getStringdata("Sheet1", 2, 6));
				Thread.sleep(3000);
				
				try {
					Thread.sleep(3000);
					WebElement closebtn1=driver.findElement(By.xpath("//button[@class='close']"));
					Thread.sleep(1000);
					closebtn1.click();
				}
				catch(Exception e) {
					
					System.out.println(e.getMessage());
				}
				Thread.sleep(1000);
				//Library.dClick(element.getoRDERqUANTITY2(), "Order quantity 2");
				Thread.sleep(3000);
				String quantity2=excel.getStringnumberdata("Sheet1", 2, 7/* colum constatnt for Quantity Field*/);
				Thread.sleep(1000);
				System.out.println("the quantity of 2nd is"+quantity2);
				
				Library.custom_Sendkeys(element.getQUANTITYINPUT(),quantity2,"Quantity of 2nd Item ");
				//element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				Library.horizontalscroll(7);
				
				Library.dClick(element.getOrderDeliveryDate2(), "Order Quantity 2");
				String deliverydate2=excel.getStringnumberdata("Sheet1", 2, 8/* colum constatnt for Quantity Field*/);
				Thread.sleep(3000);
				WebElement Ddate2=driver.findElement(By.xpath("(//td[text()='"+deliverydate2+"'])[3]"));
				Library.dClick(Ddate2, "Delivery Date For 2nd  Item");
			//	Library.dClick(element.getSaVeButton(),"Save Button");
		
				
				
		// 3rd Item Add intp Forecast Order
			
				
				Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
				JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn3(),excel.getStringdata("Sheet1", 3, 6));
					Thread.sleep(3000);
					
					try {
						Thread.sleep(3000);
						WebElement closebtn2=driver.findElement(By.xpath("//button[@class='close']"));
						Thread.sleep(1000);
						closebtn2.click();
					}
					catch(Exception e) {
						
						System.out.println(e.getMessage());
					}
				//	Library.dClick(element.getoRDERqUANTITY3(), "Order quantity 3");
					Thread.sleep(3000);
					String quantity3=excel.getStringnumberdata("Sheet1", 3, 7/* colum constatnt for Quantity Field*/);
					Library.custom_Sendkeys(element.getQUANTITYINPUT(), quantity3, "Quantity of 3rd Item ");
					element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
					
					Library.horizontalscroll(7);
					
					Library.dClick(element.getOrderDeliveryDate3(), "Order Quantity 3");
					String deliverydate3=excel.getStringnumberdata("Sheet1", 3, 8/* colum constatnt for Quantity Field*/);
					Thread.sleep(3000);
					WebElement Ddate3=driver.findElement(By.xpath("(//td[text()='"+deliverydate3+"'])[4]"));
					Library.dClick(Ddate3, "Delivery Date For 3rd  Item");
					Thread.sleep(3000);
					
					
					Library.dClick(element.getSaVeButton(),"Save Button");
					Thread.sleep(3000);
					
					
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
			        
				WebElement Forecastordernium=	driver.findElement(By.xpath("//div[@columnindex='5']//div"));
				Library.Explicitlywait(Forecastordernium);
				Library.info(Forecastordernium,"ForeCastOrder Number");
				
					
	}
	
	@Test(enabled=false)
	public void forecastorderview() throws Exception {
		String testcasename="test script for forecast entry of three items and View Description After that ";
		ExcelDataProvider excel=new ExcelDataProvider("planning","forecastorder");
	//1)Login into application	
		
		Library.login("planning","forecastorder",testcasename);
		
		ForecastOrder element=	PageFactory.initElements(driver, ForecastOrder.class);
	
	Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//planning main mopdule click
	Library.custom_click(element.getFORECASTORDER(),"Forecastorder");//Forecast Order module click
	Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
	Thread.sleep(8000);
	
	
	String Group=excel.getStringdata("Sheet1", 1, 1/* colum constatnt for group*/);//Group in first row
	Library.Comboclick(element.getGroupforecast(), Group," Forecast order Group");
	Thread.sleep(3000);
	

String Site=excel.getStringdata("Sheet1", 1, 2/* colum constatnt for site*/);//Site in first row
	System.out.println(excel.getStringdata("Sheet1", 1, 2));
	
	Thread.sleep(3000);
	Library.Comboclick(element.getSiteforecast(), Site, "Forecast Order Site");
		Thread.sleep(3000);
		String date=excel.getStringnumberdata("Sheet1", 1, 3/* colum constatnt for date*/);//Site in first row
	System.out.println(date);
		String month=excel.getStringdata("Sheet1", 1, 4/* colum constatnt for month*/);
		
		System.out.println(month);
		String Year=excel.getStringnumberdata("Sheet1", 1, 5/* colum constatnt for year*/);
		
		System.out.println(Year);
		Thread.sleep(3000);
		
		calendar.daypicker(element.getFCcalendar(), date, month,Year);
		
		Library.dClick(element.getForecastOrderDetailsNEXTBTUUTON(),"ForeCast  Order Next Button");
		Thread.sleep(3000);
		
		Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
		
		// 1st item adding in Forecast Order entry
		Thread.sleep(3000);
		JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn1(),excel.getStringnumberdata("Sheet1", 4, 6));
			Thread.sleep(3000);
			
			try {
				
				WebElement closebtn=driver.findElement(By.xpath("//button[@class='close']"));
				closebtn.click();
			}
			catch(Exception e) {
				
				System.out.println(e.getMessage());
			}
			Library.dClick(element.getoRDERqUANTITY1(), "Order quantity 1");
			Thread.sleep(3000);
			String quantity1r=excel.getStringnumberdata("Sheet1", 4, 7/* colum constatnt for Quantity Field*/);
			Library.custom_Sendkeys(element.getQUANTITYINPUT(), quantity1r, "Quantity of 1st Item ");
			element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Library.horizontalscroll(7);
			Library.dClick(element.getOrderDeliveryDate1(), quantity1r);
			String deliverydate1=excel.getStringnumberdata("Sheet1", 4, 8/* colum constatnt for Quantity Field*/);
			
			WebElement Ddate1=driver.findElement(By.xpath("(//td[text()='"+deliverydate1+"'])[2]"));
			Library.dClick(Ddate1, "Delivery Date For 1 st Item");
	
		
		
		
		
			// 2nd item adding in Forecast Order entry	
			
			Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
			JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn2(),excel.getStringnumberdata("Sheet1", 5, 6));
				Thread.sleep(3000);
				
				try {
					Thread.sleep(3000);
					WebElement closebtn1=driver.findElement(By.xpath("//button[@class='close']"));
					Thread.sleep(1000);
					closebtn1.click();
				}
				catch(Exception e) {
					
					System.out.println(e.getMessage());
				}
				Thread.sleep(1000);
				Library.dClick(element.getoRDERqUANTITY2(), "Order quantity 2");
				Thread.sleep(2000);
				String quantity2=excel.getStringnumberdata("Sheet1", 5, 7/* colum constatnt for Quantity Field*/);
				Thread.sleep(1000);
				System.out.println("the quantity of 2nd is"+quantity2);
				
				Library.custom_Sendkeys(element.getQUANTITYINPUT(),quantity2,"Quantity of 2nd Item ");
				//element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				Library.horizontalscroll(7);
				
				Library.dClick(element.getOrderDeliveryDate2(), "Order Quantity 2");
				String deliverydate2=excel.getStringnumberdata("Sheet1", 5, 8/* colum constatnt for Quantity Field*/);
				Thread.sleep(3000);
				WebElement Ddate2=driver.findElement(By.xpath("(//td[text()='"+deliverydate2+"'])[4]"));
				Library.dClick(Ddate2, "Delivery Date For 2nd  Item");
			//	Library.dClick(element.getSaVeButton(),"Save Button");
		
				
				
		// 3rd Item Add intp Forecast Order
			
				
				Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
				JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn3(),excel.getStringnumberdata("Sheet1", 6, 6));
					Thread.sleep(3000);
					
					try {
						Thread.sleep(2000);
						WebElement closebtn2=driver.findElement(By.xpath("//button[@class='close']"));
						Thread.sleep(1000);
						closebtn2.click();
					}
					catch(Exception e) {
						
						System.out.println(e.getMessage());
					}
					Library.dClick(element.getoRDERqUANTITY3(), "Order quantity 3");
					Thread.sleep(3000);
					String quantity3=excel.getStringnumberdata("Sheet1", 6, 7/* colum constatnt for Quantity Field*/);
					Library.custom_Sendkeys(element.getQUANTITYINPUT(), quantity3, "Quantity of 3rd Item ");
					element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					Library.horizontalscroll(7);
					
					Library.dClick(element.getOrderDeliveryDate3(), "Order Quantity 3");
					String deliverydate3=excel.getStringnumberdata("Sheet1", 6, 8/* colum constatnt for Quantity Field*/);
					Thread.sleep(3000);
					WebElement Ddate3=driver.findElement(By.xpath("(//td[text()='"+deliverydate3+"'])[4]"));
					Library.dClick(Ddate3, "Delivery Date For 3rd  Item");
					Thread.sleep(3000);
					
					
					Library.dClick(element.getSaVeButton(),"Save Button");
					Thread.sleep(3000);
					
					try {
			           WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
			          
			        //  Library.Explicitlywait(checkbox);
			          Library.dClick(checkbox,"Authorization Checkbox");
					}
					
					catch(Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					
					
			         
			   
			         Thread.sleep(3000);
			      
			         try {
			          WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
			       //  Library.Explicitlywait(Authorizebtn);
			         Library.ActionClick(Authorizebtn,"Authorization Button");
			   
			         System.out.println("Authorization Button Is Displayed  Enabled");
			         
			         Thread.sleep(4000);
			         }
			         catch(Exception e) {
			        	 
			        	 
			        	 System.out.println(e.getMessage());
			         }
			        
			         try {
			        	  WebElement Authorizebtn1=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']")); 
			        	  Authorizebtn1.click();
			         }
			        catch(Exception b){
			        	
			        	System.out.println(b.getMessage());
			        	
			        } 
			         
				WebElement Forecastordernium=driver.findElement(By.xpath("//div[@columnindex='5']//div"));
				Library.Explicitlywait(Forecastordernium);
				Library.info(Forecastordernium,"ForeCastOrder Number");
				Thread.sleep(3000);
					Library.ActionDoubleClick(Forecastordernium, "Foreacst Order Number");
					Thread.sleep(3000);
					WebElement itemdetailsbtn=driver.findElement(By.xpath("//div[@id='ngb-panel-1-header']//button"));
					Library.dClick(itemdetailsbtn, "Item Details Button");
					Library.Scrolldown(0, 50);
					Thread.sleep(3000);
					Thread.sleep(3000);
					Takescrnshot.attachscreenshotreport("ForeCastOrderView");
					Thread.sleep(3000);
					Library.Scrolldown(0, -50);
					driver.navigate().back();
					Thread.sleep(3000);
		
		
	}
	
	
	
	
	@Test
	public void forecastorderedit() throws Exception {
		String testcasename="test script for forecast entry of two service  items After that Edit Quantity for Both ";
		ExcelDataProvider excel=new ExcelDataProvider("planning","forecastorder");
	//1)Login into application	
		
		Library.login("planning","forecastorder",testcasename);
		
		ForecastOrder element=	PageFactory.initElements(driver, ForecastOrder.class);
	
	Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//planning main mopdule click
	Library.custom_click(element.getFORECASTORDER(),"Forecastorder");//Forecast Order module click
	Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
	Thread.sleep(8000);
	
	
	String Group=excel.getStringdata("Sheet1", 1, 1/* colum constatnt for group*/);//Group in first row
	Library.Comboclick(element.getGroupforecast(), Group," Forecast order Group");
	Thread.sleep(3000);
	

String Site=excel.getStringdata("Sheet1", 1, 2/* colum constatnt for site*/);//Site in first row
	System.out.println(excel.getStringdata("Sheet1", 1, 2));
	
	Thread.sleep(3000);
	Library.Comboclick(element.getSiteforecast(), Site, "Forecast Order Site");
		Thread.sleep(3000);
		String date=excel.getStringnumberdata("Sheet1", 1, 3/* colum constatnt for date*/);//Site in first row
	System.out.println(date);
		String month=excel.getStringdata("Sheet1", 1, 4/* colum constatnt for month*/);
		
		System.out.println(month);
		String Year=excel.getStringnumberdata("Sheet1", 1, 5/* colum constatnt for year*/);
		
		System.out.println(Year);
		Thread.sleep(3000);
		
		calendar.daypicker(element.getFCcalendar(), date, month,Year);
		
		Library.dClick(element.getForecastOrderDetailsNEXTBTUUTON(),"ForeCast  Order Next Button");
		Thread.sleep(3000);
		
		Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
	
		
		
		
		
		
		// 1st item adding in Forecast Order entry
		Thread.sleep(3000);
		JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn1(),excel.getStringdata("Sheet1", 7, 6));
			Thread.sleep(3000);
			
			try {
				
				WebElement closebtn=driver.findElement(By.xpath("//button[@class='close']"));
				closebtn.click();
			}
			catch(Exception e) {
				
				System.out.println(e.getMessage());
			}
			Library.dClick(element.getoRDERqUANTITY1(), "Order quantity 1");
			Thread.sleep(3000);
			String quantity1r=excel.getStringnumberdata("Sheet1", 7, 7/* colum constatnt for Quantity Field*/);
			Library.custom_Sendkeys(element.getQUANTITYINPUT(), quantity1r, "Quantity of 1st Item ");
			element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Library.horizontalscroll(7);
			Library.dClick(element.getOrderDeliveryDate1(), quantity1r);
			String deliverydate1=excel.getStringnumberdata("Sheet1", 7, 8/* colum constatnt for Quantity Field*/);
			
			WebElement Ddate1=driver.findElement(By.xpath("(//td[text()='"+deliverydate1+"'])[2]"));
			Library.dClick(Ddate1, "Delivery Date For 1 st Item");
	
		
			
			
			
			
		
		
		
			// 2nd item adding in Forecast Order entry	
			
			Library.dClick(element.getAddnewITEMBTN(),"Add New Item Button ");
			JQXGRID.ITEMSearchPOPUp(element.getSALESITEMCODEsearchbtn2(),excel.getStringdata("Sheet1", 8, 6));
				Thread.sleep(3000);
				
				try {
					Thread.sleep(3000);
					WebElement closebtn1=driver.findElement(By.xpath("//button[@class='close']"));
					Thread.sleep(1000);
					closebtn1.click();
				}
				catch(Exception e) {
					
					System.out.println(e.getMessage());
				}
				Thread.sleep(1000);
				Library.dClick(element.getoRDERqUANTITY2(), "Order quantity 2");
				Thread.sleep(2000);
				String quantity2=excel.getStringnumberdata("Sheet1", 8, 7/* colum constatnt for Quantity Field*/);
				Thread.sleep(1000);
				System.out.println("the quantity of 2nd is"+quantity2);
				
				Library.custom_Sendkeys(element.getQUANTITYINPUT(),quantity2,"Quantity of 2nd Item ");
				//element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				Library.horizontalscroll(7);
				
				Library.dClick(element.getOrderDeliveryDate2(), "Order Quantity 2");
				String deliverydate2=excel.getStringnumberdata("Sheet1", 8, 8/* colum constatnt for Quantity Field*/);
				Thread.sleep(3000);
				WebElement Ddate2=driver.findElement(By.xpath("(//td[text()='"+deliverydate2+"'])[3]"));
				Library.dClick(Ddate2, "Delivery Date For 2nd  Item");
				
			//	Library.dClick(element.getSaVeButton(),"Save Button");
				
				Thread.sleep(4000);
		try {
			
			Library.dClick(element.getSaVeButton(),"Save Button");
			
			           //Thread.sleep(4000);
		             //element.getSaVeButton().click();	
			
		}
		
		catch(Exception e) {
			
//		      
//            Thread.sleep(6000);
//            
//          WebElement edit=driver.findElement(By.xpath("//a[contains(@id,'jqxWidget')]"));
//          Library.Explicitlywait(edit);
//          
//          Library.ActionClick(edit,"Edit Button");
			
		}		
			
		Thread.sleep(4000);
		
		
	try {
			WebElement EditButton=element.getEditButton();
			Library.custom_click(EditButton, "Edit Button");
			Library.ActionDoubleClick(EditButton, "Edit Button");
		
			
		}
		
		catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}			
				
	Thread.sleep(3000);	
	WebElement nextbtn=element.getForecastOrderDetailsNEXTBTUUTON();
	Library.dClick(element.getForecastOrderDetailsNEXTBTUUTON(),"ForeCast  Order Next Button");
	Thread.sleep(3000);
	
	Library.dClick(element.getoRDERqUANTITY1(), "Order quantity 1");
	Thread.sleep(3000);
	String quantity1=excel.getStringnumberdata("Sheet1", 9, 7/* colum constatnt for Quantity Field*/);
	Library.custom_Sendkeys(element.getQUANTITYINPUT(), quantity1, "Quantity of 1st Item ");
	element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	
	Thread.sleep(1000);
	Library.dClick(element.getoRDERqUANTITY2(), "Order quantity 2");
	Thread.sleep(2000);
	String quantityy2=excel.getStringnumberdata("Sheet1", 10, 7/* colum constatnt for Quantity Field*/);
	Thread.sleep(1000);
	System.out.println("the quantity of 2nd is"+quantityy2);
	
	Library.custom_Sendkeys(element.getQUANTITYINPUT(),quantityy2,"Quantity of 2nd Item ");
	//element.getQUANTITYINPUT().sendKeys(Keys.ENTER);
	Thread.sleep(2000);
				
				
	
	
try {
	Library.dClick(element.getSaVeButton(),"Save Button");
//element.getSaVeButton().click();	

}

catch(Exception e) {

System.out.println(e.getMessage());

}		
				
				
				try {
			           WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
			          
			        //  Library.Explicitlywait(checkbox);
			          Library.dClick(checkbox,"Authorization Checkbox");
					}
					
					catch(Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					
					
			         
			   
			         Thread.sleep(3000);
			      
			         try {
			          WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
			       //  Library.Explicitlywait(Authorizebtn);
			         Library.ActionClick(Authorizebtn,"Authorization Button");
			   
			         System.out.println("Authorization Button Is Displayed  Enabled");
			         
			         Thread.sleep(4000);
			         }
			         catch(Exception e) {
			        	 
			        	 
			        	 System.out.println(e.getMessage());
			         }
			        
			         try {
			        	  WebElement Authorizebtn1=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']")); 
			        	  Authorizebtn1.click();
			         }
			        catch(Exception b){
			        	
			        	System.out.println(b.getMessage());
			        	
			        } 
			         
				WebElement Forecastordernium=	driver.findElement(By.xpath("//div[@columnindex='5']//div"));
				Library.Explicitlywait(Forecastordernium);
				Library.info(Forecastordernium,"ForeCastOrder Number");
				Thread.sleep(3000);
					Library.ActionDoubleClick(Forecastordernium, "Foreacst Order Number");
					Thread.sleep(3000);
					WebElement itemdetailsbtn=driver.findElement(By.xpath("//div[@id='ngb-panel-1-header']//button"));
					Library.dClick(itemdetailsbtn, "Item Details Button");
					Library.Scrolldown(0, 50);
					Thread.sleep(3000);
					Thread.sleep(3000);
					//Takescrnshot.attachscreenshotreport("ForeCastOrderView");
					Thread.sleep(3000);
					Library.Scrolldown(0, -50);
					driver.navigate().back();
					Thread.sleep(3000);
		
		
		
	}

}
