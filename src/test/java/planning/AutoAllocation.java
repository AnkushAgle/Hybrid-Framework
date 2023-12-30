package planning;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.planningpom.Allocationpom;
import com.planningpom.AutoAllocationpom;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.Library;

public class AutoAllocation extends BaseClass{
	
	@Test
	
	public void AutoAllocationMK() throws Exception {
		
		String testcasename="test cript for AutoAllocation FOR  Mk type item";
		
		//1)Login into application	
			
		Library.login("planning","AutoAllocationMK",testcasename);
		ConfigDataProvider config=new ConfigDataProvider("planning","AutoAllocationMK");
			
		Library.filelocationConfigreport("planning","AutoAllocationMK");
		AutoAllocationpom element=PageFactory.initElements(driver, AutoAllocationpom.class);

		Library.custom_click(element.getPLANNINGMODULE(),"PlanningModule");//p
		Library.custom_click(element.getAutoAllocation(),"AutoAllocation");//Forecast Order module click
		
		Thread.sleep(8000);
		String group=config.getconfigdata("group");

		System.out.println(group);
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		Library.ComboInput(element.getNumberComboBox(), element.getNumberinputField(), config.getconfigdata("sjonumber"),"Sjo Number");
		Thread.sleep(3000);
		
		Library.dClick(element.getSJODetailsNEXTBTUUTON(),"SJO  Next Button");
		Thread.sleep(3000);
		
		Library.dClick(element.getOtherDetailsNEXTBTUUTON(),"OtherDetailsNEXTBTUUTON  Next Button");
		Thread.sleep(3000);

		
		try {
		
		//WareHoose CheckBox Selection
		String WareHousename1=element.getWareHousename1().getText();
		System.out.println(WareHousename1);
		
		if(WareHousename1.isEmpty()==false) {
			
			Library.dClick(element.getWareHouseCodecheckbox1(),WareHousename1);
			Thread.sleep(2000);
		}
		else {
			
			System.out.println("No Entries are Present");
		}
		

		String WareHousename2=element.getWareHousename2().getText();
		System.out.println(WareHousename2);
		
		if(WareHousename2.isEmpty()==false) {
			
			Library.dClick(element.getWareHouseCodecheckbox2(),WareHousename2);
			Thread.sleep(2000);
			}
else {
			
			System.out.println("No Entries are Present");
		}
		
		
		
		

		String WareHousename3=element.getWareHousename3().getText();
		System.out.println(WareHousename3);
		
		if(WareHousename3.isEmpty()==false) {
			
			Library.dClick(element.getWareHouseCodecheckbox3(),WareHousename3);
			Thread.sleep(2000);
			}
else {
			
			System.out.println("No Entries are Present");
		}
		
		
		
		
		
		String WareHousename4=element.getWareHousename4().getText();
		System.out.println(WareHousename4);
		
		if(WareHousename4.isEmpty()==false) {
			
			Library.dClick(element.getWareHouseCodecheckbox4(),WareHousename4);
			Thread.sleep(2000);
			}
else {
			
			System.out.println("No Entries are Present");
		}
		
		
		
		
		
		
		String WareHousename5=element.getWareHousename4().getText();
		System.out.println(WareHousename5);
		
		
		if(WareHousename5.isEmpty()==false) {
			
			Library.dClick(element.getWareHouseCodecheckbox4(),WareHousename5);
			Thread.sleep(2000);
			}
		
else {
			
			System.out.println("No Entries are Present");
		}
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("No Entries are Present");
		}
		
		
		
		
	
		
		Library.dClick(element.getWanttoconsidersafetyFLAG()," FLAG ON ");
		Thread.sleep(2000);
		
		Library.dClick(element.getWanttoconsiderminimuFLAG()," FLAG ON  ");
		Thread.sleep(2000);
		
		Library.dClick(element.getAllocatechilditemsofFLAG(),"FLAG ON");
		Thread.sleep(2000);
		Library.Scrolldown(0, -100);
		
	
		Library.custom_click(element.getSaVeButton(),"SAVE Button ");
		
		String msg="AutoAllocation for item successfully done!";
		Thread.sleep(2000);
		Library.massagelog(msg);
		Thread.sleep(5000);
	}

}
