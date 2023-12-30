package com.Purchasepom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemMasterService {
	@FindBy(how=How.XPATH,using="//span[text()='Purchase']")
	private WebElement PURCHASEMODULE;
	@FindBy(how=How.XPATH,using="//a[text()='Item Master - Service']")
	private WebElement ItemMasterService;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement itemAddnewbutton;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='ItemCode']")
	private WebElement ItemCodetxtbox;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='ItemDescription']")
	private WebElement ItemDescriptiontxtbox;
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='UOM']")
	private WebElement IUOMcombobox;
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='Class']")
	private WebElement Classcombobox;
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='SubClass']")
	private WebElement SubClasscombobox;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='IndentityReq']")
	private WebElement INDENTrEQUIREDFLAG;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='Text']")
	private WebElement DETAILDESCRIPTIONTXTBOX;
	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
    private WebElement AddNEWITEMBTN ;
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='2']")
    private WebElement vendorcodesearchbtn1;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='2']")
    private WebElement vendorcodesearchbtn2;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5']")
    private WebElement UOM1;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='5']")
    private WebElement UOM2;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='7']")
    private WebElement basicprize1;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='7']")
    private WebElement basicprize2;
	
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'basicPrice')]/input")
    private WebElement basicPriceinput ;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']")
    private WebElement discounttypecombobox ;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']")
    private WebElement discounttypecombobox2 ;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='10']")
    private WebElement taxStucturecombobox ;
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='10']")
    private WebElement taxStucturecombobox2 ;
	

	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
    private WebElement SAVEBUTTON ;
	
	

	@FindBy(how=How.XPATH,using="//input[@formcontrolname='searchValue']")
    private WebElement Searchvalue ;
	
	

	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
    private WebElement EditButton ;
	
	public WebElement getEditButton() {
		return EditButton;
		}
	
	public WebElement getSearchvalue() {
		return Searchvalue;
		}
	
	public WebElement getSAVEBUTTON() {
		return SAVEBUTTON;
		}
	public WebElement gettaxStucturecombobox() {
		return taxStucturecombobox;
		}
	
	public WebElement getPURCHASEMODULE() {
		return PURCHASEMODULE;
	}
	public WebElement getItemMasterService() {
		return ItemMasterService;
	}
	public WebElement getitemAddnewbutton() {
		return itemAddnewbutton;
	}
	public WebElement getItemCodetxtbox() {
		return ItemCodetxtbox;
	}
	public WebElement getItemDescriptiontxtbox() {
		return ItemDescriptiontxtbox;
	}
	public WebElement getIUOMcombobox() {
		return IUOMcombobox;
	}
	public WebElement getClasscombobox() {
		return Classcombobox;
	}
	public WebElement getSubClasscombobox() {
		return SubClasscombobox;
	}
	public WebElement getINDENTrEQUIREDFLAG() {
		return INDENTrEQUIREDFLAG;
	}
	public WebElement getDETAILDESCRIPTIONTXTBOX() {
		return DETAILDESCRIPTIONTXTBOX;
	}
	public WebElement getAddNEWITEMBTN() {
		return AddNEWITEMBTN;
	}
	public WebElement getVendorcodesearchbtn1() {
		return vendorcodesearchbtn1;
	}
	public WebElement getUOM1() {
		return UOM1;
	}
	public WebElement getBasicprize1() {
		return basicprize1;
	}
	public WebElement getBasicPriceinput() {
		return basicPriceinput;
	}
	public WebElement getDiscounttypecombobox() {
		return discounttypecombobox;
	}

	public WebElement getItemAddnewbutton() {
		return itemAddnewbutton;
	}

	public WebElement getVendorcodesearchbtn2() {
		return vendorcodesearchbtn2;
	}

	public WebElement getUOM2() {
		return UOM2;
	}

	public WebElement getBasicprize2() {
		return basicprize2;
	}

	public WebElement getDiscounttypecombobox2() {
		return discounttypecombobox2;
	}

	public WebElement getTaxStucturecombobox() {
		return taxStucturecombobox;
	}

	public WebElement getTaxStucturecombobox2() {
		return taxStucturecombobox2;
	}
	
	 
}
