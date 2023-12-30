package COM.TEST;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageobject.POMaintenanceNew;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class pomaintenancenew extends BaseClass {
	


@Test
public void m2() throws Exception {
	
	ConfigDataProvider config=new ConfigDataProvider("PoMaintenanceNew");
      Library.login("PoMaintenanceNew");
	
	POMaintenanceNew element=PageFactory.initElements(driver,POMaintenanceNew.class);
	
	Library.custom_click(element.getPurchasemodule(),"Purchasemodule");
	Library.custom_click(element.getPOMaintenanceNew(),"Po  mainteance New");
	Library.custom_click(element.getPOaddnewbutton(),"Add New Btn");
	
	Thread.sleep(5000);
	Library.Explicitlywait(element.getPODATE());
	
	calendar.daypicker(element.getPODATE(),config.getconfigdata("DAY"),config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
	
	 Library.dClick(element.getPOINFONEXTBTN());
		//Library.dClick(element.getVendoraddsearchbtn());
	 Thread.sleep(5000);
	 WebElement vendorsearch=driver.findElement(By.xpath("//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input"));
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
		Library.Comboclick(element.getBuyer(),"HKP","buyer");
		Library.dClick(element.getVendorInfoNextBtn());
		Library.Explicitlywait(element.getRateStructure());
		Library.Comboclick(element.getRateStructure(),"PIG1", "Structure rate");
		
		Library.dClick(element.getRateStryctureNextBtn());
		
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[5]"));
		System.out.println(config.getconfigdata("QtyPUOM"));
		
		JQXGRID.JQXDropdown(ele,"MYWAR");
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
         
       // WebElement QtyPUOM= driver.findElement(By.xpath("//div[contains(@id,'row0')]/div[8]"));
       Library.Explicitlywait(element.getQtyPUOM());
       WebElement Qtypiom=element.getQtyPUOM();      
       //Library.dClick(Qtypiom);
       Thread.sleep(8000);
      // Library.custom_Sendkeys(Qtypiom, config.getconfigdata("QtyPUOM"),"QtyPUOM");
       Qtypiom.click();
       
       
     WebElement Qtytextbox=  driver.findElement(By.xpath("//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']"));
       Thread.sleep(3000);
       String Qty=config.getconfigdata("QtyPUOM");
      
       Thread.sleep(1500);
       Qtytextbox.sendKeys("10");
       //Qtypiom.sendKeys(Keys.ENTER);
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        Library.Scrolldown(0, -600);
        
        Library.dClick(element.getSAVEBTN());
      Thread.sleep(8000);
      
   WebElement Authorizecheckbox=   element.getAuthorizecheckbox();

Library.Explicitlywait(Authorizecheckbox);
Thread.sleep(3000);
Library.dClick(Authorizecheckbox);

Thread.sleep(5000);
Library.Explicitlywait(element.getAuthorizebtn());
Library.dClick(element.getAuthorizebtn());
Thread.sleep(4000);

}






























@Test(enabled=false)


public void m1() throws Exception{
	
	Library.login("PoMaintenanceNew");
	
	POMaintenanceNew element=PageFactory.initElements(driver,POMaintenanceNew.class);
	ConfigDataProvider config=new ConfigDataProvider("PoMaintenanceNew");
	Library.custom_click(element.getPurchasemodule(),"Purchasemodule");
	Library.custom_click(element.getPOMaintenanceNew(),"Po  mainteance New");
	Library.custom_click(element.getPOaddnewbutton(),"Add New Btn");
	
	Thread.sleep(3000);
	Library.Explicitlywait(element.getPODATE());
	Library.dClick(element.getPODATE());
	
	calendar.daypicker(element.getPODATE(),config.getconfigdata("DAY"),config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
	WebElement MonthYear=driver.findElement(By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
	String Monthyear=MonthYear.getText();
	System.out.println(MonthYear);
	String Month1=Monthyear.split(" ")[0];
	System.out.println("Month1");
	String Year1=Monthyear.split(" ")[1];
	System.out.println(Year1);
	Thread.sleep(2000);
	
while(!(Month1.equals("February")&&Year1.equals("2021"))) {
		
		WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	//	Library.Explicitlywait(prebtn);
        Library.dClick(prebtn);
        MonthYear=driver.findElement(By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
		String nemm=MonthYear.getText();	
		System.out.println(MonthYear.getText());
		Month1=nemm.split(" ")[0];
		System.out.println(Month1);
		Year1=nemm.split(" ")[1];
		System.out.println(Year1);
	}
Thread.sleep(2000);
WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
Library.dClick(date);


	WebElement prebtn=driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
	Library.dClick(prebtn);
	Library.dClick(prebtn);
	Library.Scrolldown(0, 10);
//	WebElement date=driver.findElement(By.xpath("//td[text()='12']"));
//    Library.dClick(date);
	Library.dClick(element.getPOINFONEXTBTN());
	//Library.dClick(element.getVendoraddsearchbtn());
	
	JavascriptExecutor js = (JavascriptExecutor)driver;

	Library.Explicitlywait(element.getVendoraddsearchbtn());
	Library.vendorselect(element.getVendoraddsearchbtn(),"A001");
	Library.Explicitlywait(element.getBuyer());
	Library.Comboclick(element.getBuyer(),"HKP","buyer");
	Library.dClick(element.getVendorInfoNextBtn());
	Library.Explicitlywait(element.getRateStructure());
	Library.Comboclick(element.getRateStructure(),"PIG1", "Structure rate");
	
	Library.dClick(element.getRateStryctureNextBtn());
	
	WebElement ele=driver.findElement(By.xpath("(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms jqx-grid-cell-selected jqx-grid-cell-selected-imms jqx-fill-state-pressed jqx-fill-state-pressed-imms'])[3]"));
	
	
	ele.click();//div[contains(@id,'whCode')]
	
	driver.findElement(By.xpath("//span[text()='MYWAR - my ware house name']")).click();
	//div[@columnindex='9']
	
	//div[contains(@id,'qtypuom')]
	
}
}
