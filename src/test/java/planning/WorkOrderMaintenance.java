package planning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.planningpom.DeAllocationpom;
import com.planningpom.WorkOrderMaintenancepom;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.calendar;

public class WorkOrderMaintenance extends BaseClass {
	
	@Test(enabled=false)
	
	public void WorkOrderMaintenancebasicentry() throws Exception  {

		//1)Login into application	
			String testcasename="Work Order  Maintenance basic Entry ";
			
			
			Library.login("planning","WorkOrderMaintenance",testcasename);
			ConfigDataProvider config=new ConfigDataProvider("planning","WorkOrderMaintenance");
			
			Library.filelocationConfigreport("planning","WorkOrderMaintenance");
			WorkOrderMaintenancepom element=PageFactory.initElements(driver, WorkOrderMaintenancepom.class);

		Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
		Library.custom_click(element.getWorkOrderMaintenane(),"Work Order Maintenance");//Forecast Order module click
		Thread.sleep(3000);
	    Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
		Thread.sleep(3000);
	   // Library.ComboInput(element.getWorkordersGroupcombobox(),element.getWorkordersGroupinputfield(),config.getconfigdata("WorkordersGroup"), "WorkordersGroup");
		Thread.sleep(3000);
	// Work Order Details Value Feel Up	
		Library.Comboclick(element.getWorkordersSitecombobox(),config.getconfigdata("WorkordersSite"),"Work Order Site");
		Thread.sleep(3000);
		calendar.daypicker(element.getCalendarworkDetails(),config.getconfigdata("DATE"),config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
		Thread.sleep(3000);
		Library.Comboclick(element.getWorkordersPlanner(),config.getconfigdata("planner"),"Planner");
		Thread.sleep(3000);
		Library.searchwindowpopup(element.getItemSearchbutton(),config.getconfigdata("itemcode"));
		Thread.sleep(3000);
		Library.dClick(element.getWorkOrderDueDate(), "Work Order Due DAte");
		Thread.sleep(3000);
		String WODueDate=config.getconfigdata("WODueDate");
		String datexpath="(//td[text()='"+WODueDate+"'])[2]";
		Thread.sleep(3000);
		WebElement Date=driver.findElement(By.xpath(datexpath));
		Library.dClick(Date, "Date");
		Thread.sleep(3000);
		Thread.sleep(6000);
		Library.dClick(element.getWorkOrderdetailNEXTBUTTON(),"WorkOrderdetailNEXTBUTTON");
		Thread.sleep(3000);
		
		
		//SJO Details Value Field 
		//Library.Scrolldown(0, 50);
	String pendingQuantity1=element.getPendingquantityrow1().getText();
	System.out.println("Pending Quantity of Row1=="+pendingQuantity1);
	String WorkOrderQuanty1=config.getconfigdata("WorkOrderQuanty1");
	System.out.println("Work Order Quantity1=="+WorkOrderQuanty1);
	
	Library.dClick(element.getWorkOrderQuantityfieldrow1(),"Work order Quantity");
	
	Thread.sleep(3000);
	Library.custom_Sendkeys(element.getWorkOrderQuantityINPUTTEXTBOX(),WorkOrderQuanty1,"Work order Quantity");
	Thread.sleep(3000);
	Library.dClick(element.getSJOdetailNEXTBUTTON(),"SJO detail NEXTBUTTON");
	Thread.sleep(1500);
	Library.dClick(element.getSJOdetailNEXTBUTTON(),"SJO detail NEXTBUTTON");
	Thread.sleep(3000);
	
	Library.dClick(element.getWorkOrderRoutingDetailsdetailNEXTBUTTON(),"Work Order Routing DetailsdetailNEXTBUTTON");
	
	Library.Scrolldown(0, -200);
	//save Button
	Thread.sleep(3000);
	Library.custom_click(element.getSAVEBTN(),"Save Button");
	Thread.sleep(3000);
	try {
		
		element.getSAVEBTN().click();
	}
	
	catch(Exception e) {
		System.out.println(e.getMessage());
		
	}
	//Library.custom_click(element.getSAVEBTN(),"Save Button");
	Thread.sleep(3000);
	
	
	Library.dClick(element.getAuthorizecheckbox(),"Work order Maint. Authorization checkbox");

	
	Thread.sleep(3000);
	
	Library.ActionClick(element.getAuthorizebtn(),"Authorization Button");
	
try {
	Library.custom_click(element.getAuthorizebtn(),"Authorization Button");
		element.getAuthorizebtn().click();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		
	}
	
      Thread.sleep(2000);
      
      Library.Explicitlywait(element.getWorkOrderMaintenanceNumber(), 10);
	String WorkorderNumber=element.getWorkOrderMaintenanceNumber().getText();
System.out.println(WorkorderNumber);
	
	Library.info(element.getWorkOrderMaintenanceNumber(),"WORK ORDER NUMBER");

	
	}

	
	
	
	
	
	
	
	
	
@Test
	
	public void WorkOrderMaintenancebasicentrystdtime() throws Exception  {

		//1)Login into application	
			String testcasename="Work Order Maintenance basic Entry  Standard Setting Time change";
			
			
			Library.login("planning","WorkOrderMaintenancesstime",testcasename);
			ConfigDataProvider config=new ConfigDataProvider("planning","WorkOrderMaintenancesstime");
			
			Library.filelocationConfigreport("planning","WorkOrderMaintenancesstime");
			WorkOrderMaintenancepom element=PageFactory.initElements(driver, WorkOrderMaintenancepom.class);

		Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
		Library.custom_click(element.getWorkOrderMaintenane(),"Work Order Maintenance");//Forecast Order module click
		Thread.sleep(3000);
	    Library.custom_click(element.getAddnewbutton(),"AddNewBtn");
		Thread.sleep(3000);
	   // Library.ComboInput(element.getWorkordersGroupcombobox(),element.getWorkordersGroupinputfield(),config.getconfigdata("WorkordersGroup"), "WorkordersGroup");
		Thread.sleep(3000);
	// Work Order Details Value Feel Up	
		Library.Comboclick(element.getWorkordersSitecombobox(),config.getconfigdata("WorkordersSite"),"Work Order Site");
		Thread.sleep(3000);
		calendar.daypicker(element.getCalendarworkDetails(),config.getconfigdata("DATE"),config.getconfigdata("MONTH"),config.getconfigdata("YEAR"));
		Thread.sleep(3000);
		Library.Comboclick(element.getWorkordersPlanner(),config.getconfigdata("planner"),"Planner");
		Thread.sleep(3000);
		Library.searchwindowpopup(element.getItemSearchbutton(),config.getconfigdata("itemcode"));
		Thread.sleep(3000);
		Library.dClick(element.getWorkOrderDueDate(), "Work Order Due DAte");
		Thread.sleep(3000);
		String WODueDate=config.getconfigdata("WODueDate");
		try {
		String datexpath="(//td[text()='"+WODueDate+"'])[2]";
		Thread.sleep(3000);
		WebElement Date=driver.findElement(By.xpath(datexpath));
		Library.dClick(Date, "Date");
		
		}
		
		catch(Exception E) {
			System.out.println(E);
			
		}
		Thread.sleep(3000);
		Thread.sleep(6000);
		Library.dClick(element.getWorkOrderdetailNEXTBUTTON(),"WorkOrderdetailNEXTBUTTON");
		Thread.sleep(3000);
		
		
		//SJO Details Value Field 
		//Library.Scrolldown(0, 50);
	String pendingQuantity1=element.getPendingquantityrow1().getText();
	System.out.println("Pending Quantity of Row1=="+pendingQuantity1);
	String WorkOrderQuanty1=config.getconfigdata("WorkOrderQuanty1");
	System.out.println("Work Order Quantity1=="+WorkOrderQuanty1);
	
	Library.dClick(element.getWorkOrderQuantityfieldrow1(),"Work order Quantity");
	
	Thread.sleep(3000);
	Library.custom_Sendkeys(element.getWorkOrderQuantityINPUTTEXTBOX(),WorkOrderQuanty1,"Work order Quantity");
	Thread.sleep(3000);
	Library.dClick(element.getSJOdetailNEXTBUTTON(),"SJO detail NEXTBUTTON");
	Thread.sleep(1500);
	Library.dClick(element.getSJOdetailNEXTBUTTON(),"SJO detail NEXTBUTTON");
	Thread.sleep(3000);
	
	
	//Work Order Routing Details
	
	
	//Library.custom_click(element.getADDNEWButtonWorOrderRoutingDetails(),"ADD NEW Work Order Routing Details ");
	
	
	Thread.sleep(3000);
	JQXGRID.dClick(element.getInsideOutsideOperationrow1(),"InsideOutsideOperationrow1");
	
	JQXGRID.dClick(element.getSelectInsideOperation(),"Inside");
	Thread.sleep(3000);
	JQXGRID.JQXDropdown(element.getWorkCentreCoderow1(),config.getconfigdata("workordercenter1"));
	Thread.sleep(3000);
	JQXGRID.JQXDropdown(element.getOperationCode1(),config.getconfigdata("operationcode1"));
	Thread.sleep(3000);
	Library.dClick(element.getStandardSettingTimeROW1(),"StandardSettingTimeROW1");
	Thread.sleep(3000);
	Library.dClick(element.getStandardSettingTimeinputfield(),"StandardSettingTimeROW1");
	Thread.sleep(3000);
	Library.custom_Sendkeys(element.getStandardSettingTimeinputfield(),config.getconfigdata("StandardSettingTime"),"Standard Setting Time");
	Thread.sleep(3000);
	
//	Library.horizontalscroll(15);
	
	
	
	
	Library.dClick(element.getWorkOrderRoutingDetailsdetailNEXTBUTTON(),"Work Order Routing DetailsdetailNEXTBUTTON");
	
	Library.Scrolldown(0, -200);
	//save Button
	Thread.sleep(3000);
	Library.custom_click(element.getSAVEBTN(),"Save Button");
	Thread.sleep(3000);
	try {
		
		element.getSAVEBTN().click();
	}
	
	catch(Exception e) {
		System.out.println(e.getMessage());
		
	}
	//Library.custom_click(element.getSAVEBTN(),"Save Button");
	Thread.sleep(3000);
	
	
	Library.dClick(element.getAuthorizecheckbox(),"Work order Maint. Authorization checkbox");

	
	Thread.sleep(3000);
	
	Library.ActionClick(element.getAuthorizebtn(),"Authorization Button");
	
try {
	Library.custom_click(element.getAuthorizebtn(),"Authorization Button");
		element.getAuthorizebtn().click();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		
	}
	
      Thread.sleep(2000);
      
      Library.Explicitlywait(element.getWorkOrderMaintenanceNumber(), 10);
	String WorkorderNumber=element.getWorkOrderMaintenanceNumber().getText();
System.out.println(WorkorderNumber);
	
	Library.info(element.getWorkOrderMaintenanceNumber(),"WORK ORDER NUMBER");

	
	}
	
	
	
	
	
	
	
	
	
}
