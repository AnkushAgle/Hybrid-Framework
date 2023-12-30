package com.Purchasepom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utility.Library;

public class POMaintenanceNew {

	@FindBy(how = How.XPATH, using = "//span[text()='Purchase']")
	private WebElement Purchasemodule;
	@FindBy(how = How.XPATH, using = "//a[text()='PO Maintenance New']")
	private WebElement POMaintenanceNew;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement POaddnewbutton;

	@FindBy(how = How.XPATH, using = "//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	private WebElement PODATE;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'inputjqxWidget')]")
	private WebElement POdateINPUTTEXTFIELD;

	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'row0jqxWidget')]//div[@columnindex='2']//div)[1]")
	private WebElement ItemCode1;
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

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row2jqxWidget')]//div[@columnindex='9']")
	private WebElement ItemCodeQuantityPUOM3;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row3jqxWidget')]//div[@columnindex='9']")
	private WebElement ItemCodeQuantityPUOM4;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row4jqxWidget')]//div[@columnindex='9']")
	private WebElement ItemCodeQuantityPUOM5;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'qtypuom')]//input")
	private WebElement ItemCodeQuantityInputTextField;

	@FindBy(how = How.XPATH, using = "//span[@class='jqx-checkbox-check-checked jqx-checkbox-check-checked-imms']")
	private WebElement Authorizecheckbox;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[1]")
	private WebElement POINFONEXTBTN;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-outline-secondary btn-search border-0']")
	private WebElement Vendoraddsearchbtn;
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='buyer']")
	private WebElement Buyer;
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[2]	")
	private WebElement VendorInfoNextBtn;

	@FindBy(how = How.XPATH, using = "//jqxinput[@class='ng-untouched ng-pristine ng-valid']/input")
	private WebElement Vendortextboxfield;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[3]	")
	private WebElement PurchaseOrderDeliveryDetailsNEXTBUTTON;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[4]	")
	private WebElement SJOandOAFSelectionNEXTBUTTON;

	// Purchase Order Delivery Details
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='rateStructure']")
	private WebElement RateStructure;
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[3]")
	private WebElement RateStryctureNextBtn;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-orange-outline ml-2'])[4]")
	private WebElement sjoandoffNextBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement warehousecodepopupms;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']")
	private WebElement WareHouseCode1;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row1jqxWidget')]//div[@columnindex='4']")
	private WebElement WareHouseCode2;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row2jqxWidget')]//div[@columnindex='4']")
	private WebElement WareHouseCode3;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row3jqxWidget')]//div[@columnindex='4']")
	private WebElement WareHouseCode4;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row4jqxWidget')]//div[@columnindex='4']")
	private WebElement WareHouseCode5;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange ml-2 key key-s']")
	private WebElement SAVEBTN;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'row0')]/div[10]")
	private WebElement QtyPUOM;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange-outline ml-2']")
	private WebElement Authorizebtn;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='poBasis']")
	private WebElement POBASIS;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 d-flex justify-content-end']//button[@class='btn btn-orange-outline ml-2']")
	private WebElement Itemandindentaddnewbtn;

	public WebElement getVendortextboxfield() {

		return Vendortextboxfield;
	}

	public WebElement getItemandindentaddnewbtn() {

		return Itemandindentaddnewbtn;
	}

	public WebElement getPOBASIS() {

		return POBASIS;
	}

	public WebElement getAuthorizebtn() {

		return Authorizebtn;
	}

	public WebElement getAuthorizecheckbox() {

		return Authorizecheckbox;
	}

	public WebElement getQtyPUOM() {
		return QtyPUOM;
	}

	public WebElement getSAVEBTN() {
		return SAVEBTN;
	}

	public WebElement getwarehousecodepopupms() {
		return warehousecodepopupms;
	}

	public WebElement getPurchasemodule() {
		return Purchasemodule;
	}

	public WebElement getPOMaintenanceNew() {
		return POMaintenanceNew;
	}

	public WebElement getPOaddnewbutton() {
		return POaddnewbutton;
	}

	public WebElement getPODATE() {
		return PODATE;
	}

	public WebElement getPOINFONEXTBTN() {
		return POINFONEXTBTN;
	}

	public WebElement getVendoraddsearchbtn() {
		return Vendoraddsearchbtn;
	}

	public WebElement getBuyer() {
		return Buyer;
	}

	public WebElement getVendorInfoNextBtn() {
		return VendorInfoNextBtn;
	}

	public WebElement getRateStructure() {
		return RateStructure;
	}

	public WebElement getRateStryctureNextBtn() {
		return RateStryctureNextBtn;
	}

	public WebElement getPurchaseOrderDeliveryDetailsNEXTBUTTON() {
		return PurchaseOrderDeliveryDetailsNEXTBUTTON;
	}

	public WebElement getSJOandOAFSelectionNEXTBUTTON() {
		return SJOandOAFSelectionNEXTBUTTON;
	}

	public WebElement getSjoandoffNextBtn() {
		return sjoandoffNextBtn;
	}

	public WebElement getWarehousecodepopupms() {
		return warehousecodepopupms;
	}

	public WebElement getWareHouseCode1() {
		return WareHouseCode1;
	}

	public WebElement getWareHouseCode2() {
		return WareHouseCode2;
	}

	public WebElement getWareHouseCode3() {
		return WareHouseCode3;
	}

	public WebElement getWareHouseCode4() {
		return WareHouseCode4;
	}

	public WebElement getWareHouseCode5() {
		return WareHouseCode5;
	}

	public WebElement getItemCodeQuantityPUOM1() {
		return ItemCodeQuantityPUOM1;
	}

	public WebElement getItemCodeQuantityPUOM2() {
		return ItemCodeQuantityPUOM2;
	}

	public WebElement getItemCodeQuantityPUOM3() {
		return ItemCodeQuantityPUOM3;
	}

	public WebElement getItemCodeQuantityPUOM4() {
		return ItemCodeQuantityPUOM4;
	}

	public WebElement getItemCodeQuantityPUOM5() {
		return ItemCodeQuantityPUOM5;
	}

	public WebElement getItemCodeQuantityInputTextField() {
		return ItemCodeQuantityInputTextField;
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

	public WebElement getPOdateINPUTTEXTFIELD() {
		return POdateINPUTTEXTFIELD;
	}

}
