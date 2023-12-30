package com.Purchasepom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LabourRateContractAmendment {

	@FindBy(how = How.XPATH, using = "//span[text()='Purchase']")
	private WebElement Purchasemodule;

	@FindBy(how = How.XPATH, using = "//a[text()='Labour Rate Contract Amendment']")
	private WebElement LabourRateContractEntryAmendment;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement LabourRateContractEntryaddnewbutton;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='indentYear']")
	private WebElement LRCAMDYEAR;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='GroupControl']")
	private WebElement LRCAMDGroup;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='OrderSite']")
	private WebElement LRCAMDSite;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='OrderNum']//input")
	private WebElement LRCNUMBER;

	@FindBy(how = How.XPATH, using = "//jqxdatetimeinput[@formcontrolname='AmendmentDate']//div[contains(@id,'jqxWidget')]//div[1]//div[1]")
	private WebElement LRCAmendentDATE;

	@FindBy(how = How.XPATH, using = "//jqxdatetimeinput[@formcontrolname='contrvalidfrmDate']//div[contains(@id,'jqxWidget')]//div[1]//div[1]")
	private WebElement LRCAMDContractValidFromdate;
	
	

	@FindBy(how = How.XPATH, using = "(//div[@class='col-12 text-right']//button)[1]")
	private WebElement PurchaseOrderAmendentInformationNEXTBUTTON;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='reasonControl']")
	private WebElement Reasons;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline mt-3'])[2]")
	private WebElement VendorInfoNEXTBUTTON;
	
	@FindBy(how = How.XPATH, using ="//ng-select[@formcontrolname='ratestruccodeControl']")
	private WebElement RateStucture;
	
	
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline mt-3'])[3]")
	private WebElement purchaseorderdeliverydetailsNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row0jqxWidget')]//a[contains(@class,'edibutton1')]")
	private WebElement ItemCode1DeliveryActionButton1;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row1jqxWidget')]//a[contains(@class,'edibutton1')]")
	private WebElement ItemCode2DeliveryActionButton2;
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row2jqxWidget')]//a[contains(@class,'edibutton3')]")
	private WebElement ItemCode3DeliveryActionButton2;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-s']")
	private WebElement SAVEBTN;

	public WebElement getSAVEBTN() {
		return SAVEBTN;
	}
	
	
	public WebElement getPurchasemodule() {
		return Purchasemodule;
	}


	public WebElement getLabourRateContractEntryAmendment() {
		return LabourRateContractEntryAmendment;
	}


	public WebElement getLabourRateContractEntryaddnewbutton() {
		return LabourRateContractEntryaddnewbutton;
	}


	public WebElement getLRCAMDYEAR() {
		return LRCAMDYEAR;
	}


	public WebElement getLRCAMDGroup() {
		return LRCAMDGroup;
	}


	public WebElement getLRCAMDSite() {
		return LRCAMDSite;
	}


	public WebElement getLRCNUMBER() {
		return LRCNUMBER;
	}


	public WebElement getLRCAmendentDATE() {
		return LRCAmendentDATE;
	}


	public WebElement getLRCAMDContractValidFromdate() {
		return LRCAMDContractValidFromdate;
	}


	public WebElement getPurchaseOrderAmendentInformationNEXTBUTTON() {
		return PurchaseOrderAmendentInformationNEXTBUTTON;
	}


	public WebElement getReasons() {
		return Reasons;
	}


	public WebElement getVendorInfoNEXTBUTTON() {
		return VendorInfoNEXTBUTTON;
	}


	public WebElement getRateStucture() {
		return RateStucture;
	}


	public WebElement getPurchaseorderdeliverydetailsNEXTBUTTON() {
		return purchaseorderdeliverydetailsNEXTBUTTON;
	}


	public WebElement getItemCode1DeliveryActionButton1() {
		return ItemCode1DeliveryActionButton1;
	}


	public WebElement getItemCode2DeliveryActionButton2() {
		return ItemCode2DeliveryActionButton2;
	}


	public WebElement getItemCode3DeliveryActionButton2() {
		return ItemCode3DeliveryActionButton2;
	}


}
