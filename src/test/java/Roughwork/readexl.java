package Roughwork;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageobject.POMaintenanceNew;
import com.utility.ExcelDATA;
import com.utility.ExcelDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.ScreenRecorderUtil;
import com.utility.calendar;

public class readexl {

	public static void main(String[] args) throws Exception {
	ExcelDATA excel=new ExcelDATA("purchase","POMaintenanceNew");
	ExcelDataProvider Excel=new ExcelDataProvider("purchase","POMaintenanceNew");
	
	String date = Excel.getStringdata("POI002", 1, 2);  
	
	
	String PoBasiss=Excel.getStringdata("POI002", 1, 3);
    System.out.println(PoBasiss);
	String TestcaseID=Excel.getStringdata("Testcases", 4, 0);// Test Case ID 
	String testcasedesc=Excel.getStringdata("Testcases", 4, 1);// Test Case Desc
	System.out.println(TestcaseID+ testcasedesc);
	}

	
	
	
	
	

	
	
	
	
}
