package COM.TEST1;

import java.util.Date;

import org.testng.annotations.Test;

import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;

import junit.framework.Assert;

public class propertydemo {
	
	@SuppressWarnings("deprecation")
	
	
	@Test(enabled=false)
	public void m3() {
		Date date4=new Date();
		

		String date1=date4.toString();
		System.out.println(date1);
		String date2=date1.replaceAll(":","_");
		String date=date2.replaceAll(" ","_");
		System.out.println(date);
		
		
	}
	@Test()
public void propert() throws Exception {
		ConfigDataProvider config=new ConfigDataProvider();
		ExcelDataProvider	 excel=new ExcelDataProvider();
		System.out.println(config.getconfigdata("username"));
		
		System.out.println(config.getconfigdata("password"));
		System.out.println(config.getconfigdata("selectclass"));
		System.out.println(config.getconfigdata("str"));
		System.out.println(config.getconfigdata("selectsite"));
		System.out.println(config.getconfigdata("selectcompany"));
		System.out.println(config.getconfigdata("username"));
		System.out.println(config.getconfigdata("selectclass"));
		System.out.println(config.getconfigdata("selectsubclass"));
		System.out.println(excel.getStringdata("Sheet1", 0, 0));
		Assert.assertEquals("a", "a");
	
		ConfigDataProvider config1=new ConfigDataProvider("material");
		
		System.out.println(config1.getconfigdata("Itemclass"));
		
		System.out.println(excel.getStringdata("Sheet1", 0, 0)); 
		System.out.println("---------------------------------------------------------------------------");
		
		ExcelDataProvider	 excel1=new ExcelDataProvider("NH");
		
		String a=excel1.getStringdata("Sheet1", 17, 0);
		String b=excel1.getStringdata("Sheet1", 17, 1);
		String c=excel1.getStringdata("Sheet1", 17, 2);
		String d=excel1.getStringdata("Sheet1", 17, 3);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
//		
	for(int i=0;i>=3;i++) {	
			
		//excel.getStringdata("Sheet1", 0, i);
			System.out.println(excel.getStringdata("Sheet1", 17, i));
			
	}

	
	}
	
	@Test
	public void m2() {
		
		int a=10;
		
		while((a==10)) {
			
			System.out.println("A is EQual to 10");
			a++;
		}
	}
}
