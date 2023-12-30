package com.Purchasepom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class POAmendmentnew {

	@FindBy(how = How.XPATH, using = "//span[text()='Purchase']")
	private WebElement Purchasemodule;

	@FindBy(how = How.XPATH, using = "//a[text()='PO Amendment New']")
	private WebElement POAmendmentNew;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement POAmendmentNewADDNEWBUTTON;
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='pobasisControl']")
	private WebElement POBasis;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='yearControl']")
	private WebElement POYEAR;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='groupControl']")
	private WebElement POGroup;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='siteControl']")
	private WebElement POSite;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='numControl']//input")
	private WebElement PONUMBER;

	@FindBy(how = How.XPATH, using = "//jqxdatetimeinput[@formcontrolname='amddateControl']//div[contains(@id,'jqxWidget')]//div[1]//div[1]")
	private WebElement AmendentDATE;

	@FindBy(how = How.XPATH, using = "(//div[@class='col-12 text-right']//button)[1]")
	private WebElement PurchaseOrderInformationNextButtonNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline mt-3'])[2]")
	private WebElement VendorInfoNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='reasonControl']")
	private WebElement Reasons;

	@FindBy(how = How.XPATH, using ="//ng-select[@formcontrolname='ratestruControl']")
	private WebElement RateStucture;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline mt-3'])[3]")
	private WebElement purchaseorderdeliverydetailsNEXTBUTTON;
	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='2']//div)[1]")
	private WebElement ItemCode1;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']//div)[1]")
	private WebElement ItemCode1Directbasedpo;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row1jqxWidget')]//div[@columnindex='4']//div)[1]")
	private WebElement ItemCode2Directbasedpo;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row2jqxWidget')]//div[@columnindex='4']//div)[1]")
	private WebElement ItemCode3Directbasedpo;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row3jqxWidget')]//div[@columnindex='4']//div)[1]")
	private WebElement ItemCode4Directbasedpo;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row1jqxWidget')]//div[@columnindex='2']//div")
	private WebElement ItemCode2;
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row2jqxWidget')]//div[@columnindex='2']//div")
	private WebElement ItemCode3;
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row3jqxWidget')]//div[@columnindex='2']//div")
	private WebElement ItemCode4;
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row4jqxWidget')]//div[@columnindex='2']//div")
	private WebElement ItemCode5;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row0jqxWidget')]//div[@columnindex='9']")
	private WebElement ItemCodeQuantityPUOM1;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row1jqxWidget')]//div[@columnindex='9']")
	private WebElement ItemCodeQuantityPUOM2;
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'qtypuom')]//input")
	private WebElement ItemCodeQuantityInputTextField;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'pilqtyiuom')]//input[1]")
	private WebElement CurrentPOQty_IUOM;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-s']")
	private WebElement SAVEBTN;

	@FindBy(how = How.XPATH, using = "//button[@id='childadd']")
	private WebElement childaddNewButton;

	@FindBy(how = How.XPATH, using = "(//a[contains(@class,'edibutton1')])[1]")
	private WebElement PoAmendentEditButton;

	
	@FindBy(how = How.XPATH, using = "(//a[contains(@class,'deletebutton1')])[1]")
	private WebElement PoAmendentDeleteButton;

	public WebElement getPoAmendentDeleteButton() {
		return PoAmendentDeleteButton;
	}
	
	
	
	
	
	
	
	public WebElement getPoAmendentEditButton() {
		return PoAmendentEditButton;
	}

	public WebElement getchildaddNewButton() {
		return childaddNewButton;
	}

	public WebElement getCurrentPOQty_IUOM() {
		return CurrentPOQty_IUOM;
	}

	public WebElement getSAVEBTN() {
		return SAVEBTN;
	}

	public WebElement getItemCodeQuantityPUOM2() {
		return ItemCodeQuantityPUOM2;
	}

	public WebElement getItemCodeQuantityInputTextField() {
		return ItemCodeQuantityInputTextField;
	}

	public WebElement getItemCodeQuantityPUOM1() {
		return ItemCodeQuantityPUOM1;
	}

	public WebElement getPurchasemodule() {
		return Purchasemodule;
	}

	public WebElement getPOAmendmentNew() {
		return POAmendmentNew;
	}

	public WebElement getPOAmendmentNewADDNEWBUTTON() {
		return POAmendmentNewADDNEWBUTTON;
	}

	public WebElement getPOBasis() {
		return POBasis;
	}

	public WebElement getPOYEAR() {
		return POYEAR;
	}

	public WebElement getPOGroup() {
		return POGroup;
	}

	public WebElement getPOSite() {
		return POSite;
	}

	public WebElement getPONUMBER() {
		return PONUMBER;
	}

	public WebElement getAmendentDATE() {
		return AmendentDATE;
	}

	public WebElement getPurchaseOrderInformationNextButtonNEXTBUTTON() {
		return PurchaseOrderInformationNextButtonNEXTBUTTON;
	}

	public WebElement getVendorInfoNEXTBUTTON() {
		return VendorInfoNEXTBUTTON;
	}

	public WebElement getItemCode1() {
		return ItemCode1;
	}

	public WebElement getItemCode2() {
		return ItemCode2;
	}

	public WebElement getItemCode3() {
		return ItemCode3;
	}

	public WebElement getItemCode4() {
		return ItemCode4;
	}

	public WebElement getItemCode5() {
		return ItemCode5;
	}

	public WebElement getReasons() {
		return Reasons;
	}

	public WebElement getRateStucture() {
		return RateStucture;
	}

	public WebElement getPurchaseorderdeliverydetailsNEXTBUTTON() {
		return purchaseorderdeliverydetailsNEXTBUTTON;
	}

	public WebElement getItemCode1Directbasedpo() {
		return ItemCode1Directbasedpo;
	}

	public WebElement getItemCode2Directbasedpo() {
		return ItemCode2Directbasedpo;
	}

	public WebElement getItemCode3Directbasedpo() {
		return ItemCode3Directbasedpo;
	}

	public WebElement getItemCode4Directbasedpo() {
		return ItemCode4Directbasedpo;
	}

	public WebElement getChildaddNewButton() {
		return childaddNewButton;
	}

}
