package com.storesandinventory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class grnwithoutpo {
	
	@FindBy(how=How.XPATH,using="//span[text()='Stores & Inventory']")
	private WebElement StoresInventory;
	
	
	@FindBy(how=How.XPATH,using="//a[text()='GRN WITHOUT PO']")
	private WebElement grnwithoutpo;
	

	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbtn;
	
	
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='gnrwopoGroup']")
	private WebElement gnrwopoGroup;
	
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='gnrwopoSite']")
	private WebElement gnrwopoSite;
	
	@FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	private WebElement calendor ;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
	private WebElement vendorsearchbtn ;
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='rateStructure']")
	private WebElement rateStructure ;
	
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='warehouse']")
	private WebElement warehouse ;
	//button[@class='btn btn-orange-outline ml-2']
	
	@FindBy(how=How.XPATH,using="	//button[@class='btn btn-orange-outline ml-2']")
	private WebElement grnNEXTBTN ;
	
	
	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
	private WebElement transportNEXTBTN ;		
	
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-orange-outline ml-2 mr-2']")
	private WebElement ItemAddNewbtn ;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='jqx-grid-cell jqx-grid-cell-imms jqx-item jqx-item-imms  nesteddelbtn jqx-grid-cell-selected jqx-grid-cell-selected-imms jqx-fill-state-pressed jqx-fill-state-pressed-imms']")
	private WebElement Addnewitemsearchbtn ;
	
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5']")
	private WebElement PUOM ;

	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='10']")
	private WebElement PUOMQty;
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='18']")
	private WebElement BASICPRICE;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
	private WebElement Authorizebtn;
	public WebElement getStoresInventory() {
		return StoresInventory;
	}
	public WebElement getGrnwithoutpo() {
		return grnwithoutpo;
	}
	public WebElement getAddnewbtn() {
		return Addnewbtn;
	}
	public WebElement getGnrwopoGroup() {
		return gnrwopoGroup;
	}
	public WebElement getGnrwopoSite() {
		return gnrwopoSite;
	}
	public WebElement getCalendor() {
		return calendor;
	}
	public WebElement getVendorsearchbtn() {
		return vendorsearchbtn;
	}
	public WebElement getRateStructure() {
		return rateStructure;
	}
	public WebElement getWarehouse() {
		return warehouse;
	}
	public WebElement getGrnNEXTBTN() {
		return grnNEXTBTN;
	}
	public WebElement getTransportNEXTBTN() {
		return transportNEXTBTN;
	}
	public WebElement getItemAddNewbtn() {
		return ItemAddNewbtn;
	}
	public WebElement getAddnewitemsearchbtn() {
		return Addnewitemsearchbtn;
	}
	public WebElement getPUOM() {
		return PUOM;
	}
	public WebElement getPUOMQty() {
		return PUOMQty;
	}
	public WebElement getBASICPRICE() {
		return BASICPRICE;
	}
	public WebElement getAuthorizebtn() {
		return Authorizebtn;
	}
}


