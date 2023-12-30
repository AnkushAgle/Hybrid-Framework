package Roughwork;

import com.utility.ExcelReader;
import com.utility.Library;

public class Excelpoindent {

	public static void main(String[] args) {
		

		String path = Library.ExelFilepath("purchase", "POMaintenanceNew");
  	System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String sheetNaMe="POI007";
		String Recoedingrequired =Ecel.getCellData(sheetNaMe, "RECORDING(YES/NO)", 1);
		String PODate=Ecel.getCellData(sheetNaMe, "PO Date", 1);
		String POBASIS=Ecel.getCellData(sheetNaMe, "POBASIS", 1);
		String Vendor=Ecel.getCellData(sheetNaMe, "Vendor", 1);
		String Buyer=Ecel.getCellData(sheetNaMe, "Buyer", 1);
		String RateStructure=Ecel.getCellData(sheetNaMe, "RateStructure", 1);
		String ITEMCODES=Ecel.getCellData(sheetNaMe, "ITEMCODES", 1);
		String WAREHOUSECODEs=Ecel.getCellData(sheetNaMe, "WAREHOUSECODEs", 1);
		String ITEMCODEDeliveryDates=Ecel.getCellData(sheetNaMe, "ITEMCODE Delivery Dates", 1);
		String DeliveryQty=Ecel.getCellData(sheetNaMe, "Delivery Qty", 1);
		
		
		System.out.println(ITEMCODEDeliveryDates+DeliveryQty);

		
			//	Excel.getStringdata("POI003", 1, 11);
	
	
	
	
	}

}
