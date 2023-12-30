package com.Purchasepom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Indententrypom {
	//span[text()='Purchase']
	

	@FindBy(how=How.XPATH,using="//span[text()='Purchase']")
	private WebElement Purchasemodule;

	public WebElement getFirstAddNewbtn() {
		return firstAddNewbtn;
	}

	public WebElement getSecondAddNewbtn() {
		return secondAddNewbtn;
	}

	public WebElement getDropdownUOM() {
		return dropdownUOM;
	}

	public WebElement getITEMCODESEARCHBTN() {
		return ITEMCODESEARCHBTN;
	}

	public WebElement getCALENDOR() {
		return CALENDOR;
	}

	public WebElement getVENDORCODESEARCHBTN() {
		return VENDORCODESEARCHBTN;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getQuantitytextboxfield() {
		return Quantitytextboxfield;
	}

	public WebElement getSAVEBTN() {
		return SAVEBTN;
	}

	public WebElement getAuthorizationcheckbox() {
		return Authorizationcheckbox;
	}

	public WebElement getAuthorizationBTN() {
		return AuthorizationBTN;
	}

	@FindBy(how=How.XPATH,using="//a[text()='Indent Entry']")
	private WebElement IntentEntry;
	
	//button[normalize-space()='Add New']
	

	@FindBy(how=How.XPATH,using="//button[normalize-space()='Add New']")
	private WebElement Addnewbtn;
	//ng-select[@formcontrolname='indentreqby']
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='indentreqby']")
	private WebElement IntendtReqBy;
	
	

	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline mt-3'])[1]")
	private WebElement FirstNextBtn;
	

	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline mt-3'])[2]")
	private WebElement SecondNextBtn;
	

	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[1]")
	private WebElement firstAddNewbtn;
	

	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2 mb-2']")
	private WebElement secondAddNewbtn;
	

	@FindBy(how=How.XPATH,using="//div[contains(@id,'dropdownlistArrowtemp')]")
	private WebElement dropdownUOM;
	
	@FindBy(how=How.XPATH,using="(//input[contains(@id,'jqxWidge')])[5]")
	private WebElement ITEMCODESEARCHBTN;
	

	@FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	private WebElement CALENDOR;
	

	@FindBy(how=How.XPATH,using="(//input[contains(@id,'jqxWidge')])[6]")
	private WebElement VENDORCODESEARCHBTN;
	
	

			@FindBy(how=How.XPATH,using="(//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms'])[2]")
			private WebElement Quantity;

			@FindBy(how=How.XPATH,using="//input[@class='jqx-input-content jqx-input-content-imms jqx-widget-content jqx-widget-content-imms']")
			private WebElement Quantitytextboxfield;
	
			@FindBy(how=How.XPATH,using="//input[contains(@id,'delDate')]")
			private WebElement CalendarInputFieldDelivery;
			
			
			@FindBy(how=How.XPATH,using="//div[contains(@id,'quantity')]//input")
			private WebElement QuantityInputTextFieldChild;
			
			
			
			
			@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
			private WebElement SAVEBTN;

			@FindBy(how=How.XPATH,using="//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms unauthorized jqx-grid-cell-pinned jqx-grid-cell-pinned-imms']")
			private WebElement Authorizationcheckbox;
			
			@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
			private WebElement AuthorizationBTN;
		
			
			public WebElement getCalendarInputFieldDelivery() {
				return CalendarInputFieldDelivery;
			}
		
			
			
			public WebElement getQuantityInputTextFieldChild() {
				return QuantityInputTextFieldChild;
			}
	public WebElement getdropdownUOM() {
		return dropdownUOM;
	}

	public WebElement getFirstNextBtn() {
		return FirstNextBtn;
	}

	public WebElement getSecondNextBtn() {
		return SecondNextBtn;
	}
	public WebElement getfirstAddNewbtn() {
		return firstAddNewbtn;
	}
	public WebElement getsecondAddNewbtn() {
		return secondAddNewbtn;
	}
	
	
	public WebElement getIntendtReqBy() {
		return IntendtReqBy;
	}
	
	
	
	public WebElement getPurchasemodule() {
		return Purchasemodule;
	}

	public WebElement getIntentEntry() {
		return IntentEntry;
	}

	public WebElement getAddnewbtn() {
		return Addnewbtn;
	}

	
}
