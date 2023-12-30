package com.planningpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WorkOrderMaintenancepom {
	//Work Order Detail POM Elements 
	@FindBy(how=How.XPATH,using="//span[text()='Planning']")
	private WebElement PLANNINGMODULE;
	@FindBy(how=How.XPATH,using="//a[text()='Work Order Maintenance']")
	private WebElement WorkOrderMaintenane;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-v']")
	private WebElement Addnewbutton;
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='workordersGroup']")
	private WebElement workordersGroupcombobox;
	@FindBy(how=How.XPATH,using="//input[@role='combobox']")
	private WebElement workordersGroupinputfield;
	@FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='workordersSite']")
	private WebElement workordersSitecombobox;
    @FindBy(how=How.XPATH,using="//ng-select[@formcontrolname='workordersPlanner']")
	private WebElement workordersPlanner;
    
    
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
	private WebElement ItemSearchbutton;
    
    @FindBy(how=How.XPATH,using="//div[@class='jqx-position-absolute jqx-action-button jqx-action-button-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-r jqx-rc-r-imms jqx-default jqx-default-imms']")
   	private WebElement calendarworkDetails;
  //jqxdatetimeinput[@formcontrolname='workordersWoduedate']/div[1]/div[1]/div[1]
    
    @FindBy(how=How.XPATH,using="//jqxdatetimeinput[@formcontrolname='workordersWoduedate']/div[1]/div[1]/div[1]")
   	private WebElement WorkOrderDueDate;
    
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
   	private WebElement WorkOrderdetailNEXTBUTTON;
    
    
    //SJO Detail 
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='8']/div[1]")
   	private WebElement pendingquantityrow1;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row1jqxWidget')]//div[@columnindex='8']/div[1]")
   	private WebElement pendingquantityrow2;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row2jqxWidget')]//div[@columnindex='8']/div[1]")
   	private WebElement pendingquantityrow3;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row3jqxWidget')]//div[@columnindex='8']/div[1]")
   	private WebElement pendingquantityrow4;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row4jqxWidget')]//div[@columnindex='8']/div[1]")
   	private WebElement pendingquantityrow5;
    
    
    @FindBy(how=How.XPATH,using=" //div[contains(@id,'row0jqxWidget')]//div[@columnindex='9']")
   	private WebElement workOrderQuantityfieldrow1;
    
    
    @FindBy(how=How.XPATH,using=" //div[contains(@id,'row1jqxWidget')]//div[@columnindex='9']")
   	private WebElement workOrderQuantityfieldrow2;
    
    
    @FindBy(how=How.XPATH,using=" //div[contains(@id,'row2jqxWidget')]//div[@columnindex='9']")
   	private WebElement workOrderQuantityfieldrow3;
    
    
    @FindBy(how=How.XPATH,using=" //div[contains(@id,'row3jqxWidget')]//div[@columnindex='9']")
   	private WebElement workOrderQuantityfieldrow4;
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'row4jqxWidget')]//div[@columnindex='9']")
   	private WebElement workOrderQuantityfieldrow5;
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'workorderquantity')]/input[1]")
   	private WebElement workOrderQuantityINPUTTEXTBOX;
 

    @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[2]")
   	private WebElement SJOdetailNEXTBUTTON;

    //Work Order Routing Details 
    
    @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[3]")
   	private WebElement WorkOrderRoutingDetailsdetailNEXTBUTTON;
    
    
    //Item Required for the Work Order Item 
 
    @FindBy(how=How.XPATH,using=" //a[@class='btn btn-orange-outline ml-2 mr-2']")
   	private WebElement ADDNEWButtonWorOrderRoutingDetails;
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='2']")
   	private WebElement InsideOutsideOperationrow1;
    
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row1jqxWidget')])[2]//div[@columnindex='2']")
   	private WebElement InsideOutsideOperationrow2;
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row2jqxWidget')])[2]//div[@columnindex='2']")
   	private WebElement InsideOutsideOperationrow3;
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'wpioflag')]//span[text()='Outside']")
   	private WebElement SelectOutsideOperation;
    
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'wpioflag')]//span[text()='Inside']")
   	private WebElement SelectInsideOperation;
    
    
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='4']")
   	private WebElement WorkCentreCoderow1;
    
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row1jqxWidget')])[2]//div[@columnindex='4']")
   	private WebElement WorkCentreCoderow2;
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row2jqxWidget')])[2]//div[@columnindex='4']")
   	private WebElement WorkCentreCoderow3;
    
   // (//div[contains(@id,'row2jqxWidget')])[2]//div[@columnindex='11']
    
      @FindBy(how=How.XPATH,using="(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='11']")
   	private WebElement StandardSettingTimeROW1;
      
      
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row1jqxWidget')])[2]//div[@columnindex='11']")
   	private WebElement StandardSettingTimeROW2;
    
    @FindBy(how=How.XPATH,using="(//div[contains(@id,'row2jqxWidget')])[2]//div[@columnindex='11']")
   	private WebElement StandardSettingTimeROW3;
      
    
    @FindBy(how=How.XPATH,using="//div[contains(@id,'wpssettm')]//input[1]")
   	private WebElement StandardSettingTimeinputfield;
    
    
  
      
      
      
      
    
    @FindBy(how=How.XPATH,using="(//button[@class='btn btn-orange-outline ml-2'])[4]")
   	private WebElement ItemRequiredfortheWorkOrderItemNEXTBUTTON;

    
    
    
    @FindBy(how=How.XPATH,using="//button[@class='btn btn-orange ml-2 key key-s']")
	private WebElement SAVEBTN ;
    
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@class='jqx-checkbox-default jqx-checkbox-default-imms jqx-fill-state-normal jqx-fill-state-normal-imms jqx-rc-all jqx-rc-all-imms']")
private WebElement Authorizecheckbox;
	

	@FindBy(how=How.XPATH,using="//button[@class='btn btn-orange-outline ml-2']")
	private WebElement Authorizebtn ;
  
	@FindBy(how=How.XPATH,using="//div[contains(@id,'row0jqxWidget')]//div[@columnindex='5']//div[1]")
	private WebElement WorkOrderMaintenanceNumber;
	
	@FindBy(how=How.XPATH,using="(//div[contains(@id,'row0jqxWidget')])[2]//div[@columnindex='8']")
	private WebElement OperationCode1;
	@FindBy(how=How.XPATH,using="(//div[contains(@id,'row1jqxWidget')])[2]//div[@columnindex='8']")
	private WebElement OperationCode2;
	
	@FindBy(how=How.XPATH,using="(//div[contains(@id,'row2jqxWidget')])[2]//div[@columnindex='8']")
	private WebElement OperationCode3;
	
	
	 public WebElement getWorkOrderMaintenanceNumber() {
			return WorkOrderMaintenanceNumber;
		}
	
	
    public WebElement getSAVEBTN() {
		return SAVEBTN;
	}
	public WebElement getPLANNINGMODULE() {
		return PLANNINGMODULE;
	}

	public WebElement getWorkOrderMaintenane() {
		return WorkOrderMaintenane;
	}

	public WebElement getAddnewbutton() {
		return Addnewbutton;
	}

	public WebElement getWorkordersGroupcombobox() {
		return workordersGroupcombobox;
	}

	public WebElement getWorkordersGroupinputfield() {
		return workordersGroupinputfield;
	}

	public WebElement getWorkordersSitecombobox() {
		return workordersSitecombobox;
	}

	public WebElement getWorkordersPlanner() {
		return workordersPlanner;
	}

	public WebElement getItemSearchbutton() {
		return ItemSearchbutton;
	}

	public WebElement getCalendarworkDetails() {
		return calendarworkDetails;
	}

	public WebElement getWorkOrderDueDate() {
		return WorkOrderDueDate;
	}

	public WebElement getWorkOrderdetailNEXTBUTTON() {
		return WorkOrderdetailNEXTBUTTON;
	}

	public WebElement getPendingquantityrow1() {
		return pendingquantityrow1;
	}

	public WebElement getPendingquantityrow2() {
		return pendingquantityrow2;
	}

	public WebElement getPendingquantityrow3() {
		return pendingquantityrow3;
	}

	public WebElement getPendingquantityrow4() {
		return pendingquantityrow4;
	}

	public WebElement getPendingquantityrow5() {
		return pendingquantityrow5;
	}

	public WebElement getWorkOrderQuantityfieldrow1() {
		return workOrderQuantityfieldrow1;
	}

	public WebElement getWorkOrderQuantityfieldrow2() {
		return workOrderQuantityfieldrow2;
	}

	public WebElement getWorkOrderQuantityfieldrow3() {
		return workOrderQuantityfieldrow3;
	}

	public WebElement getWorkOrderQuantityfieldrow4() {
		return workOrderQuantityfieldrow4;
	}

	public WebElement getWorkOrderQuantityfieldrow5() {
		return workOrderQuantityfieldrow5;
	}

	public WebElement getWorkOrderQuantityINPUTTEXTBOX() {
		return workOrderQuantityINPUTTEXTBOX;
	}

	public WebElement getSJOdetailNEXTBUTTON() {
		return SJOdetailNEXTBUTTON;
	}

	public WebElement getWorkOrderRoutingDetailsdetailNEXTBUTTON() {
		return WorkOrderRoutingDetailsdetailNEXTBUTTON;
	}

	public WebElement getItemRequiredfortheWorkOrderItemNEXTBUTTON() {
		return ItemRequiredfortheWorkOrderItemNEXTBUTTON;
	}
	public WebElement getAuthorizecheckbox() {
		return Authorizecheckbox;
	}
	public WebElement getAuthorizebtn() {
		return Authorizebtn;
	}


	public WebElement getADDNEWButtonWorOrderRoutingDetails() {
		return ADDNEWButtonWorOrderRoutingDetails;
	}


	public WebElement getInsideOutsideOperationrow1() {
		return InsideOutsideOperationrow1;
	}


	public WebElement getInsideOutsideOperationrow2() {
		return InsideOutsideOperationrow2;
	}


	public WebElement getInsideOutsideOperationrow3() {
		return InsideOutsideOperationrow3;
	}


	public WebElement getWorkCentreCoderow1() {
		return WorkCentreCoderow1;
	}


	public WebElement getWorkCentreCoderow2() {
		return WorkCentreCoderow2;
	}


	public WebElement getWorkCentreCoderow3() {
		return WorkCentreCoderow3;
	}


	public WebElement getStandardSettingTimeROW1() {
		return StandardSettingTimeROW1;
	}


	public WebElement getStandardSettingTimeROW2() {
		return StandardSettingTimeROW2;
	}


	public WebElement getStandardSettingTimeROW3() {
		return StandardSettingTimeROW3;
	}


	public WebElement getStandardSettingTimeinputfield() {
		return StandardSettingTimeinputfield;
	}


	public WebElement getOperationCode1() {
		return OperationCode1;
	}


	public WebElement getOperationCode2() {
		return OperationCode2;
	}


	public WebElement getOperationCode3() {
		return OperationCode3;
	}


	public WebElement getSelectOutsideOperation() {
		return SelectOutsideOperation;
	}


	public WebElement getSelectInsideOperation() {
		return SelectInsideOperation;
	}

}
