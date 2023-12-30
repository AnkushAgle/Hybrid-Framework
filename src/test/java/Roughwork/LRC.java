package Roughwork;

import com.utility.ExcelReader;
import com.utility.Library;

public class LRC {

	public static void main(String[] args) {
		String path = Library.ExelFilepath("purchase", "LabourRateContractEntry");
		System.out.println(path);
		ExcelReader Ecel = new ExcelReader(path);
		String TestcaseID = Ecel.getCellData("Testcases", "TestCaseID", 1);// Test Case ID
		String testcasedesc = Ecel.getCellData("Testcases", "TestCase Desc", 1);// Test Case Desc
	Library.testcasedesc(TestcaseID, testcasedesc);
		String Recoedingrequired = Ecel.getCellData("POAMI001", "RECORDING(YES/NO)", 1);
	String thread = "YES";
	String sheet = "LRC002";
	String Group = Ecel.getCellData(sheet, "GROUP", 1);

		String Site = Ecel.getCellData(sheet, "SITE", 1);

	String PODate = Ecel.getCellData(sheet, "PODate", 1);

		String CONTRACTVALIDFROMDATE = Ecel.getCellData(sheet, "CONTRACTVALIDFROMDATE", 1);

		String BUYER= Ecel.getCellData(sheet, "BUYER", 1);

		String RateStructure=Ecel.getCellData(sheet, "RateStucture", 1);
		
		System.out.println(PODate);
		System.out.println(CONTRACTVALIDFROMDATE);

		

	}

}
