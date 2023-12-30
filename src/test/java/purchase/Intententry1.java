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
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class Intententry1 extends BaseClass{
	
	
	
@Test()
public void test_01() throws Exception {
	

	ConfigDataProvider config=new ConfigDataProvider("intententry");
	Library.login();
	
	Indententrypom indent=	PageFactory.initElements(driver, Indententrypom.class);
	
	Library.custom_click(indent.getPurchasemodule(),"PurchaseModule");
	Library.custom_click(indent.getIntentEntry(),"IndentEntry");
	Library.custom_click(indent.getAddnewbtn(),"AddNewBtn");
	
	Thread.sleep(10000);
	
	Library.Comboclick(indent.getIntendtReqBy(), config.getconfigdata("IndentReqBy"),"IntentReqBy");
	
	//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']
	
	WebElement calendor=driver.findElement(By.xpath("//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));
	
	//calendar.selectcalendardate(calendor,20,"May", 2022);
	Library.dClick(calendor);
	WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	Library.dClick(prebtn);
	Library.dClick(prebtn);
	Library.Scrolldown(0, 10);
	WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
    Library.dClick(date);
	Library.dClick(indent.getFirstNextBtn());
	Library.dClick(indent.getSecondNextBtn());
	Library.dClick(indent.getfirstAddNewbtn());

	WebElement selectiten=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[5]"));
	Thread.sleep(6000);
	Library.searchwindowpopup(selectiten,config.getconfigdata("ITEMCODE"));
	Thread.sleep(6000);
	WebElement selectvendor=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
	Thread.sleep(12000);
	Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
    Library.Scrolldown(0, 100);
    Thread.sleep(3000);
   
	Library.custom_click(indent.getsecondAddNewbtn(),"Add new second btn");
	Library.Scrolldown(0, 150);

	Thread.sleep(10000);
	try {
		
		driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]")).click();
		
		Thread.sleep(3000);
	WebElement Quantyfiled=driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

	Quantyfiled.sendKeys(config.getconfigdata("Quantity"));
	Quantyfiled.sendKeys(Keys.ENTER);
	
	
	}
	catch(Exception e) {
		
		e.getMessage();
		System.out.println(e.getMessage());
	}
//	(//div[contains(@id,'row0')]/div[5])[2]
	
	
	WebElement jqxCalendor=driver.findElement(By.xpath("(//div[contains(@id,'row0')]/div[5])[2]"));
	String date1=config.getconfigdata("date");
	JQXGRID.jqxcalendor(jqxCalendor,date1);
//	Thread.sleep(2000);
//	if(jqxCalendor.isEnabled()) {
//	jqxCalendor.click();
//	}
//Thread.sleep(2000);
//	driver.findElement(By.xpath("(//td[text()='15'])[2]")).click();
//	
	
	
	//Add second item into indent Entry
	Thread.sleep(6000);
	Library.Scrolldown(0, -400);
	Library.dClick(indent.getfirstAddNewbtn());
	
	Thread.sleep(2000);
	
	WebElement secondsearchbtn=driver.findElement(By.xpath("//div[contains(@id,'row1')]/div[5]"));
	Library.searchwindowpopup(secondsearchbtn,config.getconfigdata("ITEMCODE2"));
	
	Thread.sleep(6000);
//	Library.searchwindowpopup(selectiten,config.getconfigdata("ITEMCODE1"));
//	Thread.sleep(2000);
//	WebElement secondvendorsearchbtn=driver.findElement(By.xpath("//div[contains(@id,'row1')]/div[13]"));
//	Thread.sleep(10000);
//	Library.searchwindowpopup(secondvendorsearchbtn, config.getconfigdata("VENDORCODE"));
    Library.Scrolldown(0, 100);
	
    Library.custom_click(indent.getsecondAddNewbtn(),"Add new second btn");
	Library.Scrolldown(0, 220);

	Thread.sleep(10000);
	try {
		driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidge')]/div[4])[2]")).click();
//driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]")).click();
		
		Thread.sleep(3000);
	WebElement Quantyfiled1=driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

	Quantyfiled1.sendKeys(config.getconfigdata("Quantity"));
	Quantyfiled1.sendKeys(Keys.ENTER);
	
	
	}
	
catch(Exception e) {
	
	e.getMessage();
		System.out.println(e.getMessage());
	}
	
	Library.Scrolldown(0, -500);
	WebElement savebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
	Library.Explicitlywait(savebtn);
	Library.dClick(savebtn);
	
	Thread.sleep(6000);
	WebElement checkbox=driver.findElement(By.xpath("//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
	Library.dClick(checkbox);
	
	WebElement ponumber=driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
	Library.info(ponumber, "PO NUmber");
	
	Thread.sleep(3000);
	WebElement Authorizebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	Authorizebtn.click();
	
}

@Test(enabled=false)
//pass test case
public void Test_04() throws Exception {

	ConfigDataProvider config=new ConfigDataProvider("intententry");
	Library.login();
	
	Indententrypom indent=	PageFactory.initElements(driver, Indententrypom.class);
	
	Library.custom_click(indent.getPurchasemodule(),"PurchaseModule");
	Library.custom_click(indent.getIntentEntry(),"IndentEntry");
	Library.custom_click(indent.getAddnewbtn(),"AddNewBtn");
	
	Thread.sleep(10000);
	
	Library.Comboclick(indent.getIntendtReqBy(), config.getconfigdata("IndentReqBy"),"IntentReqBy");
	
	//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']
	
	WebElement calendor=driver.findElement(By.xpath("//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));
	
	//calendar.selectcalendardate(calendor,20,"May", 2022);
	Library.dClick(calendor);
	WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	Library.dClick(prebtn);
	Library.dClick(prebtn);
	Library.Scrolldown(0, 10);
	WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
    Library.dClick(date);
	Library.dClick(indent.getFirstNextBtn());
	Library.dClick(indent.getSecondNextBtn());
	Library.dClick(indent.getfirstAddNewbtn());

	WebElement selectiten=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[5]"));
	Thread.sleep(3000);
	Library.searchwindowpopup(selectiten,config.getconfigdata("ITEMCODE"));
	WebElement selectvendor=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
	Thread.sleep(10000);
	Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
    Library.Scrolldown(0, 100);
    
	Library.custom_click(indent.getsecondAddNewbtn(),"Add new second btn");
	Library.Scrolldown(0, 150);

	Thread.sleep(10000);
	try {
		
		driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]")).click();
		
		Thread.sleep(3000);
	WebElement Quantyfiled=driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));

	Quantyfiled.sendKeys("1");
	Quantyfiled.sendKeys(Keys.ENTER);
	
	
	}
	catch(Exception e) {
		
		e.getMessage();
		System.out.println(e.getMessage());
	}
	
	Library.Scrolldown(0, -500);
	WebElement savebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange ml-2 key key-s']"));
	Library.Explicitlywait(savebtn);
	Library.dClick(savebtn);
	
	Thread.sleep(6000);
	WebElement checkbox=driver.findElement(By.xpath("//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']"));
	Library.dClick(checkbox);
	
	WebElement ponumber=driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[7]"));
	Library.info(ponumber, "PO NUmber");
	
	Thread.sleep(3000);
	WebElement Authorizebtn=driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	Authorizebtn.click();
}




























































@Test(enabled=false)

public void test_02() throws Exception {

	ConfigDataProvider config=new ConfigDataProvider("intententry");
	Library.login();
	Indententrypom indent=	PageFactory.initElements(driver, Indententrypom.class);
	Library.custom_click(indent.getPurchasemodule(),"PurchaseModule");
	Library.custom_click(indent.getIntentEntry(),"IndentEntry");
	Library.custom_click(indent.getAddnewbtn(),"AddNewBtn");
	Thread.sleep(10000);
	Library.dClick(indent.getCALENDOR());
	WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	Library.dClick(prebtn);
	Library.dClick(prebtn);
	Library.Scrolldown(0, 10);
	WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
    Library.dClick(date);
	Library.dClick(indent.getFirstNextBtn());
	Library.dClick(indent.getSecondNextBtn());
	Library.dClick(indent.getfirstAddNewbtn());
	Thread.sleep(3000);
	Library.searchwindowpopup(indent.getITEMCODESEARCHBTN(),config.getconfigdata("ITEMCODE"));
	Thread.sleep(10000);
	Library.searchwindowpopup(indent.getVENDORCODESEARCHBTN(), config.getconfigdata("VENDORCODE"));
    Library.Scrolldown(0, 100);
     Library.Scrolldown(0, 100);
     Thread.sleep(4000);
    Library.custom_click(indent.getsecondAddNewbtn(),"Add new second btn");
	Library.Scrolldown(0, 150);
	try {
		
		indent.getQuantity().click();
		Thread.sleep(3000);
		//WebElement Quantyfiled=driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));
indent.getQuantitytextboxfield();

Library.custom_Sendkeys(indent.getQuantitytextboxfield(),config.getconfigdata("Quantity"),"Quantity Field");

indent.getQuantitytextboxfield().sendKeys(Keys.ENTER);
	}
	
	catch(Exception e) {
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



	
@Test(enabled=false)
public void test_00() throws Exception {
	
	ConfigDataProvider config=new ConfigDataProvider("intententry");
	Library.login();
	
	Indententrypom indent=	PageFactory.initElements(driver, Indententrypom.class);
	
	Library.custom_click(indent.getPurchasemodule(),"PurchaseModule");
	Library.custom_click(indent.getIntentEntry(),"IndentEntry");
	Library.custom_click(indent.getAddnewbtn(),"AddNewBtn");
	
	Thread.sleep(10000);
	
	Library.Comboclick(indent.getIntendtReqBy(), config.getconfigdata("IndentReqBy"),"IntentReqBy");
	
	//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']
	
	WebElement calendor=driver.findElement(By.xpath("//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']"));
	//calendor.click();
	Library.dClick(calendor);
	//Library.custom_click(calendor, "calendor");
	WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	//Library.custom_click(prebtn, "Previousbtn");
//	Library.custom_click(prebtn, "Previousbtn");
	
	Library.dClick(prebtn);
	Library.dClick(prebtn);
	Library.Scrolldown(0, 10);
	WebElement date=driver.findElement(By.xpath("//td[text()='12']"));

	Library.dClick(date);
	Library.dClick(indent.getFirstNextBtn());
	Library.dClick(indent.getSecondNextBtn());
	Library.dClick(indent.getfirstAddNewbtn());
	
	//(//input[contains(@id,'Button')])[3]
	
	WebElement selectiten=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[5]"));
	Thread.sleep(3000);
	Library.searchwindowpopup(selectiten,config.getconfigdata("ITEMCODE"));
	WebElement selectvendor=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
	Thread.sleep(3000);
	Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
	selectiten.click();
	//Library.dClick(selectiten);
	//Library.custom_click(selectiten, "Search new btn");
	WebElement itemsearch=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
	Library.custom_Sendkeys(itemsearch, config.getconfigdata("ITEMCODE"), "Item code Seacrch text box");
	Thread.sleep(3000);
	WebElement itemsearchbtn=driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary btn-search border-0']"));
	Library.custom_click(itemsearchbtn,"itemsearchbtn");
	//Library.dClick(itemsearchbtn);
	Thread.sleep(3000);
	WebElement selectitem=driver.findElement(By.xpath("//div[text()='"+config.getconfigdata("ITEMCODE")+"']"));
	Thread.sleep(3000);
	Library.dClick(selectitem);
	Library.dClick(selectitem); 
	
	Thread.sleep(10000);
//
//	WebElement selectvendor=driver.findElement(By.xpath("(//input[contains(@id,'jqxWidge')])[6]"));
//	Thread.sleep(3000);
//	Library.searchwindowpopup(selectvendor, config.getconfigdata("VENDORCODE"));
	
	//Library.dClick(selectitem);
	
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
