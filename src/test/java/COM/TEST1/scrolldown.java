package COM.TEST1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageobject.POMaintenanceNew;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class scrolldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scrolldown(200,-300);
		
	}

public static void Scrolldown(int Horizontalpixel,int Verticalpixel) {
	
	String str1 = Integer.toString(Horizontalpixel);
     String str2 = Integer.toString(Verticalpixel);
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	  //js.executeScript("window.scrollBy("+str1+","+str2+")");
     
     
     
     String a="window.scrollBy("+str1+","+str2+")";
     System.out.println(a);
}
}





































