package purchase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pageobject.POMaintenanceNew;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.ExcelReader;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.ScreenRecorderUtil;
import com.utility.WriteIntoExcel;
import com.utility.calendar;

public class pomaintenancenew extends BaseClass {

	@Test

	public void Login() throws Exception {

	 	Library.login("LOGIN");
		// Thread.sleep(10000);
	}

	// Test Case POD001 Satrted

	@Test

	public void POD006() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ScreenRecorderUtil.startRecord("POD006");
		// NgWebDriver ngDriver = new NgWebDriver(js);

		// ngDriver.waitForAngularRequestsToFinish();

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "POMaintenanceNew");
		System.out.println(path);
		// writeexcel.writeData(path,"Testcases", 10, 0,"POD007"+path);

		ExcelReader Ecel = new ExcelReader(path);

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 1, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 1, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println(Excel.getStringdata("POD006", 1, 2));

		System.out.println(Excel.getStringdata("POD006", 1, 4));

		// Library.login("pomaintenancedirect");
//	 ngDriver.waitForAngularRequestsToFinish();
// Library.login();
		Thread.sleep(1500);

		Thread.sleep(3000);
		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Thread.sleep(1000);
// ngDriver.waitForAngularRequestsToFinish();
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
// ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
//ngDriver.waitForAngularRequestsToFinish();
//  ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(12000);

		String pobasis = Excel.getStringdata("POD006", 1, 3);
		System.out.println(pobasis);
		Library.Explicitlywait(element.getPOBASIS(), 20);

		Thread.sleep(3000);
		Library.Comboclick(element.getPOBASIS(), pobasis, "PO BAsis");
		Thread.sleep(5000);
//ngDriver.waitForAngularRequestsToFinish();

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POD006", 1, 2);
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
		String vendorcode = Excel.getStringdata("POD006", 1, 4);
		vendorsearch.sendKeys(vendorcode);
		vendorsearch.sendKeys(Keys.ENTER);
//JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 30);
//	Library.Explicitlywait(element.getVendoraddsearchbtn());
//	
//	Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
		try {

			WebElement erroemsg = driver.findElement(By.xpath("//div[contains(text(),' Buyer is required')]"));
			String errrormsg = erroemsg.getText();
			Library.ERRORmassagelog(errrormsg);
		} catch (Exception e) {
		}

//	
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());

		String buyer = Excel.getStringdata("POD006", 1, 5);
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
		String RateStructure = Excel.getStringdata("POD006", 1, 6);

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
			String itemcode = Excel.getStringdata("POD006", 1, 7);
			Thread.sleep(6000);
			JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		Thread.sleep(6000);
		WebElement warehousecode = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
		Library.Explicitlywait(warehousecode, 20);
		String ware = Excel.getStringdata("POD006", 1, 8);
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

		int lastrow = Ecel.getRowCount("POD006");

		System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

		for (int i = 0; i <= lastrow; i++) {

			int j = i + 1;
			String deliverydate1 = Ecel.getCellData("POD006", "ITEMCODE Delivery Dates", j);
			String Qty1 = Ecel.getCellData("POD006", "Delivery Qty", j);
			// String a=Ecel.getCellData("POD006", "ITEMCODE Delivery Dates", 1);
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

				// Excel.getStringdata("POD006", j, 10);

				Thread.sleep(2000);
				Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
				Qtytxtbox.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				// Excel.getStringdata("POD006", j, 9);
				String date1 = deliverydate1.replaceAll("/", "");

				System.out.println(date1);

				if (s.equalsIgnoreCase("0")) {

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else {

					String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

					WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
					String v = Integer.toString(i + 1);
					Library.Explicitlywait(calendar1, 20);
					Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
					Thread.sleep(3000);
				}

				WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
				Library.Explicitlywait(Deldate);
				Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
				Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);
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
		Thread.sleep(8000);
//	

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
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

	
	
	
	
	
	@Test
	public void POD001() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ScreenRecorderUtil.startRecord("POD001");
		// NgWebDriver ngDriver = new NgWebDriver(js);

		// ngDriver.waitForAngularRequestsToFinish();Thread

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "POMaintenanceNew");
		System.out.println(path);
		// writeexcel.writeData(path,"Testcases", 10, 0,"POD007"+path);

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 1, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 1, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		String thread = Excel.getStringdata("POD001", 1, 12);

		System.out.println(Excel.getStringdata("POD001", 1, 2));

		System.out.println(Excel.getStringdata("POD001", 1, 4));

		// Library.login("pomaintenancedirect");
//	 ngDriver.waitForAngularRequestsToFinish();
// Library.login();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(1500);

			Thread.sleep(3000);
		}
		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Thread.sleep(1000);
// ngDriver.waitForAngularRequestsToFinish();
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
// ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
//ngDriver.waitForAngularRequestsToFinish();
//  ngDriver.waitForAngularRequestsToFinish();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(12000);
		}

		String pobasis = Excel.getStringdata("POD001", 1, 3);
		System.out.println(pobasis);
		Library.Explicitlywait(element.getPOBASIS(), 20);

		Thread.sleep(3000);
		Library.Comboclick(element.getPOBASIS(), pobasis, "PO BAsis");
		Thread.sleep(5000);
//ngDriver.waitForAngularRequestsToFinish();

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POD001", 1, 2);
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
		String vendorcode = Excel.getStringdata("POD001", 1, 4);
		vendorsearch.sendKeys(vendorcode);
		vendorsearch.sendKeys(Keys.ENTER);
//JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 30);
//	Library.Explicitlywait(element.getVendoraddsearchbtn());
//	
//	Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
		try {

			WebElement erroemsg = driver.findElement(By.xpath("//div[contains(text(),' Buyer is required')]"));
			String errrormsg = erroemsg.getText();
			Library.ERRORmassagelog(errrormsg);
		} catch (Exception e) {
		}

//	
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());

		String buyer = Excel.getStringdata("POD001", 1, 5);
		System.out.println(buyer);
		Library.Scrolldown(0, 30);
		Thread.sleep(3000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(20000);
		Library.Explicitlywait(Buyer, 0);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 30);
		Library.ActionClick(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POD001", 1, 6);

		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Library.Scrolldown(0, 50);
		Thread.sleep(6000);
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(15000);
		}
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
		Thread.sleep(3000);

		try {

			WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
			Library.Explicitlywait(FirstItembtn);

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);
			}
			String itemcode = Excel.getStringdata("POD001", 1, 7);
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);
			}
			JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		Thread.sleep(6000);
		WebElement warehousecode = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
		Library.Explicitlywait(warehousecode, 20);
		String ware = Excel.getStringdata("POD001", 1, 8);
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

		for (int i = 0; i <= 3; i++) {

			String s = Integer.toString(i);

			if (i >= 1) {
				Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			Thread.sleep(1000);

			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 1;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD001", j, 10);
			Thread.sleep(2000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String deliverydate1 = Excel.getStringdata("POD001", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				WebElement fcalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 5);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
			Library.Explicitlywait(childadd, 5);
			Thread.sleep(2000);

		}

		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(8000);
		}
//	

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
		Library.Explicitlywait(Ponumber);
		Thread.sleep(2000);
		Library.info(Ponumber, "PO NUmber");
		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
			Thread.sleep(3000);
		}
		Authorizecheckbox.click();

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		Authorizebtn.click();

		ScreenRecorderUtil.stopRecord();
	}

	// For this test case for loop is used
	@Test
	public void POD002() throws Exception {

		ScreenRecorderUtil.startRecord("POD002");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// NgWebDriver ngDriver = new NgWebDriver(js);

		// ngDriver.waitForAngularRequestsToFinish();

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 2, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 2, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String thread = Excel.getStringdata("POD002", 1, 12);
		System.out.println(Excel.getStringdata("POD002", 1, 2));

		System.out.println(Excel.getStringdata("POD002", 1, 4));

		// Library.login("pomaintenancedirect");
//	 ngDriver.waitForAngularRequestsToFinish();
// Library.login();
		Thread.sleep(1500);

		Thread.sleep(3000);
		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Thread.sleep(1000);
// ngDriver.waitForAngularRequestsToFinish();
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
// ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
//ngDriver.waitForAngularRequestsToFinish();
//  ngDriver.waitForAngularRequestsToFinish();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(20000);
		}

		String pobasis = Excel.getStringdata("POD002", 1, 3);
		Library.Explicitlywait(element.getPOBASIS(), 20);

		Thread.sleep(3000);
		Library.Comboclick(element.getPOBASIS(), pobasis, "PO BAsis");
		Thread.sleep(5000);
//ngDriver.waitForAngularRequestsToFinish();

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POD002", 1, 2);
		calendar.calendarinput(calendorinput, date);

		Library.Scrolldown(0, 30);
		Thread.sleep(1500);
		Library.ActionClick(element.getPOINFONEXTBTN(), "PO Next Button");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		System.out.println("Vendor Serach Field Searching");
		WebElement vendorsearch = element.getVendoraddsearhTextBox();
		Library.Explicitlywait(vendorsearch);
		Thread.sleep(5000);
		vendorsearch.click();
		String vendorcode = Excel.getStringdata("POD002", 1, 4);
		vendorsearch.sendKeys(vendorcode);
		vendorsearch.sendKeys(Keys.ENTER);
//JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 30);
//	Library.Explicitlywait(element.getVendoraddsearchbtn());
//	
//	Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
//	
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POD002", 1, 5);
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
		String RateStructure = Excel.getStringdata("POD002", 1, 6);

		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(17000);
		}
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
		Thread.sleep(3000);

		try {

			WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
			Library.Explicitlywait(FirstItembtn);

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);
			}
			String itemcode = Excel.getStringdata("POD002", 1, 7);
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);
			}
			JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		Thread.sleep(3000);
		WebElement warehousecode = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']"));
		Library.Explicitlywait(warehousecode, 20);
		String ware = Excel.getStringdata("POD002", 1, 8);
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

		for (int i = 0; i <= 3; i++) {

			Thread.sleep(1000);
			String s = Integer.toString(i);

			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 1;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD002", j, 10);
			Thread.sleep(2000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String deliverydate1 = Excel.getStringdata("POD002", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				WebElement fcalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 5);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
			Library.Explicitlywait(childadd, 5);
			Thread.sleep(2000);
			Library.dClick(childadd, " Chield add Button");
			System.out.println("cycle " + s);

		}

		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(8000);
		}
//	

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
		Library.Explicitlywait(Ponumber);
		Thread.sleep(2000);
		Library.info(Ponumber, "PO NUmber");
		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
			Thread.sleep(3000);
		}
		Authorizecheckbox.click();

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		Authorizebtn.click();

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		ScreenRecorderUtil.stopRecord();
	}

	// TSET CASE THREE STARTED
	@Test

	public void POD003() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		NgWebDriver ngDriver = new NgWebDriver(js);

		ScreenRecorderUtil.startRecord("POD003");

		// test.log(Status.INFO, "Please do automation for PO entry (Direct i.e. without
		// indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with
		// 1 delivery schedule Once finished, we will check");
		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 3, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 3, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String thread = Excel.getStringdata("POD003", 1, 12);
		System.out.println(TestcaseID + testcasedesc);
		ConfigDataProvider config = new ConfigDataProvider("pomaintenancedirect");
		// Library.login("LOGIN");

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(8000);
		}

		String POBasis = Excel.getStringdata("POD003", 1, 3);
		System.out.println(POBasis);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		Library.Comboclick(element.getPOBASIS(), POBasis, "PO BAsis");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POD003", 1, 2);
		calendar.calendarinput(calendorinput, date);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		System.out.println("Vendor Serach Field Searching");
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch, 20);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POD003", 1, 4));
		vendorsearch.sendKeys(Keys.ENTER);
//      		 JavascriptExecutor js = (JavascriptExecutor)driver;
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		Library.Scrolldown(0, 30);
//      	 		Library.Explicitlywait(element.getVendoraddsearchbtn());
//      	 		
//      			Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
//      			
		Thread.sleep(2000);
//      			Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POD003", 1, 5);
		System.out.println(buyer);

		Thread.sleep(5000);
		Library.Comboclick(element.getBuyer(), buyer, "Buyer");
		Library.Scrolldown(0, 50);
		Thread.sleep(4000);
		Library.Scrolldown(0, 50);
		Library.dClick(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		String RateStructure = Excel.getStringdata("POD003", 1, 6);

		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.Scrolldown(0, 70);
		WebElement getRateStryctureNextBtn = element.getRateStryctureNextBtn();
		Library.Explicitlywait(getRateStryctureNextBtn, 20);
		Library.dClick(getRateStryctureNextBtn, "RateStryctureNextBtn");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(17000);
		}
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
		Thread.sleep(5000);

		try {

			WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
			Library.Explicitlywait(FirstItembtn, 30);

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(8000);
			}
			String itemcode = Excel.getStringdata("POD003", 1, 7);
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(8000);
			}
			JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		WebElement warehousecode = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']"));
		String ware = Excel.getStringdata("POD003", 1, 8);
		System.out.println(ware);
		Library.Explicitlywait(warehousecode, 20);
		JQXGRID.JQXDropdown(warehousecode, ware);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

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

		// For Loop Started For 1st ITem CODE

		for (int i = 0; i <= 3; i++) {

			Thread.sleep(1000);
			String s = Integer.toString(i);

			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 1;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD003", j, 10);
			Thread.sleep(2000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String deliverydate1 = Excel.getStringdata("POD003", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				WebElement fcalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 5);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
			Library.Explicitlywait(childadd, 5);
			Thread.sleep(2000);
			Library.dClick(childadd, " Chield add Button");
			System.out.println("cycle " + s);

		}

		// For Loop Endend For Item 1

		// Po for Second Item Code

		Thread.sleep(5000);
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
		Thread.sleep(3000);

		try {

			WebElement SecondItemButton = driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]/div[7]"));
			Library.Explicitlywait(SecondItemButton);

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);
			}
			String itemcode2 = Excel.getStringdata("POD003", 5, 7);
			System.out.println(itemcode2);
			Thread.sleep(6000);
			JQXGRID.JQXDIRECTITEM(SecondItemButton, itemcode2);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		Thread.sleep(3000);
		WebElement warehousecode2 = driver
				.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']"));
		Library.Explicitlywait(warehousecode2, 20);
		String ware2 = Excel.getStringdata("POD003", 5, 8);
		System.out.println(ware2);
		JQXGRID.JQXDropdown(warehousecode2, ware2);
		Thread.sleep(6000);

		WebElement Qty2 = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']"));
		Library.Explicitlywait(Qty2);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		if (Qty2.isEnabled()) {
			System.out.println("QUantity Field Is Enbaled");
			Thread.sleep(3000);
			Act.moveToElement(Qty2).doubleClick(Qty2).perform();
		}

		WebElement childadd2 = driver.findElement(By.xpath("//button[@id='childadd']"));
		// For Loop for Second Item Code
		for (int i = 0; i <= 3; i++) {
			String v = Integer.toString(i + 1);
			Thread.sleep(1000);
			String s = Integer.toString(i);

			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 5;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD003", j, 10);
			Thread.sleep(2000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String deliverydate1 = Excel.getStringdata("POD003", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']";
				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				// String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			else if (s.equalsIgnoreCase("1")) {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']";
				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));

				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";
				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));

				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);

			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + v);
			Library.Explicitlywait(childadd, 5);
			Thread.sleep(2000);
			Library.dClick(childadd, " Chield add Button");
			System.out.println("cycle " + s);

		}

		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");
		Thread.sleep(10000);
		//

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
		Library.Explicitlywait(Ponumber, 20);
		Thread.sleep(2000);
		Library.info(Ponumber, "PO NUmber");
		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
			Thread.sleep(3000);
		}
		Authorizecheckbox.click();

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Thread.sleep(5000);

		Authorizebtn.click();

		Thread.sleep(5000);

		ScreenRecorderUtil.stopRecord();
	}

	// Test Case Four IS Started

	@Test
	public void POD004() throws Exception {
		// driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ScreenRecorderUtil.startRecord("POD004");
		NgWebDriver ngDriver = new NgWebDriver(js);

		// ngDriver.waitForAngularRequestsToFinish();

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 9, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 9, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println(Excel.getStringdata("POD004", 1, 2));

		System.out.println(Excel.getStringdata("POD004", 1, 4));

		// Library.login("pomaintenancedirect");
//	 ngDriver.waitForAngularRequestsToFinish();
// Library.login();
		Thread.sleep(1500);

		Thread.sleep(3000);
		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Thread.sleep(1000);
// ngDriver.waitForAngularRequestsToFinish();
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
// ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
//ngDriver.waitForAngularRequestsToFinish();
//  ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(12000);

		String pobasis = Excel.getStringdata("POD004", 1, 3);
		System.out.println(pobasis);
		Thread.sleep(10000);

		Library.Explicitlywait(element.getPOBASIS(), 30);

		Library.Comboclick(element.getPOBASIS(), pobasis, "PO BAsis");
		Thread.sleep(4000);
//ngDriver.waitForAngularRequestsToFinish();

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POD004", 1, 2);
		calendar.calendarinput(calendorinput, date);

		Library.Scrolldown(0, 30);
		Thread.sleep(1500);
		Library.ActionClick(element.getPOINFONEXTBTN(), "PO Next Button");

		Thread.sleep(5000);
		System.out.println("Vendor Serach Field Searching");

		WebElement vendorsearch = element.getVendoraddsearhTextBox();
		Thread.sleep(5000);
		Library.Explicitlywait(vendorsearch);
		vendorsearch.click();
		String vendorcode = Excel.getStringdata("POD004", 1, 4);
		vendorsearch.sendKeys(vendorcode);
		vendorsearch.sendKeys(Keys.ENTER);
//JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 30);
//	Library.Explicitlywait(element.getVendoraddsearchbtn());
//	
//	Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
		try {

			WebElement erroemsg = driver.findElement(By.xpath("//div[contains(text(),' Buyer is required')]"));
			String errrormsg = erroemsg.getText();
			Library.ERRORmassagelog(errrormsg);
		} catch (Exception e) {
		}

//	
		Thread.sleep(10000);
//	Library.Explicitlywait(element.getBuyer());

		String buyer = Excel.getStringdata("POD004", 1, 5);
		System.out.println(buyer);
		Library.Scrolldown(0, 70);
		Thread.sleep(3000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(4000);
		Library.Explicitlywait(Buyer, 20);
		Library.Comboclick(Buyer, buyer, "Buyer");

		Thread.sleep(4000);

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",element.getVendorInfoNextBtn());
		Library.ActionClick(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(7000);
		Library.Scrolldown(0, 70);
		String RateStructure = Excel.getStringdata("POD004", 1, 6);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// element.getRateStructure());
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Thread.sleep(3000);
		Library.Scrolldown(0, 50);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",element.getRateStryctureNextBtn());
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStructureNextBtn");
		Library.Scrolldown(0, 30);
		Thread.sleep(20000);
		// Library.Scrolldown(0, 30);

		Library.Explicitlywait(element.getItemandindentaddnewbtn(), 50);
		Library.custom_click(element.getItemandindentaddnewbtn(), "Add New Button ");

		Thread.sleep(8000);

		WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
		Library.Explicitlywait(FirstItembtn, 30);

		Thread.sleep(6000);
		String itemcode = Excel.getStringdata("POD004", 1, 7);
		Thread.sleep(6000);
		JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);

		Thread.sleep(15000);
		WebElement warehousecode = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
		String ware = Excel.getStringdata("POD004", 1, 8);
		System.out.println(ware);

		Library.Explicitlywait(warehousecode, 30);
		JQXGRID.JQXDropdown(warehousecode, ware);
		Thread.sleep(6000);

		Library.horizontalscroll(80);
		Thread.sleep(3000);
		WebElement Discount = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='15']"));
		Library.Explicitlywait(Discount, 20);
		Thread.sleep(3000);
		String discounttype = Excel.getStringdata("POD004", 1, 11);
		Thread.sleep(1000);
		System.out.println("The DisCount Type Is " + discounttype);
		JQXGRID.JQXDropdown(Discount, discounttype);

		WebElement Discountvalue = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='16']"));
		Library.Explicitlywait(Discountvalue, 20);
		Library.dClick(Discountvalue, "Discount Type ");
		WebElement discounttextField = driver.findElement(By.xpath("//div[contains(@id,'discoval')]//input"));
		Library.Explicitlywait(discounttextField, 20);

		String discountinput = Excel.getStringdata("POD004", 1, 12);
		Library.custom_Sendkeys(discounttextField, discountinput, "Discount Input Field ");
		Thread.sleep(3000);
		Library.horizontalscrollback(80);
		// div[contains(@id,'row0jqxWidget')]//div[@columnindex='16']

		// Library.horizontalscroll(80);
//		WebElement PurchaseConversionFactor=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='17']//div[1]"));
//	Library.Explicitlywait(PurchaseConversionFactor, 20);
//	String PCF=PurchaseConversionFactor.getText();
//		System.out.println(PCF);
//		Library.Scrolldown(500, 0);

		// WebElement childadd =
		// driver.findElement(By.xpath("//button[@id='childadd']"));
		// For Loop Started
		Thread.sleep(6000);
		for (int i = 0; i <= 4; i++) {
			WebElement childadd = driver.findElement(By.xpath("//button[@id='childadd']"));
			Library.Explicitlywait(childadd, 10);
			Thread.sleep(1000);
			String s = Integer.toString(i);

			if (s.equalsIgnoreCase("0")) {
				WebElement childadd1 = driver.findElement(By.xpath("//button[@id='childadd']"));
				Library.Explicitlywait(childadd1, 20);
				Library.dClick(childadd1, " Chield add Button");

				WebElement Qty1 = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]/div[6]"));
				Library.Explicitlywait(Qty1, 30);
//				Thread.sleep(5000);
//				try {Qty1.click(); Library.custom_click(Qty1, s);}catch(Exception e) {}
				Library.ActionDoubleClick(Qty1, "Quantity 1 Field");
				Library.dClick(childadd1, " Chield add Button");
				System.out.println("QUantity Field Is Enbaled");
				Thread.sleep(3000);

			}

			else {
				Thread.sleep(2000);
				Library.Explicitlywait(childadd, 10);
				Library.dClick(childadd, " Chield add Button");
			}

			System.out.println("cycle " + s);
			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 1;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD004", j, 10);
			Thread.sleep(4000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String MSG = "Qty PUOM should be in multiple of purchase conversion factor: 2 !";

			String deliverydate1 = Excel.getStringdata("POD004", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				WebElement fcalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 10);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);

		}
		Library.Scrolldown(0, 100);
		Thread.sleep(2000);
		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");
		Thread.sleep(25000);
//	

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
		Library.Explicitlywait(Ponumber);
		Thread.sleep(2000);
		Library.info(Ponumber, "PO NUmber");

		WebElement EditButton = driver.findElement(By.xpath("//a[contains(@class,'edibutton1 ')]"));
		Library.Explicitlywait(EditButton, 20);

		try {

			Library.dClick(EditButton, discountinput);
		}

		catch (Exception j) {
			System.out.println(j);
		}

		try {

			EditButton.click();
		}

		catch (Exception j) {
			System.out.println(j);
		}

		Thread.sleep(15000);

		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		Thread.sleep(3000);
		Library.dClick(element.getRateStryctureNextBtn());
		Thread.sleep(3000);

		Thread.sleep(15000);
		WebElement warehousecode1 = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
		String ware1 = Excel.getStringdata("POD004", 2, 8);
		System.out.println(ware1);

		Library.Explicitlywait(warehousecode1, 30);
		JQXGRID.JQXDropdown(warehousecode1, ware1);
		Thread.sleep(6000);

		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");

		Thread.sleep(10000);

		try {
			WebElement Authorizecheckbox = driver
					.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

			Thread.sleep(5000);
			Thread.sleep(3000);
			Authorizecheckbox.click();

			Thread.sleep(5000);
			WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
			Thread.sleep(5000);

			Authorizebtn.click();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
		// ScreenRecorderUtil.stopRecord();

	}

	@Test
	public void POD005() throws Exception {
		// driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		// JavascriptExecutor js = (JavascriptExecutor) driver;

		// ScreenRecorderUtil.startRecord("POD005");
		// NgWebDriver ngDriver = new NgWebDriver(js);

		// ngDriver.waitForAngularRequestsToFinish();

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 11, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 11, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println(Excel.getStringdata("POD005", 1, 2));

		System.out.println(Excel.getStringdata("POD005", 1, 4));

//	 ngDriver.waitForAngularRequestsToFinish();
// Library.login();
		Thread.sleep(1500);

		Thread.sleep(3000);
		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Thread.sleep(1000);
// ngDriver.waitForAngularRequestsToFinish();
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
// ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
//ngDriver.waitForAngularRequestsToFinish();
//  ngDriver.waitForAngularRequestsToFinish();
		Thread.sleep(12000);

		String pobasis = Excel.getStringdata("POD005", 1, 3);
		System.out.println(pobasis);
		Thread.sleep(20000);
		//

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100L))
				.pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//ng-select[@formcontrolname='poBasis']"));
			}
		});

		Library.Explicitlywait(element.getPOBASIS(), 30);

		Thread.sleep(4000);
		Library.Comboclick(element.getPOBASIS(), pobasis, "PO BAsis");
		Thread.sleep(4000);
//ngDriver.waitForAngularRequestsToFinish();

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POD005", 1, 2);
		calendar.calendarinput(calendorinput, date);

		Library.Scrolldown(0, 30);
		Thread.sleep(1500);
		Library.ActionClick(element.getPOINFONEXTBTN(), "PO Next Button");

		Thread.sleep(5000);
		System.out.println("Vendor Serach Field Searching");

		WebElement vendorsearch = element.getVendoraddsearhTextBox();
		Thread.sleep(5000);
		Library.Explicitlywait(vendorsearch);
		vendorsearch.click();
		String vendorcode = Excel.getStringdata("POD005", 1, 4);
		vendorsearch.sendKeys(vendorcode);
		vendorsearch.sendKeys(Keys.ENTER);
//JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 30);
//	Library.Explicitlywait(element.getVendoraddsearchbtn());
//	
//	Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
		try {

			WebElement erroemsg = driver.findElement(By.xpath("//div[contains(text(),' Buyer is required')]"));
			String errrormsg = erroemsg.getText();
			Library.ERRORmassagelog(errrormsg);
		} catch (Exception e) {
		}

//	
		Thread.sleep(10000);
//	Library.Explicitlywait(element.getBuyer());

		String buyer = Excel.getStringdata("POD005", 1, 5);
		System.out.println(buyer);
		Library.Scrolldown(0, 70);
		Thread.sleep(3000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(4000);
		Library.Explicitlywait(Buyer, 20);
		Library.Comboclick(Buyer, buyer, "Buyer");

		Thread.sleep(4000);

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",element.getVendorInfoNextBtn());
		Library.ActionClick(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(7000);
		Library.Scrolldown(0, 70);
		String RateStructure = Excel.getStringdata("POD005", 1, 6);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// element.getRateStructure());
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Thread.sleep(3000);
		Library.Scrolldown(0, 50);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",element.getRateStryctureNextBtn());
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStructureNextBtn");
		Library.Scrolldown(0, 30);
		Thread.sleep(20000);
		// Library.Scrolldown(0, 30);

		Library.Explicitlywait(element.getItemandindentaddnewbtn(), 50);
		Library.custom_click(element.getItemandindentaddnewbtn(), "Add New Button ");

		Thread.sleep(8000);

		WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
		Library.Explicitlywait(FirstItembtn, 30);

		Thread.sleep(6000);
		String itemcode = Excel.getStringdata("POD005", 1, 7);
		System.out.println("The Item Code IS Equals To "+itemcode);
		Thread.sleep(6000);
		JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);

		Thread.sleep(15000);
		WebElement warehousecode = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
		String ware = Excel.getStringdata("POD005", 1, 8);
		System.out.println(ware);

		Library.Explicitlywait(warehousecode, 30);
		JQXGRID.JQXDropdown(warehousecode, ware);
		Thread.sleep(6000);

		Library.horizontalscroll(80);
		Thread.sleep(3000);
		WebElement Discount = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='15']"));
		Library.Explicitlywait(Discount, 20);
		Thread.sleep(3000);
		String discounttype = Excel.getStringdata("POD005", 1, 11);
		Thread.sleep(1000);
		System.out.println("The DisCount Type Is " + discounttype);
		JQXGRID.JQXDropdown(Discount, discounttype);

		WebElement Discountvalue = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='16']"));
		Library.Explicitlywait(Discountvalue, 20);
		Library.dClick(Discountvalue, "Discount Type ");
		WebElement discounttextField = driver.findElement(By.xpath("//div[contains(@id,'discoval')]//input"));
		Library.Explicitlywait(discounttextField, 20);

		String discountinput = Excel.getStringdata("POD005", 1, 12);
		Library.custom_Sendkeys(discounttextField, discountinput, "Discount Input Field ");
		Thread.sleep(3000);
		Library.horizontalscrollback(80);
		// div[contains(@id,'row0jqxWidget')]//div[@columnindex='16']

		// Library.horizontalscroll(80);
//		WebElement PurchaseConversionFactor=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='17']//div[1]"));
//	Library.Explicitlywait(PurchaseConversionFactor, 20);
//	String PCF=PurchaseConversionFactor.getText();
//		System.out.println(PCF);
//		Library.Scrolldown(500, 0);

		// WebElement childadd =
		// driver.findElement(By.xpath("//button[@id='childadd']"));

		// For Loop Started For First Item code
		Thread.sleep(6000);
		for (int i = 0; i <= 3; i++) {

			Library.Scrolldown(0, 50);
			WebElement childadd = driver.findElement(By.xpath("//button[@id='childadd']"));
			Library.Explicitlywait(childadd, 10);
			Thread.sleep(1000);
			String s = Integer.toString(i);

			if (s.equalsIgnoreCase("0")) {
				WebElement childadd1 = driver.findElement(By.xpath("//button[@id='childadd']"));
				Library.Explicitlywait(childadd1, 20);
				Library.dClick(childadd1, " Chield add Button");

				WebElement Qty1 = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]/div[6]"));
				Library.Explicitlywait(Qty1, 30);
//				Thread.sleep(5000);
//				try {Qty1.click(); Library.custom_click(Qty1, s);}catch(Exception e) {}
				Library.ActionDoubleClick(Qty1, "Quantity 1 Field");
				Library.dClick(childadd1, " Chield add Button");
				System.out.println("QUantity Field Is Enbaled");
				Thread.sleep(3000);

			}

			else {
				Thread.sleep(2000);
				Library.Explicitlywait(childadd, 10);
				Library.dClick(childadd, " Chield add Button");
			}

			System.out.println("cycle " + s);
			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 1;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD005", j, 10);
			Thread.sleep(4000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String MSG = "Qty PUOM should be in multiple of purchase conversion factor: 2 !";

			String deliverydate1 = Excel.getStringdata("POD005", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				WebElement fcalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 10);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";

				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);

			if (i == 3) {
				Deldate.sendKeys(Keys.ENTER);
			}

			Library.Scrolldown(0, -50);
		}

		// Description Of Second item Code
		Library.Scrolldown(0, -70);

		Thread.sleep(5000);
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
		Thread.sleep(3000);

		try {

			WebElement SecondItemButton = driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]/div[7]"));
			Library.Explicitlywait(SecondItemButton);

			Thread.sleep(6000);
			String itemcode2 = Excel.getStringdata("POD005", 6, 7);
			System.out.println(itemcode2);
			Thread.sleep(6000);
			JQXGRID.JQXDIRECTITEM(SecondItemButton, itemcode2);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		Thread.sleep(3000);
		WebElement warehousecode2 = driver
				.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']"));
		Library.Explicitlywait(warehousecode2, 20);

		String ware2 = Excel.getStringdata("POD005", 6, 8);
		System.out.println(ware2);
		JQXGRID.JQXDropdown(warehousecode2, ware2);
		Thread.sleep(6000);

		WebElement Qty2 = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']"));
		Library.Explicitlywait(Qty2);
		Thread.sleep(3000);

		if (Qty2.isEnabled()) {
			System.out.println("QUantity Field Is Enbaled");
			Thread.sleep(3000);
			Actions Act = new Actions(driver);
			Act.moveToElement(Qty2).doubleClick(Qty2).perform();
		}

		// For Loop for Second Item Code
		for (int i = 0; i <= 3; i++) {
			String v = Integer.toString(i + 1);
			Thread.sleep(1000);
			String s = Integer.toString(i);
			WebElement childadd = driver.findElement(By.xpath("//button[@id='childadd']"));

			Library.Explicitlywait(childadd, 5);
			Thread.sleep(2000);
			Library.dClick(childadd, " Chield add Button");
			System.out.println("cycle " + s);

			System.out.println(s);
			Thread.sleep(3000);
			int j = i + 5;
			String s1 = Integer.toString(j);

			WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));
			String Qty1 = Excel.getStringdata("POD005", j, 10);
			Thread.sleep(2000);
			Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s + " schedule");
			Qtytxtbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			String deliverydate1 = Excel.getStringdata("POD005", j, 9);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);

			if (s.equalsIgnoreCase("0")) {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']";
				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));
				// String v = Integer.toString(i + 1);
				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			else if (s.equalsIgnoreCase("1")) {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']";
				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));

				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);
			}

			else {

				String xcalendarpath = "(//div[contains(@id,'row" + s + "jqxWidget')])[1]//div[@columnindex='7']";
				WebElement calendar1 = driver.findElement(By.xpath(xcalendarpath));

				Library.Explicitlywait(calendar1, 20);
				Library.ActionDoubleClick(calendar1, "Delivery Date Field" + v);
				Thread.sleep(3000);

			}

			WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
			Library.Explicitlywait(Deldate);
			Library.custom_Sendkeys(Deldate, date1, "Delivery date " + v);

		}

		Library.Scrolldown(0, 100);
		Thread.sleep(2000);
		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");
		Thread.sleep(25000);
//	

		WebElement EditButton = driver.findElement(By.xpath("//a[contains(@class,'edibutton1 ')]"));
		Library.Explicitlywait(EditButton, 20);

		try {

			Library.dClick(EditButton, discountinput);
		}

		catch (Exception j) {
			System.out.println(j);
		}

		try {

			EditButton.click();
		}

		catch (Exception j) {
			System.out.println(j);
		}

		Thread.sleep(15000);

		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		Thread.sleep(3000);
		Library.dClick(element.getRateStryctureNextBtn());
		Thread.sleep(3000);

		Thread.sleep(15000);
		WebElement warehousecode1 = driver
				.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8'])[1]"));
		String ware1 = Excel.getStringdata("POD005", 2, 8);
		System.out.println(ware1);

		Library.Explicitlywait(warehousecode1, 30);
		JQXGRID.JQXDropdown(warehousecode1, ware1);
		Thread.sleep(6000);

		Library.Scrolldown(0, -600);
		Library.dClick(element.getSAVEBTN(), "Save button");
		Thread.sleep(15000);

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
		Library.Explicitlywait(Ponumber);
		Thread.sleep(2000);
		Library.info(Ponumber, "PO NUmber");

		try {
			WebElement Authorizecheckbox = driver
					.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

			Thread.sleep(5000);
			Thread.sleep(3000);
			Authorizecheckbox.click();

			Thread.sleep(5000);
			WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
			Thread.sleep(5000);

			Authorizebtn.click();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
		try {
			WebElement Ponumberview = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]"));
			Library.Explicitlywait(Ponumberview, 20);
			Library.ActionDoubleClick(Ponumberview, "Po Number View ");
			Thread.sleep(9000);

		}
		// ScreenRecorderUtil.stopRecord();
		catch (Exception t) {
			System.out.println(t.getMessage());
		}
	}

	 // Config Files Test Cases

	@Test(enabled = false)

	public void Test_01() throws Exception {

		// test.log(Status.INFO, "Please do automation for PO entry (Direct i.e. without
		// indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with
		// 1 delivery schedule Once finished, we will check");

		String testcasename = "automation for PO entry (Direct i.e. without indent) with 2 items and 1st item with 3 delivery schedule and 2nd item with 1 delivery schedule";
		ConfigDataProvider config = new ConfigDataProvider("pomaintenancedirect");
		// Library.login("pomaintenancedirect", testcasename);

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");
		Thread.sleep(4000);
		Library.Explicitlywait(element.getPOBASIS());
		Library.Comboclick(element.getPOBASIS(), config.getconfigdata("POBASIS"), "PO BAsis");
		Thread.sleep(5000);
		Library.Explicitlywait(element.getPODATE());

		calendar.daypicker(element.getPODATE(), config.getconfigdata("DAY"), config.getconfigdata("MONTH"),
				config.getconfigdata("YEAR"));

		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(5000);
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		Thread.sleep(5000);
		vendorsearch.click();
		vendorsearch.sendKeys(config.getconfigdata("Vendor"));
		vendorsearch.sendKeys(Keys.ENTER);
//				 JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 20);
//			 		Library.Explicitlywait(element.getVendoraddsearchbtn());
//			 		
//					Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
//					
//					
//					
//					Library.Explicitlywait(element.getBuyer());
		Library.Comboclick(element.getBuyer(), config.getconfigdata("Buyer"), "buyer");
		Thread.sleep(5000);
		Library.dClick(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Library.Explicitlywait(element.getRateStructure());
		Library.Comboclick(element.getRateStructure(), config.getconfigdata("RateStructure"), "Structure rate");
		Thread.sleep(5000);
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");

		Thread.sleep(5000);
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
//					
//					WebElement itemsearchbocfiellld=driver.findElement(By.xpath("//input[@class='jqx-input-imms jqx-widget-content-imms jqx-widget-content jqx-input-widget jqx-input jqx-widget jqx-rc-all jqx-grid-cell-edit']"));
//					Library.Explicitlywait(itemsearchbocfiellld);
//					itemsearchbocfiellld.sendKeys(config.getconfigdata("ITEMCODE"));

//					//div[contains(@id,'row0jqxWidget')]/div[6]/input
		Thread.sleep(3000);
		WebElement FirstItembtn = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]"));
		// Library.Explicitlywait(FirstItembtn);
		Thread.sleep(6000);
		FirstItembtn.click();
		// Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
		String itemcode = config.getconfigdata("ITEMCODE1");

		JQXGRID.JQXDIRECTITEM(FirstItembtn, itemcode);
//					WebElement Itemcode=driver.findElement(By.xpath("//div[text()='19021997MCB']"));
//					Library.Explicitlywait(Itemcode);
//					Thread.sleep(6000);
//				
//					Itemcode.click();
//					Itemcode.click();
//					Itemcode.sendKeys(Keys.ENTER);
		Thread.sleep(6000);

		WebElement warehousecode = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']"));
		Library.Explicitlywait(warehousecode);

		Thread.sleep(12000);
		JQXGRID.JQXDropdown(warehousecode, config.getconfigdata("WAREHOUSECODE"));
		Thread.sleep(6000);

//					WebElement actbtn=driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidge')]/div[1]/input"));
//					Library.Explicitlywait(actbtn);
//					actbtn.click();

		WebElement Qty = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]/div[6]"));
		Library.Explicitlywait(Qty);
		Thread.sleep(3000);
		Actions Act = new Actions(driver);
		if (Qty.isEnabled()) {
			Thread.sleep(3000);
			Act.moveToElement(Qty).click().perform();
		}

		WebElement childadd = driver.findElement(By.xpath("//button[@id='childadd']"));
		Library.Explicitlywait(childadd);
		childadd.click();

		WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		JQXGRID.Qtybox(Qtytxtbox, config.getconfigdata("Qty4"));
		Thread.sleep(3000);
//				
		WebElement fcalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));

		JQXGRID.Jcalendarsendkeys(fcalendor, config.getconfigdata("firstdate"));
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
		WebElement Qtytxtbox1 = driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		JQXGRID.Qtybox(Qtytxtbox1, config.getconfigdata("Qty1"));

		WebElement fcalendor1 = driver.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[1]"));

		JQXGRID.Jcalendarsendkeys(fcalendor1, config.getconfigdata("seconddate"));
		Thread.sleep(3000);
		Library.Explicitlywait(childadd);
		childadd.click();
		Thread.sleep(2000);
		childadd.click();

		WebElement Qtytxtbox2 = driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		JQXGRID.Qtybox(Qtytxtbox2, config.getconfigdata("Qty2"));

		WebElement fcalendor2 = driver.findElement(By.xpath("(//div[contains(@id,'row2jqxWidget')]/div[8])[1]"));

		JQXGRID.Jcalendarsendkeys(fcalendor2, config.getconfigdata("thirddate"));
		Library.Explicitlywait(childadd);

		Thread.sleep(2000);

		Thread.sleep(5000);
		Library.dClick(element.getItemandindentaddnewbtn(), "Add New BTN");
		Thread.sleep(3000);
		WebElement secondItembtn = driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]/div[7]"));
		// Library.Explicitlywait(secondItembtn);
		Thread.sleep(6000);
		// secondItembtn.click();
		// Library.searchwindowpopup(FirstItembtn,config.getconfigdata("ITEMCODE"));
		String itemcode2 = config.getconfigdata("ITEMCODE2");

		JQXGRID.JQXDIRECTITEM(secondItembtn, itemcode2);
		Thread.sleep(6000);
		Thread.sleep(3000);
		WebElement warehousecode1 = driver
				.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']"));
		Library.Explicitlywait(warehousecode1);

		Thread.sleep(12000);
		JQXGRID.JQXDropdown(warehousecode1, "MYWAR");
		Thread.sleep(6000);
		// childadd.click();

		// WebElement childadd=
		// driver.findElement(By.xpath("//button[@id='childadd']"));
		Library.Explicitlywait(childadd);
		childadd.click();

		WebElement Qtytxtbox3 = driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		JQXGRID.Qtybox(Qtytxtbox3, config.getconfigdata("Qty3"));
		Thread.sleep(3000);
		WebElement fcalendor4 = driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));

		JQXGRID.Jcalendarsendkeys(fcalendor4, config.getconfigdata("fourthdate"));
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

		Library.dClick(element.getSAVEBTN(), "Save button");
		Thread.sleep(8000);
//				

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
		Library.Explicitlywait(Ponumber);
		Thread.sleep(2000);
		Library.info(Ponumber, "PO NUmber");
		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

		// Library.Explicitlywait(Authorizecheckbox);
		Thread.sleep(6000);
		Authorizecheckbox.click();
		// Library.dClick(Authorizecheckbox,"Authorization check box");

		Thread.sleep(5000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Thread.sleep(5000);
		Authorizebtn.click();
		// Library.dClick(Authorizebtn,"Authorization Button");

	}

	@Test(enabled = false)
	public void m2() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider("PoMaintenanceNew");
		// Library.login("PoMaintenanceNew");

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		Thread.sleep(5000);
		Library.Explicitlywait(element.getPODATE());

		calendar.daypicker(element.getPODATE(), config.getconfigdata("DAY"), config.getconfigdata("MONTH"),
				config.getconfigdata("YEAR"));

		Library.dClick(element.getPOINFONEXTBTN());
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(5000);
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		Thread.sleep(5000);
		vendorsearch.click();
		vendorsearch.sendKeys("A001");
		vendorsearch.sendKeys(Keys.ENTER);
//	 JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		Library.Scrolldown(0, 30);
// 		Library.Explicitlywait(element.getVendoraddsearchbtn());
// 		
//		Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
//		
//		
//		
//		Library.Explicitlywait(element.getBuyer());
		Library.Comboclick(element.getBuyer(), "HKP", "buyer");
		Library.dClick(element.getVendorInfoNextBtn());
		Library.Explicitlywait(element.getRateStructure());
		Library.Comboclick(element.getRateStructure(), "PIG1", "Structure rate");

		Library.dClick(element.getRateStryctureNextBtn());

		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[5]"));
		System.out.println(config.getconfigdata("QtyPUOM"));

		JQXGRID.JQXDropdown(ele, "MYWAR");
//		Library.Explicitlywait(ele);
//		
//		ele.click();//div[contains(@id,'whCode')]
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//span[text()='MYWAR - my ware house name']")).click();
		Robot robot = new Robot();
//		 Thread.sleep(2000);	
//         robot.keyPress(KeyEvent.VK_ENTER);
//         robot.keyRelease(KeyEvent.VK_ENTER);
//         Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		Thread.sleep(3000);

		// WebElement QtyPUOM=
		// driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[8]"));
		Library.Explicitlywait(element.getQtyPUOM());
		WebElement Qtypiom = element.getQtyPUOM();
		// Library.dClick(Qtypiom);
		Thread.sleep(8000);
		// Library.custom_Sendkeys(Qtypiom, config.getconfigdata("QtyPUOM"),"QtyPUOM");
		Qtypiom.click();

		WebElement Qtytextbox = driver.findElement(By.xpath(
				"//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));
		Thread.sleep(3000);
		String Qty = config.getconfigdata("QtyPUOM");

		Thread.sleep(1500);
		Qtytextbox.sendKeys("10");
		// Qtypiom.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Library.Scrolldown(0, -600);

		Library.dClick(element.getSAVEBTN());
		Thread.sleep(8000);

		WebElement Authorizecheckbox = element.getAuthorizecheckbox();

		Library.Explicitlywait(Authorizecheckbox);
		Thread.sleep(3000);
		Library.dClick(Authorizecheckbox);

		Thread.sleep(5000);
		Library.Explicitlywait(element.getAuthorizebtn());
		Library.dClick(element.getAuthorizebtn());
		Thread.sleep(4000);

	}

	@Test(enabled = false)

	public void m1() throws Exception {

		// Library.login("PoMaintenanceNew");

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);
		ConfigDataProvider config = new ConfigDataProvider("PoMaintenanceNew");
		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		Thread.sleep(3000);
		Library.Explicitlywait(element.getPODATE());
		Library.dClick(element.getPODATE());

		calendar.daypicker(element.getPODATE(), config.getconfigdata("DAY"), config.getconfigdata("MONTH"),
				config.getconfigdata("YEAR"));
		WebElement MonthYear = driver.findElement(
				By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
		String Monthyear = MonthYear.getText();
		System.out.println(MonthYear);
		String Month1 = Monthyear.split(" ")[0];
		System.out.println("Month1");
		String Year1 = Monthyear.split(" ")[1];
		System.out.println(Year1);
		Thread.sleep(2000);

		while (!(Month1.equals("February") && Year1.equals("2021"))) {

			WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
			// Library.Explicitlywait(prebtn);
			Library.dClick(prebtn);
			MonthYear = driver.findElement(
					By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
			String nemm = MonthYear.getText();
			System.out.println(MonthYear.getText());
			Month1 = nemm.split(" ")[0];
			System.out.println(Month1);
			Year1 = nemm.split(" ")[1];
			System.out.println(Year1);
		}
		Thread.sleep(2000);
		WebElement date = driver.findElement(By.xpath("//td[text()='12']"));
		Library.dClick(date);

		WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
//	WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
//    Library.dClick(date);
		Library.dClick(element.getPOINFONEXTBTN());
		// Library.dClick(element.getVendoraddsearchbtn());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Library.Explicitlywait(element.getVendoraddsearchbtn());
		Library.vendorselect(element.getVendoraddsearchbtn(), "A001");
		Library.Explicitlywait(element.getBuyer());
		Library.Comboclick(element.getBuyer(), "HKP", "buyer");
		Library.dClick(element.getVendorInfoNextBtn());
		Library.Explicitlywait(element.getRateStructure());
		Library.Comboclick(element.getRateStructure(), "PIG1", "Structure rate");

		Library.dClick(element.getRateStryctureNextBtn());

		WebElement ele = driver.findElement(By.xpath(
				"(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms jqx-grid-cell-selected jqx-grid-cell-selected-imms jqx-fill-state-pressed jqx-fill-state-pressed-imms'])[3]"));

		ele.click();// div[contains(@id,'whCode')]

		driver.findElement(By.xpath("//span[text()='MYWAR - my ware house name']")).click();
		// div[@columnindex='9']

		// div[contains(@id,'qtypuom')]

	}

}
