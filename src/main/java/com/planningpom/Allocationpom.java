package com.planningpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Allocationpom {
	
	
	@FindBy(how=How.XPATH,using="//span[text()='Planning']")
	private WebElement PLANNINGMODULE;
	@FindBy(how=How.XPATH,using="//a[text()='Allocation/WO Creation']")
	private WebElement Allocation_WoCreation;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='group']")
	 private WebElement GroupAllocation;
	 @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='site']")
	 private WebElement SiteAllocation;
	//button[@class='btn btn-outline-secondary btn-search border-0']

	 
	 @FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
	 private WebElement NumberSearchbtn;
	 

	 @FindBy(how=How.XPATH,using="//input[contains(@id,'jqxWidget')]")
	 private WebElement NumberinputField;
	 
	  @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[1]")
		private WebElement SJODetailsNEXTBTUUTON ;
	  
	  
		 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-outline-secondary btn-search border-0'])[2]")
		 private WebElement ItemserachButton;
		 
		 @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
			private WebElement ItemandDetailsNEXTBTUUTON ;
		 
		 
		 
		 @FindBy(how=How.XPATH,using="//a[text()='Allocate Item']")
			private WebElement AllocateItem;
		 
		 
		 
		 @FindBy(how=How.XPATH,using="//div[@columnindex='5']")
			private WebElement AllocationQty ;

		 @FindBy(how=How.XPATH,using="//div[contains(@id,'QTY')]//input")
			private WebElement AllocationQtyinput;
		 

		 @FindBy(how=How.XPATH,using="//button[text()='Allocate']")
			private WebElement AllocateButton;
		
		 

			public WebElement getNumberinputField() {
				return NumberinputField;
			}
		 

			public WebElement getAllocateButton() {
				return AllocateButton;
			}
		 

			public WebElement getAllocationQtyinput() {
				return AllocationQtyinput;
			}
			
			
			public WebElement getAllocationQty() {
				return AllocationQty;
			}
		 
		 
			public WebElement getAllocateItem() {
				return AllocateItem;
			}
		 
		 
		public WebElement getPLANNINGMODULE() {
			return PLANNINGMODULE;
		}

		public WebElement getAllocation_WoCreation() {
			return Allocation_WoCreation;
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

		public WebElement getNumberSearchbtn() {
			return NumberSearchbtn;
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
	  
}
