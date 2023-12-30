package purchase;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Purchasepom.ItemMasterService;
import com.storesandinventory.grnwithoutpo;
import com.utility.BaseClass;
import com.utility.ConfigDataProvider;
import com.utility.JQXGRID;
import com.utility.Library;
import com.utility.BaseClass;

public class itemmasterservicevaldn extends BaseClass {
	

@Test()

public void itemservicemastervalidation() throws Exception{
	
	String TestCaseName="Test Script to create Item master service with two vendors and validation for duplicate Entry";
	Library.login("purchase","itemmasterservicevaldn", TestCaseName);
	ConfigDataProvider config=new ConfigDataProvider("purchase","itemmasterservicevaldn");
		 
	ItemMasterService element=PageFactory.initElements( driver,ItemMasterService.class);
			
			Library.custom_click(element.getPURCHASEMODULE(),"Purchase Module");
			Library.custom_click(element.getItemMasterService(),"ItemMasterService");
			Thread.sleep(3000);
			Library.custom_click(element.getitemAddnewbutton(),"Add New Button");
		    Thread.sleep(10000);
		    Library.custom_Sendkeys(element.getItemCodetxtbox(),config.getconfigdata("serviceitemcode"),"serviceitemcode");
		    Thread.sleep(3000);
		    Library.custom_Sendkeys(element.getItemDescriptiontxtbox(),config.getconfigdata("description"),"description");
		    Thread.sleep(3000);
		    Library.Comboclick(element.getIUOMcombobox(),config.getconfigdata("IUOM"),"IUOM");
		    Thread.sleep(3000);
		   Library.Comboclick(element.getClasscombobox(), config.getconfigdata("class"),"class field");
		   Thread.sleep(3000);
		   Library.Comboclick(element.getSubClasscombobox(), config.getconfigdata("subclass")," sub class field");
		   Thread.sleep(5000);
		   WebElement flag=driver.findElement(By.xpath("//label[@for='IndentityReq']"));
		   Library.Explicitlywait(flag);
		   
		   Library.dClick(flag,"Indent REquired Flag is On ");
		  // Library.flaginfo(element.getINDENTrEQUIREDFLAG(),"Indent Required Flag is ON");
		   Thread.sleep(3000);
		   
		   
		   
		   
		   
		   Library.custom_Sendkeys(element.getDETAILDESCRIPTIONTXTBOX(),config.getconfigdata("detaildesc"),"Details Description Field");
		   Thread.sleep(3000);
		   
		   //First Vendor Addd  
		   Library.dClick(element.getAddNEWITEMBTN(),"Add New Vendor Btn");
		   Thread.sleep(3000);
		   Library.Scrolldown(0, 100);
		     JQXGRID.JQXDIRECTITEMSearch(element.getVendorcodesearchbtn1(),config.getconfigdata("vendorcode"));
		     Thread.sleep(3000);
		     JQXGRID.JQXDropdown(element.getUOM1(),config.getconfigdata("UOM"));
		     Thread.sleep(3000);
		     Library.dClick(element.getBasicprize1(),"Basic Price ");
		     Thread.sleep(3000);
		     Library.custom_Sendkeys(element.getBasicPriceinput(), config.getconfigdata("basicprice"),"basicprice");
		     Thread.sleep(3000);
		     JQXGRID.JQXDropdown(element.getDiscounttypecombobox(), config.getconfigdata("discounttype"));
		     Thread.sleep(3000);
		     JQXGRID.JQXDropdown(element.gettaxStucturecombobox(), config.getconfigdata("taxstucture"));
		     Thread.sleep(3000);
		   //  Library.Scrolldown(0, -200);
		     
		     //Second Vendor Add 
		     Library.dClick(element.getAddNEWITEMBTN(),"Add New Vendor Btn");
			   Thread.sleep(3000);
			   Library.Scrolldown(0, 100);
			   
			     JQXGRID.JQXDIRECTITEMSearch(element.getVendorcodesearchbtn2(),config.getconfigdata("vendorcode2"));
			     Thread.sleep(3000);
			     JQXGRID.JQXDropdowntemp(element.getUOM2(),config.getconfigdata("UOM2"));
			     Thread.sleep(3000);
			     Library.dClick(element.getBasicprize2(),"Basic Price ");
			     Thread.sleep(3000);
			     Library.custom_Sendkeys(element.getBasicPriceinput(), config.getconfigdata("basicprice2"),"basicprice");
			     Thread.sleep(3000);
			     JQXGRID.JQXDropdown(element.getDiscounttypecombobox2(), config.getconfigdata("discounttype2"));
			     Thread.sleep(3000);
			     
			   WebElement discount=  driver.findElement(By.xpath("//div[contains(@id,'row1jqxWidget')]//div[@columnindex='9']"));
			   Library.Explicitlywait(discount);
			   Library.dClick(discount,"Discount field");
			   Thread.sleep(3000);
			   WebElement discounttxtbox=driver.findElement(By.xpath("//div[contains(@id,'discountValue')]/input"));
			   Library.Explicitlywait(discounttxtbox);
			   Thread.sleep(3000);
			   Library.custom_Sendkeys(discounttxtbox,config.getconfigdata("discvalue2"),"Discount value Field");
			   Thread.sleep(2000);	
			 
			   Thread.sleep(3000);
			   JQXGRID.JQXDropdown(element.getTaxStucturecombobox2(), config.getconfigdata("taxstucture2"));
			     Thread.sleep(3000);
			     Library.Scrolldown(0, -200);
		      Library.ActionDoubleClick(element.getSAVEBUTTON(),"SAVE BUTTON");
		      Library.Explicitlywait(element.getSAVEBUTTON());
		      Library.ActionDoubleClick(element.getSAVEBUTTON(),"SAVE BUTTON");
	        String servicecode= config.getconfigdata("serviceitemcode");
	       
	       
	        
	        
	        String servicecod=servicecode.toUpperCase();
	         
	      
//	        
//	       
	      //  WebElement servicecoDe=driver.findElement(By.xpath("//div[contains(text(),'"+servicecod+"')]"));
//	           Library.Explicitlywait(servicecoDe);
//		      Library.ActionDoubleClick(servicecoDe, servicecod);
	        
	        
	        
//		   
				         
				    	String msg=servicecod+"=="+"Item Master - Service already exists.";
				       
	Library.validation(element.getSearchvalue(), msg,"Itemmasterservice");
	try {
	 Thread.sleep(10000);
     Library.custom_Sendkeys(element.getSearchvalue(),config.getconfigdata("serviceitemcode"),"Search Field");
     Robot robot = new Robot(); 
	 Thread.sleep(2000);	
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     Thread.sleep(2000);	
				      WebElement servicecoDe1=driver.findElement(By.xpath("//div[contains(text(),'"+servicecod+"')]"));
				           Library.Explicitlywait(servicecoDe1);
					      Library.ActionDoubleClick(servicecoDe1, servicecod);
					      
					      Thread.sleep(4000);
					      Thread.sleep(4000);
					      
					      for (int i = 0; i<3; i++) {
					        	Thread.sleep(700);
					        	Library.Scrolldown(0, 30);
					        	}
	}
	
	catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
	
	
	
}

}
