
package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.pageobject.loginpom;

public class Library extends BaseClass {
	public static ExtentTest test;

	public static void login() throws Exception {

		loginpom login = PageFactory.initElements(driver, loginpom.class);

		String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\LOGIN.xlsx";
		ExcelReader Ecel = new ExcelReader(excelpath);
		String sheet = "LOGIN";
		String LoginString = Ecel.getCellData(sheet, "value", 1);
		String username = Ecel.getCellData(sheet, "value", 2);
		String password = Ecel.getCellData(sheet, "value", 3);
		String selectcompany = Ecel.getCellData(sheet, "value", 4);
		String selectlocation = Ecel.getCellData(sheet, "value", 5);
		System.out.println("Connection String == " + LoginString);
		login.getUserName().sendKeys(Keys.F2);
		Library.custom_Sendkeys(login.getConnection_String(), LoginString, "Connection  String");

		System.out.println("username == " + username);

		Library.custom_Sendkeys(login.getUserName(), username, "Username");

		System.out.println("password == " + password);
		Library.custom_Sendkeys(login.getPassword(), password, "Password");

		Thread.sleep(1000);
		Library.custom_click(login.getLoginbtn(), "Login Button");
		try {
			login.getLoginbtn().click();
		}

		catch (Exception t) {
			System.out.println(t.getMessage());
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(login.getSelect_company()));
		wait.until(ExpectedConditions.visibilityOf(login.getSelect_Location()));

		Library.Custom_Dropdown(login.getSelect_company(), selectcompany, "Company");
		Thread.sleep(5000);

		Library.Custom_Dropdown(login.getSelect_Location(), selectlocation, "Company/Location");
		Thread.sleep(5000);
		Library.custom_click(login.getSubmitbtn(), "submit Button");
		try {
			login.getSubmitbtn().click();
		} catch (Exception o) {
			o.getMessage();
	 	}
		System.out.println("The company name == " + selectcompany);
		System.out.println("The Site name == " + selectlocation);

	}

	public static void LOGIN(String filename) throws Exception {
		loginpom login = PageFactory.initElements(driver, loginpom.class);
		ConfigDataProvider config = new ConfigDataProvider(filename);
		login.getUserName().sendKeys(Keys.F2);
		Library.custom_Sendkeys(login.getConnection_String(), config.getconfigdata("str"), "Connection  String");
		Library.custom_Sendkeys(login.getUserName(), config.getconfigdata("username"), "Username");
		Thread.sleep(2000);
		Library.custom_Sendkeys(login.getPassword(), config.getconfigdata("password"), "Password");
		Library.custom_click(login.getLoginbtn(), "Login Button");
		try {
			login.getLoginbtn().click();
		} catch (Exception e) {
			//System.out.println(e);
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(login.getSelect_company()));

		Library.Custom_Dropdown(login.getSelect_company(), config.getconfigdata("selectcompany"), "Company");
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(login.getSelect_Location()));
		Library.Custom_Dropdown(login.getSelect_Location(), config.getconfigdata("selectsite"), "Company/Location");
		Thread.sleep(5000);
		Library.custom_click(login.getSubmitbtn(), "submit Button");
		try {
			login.getSubmitbtn().click();
		} catch (Exception e) {
			//System.out.println(e);
		}

	}

	public static void login(String filename) throws Exception {
		loginpom login = PageFactory.initElements(driver, loginpom.class);
		// Library.custom_click(login.getUserName(), "Keys.F2");
		ConfigDataProvider config = new ConfigDataProvider(filename);
		login.getUserName().sendKeys(Keys.F2);
		Library.custom_Sendkeys(login.getConnection_String(), config.getconfigdata("str"), "Connection  String");
		// login.getConnection_String().sendKeys(config.getconfigdata("str"));
		// login.getConnection_String().sendKeys("Server=PC43\\SQLEXPRESS;Database=QCNHADMPETPL;uid=sa;pwd=;Max
		// Pool Size=1000;Connection TimeOut= 3000;");
		Library.custom_Sendkeys(login.getUserName(), config.getconfigdata("username"), "Username");
		// login.getUserName().sendKeys(config.getconfigdata("username"));
		Library.custom_Sendkeys(login.getPassword(), config.getconfigdata("password"), "Password");
		// login.getPassword().sendKeys(config.getconfigdata("password"));
		// login.getLoginbtn().click();
		Thread.sleep(1000);
		Library.custom_click(login.getLoginbtn(), "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(login.getSelect_company()));
		wait.until(ExpectedConditions.visibilityOf(login.getSelect_Location()));
//		
//		Select selectcompany=new Select(login.getSelect_company());
//		selectcompany.selectByVisibleText(config.getconfigdata("selectcompany"));
//		
		Library.Custom_Dropdown(login.getSelect_company(), config.getconfigdata("selectcompany"), "Company");
		Thread.sleep(5000);
//		
//		Select selectlocation=new Select(login.getSelect_Location());
//		selectlocation.selectByVisibleText(config.getconfigdata("selectsite"));
		Library.Custom_Dropdown(login.getSelect_Location(), config.getconfigdata("selectsite"), "Company/Location");
		Thread.sleep(5000);
		Library.custom_click(login.getSubmitbtn(), "submit Button");
		// login.getSubmitbtn().click();
	}

	public static void login(String filename, String testcasename) throws Exception {
		test.log(Status.INFO, MarkupHelper.createLabel(testcasename, ExtentColor.GREEN));
		loginpom login = PageFactory.initElements(driver, loginpom.class);
		// Library.custom_click(login.getUserName(), "Keys.F2");
		ConfigDataProvider config = new ConfigDataProvider(filename);
		login.getUserName().sendKeys(Keys.F2);
		Library.custom_Sendkeys(login.getConnection_String(), config.getconfigdata("str"), "Connection  String");
		// login.getConnection_String().sendKeys(config.getconfigdata("str"));
		// login.getConnection_String().sendKeys("Server=PC43\\SQLEXPRESS;Database=QCNHADMPETPL;uid=sa;pwd=;Max
		// Pool Size=1000;Connection TimeOut= 3000;");
		Library.custom_Sendkeys(login.getUserName(), config.getconfigdata("username"), "Username");
		// login.getUserName().sendKeys(config.getconfigdata("username"));
		Library.custom_Sendkeys(login.getPassword(), config.getconfigdata("password"), "Password");
		// login.getPassword().sendKeys(config.getconfigdata("password"));
		// login.getLoginbtn().click();
		Library.custom_click(login.getLoginbtn(), "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(login.getSelect_company()));
		wait.until(ExpectedConditions.visibilityOf(login.getSelect_Location()));
//		
//		Select selectcompany=new Select(login.getSelect_company());
//		selectcompany.selectByVisibleText(config.getconfigdata("selectcompany"));
//		
		Library.Custom_Dropdown(login.getSelect_company(), config.getconfigdata("selectcompany"), "Company");
		Thread.sleep(5000);
//		
//		Select selectlocation=new Select(login.getSelect_Location());
//		selectlocation.selectByVisibleText(config.getconfigdata("selectsite"));
		Library.Custom_Dropdown(login.getSelect_Location(), config.getconfigdata("selectsite"), "Company/Location");
		Thread.sleep(5000);
		Library.custom_click(login.getSubmitbtn(), "submit Button");
		// login.getSubmitbtn().click();
	}

	public static void login(String Modulename, String filename, String testcasename) throws Exception {
		test.log(Status.INFO, MarkupHelper.createLabel(testcasename, ExtentColor.GREEN));
		loginpom login = PageFactory.initElements(driver, loginpom.class);
		// Library.custom_click(login.getUserName(), "Keys.F2");
		ConfigDataProvider config = new ConfigDataProvider(Modulename, filename);

		ExcelDataProvider Excel = new ExcelDataProvider();

		String LoginString = Excel.getStringdata("Sheet1", 0, 0);

		login.getUserName().sendKeys(Keys.F2);
		Library.custom_Sendkeys(login.getConnection_String(), LoginString, "Connection  String");
		// login.getConnection_String().sendKeys(config.getconfigdata("str"));
		// login.getConnection_String().sendKeys("Server=PC43\\SQLEXPRESS;Database=QCNHADMPETPL;uid=sa;pwd=;Max
		// Pool Size=1000;Connection TimeOut= 3000;");
		Library.custom_Sendkeys(login.getUserName(), config.getconfigdata("username"), "Username");
		// login.getUserName().sendKeys(config.getconfigdata("username"));
		Library.custom_Sendkeys(login.getPassword(), config.getconfigdata("password"), "Password");
		// login.getPassword().sendKeys(config.getconfigdata("password"));
		// login.getLoginbtn().click();
		Library.custom_click(login.getLoginbtn(), "Login Button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(login.getSelect_company()));
		wait.until(ExpectedConditions.visibilityOf(login.getSelect_Location()));
//		
//		Select selectcompany=new Select(login.getSelect_company());
//		selectcompany.selectByVisibleText(config.getconfigdata("selectcompany"));
//		
		Library.Custom_Dropdown(login.getSelect_company(), config.getconfigdata("selectcompany"), "Company");
		Thread.sleep(5000);
//		
//		Select selectlocation=new Select(login.getSelect_Location());
//		selectlocation.selectByVisibleText(config.getconfigdata("selectsite"));
		Library.Custom_Dropdown(login.getSelect_Location(), config.getconfigdata("selectsite"), "Company/Location");
		Thread.sleep(5000);
		Library.custom_click(login.getSubmitbtn(), "submit Button");
		// login.getSubmitbtn().click();
	}

	public static void Comboclick(WebElement element, String optionname, String Fieldname) {

		System.out.println("The Option Name Is ==" + optionname);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Wait Succesfully Applied On Field");
		System.out.print("");
		element.click();

		try {

			Reporter.log("Click sucessfully==" + Fieldname);
			test.log(Status.PASS, "Click sucessfully==" + Fieldname);
			WebElement Option = driver.findElement(By.xpath("//span[contains(text(),'" + optionname + "')]"));

			wait.until(ExpectedConditions.elementToBeClickable(Option));

			String text = Option.getText();

			Reporter.log("Option Sucessfully Selected==" + "<b>" + Fieldname + "==" + text + "</b>");

			test.log(Status.PASS, "Option Sucessfully Selected==" + "<b>" + Fieldname + "==" + text + "</b>");

			js.executeScript("arguments[0].click()", Option);

		} catch (Exception e) {
			System.err.println("Cannot Click " + e.getMessage());
			Reporter.log("<b><FONT COLOR=\"#ff0000\"> INVALID  Option/No such Option Present ==</FONT></b>"
					+ "<b><FONT COLOR=\"#0000ff\">" + Fieldname + "==" + optionname + "</FONT></b>");
			Reporter.log(e.getMessage());
			System.out.println(optionname + "==INVALID  Option/No such Option Present" + e.getMessage());
			test.log(Status.PASS, "<b><FONT COLOR=\"#ff0000\"> INVALID  Option/No such Option Present ==</FONT></b>"
					+ "<b>" + Fieldname + "==" + optionname + "</b>" + e.getMessage());
			// test.log(Status.FAIL, e.getMessage());
		}

	}

	public static void custom_click(WebElement element, String Fieldname) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Explicitlywait(element);
		try {

			if (element.isEnabled()) {
				// element.click();
				js.executeScript("arguments[0].click()", element);
				Reporter.log("Click Sucessfully == " + Fieldname);
				test.log(Status.PASS, "Click Sucessfully == " + Fieldname);
			}

			else {
				test.log(Status.FAIL, "No such field present == " + Fieldname);
				Reporter.log("No such field present == " + Fieldname);
				System.out.println("Element Not Found");
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log("No such field present == " + Fieldname);
			test.log(Status.FAIL, "No such field present == " + Fieldname + e.getMessage());
		}
	}

	public static void custom_Sendkeys(WebElement element, String value, String Fieldname) {

		if (element.isEnabled()) {

			element.sendKeys(value);
			Reporter.log(Fieldname + " value succesfully send == " + "<b>" + value + "</b>");
			test.log(Status.INFO, Fieldname + " value succesfully send == " + "<b>" + value + "</b>");

		} else {

			Reporter.log("No Such " + Fieldname + "   present");
			test.log(Status.PASS,
					MarkupHelper.createLabel("No Such " + Fieldname + "   present/Field is Disabled", ExtentColor.RED));
			// test.log(Status.PASS,"No Such "+Fieldname+" present" );
			// Exception e;

		}
	}

	public static void Custom_Dropdown(WebElement Element, String visibletext, String Fieldname) {
		try {
			Select select = new Select(Element);
			select.selectByVisibleText(visibletext);
			Reporter.log("Dropdown  " + Fieldname + " selected==" + visibletext);
			test.log(Status.PASS, "Dropdown  " + Fieldname + " selected==" + visibletext);
		}

		catch (Exception e) {

			test.log(Status.FAIL, e.getMessage());
		}
	}

	public static void UploadImg(WebElement element, String imagename, String Fieldname) {
		try {
			// JavascriptExecutor jse = ((JavascriptExecutor)driver);
			// WebElement email = driver.findElement(By.id("useremail"));
			if (element.isDisplayed() == true) {
				String imgpath = System.getProperty("user.dir") + "\\UploadImages\\" + imagename + ".png";
				// jse.executeScript("arguments[0].value='"+imgpath+"'", element);
				element.sendKeys(imgpath);
				System.out.println(imgpath);
				Reporter.log(imgpath);
				Reporter.log("Image Successfully Uploaded==" + Fieldname + "==" + imagename + ".png");
				test.log(Status.PASS, "Image Successfully Uploaded==" + Fieldname + "==" + imagename + ".png");
			}
		} catch (Exception e) {

			Reporter.log("No such image Available");
			test.log(Status.PASS, "No such image Available");
		}

	}

	public static void Scrolldown(int Horizontalpixel, int Verticalpixel) {

		String str1 = Integer.toString(Horizontalpixel);
		String str2 = Integer.toString(Verticalpixel);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + str1 + "," + str2 + ")");
	}

	public static void Explicitlywait(WebElement elemennt) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(elemennt));
		wait.until(ExpectedConditions.elementToBeClickable(elemennt));
		// wait.until(ExpectedConditions.(elemennt));
		// wait.until(ExpectedConditions.textToBePresentInElement(elemennt));
		// wait.until(ExpectedConditions.elementToBeClickable(elemennt);
	}

	public static void dClick(WebElement element) {
		Explicitlywait(element);
		try {
			element.click();
			test.log(Status.PASS, "Click Sucessfully==" + element.getText());
			Reporter.log("Click Sucessfully==" + element.getText());
			System.out.println("Click Sucessfully==" + element.getText());
		} catch (Exception e) {
			test.log(Status.FAIL, "Click Sucessfully==" + element.getText() + e.getMessage());

			System.out.println("Click Sucessfully==" + element.getText());
			System.out.println(e.getMessage());
		}
	}

	public static void dClick(WebElement element, String Fieldname) {

		try {
			Explicitlywait(element);

			String text = element.getText();
			element.click();
			Reporter.log("Click Sucessfully==" + element.getText());
			test.log(Status.PASS, "Click Sucessfully==" + text + "==" + Fieldname);
			System.out.println("Click Sucessfully==" + text + "==" + Fieldname);
		} catch (Exception e) {

			test.log(Status.PASS, "Click Sucessfully==" + element.getText() + "==" + Fieldname + e.getMessage());

			System.out.println("Click Sucessfully==" + element.getText() + "==" + Fieldname);
			System.out.println(e.getMessage());
		}
	}

	public static void searchwindowpopupenter(WebElement element, String optionname) throws Exception {

		Library.Explicitlywait(element, 50);
		element.click();

		WebElement itemsearch = driver.findElement(By.xpath("//input[@formcontrolname='item']"));
		Thread.sleep(6000);
		Library.custom_Sendkeys(itemsearch, optionname, "Item code Seacrch text box");
		Thread.sleep(6000);
		itemsearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //h4[contains(text(),'Item Details')] ")).click();
		System.out.println("Searching For Element ");
		WebElement selectitem = driver.findElement(By.xpath("//div[text()='" + optionname + "']"));
		Library.Explicitlywait(selectitem);

		selectitem.click();

		try {

			Library.ActionClick(selectitem, "item code");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(Status.PASS, "option succesfully selected==" + selectitem.getText() + e.getMessage());
		}

		test.log(Status.PASS, "option succesfully selected==" + selectitem.getText());
		Reporter.log("option succesfully selected==" + selectitem.getText());

	}

	public static void searchwindowpopup(WebElement element, String optionname) {
		// Explicitlywait(element);

		try {

			element.click();

			WebElement itemsearch = driver.findElement(By.xpath("//input[@formcontrolname='item']"));
			Thread.sleep(6000);
			Library.custom_Sendkeys(itemsearch, optionname, "Item code Seacrch text box");
			Thread.sleep(6000);
			itemsearch.sendKeys(Keys.ENTER);

			try {
				WebElement itemsearchbtn = driver
						.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));

				Library.custom_click(itemsearchbtn, "itemsearchbtn");
				if (itemsearchbtn.isEnabled()) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click()", itemsearchbtn);
				}
			}

			catch (Exception e) {

				//System.out.println(e);
			}

			try {

				WebElement itemsearchbtn = driver
						.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[1]"));

				Library.custom_click(itemsearchbtn, "itemsearchbtn");
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			Thread.sleep(2000);
			System.out.println("Searching For Element ");
			WebElement selectitem = driver.findElement(By.xpath("//div[text()='" + optionname + "']"));
			Library.Explicitlywait(selectitem);
			Library.dClick(selectitem);
			Library.dClick(selectitem);
			test.log(Status.PASS, "option succesfully selected==" + selectitem.getText());
			Reporter.log("option succesfully selected==" + selectitem.getText());
		}

		catch (Exception e) {
			// test.log(Status.FAIL, "No such option");

		}

	}

	public static void vendorselect(WebElement element, String optionname) {
		// Explicitlywait(element);

		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click()", element);
			Thread.sleep(2000);
			WebElement itemsearch = driver.findElement(By.xpath("//input[@formcontrolname='item']"));
			Library.Explicitlywait(itemsearch);
			// Library.dClick(itemsearch);
			Thread.sleep(3000);
			Library.custom_Sendkeys(itemsearch, optionname, "Item code Seacrch text box");
			Thread.sleep(3000);
			WebElement itemsearchbtn = driver
					.findElement(By.xpath("//button[@class='btn btn-outline-secondary btn-search border-0']"));
			Library.custom_click(itemsearchbtn, "itemsearchbtn");
			// Library.dClick(itemsearchbtn);
			Thread.sleep(3000);
			WebElement selectitem = driver.findElement(By.xpath("//div[text()='" + optionname + "']"));
			Library.Explicitlywait(selectitem);
			Thread.sleep(3000);
//		Actions act=new Actions(driver);
//		act.moveToElement(selectitem).doubleClick().build().perform();
			Library.dClick(selectitem);
			Library.dClick(selectitem);
			test.log(Status.PASS, "option succesfully selected==" + selectitem.getText());
			Reporter.log("option succesfully selected==" + selectitem.getText());
		}

		catch (Exception e) {
			// test.log(Status.FAIL, "No such option");

		}

	}

	public static void info(WebElement element, String Fieldname) {
		try {
			if (element.isEnabled() == true) {
				Library.Explicitlywait(element);

				// test.log(Status.INFO,"New generated "+Fieldname+"=="+element.getText());

				test.log(Status.INFO, MarkupHelper.createLabel("New generated " + Fieldname + "==" + element.getText(),
						ExtentColor.BLUE));
				// Reporter.log("<b><FONT COLOR=\\\"blue\\\">"+"New generated
				// "+Fieldname+"=="+element.getText()+"</FONT></b>");
				Reporter.log("<b><FONT COLOR=\\\"1f1f7a\\\">" + "New generated " + Fieldname + "==" + element.getText()
						+ "</FONT></b>");
				System.out.println("New generated " + Fieldname + "==" + element.getText());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// test.log(Status.SKIP, "element not visible");

		}

	}

	public static void ActionClick(WebElement element, String Fieldname) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).click().build().perform();
			Thread.sleep(2000);
			test.log(Status.PASS, "Click Sucessfully==" + Fieldname);

			Reporter.log("Click Sucessfully==" + Fieldname);
			System.out.println("Click Sucessfully==" + Fieldname);
		}

		catch (Exception e) {

			test.log(Status.FAIL, "Click Failed==" + Fieldname);

		}
	}

	public static void ActionDoubleClick(WebElement element, String Fieldname) {
		try {
			Actions act = new Actions(driver);
			Thread.sleep(1000);
			act.moveToElement(element).doubleClick(element).build().perform();
			Thread.sleep(2000);
			test.log(Status.PASS, "Click Sucessfully==" + Fieldname);
			Reporter.log("Click Sucessfully==" + Fieldname);
			System.out.println("Click Sucessfully==" + Fieldname);
		}

		catch (Exception e) {

			// test.log(Status.FAIL,"Click Failed=="+Fieldname);

		}
	}

	public static void Customerselect(WebElement element, String optionname) {
		// Explicitlywait(element);

		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click()", element);
			Thread.sleep(2000);
			WebElement itemsearch = driver.findElement(By.xpath("//input[@formcontrolname='item']"));
			Library.Explicitlywait(itemsearch);
			// Library.dClick(itemsearch);
			Thread.sleep(3000);
			Library.custom_Sendkeys(itemsearch, optionname, "Item code Seacrch text box");
			Thread.sleep(3000);
			WebElement itemsearchbtn = driver
					.findElement(By.xpath("(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]"));
			Library.custom_click(itemsearchbtn, "itemsearchbtn");
			// Library.dClick(itemsearchbtn);
			Thread.sleep(3000);
			WebElement selectitem = driver.findElement(By.xpath("//div[text()='" + optionname + "']"));
			Library.Explicitlywait(selectitem);
			Thread.sleep(3000);
//		Actions act=new Actions(driver);
//		act.moveToElement(selectitem).doubleClick().build().perform();
			Library.dClick(selectitem);
			Library.dClick(selectitem);
			test.log(Status.PASS, "option succesfully selected==" + selectitem.getText());
			Reporter.log("option succesfully selected==" + selectitem.getText());
		}

		catch (Exception e) {
			// test.log(Status.FAIL, "No such option");

		}
	}

	public static void flaginfo(WebElement element, String msg) {

		// Library.Explicitlywait(element);

		Library.custom_click(element, msg);
		test.log(Status.INFO, msg);
		Reporter.log(msg);

	}

	public static void horizontalscroll(int step) throws Exception {

		WebElement horizontalscroll = driver
				.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnDownhorizontalScrollBarjqxWidget')]"));

		for (int i = 0; i < step; i++) {
			Thread.sleep(100);
			Library.Explicitlywait(horizontalscroll);
			Library.dClickHorizontal(horizontalscroll, "Horizontal Scroll Button");

		}
	}

	public static void horizontalscrollback(int step) throws Exception {

		WebElement horizontalscroll = driver
				.findElement(By.xpath("//div[contains(@id,'jqxScrollBtnUphorizontalScrollBarjqxWidget')]"));

		for (int i = 0; i < step; i++) {
			Thread.sleep(100);
			Library.Explicitlywait(horizontalscroll);
			Library.dClickHorizontal(horizontalscroll, "Horizontal Scroll Button");

		}
	}

	public static void validation(WebElement element, String msg, String Fieldname) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			// wait.until(ExpectedConditions.elementToBeClickable(element));
			test.log(Status.INFO, MarkupHelper.createLabel("New generated " + Fieldname + "==" + element.getText(),
					ExtentColor.BLUE));

			Reporter.log("New generated " + Fieldname + "==" + element.getText());

		}

		catch (Exception e) {

			test.log(Status.PASS, MarkupHelper.createLabel(" " + msg, ExtentColor.RED));

			// driver.navigate().to("http://192.168.0.147:8014/engineering/masters/items/add");
		}
	}

	public static void Ertrormassage(WebElement msg) {

		test.log(Status.PASS, MarkupHelper.createLabel(" " + msg.getText(), ExtentColor.RED));

		Reporter.log(" " + msg.getText());
	}

	public static void filelocationConfigreport(String modulename, String filename) {

		String path = System.getProperty("user.dir") + "\\ConfigFiles\\" + modulename + "\\" + filename + ".properties";
		test.log(Status.INFO, MarkupHelper.createLabel(path, ExtentColor.INDIGO));

		Reporter.log(path);
	}

	public static void Explicitlywait(WebElement elemennt, int time) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(elemennt));
		wait.until(ExpectedConditions.elementToBeClickable(elemennt));
		System.out.println("Wait Statement Succesfully ExceutedS");
	}

	public static void massagelog(String msg) {

		test.log(Status.INFO, MarkupHelper.createLabel(" " + msg, ExtentColor.GREY));
		Reporter.log(msg);

	}

	public static void Savemassagelog(String msg) {

		test.log(Status.INFO, MarkupHelper.createLabel(" " + msg, ExtentColor.GREEN));
		Reporter.log("<font color =" + "blue" + ">" + msg + "</font>");
		System.out.println(msg);

	}

	public static void ERRORmassagelog(String msg) {

		test.log(Status.INFO, MarkupHelper.createLabel(" " + msg, ExtentColor.RED));
		Reporter.log(msg);
	}

	public static void massagelog(WebElement ele, String msg) {

		test.log(Status.INFO, MarkupHelper.createLabel(ele.getText() + msg, ExtentColor.BROWN));
		Reporter.log(ele.getText() + "  " + msg);
	}

	public static void ComboInput(WebElement Comboboxformcontrol, WebElement inputfieldelement, String optionname,
			String Fieldname) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOf(Comboboxformcontrol));
			wait.until(ExpectedConditions.elementToBeClickable(Comboboxformcontrol));

			Comboboxformcontrol.click();
			Library.custom_Sendkeys(inputfieldelement, optionname, "SJO Item Search Field");
			Thread.sleep(3000);
			Comboboxformcontrol.click();

			Reporter.log("Click sucessfully==" + Fieldname);
			test.log(Status.PASS, "Click sucessfully==" + Fieldname);
			WebElement Option = driver.findElement(By.xpath("//span[contains(text(),'" + optionname + "')]"));

			wait.until(ExpectedConditions.elementToBeClickable(Option));

			String text = Option.getText();

			Reporter.log("Option Sucessfully Selected==" + "<b>" + Fieldname + "==" + text + "</b>");

			test.log(Status.PASS, "Option Sucessfully Selected==" + "<b>" + Fieldname + "==" + text + "</b>");

			// System.out.println("Option true");

			js.executeScript("arguments[0].click()", Option);
			// System.out.println("Option SElected=="+optionname);
			// kg.click();

			// System.out.println(optionname+"==NO Such Option Present");

		} catch (Exception e) {
			// System.err.println("Cannot Click " + e.getMessage());
			Reporter.log("<b><FONT COLOR=\"#ff0000\"> INVALID  Option/No such Option Present ==</FONT></b>"
					+ "<b><FONT COLOR=\"#0000ff\">" + Fieldname + "==" + optionname + "</FONT></b>");
			Reporter.log(e.getMessage());
			System.out.println(optionname + "==INVALID  Option/No such Option Present" + e.getMessage());
			test.log(Status.PASS, "<b><FONT COLOR=\"#ff0000\"> INVALID  Option/No such Option Present ==</FONT></b>"
					+ "<b>" + Fieldname + "==" + optionname + "</b>");
			// test.log(Status.FAIL, e.getMessage());
		}

	}

	public static void testcasedesc(String testcaseID, String desc) {

		test.log(Status.INFO, MarkupHelper.createLabel(testcaseID + "==" + desc, ExtentColor.INDIGO));
		Reporter.log("<b><FONT COLOR=\\\"1f7a1f\\\">" + "Test Case ID==" + testcaseID + "</FONT></b>");
		Reporter.log("<b><FONT COLOR=\\\"1f7a1f\\\">" + "Test Case Description==" + desc + "</FONT></b>");

	}

	public static void dClickHorizontal(WebElement element, String Fieldname) {

		try {
			Explicitlywait(element);

			String text = element.getText();
			element.click();

		} catch (Exception e) {

			System.out.println("Click Sucessfully==" + element.getText() + "==" + Fieldname);
			System.out.println(e.getMessage());
		}
	}

	public static void failmassage(String msg) {

		test.log(Status.FAIL, MarkupHelper.createLabel(" " + msg, ExtentColor.RED));
		Reporter.log(msg);

		Reporter.log(msg);

	}

	public static void TestcaseFailed() {

		test.fail("Test Case Fail");
		Reporter.log("Test Case Fail");

	}

	public static String ExelFilepath(String foldername, String Filename) {

		String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\" + foldername + "\\" + Filename + ".xlsx";

		return excelpath;
	}

	public static String MONTH(String month) {

		if (month.equalsIgnoreCase("01")) {

			return "January";
		}

		else if (month.equalsIgnoreCase("02")) {

			return "February";
		} else if (month.equalsIgnoreCase("03")) {

			return "March";
		}

		else if (month.equalsIgnoreCase("04")) {

			return "April";
		}

		else if (month.equalsIgnoreCase("05")) {

			return "May";
		}

		else if (month.equalsIgnoreCase("06")) {

			return "June";
		}

		else if (month.equalsIgnoreCase("07")) {

			return "July";
		} else if (month.equalsIgnoreCase("08")) {

			return "August";
		}

//September  October   November   December	

		else if (month.equalsIgnoreCase("09")) {

			return "September";
		}

		else if (month.equalsIgnoreCase("10")) {

			return "October";
		}

		else if (month.equalsIgnoreCase("11")) {

			return "November";
		}

		else if (month.equalsIgnoreCase("12")) {

			return "December";
		}

		return "No any Month";
	}

	public static void Thread(String yes_NO, long time) throws Exception {

		if (yes_NO.equalsIgnoreCase("yes")) {
			Thread.sleep(time * 1000);
			System.out.println("Thread succsfully applied time ==" + time * 1000 + "ms");
		}

		else {
			Thread.sleep(time * 10);
		}

	}

	
	
	
	
	public static void SELECTBYBYVALUE(WebElement elemnet,String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(elemnet));
		Select select=new Select(elemnet);
		select.selectByValue(value);
		
	}
}