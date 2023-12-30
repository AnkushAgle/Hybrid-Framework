package com.planningpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeAllocationpom{
	

	@FindBy(how=How.XPATH,using="//span[text()='Planning']")
	private WebElement PLANNINGMODULE;
	@FindBy(how=How.XPATH,using="//a[text()='DeAllocation']")
	private WebElement DeAllocation;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='group']")
	 private WebElement GroupDeAllocation;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='site']")
	 private WebElement SiteDeAllocation;
	//button[@class='btn btn-outline-secondary btn-search border-0']

	 
	 @FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
	 private WebElement NumberSearchbtn;

	 @FindBy(how=How.XPATH,using="(//div[@class='ng-input']//input[1])[4]")
	 private WebElement NumberinputField;
	 

	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='number']")
	 private WebElement NumberComboBox;
	 
	  @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[1]")
		private WebElement SJODetailsNEXTBTUUTON ;
	  
	  
		 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]")
		 private WebElement ItemserachButton;
		 
		 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
			private WebElement ItemandDetailsNEXTBTUUTON ;
		 
		 
		 
		 @FindBy(how=How.XPATH,using="//a[text()='DeAllocate Item']")
			private WebElement DeAllocateItem;
		 
		 
		 
		 @FindBy(how=How.XPATH,using="//div[@columnindex='5']")
			private WebElement DeAllocateQuantity ;

		 @FindBy(how=How.XPATH,using="//div[contains(@id,'QTY')]//input")
			private WebElement DeAllocateinput;
		 

		 @FindBy(how=How.XPATH,using="//button[text()='DeAllocate']")
			private WebElement DeAllocateButton;

		 

		 @FindBy(how=How.XPATH,using="//span[@id='arrow1']")
			private WebElement Arrow1;

		 @FindBy(how=How.XPATH,using="//span[@id='arrow2']")
			private WebElement Arrow2;
		 

		 @FindBy(how=How.XPATH,using="//span[@id='arrow3']")
			private WebElement Arrow3;

		 @FindBy(how=How.XPATH,using="//span[@id='arrow4']")
			private WebElement Arrow4;

		 
		 
		 

		public WebElement getPLANNINGMODULE() {
			return PLANNINGMODULE;
		}


		public WebElement getDeAllocation() {
			return DeAllocation;
		}


		public WebElement getAddnewbutton() {
			return Addnewbutton;
		}


		public WebElement getGroupDeAllocation() {
			return GroupDeAllocation;
		}


		public WebElement getSiteDeAllocation() {
			return SiteDeAllocation;
		}


		public WebElement getNumberSearchbtn() {
			return NumberSearchbtn;
		}


		public WebElement getNumberinputField() {
			return NumberinputField;
		}


		public WebElement getSJODetailsNEXTBTUUTON() {
			return SJODetailsNEXTBTUUTON;
		}


		public WebElement getItemserachButton() {
			return ItemserachButton;
		}


		public WebElement getItemandDetailsNEXTBTUUTON() {
			return ItemandDetailsNEXTBTUUTON;
		}


		public WebElement getDeAllocateItem() {
			return DeAllocateItem;
		}


		public WebElement getDeAllocateQuantity() {
			return DeAllocateQuantity;
		}


		public WebElement getDeAllocateinput() {
			return DeAllocateinput;
		}


		public WebElement getDeAllocateButton() {
			return DeAllocateButton;
		}


		public WebElement getNumberComboBox() {
			return NumberComboBox;
		}


		public WebElement getArrow1() {
			return Arrow1;
		}


		public WebElement getArrow2() {
			return Arrow2;
		}


		public WebElement getArrow3() {
			return Arrow3;
		}


		public WebElement getArrow4() {
			return Arrow4;
		}
		

}
