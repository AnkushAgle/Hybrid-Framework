package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class calendar extends Library {

	public static void calendarinput(WebElement Element, String inputdate) throws Exception {
		Library.Explicitlywait(Element, 10);
		Element.click();

		String date1 = inputdate.replaceAll("/", "");

		System.out.println(date1);
		Thread.sleep(3000);
		Element.sendKeys(Keys.ARROW_LEFT);
		Element.sendKeys(Keys.ARROW_LEFT);
		Element.sendKeys(date1);
		Element.sendKeys(Keys.ENTER);

	}

	public static void daypicker(WebElement element, String Day, String Month, String Year) throws Exception {

		Library.Explicitlywait(element);
		Library.dClick(element, "Calendor Field");
		Thread.sleep(3000);
		WebElement MonthYear = driver.findElement(By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
		Library.Explicitlywait(MonthYear);
		String Monthyear = MonthYear.getText();
	//System.out.println(MonthYear);
		String Month1 = Monthyear.split(" ")[0];
		System.out.println(Month1);
		String Year1 = Monthyear.split(" ")[1];
		System.out.println(Year1);
		Thread.sleep(2000);
		// String Year=Integer.toString(year);
		while (!(Month1.equals(Month) && Year1.equals(Year))) {

			WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
			Library.Explicitlywait(prebtn);
			Library.dClick(prebtn, "previous");
			MonthYear = driver.findElement(
					By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
			String nemm = MonthYear.getText();
			System.out.println(MonthYear.getText());
			Month1 = nemm.split(" ")[0];
			System.out.println(Month1);
			Year1 = nemm.split(" ")[1];
			System.out.println(Year1);

		}
		int day = Integer.parseInt(Day);
		if (day > 0 && day <= 31) {
			WebElement date = driver.findElement(By.xpath("//td[text()='" + Day + "']"));
			WebElement Monthyyear = driver.findElement(
					By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
			Library.dClick(date, Monthyyear.getText() + "Date_");

			test.log(Status.PASS, "Date succesfully selecte==" + Day + Monthyyear.getText());
//	Click Sucessfully==10==Date_October 2022
		} else {
			test.fail("Wrong date");
			System.out.println("Wrong date");
		}
	}

	
	
	public static void DATEPICKER(WebElement element, String Date) throws Exception {

		String b = Date.replaceAll("/", "");
		String Mth = b.substring(2, 4);
		String Year = b.substring(4, 8);
	    String Month = Library.MONTH(Mth);
		
		String Day = b.substring(0, 2);
		
		if(Day.startsWith("0")) {
			
			String dayy=Day.substring(1, 2);
			Library.Explicitlywait(element);
			Library.dClick(element, "Calendor Field");
			Thread.sleep(3000);
			WebElement MonthYear = driver.findElement(By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
			Library.Explicitlywait(MonthYear);
			String Monthyear = MonthYear.getText();
			//System.out.println(MonthYear);
			String Month1 = Monthyear.split(" ")[0];
			System.out.println(Month1);
			String Year1 = Monthyear.split(" ")[1];
			System.out.println(Year1);
			Thread.sleep(2000);
			// String Year=Integer.toString(year);
			while (!(Month1.equals(Month) && Year1.equals(Year))) {

				WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
				Library.Explicitlywait(prebtn);
				Library.dClick(prebtn, "previous");
				MonthYear = driver.findElement(
						By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
				String nemm = MonthYear.getText();
				System.out.println(MonthYear.getText());
				Month1 = nemm.split(" ")[0];
				System.out.println(Month1);
				Year1 = nemm.split(" ")[1];
				System.out.println(Year1);

			}
			int day = Integer.parseInt(Day);
			if (day > 0 && day <= 31) {
				WebElement date = driver.findElement(By.xpath("//td[text()='" + dayy + "']"));
				WebElement Monthyyear = driver.findElement(
						By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
				Library.dClick(date, Monthyyear.getText() + "Date_");

				test.log(Status.PASS, "Date succesfully selecte==" + Day + Monthyyear.getText());
//		Click Sucessfully==10==Date_October 2022
			} else {
				test.fail("Wrong date");
				System.out.println("Wrong date");
			}
			
		}
		
		
		
		else {
			
			Library.Explicitlywait(element);
			Library.dClick(element, "Calendor Field");
			Thread.sleep(3000);
			WebElement MonthYear = driver.findElement(By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
			Library.Explicitlywait(MonthYear);
			String Monthyear = MonthYear.getText();
			//System.out.println(MonthYear);
			String Month1 = Monthyear.split(" ")[0];
			System.out.println(Month1);
			String Year1 = Monthyear.split(" ")[1];
			System.out.println(Year1);
			Thread.sleep(2000);
			// String Year=Integer.toString(year);
			while (!(Month1.equals(Month) && Year1.equals(Year))) {

				WebElement prebtn = driver.findElement(By.xpath("//td[contains(@id,'leftNavigationArrowViewinne')]/div"));
				Library.Explicitlywait(prebtn);
				Library.dClick(prebtn, "previous");
				MonthYear = driver.findElement(
						By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
				String nemm = MonthYear.getText();
				System.out.println(MonthYear.getText());
				Month1 = nemm.split(" ")[0];
				System.out.println(Month1);
				Year1 = nemm.split(" ")[1];
				System.out.println(Year1);

			}
			int day = Integer.parseInt(Day);
			if (day > 0 && day <= 31) {
				WebElement date = driver.findElement(By.xpath("//td[text()='" + Day + "']"));
				WebElement Monthyyear = driver.findElement(
						By.xpath("//div[contains(@class,'jqx-calendar-title-content jqx-calendar-title-content-imms')]"));
				Library.dClick(date, Monthyyear.getText() + "Date_");

				test.log(Status.PASS, "Date succesfully selecte==" + Day + Monthyyear.getText());
//		Click Sucessfully==10==Date_October 2022
			} else {
				test.fail("Wrong date");
				System.out.println("Wrong date");
			}
			
			
		}
	

	}

}
