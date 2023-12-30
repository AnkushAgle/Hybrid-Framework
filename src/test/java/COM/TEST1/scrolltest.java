package COM.TEST1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pageobject.Materials;
import com.utility.BaseClass;
import com.utility.Library;

public class scrolltest extends BaseClass{
	@Test
	
	public void Test_00() throws Exception {
		Library.login();
		Reporter.log("Browser Open ");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor)driver;
			Materials ele=PageFactory.initElements(driver,Materials.class);
			wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
			js.executeScript("arguments[0].click()", ele.getMaterialsModule());
			wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
			Actions act=new Actions(driver);
			Reporter.log("Move to Element");
			WebElement newa=driver.findElement(By.xpath("//div[@class='scrol-list hide-nav']"));
			act.moveToElement(newa).build().perform();
			Thread.sleep(3000);
			  js.executeScript("window.scrollBy(0,70)");  
			 js.executeScript("window.scrollBy(0,200)");
		//	js.executeScript("arguments[0].click()", ele.getItem_mater_basic_detail_entry());
		
	}

}
