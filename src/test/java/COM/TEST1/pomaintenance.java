package COM.TEST1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.utility.ExcelDataProvider;
import com.utility.Library;

public class pomaintenance {

	public static void main(String[] args) throws Exception {
		ExcelDataProvider Excel=new ExcelDataProvider("purchase","POMaintenanceNew");
		String TestcaseID=Excel.getStringdata("Testcases", 4, 0);// Test Case ID 
		String testcasedesc=Excel.getStringdata("Testcases", 4, 1);// Test Case Desc
		System.out.println(TestcaseID+ testcasedesc);
		
		 String PoBasiss=	Excel.getStringdata("POI001", 1, 5);
		
		System.out.println(PoBasiss);
	  
		
	  	System.out.println(Excel.getStringdata("POI001", 1, 11));
	  	
	  
	  	String QtyPUOM1=Excel.getStringdata("POI001", 1, 12);
     	System.out.println(QtyPUOM1);
	  
	  	
	  	//String s=Integer.toString(i);  
	  	
//	  	
//	  	for(int i=1;i<=3;i++) {
//	  		
//	  		String date=Excel.getStringdata("POD001", i, 11);
//			
//			String date1=date.replaceAll("/","");
//			System.out.println(date1);
//	  		System.out.println(Excel.getStringdata("POD001", i, 11));
//	  		
//	  		String data=Excel.getStringdata("POD001", i, 11);
//	  
//	  	
//	  		String.valueOf(i);  
//	  		System.out.println(String.valueOf(i));
//	  	}
//	  	
//;

	}

}
