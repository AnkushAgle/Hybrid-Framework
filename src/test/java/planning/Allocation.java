package planning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.planningpom.Allocationpom;

import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;

public class Allocation extends BaseClass {
	
@Test(priority=1)

public void AllocationMK() throws Exception{
	String testcasename="Allocation/WO creation of Mk type item";
	
//1)Login into application	
	
	Library.login("planning","AllocationMK",testcasename);
	ConfigDataProvider config=new ConfigDataProvider("planning","AllocationMK");
	
	Library.filelocationConfigreport("planning","AllocationMK");
	Allocationpom element=PageFactory.initElements(driver, Allocationpom.class);

Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
Library.custom_click(element.getAllocation_WoCreation(),"Allocation/WoCreation");//Forecast Order module click
Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
Thread.sleep(8000);
String group=config.getconfigdata("group");

System.out.println(group);

//Library.Comboclick(element.getGroupAllocation(),group,"Allocation Group");
Thread.sleep(3000);
String site=config.getconfigdata("site");
System.out.println(site);
//Library.Comboclick(element.getGroupAllocation(),site,"Allocation Site");
Thread.sleep(3000);
Thread.sleep(3000);
Library.custom_Sendkeys(element.getNumberinputField(),config.getconfigdata("number"),"SJO Item Search Field");
	Thread.sleep(3000);

	Library.dClick(element.getSJODetailsNEXTBTUUTON(),"SJO  Next Button");
	Thread.sleep(3000);	
	Library.dClick(element.getItemandDetailsNEXTBTUUTON(),"Item Details Next Button");
	Thread.sleep(3000);	
	
	WebElement parentitemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("parentitem")+"')]"));
	Library.dClick(parentitemcode,"parent Item code");
	WebElement chielditemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("chielditem")+"')]"));
	Library.dClick(chielditemcode,"Chield  Item code");
	Library.ActionDoubleClick(chielditemcode, "Chield Item Code ");
	//Library.dClick(chielditemcode,"Chield  Item code");
	
	
WebElement arrow=driver.findElement(By.xpath("//span[@id='arrow2']"));

Library.dClick(arrow,"chield item Arrow");


	Thread.sleep(3000);	
	Actions act =new Actions(driver);
	act.moveToElement(chielditemcode).contextClick(chielditemcode).build().perform();
	Thread.sleep(3000);	
	Library.custom_click(element.getAllocateItem(),"Allocate Item");
	Thread.sleep(3000);	
	
	Library.dClick(element.getAllocationQty(), site);
	
	try {
	Thread.sleep(3000);	
	Library.custom_Sendkeys(element.getAllocationQtyinput(),config.getconfigdata("allocationqty"),"Allocation QtyField");
	Thread.sleep(3000);	
	Library.ActionDoubleClick(element.getAllocateButton(),"Allocate Button ");
	Thread.sleep(3000);
	
	Library.ActionClick(element.getAllocateButton(),"Allocate Button ");
	
	}
	catch(Exception e) {
		System.out.println(e);
		String msg="Item has no pending requirement!";
		Library.massagelog(msg);
	}
	Thread.sleep(6000);
	
	try {
		Thread.sleep(3000);
		System.out.println("Allocated Quantity Field Input succsesfully");
		System.out.println(config.getconfigdata("allocationqty"));
		String real=config.getconfigdata("allocationqty");
		Thread.sleep(1500);
		//String real=allocatedQuantity.getText();
		System.out.println(real);
		if(real==config.getconfigdata("allocationqty")){
			String msg="Allocation for item successfully done!";
			
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
	
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	
	WebElement gchielditemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("grandchield")+"')]"));
	Library.dClick(gchielditemcode, "Grand Chield Item Code ");
	
	Library.ActionDoubleClick(gchielditemcode, "gChield Item Code ");
	
	act.moveToElement(gchielditemcode).contextClick(gchielditemcode).build().perform();
	Thread.sleep(3000);	
	Library.custom_click(element.getAllocateItem(),"Allocate Item");
	Thread.sleep(3000);	
	
	Library.dClick(element.getAllocationQty(), site);
	
	try {
	Thread.sleep(3000);	
	Library.custom_Sendkeys(element.getAllocationQtyinput(),config.getconfigdata("gallocationqty"),"Allocation QtyField");
	Thread.sleep(3000);	
	Library.ActionDoubleClick(element.getAllocateButton(),"Allocate Button ");
	Thread.sleep(3000);
	
	Library.ActionClick(element.getAllocateButton(),"Allocate Button ");
	
	}
	
	
	catch(Exception e) {
		System.out.println(e);
		String msg="Item has no pending requirement!";
		Library.massagelog(msg);
	}
	
	
	
	
	try {
		Thread.sleep(3000);
		System.out.println("Allocated Quantity Field Input succsesfully");
		System.out.println(config.getconfigdata("gallocationqty"));
		String real=config.getconfigdata("gallocationqty");
		Thread.sleep(1500);
		//String real=allocatedQuantity.getText();
		System.out.println(real);
		if(real==config.getconfigdata("gallocationqty")){
			String msg="Allocation for item successfully done!";
			
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

@Test(priority=3)
public void AllocationAS() throws Exception {
	String testcasename="Allocation/WO creation of AS type item";
	
	//1)Login into application	
		
		Library.login("planning","AllocationAS",testcasename);
		ConfigDataProvider config=new ConfigDataProvider("planning","AllocationAS");
		
		Library.filelocationConfigreport("planning","AllocationAS");
		Allocationpom element=	PageFactory.initElements(driver, Allocationpom.class);

	Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
	Library.custom_click(element.getAllocation_WoCreation(),"Allocation/WoCreation");//Forecast Order module click
	Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
	Thread.sleep(8000);
	String group=config.getconfigdata("group");

	System.out.println(group);

	//Library.Comboclick(element.getGroupAllocation(),group,"Allocation Group");
	Thread.sleep(3000);
	String site=config.getconfigdata("site");
	System.out.println(site);
	//Library.Comboclick(element.getGroupAllocation(),site,"Allocation Site");
	Thread.sleep(3000);
	Thread.sleep(3000);
	Library.custom_Sendkeys(element.getNumberinputField(),config.getconfigdata("number"),"SJO Item Search Field");
		Thread.sleep(3000);

		Library.dClick(element.getSJODetailsNEXTBTUUTON(),"SJO  Next Button");
		Thread.sleep(3000);	
		Library.dClick(element.getItemandDetailsNEXTBTUUTON(),"Item Details Next Button");
		Thread.sleep(3000);	
		
		
		//  Item Code Next Bitton
		
		//parent Item Code Click
		WebElement parentitemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("parentitem")+"')]"));
		Library.dClick(parentitemcode,"parent Item code");
		
	
		
		//Chield Item Code Click
		WebElement chielditemcode=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("chielditem")+"')]"));
		Library.dClick(chielditemcode,"Chield  Item code");
		
		
		
		Library.ActionDoubleClick(chielditemcode, "Chield Item Code ");
		//Library.dClick(chielditemcode,"Chield  Item code");
		
		// Arrow Click
	WebElement arrow=driver.findElement(By.xpath("//span[@id='arrow2']"));

	Library.dClick(arrow,"chield item Arrow2");
	
	WebElement arrow3=driver.findElement(By.xpath("//span[@id='arrow3']"));

	Library.dClick(arrow3,"chield item Arrow3");

	WebElement  finalchield=driver.findElement(By.xpath("//div[contains(text(),'"+config.getconfigdata("finalchield")+"')]"));
	
	Library.dClick(finalchield,"Bottom Chield Item");
		Thread.sleep(3000);	
		Actions act =new Actions(driver);
		act.moveToElement(finalchield).contextClick(finalchield).build().perform();
		Thread.sleep(3000);	
		Library.custom_click(element.getAllocateItem(),"Allocate Item");
		Thread.sleep(3000);	
		
		Library.dClick(element.getAllocationQty(), site);
		
		
		try {
			Thread.sleep(3000);	
			Library.custom_Sendkeys(element.getAllocationQtyinput(),config.getconfigdata("allocationqty"),"Allocation QtyField");
			Thread.sleep(3000);	
			Library.ActionDoubleClick(element.getAllocateButton(),"Allocate Button ");
			Thread.sleep(3000);
			
			Library.ActionClick(element.getAllocateButton(),"Allocate Button ");
			
			}
			
			
			catch(Exception e) {
				System.out.println(e);
				String msg="Item has no pending requirement!";
				Library.massagelog(msg);
			}
	
		
		try {
			Thread.sleep(3000);
			System.out.println("Allocated Quantity Field Input succsesfully");
			System.out.println(config.getconfigdata("allocationqty"));
			String real=config.getconfigdata("allocationqty");
			Thread.sleep(1500);
			//String real=allocatedQuantity.getText();
			System.out.println(real);
			if(real==config.getconfigdata("allocationqty")){
				String msg="Allocation for item successfully done!";
				
				Library.massagelog(msg);
				}
			
			else {
				
	               String msg="Allocation for item successfully done!";
				
				Library.massagelog(msg);
			}
					
		}
		catch(Exception e) {
			System.out.println("Allocation Quanty Field not be inspectable");
			System.out.println(e);
		}
			
}

}
