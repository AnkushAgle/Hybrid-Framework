package qcandassurance;

import com.utility.ExcelDataProvider;

public class emp {

	public static void main(String[] args) throws Exception {
	String a="15,000.0000";
	String a1=a.replaceAll(",", "");
	float b=Float.parseFloat(a1);
	System.out.println(b);
	
	
	
	
	
	
	
	
	ExcelDataProvider Excel = new ExcelDataProvider("purchase", "POMaintenanceNew");
	
	
	   String discounttype= Excel.getStringdata("POD004", 1, 11);
	
	System.out.println(discounttype);
	
	}

}
