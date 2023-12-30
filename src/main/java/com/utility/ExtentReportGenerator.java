package com.utility;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	static ExtentReports extent;
	public static ExtentReports getReports() {
		Date d=new Date();
		
		String date1=d.toString();
		System.out.println(date1);
		String date2=date1.replaceAll(":","_");
		String date=date2.replaceAll(" ","_");
		String Reportpath=System.getProperty("user.dir")+"\\Reports\\"+"index"+date+".html";
		File file=new File(Reportpath);
		System.out.println(Reportpath);
		ExtentSparkReporter reportes=new ExtentSparkReporter(file);
	     reportes.config().setDocumentTitle("NEW HORIZON");
	     reportes.config().setReportName("NEW HORIZON");
	     //reportes.config().setReportName("ANKUSH AGLE");
	     reportes.config().setTheme(Theme.DARK);
	     
	     extent=new  ExtentReports();
	     
	     extent.attachReporter(reportes);
	     extent.setSystemInfo("Project Name", "NH(New Horizon)");
	     extent.setSystemInfo("Created By","Ankush Agle");
	     extent.setSystemInfo("Module Name", "Materials Module");
	     extent.setSystemInfo("O.S", "Windows");
	     extent.setSystemInfo("QA Name","Ankush Agle");
		
		
		return extent;
	}

}
