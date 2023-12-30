package com.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public ExcelDataProvider() throws Exception{
		String excelpath=System.getProperty("user.dir")+"\\ExcelFiles\\LOGIN.xlsx";
		
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		 wb = new XSSFWorkbook(fis);
		
			
			
		 
		 
	} 
		
	public ExcelDataProvider(String Filename) throws Exception{
		String excelpath=System.getProperty("user.dir")+"\\ExcelFiles\\"+Filename+".xlsx";
		
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		 wb = new XSSFWorkbook(fis);
		 
	} 
	
	public ExcelDataProvider(String foldername,String Filename) throws Exception{
		String excelpath=System.getProperty("user.dir")+"\\ExcelFiles\\"+foldername+"\\"+Filename+".xlsx";
		
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		 wb = new XSSFWorkbook(fis);
		 
		
		 
	}
	
	
	
		public String getStringdata(String sheetname,int row,int cell) {
			
			
			
			return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		}
		

//		public String getStringdata1(String sheetname,int row,int cell) {
//			wb.getSheet(sheetname).getRow(row).getCell(cell).getCellType();
//			
//			switch(wb.getSheet(sheetname).getRow(row).getCell(cell).getCellType()) {
//			
//			case STRING:System.out.println(wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue());
//			
//			return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
//			
//			
//			
//			case NUMERIC:
//				
//				System.out.println(wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue());
//			double d=wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
//			
//			int value = (int)d;
//			String str=Integer.toString(value);
//			
//			
//			return str;
//			
//			
//		
//			
//			
//			}
			
			
			
			
			
		
		

		
		
		
		
		
		
		
		
		
		
		public String getStringnumberdata(String sheetname,int row,int cell) {
			
			double d=wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			int value = (int)d;
			String str=Integer.toString(value);
			
			
			return str;
		}
		
		
		
		
		
		
		public static void main(String[] args) throws Exception {
			
			String excelpath=System.getProperty("user.dir")+"\\ExcelFiles\\LOGIN.xlsx";
			
			
			FileInputStream fis=new FileInputStream(excelpath);
			XSSFWorkbook wb1= new XSSFWorkbook(fis);
			String value=wb1.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
			System.out.println(value);
			 
		}
		
		}
		

		
	


