package TESTDEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utility.ExcelReader;
import com.utility.Library;

import UTILITY.BaseClass;

public class test1 extends BaseClass{
	
	
	
	
	@Test
	
	public void m1() {
		driver.findElement(By.xpath(""));
		
		
		
		
		
	}
	
	
	
	

	@Test
	public void m2() {
		String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\LOGIN.xlsx";
		ExcelReader Ecel = new ExcelReader(excelpath);
		String username = Ecel.getCellData("LOGIN", "value", 2);
		System.out.println(username);
		String pass = Ecel.getCellData("LOGIN", "value", 3);
		System.out.println(pass);
		
		
	
			
	}
	
	
	
	

	@Test
	
	public void m3() {
		String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\LOGIN.xlsx";
		ExcelReader Ecel = new ExcelReader(excelpath);
		String username = Ecel.getCellData("LOGIN", "value", 2);
		System.out.println(username);
		String pass = Ecel.getCellData("LOGIN", "value", 3);
		System.out.println(pass);
		
		
	
		
		
	}


	@Test
	public void m4() {
		
		
		String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\LOGIN.xlsx";
		ExcelReader Ecel = new ExcelReader(excelpath);
	
		
		String sheet="LOGIN";
		Ecel.getCellData(sheet, excelpath, 0);
		
		String username = Ecel.getCellData(sheet, "value", 2);
		System.out.println(username);
		String pass = Ecel.getCellData(sheet, "value", 3);
		System.out.println(pass);
		
		
		
		
		
		
		
		
		
		WebElement drpdown=driver.findElement(By.xpath(""));
		String value="";
		
		Library.SELECTBYBYVALUE(drpdown,value);
		
		
		
	}
	
	
	
	
	
}
