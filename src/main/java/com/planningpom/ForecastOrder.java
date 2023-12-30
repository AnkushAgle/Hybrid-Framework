package com.planningpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForecastOrder {
	
	
	@FindBy(how=How.XPATH,using="//span[text()='Planning']")
	private WebElement PLANNINGMODULE;
	@FindBy(how=How.XPATH,using="//a[text()='Forecast Order']")
	private WebElement FORECASTORDER;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	
	@FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	private WebElement FCcalendar;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='forecastGroup']")
	 private WebElement Groupforecast;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='forecastSite']")
	 private WebElement Siteforecast;
	  @FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	 private WebElement FORECASTdate;
	  @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
	private WebElement ForecastOrderDetailsNEXTBTUUTON ;
	  
	  @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2 mr-2']")
		private WebElement addnewITEMBTN;
	  
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5']")
	    private WebElement SALESITEMCODEsearchbtn1;
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='10']")
	    private WebElement oRDERqUANTITY1;
	  
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'orderQty')]//input")
	    private WebElement QUANTITYINPUT;

	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='11']")
	    private WebElement OrderDeliveryDate1;
	  
	  
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5']")
	    private WebElement SALESITEMCODEsearchbtn2;
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='10']")
	    private WebElement oRDERqUANTITY2;
	  
         @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='11']")
	    private WebElement OrderDeliveryDate2;
	  
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='5']")
	    private WebElement SALESITEMCODEsearchbtn3;
	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='10']")
	    private WebElement oRDERqUANTITY3;

	  @FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='11']")
	    private WebElement OrderDeliveryDate3;
	  @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
		private WebElement SaVeButton;
	  
	  @FindBy(how=How.XPATH,using="//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']")
		private WebElement CheckBox;
	  
	 // WebElement checkbox=  driver.findElement(By.xpath("//div[@class='jqx-widget jqx-widget-imms jqx-checkbox jqx-checkbox-imms']"));
	  @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
		private WebElement AuthorizationButton;
	//  WebElement Authorizebtn=  driver.findElement(By.xpath("//button[@class='btn btn-orange-outline ml-2']"));
	  
	  @FindBy(how=How.XPATH,using="//a[@role='button']")
		private WebElement EditButton;
	  
	  
		public WebElement getEditButton() {
			return EditButton;
		}
	  
	  
	public WebElement getPLANNINGMODULE() {
		return PLANNINGMODULE;
	}
	public WebElement getFORECASTORDER() {
		return FORECASTORDER;
	}
	public WebElement getAddnewbutton() {
		return Addnewbutton;
	}
	public WebElement getGroupforecast() {
		return Groupforecast;
	}
	public WebElement getSiteforecast() {
		return Siteforecast;
	}
	public WebElement getFORECASTdate() {
		return FORECASTdate;
	}
	public WebElement getForecastOrderDetailsNEXTBTUUTON() {
		return ForecastOrderDetailsNEXTBTUUTON;
	}
	public WebElement getAddnewITEMBTN() {
		return addnewITEMBTN;
	}
	public WebElement getSALESITEMCODEsearchbtn1() {
		return SALESITEMCODEsearchbtn1;
	}
	public WebElement getoRDERqUANTITY1() {
		return oRDERqUANTITY1;
	}
	public WebElement getQUANTITYINPUT() {
		return QUANTITYINPUT;
	}
	public WebElement getOrderDeliveryDate1() {
		return OrderDeliveryDate1;
	}
	public WebElement getSALESITEMCODEsearchbtn2() {
		return SALESITEMCODEsearchbtn2;
	}
	public WebElement getoRDERqUANTITY2() {
		return oRDERqUANTITY2;
	}
	public WebElement getOrderDeliveryDate2() {
		return OrderDeliveryDate2;
	}
	public WebElement getSALESITEMCODEsearchbtn3() {
		return SALESITEMCODEsearchbtn3;
	}
	public WebElement getoRDERqUANTITY3() {
		return oRDERqUANTITY3;
	}
	public WebElement getOrderDeliveryDate3() {
		return OrderDeliveryDate3;
	}
	public WebElement getSaVeButton() {
		return SaVeButton;
	}
	public WebElement getFCcalendar() {
		return FCcalendar;
	}
	public WebElement getCheckBox() {
		return CheckBox;
	}
	public WebElement getAuthorizationButton() {
		return AuthorizationButton;
	}
}
