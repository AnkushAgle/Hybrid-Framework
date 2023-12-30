package COM.TEST;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pageobject.Materials;
import com.utility.BaseClass;
import com.utility.Library;

public class itemedit extends BaseClass {
	
	@Test
	public static void edititemmaster() throws Exception {
		
		Library.login();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		Materials ele=PageFactory.initElements(driver,Materials.class);
		wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
		Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
		wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
		//js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
		Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
		
		//WebElement item=driver.findElement(By.xpath("//div[contains(text(),'zTHUJ4GSX')]"));
		
//		while(item.isEnabled()) {
//			
//		if(item.isDisplayed()&&item.isEnabled()) {
//		item.click();
//		item.click();
//		break;
//		}
//		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement listNext=driver.findElement(By.xpath("//div[@class='jqx-icon-arrow-right jqx-icon-arrow-right-imms']"));
		Thread.sleep(6000);
		//div[@title='next']
		
		wait.until(ExpectedConditions.elementToBeClickable(listNext));
//		Actions act=new Actions(driver);
		
		
//WebElement mater=driver.findElement(By.xpath("//div[contains(text(),'TDAYIQO - latest item description')]"));	//div[contains(text(),'TDAYIQO - latest item description')]
//		act.moveToElement(listNext);
//		act.click();
//		act.click();

		  
		
			 wait.until(ExpectedConditions.elementToBeClickable(listNext));
        	 JavascriptExecutor jse2 = (JavascriptExecutor) driver;
     		jse2.executeScript("arguments[0].scrollIntoView()", listNext);	
		  
		  
			 

	Library.custom_click(listNext,"NEXTBUTTON");
	listNext.click();
	wait.until(ExpectedConditions.elementToBeClickable(listNext));

	Library.custom_click(listNext,"NEXTBUTTON");
	listNext.click();
	wait.until(ExpectedConditions.elementToBeClickable(listNext));
	

	Library.custom_click(listNext,"NEXTBUTTON");
	listNext.click();
	wait.until(ExpectedConditions.elementToBeClickable(listNext));

	Library.custom_click(listNext,"NEXTBUTTON");
	listNext.click();
	wait.until(ExpectedConditions.elementToBeClickable(listNext));

	Library.custom_click(listNext,"NEXTBUTTON");
	listNext.click();
	wait.until(ExpectedConditions.elementToBeClickable(listNext));
	
	}

}
