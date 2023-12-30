package com.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int setmaxlimit;

	public boolean retry(ITestResult result) {
		int count=0;
		int semaxlimit=5;
		if(!(result.isSuccess())) {
			if(count<setmaxlimit) {
				
				count++;
				
				return true;
				
			}
			
		}
		return false;
	}

}
