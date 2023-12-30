package com.Purchasepom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LabourRateContractentry {

	@FindBy(how = How.XPATH, using = "//span[text()='Purchase']")
	private WebElement Purchasemodule;

	@FindBy(how = How.XPATH, using = "//a[text()='Labour Rate Contract Entry']")
	private WebElement LabourRateContractEntry;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement LabourRateContractEntryaddnewbutton;

	@FindBy(how = How.XPATH, using = "//jqxdatetimeinput[@tabindex='1']//div[contains(@id,'jqxWidget')]//div[1]//div[1]")
	private WebElement OrderDATE;

	@FindBy(how = How.XPATH, using = " //jqxdatetimeinput[@formcontrolname='contrvalidfrmDate']//div[contains(@id,'jqxWidget')]//div[1]//div[1]")
	private WebElement contrvalidfrmDate;

	@FindBy(how = How.XPATH, using = "(//div[@class='col-12 text-right']//button)[1]")
	private WebElement PurchaseOrderInformationNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "(//div[@class='col-12 text-right']//button)[2]")
	private WebElement VendorInformationNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='buyercodeControl']")
	private WebElement Buyer;

	@FindBy(how = How.XPATH, using = "//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input")
	private WebElement Vendortextboxfield;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-outline-secondary btn-search border-0']")
	private WebElement Vendoraddsearchbtn;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='ratestruccodeControl']")
	private WebElement RateStructure;

	@FindBy(how = How.XPATH, using = "(//div[@class='col-12 text-right']//button)[3]")
	private WebElement PurchaseOrderDeliveryNextButtonNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[1]")
	private WebElement ItemDeliveryAdddBUTTON;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='2'])[1]")
	private WebElement ItemCode1Button;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='2'])[1]")
	private WebElement ItemCode2Button;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row2jqxWidget')]//div[@columnindex='2'])[1]")
	private WebElement ItemCode3Button;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='10'])[1]")
	private WebElement ItemCode1OPCODEDropdown;
	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='10'])[1]")
	private WebElement ItemCode2OPCODEDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row2jqxWidget')]//div[@columnindex='10'])[1]")
	private WebElement ItemCode3OPCODEDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='30'])[1]")
	private WebElement ItemCode1WareHouseCODEDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='30'])[1]")
	private WebElement ItemCode2WareHouseCODEDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row2jqxWidget')]//div[@columnindex='30'])[1]")
	private WebElement ItemCode3WareHouseCODEDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='27'])[1]")
	private WebElement ItemCode1workorderNumberDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='27'])[1]")
	private WebElement ItemCode2workorderNumberDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row2jqxWidget')]//div[@columnindex='27'])[1]")
	private WebElement ItemCode3workorderNumberDropdown;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='0'])[1]//div[1]//a[1]")
	private WebElement ItemCode1DeliveryActionButton1;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='0'])[1]//div[1]//a[1]")
	private WebElement ItemCode2DeliveryActionButton2;
	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row2jqxWidget')]//div[@columnindex='0'])[1]//div[1]//a[1]")
	private WebElement ItemCode3DeliveryActionButton2;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange-outline ml-2 mb-2']")
	private WebElement ChieldAddButtonButton;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-s']")
	private WebElement SAVEBTN;

	public WebElement getSAVEBTN() {
		return SAVEBTN;
	}

	public WebElement getChieldAddButtonButton() {
		return ChieldAddButtonButton;
	}

	public WebElement getItemCode1DeliveryActionButton1() {
		return ItemCode1DeliveryActionButton1;
	}

	public WebElement getPurchasemodule() {
		return Purchasemodule;
	}

	public WebElement getLabourRateContractEntry() {
		return LabourRateContractEntry;
	}

	public WebElement getLabourRateContractEntryaddnewbutton() {
		return LabourRateContractEntryaddnewbutton;
	}

	public WebElement getOrderDATE() {
		return OrderDATE;
	}

	public WebElement getContrvalidfrmDate() {
		return contrvalidfrmDate;
	}

	public WebElement getPurchaseOrderInformationNEXTBUTTON() {
		return PurchaseOrderInformationNEXTBUTTON;
	}

	public WebElement getVendorInformationNEXTBUTTON() {
		return VendorInformationNEXTBUTTON;
	}

	public WebElement getBuyer() {
		return Buyer;
	}

	public WebElement getVendortextboxfield() {
		return Vendortextboxfield;
	}

	public WebElement getVendoraddsearchbtn() {
		return Vendoraddsearchbtn;
	}

	public WebElement getRateStructure() {
		return RateStructure;
	}

	public WebElement getPurchaseOrderDeliveryNextButtonNEXTBUTTON() {
		return PurchaseOrderDeliveryNextButtonNEXTBUTTON;
	}

	public WebElement getItemDeliveryAdddBUTTON() {
		return ItemDeliveryAdddBUTTON;
	}

	public WebElement getItemCode1Button() {
		return ItemCode1Button;
	}

	public WebElement getItemCode2Button() {
		return ItemCode2Button;
	}

	public WebElement getItemCode3Button() {
		return ItemCode3Button;
	}

	public WebElement getItemCode1OPCODEDropdown() {
		return ItemCode1OPCODEDropdown;
	}

	public WebElement getItemCode2OPCODEDropdown() {
		return ItemCode2OPCODEDropdown;
	}

	public WebElement getItemCode3OPCODEDropdown() {
		return ItemCode3OPCODEDropdown;
	}

	public WebElement getItemCode1WareHouseCODEDropdown() {
		return ItemCode1WareHouseCODEDropdown;
	}

	public WebElement getItemCode2WareHouseCODEDropdown() {
		return ItemCode2WareHouseCODEDropdown;
	}

	public WebElement getItemCode3WareHouseCODEDropdown() {
		return ItemCode3WareHouseCODEDropdown;
	}

	public WebElement getItemCode2DeliveryActionButton2() {
		return ItemCode2DeliveryActionButton2;
	}

	public WebElement getItemCode3DeliveryActionButton2() {
		return ItemCode3DeliveryActionButton2;
	}

	public WebElement getItemCode1workorderNumberDropdown() {
		return ItemCode1workorderNumberDropdown;
	}

	public WebElement getItemCode2workorderNumberDropdown() {
		return ItemCode2workorderNumberDropdown;
	}

	public WebElement getItemCode3workorderNumberDropdown() {
		return ItemCode3workorderNumberDropdown;
	}

}
