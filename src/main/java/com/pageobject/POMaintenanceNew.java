package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utility.Library;

public class POMaintenanceNew {

	@FindBy(how=How.XPATH,using="//span[text()='Purchase']")
	private WebElement Purchasemodule;
	@FindBy(how=How.XPATH,using="//a[text()='PO Maintenance New']")
	private WebElement POMaintenanceNew;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement POaddnewbutton;
	
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'inputjqxWidget')]")
	private WebElement POdateINPUTTEXTFIELD;

	
	
	@FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	private WebElement PODATE;

			
	@FindBy(how=How.XPATH,using="//span[@class='jqx-checkbox-check-checked jqx-checkbox-check-checked-imms']")
	private WebElement Authorizecheckbox;	
			
	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[1]")
	 private WebElement POINFONEXTBTN;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
    private WebElement Vendoraddsearchbtn ;
	
	
	@FindBy(how=How.XPATH,using="//jqxinput[contains(@class,'ng-untouched')]//input")
    private WebElement VendoraddsearhTextBox ;
	
	
	
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='buyer']")
	private WebElement Buyer ;
	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]	")
	private WebElement VendorInfoNextBtn ;
	// Purchase Order Delivery Details 
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='rateStructure']")
   private WebElement RateStructure ;	
		@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[3]")
		private WebElement RateStryctureNextBtn ;
		
		
		@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[4]")
		private WebElement sjoandoffNextBtn ;
		
		
		
		
		@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
		private WebElement SAVEBTN ;
		
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row0')]/div[10]")
		private WebElement QtyPUOM ;
		
		@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
		private WebElement Authorizebtn ;
		
		
		
		@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='poBasis']")
		private WebElement POBASIS ;
		
		

		@FindBy(how=How.XPATH,using="//div[@class='col-12 d-flex justify-content-end']//button[@class='btn btn-orange-outline ml-2']")
		private WebElement Itemandindentaddnewbtn;
		
		
	
	
		
		@FindBy(how=How.XPATH,using="//button[text()='Yes']")
		private WebElement warehousecodepopupms ;
		
		
		//div[contains(@id,'row0jqxWidget')]//div[@columnindex='9']
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='9']")
		private WebElement ItemCodeQuantityPUOM1;
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='9']")
		private WebElement ItemCodeQuantityPUOM2;
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='9']")
		private WebElement ItemCodeQuantityPUOM3;
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row3jqxWidget')]//div[@columnindex='9']")
		private WebElement ItemCodeQuantityPUOM4;
		
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row4jqxWidget')]//div[@columnindex='9']")
		private WebElement ItemCodeQuantityPUOM5;
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'qtypuom')]//input")
		private WebElement ItemCodeQuantityInputTextField;
		
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='4']")
		private WebElement WareHouseCode1;
		
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='4']")
		private WebElement WareHouseCode2;

		@FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='4']")
		private WebElement WareHouseCode3;
		
		
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row3jqxWidget')]//div[@columnindex='4']")
		private WebElement WareHouseCode4;
		
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'row4jqxWidget')]//div[@columnindex='4']")
		private WebElement WareHouseCode5;
		
		//div[contains(@id,'qtypuom')]//input
		
		
		
		
		
		
		
		
		
		 public WebElement getVendoraddsearhTextBox() {
				
				
				return VendoraddsearhTextBox;
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




		public void setPurchasemodule(WebElement purchasemodule) {
			Purchasemodule = purchasemodule;
		}




		public void setPOMaintenanceNew(WebElement pOMaintenanceNew) {
			POMaintenanceNew = pOMaintenanceNew;
		}




		public void setPOaddnewbutton(WebElement pOaddnewbutton) {
			POaddnewbutton = pOaddnewbutton;
		}




		public void setPOdateINPUTTEXTFIELD(WebElement pOdateINPUTTEXTFIELD) {
			POdateINPUTTEXTFIELD = pOdateINPUTTEXTFIELD;
		}




		public void setPODATE(WebElement pODATE) {
			PODATE = pODATE;
		}




		public void setAuthorizecheckbox(WebElement authorizecheckbox) {
			Authorizecheckbox = authorizecheckbox;
		}




		public void setPOINFONEXTBTN(WebElement pOINFONEXTBTN) {
			POINFONEXTBTN = pOINFONEXTBTN;
		}




		public void setVendoraddsearchbtn(WebElement vendoraddsearchbtn) {
			Vendoraddsearchbtn = vendoraddsearchbtn;
		}




		public void setVendoraddsearhTextBox(WebElement vendoraddsearhTextBox) {
			VendoraddsearhTextBox = vendoraddsearhTextBox;
		}




		public void setBuyer(WebElement buyer) {
			Buyer = buyer;
		}




		public void setVendorInfoNextBtn(WebElement vendorInfoNextBtn) {
			VendorInfoNextBtn = vendorInfoNextBtn;
		}




		public void setRateStructure(WebElement rateStructure) {
			RateStructure = rateStructure;
		}




		public void setRateStryctureNextBtn(WebElement rateStryctureNextBtn) {
			RateStryctureNextBtn = rateStryctureNextBtn;
		}




		public void setSjoandoffNextBtn(WebElement sjoandoffNextBtn) {
			this.sjoandoffNextBtn = sjoandoffNextBtn;
		}




		public void setSAVEBTN(WebElement sAVEBTN) {
			SAVEBTN = sAVEBTN;
		}




		public void setQtyPUOM(WebElement qtyPUOM) {
			QtyPUOM = qtyPUOM;
		}




		public void setAuthorizebtn(WebElement authorizebtn) {
			Authorizebtn = authorizebtn;
		}




		public void setPOBASIS(WebElement pOBASIS) {
			POBASIS = pOBASIS;
		}




		public void setItemandindentaddnewbtn(WebElement itemandindentaddnewbtn) {
			Itemandindentaddnewbtn = itemandindentaddnewbtn;
		}




		public void setWarehousecodepopupms(WebElement warehousecodepopupms) {
			this.warehousecodepopupms = warehousecodepopupms;
		}




		public void setItemCodeQuantityPUOM1(WebElement itemCodeQuantityPUOM1) {
			ItemCodeQuantityPUOM1 = itemCodeQuantityPUOM1;
		}




		public void setItemCodeQuantityPUOM2(WebElement itemCodeQuantityPUOM2) {
			ItemCodeQuantityPUOM2 = itemCodeQuantityPUOM2;
		}




		public void setItemCodeQuantityPUOM3(WebElement itemCodeQuantityPUOM3) {
			ItemCodeQuantityPUOM3 = itemCodeQuantityPUOM3;
		}




		public void setItemCodeQuantityPUOM4(WebElement itemCodeQuantityPUOM4) {
			ItemCodeQuantityPUOM4 = itemCodeQuantityPUOM4;
		}




		public void setItemCodeQuantityPUOM5(WebElement itemCodeQuantityPUOM5) {
			ItemCodeQuantityPUOM5 = itemCodeQuantityPUOM5;
		}




		public void setItemCodeQuantityInputTextField(WebElement itemCodeQuantityInputTextField) {
			ItemCodeQuantityInputTextField = itemCodeQuantityInputTextField;
		}




		public void setWareHouseCode1(WebElement wareHouseCode1) {
			WareHouseCode1 = wareHouseCode1;
		}




		public void setWareHouseCode2(WebElement wareHouseCode2) {
			WareHouseCode2 = wareHouseCode2;
		}




		public void setWareHouseCode3(WebElement wareHouseCode3) {
			WareHouseCode3 = wareHouseCode3;
		}




		public void setWareHouseCode4(WebElement wareHouseCode4) {
			WareHouseCode4 = wareHouseCode4;
		}




		public void setWareHouseCode5(WebElement wareHouseCode5) {
			WareHouseCode5 = wareHouseCode5;
		}
		
}
