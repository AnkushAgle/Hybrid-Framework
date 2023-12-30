package purchase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Purchasepom.POAmendmentnew;
import com.Purchasepom.POMaintenanceNew;
import com.aventstack.extentreports.Status;
import com.utility.BaseClass;
import com.utility.ExcelReader;
import com.utility.Library;
import com.utility.ScreenRecorderUtil;
import com.utility.calendar;

public class POAmendmentNew extends BaseClass {

	@Test

	public void Login() throws Exception {

		Library.login("LOGIN");
		// Thread.sleep(10000);
	}
 
	// Amendment PO Indent Based Item
	@Test

	public void POAMI001() throws Exception {

		String path = Library.ExelFilepath("purchase", "POAmendmentNew");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String Recoedingrequired = Ecel.getCellData("POAMI001", "RECORDING(YES/NO)", 1);
		String thread = "YES";

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POAMI001");
		}

		String POBASIS = Ecel.getCellData("POAMI001", "POBASIS", 1);

		String Year = Ecel.getCellData("POAMI001", "Year", 1);

		String Group = Ecel.getCellData("POAMI001", "Group", 1);

		String Site = Ecel.getCellData("POAMI001", "Site", 1);

		String PONumber = Ecel.getCellData("POAMI001", "PONumber", 1);

		String AmendmentDate = Ecel.getCellData("POAMI001", "AmendmentDate", 1);

		String Vendor = Ecel.getCellData("POAMI001", "Vendor", 1);

		String Reason = Ecel.getCellData("POAMI001", "Reason", 1);

		String RateStucture = Ecel.getCellData("POAMI001", "RateStucture", 1);

		POAmendmentnew element = PageFactory.initElements(driver, POAmendmentnew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOAmendmentNew(), "Po  Amendment New");

		Library.custom_click(element.getPOAmendmentNewADDNEWBUTTON(), "Add New Btn");
		System.out.println(TestcaseID + testcasedesc);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		driver.navigate().refresh();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// Library.Comboclick(element.getPOBasis(), POBASIS, "PO Basis");// For
		// selecting po basis

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOYEAR(), Year, "PO Year");// for selecting po year
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOGroup(), Group, "Group");// for selecting po group
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOSite(), Site, "Site");// for selecting po site

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPONUMBER(), PONumber, "PO NUMBER ");// for selecting po site
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(20000);
		}

		WebElement calendor = driver.findElement(By.xpath(
				"(//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms'])[5]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(calendor));

		// Library.Explicitlywait(calendor, 50);

		String a = Ecel.getCellData("POAMI001", "AmendmentDate", 1);
		System.out.println(a);

		DATEPICKER(calendor, a);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.dClick(element.getPurchaseOrderInformationNextButtonNEXTBUTTON(), "P0 information Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.Scrolldown(0, 150);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getReasons(), Reason, "Reasons ");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Scrolldown(0, 70);

		Library.dClick(element.getVendorInfoNEXTBUTTON(), "Vendor Information Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// Library.Comboclick(element.getRateStucture(), RateStucture, "RateStucture");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.dClick(element.getPurchaseorderdeliverydetailsNEXTBUTTON(), "PO Delivery Details  Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// ITEM ONE Details is Starting

		String ItemCode1 = element.getItemCode1().getText();
		System.out.println(ItemCode1);

		if (!(ItemCode1 == null)) {

			String QtyPUOM1 = Ecel.getCellData("POAMI001", "Qty(PUOM)", 1);

			Library.dClick(element.getItemCodeQuantityPUOM1(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);
				Library.Scrolldown(0, 150);
			}

			// For Loop For First Item COdeA Fter Entering PUOM

			for (int i = 0; i <= 4; i++) {

				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println("The Information Of Grid  " + s);
				if (thread.equalsIgnoreCase("yes")) {
					Thread.sleep(3000);
				}
				int j = i + 1;
				String s1 = Integer.toString(j);

				try {

					WebElement IndentnumChield1 = driver.findElement(
							By.xpath("(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row" + s
									+ "jqxWidget')]//div[@columnindex='0']//div[1]"));
					Library.Explicitlywait(IndentnumChield1, 10);
					String IndentNum = IndentnumChield1.getText();

					Library.massagelog("indent Number==" + IndentNum);

				}

				catch (Exception m) {
					System.out.println(m);
				}

				WebElement ChieldDate1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']//div[1]"));

				ChieldDate1.getText();

				Library.massagelog("The Default Delivery Date is==" + ChieldDate1.getText());

				// (//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']

				Library.Scrolldown(0, 50);
				Thread.sleep(5000);

				////// pass this step

				try {
					WebElement PendingPOQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='8']//div[1]"));
					Library.Explicitlywait(PendingPOQtyIUOM, 5);
					PendingPOQtyIUOM.getText();

					Library.massagelog("Pending PO Qty. (IUOM) for indent " + "==" + PendingPOQtyIUOM.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				try {
					WebElement IndentQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']//div[1]"));
					Library.Explicitlywait(IndentQtyIUOM, 5);
					IndentQtyIUOM.getText();

					Library.massagelog("Indent Qty. (IUOM) for indent" + s1 + "==" + ChieldDate1.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				// Error Occures in this step
				try {
					if ((s.equalsIgnoreCase("0"))) {
						System.out.println("S is EQuals to Zero");

						WebElement ChieldDateField1 = driver.findElement(By.xpath(
								"(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']//div"));
						Library.Explicitlywait(ChieldDateField1, 10);
						ChieldDateField1.click();
						// Library.dClick(ChieldDateField1, "chield date Field 1");

						Robot robott = new Robot();
						System.out.println("Robot Class Is Started");
						Thread.sleep(1000);
						robott.keyPress(KeyEvent.VK_ENTER);
						robott.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(1000);

						// Library.dClick(ChieldDateField1, "chield date Field 1");
					}

					else {
						System.out.println("S is EQuals to  Not Equals To ZeroZero");
						WebElement ChieldDateField1 = driver.findElement(
								By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']"));
						Library.Explicitlywait(ChieldDateField1, 10);

						Library.dClick(ChieldDateField1, "Delivery Date 1");
					}

				}

				catch (Exception u) {
					System.out.println(u);
				}

				Thread.sleep(3000);

				try {
					if (s.equals("0")) {

						WebElement ChieldDateField2 = driver.findElement(By.xpath(
								"(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']//div"));

						ChieldDateField2.click();
					}
				} catch (Exception t) {
				}

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);

				String PODATE1 = Ecel.getCellData("POAMI001", "ITEMCODE Delivery Dates", j);
				System.out.println(PODATE1);

				// Excel.getStringdata("POI004", , 9);
				String date1 = PODATE1.replaceAll("/", "");
				Thread.sleep(2000);
				Robot robot = new Robot();
				Library.custom_Sendkeys(POINPUTDATEFIELD, date1, "Po delivery Date1 ");
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				try {

					WebElement popup = driver.findElement(By.xpath("//button[text()='No']"));
					Library.Explicitlywait(popup, 10);
					popup.click();

				} catch (Exception t) {
					System.out.println(t.getMessage());

				}

				Thread.sleep(6000);

				WebElement ChielQuantitiyField1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='9']"));
				Library.Explicitlywait(ChielQuantitiyField1, 10);
				Library.dClick(ChielQuantitiyField1, "TheCurrent PO Qty. (IUOM) For Indent " + s1 + "");
				int h = j + 1;
				String QtyPUOM = Ecel.getCellData("POAMI001", "Delivery Qty", j);
				System.out.println("Delivery Quantity for TheCurrent PO Qty. (IUOM) For Indent" + s1);

				// stop
				WebElement Qtyinput = driver.findElement(By.xpath("//div[contains(@id,'pilqtyiuom')]//input[1]"));
				Library.Explicitlywait(Qtyinput, 10);

				Library.custom_Sendkeys(Qtyinput, QtyPUOM, "TheCurrent PO Qty. (IUOM) For Indent " + s1);
				Robot robot1 = new Robot();
				robot1.keyPress(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_ENTER);

				Thread.sleep(2000);
				Library.Scrolldown(0, -50);

			}
		}

		// ITEM TWO Details is Starting
		Thread.sleep(2000);
		Library.Scrolldown(0, -150);
		Thread.sleep(2000);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		String QtyPUOM2 = Ecel.getCellData("POAMI001", "Qty(PUOM)", 7);

		Library.dClick(element.getItemCodeQuantityPUOM2(), "ItemCodeQuantityPUOM2()");
		Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM2, "ItemCodeQuantityPUOM2");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		for (int i = 0; i < 20; i++) {
			Thread.sleep(100);
			Library.Scrolldown(0, 15);
			Thread.sleep(100);
		}

		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			Library.dClick(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
		}

		try {
			Library.custom_click(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
			System.out.println();
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(10000);
		}

		WebElement Addbtn = element.getPOAmendmentNewADDNEWBUTTON();

		if ((Addbtn.isDisplayed()) == true) {

			Library.Savemassagelog("PO amendment details successfully saved!");

			System.out.println("PO amendment details successfully saved!");
		}

		Thread.sleep(10000);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}
	}

// Amendment PO direct Based Item 	

	@Test

	public void POAMD001() throws Exception {

		String path = Library.ExelFilepath("purchase", "POAmendmentNew");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 2);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 2);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		String sheetname = "POAMD001";

		String Recoedingrequired = Ecel.getCellData(sheetname, "RECORDING(YES/NO)", 1);
		String thread = "YES";

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord(sheetname);
		}

		String POBASIS = Ecel.getCellData(sheetname, "POBASIS", 1);

		String Year = Ecel.getCellData(sheetname, "Year", 1);

		String Group = Ecel.getCellData(sheetname, "Group", 1);

		String Site = Ecel.getCellData(sheetname, "Site", 1);

		String PONumber = Ecel.getCellData(sheetname, "PONumber", 1);

		String AmendmentDate = Ecel.getCellData(sheetname, "AmendmentDate", 1);

		String Vendor = Ecel.getCellData(sheetname, "Vendor", 1);

		String Reason = Ecel.getCellData(sheetname, "Reason", 1);

		String RateStucture = Ecel.getCellData(sheetname, "RateStucture", 1);

		POAmendmentnew element = PageFactory.initElements(driver, POAmendmentnew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOAmendmentNew(), "Po  Amendment New");

		Library.custom_click(element.getPOAmendmentNewADDNEWBUTTON(), "Add New Btn");
		System.out.println(TestcaseID + testcasedesc);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		driver.navigate().refresh();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// Library.Comboclick(element.getPOBasis(), POBASIS, "PO Basis");// For
		// selecting po basis

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOBasis(), POBASIS, "PO Basis");// for selecting po year
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOYEAR(), Year, "PO Year");// for selecting po year
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOGroup(), Group, "Group");// for selecting po group
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOSite(), Site, "Site");// for selecting po site

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPONUMBER(), PONumber, "PO NUMBER ");// for selecting po site
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(20000);
		}

		WebElement calendor = driver.findElement(By.xpath(
				"(//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms'])[5]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(calendor));

		// Library.Explicitlywait(calendor, 50);

		String a = Ecel.getCellData(sheetname, "AmendmentDate", 1);
		System.out.println(a);

		DATEPICKER(calendor, a);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.dClick(element.getPurchaseOrderInformationNextButtonNEXTBUTTON(), "P0 information Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.Scrolldown(0, 150);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getReasons(), Reason, "Reasons ");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Scrolldown(0, 70);

		Library.dClick(element.getVendorInfoNEXTBUTTON(), "Vendor Information Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// Library.Comboclick(element.getRateStucture(), RateStucture, "RateStucture");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.dClick(element.getPurchaseorderdeliverydetailsNEXTBUTTON(), "PO Delivery Details  Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// ITEM ONE Details is Starting

		String ItemCode1 = element.getItemCode1Directbasedpo().getText();
		System.out.println(ItemCode1);

		if (!(ItemCode1 == null)) {

			WebElement ActionButton = driver
					.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='1'])[1]"));

			Library.Explicitlywait(ActionButton, 20);
			Library.dClick(ActionButton, "Action Button for chield grid");

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);

			}

			Thread.sleep(1500);
			Library.Scrolldown(0, 150);

			// WebElement childadd = element.getchildaddNewButton(); Button is Enabled in
			// case of

			int lastrow = Ecel.getRowCount(sheetname);

			System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

			// For Loop For First Item COdeA Fter Entering PUOM

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

					if (s.equalsIgnoreCase("0")) {
						Thread.sleep(3000);

						WebElement Quamtitygrid1 = driver.findElement(
								By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

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

					}

					else {

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

					}

					// (//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[1]

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

					}

					else {

						String xcalendarpath = "(//div[contains(@id,'row" + s
								+ "jqxWidget')])[1]//div[@columnindex='7']";

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
				}

				Library.Scrolldown(0, -30);
			}
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		for (int i = 0; i < 20; i++) {
			Thread.sleep(100);
			Library.Scrolldown(0, 15);
			Thread.sleep(100);
		}

		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			Library.dClick(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
		}

		try {
			Library.custom_click(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
			System.out.println();
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(10000);
		}

		WebElement Addbtn = element.getPOAmendmentNewADDNEWBUTTON();

		if ((Addbtn.isDisplayed()) == true) {

			Library.Savemassagelog("PO amendment details successfully saved!");

			System.out.println("PO amendment details successfully saved!");
		}

		Thread.sleep(15000);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}
	}

	// Amendment PO direct Based Item

	@Test

	public void POAMD002() throws Exception {

		String path = Library.ExelFilepath("purchase", "POAmendmentNew");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 3);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 3);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		String sheetname = "POAMD002";

		String Recoedingrequired = Ecel.getCellData(sheetname, "RECORDING(YES/NO)", 1);
		String thread = "YES";

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord(sheetname);
		}

		String POBASIS = Ecel.getCellData(sheetname, "POBASIS", 1);

		String Year = Ecel.getCellData(sheetname, "Year", 1);

		String Group = Ecel.getCellData(sheetname, "Group", 1);

		String Site = Ecel.getCellData(sheetname, "Site", 1);

		String PONumber = Ecel.getCellData(sheetname, "PONumber", 1);

		System.out.println("The Po Number Is +Ponumber" + PONumber);

		String AmendmentDate = Ecel.getCellData(sheetname, "AmendmentDate", 1);

		String Vendor = Ecel.getCellData(sheetname, "Vendor", 1);

		String Reason = Ecel.getCellData(sheetname, "Reason", 1);

		String RateStucture = Ecel.getCellData(sheetname, "RateStucture", 1);

		POAmendmentnew element = PageFactory.initElements(driver, POAmendmentnew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOAmendmentNew(), "Po  Amendment New");

		Library.custom_click(element.getPOAmendmentNewADDNEWBUTTON(), "Add New Btn");
		System.out.println(TestcaseID + testcasedesc);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		driver.navigate().refresh();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// Library.Comboclick(element.getPOBasis(), POBASIS, "PO Basis");// For
		// selecting po basis

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOBasis(), POBASIS, "PO Basis");// for selecting po year
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOYEAR(), Year, "PO Year");// for selecting po year
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOGroup(), Group, "Group");// for selecting po group
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPOSite(), Site, "Site");// for selecting po site

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getPONUMBER(), PONumber, "PO NUMBER ");// for selecting po site
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(20000);
		}

		WebElement calendor = driver.findElement(By.xpath(
				"(//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms'])[5]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(calendor));

		// Library.Explicitlywait(calendor, 50);

		String a = Ecel.getCellData(sheetname, "AmendmentDate", 1);
		System.out.println(a);

		DATEPICKER(calendor, a);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.dClick(element.getPurchaseOrderInformationNextButtonNEXTBUTTON(), "P0 information Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.Scrolldown(0, 150);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Comboclick(element.getReasons(), Reason, "Reasons ");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.Scrolldown(0, 70);

		Library.dClick(element.getVendorInfoNEXTBUTTON(), "Vendor Information Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// Library.Comboclick(element.getRateStucture(), RateStucture, "RateStucture");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		Library.dClick(element.getPurchaseorderdeliverydetailsNEXTBUTTON(), "PO Delivery Details  Next Button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		// ITEM ONE Details is Starting

		String ItemCode1 = element.getItemCode1Directbasedpo().getText();
		System.out.println(ItemCode1);

		if (!(ItemCode1 == null)) {

			WebElement ActionButton = driver
					.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='1'])[1]"));

			Library.Explicitlywait(ActionButton, 20);
			Library.dClick(ActionButton, "Action Button for chield grid");

			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(6000);

			}

			Thread.sleep(1500);
			Library.Scrolldown(0, 150);

			// WebElement childadd = element.getchildaddNewButton(); Button is Enabled in
			// case of

			int lastrow = Ecel.getRowCount(sheetname);

			System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

			// For Loop For First Item COdeA Fter Entering PUOM

			
			
			
			for (int i = 0; i <=3; i++) {

				int j = i + 1;
				String deliverydate1 = Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", j);
				String Qty1 = Ecel.getCellData(sheetname, "Delivery Qty", j);
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

					String data = Ecel.getCellData("Testcases", "TestCase Desc", j);

					String s1 = Integer.toString(j);

					if (s.equalsIgnoreCase("0")) {
						Thread.sleep(3000);

						WebElement Quamtitygrid1 = driver.findElement(
								By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

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

						System.out.println("The Grid Quamtity @IS startrd");
						Thread.sleep(3000);

						WebElement Quamtitygrid1 = driver.findElement(
								By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[2]"));

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
						
						
						String xcalendarpath = "(//div[contains(@id,'row" + s
								+ "jqxWidget')])[1]//div[@columnindex='7']";

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
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		
		// Details OF Second Item Code

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		
		
		
        Library.Thread(thread, 6);
		
		Library.Scrolldown(0, -150);
		
		Thread.sleep(6000);
		
		
		
		
		
		
		String ItemCode2 = element.getItemCode2Directbasedpo().getText();
		System.out.println(ItemCode2);

		if (!(ItemCode2 == null)) {

			WebElement ActionButton = driver
					.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='1'])[1]"));

			Library.Explicitlywait(ActionButton, 20);
			Library.dClick(ActionButton, "Action Button for chield grid 2");

			  Library.Thread(thread, 6);

			Thread.sleep(1500);
			Library.Scrolldown(0, 150);

			// WebElement childadd = element.getchildaddNewButton(); Button is Enabled in
			// case of

			int lastrow = Ecel.getRowCount(sheetname);

			System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

			// For Loop For Second Item Code AFter Entering PUOM

			for (int i = 0; i <=3; i++) {

				int j = i + 5;
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

					int k=i+1;
					String s1 = Integer.toString(k);

					if (s.equalsIgnoreCase("0")) {
						Thread.sleep(3000);

						WebElement Quamtitygrid1 = driver.findElement(
								By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));

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

					}

					else if (s.equalsIgnoreCase("1")) {
						Thread.sleep(3000);

						WebElement Quamtitygrid1 = driver.findElement(
								By.xpath("(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[2]"));

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

					}

					else {

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

					}

					// (//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5'])[1]

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

					}

					else if (s.equalsIgnoreCase("1")) {

						WebElement fcalendor = driver
								.findElement(By.xpath("(//div[contains(@id,'row1jqxWidget')]/div[8])[2]"));
						Library.Explicitlywait(fcalendor, 5);
						Thread.sleep(3000);
						Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
						Thread.sleep(3000);

					}

					else {

						String xcalendarpath = "(//div[contains(@id,'row" + s
								+ "jqxWidget')])[1]//div[@columnindex='7']";

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
				}

				Library.Scrolldown(0, -30);
			}
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		for (int i = 0; i < 25; i++) {
			Thread.sleep(100);
			Library.Scrolldown(0, 15);
			Thread.sleep(100);
		}

		Thread.sleep(6000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			Library.dClick(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
		}

		try {
			Library.custom_click(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
			System.out.println();
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(10000);
		}

		WebElement Addbtn = element.getPOAmendmentNewADDNEWBUTTON();

		if ((Addbtn.isDisplayed()) == true) {

			Library.Savemassagelog("PO amendment details successfully saved!");

			System.out.println("PO amendment details successfully saved!");
		}

		Thread.sleep(15000);
		

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}
	}

	// Amendment PO direct Based Item
	
	@Test  ()//(dependsOnMethods = { "POAMD002" })
	
	public void POAMD002EDIT() throws Exception {
		String path = Library.ExelFilepath("purchase", "POAmendmentNew");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String Recoedingrequired = Ecel.getCellData("POAMI001", "RECORDING(YES/NO)", 1);
		String thread = "YES";

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POAMI001");
		}

		String POBASIS = Ecel.getCellData("POAMI001", "POBASIS", 1);

		String Year = Ecel.getCellData("POAMI001", "Year", 1);

		String Group = Ecel.getCellData("POAMI001", "Group", 1);

		String Site = Ecel.getCellData("POAMI001", "Site", 1);

		String PONumber = Ecel.getCellData("POAMI001", "PONumber", 1);

		String AmendmentDate = Ecel.getCellData("POAMI001", "AmendmentDate", 1);

		String Vendor = Ecel.getCellData("POAMI001", "Vendor", 1);

		String Reason = Ecel.getCellData("POAMI001", "Reason", 1);

		String RateStucture = Ecel.getCellData("POAMI001", "RateStucture", 1);

		POAmendmentnew element = PageFactory.initElements(driver, POAmendmentnew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOAmendmentNew(), "Po  Amendment New");

		
		System.out.println(TestcaseID + testcasedesc);
		

		Thread.sleep(15000);
		
		Library.custom_click(element.getPoAmendentEditButton(), "Po amendment Edit Button");
		
		
		

		for (int i = 0; i <30; i++) {
			Thread.sleep(100);
			Library.Scrolldown(0, 15);
			Thread.sleep(100);
		}

		Thread.sleep(6000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		
		for (int i = 0; i <30; i++) {
			Thread.sleep(100);
			Library.Scrolldown(0, -15);
			Thread.sleep(100);
		}
		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			Library.dClick(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
		}

		try {
			Library.custom_click(element.getSAVEBTN(), "Save button");
		} catch (Exception e) {
			System.out.println();
		}

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(10000);
		}
		

		
		
		Library.custom_click(element.getPoAmendentDeleteButton(),"PO Amendment Delete Button ");
		
		
		Thread.sleep(5000);
		WebElement dangerbtn=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		Thread.sleep(5000);
		dangerbtn.click();
		
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
