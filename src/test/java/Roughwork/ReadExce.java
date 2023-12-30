package Roughwork;

import com.utility.ExcelReader;
import com.utility.Library;

public class ReadExce {
	public static void main(String[] args) {
		String path = Library.ExelFilepath("purchase", "POAmendmentNew");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);

		System.out.println(TestcaseID + testcasedesc);

		String POBASIS = Ecel.getCellData("POAMI001", "POBASIS", 1);

		String Year = Ecel.getCellData("POAMI001", "Year", 1);

		String Group = Ecel.getCellData("POAMI001", "Group", 1);
		System.out.println(Group);

		String Site = Ecel.getCellData("POAMI001", "Site", 1);

		String PONumber = Ecel.getCellData("POAMI001", "PONumber", 1);

		String AmendmentDate = Ecel.getCellData("POAMI001", "AmendmentDate", 1);

		String Vendor = Ecel.getCellData("POAMI001", "Vendor", 1);

		String Reason = Ecel.getCellData("POAMI001", "Reason", 1);

		String RateStucture = Ecel.getCellData("POAMI001", "RateStucture", 1);

		System.out.println(POBASIS + Year + Group + Site + Site + PONumber + Reason);
		
		
		//Library.Comboclick(, Reason, RateStucture);
	}
}
