package COM.TEST;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pageobject.Materials;
import com.storesandinventory.WarehouseInventory;
import com.utility.BaseClass;
import com.utility.Library;

public class Warehouseinventory extends BaseClass{
	
	@Test
	public void warehouseinventory() throws Exception {
	Library.login();
	

	WarehouseInventory ele=PageFactory.initElements(driver,WarehouseInventory.class);
	
	ele.getWarehouseInventory();
		
	Library.Explicitlywait(ele.getStoresInventory());
	Library.custom_click(ele.getStoresInventory(), "Stores and Inventory");
	Library.Explicitlywait(ele.getWarehouseInventory());
	Library.custom_click(ele.getWarehouseInventory(),"WarehouseInventory");
	Library.Explicitlywait(ele.getEditbtn());
	Library.custom_click(ele.getEditbtn(),"Editbtn");
	Library.Explicitlywait(ele.getItemwise());
	Library.custom_click(ele.getItemwise(), "Itemwise");
	Library.Explicitlywait(ele.getItemsearchbtn());
	Library.custom_click(ele.getItemsearchbtn(), "searchbtn");
	
	Library.Explicitlywait(ele.getitemsearchNextbtn());

	WebElement item=driver.findElement(By.xpath("//div[text()='1110012B']"));
	item.click();
	String itemtext=item.getText();
	System.out.println(itemtext);
	item.click();
	
	driver.findElement(By.xpath("//button[@id='itemAdd']")).click();
	
	//button[@id='itemAdd']
	
//	
//	while(!itemtext.equals("'1110012B")) {
//		
//		
//		
//	}
	
	}

}
