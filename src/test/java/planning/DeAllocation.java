package planning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.planningpom.Allocationpom;
import com.planningpom.DeAllocationpom;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.Library;

public class DeAllocation extends BaseClass {
	
	//Planning>Sales/Shop Order Maintenance>DeAllocation

	
	@Test(priority=2)
	public void DeallocationMk() throws Exception {
		
		String testcasename="DeallocationMk of Mk type item";
		
		//1)Login into application	
			
			Library.login("planning","DeallocationMk",testcasename);
			ConfigDataProvider config=new ConfigDataProvider("planning","DeallocationMk");
			
			Library.filelocationConfigreport("planning","DeallocationMk");
			DeAllocationpom element=	PageFactory.initElements(driver, DeAllocationpom.class);

		Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
		Library.custom_click(element.getDeAllocation(),"Deallocation");//Forecast Order module click
	//	Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
	
		String group=config.getconfigdata("group");

		System.out.println(group);
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		Library.dClick(element.getNumberComboBox(),"Number Drop Down");
		Library.custom_Sendkeys(element.getNumberinputField(),config.getconfigdata("number"),"SJO Item Search Field");
			Thread.sleep(3000);
Library.Comboclick(element.getNumberComboBox(), config.getconfigdata("number"),"Number Field");


			Library.dClick(element.getSJODetailsNEXTBTUUTON(),"SJO  Next Button");
			Thread.sleep(3000);	
			Library.dClick(element.getItemandDetailsNEXTBTUUTON(),"Item Details Next Button");
			Thread.sleep(3000);	
			Library.dClick(element.getArrow1(),"parent Item + Arrow1");
			Thread.sleep(3000);
			Library.dClick(element.getArrow2(),"parent Item + Arrow2");
			
			Thread.sleep(3000);
			
			
			
			WebElement parentitemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("parentitem")+"')]"));
			Library.dClick(parentitemcode,"parent Item code");
			WebElement chielditemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("chielditem")+"')]"));
			Library.dClick(chielditemcode,"Chield  Item code");
			Library.ActionDoubleClick(chielditemcode, "Chield Item Code ");
			//Library.dClick(chielditemcode,"Chield  Item code");
			
	

			Thread.sleep(3000);	
			Actions act =new Actions(driver);
			act.moveToElement(chielditemcode).contextClick(chielditemcode).build().perform();
			Thread.sleep(3000);	
			Library.custom_click(element.getDeAllocateItem(),"Deallocate Item");
			Thread.sleep(3000);	
			
			Library.dClick(element.getDeAllocateQuantity(), "Deallocate Quantity");
			
			try {
			Thread.sleep(3000);	
			Library.custom_Sendkeys(element.getDeAllocateinput(),config.getconfigdata("deallocationqty"),"Deallocation Quantity Field QtyField");
			Thread.sleep(3000);	
			Library.ActionDoubleClick(element.getDeAllocateButton(),"DeAllocate Button ");
			Thread.sleep(3000);
			
			//Library.ActionClick(element.getDeAllocateButton(),"DEAllocate Button ");
			
			}
			catch(Exception e) {
				System.out.println(e);
				String msg="Item has no pending requirement!";
				Library.massagelog(msg);
			}
			
			
			try {
				Thread.sleep(3000);
				System.out.println("DEAllocated Quantity Field Input succsesfully");
				System.out.println(config.getconfigdata("deallocationqty"));
				String real=config.getconfigdata("deallocationqty");
				Thread.sleep(1500);
				//String real=allocatedQuantity.getText();
				System.out.println(real);
				if(real==config.getconfigdata("deallocationqty")){
					String msg="DEAllocation for item successfully done!";
					
					Library.massagelog(msg);
					}
				
				else {
					
					
					String msg="Item has no pending requirement!";
					Library.massagelog(msg);
				}
						
			}
			catch(Exception e) {
				System.out.println(e);
				String msg="Item has no pending requirement!";
				Library.massagelog(msg);
			}
			
			
			
			
			Thread.sleep(1500);
			
			
			
			
			Library.dClick(element.getArrow2(),"parent Item + Arrow2");
			Thread.sleep(1500);
			
			
			
			WebElement gchielditemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("grandchield")+"')]"));
			Library.dClick(gchielditemcode, "Grand Chield Item Code ");
			
			Library.ActionDoubleClick(gchielditemcode, "gChield Item Code ");
			
			act.moveToElement(gchielditemcode).contextClick(gchielditemcode).build().perform();
			Thread.sleep(3000);	
			Library.custom_click(element.getDeAllocateItem(),"deAllocate Item");
			Thread.sleep(3000);	
			
			Library.dClick(element.getDeAllocateQuantity(),"Deallocation Quantity");
			
			try {
			Thread.sleep(3000);	
			Library.custom_Sendkeys(element.getDeAllocateinput(),config.getconfigdata("gdeallocationqty"),"deAllocation QtyField");
			Thread.sleep(3000);	
			Library.ActionDoubleClick(element.getDeAllocateButton(),"DEAllocate Button ");
			Thread.sleep(3000);
			
			//Library.ActionClick(element.getDeAllocateButton(),"Allocate Button ");
			
			}
			
			
			catch(Exception e) {
				System.out.println(e);
				String msg="Item has no pending requirement!";
				Library.massagelog(msg);
			}
			
			
			
			
			try {
				Thread.sleep(3000);
				System.out.println("DEAllocated Quantity Field Input succsesfully");
				System.out.println(config.getconfigdata("gdeallocationqty"));
				String real=config.getconfigdata("gdeallocationqty");
				Thread.sleep(1500);
				//String real=allocatedQuantity.getText();
				System.out.println(real);
				if(real==config.getconfigdata("gdeallocationqty")){
					String msg="DEAllocation for item successfully done!";
					
					Library.massagelog(msg);
					
					
				}
						
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println(e);
				String msg="Item has no pending requirement!";
				Library.massagelog(msg);
			}
			
				}
	
	
	
	
	
	//Test CAse for Deallocation Assembly Type Item
	

	@Test(priority=4)
	public void DeallocationAS() throws Exception {
		
		
		String testcasename="DeallocationAS of AS type item";
		
		//1)Login into application	
			
			Library.login("planning","DeallocationAS",testcasename);
			ConfigDataProvider config=new ConfigDataProvider("planning","DeallocationAS");
			
			Library.filelocationConfigreport("planning","DeallocationAS");
			DeAllocationpom element=	PageFactory.initElements(driver, DeAllocationpom.class);

		Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
		Library.custom_click(element.getDeAllocation(),"Deallocation");//Forecast Order module click
	//	Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
	
		String group=config.getconfigdata("group");

		System.out.println(group);
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		Library.dClick(element.getNumberComboBox(),"Number Drop Down");
		Library.custom_Sendkeys(element.getNumberinputField(),config.getconfigdata("number"),"SJO Item Search Field");
			Thread.sleep(3000);
Library.Comboclick(element.getNumberComboBox(), config.getconfigdata("number"),"Number Field");


			Library.dClick(element.getSJODetailsNEXTBTUUTON(),"SJO  Next Button");
			Thread.sleep(3000);	
			Library.dClick(element.getItemandDetailsNEXTBTUUTON(),"Item Details Next Button");
			Thread.sleep(3000);	
			Library.dClick(element.getArrow1(),"parent Item + Arrow1");
			Thread.sleep(3000);
			Library.dClick(element.getArrow2(),"parent Item + Arrow2");
			
			Thread.sleep(3000);
			
			Library.dClick(element.getArrow3(),"parent Item + Arrow3");
			Thread.sleep(3000);
			WebElement  finalchield=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("finalchield")+"')]"));
			
			Library.dClick(finalchield,"Bottom Chield Item");
				Thread.sleep(3000);	
				Actions act =new Actions(driver);
				act.moveToElement(finalchield).contextClick(finalchield).build().perform();
				Thread.sleep(3000);	
		
		
				Thread.sleep(3000);	
				Library.custom_click(element.getDeAllocateItem(),"Deallocate Item");
				Thread.sleep(3000);	
				
				Library.dClick(element.getDeAllocateQuantity(), "Deallocate Quantity");
				
				try {
				Thread.sleep(3000);	
				Library.custom_Sendkeys(element.getDeAllocateinput(),config.getconfigdata("deallocationqty"),"Deallocation Quantity Field QtyField");
				Thread.sleep(3000);	
				Library.ActionDoubleClick(element.getDeAllocateButton(),"DeAllocate Button ");
				Thread.sleep(3000);
				
				//Library.ActionClick(element.getDeAllocateButton(),"DEAllocate Button ");
				
				}
				catch(Exception e) {
					System.out.println(e);
					String msg="Item has no pending requirement!";
					Library.massagelog(msg);
				}
				
				
				try {
					Thread.sleep(3000);
					System.out.println("DEAllocated Quantity Field Input succsesfully");
					System.out.println(config.getconfigdata("deallocationqty"));
					String real=config.getconfigdata("deallocationqty");
					Thread.sleep(1500);
					//String real=allocatedQuantity.getText();
					System.out.println(real);
					if(real==config.getconfigdata("deallocationqty")){
						String msg="DEAllocation for item successfully done!";
						
						Library.massagelog(msg);
						}
					
					else {
						
						
						String msg="Item has no pending requirement!";
						Library.massagelog(msg);
					}
							
				}
				catch(Exception e) {
					System.out.println(e);
					String msg="Item has no pending requirement!";
					Library.massagelog(msg);
				}
				
				
				
				
				Thread.sleep(1500);
				
				
		
		
		
		
		
		
		
		
		
		
	}

}
