package com.crmpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DCgeneralentry {

	@FindBy(how=How.XPATH,using="//span[text()='CRM']")
	private WebElement CRM;
	
	
	@FindBy(how=How.XPATH,using="//a[text()='Delivery Challan Entry General']")
	private WebElement DCGeneralentry;
	
	//button[@class='btn btn-orange ml-2 key key-v']
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='dcGroup']")
	private WebElement DCGroup;
  
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='dcSite']")
	private WebElement DCsite;
	@FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	private WebElement DCcalendar;
    @FindBy(how=How.XPATH,using="//input[@formcontrolname='isReturnable']")
    private WebElement Returnableflag;
    @FindBy(how=How.XPATH,using="//input[@formcontrolname='isChargeable']")
    private WebElement isChargeableflag;
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='reasonForDC']")
    private WebElement reasonForDC;
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='dcFor']")
    private WebElement DCFOR;
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
    private WebElement Customersearchbtn;
    @FindBy(how=How.XPATH,using="//jqxinput[@class='ng-untouched ng-pristine ng-valid']//input[contains(@id,'jqxWidget')]")
    private WebElement Customersearchfield;
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='dcEmployee']")
    private WebElement Employee;
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='rateStructure']")
    private WebElement Retestucture;
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
    private WebElement EmployeeDetailNextbtn;
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline mr-2']")
    private WebElement AddNEWITEMBTN ;
    @FindBy(how=How.XPATH,using="//input[contains(@id,'itemCode')]")
    private WebElement itemcodeTextfield;
    @FindBy(how=How.XPATH,using="//div[@columnindex='2']")
    private WebElement itemcodesearchbutton;
    @FindBy(how=How.XPATH,using="//div[@columnindex='5']")
    private WebElement warehousecode;
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[9]")
    private WebElement DispatchQuantity;
    
    
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='modeofDispatch']")
    private WebElement modeofDispatch;
    
    @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
    private WebElement itemdetailsnextbutton;
    
    
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
    private WebElement SaveButton;

    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='shipmentDC']")
    private WebElement Shipment;
    
    public WebElement getShipment() {
		return Shipment;
	}

	public WebElement getCRM() {
		return CRM;
	}


	public WebElement getDCGeneralentry() {
		return DCGeneralentry;
	}


	public WebElement getAddnewbutton() {
		return Addnewbutton;
	}


	public WebElement getDCGroup() {
		return DCGroup;
	}


	public WebElement getDCsite() {
		return DCsite;
	}


	public WebElement getDCcalendar() {
		return DCcalendar;
	}


	public WebElement getReturnableflag() {
		return Returnableflag;
	}


	public WebElement getIsChargeableflag() {
		return isChargeableflag;
	}


	public WebElement getReasonForDC() {
		return reasonForDC;
	}


	public WebElement getDCFOR() {
		return DCFOR;
	}


	public WebElement getCustomersearchbtn() {
		return Customersearchbtn;
	}


	public WebElement getCustomersearchfield() {
		return Customersearchfield;
	}


	public WebElement getEmployee() {
		return Employee;
	}


	public WebElement getRetestucture() {
		return Retestucture;
	}


	public WebElement getEmployeeDetailNextbtn() {
		return EmployeeDetailNextbtn;
	}


	public WebElement getAddNEWITEMBTN() {
		return AddNEWITEMBTN;
	}


	public WebElement getItemcodeTextfield() {
		return itemcodeTextfield;
	}


	public WebElement getItemcodesearchbutton() {
		return itemcodesearchbutton;
	}


	public WebElement getWarehousecode() {
		return warehousecode;
	}


	public WebElement getDispatchQuantity() {
		return DispatchQuantity;
	}


	public WebElement getModeofDispatch() {
		return modeofDispatch;
	}


	public WebElement getItemdetailsnextbutton() {
		return itemdetailsnextbutton;
	}


	public WebElement getSaveButton() {
		return SaveButton;
	}
    
    
    
    
}
