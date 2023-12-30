package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXCELREADER {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public EXCELREADER(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

public String getCellData(String sheetName,String colName,int rowNum){
		
		rowNum=rowNum+1;
		
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);
		int col_Num=-1;
		if(index==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "NODATAPRESENT";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "NODATAPRESENT";
		
		if(cell.getCellType()==CellType.STRING)
			  return cell.getStringCellValue();
		
		
		
		else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){
			  
			
			
			int value = (int)cell.getNumericCellValue();
			  String cellText  = String.valueOf(value);
			 
			

			  
			  
			  return cellText;
		  }else if(cell.getCellType()==CellType.BLANK)
		      return "NODATAPRESENT"; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "NODATAPRESENT";
			//return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	

}
