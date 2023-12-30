package COM.TEST1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.ExcelDataProvider;
import com.utility.ExcelReader;
import com.utility.Library;
import com.utility.WriteIntoExcel;

public class DProvider {

	public static void main(String[] args) throws Exception {

		WriteIntoExcel writeexcel = new WriteIntoExcel();

		String path = Library.ExelFilepath("purchase", "IndentEntry");
		System.out.println(path);
	ExcelReader Ecel = new ExcelReader(path);
	

	String IndentReqBy=Ecel.getCellData("INDENT001","IndentReqBy", 1);
	String ITEMCODE=Ecel.getCellData("INDENT001", "ITEMCODE", 1);
		System.out.println(IndentReqBy);
	System.out.println(ITEMCODE);
	
	
	
	
	
	int lastrow=Ecel.getRowCount("INDENT003");
	System.out.print("");
	System.out.println("The Last Number Of rows is "+lastrow);
	
	

	for (int i = 0; i <= lastrow; i++) {

		String item1 = Ecel.getCellData("INDENT003", "ITEMCODE", 1);
		int j = i + 1;

		System.out.println(Ecel.getCellData("INDENT003", "ITEMCODE", j));
		
		if ((Ecel.getCellData("INDENT003", "ITEMCODE", j).equals(item1) )) {

	System.out.println("Itrem code 1 "+item1);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	String a=Ecel.getCellData("INDENT001", "indentDate", 1);
//        String b=a.replaceAll("/", "");
//        String Day=b.substring(0, 2);
//        String Month=b.substring(2, 4);  		
//       System.out.println(Month.length());
//        String Year=b.substring(4, 8);  
//        System.out.println(Year); 
//      String mnth=Library.MONTH(Month);
//      System.out.println(mnth);
//      
//
//		if(Day.startsWith("0")) {
//			String day=Day.substring(1, 2);
//			System.out.println(day);
//		}
//		
//        
////        
////        String s ="123456789abcdefgh";  System.out.println(s);
////        String sub = s.substring(0, 10); System.out.println(sub);
////        String remainder = s.substring(10);  System.out.println(remainder);
//      //  System.out.println(day);
//	
	}
}
