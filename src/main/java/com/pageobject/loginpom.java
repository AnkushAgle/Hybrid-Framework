package com.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginpom {
	
	
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='connStr']")
	private WebElement Connection_String;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='userName']")
	private WebElement userName;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='password']")
	private WebElement  password;
	@FindBy(how=How.XPATH,using="//button[text()='LOGIN']")
	private WebElement loginbtn;
	
	@FindBy(how=How.XPATH,using="//select[@formcontrolname='companyId']")
	private WebElement  select_company;
	
	@FindBy(how=How.XPATH,using="//select[@formcontrolname='companyLocationId']")
	private WebElement  select_Location;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	private WebElement submitbtn;

	public WebElement getConnection_String() {
		return Connection_String;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getSelect_company() {
		return select_company;
	}

	public WebElement getSelect_Location() {
		return select_Location;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
	
	
}
