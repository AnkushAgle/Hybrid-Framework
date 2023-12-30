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

import com.Purchasepom.Indententrypom;
import com.Purchasepom.POAmendmentnew;
import com.Purchasepom.POMaintenanceNew;
import com.utility.BaseClass;
import com.utility.ExcelDataProvider;
import com.utility.ExcelReader;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.ScreenRecorderUtil;
import com.utility.WriteIntoExcel;
import com.utility.calendar;
 
public class Indent_Po_Poamendment extends BaseClass {
	@Test(priority=0)
	public void Login() throws Exception {

		Library.login("LOGIN");
		// Thread.sleep(10000);
	}

	
	
	
	
	
	
	// Test Case Description 
	
	
	@Test(priority=1)
	public void INDENT004() throws Exception {

		Thread.sleep(5000);

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "IndentEntry");
		System.out.println(path);

		ExcelReader Ecel = new ExcelReader(path);

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "IndentEntry");
		String TestcaseID = Excel.getStringdata("Testcases", 4, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 4, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println("Test Case Started" + " " + TestcaseID + " " + testcasedesc);

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Thread.sleep(1000);
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Thread.sleep(1000);
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		String sheetName = "INDENT004";

		String IndentReqBy = Ecel.getCellData(sheetName, "IndentReqBy", 1);

		Library.Comboclick(indent.getIntendtReqBy(), IndentReqBy, "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));

		String a = Ecel.getCellData(sheetName, "indentDate", 1);

		calendar.DATEPICKER(calendor, a);

		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		WebElement selectiten = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']"));
		Thread.sleep(6000);

		String ITEMCODE = Ecel.getCellData(sheetName, "ITEMCODE", 1);
		try {
			Library.searchwindowpopupenter(selectiten, ITEMCODE);
		} catch (Exception t) {
			String ErrorMassage = "Item Code Does not Found ";

			System.out.println(ErrorMassage);

			System.out.println(t.getMessage());
		}
		Thread.sleep(8000);
//
//		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
//		Thread.sleep(12000);
//		String VENDORCODE = Ecel.getCellData(sheetName, "VENDORCODE", 1);
//
//		Library.searchwindowpopup(selectvendor, VENDORCODE);

		Thread.sleep(3000);
		Library.Scrolldown(0, 250);
		Thread.sleep(3000);
		int lastrow = Ecel.getRowCount(sheetName);

		System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

		// For Loop is Started for an Item COde 1

		for (int i = 0; i <= lastrow; i++) {

			int j = i + 1;
			String date1 = Ecel.getCellData(sheetName, "DeliveryDate", j);
			String DATE11 = date1.replaceAll("/", "");
			String Quantity = Ecel.getCellData(sheetName, "Quantity", j);

			if ((DATE11.equalsIgnoreCase("NODATAPRESENT") && Quantity.equalsIgnoreCase("NODATAPRESENT"))) {
			}

			else {

				System.out.println(DATE11 + "of the Item Code Quantity==" + Quantity);
				Thread.sleep(1000);
				String s = Integer.toString(i);

				System.out.println(s);
				Thread.sleep(3000);

				String s1 = Integer.toString(j);
				Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");

				if (s.equalsIgnoreCase("0")) {
					Thread.sleep(3000);
					String Quantitiy1 = "(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row" + s
							+ "jqxWidget')]//div[@columnindex='3'])[2]";

					WebElement Quantityy = driver.findElement(By.xpath(Quantitiy1));

					Library.Explicitlywait(Quantityy, 25);
					Thread.sleep(3000);

					Quantityy.click();

//					Library.custom_click(Quantityy,  "Quantity Field 1");
//					Library.ActionDoubleClick(Quantityy, "Quantity Field 1");

					Thread.sleep(3000);
					// String
					// Quantitiy1="(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='3'])[2]";
					WebElement Quantyfiled = indent.getQuantityInputTextFieldChild();
					Library.Explicitlywait(Quantyfiled, 30);
					Library.custom_Sendkeys(Quantyfiled, Quantity, "Quantity Field  " + s1);

					Quantyfiled.sendKeys(Keys.ENTER);
					String cpathcal = "(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row" + s
							+ "jqxWidget')]//div[@columnindex='4'])[2]";
					WebElement jqxCalendor = driver.findElement(By.xpath(cpathcal));

					Library.dClick(jqxCalendor, "Calendsar Field");
					Library.custom_Sendkeys(indent.getCalendarInputFieldDelivery(), DATE11, "Delivery Date " + s1);
					indent.getCalendarInputFieldDelivery().sendKeys(Keys.ENTER);
					Thread.sleep(3000);

					WebElement SjOdrpdown = driver
							.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='6'])[2]"));
					Library.Explicitlywait(SjOdrpdown, 25);
					Library.dClick(SjOdrpdown, "SJO DRopDown");
					Thread.sleep(7000);

					WebElement SJONUM = driver.findElement(
							By.xpath("//div[contains(@id,'listitem0innerListBoxdropdownlisteditor')]//span"));
					Library.Explicitlywait(SJONUM, 20);
					String sjonum = SJONUM.getText();
					Library.massagelog("SJO Number==" + sjonum);

					
					System.out.println("SJO Number IS =="+sjonum);
					Thread.sleep(3000);

					SJONUM.click();
					
	                 Robot robo =new Robot();
	                 robo.delay(1000);
	                 robo.keyPress(KeyEvent.VK_ENTER);
					 robo.keyRelease(KeyEvent.VK_ENTER);

				}

				else {
					Thread.sleep(10000);

					String Quantitiy1 = "(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row" + s
							+ "jqxWidget')]//div[@columnindex='3'])[2]";

					driver.findElement(By.xpath(Quantitiy1)).click();

					Thread.sleep(3000);
					// String
					// Quantitiy1="(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='3'])[2]";
					WebElement Quantyfiled = indent.getQuantityInputTextFieldChild();
					Library.Explicitlywait(Quantyfiled, 30);
					Library.custom_Sendkeys(Quantyfiled, Quantity, "Quantity Field  " + s1);

					Quantyfiled.sendKeys(Keys.ENTER);
					String cpathcal = "(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row" + s
							+ "jqxWidget')]//div[@columnindex='4'])[2]";
					WebElement jqxCalendor = driver.findElement(By.xpath(cpathcal));

					Library.dClick(jqxCalendor, "Calendsar Field");
					Library.custom_Sendkeys(indent.getCalendarInputFieldDelivery(), DATE11, "Delivery Date " + s1);
					indent.getCalendarInputFieldDelivery().sendKeys(Keys.ENTER);
					

//					WebElement SjOdrpdown = driver
//							.findElement(By.xpath("(//div[contains(@id,'row"+s+"jqxWidget')]//div[@columnindex='6'])[2]"));
//					Library.Explicitlywait(SjOdrpdown, 25);
//					Library.dClick(SjOdrpdown, "SJO DRopDown");
					Thread.sleep(3000);

//					WebElement SJONUM = driver.findElement(
//							By.xpath("//div[contains(@id,'listitem0innerListBoxdropdownlisteditor')]//span"));
//					Library.Explicitlywait(SJONUM, 20);
//					String sjonum = SJONUM.getText();
//					Library.massagelog("SJO Number==" + sjonum);

					if (i >= 1) {
						Library.Scrolldown(0, -40);
					}
				}
			}
		}

		Thread.sleep(8000);
		Library.Scrolldown(0, -500);
		WebElement savebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
		Library.Explicitlywait(savebtn);
		Library.dClick(savebtn);

		Thread.sleep(6000);
		WebElement checkbox = driver.findElement(By.xpath(
				"//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
		Library.dClick(checkbox);
		System.out.println("Indent Details Succesfully Saved");

		WebElement ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
		Library.info(ponumber, "Indent Number");
System.out.println("Indent Number Is "+ponumber.getText());
		Thread.sleep(3000);
	WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	
	Library.Explicitlywait(Authorizebtn, 25);
	
	Library.custom_click(Authorizebtn, "Indent Authorization Button ");
	
	try {Authorizebtn.click();} catch(Exception j) {System.out.println(j.getMessage());}

	}
      @Test(priority=2)
	public void POI007() throws Exception {
		
		String path = Library.ExelFilepath("purchase", "POMaintenanceNew");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String sheetNaMe="POI007";
		String Recoedingrequired =Ecel.getCellData(sheetNaMe, "RECORDING(YES/NO)", 1);
		String PODate=Ecel.getCellData(sheetNaMe, "PO Date", 1);
		String POBASIS=Ecel.getCellData(sheetNaMe, "POBASIS", 1);
		String Vendor=Ecel.getCellData(sheetNaMe, "Vendor", 1);
		String Buyer=Ecel.getCellData(sheetNaMe, "Buyer", 1);
		String RateStructure=Ecel.getCellData(sheetNaMe, "RateStructure", 1);
		String ITEMCODES=Ecel.getCellData(sheetNaMe, "ITEMCODES", 1);
		String WAREHOUSECODEs=Ecel.getCellData(sheetNaMe, "WAREHOUSECODEs", 1);
		String ITEMCODEDeliveryDates=Ecel.getCellData(sheetNaMe, "ITEMCODE Delivery Dates", 1);
		String DeliveryQty=Ecel.getCellData(sheetNaMe, "Delivery Qty", 1);

	
		String str5 = Ecel.getCellData(sheetNaMe, "ThreadReQuired(YES/NO)", 1);
		

		System.out.println("static Wait IS Required==" + str5);
		System.out.println("Recording  ReQuired==" + Recoedingrequired);
//
//		if (Recoedingrequired.equalsIgnoreCase("yes")) {
//			ScreenRecorderUtil.startRecord("POI003");
//		}
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 13);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 13);// Test Case Description 
	
		System.out.println(TestcaseID + testcasedesc);
		Library.testcasedesc(TestcaseID, testcasedesc);

		Thread.sleep(3000);

		// Library.LOGIN("LOGIN");

		Thread.sleep(6000);

		POMaintenanceNew element = PageFactory.initElements(driver, POMaintenanceNew.class);

		Library.custom_click(element.getPurchasemodule(), "Purchasemodule");
		Library.custom_click(element.getPOMaintenanceNew(), "Po  mainteance New");
		Library.custom_click(element.getPOaddnewbutton(), "Add New Btn");

	
		System.out.println(POBASIS);

		// Library.Comboclick(element.getPOBASIS(),PoBasiss,"PO BAsis");
		Thread.sleep(12000);

		WebElement calendorinput = driver.findElement(By.xpath("//input[contains(@id,'inputjqxWidget')]"));
		
		calendar.calendarinput(calendorinput, PODate);
		Thread.sleep(1500);
		Library.dClick(element.getPOINFONEXTBTN(), "PO Next Button");
		// Library.dClick(element.getVendoraddsearchbtn());
		Thread.sleep(3000);
		WebElement vendorsearch = driver
				.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
		Library.Explicitlywait(vendorsearch);
		Thread.sleep(5000);
		vendorsearch.click();
		vendorsearch.sendKeys(Vendor);
		vendorsearch.sendKeys(Keys.ENTER);
		Library.Scrolldown(0, 70);
		Thread.sleep(2000);
//	Library.Explicitlywait(element.getBuyer());
	
		System.out.println(Buyer);

		Thread.sleep(15000);

		WebElement Buyyer = element.getBuyer();
		Thread.sleep(2000);
		Library.Explicitlywait(Buyyer, 20);

		Library.Comboclick(Buyyer, Buyer, "Buyer");
		Library.Scrolldown(0, 30);
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);
		Library.custom_click(element.getVendorInfoNextBtn(), "VendorInfoNextBtn()");
		Thread.sleep(2000);
		Library.Scrolldown(0, 50);

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
			

			String WAREHOUSECODE1=Ecel.getCellData(sheetNaMe, "WAREHOUSECODEs", 1);
			JQXGRID.JQXDropdown(element.getWareHouseCode1(), WAREHOUSECODE1);
			System.out.println(WAREHOUSECODE1);
			
			       //element.getWareHouseCode1().sendKeys(Keys.ENTER);
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
			String QtyPUOM1 = Ecel.getCellData(sheetNaMe, "QtyPUOM", 1);
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

			

				String PODATE1 = Ecel.getCellData(sheetNaMe, "ITEMCODE Delivery Dates", j);

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
				String QtyPUOM = Ecel.getCellData(sheetNaMe, "Delivery Qty", j);
				
				
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

			
			String PoNumber=Ponumber.getText();
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

			/// Authorizebtn.click();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}

	      Thread.sleep(5000);
	     WebElement Authorizebtn= driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	     Thread.sleep(5000);
	    
	     Authorizebtn.click();
	     
	     
	     
	     Thread.sleep(5000);
	     

//			if (Recoedingrequired.equalsIgnoreCase("yes")) {
//				ScreenRecorderUtil.stopRecord();
//			}

	}

           
           
       	@Test(priority=4)

    	public void POAMI002() throws Exception {

       		Thread.sleep(6000);

    		POMaintenanceNew elementt = PageFactory.initElements(driver, POMaintenanceNew.class);

    		Library.custom_click(elementt.getPurchasemodule(), "Purchasemodule");
    		Library.custom_click(elementt.getPOMaintenanceNew(), "Po  mainteance New");
       		
       		
    		WebElement Ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[9]/div"));
			Library.Explicitlywait(Ponumber);
				Thread.sleep(2000);
		String sheetname="POAMI002";
				
				String PONM="1605";
    		String path = Library.ExelFilepath("purchase", "POAmendmentNew");
    		System.out.println(path);
    		ExcelReader Ecel = new ExcelReader(path);
    		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 4);// Test Case ID
    		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 4);// Test Case Desc
    		Library.testcasedesc(TestcaseID, testcasedesc);
    		String Recoedingrequired = Ecel.getCellData(sheetname, "RECORDING(YES/NO)", 1);
    		String thread = "YES";

//    		if (Recoedingrequired.equalsIgnoreCase("yes")) {
//    			ScreenRecorderUtil.startRecord(sheetname);
//    		}

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

    		Library.Comboclick(element.getPONUMBER(), PONM, "PO NUMBER ");// for selecting po site
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

    		String ItemCode1 = element.getItemCode1().getText();
    		System.out.println(ItemCode1);

    		if (!(ItemCode1 == null)) {

    			String QtyPUOM1 = Ecel.getCellData(sheetname, "Qty(PUOM)", 1);

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

    				String PODATE1 = Ecel.getCellData(sheetname, "ITEMCODE Delivery Dates", j);
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
    				String QtyPUOM = Ecel.getCellData(sheetname, "Delivery Qty", j);
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
    			Thread.sleep(6000);}
//    		}
//
//    		String QtyPUOM2 = Ecel.getCellData(sheetname, "Qty(PUOM)", 7);
//
//    		Library.dClick(element.getItemCodeQuantityPUOM2(), "ItemCodeQuantityPUOM2()");
//    		Library.custom_Sendkeys(element.getItemCodeQuantityInputTextField(), QtyPUOM2, "ItemCodeQuantityPUOM2");

    		
    		
    		
    		
    		
    		
    		
    		
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
//
//    		if (Recoedingrequired.equalsIgnoreCase("yes")) {
//    			ScreenRecorderUtil.stopRecord();
//    		}
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
//    		Click Sucessfully==10==Date_October 2022
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
//    		Click Sucessfully==10==Date_October 2022
    			} else {
    				// test.fail("Wrong date");
    				System.out.println("Wrong date");
    			}

    		}

    	}

           
           
           
           
           
}
