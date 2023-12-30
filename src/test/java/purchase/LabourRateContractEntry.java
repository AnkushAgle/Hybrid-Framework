package purchase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.Purchasepom.LabourRateContractentry;
import com.pageobject.POMaintenanceNew;
import com.utility.BaseClass;
import com.utility.ExcelReader;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.Robott;
import com.utility.ScreenRecorderUtil;
import com.utility.calendar;

public class LabourRateContractEntry extends BaseClass {

	@Test(priority = 0)
	public void Login() throws Exception {

		Library.login("LOGIN");
	Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void LRC001() throws Exception {

		String path = Library.ExelFilepath("purchase", "LabourRateContractEntry");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String Recoedingrequired = Ecel.getCellData("POAMI001", "RECORDING(YES/NO)", 1);
		String thread = "YES";
		String sheet = "LRC001";
		String Group = Ecel.getCellData(sheet, "GROUP", 1);

		String Site = Ecel.getCellData(sheet, "SITE", 1);

		String PODate = Ecel.getCellData(sheet, "PODate", 1);

		String CONTRACTVALIDFROMDATE = Ecel.getCellData(sheet, "CONTRACTVALIDFROMDATE", 1);

		String BUYER = Ecel.getCellData(sheet, "BUYER", 1);

		String RateStructure = Ecel.getCellData(sheet, "RateStructure", 1);

		String Vendor = Ecel.getCellData(sheet, "VENDOR", 1);
		// Test case started
		LabourRateContractentry element = PageFactory.initElements(driver, LabourRateContractentry.class);
		Library.custom_click(element.getPurchasemodule(), "Purchase Module");
		Library.custom_click(element.getLabourRateContractEntry(), "Labour Rate Contract Entry");
		Library.custom_click(element.getLabourRateContractEntryaddnewbutton(),
				"Labour Rate Contract Entry add new button");

		Library.Thread(thread, 3);
		driver.navigate().refresh();
		Library.Thread(thread, 15);

		// Select Po Date

		WebElement calendor = element.getOrderDATE();
		Library.Explicitlywait(calendor, 25);

		calendar.DATEPICKER(calendor, PODate);

		Library.Thread(thread, 3);

		WebElement Contrvalidfrm = element.getContrvalidfrmDate();
		Library.Explicitlywait(Contrvalidfrm, 25);
		DATEPICKER(Contrvalidfrm, CONTRACTVALIDFROMDATE);
		Library.Thread(thread, 6);

		Library.custom_click(element.getPurchaseOrderInformationNEXTBUTTON(), "Purchase Order Information NEXTBUTTON");
		Library.Thread(thread, 5);
		try {
			JQXGRID.ITEMSearchPOPUp(element.getVendoraddsearchbtn(), Vendor);
		} catch (Exception to) {
			to.getMessage();
		}

		Library.Thread(thread, 17);

		Library.Comboclick(element.getBuyer(), BUYER, "Buyer combo box");
		Library.Thread(thread, 5);
		Library.dClick(element.getVendorInformationNEXTBUTTON(), "Vendor Information NEXT BUTTON");
		Library.Thread(thread, 5);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Ratestucure");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 50);
		Library.dClick(element.getPurchaseOrderDeliveryNextButtonNEXTBUTTON(), "Purchase Order Delivery Next Button");
		Library.Thread(thread, 5);
		Library.dClick(element.getItemDeliveryAdddBUTTON(), "Item Delivery ADD BUTTON");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 30);
		// Item code 1 selection
		String ITEMCODE1 = Ecel.getCellData(sheet, "ITEMCODE", 1);
		JQXGRID.JQXDIRECTITEMSearch(element.getItemCode1Button(), ITEMCODE1);
		Thread.sleep(18000);

		// Operation code for item code 1

		String OPCODE1 = Ecel.getCellData(sheet, "OPCODE", 1);
		System.out.println(OPCODE1);

		WebElement opcode1we = element.getItemCode1OPCODEDropdown();
		Library.Explicitlywait(opcode1we, 100);

		JQXGRID.JQXDropdown(opcode1we, OPCODE1);
		Thread.sleep(6000);

		// warehouse code for itme code 1

		String WarehouseCode1 = Ecel.getCellData(sheet, "WarehouseCode", 1);
		JQXGRID.JQXDropdown(element.getItemCode1WareHouseCODEDropdown(), WarehouseCode1);
		Thread.sleep(6000);

		// Action i delivery Button for item code 1
		Library.custom_click(element.getItemCode1DeliveryActionButton1(), "ItemCode1 Delivery ActionButton1");

		Thread.sleep(6000);

		WebElement chieldaDD = element.getChieldAddButtonButton();

		Library.dClick(chieldaDD, "Chield grid Add New Button");

		// For loop for first Item Code

		for (int i = 0; i <= 3; i++) {

			int j = i + 1;
			String deliverydate1 = Ecel.getCellData(sheet, "QUANTITYDATE", j);
			String Qty1 = Ecel.getCellData(sheet, "Quantity(PUOM)", j);
			// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);
			if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
			}

			else {
				System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(j);

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else if (s.equalsIgnoreCase("1")) {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					System.out.println("The Grid Quamtity @IS startrd");
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[1]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);
				}

				else {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);
					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);

					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);

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

				try {
					Deldate.sendKeys(Keys.ENTER);
				} catch (Exception y) {
				} // Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			if (i >= 3) {

				Library.Scrolldown(0, 30);
			} else {
			}

			Library.Scrolldown(0, -30);

		}

		Thread.sleep(6000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			element.getSAVEBTN().click();
		} catch (Exception t) {
		}

		Thread.sleep(15000);

		Library.Thread(thread, 50);
		Thread.sleep(5000);

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
		Library.Explicitlywait(Ponumber, 25);
		Thread.sleep(2000);
		Library.info(Ponumber, "LRC NUmber");

		WebElement Authorizecheckbox = driver.findElement(
				By.xpath("(//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms'])[1]"));

		Thread.sleep(5000);
		Thread.sleep(3000);
		Library.Explicitlywait(Authorizecheckbox, 10);
		Authorizecheckbox.click();

		Thread.sleep(5000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Thread.sleep(5000);
		Library.Explicitlywait(Authorizebtn, 20);
		Authorizebtn.click();

		if ((element.getLabourRateContractEntryaddnewbutton().isDisplayed()) == true) {

			Library.Savemassagelog("Labour Rate Contract Entry Authorize Successfully'.");

			System.out.println("Labour Rate Contract Entry Authorize Successfully!");
		}

	}

	@Test(priority = 2)
	public void LRC002() throws Exception {

		String path = Library.ExelFilepath("purchase", "LabourRateContractEntry");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 2);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 2);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String Recoedingrequired = Ecel.getCellData("POAMI001", "RECORDING(YES/NO)", 1);
		String thread = "YES";
		String sheet = "LRC002";
		String Group = Ecel.getCellData(sheet, "GROUP", 1);

		String Site = Ecel.getCellData(sheet, "SITE", 1);

		String PODate = Ecel.getCellData(sheet, "PODate", 1);

		String CONTRACTVALIDFROMDATE = Ecel.getCellData(sheet, "CONTRACTVALIDFROMDATE", 1);

		String BUYER = Ecel.getCellData(sheet, "BUYER", 1);

		String RateStructure = Ecel.getCellData(sheet, "RateStructure", 1);

		String Vendor = Ecel.getCellData(sheet, "VENDOR", 1);
		// Test case started
		LabourRateContractentry element = PageFactory.initElements(driver, LabourRateContractentry.class);
		Library.custom_click(element.getPurchasemodule(), "Purchase Module");
		Library.custom_click(element.getLabourRateContractEntry(), "Labour Rate Contract Entry");
		Library.custom_click(element.getLabourRateContractEntryaddnewbutton(),
				"Labour Rate Contract Entry add new button");

		Library.Thread(thread, 3);
		driver.navigate().refresh();
		Library.Thread(thread, 15);

		// Select Po Date

		WebElement calendor = element.getOrderDATE();
		Library.Explicitlywait(calendor, 25);

		calendar.DATEPICKER(calendor, PODate);

		Library.Thread(thread, 3);

		WebElement Contrvalidfrm = element.getContrvalidfrmDate();
		Library.Explicitlywait(Contrvalidfrm, 25);
		DATEPICKER(Contrvalidfrm, CONTRACTVALIDFROMDATE);
		Library.Thread(thread, 6);

		Library.custom_click(element.getPurchaseOrderInformationNEXTBUTTON(), "Purchase Order Information NEXTBUTTON");
		Library.Thread(thread, 5);
		try {
			JQXGRID.ITEMSearchPOPUp(element.getVendoraddsearchbtn(), Vendor);
		} catch (Exception to) {
			to.getMessage();
		}

		Library.Thread(thread, 17);

		Library.Comboclick(element.getBuyer(), BUYER, "Buyer combo box");
		Library.Thread(thread, 5);
		Library.dClick(element.getVendorInformationNEXTBUTTON(), "Vendor Information NEXT BUTTON");
		Library.Thread(thread, 5);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Ratestucure");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 50);
		Library.dClick(element.getPurchaseOrderDeliveryNextButtonNEXTBUTTON(), "Purchase Order Delivery Next Button");
		Library.Thread(thread, 5);
		Library.dClick(element.getItemDeliveryAdddBUTTON(), "Item Delivery ADD BUTTON");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 30);

		// Item code 1 selection
		String ITEMCODE1 = Ecel.getCellData(sheet, "ITEMCODE", 1);
		JQXGRID.JQXDIRECTITEMSearch(element.getItemCode1Button(), ITEMCODE1);
		Thread.sleep(20000);

		// Operation code for item code 1

		String OPCODE1 = Ecel.getCellData(sheet, "OPCODE", 1);
		System.out.println(OPCODE1);

		WebElement opcode1we = element.getItemCode1OPCODEDropdown();
		Library.Explicitlywait(opcode1we, 100);

		JQXGRID.JQXDropdown(opcode1we, OPCODE1);
		Thread.sleep(6000);

		// warehouse code for itme code 1

		String WarehouseCode1 = Ecel.getCellData(sheet, "WarehouseCode", 1);
		JQXGRID.JQXDropdown(element.getItemCode1WareHouseCODEDropdown(), WarehouseCode1);
		Thread.sleep(6000);

		// Action i delivery Button for item code 1
		Library.custom_click(element.getItemCode1DeliveryActionButton1(), "ItemCode1 Delivery ActionButton1");

		Thread.sleep(6000);

		WebElement chieldaDD = element.getChieldAddButtonButton();

		Library.dClick(chieldaDD, "Chield grid Add New Button");

		// For loop for first Item Code

		for (int i = 0; i <= 3; i++) {

			int j = i + 1;
			String deliverydate1 = Ecel.getCellData(sheet, "QUANTITYDATE", j);
			String Qty1 = Ecel.getCellData(sheet, "Quantity(PUOM)", j);
			// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);
			if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
			}

			else {
				System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(j);

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else if (s.equalsIgnoreCase("1")) {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					System.out.println("The Grid Quamtity @IS startrd");
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[1]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);
				}

				else {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);
					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);

					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);

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

				try {
					Deldate.sendKeys(Keys.ENTER);
				} catch (Exception y) {
				} // Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			if (i >= 3) {

				Library.Scrolldown(0, 30);
			} else {
			}

			Library.Scrolldown(0, -30);

		}

		Thread.sleep(1000);
		Library.Scrolldown(0, -20);

		// Item code 2 selection
		Library.dClick(element.getItemDeliveryAdddBUTTON(), "Item Delivery ADD BUTTON");
		String ITEMCODE2 = Ecel.getCellData(sheet, "ITEMCODE", 5);
		JQXGRID.JQXDIRECTITEMSearch(element.getItemCode2Button(), ITEMCODE2);
		Thread.sleep(18000);

		// Operation code for item code 1

		String OPCODE2 = Ecel.getCellData(sheet, "OPCODE", 5);
		System.out.println(OPCODE2);

		WebElement opcode2we = element.getItemCode2OPCODEDropdown();
		Library.Explicitlywait(opcode2we, 100);

		JQXGRID.JQXDropdown(opcode2we, OPCODE2);
		Thread.sleep(6000);

		// warehouse code for itme code 2

		String WarehouseCode2 = Ecel.getCellData(sheet, "WarehouseCode", 5);
		JQXGRID.JQXDropdown(element.getItemCode2WareHouseCODEDropdown(), WarehouseCode2);
		Thread.sleep(6000);

		// Action i delivery Button for item code 2
		Library.custom_click(element.getItemCode2DeliveryActionButton2(), "ItemCode2 Delivery ActionButton2");

		Thread.sleep(6000);

		WebElement chieldaDD2 = element.getChieldAddButtonButton();

		Library.dClick(chieldaDD2, "Chield grid Add New Button");

		// For loop for Second Item Code

		for (int i = 0; i <= 3; i++) {

			int j = i + 5;
			String deliverydate1 = Ecel.getCellData(sheet, "QUANTITYDATE", j);
			String Qty1 = Ecel.getCellData(sheet, "Quantity(PUOM)", j);
			// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);
			if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
			}

			else {
				System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(i + 1);

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else if (s.equalsIgnoreCase("1")) {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					System.out.println("The Grid Quamtity @IS startrd");
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);
				}

				else {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);
					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);

					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);

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

				try {
					Deldate.sendKeys(Keys.ENTER);
				} catch (Exception y) {
				} // Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			if (i >= 1) {

				Library.Scrolldown(0, 10);
			} else {
			}

			Library.Scrolldown(0, -10);

		}

		Thread.sleep(6000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			element.getSAVEBTN().click();
		} catch (Exception t) {
		}

		Thread.sleep(15000);

		Library.Thread(thread, 50);
		Thread.sleep(5000);

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
		Library.Explicitlywait(Ponumber, 25);
		Thread.sleep(2000);
		Library.info(Ponumber, "LRC NUmber");

		WebElement Authorizecheckbox = driver.findElement(
				By.xpath("(//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms'])[1]"));

		Thread.sleep(5000);
		Thread.sleep(3000);
		Library.Explicitlywait(Authorizecheckbox, 10);
		Authorizecheckbox.click();

		Thread.sleep(5000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Thread.sleep(5000);
		Library.Explicitlywait(Authorizebtn, 20);
		Authorizebtn.click();

		if ((element.getLabourRateContractEntryaddnewbutton().isDisplayed()) == true) {

			Library.Savemassagelog("Labour Rate Contract Entry Authorize Successfully'.");

			System.out.println("Labour Rate Contract Entry Authorize Successfully!");
		}

	}

	@Test(priority = 3)
	public void LRC003() throws Exception {

		String path = Library.ExelFilepath("purchase", "LabourRateContractEntry");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 3);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 3);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String Recoedingrequired = Ecel.getCellData("POAMI001", "RECORDING(YES/NO)", 1);
		String thread = "YES";
		String sheet = "LRC003";
		String Group = Ecel.getCellData(sheet, "GROUP", 1);

		String Site = Ecel.getCellData(sheet, "SITE", 1);

		String PODate = Ecel.getCellData(sheet, "PODate", 1);

		String CONTRACTVALIDFROMDATE = Ecel.getCellData(sheet, "CONTRACTVALIDFROMDATE", 1);

		String BUYER = Ecel.getCellData(sheet, "BUYER", 1);

		String RateStructure = Ecel.getCellData(sheet, "RateStructure", 1);

		String Vendor = Ecel.getCellData(sheet, "VENDOR", 1);
		// Test case started
		LabourRateContractentry element = PageFactory.initElements(driver, LabourRateContractentry.class);
		Library.custom_click(element.getPurchasemodule(), "Purchase Module");
		Library.custom_click(element.getLabourRateContractEntry(), "Labour Rate Contract Entry");
		Library.custom_click(element.getLabourRateContractEntryaddnewbutton(),
				"Labour Rate Contract Entry add new button");

		Library.Thread(thread, 3);
		driver.navigate().refresh();
		Library.Thread(thread, 15);

		// Select Po Date

		WebElement calendor = element.getOrderDATE();
		Library.Explicitlywait(calendor, 25);

		calendar.DATEPICKER(calendor, PODate);

		Library.Thread(thread, 3);

		WebElement Contrvalidfrm = element.getContrvalidfrmDate();
		Library.Explicitlywait(Contrvalidfrm, 25);
		DATEPICKER(Contrvalidfrm, CONTRACTVALIDFROMDATE);
		Library.Thread(thread, 6);

		Library.custom_click(element.getPurchaseOrderInformationNEXTBUTTON(), "Purchase Order Information NEXTBUTTON");
		Library.Thread(thread, 5);
		try {
			JQXGRID.ITEMSearchPOPUp(element.getVendoraddsearchbtn(), Vendor);
		} catch (Exception to) {
			to.getMessage();
		}

		Library.Thread(thread, 17);

		Library.Comboclick(element.getBuyer(), BUYER, "Buyer combo box");
		Library.Thread(thread, 5);
		Library.dClick(element.getVendorInformationNEXTBUTTON(), "Vendor Information NEXT BUTTON");
		Library.Thread(thread, 5);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Ratestucure");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 50);
		Library.dClick(element.getPurchaseOrderDeliveryNextButtonNEXTBUTTON(), "Purchase Order Delivery Next Button");
		Library.Thread(thread, 5);
		Library.dClick(element.getItemDeliveryAdddBUTTON(), "Item Delivery ADD BUTTON");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 30);

		// Item code 1 selection
		String ITEMCODE1 = Ecel.getCellData(sheet, "ITEMCODE", 1);
		JQXGRID.JQXDIRECTITEMSearch(element.getItemCode1Button(), ITEMCODE1);
		Thread.sleep(20000);

		// Operation code for item code 1

		String OPCODE1 = Ecel.getCellData(sheet, "OPCODE", 1);
		System.out.println(OPCODE1);

		WebElement opcode1we = element.getItemCode1OPCODEDropdown();
		Library.Explicitlywait(opcode1we, 100);

		JQXGRID.JQXDropdown(opcode1we, OPCODE1);
		Thread.sleep(6000);
		// Work Order Number for 1

		String WOCODE1 = Ecel.getCellData(sheet, "WORKORDERNUMBER", 1);
		System.out.println(WOCODE1);

		WebElement WOCODE1we = element.getItemCode1workorderNumberDropdown();
		Library.Explicitlywait(WOCODE1we, 100);

		JQXGRID.JQXDropdown(WOCODE1we, WOCODE1);
		Thread.sleep(6000);

		// warehouse code for itme code 1

		String WarehouseCode1 = Ecel.getCellData(sheet, "WarehouseCode", 1);
		JQXGRID.JQXDropdown(element.getItemCode1WareHouseCODEDropdown(), WarehouseCode1);
		Thread.sleep(6000);

		// Action i delivery Button for item code 1
		Library.custom_click(element.getItemCode1DeliveryActionButton1(), "ItemCode1 Delivery ActionButton1");

		Thread.sleep(6000);

		WebElement chieldaDD = element.getChieldAddButtonButton();

		Library.dClick(chieldaDD, "Chield grid Add New Button");

		// For loop for first Item Code

		for (int i = 0; i <= 3; i++) {

			int j = i + 1;
			String deliverydate1 = Ecel.getCellData(sheet, "QUANTITYDATE", j);
			String Qty1 = Ecel.getCellData(sheet, "Quantity(PUOM)", j);
			// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);
			if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
			}

			else {
				System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(j);

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else if (s.equalsIgnoreCase("1")) {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					System.out.println("The Grid Quamtity @IS startrd");
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[1]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);
				}

				else {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);
					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);

					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);

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

				try {
					Deldate.sendKeys(Keys.ENTER);
				} catch (Exception y) {
				} // Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			if (i >= 3) {

				Library.Scrolldown(0, 30);
			} else {
			}

			Library.Scrolldown(0, -30);

		}

		Thread.sleep(1000);
		Library.Scrolldown(0, -20);

		
		
		
		
		
		
		
		// Item code 2 selection
		Library.dClick(element.getItemDeliveryAdddBUTTON(), "Item Delivery ADD BUTTON");
		String ITEMCODE2 = Ecel.getCellData(sheet, "ITEMCODE", 5);
		JQXGRID.JQXDIRECTITEMSearchtemp(element.getItemCode2Button(), ITEMCODE2);
		Thread.sleep(18000);

		// Operation code for item code 1

		String OPCODE2 = Ecel.getCellData(sheet, "OPCODE", 5);
		System.out.println(OPCODE2);

		WebElement opcode2we = element.getItemCode2OPCODEDropdown();
		Library.Explicitlywait(opcode2we, 100);

		JQXGRID.JQXDropdown(opcode2we, OPCODE2);
		Thread.sleep(6000);
		
		// Work Order Number for 2

				String WOCODE2 = Ecel.getCellData(sheet, "WORKORDERNUMBER", 5);
				System.out.println(WOCODE2);

				WebElement WOCODE2we = element.getItemCode2workorderNumberDropdown();
				Library.Explicitlywait(WOCODE2we, 100);

				JQXGRID.JQXDropdown(WOCODE2we, WOCODE2);
				Thread.sleep(6000);
		
		

		// warehouse code for itme code 2

		String WarehouseCode2 = Ecel.getCellData(sheet, "WarehouseCode", 5);
		JQXGRID.JQXDropdown(element.getItemCode2WareHouseCODEDropdown(), WarehouseCode2);
		Thread.sleep(6000);

		// Action i delivery Button for item code 2
		Library.custom_click(element.getItemCode2DeliveryActionButton2(), "ItemCode2 Delivery ActionButton2");

		Thread.sleep(6000);

		WebElement chieldaDD2 = element.getChieldAddButtonButton();

		Library.dClick(chieldaDD2, "Chield grid Add New Button");

		// For loop for Second Item Code

		for (int i = 0; i <= 3; i++) {

			int j = i + 5;
			String deliverydate1 = Ecel.getCellData(sheet, "QUANTITYDATE", j);
			String Qty1 = Ecel.getCellData(sheet, "Quantity(PUOM)", j);
			// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);
			if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
			}

			else {
				System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(i + 1);

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else if (s.equalsIgnoreCase("1")) {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					System.out.println("The Grid Quamtity @IS startrd");
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);
				}

				else {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);
					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);

					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);

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

				try {
					Deldate.sendKeys(Keys.ENTER);
				} catch (Exception y) {
				} // Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			if (i >= 1) {

				Library.Scrolldown(0, 10);
			} else {
			}

			Library.Scrolldown(0, -10);

		}

		Thread.sleep(1000);
		Library.Scrolldown(0, -180);
	
		Thread.sleep(1000);
		
		// Item code 3 selection
		Library.dClick(element.getItemDeliveryAdddBUTTON(), "Item Delivery ADD BUTTON");
		String ITEMCODE3 = Ecel.getCellData(sheet, "ITEMCODE", 9);
		JQXGRID.JQXDIRECTITEMSearch(element.getItemCode3Button(), ITEMCODE3);
		Thread.sleep(18000);

		// Operation code for item code 1

		String OPCODE3 = Ecel.getCellData(sheet, "OPCODE", 9);
		System.out.println(OPCODE3);

		WebElement opcode3we = element.getItemCode3OPCODEDropdown();
		Library.Explicitlywait(opcode3we, 100);

		JQXGRID.JQXDropdown(opcode3we, OPCODE3);
		Thread.sleep(6000);
		
		// Work Order Number for 2

				String WOCODE3 = Ecel.getCellData(sheet, "WORKORDERNUMBER", 9);
				System.out.println(WOCODE3);

				WebElement WOCODE3we = element.getItemCode3workorderNumberDropdown();
				Library.Explicitlywait(WOCODE3we, 100);

				JQXGRID.JQXDropdown(WOCODE3we, WOCODE3);
				Thread.sleep(6000);
		
		

		// warehouse code for itme code 2

		String WarehouseCode3 = Ecel.getCellData(sheet, "WarehouseCode", 9);
		JQXGRID.JQXDropdown(element.getItemCode3WareHouseCODEDropdown(), WarehouseCode3);
		Thread.sleep(6000);

		// Action i delivery Button for item code 2
		Library.custom_click(element.getItemCode3DeliveryActionButton2(), "ItemCode3 Delivery ActionButton3");

		Thread.sleep(6000);

		WebElement chieldaDD3 = element.getChieldAddButtonButton();

		Library.dClick(chieldaDD3, "Chield grid Add New Button");

		// For loop for Second Item Code

		for (int i = 0; i <= 0; i++) {

			int j = i + 9;
			String deliverydate1 = Ecel.getCellData(sheet, "QUANTITYDATE", j);
			String Qty1 = Ecel.getCellData(sheet, "Quantity(PUOM)", j);
			// String a=Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", 1);
			String date1 = deliverydate1.replaceAll("/", "");

			System.out.println(date1);
			if (deliverydate1.equalsIgnoreCase("NODATAPRESENT") && Qty1.equalsIgnoreCase("NODATAPRESENT")) {
			}

			else {
				System.out.println(deliverydate1 + "of the Item Code Quantity==" + Qty1);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(i + 1);

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

				}

				else if (s.equalsIgnoreCase("1")) {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					System.out.println("The Grid Quamtity @IS startrd");
					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[2]"));

					Library.Explicitlywait(Quamtitygrid1, 20);

					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);
					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);
				}

				else {
					Library.dClick(chieldaDD, "Chield grid Add New Button");

					Thread.sleep(3000);

					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[1]"));

					Library.Explicitlywait(Quamtitygrid1, 20);
					Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					try {
						Library.dClick(Quamtitygrid1, "Quantity grid" + s1);
					} catch (Exception t) {
					}

					Thread.sleep(3000);

					WebElement Qtytxtbox = driver.findElement(By.xpath("//div[contains(@id,'puom')]//input"));

					Thread.sleep(2000);
					Library.custom_Sendkeys(Qtytxtbox, Qty1, "Quantity for delivery " + s1 + " schedule");
					Qtytxtbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);

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

				try {
					Deldate.sendKeys(Keys.ENTER);
				} catch (Exception y) {
				} // Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}

			if (i >= 1) {

				Library.Scrolldown(0, 10);
			} else {
			}

			Library.Scrolldown(0, -10);

		}

		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(6000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			element.getSAVEBTN().click();
		} catch (Exception t) {
		}

		Thread.sleep(15000);

		Library.Thread(thread, 30);
		Thread.sleep(5000);

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[7]/div"));
		Library.Explicitlywait(Ponumber, 25);
		Thread.sleep(2000);
		Library.info(Ponumber, "LRC NUmber");

//		WebElement Authorizecheckbox = driver.findElement(
//				By.xpath("(//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms'])[1]"));
//
//		Thread.sleep(5000);
//		Thread.sleep(3000);
//		Library.Explicitlywait(Authorizecheckbox, 10);
//		Authorizecheckbox.click();
//
//		Thread.sleep(5000);
//		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
//		Thread.sleep(5000);
//		Library.Explicitlywait(Authorizebtn, 20);
//		//Authorizebtn.click();

//		if ((element.getLabourRateContractEntryaddnewbutton().isDisplayed()) == true) {
//
//			Library.Savemassagelog("Labour Rate Contract Entry Authorize Successfully'.");
//
//			System.out.println("Labour Rate Contract Entry Authorize Successfully!");
//		}

	}

	public static void DATEPICKER(WebElement element, String Date) throws Exception {

		String b = Date.replaceAll("/", "");
		String Mth = b.substring(2, 4);
		String Year = b.substring(4, 8);
		String Month = Library.MONTH(Mth);

		String Day = b.substring(0, 2);

		if (Day.startsWith("0")) {

			String dayy = Day.substring(1, 2);
			Library.Explicitlywait(element);
			Library.dClick(element, "Calendor Field");
			Thread.sleep(3000);
			WebElement MonthYear = driver.findElement(By.xpath(
					"(//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')])[3]"));
			Library.Explicitlywait(MonthYear);
			String Monthyear = MonthYear.getText();
			System.out.println(MonthYear);
			String Month1 = Monthyear.split(" ")[0];
			System.out.println(Month1);
			String Year1 = Monthyear.split(" ")[1];
			System.out.println(Year1);

			// String Year=Integer.toString(year);
			while (!(Month1.equals(Month) && Year1.equals(Year))) {

				WebElement prebtn = driver
						.findElement(By.xpath("(//td[contains(@id,'leftNavigationArrowViewinne')]/div)[3]"));
				Library.Explicitlywait(prebtn);
				Library.dClick(prebtn, "previous");
				MonthYear = driver.findElement(By.xpath(
						"(//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')])[3]"));
				String nemm = MonthYear.getText();
				System.out.println(MonthYear.getText());
				Month1 = nemm.split(" ")[0];
				System.out.println(Month1);
				Year1 = nemm.split(" ")[1];
				System.out.println(Year1);

			}
			int day = Integer.parseInt(Day);
			if (day > 0 && day <= 31) {
				WebElement date = driver.findElement(By.xpath("(//td[text()='" + dayy + "'])[3]"));
				WebElement Monthyyear = driver.findElement(By.xpath(
						"(//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')])[3]"));
				Library.dClick(date, Monthyyear.getText() + "Date_");

				// test.log(Status.PASS, "Date succesfully selecte==" + Day +
				// Monthyyear.getText());
//		Click Sucessfully==10==Date_October 2022
			} else {
				// test.fail("Wrong date");
				System.out.println("Wrong date");
			}

		}

		else {

			Library.Explicitlywait(element);
			Library.dClick(element, "Calendor Field");
			Thread.sleep(3000);
			WebElement MonthYear = driver.findElement(By.xpath(
					"(//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')])[3]"));
			Library.Explicitlywait(MonthYear);
			String Monthyear = MonthYear.getText();
			System.out.println(MonthYear);
			String Month1 = Monthyear.split(" ")[0];
			System.out.println(Month1);
			String Year1 = Monthyear.split(" ")[1];
			System.out.println(Year1);
			Thread.sleep(2000);
			// String Year=Integer.toString(year);
			while (!(Month1.equals(Month) && Year1.equals(Year))) {

				WebElement prebtn = driver
						.findElement(By.xpath("(//td[contains(@id,'leftNavigationArrowViewinne')]/div)[3]"));
				Library.Explicitlywait(prebtn);
				Library.dClick(prebtn, "previous");
				MonthYear = driver.findElement(By.xpath(
						"(//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')])[3]"));
				String nemm = MonthYear.getText();
				System.out.println(MonthYear.getText());
				Month1 = nemm.split(" ")[0];
				System.out.println(Month1);
				Year1 = nemm.split(" ")[1];
				System.out.println(Year1);

			}
			int day = Integer.parseInt(Day);
			if (day > 0 && day <= 31) {
				WebElement date = driver.findElement(By.xpath("(//td[text()='" + Day + "'])[3]"));
				WebElement Monthyyear = driver.findElement(By.xpath(
						"(//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')])[3]"));
				Library.dClick(date, Monthyyear.getText() + "Date_");

				// test.log(Status.PASS, "Date succesfully selecte==" + Day +
				// Monthyyear.getText());
//		Click Sucessfully==10==Date_October 2022
			} else {
				// test.fail("Wrong date");
				System.out.println("Wrong date");
			}

		}

	}

}
