package purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageobject.POMaintenanceNew;
import com.utility.BaseClass;
import com.utility.ExcelDataProvider;
import com.utility.ExcelReader;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.WriteIntoExcel;
import com.utility.calendar;

public class PO_POamendement_SJO extends BaseClass {
	
	@Test(priority=0)
	public void Login() throws Exception {

		Library.login("LOGIN");
		// Thread.sleep(10000);
	}

@Test	
public void POD007() throws Exception {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// ScreenRecorderUtil.startRecord(sheetname);
	// NgWebDriver ngDriver = new NgWebDriver(js);

	// ngDriver.waitForAngularRequestsToFinish();

	WriteIntoExcel writeexcel = new WriteIntoExcel();

	String path = Library.ExelFilepath("purchase", "POMaintenanceNew");
	System.out.println(path);
	// writeexcel.writeData(path,"Testcases", 10, 0,"POD007"+path);

	ExcelReader Ecel = new ExcelReader(path);

	
	String sheetname="POD007";
	ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
	String TestcaseID = Excel.getStringdata("Testcases", 1, 0);// Test Case ID
	String testcasedesc = Excel.getStringdata("Testcases", 1, 1);// Test Case Desc
	Library.testcasedesc(TestcaseID, testcasedesc);

	System.out.println(Excel.getStringdata(sheetname, 1, 2));

	System.out.println(Excel.getStringdata(sheetname, 1, 4));

	// Library.login("pomaintenancedirect");
// ngDriver.waitForAngularRequestsToFinish();
//Library.login();
	Thread.sleep(1500);

	Thread.sleep(3000);
	POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

	Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
	Thread.sleep(1000);
//ngDriver.waitForAngularRequestsToFinish();
	Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
//ngDriver.waitForAngularRequestsToFinish();
	Thread.sleep(1000);
	Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
//ngDriver.waitForAngularRequestsToFinish();
//ngDriver.waitForAngularRequestsToFinish();
	Thread.sleep(12000);

	String pobasis = Excel.getStringdata(sheetname, 1, 3);
	System.out.println(pobasis);
	Library.Explicitlywait(element.getPOBASIS(), 20);

	Thread.sleep(3000);
	Library.Comboclick(element.getPOBASIS(), pobasis, "PO BAsis");
	Thread.sleep(5000);
//ngDriver.waitForAngularRequestsToFinish();

	WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
	String date = Excel.getStringdata(sheetname, 1, 2);
	calendar.calendarinput(calendorinput, date);

	Library.Scrolldown(0, 30);
	Thread.sleep(1500);
	Library.ActionClick(element.getPOINFONEXTBTN(), "PO Next Button");

	Thread.sleep(5000);
	System.out.println("Vendor Serach Field Searching");

	WebElement vendorsearch = element.getVendoraddsearhTextBox();
	Library.Explicitlywait(vendorsearch);
	Thread.sleep(5000);
	vendorsearch.click();
	String vendorcode = Excel.getStringdata(sheetname, 1, 4);
	vendorsearch.sendKeys(vendorcode);
	vendorsearch.sendKeys(Keys.ENTER);
//JavascriptExecutor js = (JavascriptExecutor)driver;
	Thread.sleep(5000);
	Library.Scrolldown(0, 30);
//Library.Explicitlywait(element.getVendoraddsearchbtn());
//
//Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
	try {

		WebElement erroemsg = driver.findElement(By.xpath("//div[contains(text(),' Buyer is required')]"));
		String errrormsg = erroemsg.getText();
		Library.ERRORmassagelog(errrormsg);
	} catch (Exception e) {
	}

//
	Thread.sleep(2000);
//Library.Explicitlywait(element.getBuyer());

	String buyer = Excel.getStringdata(sheetname, 1, 5);
	System.out.println(buyer);
	Library.Scrolldown(0, 30);
	Thread.sleep(3000);

	WebElement Buyer = element.getBuyer();
	Thread.sleep(2000);
	Library.Explicitlywait(Buyer, 0);

	Library.Comboclick(Buyer, buyer, "Buyer");
	Library.Scrolldown(0, 30);
	Thread.sleep(2000);
	Library.Scrolldown(0, 30);
	Library.ActionClick(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
	Thread.sleep(2000);
	Library.Scrolldown(0, 50);
	String RateStructure = Excel.getStringdata(sheetname, 1, 6);

	Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
	Library.Scrolldown(0, 50);
	Thread.sleep(6000);
	Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
	Library.Scrolldown(0, 30);
	Thread.sleep(15000);
	Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
	Thread.sleep(3000);

	try {

		WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
		Library.Explicitlywait(FirstItembtn);

		Thread.sleep(6000);
		String itemcode = Excel.getStringdata(sheetname, 1, 7);
		Thread.sleep(6000);
		JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
	} catch (Exception e) {

		System.out.println(e.getMessage());
	}
	Thread.sleep(6000);
	WebElement warehousecode = driver
			.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
	Library.Explicitlywait(warehousecode, 20);
	String ware = Excel.getStringdata(sheetname, 1, 8);
	System.out.println(ware);
	JQXGRID.JQXDropdown(warehousecode, ware);
	Thread.sleep(6000);

	WebElement childadd = driver.findElement(By.xpath("//button[@id='childadd']"));

	WebElement Qty = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]/div[6]"));
	Library.Explicitlywait(Qty);
	Thread.sleep(3000);
	Actions Act = new Actions(driver);
	if (Qty.isEnabled()) {
		System.out.println("QUantity Field Is Enbaled");
		Thread.sleep(3000);
		Act.moveToElement(Qty).doubleClick(Qty).perform();
	}

	// For Loop Started

	int lastrow = Ecel.getRowCount(sheetname);

	System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

	for (int i = 0; i <= lastrow; i++) {

		int j = i + 1;
		String deliverydate1 = Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", j);
		String Qty1 = Ecel.getCellData(sheetname, "Delivery Qty", j);
		// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
		if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
		}

		else {
			System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
			Thread.sleep(1000);
			String s = Integer.toString(i);

			System.out.println(s);
			Thread.sleep(3000);

			String data = Ecel.getCellData("Testcases", "TestCase Desc", j);

			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

			// Excel.getStringdata(sheetname, j, 10);

			Thread.sleep(2000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			// Excel.getStringdata(sheetname, j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				WebElement fcalendor = driver
						.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 5);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);
				WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
				Library.Explicitlywait(Deldate);
				Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
				Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				
				WebElement SJODROPDOWN=driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[2]"));

		Library.Explicitlywait(SJODROPDOWN, 25);
		
		Library.dClick(SJODROPDOWN,"sales Job Order DropDown");
			
			
			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
		Thread.sleep(3000);

		WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
		Library.Explicitlywait(Deldate);
		Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
		Library.Explicitlywait(childadd, 5);
		Thread.sleep(2000);
		Library.dClick(childadd, " Chield add Button");
		System.out.println("cycle " + s);
			}
			Library.dClick(childadd, " Chield add Button");
			System.out.println("cycle " + s);
			}
		if (i >= 3) {

			Library.Scrolldown(0, 30);
		}
		Library.Scrolldown(0, -30);
	}

	Library.Scrolldown(0, -600);
	Library.dClick(element.getSAVEBTN(), "Save button");
	Thread.sleep(13000);
//

	WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
	Library.Explicitlywait(Ponumber);
	Thread.sleep(2000);
	Library.info(Ponumber, "PO NUmber");
	WebElement Authorizecheckbox = driver
			.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

	Thread.sleep(5000);
	Thread.sleep(3000);
	Authorizecheckbox.click();

	Thread.sleep(5000);
	WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	Thread.sleep(5000);

	Authorizebtn.click();

	
	
	// ScreenRecorderUtil.stopRecord();

}


	

}
