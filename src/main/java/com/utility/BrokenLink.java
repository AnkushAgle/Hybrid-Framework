package com.utility;

import java.net.HttpURLConnection;
import java.net.URL;

import com.aventstack.extentreports.Status;

public class BrokenLink extends Library {
	
	public static void VerifyBrokenLink(String linkurl) throws Exception{
		
		
		
		try {
			URL url=new URL(linkurl);
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			
			if(httpURLConnect.getResponseCode()==200) {
				test.log(Status.PASS,"Link is Active== "+linkurl+"=="+httpURLConnect.getResponseMessage());
				System.out.println(linkurl+"_"+httpURLConnect.getResponseMessage());
			}
			else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				
				System.out.println(linkurl+"_"+httpURLConnect.getResponseMessage());	
				test.log(Status.PASS,"Link is Broken== "+linkurl+"=="+httpURLConnect.getResponseMessage());
			}
		}
		
	catch(Exception e)	{
		
		System.out.println(e.getMessage());
		test.log(Status.FAIL, e.getMessage());
	}
		
		
	}

}
