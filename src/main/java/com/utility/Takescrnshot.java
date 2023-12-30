package com.utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import net.bytebuddy.utility.RandomString;

public class Takescrnshot extends Library {
public static void screenshot(String name) throws Exception {
		
		String path=System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File Destnation=new  File(path);
		FileHandler.copy(src, Destnation);
	Reporter.log("Screenshot taken Succesfully=="+path);
	
	//test.log(Status.PASS,"Screenshot taken Succesfully=="+path);
//		String path = "<img src="\"file://"" alt="\"\"/" />";
//		Reporter.log(path);
	}

public static void attachscreenshotreport(String Title) throws Exception {
	
	test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(reportpath(), Title).build());
	
	
}


public static String reportpath() throws Exception {
	String rm=RandomString.make(2);
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"\\ScreenShots\\failedtest"+rm+".png";
	File destn=new File(path);
	//FileHandler.copy(src, destn);
	
	
	return path;
}


}
