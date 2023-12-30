package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import net.bytebuddy.utility.RandomString;

public class Listener extends BaseClass implements ITestListener{
ExtentReports extent=ExtentReportGenerator.getReports();
ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		
		Library.test=extent.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
		extenttest.set(Library.test);
		
		
		try {
		String recordname=result.getTestClass().getName()+"_"+result.getMethod().getMethodName();
			ScreenRecorderUtil.startRecord(recordname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS,MarkupHelper.createLabel("Test Case PASS ", ExtentColor.GREEN));
		//extent.flush();
	
	try {
		Thread.sleep(1500);
		Library.test.addScreenCaptureFromPath(reportpath());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void onTestFailure(ITestResult result) {
		//extenttest.get().log(Status.FAIL,"<b>Test Case Fail</b>");
		extenttest.get().log(Status.FAIL,MarkupHelper.createLabel("Test Case Fail", ExtentColor.RED));
		// test.log(Status.INFO,);
		//extenttest.get().log(null, null);
		//extent.flush();
try {
	//sLibrary.test.addScreenCaptureFromBase64String(getcapture());
	Library.test.addScreenCaptureFromPath(reportpath());
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	try {
		
		 ScreenRecorderUtil.stopRecord();
		Takescrnshot.screenshot("Failure");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.get().log(Status.SKIP,"<b>Test Case SKIP</b>");
	
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
	try {
		Takescrnshot.screenshot("Finish");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	

	try {
		
		 ScreenRecorderUtil.stopRecord();
		Takescrnshot.screenshot("Failure");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	}

	 public void takeScreenShot(String methodName, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
    	 
    	 String filePath=System.getProperty("user.dir");
    	 
            try {
				FileHandler.copy(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			} }
	 
	
	 public String getcapture() {
		 
	 TakesScreenshot ts = (TakesScreenshot) driver;
	
	 return ts.getScreenshotAs(OutputType.BASE64);
	 }

public String reportpath() throws Exception {
	String rm=RandomString.make(2);
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"\\ScreenShots\\failedtest"+rm+".png";
	File destn=new File(path);
	FileHandler.copy(src, destn);
	
	
	return path;
}

}
