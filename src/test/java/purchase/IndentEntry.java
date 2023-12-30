package purchase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.pageobject.Indententrypom;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.ExcelReader;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.WriteIntoExcel;
import com.utility.calendar;

public class IndentEntry extends BaseClass {
	@Test(priority = 0)
	public void Login() throws Exception {

		Library.login("LOGIN");
		Thread.sleep(10000);
	}
  
	@Test(priority = 1)
	public void INDENT001() throws Exception {

		Thread.sleep(5000);

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "IndentEntry");
		System.out.println(path);

		ExcelReader Ecel = new ExcelReader(path);

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "IndentEntry");
		String TestcaseID = Excel.getStringdata("Testcases", 1, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 1, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println("Test Case Started" + " " + TestcaseID + " " + testcasedesc);
		ConfigDataProvider config = new ConfigDataProvider("intententry");

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		
		
		WebElement element=indent.getAddnewbtn();
		
		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Thread.sleep(1000);
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Thread.sleep(1000);
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		String IndentReqBy = Ecel.getCellData("INDENT001", "IndentReqBy", 1);

		Library.Comboclick(indent.getIntendtReqBy(), IndentReqBy, "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));

		String a = Ecel.getCellData("INDENT001", "indentDate", 1);

		calendar.DATEPICKER(calendor, a);

		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		WebElement selectiten = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']"));
		Thread.sleep(6000);

		String ITEMCODE = Ecel.getCellData("INDENT001", "ITEMCODE", 1);
		try {
			Library.searchwindowpopupenter(selectiten, ITEMCODE);
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
		Thread.sleep(6000);

		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
		Thread.sleep(12000);
		String VENDORCODE = Ecel.getCellData("INDENT001", "VENDORCODE", 1);

		Library.searchwindowpopup(selectvendor, VENDORCODE);
		Library.Scrolldown(0, 100);
		Thread.sleep(3000);

		Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");
		Library.Scrolldown(0, 150);

		Thread.sleep(10000);
		try {
			String Quantitiy1 = "(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='3'])[2]";

			driver.findElement(By.xpath(Quantitiy1)).click();

			Thread.sleep(3000);
			// String
			// Quantitiy1="(//div[contains(@id,'contenttablejqxWidget')]//div[contains(@id,'row0jqxWidget')]//div[@columnindex='3'])[2]";
			WebElement Quantyfiled = driver.findElement(By.xpath(
					"//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

			String Quantity = Ecel.getCellData("INDENT001", "Quantity", 1);

			Quantyfiled.sendKeys(Quantity);
			Quantyfiled.sendKeys(Keys.ENTER);

		} catch (Exception e) {

			e.getMessage();
			System.out.println(e.getMessage());
		}
//		(//div[contains(@id,'row0')]/div[5])[2]

		WebElement jqxCalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0')]/div[5])[2]"));

		String date1 = Ecel.getCellData("INDENT001", "DeliveryDate", 1);
		String DATE11 = date1.replaceAll("/", "");

		Library.dClick(jqxCalendor, "Calendsar Field");
		Library.custom_Sendkeys(indent.getCalendarInputFieldDelivery(), DATE11, a);
		indent.getCalendarInputFieldDelivery().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		if(jqxCalendor.isEnabled()) {
//		jqxCalendor.click();
//		}
		// Thread.sleep(2000);
//		driver.findElement(By.xpath("(//td[text()='15'])[2]")).click();
		//

		// Add second item into indent Entry
//		Thread.sleep(6000);
//		Library.Scrolldown(0, -400);
//		Library.dClick(indent.getfirstAddNewbtn());
//		
//		Thread.sleep(2000);
//		
//		WebElement secondsearchbtn=driver.findElement(By.xpath("//div[contains(@id,'row1')]/div[5]"));
//		Library.searchwindowpopup(secondsearchbtn,config.getconfigdata("ITEMCODE2"));
//		
//		Thread.sleep(6000);
////		Library.searchwindowpopup(selectiten,config.getconfigdata("ITEMCODE1"));
////		Thread.sleep(2000);
////		WebElement secondvendorsearchbtn=driver.findElement(By.xpath("//div[contains(@id,'row1')]/div[13]"));
////		Thread.sleep(10000);
////		Library.searchwindowpopup(secondvendorsearchbtn, config.getconfigdata("VENDORCODE"));
//	    Library.Scrolldown(0, 100);
//		
//	    Library.custom_click(indent.getsecondAddNewbtn(),"Add new second btn");
//		Library.Scrolldown(0, 220);
//
//		Thread.sleep(10000);
//		try {
//			driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidge')]/div[4])[2]")).click();
//	//driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]")).click();
//			
//			Thread.sleep(3000);
//		WebElement Quantyfiled1=driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));
//
//		Quantyfiled1.sendKeys(config.getconfigdata("Quantity"));
//		Quantyfiled1.sendKeys(Keys.ENTER);
//		
//		
//		}
//		
//	catch(Exception e) {
//		
//		e.getMessage();
//			System.out.println(e.getMessage());
//		}
		Thread.sleep(8000);
		Library.Scrolldown(0, -500);
		WebElement savebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
		Library.Explicitlywait(savebtn);
		Library.dClick(savebtn);

		Thread.sleep(6000);
		WebElement checkbox = driver.findElement(By.xpath(
				"//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
		Library.dClick(checkbox);

		WebElement ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
		Library.info(ponumber, "Indent Number");

		Thread.sleep(3000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Authorizebtn.click();

	}

	@Test(priority = 2)
	public void INDENT002() throws Exception {

		Thread.sleep(5000);

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "IndentEntry");
		System.out.println(path);

		ExcelReader Ecel = new ExcelReader(path);

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "IndentEntry");
		String TestcaseID = Excel.getStringdata("Testcases", 2, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 2, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println("Test Case Started" + " " + TestcaseID + " " + testcasedesc);

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Thread.sleep(1000);
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Thread.sleep(1000);
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		String IndentReqBy = Ecel.getCellData("INDENT002", "IndentReqBy", 1);

		Library.Comboclick(indent.getIntendtReqBy(), IndentReqBy, "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));

		String a = Ecel.getCellData("INDENT002", "indentDate", 1);

		calendar.DATEPICKER(calendor, a);

		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		WebElement selectiten = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']"));
		Thread.sleep(6000);

		String ITEMCODE = Ecel.getCellData("INDENT002", "ITEMCODE", 1);
		try {
			Library.searchwindowpopupenter(selectiten, ITEMCODE);
		} catch (Exception t) {
			String ErrorMassage = "Item Code Does not Found ";

			System.out.println(ErrorMassage);

			System.out.println(t.getMessage());
		}
		Thread.sleep(6000);

		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
		Thread.sleep(12000);
		String VENDORCODE = Ecel.getCellData("INDENT002", "VENDORCODE", 1);

		Library.searchwindowpopup(selectvendor, VENDORCODE);

		Thread.sleep(3000);
		Library.Scrolldown(0, 150);
		int lastrow = Ecel.getRowCount("INDENT002");

		System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

		// For Loop is Started for an Item COde 1

		for (int i = 0; i <= lastrow; i++) {

			int j = i + 1;
			String date1 = Ecel.getCellData("INDENT002", "DeliveryDate", j);
			String DATE11 = date1.replaceAll("/", "");
			String Quantity = Ecel.getCellData("INDENT002", "Quantity", j);

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

				if (i >= 1) {
					Library.Scrolldown(0, -40);
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

		WebElement ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
		Library.info(ponumber, "Indent Number");

		Thread.sleep(3000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Authorizebtn.click();

	}

	@Test(priority = 3)
	public void INDENT003() throws Exception {

		Thread.sleep(5000);

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "IndentEntry");
		System.out.println(path);

		ExcelReader Ecel = new ExcelReader(path);

		ExcelDataProvider Excel = new ExcelDataProvider("purchase", "IndentEntry");
		String TestcaseID = Excel.getStringdata("Testcases", 3, 0);// Test Case ID
		String testcasedesc = Excel.getStringdata("Testcases", 3, 1);// Test Case Desc
		Library.testcasedesc(TestcaseID, testcasedesc);

		System.out.println("Test Case Started" + " " + TestcaseID + " " + testcasedesc);

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Thread.sleep(1000);
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Thread.sleep(1000);
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		String IndentReqBy = Ecel.getCellData("INDENT002", "IndentReqBy", 1);

		Library.Comboclick(indent.getIntendtReqBy(), IndentReqBy, "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));

		String a = Ecel.getCellData("INDENT003", "indentDate", 1);

		calendar.DATEPICKER(calendor, a);

		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		// Details For ITEM CODE 1

		WebElement selectiten = driver
				.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']"));
		Thread.sleep(6000);

		String ITEMCODE = Ecel.getCellData("INDENT003", "ITEMCODE", 1);
		try {
			Library.searchwindowpopupenter(selectiten, ITEMCODE);
		} catch (Exception t) {
			String ErrorMassage = "Item Code Does not Found ";

			System.out.println(ErrorMassage);

			System.out.println(t.getMessage());
		}
		Thread.sleep(6000);
//
//		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
//		Thread.sleep(12000);
//		String VENDORCODE = Ecel.getCellData("INDENT003", "VENDORCODE", 1);
//
//		Library.searchwindowpopup(selectvendor, VENDORCODE);

		Thread.sleep(3000);
		Library.Scrolldown(0, 150);
		int lastrow = Ecel.getRowCount("INDENT003");

		System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow);

		// For Loop is Started for an Item COde 1

		for (int i = 0; i <= lastrow; i++) {

			String item1 = Ecel.getCellData("INDENT003", "ITEMCODE", 1);
			int j = i + 1;

			if (item1 == Ecel.getCellData("INDENT003", "ITEMCODE", j)) {

				String date1 = Ecel.getCellData("INDENT003", "DeliveryDate", j);
				String DATE11 = date1.replaceAll("/", "");
				String Quantity = Ecel.getCellData("INDENT003", "Quantity", j);

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

					if (i >= 1) {
						Library.Scrolldown(0, -40);
					}
				}

			}

			else {
			}
		}
		Thread.sleep(6000);
		Library.Scrolldown(0, -550);

		Thread.sleep(6000);
		WebElement ItemADDBUTTON = indent.getfirstAddNewbtn();
		Library.Explicitlywait(ItemADDBUTTON, 10);
		ItemADDBUTTON.click();
		// Details For ITEM CODE 2

		// Library.dClick(indent.getfirstAddNewbtn(), "ADD NEW Button");

		Thread.sleep(6000);

		WebElement selectiten2 = driver
				.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='4']"));
		Thread.sleep(6000);

		String ITEMCODE2 = Ecel.getCellData("INDENT003", "ITEMCODE", 7);
		try {
			Library.searchwindowpopupenter(selectiten2, ITEMCODE2);
		} catch (Exception t) {
			String ErrorMassage = "Item Code Does not Found ";

			System.out.println(ErrorMassage);

			System.out.println(t.getMessage());
		}
		Thread.sleep(6000);

		Thread.sleep(3000);
		Library.Scrolldown(0, 150);
		int lastrow2 = Ecel.getRowCount("INDENT003");

		System.out.println("The LAst Row Numbers Of The SheetIs " + lastrow2);

		// For Loop is Started for an Item COde 2

		Thread.sleep(6000);

		Thread.sleep(3000);
		Library.Scrolldown(0, 350);

		// For Loop For Second Item DetAIS

		int t = 0;

		for (int i = 0; i <= lastrow; i++) {

			String item2 = Ecel.getCellData("INDENT003", "ITEMCODE", 10);
			int j = i + 1;

			if (item2 == Ecel.getCellData("INDENT003", "ITEMCODE", j)) {

				String date1 = Ecel.getCellData("INDENT003", "DeliveryDate", j);
				String DATE11 = date1.replaceAll("/", "");
				String Quantity = Ecel.getCellData("INDENT003", "Quantity", j);

				if ((DATE11.equalsIgnoreCase("NODATAPRESENT") && Quantity.equalsIgnoreCase("NODATAPRESENT"))) {
				}

				else {

					System.out.println(DATE11 + "of the Item Code Quantity==" + Quantity);
					Thread.sleep(1000);

					String s = Integer.toString(t);

					System.out.println(s);
					Thread.sleep(3000);
					int u = t + 1;
					String s1 = Integer.toString(u);
					Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");

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

					if (t >= 1) {
						Library.Scrolldown(0, -40);
					}

					t++;
				}

			}

			else {
			}
		}

		Thread.sleep(8000);
		Library.Scrolldown(0, -500);
		Thread.sleep(6000);
		WebElement savebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
		Library.Explicitlywait(savebtn);
		Library.dClick(savebtn, "Save Button");

		Thread.sleep(6000);
		WebElement checkbox = driver.findElement(By.xpath(
				"//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
		Library.dClick(checkbox);

		WebElement ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
		Library.info(ponumber, "Indent Number");

		Thread.sleep(3000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Authorizebtn.click();
		  Library.massagelog("Indent Details   Authorized SuccessFully");

		  WebElement drop=driver.findElement(null);
		  
		 
		  
		  
		  
	}

	@Test()
	public void test_01() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider("intententry");
		Library.login("intententry");

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		Library.Comboclick(indent.getIntendtReqBy(), config.getconfigdata("IndentReqBy"), "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));

		// calendar.selectcalendardate(calendor,20,"May", 2022);
		Library.dClick(calendor);
		WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date = driver.findElement(By.xpath("//td[text()='12']"));
		Library.dClick(date);
		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		WebElement selectiten = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[5]"));
		Thread.sleep(6000);
		Library.searchwindowpopup(selectiten, config.getconfigdata("ITEMCODE"));
		Thread.sleep(6000);
		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
		Thread.sleep(12000);
		Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
		Library.Scrolldown(0, 100);
		Thread.sleep(3000);

		Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");
		Library.Scrolldown(0, 150);

		Thread.sleep(10000);
		try {

			driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]"))
					.click();

			Thread.sleep(3000);
			WebElement Quantyfiled = driver.findElement(By.xpath(
					"//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

			Quantyfiled.sendKeys(config.getconfigdata("Quantity"));
			Quantyfiled.sendKeys(Keys.ENTER);

		} catch (Exception e) {

			e.getMessage();
			System.out.println(e.getMessage());
		}
//	(//div[contains(@id,'row0')]/div[5])[2]

		WebElement jqxCalendor = driver.findElement(By.xpath("(//div[contains(@id,'row0')]/div[5])[2]"));
		String date1 = config.getconfigdata("date");
		JQXGRID.jqxcalendor(jqxCalendor, date1);
//	Thread.sleep(2000);
//	if(jqxCalendor.isEnabled()) {
//	jqxCalendor.click();
//	}
//Thread.sleep(2000);
//	driver.findElement(By.xpath("(//td[text()='15'])[2]")).click();
//	

		// Add second item into indent Entry
		Thread.sleep(6000);
		Library.Scrolldown(0, -400);
		Library.dClick(indent.getfirstAddNewbtn());

		Thread.sleep(2000);

		WebElement secondsearchbtn = driver.findElement(By.xpath("//div[contains(@id,'row1')]/div[5]"));
		Library.searchwindowpopup(secondsearchbtn, config.getconfigdata("ITEMCODE2"));

		Thread.sleep(6000);
//	Library.searchwindowpopup(selectiten,config.getconfigdata("ITEMCODE1"));
//	Thread.sleep(2000);
//	WebElement secondvendorsearchbtn=driver.findElement(By.xpath("//div[contains(@id,'row1')]/div[13]"));
//	Thread.sleep(10000);
//	Library.searchwindowpopup(secondvendorsearchbtn, config.getconfigdata("VENDORCODE"));
		Library.Scrolldown(0, 100);

		Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");
		Library.Scrolldown(0, 220);

		Thread.sleep(10000);
		try {
			driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidge')]/div[4])[2]")).click();
//driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]")).click();

			Thread.sleep(3000);
			WebElement Quantyfiled1 = driver.findElement(By.xpath(
					"//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

			Quantyfiled1.sendKeys(config.getconfigdata("Quantity"));
			Quantyfiled1.sendKeys(Keys.ENTER);

		}

		catch (Exception e) {

			e.getMessage();
			System.out.println(e.getMessage());
		}

		Library.Scrolldown(0, -500);
		WebElement savebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
		Library.Explicitlywait(savebtn);
		Library.dClick(savebtn);

		Thread.sleep(6000);
		WebElement checkbox = driver.findElement(By.xpath(
				"//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
		Library.dClick(checkbox);

		WebElement ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
		Library.info(ponumber, "PO NUmber");

		Thread.sleep(3000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Authorizebtn.click();

	}

	@Test
//pass test case
	public void Test_04() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider("intententry");
		Library.login();

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		Library.Comboclick(indent.getIntendtReqBy(), config.getconfigdata("IndentReqBy"), "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));

		// calendar.selectcalendardate(calendor,20,"May", 2022);
		Library.dClick(calendor);
		WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date = driver.findElement(By.xpath("//td[text()='12']"));
		Library.dClick(date);
		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		WebElement selectiten = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[5]"));
		Thread.sleep(3000);
		Library.searchwindowpopup(selectiten, config.getconfigdata("ITEMCODE"));
		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
		Thread.sleep(10000);
		Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
		Library.Scrolldown(0, 100);

		Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");
		Library.Scrolldown(0, 150);

		Thread.sleep(10000);
		try {

			driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]"))
					.click();

			Thread.sleep(3000);
			WebElement Quantyfiled = driver.findElement(By.xpath(
					"//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

			Quantyfiled.sendKeys("1");
			Quantyfiled.sendKeys(Keys.ENTER);

		} catch (Exception e) {

			e.getMessage();
			System.out.println(e.getMessage());
		}

		Library.Scrolldown(0, -500);
		WebElement savebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
		Library.Explicitlywait(savebtn);
		Library.dClick(savebtn);

		Thread.sleep(6000);
		WebElement checkbox = driver.findElement(By.xpath(
				"//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
		Library.dClick(checkbox);

		WebElement ponumber = driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
		Library.info(ponumber, "PO NUmber");

		Thread.sleep(3000);
		WebElement Authorizebtn = driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
		Authorizebtn.click();
	}

	@Test(enabled = false)

	public void test_02() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider("intententry");
		Library.login();
		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);
		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");
		Thread.sleep(10000);
		Library.dClick(indent.getCALENDOR());
		WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date = driver.findElement(By.xpath("//td[text()='12']"));
		Library.dClick(date);
		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());
		Thread.sleep(3000);
		Library.searchwindowpopup(indent.getITEMCODESEARCHBTN(), config.getconfigdata("ITEMCODE"));
		Thread.sleep(10000);
		Library.searchwindowpopup(indent.getVENDORCODESEARCHBTN(), config.getconfigdata("VENDORCODE"));
		Library.Scrolldown(0, 100);
		Library.Scrolldown(0, 100);
		Thread.sleep(4000);
		Library.custom_click(indent.getsecondAddNewbtn(), "Add new second btn");
		Library.Scrolldown(0, 150);
		try {

			indent.getQuantity().click();
			Thread.sleep(3000);
			// WebElement
			// Quantyfiled=driver.findElement(By.xpath("//input[@class='jqx-input-content
			// jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));
			indent.getQuantitytextboxfield();

			Library.custom_Sendkeys(indent.getQuantitytextboxfield(), config.getconfigdata("Quantity"),
					"Quantity Field");

			indent.getQuantitytextboxfield().sendKeys(Keys.ENTER);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		Library.Explicitlywait(indent.getSAVEBTN());
		Library.dClick(indent.getSAVEBTN());

		Thread.sleep(2000);
		Library.Explicitlywait(indent.getAuthorizationcheckbox());
		Library.dClick(indent.getAuthorizationcheckbox());

		Thread.sleep(3000);
		Library.Explicitlywait(indent.getAuthorizationBTN());
		Library.Explicitlywait(indent.getAuthorizationBTN());

	}

	@Test(enabled = false)
	public void test_00() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider("intententry");
		Library.login();

		Indententrypom indent = PageFactory.initElements(driver, Indententrypom.class);

		Library.custom_click(indent.getPurchasemodule(), "PurchaseModule");
		Library.custom_click(indent.getIntentEntry(), "IndentEntry");
		Library.custom_click(indent.getAddnewbtn(), "AddNewBtn");

		Thread.sleep(10000);

		Library.Comboclick(indent.getIntendtReqBy(), config.getconfigdata("IndentReqBy"), "IntentReqBy");

		// div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms
		// jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms
		// jqx-default jqx-default-imms']

		WebElement calendor = driver.findElement(By.xpath(
				"//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));
		// calendor.click();
		Library.dClick(calendor);
		// Library.custom_click(calendor, "calendor");
		WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
		// Library.custom_click(prebtn, "Previousbtn");
//	Library.custom_click(prebtn, "Previousbtn");

		Library.dClick(prebtn);
		Library.dClick(prebtn);
		Library.Scrolldown(0, 10);
		WebElement date = driver.findElement(By.xpath("//td[text()='12']"));

		Library.dClick(date);
		Library.dClick(indent.getFirstNextBtn());
		Library.dClick(indent.getSecondNextBtn());
		Library.dClick(indent.getfirstAddNewbtn());

		// (//input[contains(@id,'Button')])[3]

		WebElement selectiten = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[5]"));
		Thread.sleep(3000);
		Library.searchwindowpopup(selectiten, config.getconfigdata("ITEMCODE"));
		WebElement selectvendor = driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
		Thread.sleep(3000);
		Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
		selectiten.click();
		// Library.dClick(selectiten);
		// Library.custom_click(selectiten, "Search new btn");
		WebElement itemsearch = driver.findElement(By.xpath("//input[@formcontrolname='item']"));
		Library.custom_Sendkeys(itemsearch, config.getconfigdata("ITEMCODE"), "Item code Seacrch text box");
		Thread.sleep(3000);
		WebElement itemsearchbtn = driver
				.findElement(By.xpath("//button[@class='btn btn-outline-secondary btn-search border-0']"));
		Library.custom_click(itemsearchbtn, "itemsearchbtn");
		// Library.dClick(itemsearchbtn);
		Thread.sleep(3000);
		WebElement selectitem = driver
				.findElement(By.xpath("//div[text()='" + config.getconfigdata("ITEMCODE") + "']"));
		Thread.sleep(3000);
		Library.dClick(selectitem);
		Library.dClick(selectitem);

		Thread.sleep(10000);
//
//	WebElement selectvendor=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
//	Thread.sleep(3000);
//	Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));

		// Library.dClick(selectitem);

//	driver.findElement(By.xpath("//div[contains(@id,'row0jqxWidget')]/div[10]")).click();
//	Thread.sleep(3000);
//	Library.Scrolldown(0,50);
//	Library.Scrolldown(50, 0);
//	//driver.findElement(By.xpath("//span[text()='NOS - Numbers']")).click();
//	//WebElement udrp=driver.findElement(By.xpath("//div[contains(@aria-activedescendant,'listitem0innerListBoxtemplateeditorjqx')]"));
//	//String xpath="/html/body/app-root/app-inner-layout/app-indententry/div/div/ngb-accordion/div[3]/div[2]/div/form/div[1]/div[2]/jqxgrid/div/div/div/div[4]/div[2]/div/div[2]/div[7]";
//	String xpath="//*[@id=\"row0jqxWidgetd7a443cdf02a\"]/div[11]";
//	WebElement udrp=driver.findElement(By.xpath(xpath));
//	Actions act =new Actions(driver);
//act.moveToElement(udrp).build().perform();
//Library.custom_click(udrp, xpath);
//	Library.dClick(udrp);
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//span[text()='NOS - Numbers']")).click();
//	//indent.getdropdownUOM().click();
//	//Library.Comboclick(udrp,config.getconfigdata("dropdownUOM"),"UOM");
//	//button[@class='btn btn-outline-secondary btn-search border-0']	

	}

}
