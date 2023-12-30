package com.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Materials {
 
//	@FindBy(how=How.XPATH,using="(//a[@id='dropdownSubContracting'])[1]")
//	private WebElement MaterialsModule;//span[text()='Materials']
	
	@FindBy(how=How.XPATH,using="//span[text()='Materials']")
	private WebElement MaterialsModule;
	@FindBy(how=How.XPATH,using="//a[text()='Item Master Basic Detail - Entry']")
	private WebElement Item_mater_basic_detail_entry;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement ADDNEWBTN;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='itemCode']")
	private WebElement itemcode;
	@FindBy(how=How.XPATH,using="//textarea[@formcontrolname='ItemDesc1']")
	private WebElement ItemDescription;
	@FindBy(how=How.XPATH,using="//textarea[@formcontrolname='ItemDetailDesc1']")
	private WebElement ItemDetailDescription;
	@FindBy(how=How.XPATH,using="//textarea[@formcontrolname='ItemaddDetailDesc']")
	private WebElement ItemaddDetailDesc;
	//*[@id=\"panel-1\"]/div/div/div[1]/div/div[6]/div/ng-select/div/div/div[3]/input
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='itemClass1']")
	private WebElement Itemclass;
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='itemSubClass1']")
	private WebElement subclass;
	
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='itemMaterialOF1']")
	private WebElement Material_Of_Construction;
	@FindBy(how=How.XPATH,using="//span[text()='ALLUMINIUN']")
	private WebElement ALLUMINIUN;
	
	
	@FindBy(how=How.XPATH,using="//a[text()='Change']")
	private WebElement Changeimg;
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='type']")
	private WebElement Itemtype;
	
	@FindBy(how=How.XPATH,using="//span[text()='Manufacturing']")
	private WebElement Manufacturing;
	
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='itemUOM']")
	private WebElement UnitOfMeasurement;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
	private WebElement Savebutton;
	
	@FindBy(how=How.XPATH,using="//a[text()='Change']")
	private WebElement UploadImg;
	
	@FindBy(how=How.XPATH,using="//button[@aria-controls='panel-2']")
	private WebElement Drawingfile;
	
	@FindBy(how=How.XPATH,using="//div[@class='well my-drop-zone']")
	private WebElement Fileupload;
	

	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]/div[5]/div[1]")
	private WebElement ITEMINFO;

	@FindBy(how=How.XPATH,using="//input[@formcontrolname='searchValue']")
	private WebElement SEARCHITEMCODE;

	
	public WebElement getSEARCHITEMCODE() {
		return SEARCHITEMCODE;
	}
	
	
	public WebElement getITEMINFO() {
		return ITEMINFO;
	}
	
	
	public WebElement getDrawingfile() {
		return Drawingfile;
	}
	
	public WebElement getFileupload() {
		return Fileupload;
	}
	
	public WebElement getUploadImg() {
		return UploadImg;
	}
	
	
	public WebElement getMaterialsModule() {
		return MaterialsModule;
	}
	public WebElement getItem_mater_basic_detail_entry() {
		return Item_mater_basic_detail_entry;
	}
	public WebElement getADDNEWBTN() {
		return ADDNEWBTN;
	}
	public WebElement getItemcode() {
		return itemcode;
	}
	public WebElement getItemDescription() {
		return ItemDescription;
	}
	public WebElement getItemDetailDescription() {
		return ItemDetailDescription;
	}
	public WebElement getItemaddDetailDesc() {
		return ItemaddDetailDesc;
	}
	
	public WebElement getItemclass() {
		return Itemclass;
	}
	
	public WebElement getSubclass() {
		return subclass;
	}
	
	public WebElement getMaterial_Of_Construction() {
		return Material_Of_Construction;
	}
	public WebElement getALLUMINIUN() {
		return ALLUMINIUN;
	}
	public WebElement getItemtype() {
		return Itemtype;
	}
	public WebElement getManufacturing() {
		return Manufacturing;
	}
	public WebElement getUnitOfMeasurement() {
		return UnitOfMeasurement;
	}
	public WebElement getSavebutton() {
		return Savebutton;
	}
	
}
