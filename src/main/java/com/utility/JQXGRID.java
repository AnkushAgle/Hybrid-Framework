package com.utility;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class JQXGRID extends Library{
	
	
	public static void JQXDropdown(WebElement element,String Optionname) throws Exception {
		
		Library.Explicitlywait(element);
		
		
		element.click();//div[contains(@id,'whCode')]
		Thread.sleep(5000);
		WebElement wareHousename=driver.findElement(By.xpath("//span[contains(text(),'"+Optionname+"')]"));
		Library.Explicitlywait(wareHousename,20);
		Thread.sleep(1000);
		Library.dClick(wareHousename);
		
		test.log(Status.PASS,"Option Sucessfully selected =="+wareHousename.getText());
		 Robot robot = new Robot(); 
		 Thread.sleep(2000);	
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
		
	}

	
	public static void jqxcalendor(WebElement jqxCalendor,String date) throws Exception {
		
		Library.Explicitlywait(jqxCalendor);
		Thread.sleep(2000);
		if(jqxCalendor.isEnabled()) {
		jqxCalendor.click();
		
		Thread.sleep(4000);
			WebElement Date=driver.findElement(By.xpath("(//td[text()='"+date+"'])[2]"));
			Thread.sleep(4000);
			Date.click();
			test.log(Status.PASS,"Date Sucessfully seleected date=="+date);
		}
	else{
		
		test.log(Status.SKIP,"Event Skip");		
	}
	}
	
	
	public static void JQXDIRECTITEM(WebElement element,String itemcode) {
		
		try {
			//Library.Explicitlywait(element);
			Thread.sleep(3000);
			Library.dClick(element,"Item code searchbtn");

			WebElement Itemcode=driver.findElement(By.xpath("//div[text()='"+itemcode+"']"));
			Library.Explicitlywait(Itemcode);
			Thread.sleep(6000);
		
			Itemcode.click();
			Itemcode.click();
			//Itemcode.sendKeys(Keys.ENTER);
			test.log(Status.INFO, "Itemcode Sucessfully selected =="+itemcode);
		}
		
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static void Qtybox(WebElement element,String Qty) {
		
		try {
	//	WebElement Qtytxtbox2=driver.findElement(By.xpath("//div[contains(@id,'puom')]/input"));
		Library.Explicitlywait(element);
		Thread.sleep(2000);
		element.sendKeys(Qty);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		test.log(Status.PASS,"Quantity SucesssFully send=="+Qty);
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

public static  void Jcalendarsendkeys(WebElement fcalendor,String date) throws Exception {
	
	//WebElement fcalendor=driver.findElement(By.xpath("(//div[contains(@id,'row0jqxWidget')]/div[8])[2]"));
Library.Explicitlywait(fcalendor);
	Thread.sleep(3000);
	Library.dClick(fcalendor);
	Library.dClick(fcalendor);
	
	WebElement datefield=driver.findElement(By.xpath("//input[contains(@id,'date')]"));
	Library.Explicitlywait(datefield);
	datefield.sendKeys(date);
	datefield.sendKeys(Keys.ENTER);
	test.log(Status.PASS,"Date Succesfully Selected=="+date);
	
}
public static void JQXDIRECTITEMSearch(WebElement element,String itemcode) {
	
	try {
		//Library.Explicitlywait(element);
		
		Library.dClick(element,"Item code searchbtn");
		Thread.sleep(7000);
		WebElement item=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
		Library.Explicitlywait(item);
		Thread.sleep(4000);
		Library.custom_Sendkeys(item, itemcode, "Item code Search Filed");
		Thread.sleep(1000);
		item.submit();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.getAutoDelay();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

		WebElement Itemcode=driver.findElement(By.xpath("//div[text()='"+itemcode+"']"));
		Library.Explicitlywait(Itemcode);
		Thread.sleep(6000);
	
		Itemcode.click();
		Itemcode.click();
		//Itemcode.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Itemcode Sucessfully selected =="+itemcode);
	}
	
	catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
}

public static void ITEMSearchPOPUp(WebElement element,String itemcode) {
	
	try {
		//Library.Explicitlywait(element);
		
		Library.dClick(element,"Item code searchbtn");
		Thread.sleep(7000);
		WebElement item=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
		Library.Explicitlywait(item);
		Thread.sleep(4000);
		Library.custom_Sendkeys(item, itemcode, "Item code Search Filed");
		Thread.sleep(1000);
		WebElement itemsearchbtn=driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary btn-search border-0']"));
		Thread.sleep(1000);
		Library.dClick(itemsearchbtn,"itemsearchbtn");
		//Library.dClick(itemsearchbtn);
		Thread.sleep(3000);

		WebElement Itemcode=driver.findElement(By.xpath("//div[text()='"+itemcode+"']"));
		Library.Explicitlywait(Itemcode);
		Thread.sleep(6000);
	
		Itemcode.click();
		Itemcode.click();
		//Itemcode.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Itemcode Sucessfully selected =="+itemcode);
	}
	
	catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
}



public static void JQXDropdowntemp(WebElement element,String Optionname) throws Exception {
	
	Library.Explicitlywait(element);
	
	
	element.click();//div[contains(@id,'whCode')]
	Thread.sleep(5000);
	
	 for(int i=1;i<=12;i++){  
		 Robot robot = new Robot();
		 Thread.sleep(500);
	        // Scroll Down using Robot class
	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	        robot.keyRelease(KeyEvent.VK_PAGE_DOWN); 
	    }  
	WebElement wareHousename=driver.findElement(By.xpath("//span[contains(text(),'"+Optionname+"')]"));
	Library.Explicitlywait(wareHousename);
	Thread.sleep(1000);
	Library.dClick(wareHousename);
	
	test.log(Status.PASS,"Option Sucessfully selected =="+wareHousename.getText());
	 Robot robot = new Robot(); 
	 Thread.sleep(2000);	
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     Thread.sleep(2000);
	
}

































public static void JQXDIRECTITEMSearchtemp(WebElement element,String itemcode) {
	
	try {
		//Library.Explicitlywait(element);
		
		Library.dClick(element,"Item code searchbtn");
		Thread.sleep(7000);
		WebElement item=driver.findElement(By.xpath("//input[@formcontrolname='item']"));
		Library.Explicitlywait(item);
		Thread.sleep(4000);
		Library.custom_Sendkeys(item, itemcode, "Item code Search Filed");
		Thread.sleep(1000);
		item.submit();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.getAutoDelay();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

		WebElement Itemcode=driver.findElement(By.xpath("(//div[text()='"+itemcode+"'])[6]"));
		Library.Explicitlywait(Itemcode);
		Thread.sleep(6000);
	
		Itemcode.click();
		Itemcode.click();
		//Itemcode.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Itemcode Sucessfully selected =="+itemcode);
	}
	
	catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
}









}
