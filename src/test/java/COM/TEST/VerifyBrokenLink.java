package COM.TEST;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utility.BaseClass;
import com.utility.BrokenLink;
import com.utility.Library;

public class VerifyBrokenLink extends BaseClass {
	
	//public static ExtentTest test;
	@Test
	public void VBL() throws Exception {
		Library.login();
		List<WebElement> list=driver.findElements(By.tagName("a"));
		System.out.println("The total number of link Present Are::"+list.size());
		Library.test.log(Status.PASS, "The total number of link Present Are::"+list.size());
		for(int i=0;i<list.size();i++) {
			//Thread.sleep();
			WebElement ele=list.get(i);
			String url=ele.getAttribute("href");
			BrokenLink.VerifyBrokenLink(url);
			//Thread.sleep(5);
		}
		
	}

}
