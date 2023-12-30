package purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Purchasepom.LabourRateContractAmendment;
import com.Purchasepom.LabourRateContractentry;
import com.utility.BaseClass;
import com.utility.ExcelReader;
import com.utility.Library;
import com.utility.calendar;

public class LabourRateContractAMD extends BaseClass {

	@Test(priority = 0)
	public void Login() throws Exception {

		Library.login();
		// Thread.sleep(10000);
	}

	@Test(priority = 1)

	public void LRCAMD001() throws Exception {

		String path = Library.ExelFilepath("purchase", "LabourRateContractAmendment");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String thread = "YES";
		String sheet = "LRCAMD001";
		String Year = Ecel.getCellData(sheet, "Year", 1);

		String Group = Ecel.getCellData(sheet, "Group", 1);

		String Site = Ecel.getCellData(sheet, "Site", 1);

		String LRCNumber = Ecel.getCellData(sheet, "LRCNumber", 1);

		String AmendmentDate = Ecel.getCellData(sheet, "AmendmentDate", 1);

		String Vendor = Ecel.getCellData(sheet, "Vendor", 1);

		String Reason = Ecel.getCellData(sheet, "Reason", 1);

		String RateStucture = Ecel.getCellData(sheet, "RateStucture", 1);

		System.out.println(Year + Group + LRCNumber + AmendmentDate + Vendor + Reason + RateStucture);
		LabourRateContractAmendment element = PageFactory.initElements(driver, LabourRateContractAmendment.class);
		Library.custom_click(element.getPurchasemodule(), "Purchase Module");
		Library.custom_click(element.getLabourRateContractEntryAmendment(), "Labour Rate Contract Amendment Entry");
		Library.custom_click(element.getLabourRateContractEntryaddnewbutton(),
				"Labour Rate Contract Amendent  Entry add new button");

		Library.Thread(thread, 3);

		Library.Thread(thread, 15);

		Library.Comboclick(element.getLRCAMDYEAR(), Year, "LRC AMD YEAR");
		Library.Thread(thread, 5);

		Library.Comboclick(element.getLRCAMDGroup(), Group, "LRC AMD Group");
		Library.Thread(thread, 5);
		Library.Comboclick(element.getLRCAMDSite(), Site, "LRC AMD SITE");
		Library.Thread(thread, 10);
		Library.Comboclick(element.getLRCNUMBER(), LRCNumber, "LRC Number");
		Library.Thread(thread, 20);
		Library.Thread(thread, 5);
		Library.Scrolldown(0, -600);

		Library.Thread(thread, 5);
		WebElement calendor = element.getLRCAmendentDATE();
		Library.Explicitlywait(calendor, 25);

		DATEPICKER(calendor, AmendmentDate);

		Library.Thread(thread, 3);
		Library.Thread(thread, 3);

		Library.custom_click(element.getPurchaseOrderAmendentInformationNEXTBUTTON(),
				"Purchase Order Amendent Information NEXTBUTTON");
		Library.Thread(thread, 3);
		Library.Comboclick(element.getReasons(), Reason, "Reasons");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 70);
		Library.Thread(thread, 1);

		Library.custom_click(element.getVendorInfoNEXTBUTTON(), "Vendor Info NEXT BUTTON");
		Library.Thread(thread, 5);

		Library.Comboclick(element.getRateStucture(), RateStucture, " RateStucture");
		Library.Thread(thread, 5);
		Library.custom_click(element.getPurchaseorderdeliverydetailsNEXTBUTTON(),
				"Purchase order delivery details NEXT BUTTON");
		Library.Thread(thread, 5);

		Library.custom_click(element.getItemCode1DeliveryActionButton1(), "ItemCode1 Delivery ActionButton1");
		try {
			element.getItemCode1DeliveryActionButton1().click();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
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

				Thread.sleep(3000);

				WebElement Quamtitygrid1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[2]"));

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
						.findElement(By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 5);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

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
		}

		Library.custom_click(element.getItemCode2DeliveryActionButton2(), "ItemCode2 Delivery ActionButton2");
		try {
			element.getItemCode2DeliveryActionButton2().click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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

				Thread.sleep(3000);

				WebElement Quamtitygrid1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[2]"));

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
						.findElement(By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]/div[8])[2]"));
				Library.Explicitlywait(fcalendor, 5);
				Thread.sleep(3000);
				Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
				Thread.sleep(3000);

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
		}

		Thread.sleep(1000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			element.getSAVEBTN().click();
		} catch (Exception t) {
		}
		Library.Thread(thread, 50);

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[8]/div"));
		Library.Explicitlywait(Ponumber, 25);
		Thread.sleep(2000);
		Library.info(Ponumber, "LRC NUmber");

	}

	@Test(priority = 2)

	public void LRCAMD002() throws Exception {

		String path = Library.ExelFilepath("purchase", "LabourRateContractAmendment");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);
		String thread = "YES";
		String sheet = "LRCAMD002";
		String Year = Ecel.getCellData(sheet, "Year", 1);

		String Group = Ecel.getCellData(sheet, "Group", 1);

		String Site = Ecel.getCellData(sheet, "Site", 1);

		String LRCNumber = Ecel.getCellData(sheet, "LRCNumber", 1);

		String AmendmentDate = Ecel.getCellData(sheet, "AmendmentDate", 1);

		String Vendor = Ecel.getCellData(sheet, "Vendor", 1);

		String Reason = Ecel.getCellData(sheet, "Reason", 1);

		String RateStucture = Ecel.getCellData(sheet, "RateStucture", 1);

		System.out.println(Year + Group + LRCNumber + AmendmentDate + Vendor + Reason + RateStucture);
		LabourRateContractAmendment element = PageFactory.initElements(driver, LabourRateContractAmendment.class);
		Library.custom_click(element.getPurchasemodule(), "Purchase Module");
		Library.custom_click(element.getLabourRateContractEntryAmendment(), "Labour Rate Contract Amendment Entry");
		Library.custom_click(element.getLabourRateContractEntryaddnewbutton(),
				"Labour Rate Contract Amendent  Entry add new button");

		Library.Thread(thread, 3);

		Library.Thread(thread, 15);

		Library.Comboclick(element.getLRCAMDYEAR(), Year, "LRC AMD YEAR");
		Library.Thread(thread, 5);

		Library.Comboclick(element.getLRCAMDGroup(), Group, "LRC AMD Group");
		Library.Thread(thread, 5);
		Library.Comboclick(element.getLRCAMDSite(), Site, "LRC AMD SITE");
		Library.Thread(thread, 10);
		Library.Comboclick(element.getLRCNUMBER(), LRCNumber, "LRC Number");
		Library.Thread(thread, 20);
		Library.Thread(thread, 7);
		Library.Scrolldown(0, -600);

		Library.Thread(thread, 5);
		WebElement calendor = element.getLRCAmendentDATE();
		Library.Explicitlywait(calendor, 25);

		DATEPICKER(calendor, AmendmentDate);

		Library.Thread(thread, 3);
		Library.Thread(thread, 3);

		Library.custom_click(element.getPurchaseOrderAmendentInformationNEXTBUTTON(),
				"Purchase Order Amendent Information NEXTBUTTON");
		Library.Thread(thread, 3);
		Library.Comboclick(element.getReasons(), Reason, "Reasons");
		Library.Thread(thread, 5);
		Library.Scrolldown(0, 70);
		Library.Thread(thread, 1);

		Library.custom_click(element.getVendorInfoNEXTBUTTON(), "Vendor Info NEXT BUTTON");
		Library.Thread(thread, 5);

		Library.Comboclick(element.getRateStucture(), RateStucture, " RateStucture");
		Library.Thread(thread, 5);
		Library.custom_click(element.getPurchaseorderdeliverydetailsNEXTBUTTON(),
				"Purchase order delivery details NEXT BUTTON");
		Library.Thread(thread, 5);

		Library.custom_click(element.getItemCode1DeliveryActionButton1(), "ItemCode1 Delivery ActionButton1");
		try {
			element.getItemCode1DeliveryActionButton1().click();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
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

				Thread.sleep(3000);

				if (s.equalsIgnoreCase("0")||s.equalsIgnoreCase("1")) {
					WebElement Quamtitygrid1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='5'])[2]"));

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
							.findElement(By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]/div[8])[2]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

					WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
					Library.Explicitlywait(Deldate);
					Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
					try {
						Deldate.sendKeys(Keys.ENTER);
					} catch (Exception y) {
					}
				}

				else {

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

					WebElement fcalendor = driver
							.findElement(By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')]/div[8])[1]"));
					Library.Explicitlywait(fcalendor, 5);
					Thread.sleep(3000);
					Library.ActionDoubleClick(fcalendor, "Delivery Field 1");
					Thread.sleep(3000);

					WebElement Deldate = driver.findElement(By.xpath("//input[contains(@id,'deldate')]"));
					Library.Explicitlywait(Deldate);
					Library.custom_Sendkeys(Deldate, date1, "Delivery date " + s1);
					try {
						Deldate.sendKeys(Keys.ENTER);
					} catch (Exception y) {
					}
				}

				// Library.Explicitlywait(childadd, 5);
				Thread.sleep(2000);

				// Library.dClick(childadd, " Chield add Button");
				System.out.println("cycle " + s);
			}
		}

		Thread.sleep(1000);
		Library.Scrolldown(0, -600);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			element.getSAVEBTN().click();
		} catch (Exception t) {
		}
		Library.Thread(thread, 50);

		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[8]/div"));
		Library.Explicitlywait(Ponumber, 25);
		Thread.sleep(2000);
		Library.info(Ponumber, "LRC NUmber");

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
				WebElement date = driver.findElement(By.xpath("(//td[text()='" + dayy + "'])[4]"));
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
				WebElement date = driver.findElement(By.xpath("(//td[text()='" + Day + "'])[4]"));
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
