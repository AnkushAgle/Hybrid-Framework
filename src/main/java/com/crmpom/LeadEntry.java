package com.crmpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeadEntry {
	@FindBy(how=How.XPATH,using="//span[text()='CRM']")
	private WebElement CRM;
	@FindBy(how=How.XPATH,using="//a[text()='Lead Entry']")
	private WebElement Leadentry;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	 @FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
	 private WebElement Customersearchbtn;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='salesmanControl']")
	 private WebElement salesmanControl;
	 @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
	 private WebElement cstmrandsalesDetailNextbtn;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='inqgrpControl']")
	 private WebElement LEADGROUP;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='inqsiteControl']")
	 private WebElement LEADsite;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='salesregControl']")
	 private WebElement salesregControl;
	 
	 @FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
	 private WebElement LEADdate;
	 
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='sourinqControl']")
	 private WebElement SourcesofLead;

	 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
	 private WebElement  LeadDetailNextbtn;
	 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[3]")
	 private WebElement  TendorinfoNextbtn;
	 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[4]")
	 private WebElement  FOLLOUPQUOTNextbtn;
	 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[5]")
	 private WebElement  aDDNEWbtn;
	 @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]/div[4]")
	 private WebElement salesitmserachbtn1;
	 
	 @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]/div[11]")
	 private WebElement QuantityField1;
	 @FindBy(how=How.XPATH,using="//div[contains(@id,'quantCL')]/input")
	 private WebElement QuantityFieldtxtbox;
	 @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]/div[4]")
	 private WebElement salesitmserachbtn2;
	 @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]/div[11]")
	 private WebElement QuantityField2;
	 
	 @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
	 private WebElement SAVEBUTTON;
	 
	 
	 @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]/div[7]/div")
	 private WebElement LeadNumber;


	public WebElement getCRM() {
		return CRM;
	}


	public WebElement getLeadentry() {
		return Leadentry;
	}


	public WebElement getAddnewbutton() {
		return Addnewbutton;
	}


	public WebElement getCustomersearchbtn() {
		return Customersearchbtn;
	}


	public WebElement getSalesmanControl() {
		return salesmanControl;
	}


	public WebElement getCstmrandsalesDetailNextbtn() {
		return cstmrandsalesDetailNextbtn;
	}


	public WebElement getLEADGROUP() {
		return LEADGROUP;
	}


	public WebElement getLEADsite() {
		return LEADsite;
	}


	public WebElement getSalesregControl() {
		return salesregControl;
	}


	public WebElement getLEADdate() {
		return LEADdate;
	}


	public WebElement getSourcesofLead() {
		return SourcesofLead;
	}


	public WebElement getLeadDetailNextbtn() {
		return LeadDetailNextbtn;
	}


	public WebElement getTendorinfoNextbtn() {
		return TendorinfoNextbtn;
	}


	public WebElement getFOLLOUPQUOTNextbtn() {
		return FOLLOUPQUOTNextbtn;
	}


	public WebElement getaDDNEWbtn() {
		return aDDNEWbtn;
	}


	public WebElement getSalesitmserachbtn1() {
		return salesitmserachbtn1;
	}


	public WebElement getQuantityField1() {
		return QuantityField1;
	}


	public WebElement getQuantityFieldtxtbox() {
		return QuantityFieldtxtbox;
	}


	public WebElement getSalesitmserachbtn2() {
		return salesitmserachbtn2;
	}


	public WebElement getQuantityField2() {
		return QuantityField2;
	}


	public WebElement getSAVEBUTTON() {
		return SAVEBUTTON;
	}


	public WebElement getLeadNumber() {
		return LeadNumber;
	}
		

	
	 
	 
	 
	 
	 
	 
	 
}


