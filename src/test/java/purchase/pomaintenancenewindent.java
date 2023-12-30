package purchase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.Purchasepom.POMaintenanceNew;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.ScreenRecorderUtil;
//import com.utility.ScreenRecorderUtil;
import com.utility.calendar;

public class pomaintenancenewindent extends BaseClass {

	@Test

	public void Login() throws Exception {

		Library.login("LOGIN");
		// Thread.sleep(10000);
	}

	@Test
	public void POI001() throws Exception {

		ScreenRecorderUtil.startRecord("POI001");

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String TestcaseID = Excel.getStringdata("Testcases", 4, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 4, 1);// Test Case Desc
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);
		String thread = Excel.getStringdata("POI002", 1, 12);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}
		// Library.LOGIN("LOGIN");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}
		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		String PoBasiss = Excel.getStringdata("POI001", 1, 3);
		System.out.println(PoBasiss);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(12000);
		}
		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POI001", 1, 2);
		calendar.calendarinput(calendorinput, date);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(1500);
		}
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		if (thread.equalsIgnoreCase("yes")) {

			Thread.sleep(3000);
		}
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POI001", 1, 4));
		vendorsearch.sendKeys(Keys.ENTER);
		Library.Scrolldown(0, 70);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(2000);
		}
//	Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POI001", 1, 5);
		System.out.println(buyer);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		WebElement Buyer = element.getBuyer();
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(2000);
		}
		Library.Explicitlywait(Buyer, 8);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(2000);
		}
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(2000);
		}
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POI001", 1, 6);
		System.out.println(RateStructure);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		Library.custom_click(element.getPurchaseOrderDeliveryDetailsNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}
		Library.custom_click(element.getSJOandOAFSelectionNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		// Item Code 1 Description

		String ItemCode1 = element.getItemCode1().getText();
		System.out.println(ItemCode1);

		if (!(ItemCode1 == null)) {

			Library.massagelog("Description of indent item code==" + ItemCode1);
			String WareHouseCode1 = Excel.getStringdata("POI001", 1, 8);

			System.out.println(WareHouseCode1);
			JQXGRID.JQXDropdown(element.getWareHouseCode1(), WareHouseCode1);
			System.out.println(WareHouseCode1);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 5);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(4000);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			String QtyPUOM1 = Excel.getStringdata("POI001", 1, 10);
			System.out.println(QtyPUOM1);

			Library.dClick(element.getItemCodeQuantityPUOM1(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(4000);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Library.Scrolldown(0, 20);

			try {

				WebElement IndentnumChield1 = driver.findElement(By.xpath(
						"(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='0']//div[1]"));
				Library.Explicitlywait(IndentnumChield1, 5);
				String IndentNum = IndentnumChield1.getText();

				Library.massagelog("indent Number==" + IndentNum);

			}

			catch (Exception m) {
				System.out.println(m);
			}

			WebElement ChieldDate1 = driver
					.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']//div[1]"));

			ChieldDate1.getText();

			Library.massagelog("The Default Delivery Date is==" + ChieldDate1.getText());

			// (//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']

			Library.Scrolldown(0, 50);
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(3000);
			}
			WebElement ChieldDateField1 = driver
					.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']"));
			Library.Explicitlywait(ChieldDateField1, 10);

			Library.dClick(ChieldDateField1, "Delivery Date 1");////// pass this step

			WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
			Library.Explicitlywait(POINPUTDATEFIELD, 10);

			System.out.println(Excel.getStringdata("POI001", 1, 9));

			String PODATE1 = Excel.getStringdata("POI001", 1, 9);
			String date1 = PODATE1.replaceAll("/", "");
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(2000);
			}

			Library.custom_Sendkeys(POINPUTDATEFIELD, date1, "Po delivery Date1 ");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			try {

				WebElement popup = driver.findElement(By.xpath("//button[text()='Yes']"));
				Library.Explicitlywait(popup, 10);
				popup.click();

			} catch (Exception t) {
				System.out.println(t.getMessage());

			}

		}

		else {
			Library.ERRORmassagelog("No Any Item Code Present For the Details");

		}

		/// Item Code 2 description
		String ItemCode2 = element.getItemCode2().getText();
		System.out.println(ItemCode2);

		if (!(ItemCode2 == null)) {

			Library.massagelog("Description of indent item code==" + ItemCode2);
			String WareHouseCode2 = Excel.getStringdata("POI001", 2, 8);

			System.out.println(WareHouseCode2);
			JQXGRID.JQXDropdown(element.getWareHouseCode2(), WareHouseCode2);
			System.out.println(WareHouseCode2);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 7);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(4000);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			String QtyPUOM2 = Excel.getStringdata("POI001", 2, 10);
			System.out.println(QtyPUOM2);

			Library.dClick(element.getItemCodeQuantityPUOM2(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM2, "ItemCodeQuantityPUOM1");

			WebElement IndentnumChield1 = driver.findElement(By.xpath(
					"(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='0']//div[1]"));

			String IndentNum = IndentnumChield1.getText();

			Library.massagelog("indent Number==" + IndentNum);
			WebElement ChieldDate1 = driver
					.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']//div[1]"));

			ChieldDate1.getText();

			Library.massagelog("The Default Delivery Date is==" + ChieldDate1.getText());

			WebElement ChieldDateField1 = driver
					.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']"));
			Library.Explicitlywait(ChieldDateField1, 10);
			Library.dClick(ChieldDateField1, "Delivery Date 1");

			WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
			// Library.Explicitlywait(POINPUTDATEFIELD, 10);

			System.out.println(Excel.getStringdata("POI001", 2, 9));

			String PODATE2 = Excel.getStringdata("POI001", 2, 9);
			String date2 = PODATE2.replaceAll("/", "");
			Thread.sleep(2000);
			Library.custom_Sendkeys(POINPUTDATEFIELD, date2, "Po delivery Date1 ");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}

		Thread.sleep(2000);

		Library.Scrolldown(0, -600);
		Library.ActionClick(element.getSAVEBTN(), "Save button");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(8000);
		}
//		

		Library.Explicitlywait(element.getPOaddnewbutton(), 10);

		if (element.getPOaddnewbutton().isEnabled()) {

			WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			Library.Explicitlywait(Ponumber);
			Thread.sleep(2000);
			Library.info(Ponumber, "PO NUmber");

		}

		else {

		}

		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
			Thread.sleep(3000);
		}
		Authorizecheckbox.click();

		Thread.sleep(5000);

		ScreenRecorderUtil.stopRecord();

//	      Thread.sleep(5000);
//	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
//	     Thread.sleep(5000);
//	    
//	     Authorizebtn.click();

	}

	// Test CAse POI002 is Stared
	@Test

	public void POI002() throws Exception {

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");

		String Recoedingrequired = Excel.getStringdata("POI002", 1, 11);
		String str5 = Excel.getStringdata("POI002", 1, 12);
		System.out.println("static Wait IS Required==" + str5);
		System.out.println("Recording  ReQuired==" + Recoedingrequired);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POI002");
		}

		String TestcaseID = Excel.getStringdata("Testcases", 5, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 5, 1);// Test Case Desc
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);

		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		// Library.LOGIN("LOGIN");

		Thread.sleep(6000);

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		String PoBasiss = Excel.getStringdata("POI002", 1, 3);
		System.out.println(PoBasiss);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		Thread.sleep(12000);

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POI002", 1, 2);
		calendar.calendarinput(calendorinput, date);
		Thread.sleep(1500);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POI002", 1, 4));
		vendorsearch.sendKeys(Keys.ENTER);
		Library.Scrolldown(0, 70);
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
		try {

			WebElement erroemsg = driver.findElement(By.xpath("//div[contains(text(),' Buyer is required')]"));
			String errrormsg = erroemsg.getText();
			Library.ERRORmassagelog(errrormsg);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		String buyer = Excel.getStringdata("POI002", 1, 5);
		System.out.println(buyer);

		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		WebElement Buyer = element.getBuyer();
		Thread.sleep(2000);
		Library.Explicitlywait(Buyer, 8);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POI002", 1, 6);
		System.out.println(RateStructure);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		Library.custom_click(element.getPurchaseOrderDeliveryDetailsNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}
		Library.custom_click(element.getSJOandOAFSelectionNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		// For LOOP IS Started For Test Case 1

		for (int i = 0; i <= 3; i++) {

			Thread.sleep(1000);
			String s = Integer.toString(i);

			System.out.println("The Information Of Grid  " + s);
			if (str5.equalsIgnoreCase("yes")) {
				Thread.sleep(3000);
			}
			int j = i + 1;
			String s1 = Integer.toString(j);

			// Item Code 1 Description
			if (str5.equalsIgnoreCase("yes")) {
				Thread.sleep(3000);
			}

			WebElement ItemCode = driver
					.findElement(By.xpath("//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='2']//div"));
			Library.Explicitlywait(ItemCode, 10);
			String ItemCode1 = ItemCode.getText();

			System.out.println(ItemCode1);

			if (!(ItemCode1 == null)) {

				Library.massagelog("Description of indent item code==" + ItemCode1);

				String WareHouseCode1 = Excel.getStringdata("POI002", j, 8);

				System.out.println(WareHouseCode1);

				String wareHouseCodeXpath = "//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='4']";

				WebElement WAreHoseCode = driver.findElement(By.xpath(wareHouseCodeXpath));
				Library.Explicitlywait(WAreHoseCode, 10);

				JQXGRID.JQXDropdown(WAreHoseCode, WareHouseCode1);
				System.out.println(WareHouseCode1);

				try {

					Library.Explicitlywait(element.getWarehousecodepopupms(), 5);
					element.getWarehousecodepopupms().click();
				}

				catch (Exception e) {

				}
				Robot robot = new Robot();
				Thread.sleep(4000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				String QtyPUOM1 = Excel.getStringdata("POI002", j, 10);
				System.out.println(QtyPUOM1);

				WebElement Qty = driver
						.findElement(By.xpath("//div[contains(@id,'row" + s + "jqxWidget')]//div[@columnindex='9']"));

				Library.Explicitlywait(Qty, 10);

				Library.dClick(Qty, "ItemCode " + s1 + "Quantity PUOM  ");

				Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");
				Thread.sleep(4000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				Library.Scrolldown(0, 20);

				try {

					WebElement IndentnumChield1 = driver.findElement(By.xpath(
							"(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='0']//div[1]"));
					Library.Explicitlywait(IndentnumChield1, 5);
					String IndentNum = IndentnumChield1.getText();

					Library.massagelog("indent Number==" + IndentNum);

				}

				catch (Exception m) {
					System.out.println(m);
				} // (//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']

				WebElement ChieldDate1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']//div[1]"));

				ChieldDate1.getText();

				Library.massagelog("The Default Delivery Date is==" + ChieldDate1.getText());

				// (//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']

				Library.Scrolldown(0, 50);
				Thread.sleep(3000);

				// String
				// daate="(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']//div";

				Library.Scrolldown(0, 10);
				WebElement ChieldDateField1 = driver
						.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5'])[2]"));
				Library.Explicitlywait(ChieldDateField1, 20);

				Library.dClick(ChieldDateField1, "Delivery Date " + s1);////// pass this step

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);

				System.out.println(Excel.getStringdata("POI002", j, 9));

				String PODATE1 = Excel.getStringdata("POI002", j, 9);
				String date1 = PODATE1.replaceAll("/", "");
				Thread.sleep(2000);

				Library.custom_Sendkeys(POINPUTDATEFIELD, date1, "Po delivery Date1 ");
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				try {

					WebElement popup = driver.findElement(By.xpath("//button[text()='Yes']"));
					Library.Explicitlywait(popup, 10);
					popup.click();

				} catch (Exception t) {
					System.out.println(t.getMessage());

				}

			}

			else {
				Library.ERRORmassagelog("No Any Item Code Present For the Details");

			}

			Library.Scrolldown(0, -55);

		}

//
		Library.Scrolldown(0, -600);
		Library.ActionClick(element.getSAVEBTN(), "Save button");
		if (str5.equalsIgnoreCase("yes")) {
			Thread.sleep(8000);
		}
//		

		Library.Explicitlywait(element.getPOaddnewbutton(), 10);

		if (element.getPOaddnewbutton().isEnabled()) {

			WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			Library.Explicitlywait(Ponumber);
			Thread.sleep(2000);
			Library.info(Ponumber, "PO NUmber");

		}

		else {

		}

		// For Loop Is Closed

		try {
			WebElement Authorizecheckbox = driver
					.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

			if (str5.equalsIgnoreCase("yes")) {
				Thread.sleep(5000);
			}
			if (str5.equalsIgnoreCase("yes")) {
				Thread.sleep(3000);
			}
			Authorizecheckbox.click();

			if (str5.equalsIgnoreCase("yes")) {
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}

//	       if(str5.equalsIgnoreCase("yes")) {Thread.sleep(5000);}
//	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
//	      if(str5.equalsIgnoreCase("yes")) {Thread.sleep(5000);}
//	    
//	     Authorizebtn.click();

	}

// Test Case 3 Is Started

	@Test
	public void POI003() throws Exception {
		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String Recoedingrequired = Excel.getStringdata("POI003", 1, 11);
		String str5 = Excel.getStringdata("POI003", 1, 12);
		System.out.println("static Wait IS Required==" + str5);
		System.out.println("Recording  ReQuired==" + Recoedingrequired);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POI003");
		}

		String TestcaseID = Excel.getStringdata("Testcases", 6, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 6, 1);// Test Case Desc
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);

		Thread.sleep(3000);

		// Library.LOGIN("LOGIN");

		Thread.sleep(6000);

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		String PoBasiss = Excel.getStringdata("POI003", 1, 3);
		System.out.println(PoBasiss);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		Thread.sleep(12000);

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POI003", 1, 2);
		calendar.calendarinput(calendorinput, date);
		Thread.sleep(1500);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(3000);
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		Thread.sleep(5000);
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POI003", 1, 4));
		vendorsearch.sendKeys(Keys.ENTER);
		Library.Scrolldown(0, 70);
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POI003", 1, 5);
		System.out.println(buyer);

		Thread.sleep(15000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(2000);
		Library.Explicitlywait(Buyer, 20);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POI003", 1, 6);
		System.out.println(RateStructure);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Thread.sleep(3000);
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		Thread.sleep(5000);

		Library.custom_click(element.getPurchaseOrderDeliveryDetailsNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		Thread.sleep(3000);
		Library.custom_click(element.getSJOandOAFSelectionNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		Thread.sleep(3000);

		// Item Code 1 Description

		String ItemCode1 = element.getItemCode1().getText();
		System.out.println(ItemCode1);

		if (!(ItemCode1 == null)) {

			Library.massagelog("Description of indent item code==" + ItemCode1);
			String WareHouseCode1 = Excel.getStringdata("POI003", 1, 8);

			System.out.println(WareHouseCode1);
			JQXGRID.JQXDropdown(element.getWareHouseCode1(), WareHouseCode1);
			System.out.println(WareHouseCode1);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 5);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			String QtyPUOM1 = Excel.getStringdata("POI003", 1, 10);
			System.out.println(QtyPUOM1);

			Library.dClick(element.getItemCodeQuantityPUOM1(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Library.Scrolldown(0, 20);

			// For loop for the item code1

			for (int i = 0; i <= 4; i++) {

				Thread.sleep(1000);
				String s = Integer.toString(i);
				WebElement IndentnumChield1 = driver
						.findElement(By.xpath("(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row"
								+ s + "jqxWidget')]//div[@columnindex='0']//div[1]"));
				Library.Explicitlywait(IndentnumChield1, 10);
				String IndentNum = IndentnumChield1.getText();
				Library.massagelog("indent Number==" + IndentNum);
				System.out.println("The Information Of Grid  " + s);
				if (str5.equalsIgnoreCase("yes")) {
					Thread.sleep(3000);
				}
				int j = i + 1;
				String s1 = Integer.toString(j);

				try {

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

				try {

					WebElement ChieldDateField1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']"));
					Library.Explicitlywait(ChieldDateField1, 10);

					Library.dClick(ChieldDateField1, "Delivery Date 1");
				} catch (Exception u) {
					System.out.println(u);
				}
				////// pass this step

				try {
					WebElement PendingPOQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='8']//div[1]"));
					Library.Explicitlywait(PendingPOQtyIUOM, 5);
					PendingPOQtyIUOM.getText();

					Library.massagelog("Pending PO Qty. (IUOM) for indent ==" + PendingPOQtyIUOM.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				try {
					WebElement IndentQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']//div[1]"));
					Library.Explicitlywait(IndentQtyIUOM, 5);
					IndentQtyIUOM.getText();

					Library.massagelog("Indent Qty. (IUOM) for indent ==" + s1 + ChieldDate1.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);

				System.out.println(Excel.getStringdata("POI006", j, 9));

				String PODATE1 = Excel.getStringdata("POI003", j, 9);
				String date1 = PODATE1.replaceAll("/", "");
				Thread.sleep(2000);

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

				WebElement ChielQuantitiyField1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='9']"));
				Library.Explicitlywait(ChielQuantitiyField1, 10);
				Library.dClick(ChielQuantitiyField1, "TheCurrent PO Qty. (IUOM) For Indent " + s1 + "");
				int h = j + 1;
				String QtyPUOM = Excel.getStringdata("POI003", h, 10);
				System.out.println("Delivery Quantity for TheCurrent PO Qty. (IUOM) For Indent" + s1);
				WebElement Qtyinput = driver.findElement(By.xpath("//div[contains(@id,'currentpoqtyiuom')]//input[1]"));
				Library.Explicitlywait(Qtyinput, 10);
				Library.custom_Sendkeys(Qtyinput, QtyPUOM, "TheCurrent PO Qty. (IUOM) For Indent " + s1);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

			}

		}
		Thread.sleep(3000);

		Library.Scrolldown(0, -600);
		Library.ActionClick(element.getSAVEBTN(), "Save button");

		Thread.sleep(9000);
		Library.Explicitlywait(element.getPOaddnewbutton(), 10);

		if (element.getPOaddnewbutton().isEnabled()) {

			WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			Library.Explicitlywait(Ponumber);
			Thread.sleep(2000);
			Library.info(Ponumber, "PO NUmber");

		}

		else {

		}

		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));

		Thread.sleep(5000);
		Thread.sleep(3000);
		Authorizecheckbox.click();

		Thread.sleep(5000);

		Thread.sleep(10000);

		try {

			Thread.sleep(5000);
			WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
			Thread.sleep(5000);

			Authorizebtn.click();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}
//	      Thread.sleep(5000);
//	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
//	     Thread.sleep(5000);
//	    
//	     Authorizebtn.click();

	}

//Test CAse 4 Is Started 

	@Test
	public void POI004() throws Exception {
		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String Recoedingrequired = Excel.getStringdata("POI004", 1, 11);
		String str5 = Excel.getStringdata("POI004", 1, 12);
		String thread = Excel.getStringdata("POI004", 1, 12);
		System.out.println("static Wait IS Required==" + str5);
		System.out.println("Recording  ReQuired==" + Recoedingrequired);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POI004");
		}

		String TestcaseID = Excel.getStringdata("Testcases", 7, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 7, 1);// Test Case Desc
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);
		}

		// Library.LOGIN("LOGIN");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		String PoBasiss = Excel.getStringdata("POI004", 1, 3);
		System.out.println(PoBasiss);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(12000);
		}

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POI004", 1, 2);
		calendar.calendarinput(calendorinput, date);
		Thread.sleep(1500);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(3000);
		WebElement vendorsearch = element.getVendortextboxfield();
		
		
		Library.Explicitlywait(vendorsearch);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		
		try {
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POI004", 1, 4));
		
		vendorsearch.sendKeys(Keys.ENTER);
		}
		catch(Exception t) {
		Robot robott=new Robot();
		System.out.println("Robot Class Is Started");
		Thread.sleep(1000);
		robott.delay(500);
		robott.keyPress(KeyEvent.VK_ENTER);
	
		robott.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
			
			
		}
		Library.Scrolldown(0, 70);
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POI004", 1, 5);
		System.out.println(buyer);

		Thread.sleep(3000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(2000);
		Library.Explicitlywait(Buyer, 20);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POI004", 1, 6);
		System.out.println(RateStructure);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Thread.sleep(3000);
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		Library.custom_click(element.getPurchaseOrderDeliveryDetailsNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		Thread.sleep(3000);
		Library.custom_click(element.getSJOandOAFSelectionNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		Thread.sleep(3000);

		// Item Code 1 Description

		String ItemCode1 = element.getItemCode1().getText();
		System.out.println(ItemCode1);

		if (!(ItemCode1 == null)) {

			Library.massagelog("Description of indent item code==" + ItemCode1);
			String WareHouseCode1 = Excel.getStringdata("POI004", 1, 8);

			System.out.println(WareHouseCode1);
			JQXGRID.JQXDropdown(element.getWareHouseCode1(), WareHouseCode1);
			System.out.println(WareHouseCode1);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 5);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			String QtyPUOM1 = Excel.getStringdata("POI004", 1, 10);
			System.out.println(QtyPUOM1);

			Library.dClick(element.getItemCodeQuantityPUOM1(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Library.Scrolldown(0, 20);

			// For loop for the item code1

			for (int i = 0; i <= 4; i++) {

				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println("The Information Of Grid  " + s);
				if (str5.equalsIgnoreCase("yes")) {
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

				try {

					WebElement ChieldDateField1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']"));
					Library.Explicitlywait(ChieldDateField1, 10);

					Library.dClick(ChieldDateField1, "Delivery Date 1");
				} catch (Exception u) {
					System.out.println(u);
				}
				////// pass this step

				try {
					WebElement PendingPOQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='8']//div[1]"));
					Library.Explicitlywait(PendingPOQtyIUOM, 5);
					PendingPOQtyIUOM.getText();

					Library.massagelog("Pending PO Qty. (IUOM) for indent " +"==" + PendingPOQtyIUOM.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				try {
					WebElement IndentQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']//div[1]"));
					Library.Explicitlywait(IndentQtyIUOM, 5);
					IndentQtyIUOM.getText();

					Library.massagelog("Indent Qty. (IUOM) for indent ==" + s1 + ChieldDate1.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);

				System.out.println(Excel.getStringdata("POI004", j + 1, 9));

				String PODATE1 = Excel.getStringdata("POI004", j + 1, 9);
				String date1 = PODATE1.replaceAll("/", "");
				Thread.sleep(2000);

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

				WebElement ChielQuantitiyField1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='9']"));
				Library.Explicitlywait(ChielQuantitiyField1, 10);
				Library.dClick(ChielQuantitiyField1, "TheCurrent PO Qty. (IUOM) For Indent " + s1 + "");
				int h = j + 1;
				String QtyPUOM = Excel.getStringdata("POI004", h, 10);
				System.out.println("Delivery Quantity for TheCurrent PO Qty. (IUOM) For Indent" + s1);
				WebElement Qtyinput = driver.findElement(By.xpath("//div[contains(@id,'currentpoqtyiuom')]//input[1]"));
				Library.Explicitlywait(Qtyinput, 10);
				Library.custom_Sendkeys(Qtyinput, QtyPUOM, "TheCurrent PO Qty. (IUOM) For Indent " + s1+"==");
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				Thread.sleep(2000);
				Library.Scrolldown(0, -50);
			}
//Library.Scrolldown(0, -50);
		}

		else {
		}

		Thread.sleep(2000);
		Library.Scrolldown(0, -100);

		// For Lopp for Item Code 2 WAS ended
		// Item Code 2 description
		Thread.sleep(4000);

		String ItemCode2 = element.getItemCode2().getText();
		Library.Explicitlywait(element.getItemCode2(), 5);
		System.out.println("Item Code2 is Found " + ItemCode2);

		if (!(ItemCode2 == null)) {

			System.out.println("Description of indent item code==" + ItemCode2);
			Library.massagelog("Description of indent item code==" + ItemCode2);
			String WareHouseCode2 = Excel.getStringdata("POI004", 7, 8);

			System.out.println("The WareHouse Code for Item 2 is" + WareHouseCode2);
			JQXGRID.JQXDropdown(element.getWareHouseCode2(), WareHouseCode2);
			System.out.println(WareHouseCode2);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 7);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			String QtyPUOM2 = Excel.getStringdata("POI004", 7, 10);
			System.out.println(QtyPUOM2);
			Thread.sleep(1500);
			Library.dClick(element.getItemCodeQuantityPUOM2(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM2, "ItemCodeQuantityPUOM1");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// For loop for the item code2

			for (int i = 0; i <= 4; i++) {

				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println("The Information Of Grid for  Second Item Code  " + s);
				if (str5.equalsIgnoreCase("yes")) {
					Thread.sleep(3000);
				}
				int j = i + 9;
				int k = i + 1;

				String s1 = Integer.toString(k);

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

				Library.Scrolldown(0, 55);
				if (thread.equalsIgnoreCase("yes")) {
					Thread.sleep(5000);
				}

				try {
					Library.Scrolldown(0, 10);
					WebElement ChieldDateField1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']"));
					Library.Explicitlywait(ChieldDateField1, 10);

					Library.dClick(ChieldDateField1, "Delivery Date  " + s1);

				} catch (Exception u) {
					System.out.println(u);
				}
				////// pass this step

				try {
					WebElement PendingPOQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='8']//div[1]"));
					Library.Explicitlywait(PendingPOQtyIUOM, 5);
					PendingPOQtyIUOM.getText();

					Library.massagelog("Pending PO Qty. (IUOM) for indent =="+ PendingPOQtyIUOM.getText());
				}

				catch (Exception u) {
					System.out.println(u);
				}

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);
				int j1 = j - 1;
				System.out.println(Excel.getStringdata("POI004", j1, 9));

				String PODATE1 = Excel.getStringdata("POI004", j1, 9);
				String date1 = PODATE1.replaceAll("/", "");
				if (thread.equalsIgnoreCase("yes")) {
					Thread.sleep(2000);
				}

				Library.custom_Sendkeys(POINPUTDATEFIELD, date1, "Po delivery Date1 ");
				if (thread.equalsIgnoreCase("yes")) {
					Thread.sleep(1000);
					robot.delay(1000);
				}
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				try {
					WebElement IndentQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']//div[1]"));
					Library.Explicitlywait(IndentQtyIUOM, 5);
					IndentQtyIUOM.getText();

					Library.massagelog("Indent Qty. (IUOM) for indent ==" + s1 + ChieldDate1.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				try {

					WebElement popup = driver.findElement(By.xpath("//button[text()='No']"));
					Library.Explicitlywait(popup, 5);
					popup.click();

				} catch (Exception t) {
					System.out.println(t.getMessage());

				}

				WebElement ChielQuantitiyField1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='9']"));
				Library.Explicitlywait(ChielQuantitiyField1, 10);
				Library.dClick(ChielQuantitiyField1, "TheCurrent PO Qty. (IUOM) For Indent " + s1 + "");
				int h = j - 1;
				String QtyPUOM = Excel.getStringdata("POI004", h, 10);

				System.out.println("Delivery Quantity for TheCurrent PO Qty. (IUOM) For Indent" + s1 + QtyPUOM);

				WebElement Qtyinput = driver.findElement(By.xpath("//div[contains(@id,'currentpoqtyiuom')]//input[1]"));
				Library.Explicitlywait(Qtyinput, 10);
				Library.custom_Sendkeys(Qtyinput, QtyPUOM, "TheCurrent PO Qty. (IUOM) For Indent " + s1);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Library.Scrolldown(0, -50);
			}

		}

		Thread.sleep(3000);

		Library.Scrolldown(0, -600);
		Library.ActionClick(element.getSAVEBTN(), "Save button");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(9000);
		}

		try {
			Library.Explicitlywait(element.getPOaddnewbutton(), 10);
			System.out.println("The Button Is " + element.getPOaddnewbutton().isEnabled());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (element.getPOaddnewbutton().isEnabled() == true) {

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

			Thread.sleep(5000);
		}

		else {
			String Error = "Po Delivry Date for item : WOOD is less then PO Date !";
			Library.ERRORmassagelog(Error);

		}

		
    Thread.sleep(5000);;
     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
     Thread.sleep(5000);
    
     Authorizebtn.click();
     Library.massagelog("Purchase Order  Authorized SuccessFully");
     if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}

	}

	// Test Case 5 Is Started

	@Test
	public void POI005() throws Exception {

		// Declare

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String Recoedingrequired = Excel.getStringdata("POI005", 1, 11);
		String str5 = Excel.getStringdata("POI005", 1, 12);

		String thread = Excel.getStringdata("POI005", 1, 12);
		System.out.println("static Wait IS Required==" + str5);
		System.out.println("Recording  ReQuired==" + Recoedingrequired);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POI005");
		}

		String TestcaseID = Excel.getStringdata("Testcases", 8, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 8, 1);// Test Case Desc
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);

		Thread.sleep(3000);

		// Library.LOGIN("LOGIN");

		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(6000);
		}

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		String PoBasiss = Excel.getStringdata("POI005", 1, 3);
		System.out.println(PoBasiss);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(13000);
		}
		Library.Scrolldown(0, 20);
		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		String date = Excel.getStringdata("POI005", 1, 2);
		calendar.calendarinput(calendorinput, date);
		Thread.sleep(1500);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(3000);
		WebElement vendorsearch =element.getVendortextboxfield();
				//driver.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		Thread.sleep(5000);
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POI005", 1, 4));
		vendorsearch.sendKeys(Keys.ENTER);
		Library.Scrolldown(0, 70);
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POI005", 1, 5);
		System.out.println(buyer);

		Thread.sleep(3000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(2000);
		Library.Explicitlywait(Buyer, 50);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POI005", 1, 6);
		System.out.println(RateStructure);
		Library.Explicitlywait(element.getRateStructure(), 40);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Thread.sleep(3000);
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}

		Library.custom_click(element.getPurchaseOrderDeliveryDetailsNEXTBUTTON(),
				"PurchaseOrderDeliveryDetailsNEXTBUTTON");
		System.out.println("PurchaseOrderDeliveryDetailsNEXTBUTTON");
		Thread.sleep(3000);
		Library.custom_click(element.getSJOandOAFSelectionNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		System.out.println("SJOandOAFSelectionNEXTBUTTON");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(8000);
		}

		// Item Code 1 Description
		Library.Explicitlywait(element.getItemCode1(), 10);
		String ItemCode1 = element.getItemCode1().getText();
		System.out.println("The First Item Code is" + ItemCode1);

		if (!(ItemCode1 == null)) {

			Library.massagelog("Description of indent item code==" + ItemCode1);
			String WareHouseCode1 = Excel.getStringdata("POI005", 1, 8);

			System.out.println(WareHouseCode1);
			JQXGRID.JQXDropdown(element.getWareHouseCode1(), WareHouseCode1);
			System.out.println(WareHouseCode1);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 5);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			String QtyPUOM1 = Excel.getStringdata("POI005", 1, 10);
			System.out.println(QtyPUOM1);

			Library.dClick(element.getItemCodeQuantityPUOM1(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Library.Scrolldown(0, 20);

			// For loop for the item code1

			for (int i = 0; i <= 4; i++) {

				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println("The Information Of Grid  " + s);
				if (str5.equalsIgnoreCase("yes")) {
					Thread.sleep(3000);
				}
				int j = i + 1;
				String s1 = Integer.toString(j);
				int h = j + 1;

				WebElement IndentnumChield1 = driver
						.findElement(By.xpath("(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row"
								+ s + "jqxWidget')]//div[@columnindex='0']//div[1]"));
				Library.Explicitlywait(IndentnumChield1, 10);
				String IndentNum = IndentnumChield1.getText();

				Library.massagelog("indent Number==" + IndentNum);

				WebElement ChieldDate1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']//div[1]"));

				ChieldDate1.getText();

				Library.massagelog("The Default Delivery Date is==" + ChieldDate1.getText());

				// (//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']

				Library.Scrolldown(0, 50);
				Thread.sleep(5000);

				try {

					WebElement ChieldDateField1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']"));
					Library.Explicitlywait(ChieldDateField1, 10);

					Library.dClick(ChieldDateField1, "Delivery Date 1");
				} catch (Exception u) {
					System.out.println(u);
				}
				////// pass this step

				try {
					WebElement IndentQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']//div[1]"));
					Library.Explicitlywait(IndentQtyIUOM, 5);
					IndentQtyIUOM.getText();

					Library.massagelog("Indent Qty. (IUOM) for indent ==" + s1 + ChieldDate1.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);

				System.out.println(Excel.getStringdata("POI005", j, 9));

				String PODATE1 = Excel.getStringdata("POI005", j, 9);
				String date1 = PODATE1.replaceAll("/", "");
				Thread.sleep(2000);

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

				WebElement PendingPOQtyIUOM = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='8']//div[1]"));
				Library.Explicitlywait(PendingPOQtyIUOM, 5);
				String pendingpoQuantity = PendingPOQtyIUOM.getText();

				String a1 = pendingpoQuantity.replaceAll(",", "");
				float b = Float.parseFloat(a1);
				System.out.println(b);

				Library.massagelog("Pending PO Qty. (IUOM) for indent ==" + s1 + PendingPOQtyIUOM.getText());
				String QtyPUOM = Excel.getStringdata("POI005", h, 10);

				float QtyPUOMint = Float.parseFloat(QtyPUOM);

				WebElement ChielQuantitiyField1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='9']"));
				Library.Explicitlywait(ChielQuantitiyField1, 10);
				Library.dClick(ChielQuantitiyField1, "TheCurrent PO Qty. (IUOM) For Indent " + s1 + "");

				System.out.println("Delivery Quantity for TheCurrent PO Qty. (IUOM) For Indent" + s1);
				WebElement Qtyinput = driver.findElement(By.xpath("//div[contains(@id,'currentpoqtyiuom')]//input[1]"));
				Library.Explicitlywait(Qtyinput, 10);
				Library.custom_Sendkeys(Qtyinput, QtyPUOM, "TheCurrent PO Qty. (IUOM) For Indent " + s1);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				if (QtyPUOMint <= b) {
				}

				else {

					String errormassage = "Please Enter Quantity Less Than indent Quantity for Indent Number  ReQuired Quantity=="
							+ a1 + "EnteredQuantity==" + QtyPUOM + "For a endent Number " + IndentNum;
					Library.ERRORmassagelog(errormassage);
				}
			}

		}
		Thread.sleep(3000);

		Library.Scrolldown(0, -600);
		Library.ActionClick(element.getSAVEBTN(), "Save button");

		Thread.sleep(9000);
		Library.Explicitlywait(element.getPOaddnewbutton(), 10);

		if (element.getPOaddnewbutton().isEnabled()) {

			WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			Library.Explicitlywait(Ponumber);
			Thread.sleep(2000);
			Library.info(Ponumber, "PO NUmber");

		}

		else {

		}

		WebElement Authorizecheckbox = driver
				.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
			Thread.sleep(3000);
		}
		Authorizecheckbox.click();

		Thread.sleep(5000);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.stopRecord();
		}

//	      Thread.sleep(5000);
//	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
//	     Thread.sleep(5000);
//	    
//	     Authorizebtn.click();

	}

	@Test
	public void POI006() throws Exception {

		// Declare

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
		String Recoedingrequired = Excel.getStringdata("POI006", 1, 11);
		String str5 = Excel.getStringdata("POI006", 1, 12);
		String thread = Excel.getStringdata("POI006", 1, 12);
		System.out.println("static Wait IS Required==" + str5);
		System.out.println("Recording  ReQuired==" + Recoedingrequired);

		if (Recoedingrequired.equalsIgnoreCase("yes")) {
			ScreenRecorderUtil.startRecord("POI006");
		}

		String TestcaseID = Excel.getStringdata("Testcases", 8, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 8, 1);// Test Case Desc
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(3000);

			// Library.LOGIN("LOGIN");

			Thread.sleep(6000);
		}

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

		String PoBasiss = Excel.getStringdata("POI006", 1, 3);
		System.out.println(PoBasiss);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(13000);
		}
		Library.Scrolldown(0, 20);
		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		Library.Explicitlywait(calendorinput, 20);
		String date = Excel.getStringdata("POI006", 1, 2);
		calendar.calendarinput(calendorinput, date);
		Thread.sleep(1500);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(3000);
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(5000);
		}
		vendorsearch.click();
		vendorsearch.sendKeys(Excel.getStringdata("POI006", 1, 4));
		vendorsearch.sendKeys(Keys.ENTER);
		Library.Scrolldown(0, 70);
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
		String buyer = Excel.getStringdata("POI006", 1, 5);
		System.out.println(buyer);

		Thread.sleep(3000);

		WebElement Buyer = element.getBuyer();
		Thread.sleep(2000);
		Library.Explicitlywait(Buyer, 50);

		Library.Comboclick(Buyer, buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		String RateStructure = Excel.getStringdata("POI006", 1, 6);
		System.out.println(RateStructure);
		Library.Explicitlywait(element.getRateStructure(), 40);
		Library.Comboclick(element.getRateStructure(), RateStructure, "Structure rate");
		Thread.sleep(3000);
		Library.ActionClick(element.getRateStryctureNextBtn(), "RateStryctureNextBtn");
		Library.Scrolldown(0, 30);
		Thread.sleep(5000);

		Library.custom_click(element.getPurchaseOrderDeliveryDetailsNEXTBUTTON(),
				"PurchaseOrderDeliveryDetailsNEXTBUTTON");
		System.out.println("PurchaseOrderDeliveryDetailsNEXTBUTTON");
		Thread.sleep(3000);
		Library.custom_click(element.getSJOandOAFSelectionNEXTBUTTON(), "SJOandOAFSelectionNEXTBUTTON");
		System.out.println("SJOandOAFSelectionNEXTBUTTON");
		if (thread.equalsIgnoreCase("yes")) {
			Thread.sleep(20000);
		}

		// Item Code 1 Description
		Library.Explicitlywait(element.getItemCode1(), 10);
		String ItemCode1 = element.getItemCode1().getText();
		System.out.println("The First Item Code is" + ItemCode1);

		if (!(ItemCode1 == null)) {
			Thread.sleep(3000);
			Library.massagelog("Description of indent item code==" + ItemCode1);
			String WareHouseCode1 = Excel.getStringdata("POI006", 1, 8);

			System.out.println(WareHouseCode1);
			WebElement warehuse = element.getWareHouseCode1();
			Library.Explicitlywait(warehuse, 30);
			JQXGRID.JQXDropdown(warehuse, WareHouseCode1);

			try {

				Library.Explicitlywait(element.getWarehousecodepopupms(), 5);
				element.getWarehousecodepopupms().click();
			}

			catch (Exception e) {

			}
			Robot robot = new Robot();
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			String QtyPUOM1 = Excel.getStringdata("POI006", 1, 10);
			System.out.println(QtyPUOM1);

			Library.dClick(element.getItemCodeQuantityPUOM1(), "ItemCodeQuantityPUOM1()");
			Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM1, "ItemCodeQuantityPUOM1");
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Library.Scrolldown(0, 20);
			Library.horizontalscroll(80);
			WebElement EQMvalue = driver
					.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='17']//div[1]"));
			Library.Explicitlywait(EQMvalue, 20);
			String EQM = EQMvalue.getText();
			System.out.println(EQM);
			float EQMvaluef = Float.parseFloat(EQM);
			System.out.println("EOQ (PUOM) is " + EQMvaluef);

			// Library.horizontalscrollback(80);

			// For loop for the item code1

			for (int i = 0; i <= 4; i++) {

				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println("The Information Of Grid  " + s);
				if (str5.equalsIgnoreCase("yes")) {
					Thread.sleep(3000);
				}
				int j = i + 1;
				String s1 = Integer.toString(j);
				int h = j + 1;

				WebElement IndentnumChield1 = driver
						.findElement(By.xpath("(//div[contains(@id,'contenttablejqxWidget')])[2]//div[contains(@id,'row"
								+ s + "jqxWidget')]//div[@columnindex='0']//div[1]"));
				Library.Explicitlywait(IndentnumChield1, 10);
				String IndentNum = IndentnumChield1.getText();

				Library.massagelog("indent Number==" + IndentNum);

				WebElement ChieldDate1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']//div[1]"));

				ChieldDate1.getText();

				Library.massagelog("The Default Delivery Date is==" + ChieldDate1.getText());

				// (//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='5']

				Library.Scrolldown(0, 50);
				if (thread.equalsIgnoreCase("yes")) {
					Thread.sleep(5000);
				}

				try {

					WebElement ChieldDateField1 = driver.findElement(
							By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='5']"));
					Library.Explicitlywait(ChieldDateField1, 10);

					Library.dClick(ChieldDateField1, "Delivery Date 1");
				} catch (Exception u) {
					System.out.println(u);
				}
				////// pass this step

				try {
					WebElement IndentQtyIUOM = driver.findElement(By
							.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='7']//div[1]"));
					Library.Explicitlywait(IndentQtyIUOM, 5);
					IndentQtyIUOM.getText();

					Library.massagelog("Indent Qty. (IUOM) for indent ==" + s1 + ChieldDate1.getText());

				}

				catch (Exception u) {
					System.out.println(u);
				}

				WebElement POINPUTDATEFIELD = driver.findElement(By.xpath("//input[contains(@id,'podeliverydate')]"));
				Library.Explicitlywait(POINPUTDATEFIELD, 10);

				System.out.println(Excel.getStringdata("POI006", j + 1, 9));

				String PODATE1 = Excel.getStringdata("POI006", j + 1, 9);
				String date1 = PODATE1.replaceAll("/", "");
				Thread.sleep(2000);

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

				WebElement PendingPOQtyIUOM = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='8']//div[1]"));
				Library.Explicitlywait(PendingPOQtyIUOM, 5);
				String pendingpoQuantity = PendingPOQtyIUOM.getText();

				String a1 = pendingpoQuantity.replaceAll(",", "");
				float b = Float.parseFloat(a1);
				System.out.println(b);

				Library.massagelog("Pending PO Qty. (IUOM) for indent ==" + s1 + PendingPOQtyIUOM.getText());
				String QtyPUOM = Excel.getStringdata("POI006", h, 10);

				float QtyPUOMint = Float.parseFloat(QtyPUOM);

				WebElement ChielQuantitiyField1 = driver.findElement(
						By.xpath("(//div[contains(@id,'row" + s + "jqxWidget')])[2]//div[@columnindex='9']"));
				Library.Explicitlywait(ChielQuantitiyField1, 10);
				Library.dClick(ChielQuantitiyField1, "TheCurrent PO Qty. (IUOM) For Indent " + s1 + "");

				System.out.println("Delivery Quantity for TheCurrent PO Qty. (IUOM) For Indent" + s1);
				WebElement Qtyinput = driver.findElement(By.xpath("//div[contains(@id,'currentpoqtyiuom')]//input[1]"));
				Library.Explicitlywait(Qtyinput, 10);
				Library.custom_Sendkeys(Qtyinput, QtyPUOM, "TheCurrent PO Qty. (IUOM) For Indent " + s1);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				if (QtyPUOMint % EQMvaluef == 0) {
					String msg = "The Entered Current PO Qty. (IUOM) is not  AS per  Ecomical Order Quantity EOQ (PUOM)  "
							+ EQMvaluef;
					System.out.println(msg);
				}

				else {
					String errmsg = "The Entered Current PO Qty. (IUOM) is not  AS per  Ecomical Order Quantity EOQ (PUOM) ";
					Library.failmassage(errmsg);
					System.out.println(errmsg);
					if (i == 4) {

						Library.TestcaseFailed();
					}
				}

				if (QtyPUOMint <= b) {
				}

				else {

					String errormassage = "Please Enter Quantity Less Than indent Quantity for Indent Number  ReQuired Quantity=="
							+ a1 + "  Entered Quantity==" + QtyPUOM + "For an Indent Number " + IndentNum;
					Library.failmassage(errormassage);

				}
			}

		}
		Thread.sleep(3000);

		Library.Scrolldown(0, -600);
		Library.ActionClick(element.getSAVEBTN(), "Save button");

		try {
			if (thread.equalsIgnoreCase("yes")) {
				Thread.sleep(17000);
			}
			Library.Explicitlywait(element.getPOaddnewbutton(), 10);

			if (element.getPOaddnewbutton().isEnabled()) {

				WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			Library.Explicitlywait(Ponumber);
				Thread.sleep(2000);
				Library.info(Ponumber, "PO NUmber");

			}

			else {

			}

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

			if (Recoedingrequired.equalsIgnoreCase("yes")) {
				ScreenRecorderUtil.stopRecord();
			}
		} catch (Exception e) {

			String errormsg = "Indent is close or Po Qty is more than indent qty.";
			Library.ERRORmassagelog(errormsg);

		}
      Thread.sleep(5000);
	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	     Thread.sleep(5000);
    Library.massagelog("PO Authorized SuccessFully");
     Authorizebtn.click();

	}

}
