package com.planningpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AutoAllocationpom {
	
	@FindBy(how=How.XPATH,using="//span[text()='Planning']")
	private WebElement PLANNINGMODULE;
	@FindBy(how=How.XPATH,using="//a[text()='Auto Allocation']")
	private WebElement AutoAllocation;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='group']")
	 private WebElement GroupAllocation;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='site']")
	 private WebElement SiteAllocation;

	 @FindBy(how=How.XPATH,using="(//div[@class='ng-input']//input[1])[4]")
	 private WebElement NumberinputField;
	 

	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='forecastNumber']")
	 private WebElement NumberComboBox;
	 
	  @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[1]")
		private WebElement SJODetailsNEXTBTUUTON ;
	  
    @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
	private WebElement OtherDetailsNEXTBTUUTON ;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='0']")
   	private WebElement WareHouseCodecheckbox1;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='2']/div[1]")
   	private WebElement WareHousename1;
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='2']/div[1]")
   	private WebElement WareHousename2;
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='2']/div[1]")
   	private WebElement WareHousename3;
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row3jqxWidget')]//div[@columnindex='2']/div[1]")
   	private WebElement WareHousename4;
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row4jqxWidget')]//div[@columnindex='2']/div[1]")
   	private WebElement WareHousename5;
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='0']")
   	private WebElement WareHouseCodecheckbox2;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='0']")
   	private WebElement WareHouseCodecheckbox3;
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row3jqxWidget')]//div[@columnindex='0']")
   	private WebElement WareHouseCodecheckbox4;
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row4jqxWidget')]//div[@columnindex='0']")
   	private WebElement WareHouseCodecheckbox5;
    
    
  //div[contains(@id,'columntablejqxWidget')]/div[1]
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'columntablejqxWidget')]/div[1]")
   	private WebElement AllWareHouseCodeselectcheckbox;
     
    @FindBy(how=How.XPATH,using="//label[@for='wanttoconsidersafetyID']")
  	private WebElement wanttoconsidersafetyFLAG;
    
    @FindBy(how=How.XPATH,using="//label[@for='wanttoconsiderminimuID']")
  	private WebElement wanttoconsiderminimuFLAG;
    
    @FindBy(how=How.XPATH,using="//label[@for='allocatechilditemsofID']")
  	private WebElement allocatechilditemsofFLAG;
    
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
  	private WebElement SaVeButton;

	public WebElement getPLANNINGMODULE() {
		return PLANNINGMODULE;
	}

	public WebElement getAutoAllocation() {
		return AutoAllocation;
	}

	public WebElement getAddnewbutton() {
		return Addnewbutton;
	}

	public WebElement getGroupAllocation() {
		return GroupAllocation;
	}

	public WebElement getSiteAllocation() {
		return SiteAllocation;
	}

	public WebElement getNumberinputField() {
		return NumberinputField;
	}

	public WebElement getNumberComboBox() {
		return NumberComboBox;
	}

	public WebElement getSJODetailsNEXTBTUUTON() {
		return SJODetailsNEXTBTUUTON;
	}

	public WebElement getOtherDetailsNEXTBTUUTON() {
		return OtherDetailsNEXTBTUUTON;
	}

	public WebElement getWareHouseCodecheckbox1() {
		return WareHouseCodecheckbox1;
	}

	public WebElement getWareHouseCodecheckbox2() {
		return WareHouseCodecheckbox2;
	}

	public WebElement getWareHouseCodecheckbox3() {
		return WareHouseCodecheckbox3;
	}

	public WebElement getWareHouseCodecheckbox4() {
		return WareHouseCodecheckbox4;
	}

	public WebElement getWareHouseCodecheckbox5() {
		return WareHouseCodecheckbox5;
	}

	public WebElement getAllWareHouseCodeselectcheckbox() {
		return AllWareHouseCodeselectcheckbox;
	}

	public WebElement getWanttoconsidersafetyFLAG() {
		return wanttoconsidersafetyFLAG;
	}

	public WebElement getWanttoconsiderminimuFLAG() {
		return wanttoconsiderminimuFLAG;
	}

	public WebElement getAllocatechilditemsofFLAG() {
		return allocatechilditemsofFLAG;
	}

	public WebElement getSaVeButton() {
		return SaVeButton;
	}

	public WebElement getWareHousename1() {
		return WareHousename1;
	}

	public WebElement getWareHousename2() {
		return WareHousename2;
	}

	public WebElement getWareHousename3() {
		return WareHousename3;
	}

	public WebElement getWareHousename4() {
		return WareHousename4;
	}

	public WebElement getWareHousename5() {
		return WareHousename5;
	}
  	  
  	  
    
		//div[contains(@id,'row0jqxWidget')]//div[@columnindex='0']

}
