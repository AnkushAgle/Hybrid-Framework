package COM.TEST;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import com.utility.ConfigDataProvider;
import com.utility.Library;
import com.utility.Takescrnshot;
import com.utility.UploadFile;

import net.bytebuddy.utility.RandomString;

public class Uploadimg extends BaseClass {

	@Test
	
	public void uploadimage() throws Exception {
		ConfigDataProvider config=new ConfigDataProvider("material","uploadimage");
		
		Library.filelocationConfigreport("material","uploadimage");
	Library.login();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	Materials ele=PageFactory.initElements(driver,Materials.class);
	JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.visibilityOf(ele.getMaterialsModule()));
		Library.custom_click(ele.getMaterialsModule(),"MAterial Module");
		wait.until(ExpectedConditions.visibilityOf(ele.getItem_mater_basic_detail_entry()));
		Library.custom_click(ele.getItem_mater_basic_detail_entry(),"Item MAster BAsic Details Entry");
	        String rm=RandomString.make(2);
			Library.custom_click(ele.getADDNEWBTN(),"Add new Button");
			
			//ele.getItemcode().sendKeys(config.getconfigdata("Itemcode")+rm);
			Library.custom_Sendkeys(ele.getItemcode(), config.getconfigdata("Itemcode")+rm, " Class");
		Library.custom_Sendkeys(ele.getItemDescription(),config.getconfigdata("ItemDesc"),"ItemDesc");
		Library.custom_Sendkeys( ele.getItemDetailDescription(), config.getconfigdata("ItemDetailDesc"), "ItemDetailDesc");
		 Library.custom_Sendkeys( ele.getItemaddDetailDesc(), config.getconfigdata("ItemaddDetailDesc"),"ItemaddDetailDesc" );
		
		    Thread.sleep(5000);
			 
		    js.executeScript("window.scrollBy(0,40)");
		    Library.Comboclick(ele.getItemclass(),config.getconfigdata("selectclass"),"Class");
		    Thread.sleep(5000);
		    Library.Comboclick(ele.getSubclass(),config.getconfigdata("selectsubclass"),"Subclass");
		  
		    Thread.sleep(5000);
			   Library.Comboclick(ele.getMaterial_Of_Construction(),config.getconfigdata("MOC"),"MOC");
			 Thread.sleep(5000);
			   Library.Comboclick(ele.getItemtype(),config.getconfigdata("Itemtype"),"ItemType");
			   js.executeScript("window.scrollBy(0,200)");
			  Library.Comboclick(ele.getUnitOfMeasurement(), config.getconfigdata("UOM"),"UOM");
			  Thread.sleep(2000);	 
			 
			wait.until(ExpectedConditions.visibilityOf(ele.getUploadImg()));
	
			String imgpath="D:\\Users\\Ankush\\eclipse-workspace\\NEW_HORIZON\\ExcelFiles\\NH.xlsx";
			Actions act=new Actions(driver);
		WebElement upload=	driver.findElement(By.xpath("//a[text()='Change']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(upload));
		
		//act.moveToElement(upload).doubleClick().build().perform();
//		js.executeScript("arguments[0].value='"+imgpath+"';",upload);
////		 js.executeScript("arguments[0].click();",upload);
//		 js.executeScript("arguments[0].click();",upload);
//		 js.executeScript("arguments[0].click();",upload);
//		  //act.moveToElement(upload).click().perform();
		js.executeScript("arguments[0].click();",ele.getDrawingfile());
		//ele.getDrawingfile().click();
		Thread.sleep(5000);
		ele.getFileupload().click();
		 js.executeScript("window.scrollBy(0,200)");	
		 
		 
		 UploadFile.roboupload("NH");
			
//		 
//		 Robot rb=new Robot();
//			rb.delay(2000);
//			
//			
//			StringSelection ss=new StringSelection(imgpath);
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			rb.keyPress(KeyEvent.VK_CONTROL);
//			rb.keyPress(KeyEvent.VK_V);
//			rb.keyRelease(KeyEvent.VK_CONTROL);
//			rb.keyRelease(KeyEvent.VK_V);
//			rb.keyPress(KeyEvent.VK_ENTER);
//			rb.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(5000);
			WebElement Filetype=driver.findElement(By.xpath("//ng-select[@bindlabel='codeFullName']"));
			Library.Comboclick(Filetype,"XLSX", "Filetype");
			
			Thread.sleep(5000);
			 js.executeScript("window.scrollBy(0,-500)");
			 Library.custom_click(ele.getSavebutton(), "Save Button");
			   // js.executeScript("arguments[0].click()",ele.getSavebutton());
				  
			    wait.until(ExpectedConditions.visibilityOf(ele.getADDNEWBTN()));
			   Thread.sleep(5000);
			    Takescrnshot.screenshot(config.getconfigdata("Itemcode")+rm);
			    
		}
}

