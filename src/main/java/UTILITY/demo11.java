package UTILITY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class demo11 extends BaseClass {

	@Test
	public void m1() {
		String path = "C:\\Users\\HP\\Downloads\\NEW_HORIZON\\ExcelFiles\\LOGIN.xlsx";

		EXCELREADER excel = new EXCELREADER(path);

		String username = excel.getCellData("LOGIN", "value", 1);

		System.out.println(username);

		WebElement usr = driver.findElement(By.xpath(""));

		usr.sendKeys(username);

	}
}
