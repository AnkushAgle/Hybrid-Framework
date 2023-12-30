package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.Status;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() throws Exception{
		String path=System.getProperty("user.dir")+"\\ConfigFiles\\LOGIN.properties";
	//Library.filelocationreport(path);
		//Library.test.log(Status.INFO, path);
		FileInputStream fis=new FileInputStream(path);
		 pro=new Properties();
		 System.out.println(path);
		pro.load(fis);
	}
	public ConfigDataProvider(String filename) throws Exception{
		
		String path=System.getProperty("user.dir")+"\\ConfigFiles\\"+filename+".properties";
		//Library.filelocationreport(path);
	//	Library.test.log(Status.INFO, path);
		FileInputStream fis=new FileInputStream(path);
		 pro=new Properties();
		 System.out.println(path);
		pro.load(fis);
	}

	
	public ConfigDataProvider(String modulename,String filename) throws Exception{
		String path=System.getProperty("user.dir")+"\\ConfigFiles\\"+modulename+"\\"+filename+".properties";
		//Library.filelocationreport(path);
		
	//	Library.test.log(Status.INFO, path);
		FileInputStream fis=new FileInputStream(path);
		 pro=new Properties();
		System.out.println(path);
		pro.load(fis);
	}
	public String getURL() {
		
		
		return pro.getProperty("URL");
	}
	
	public String getconfigdata(String key) {
		
		return pro.getProperty(key);
	}

	
	
}
