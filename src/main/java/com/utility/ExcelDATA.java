package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDATA {
	public XSSFWorkbook wb;

	public ExcelDATA(String foldername, String Filename) throws Exception {
		String excelpath = System.getProperty("user.dir") + "\\ExcelFiles\\" + foldername + "\\" + Filename + ".xlsx";

		File file = new File(excelpath);
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);

	}

	public int lastrow(String sheetname) {

		XSSFSheet sheet = wb.getSheet(sheetname);

		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}

	public int lastcell(String sheetname, int row) {
		XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFRow rows = sheet.getRow(row);

		int lastcell = rows.getLastCellNum();
		return lastcell;
	}

	public String getStringDATA(String sheetname, int row, int cell) throws Exception {
		XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFRow rows = sheet.getRow(row);
		XSSFCell cells = rows.getCell(cell);
		CellType celltype = cells.getCellType();

		if (celltype == celltype.STRING) {

			return cells.getStringCellValue();

		} else if (celltype == celltype.NUMERIC) {

			double d = cells.getNumericCellValue();

			int c = (int) d;
			String s = Integer.toString(c);

			if (s.length() == 5) {
				cells.getDateCellValue();
				Date javaDate = DateUtil.getJavaDate((double) d);
				String cdate = new SimpleDateFormat("dd/MM/yyyy").format(javaDate);

				return cdate;
			}

			return s;
		}

		else if (celltype == celltype.FORMULA) {

			cells.getCellFormula();

			return cells.getCellFormula();
		}

		else if (celltype == celltype.BLANK) {

			return "The value is blank";
		}

		return null;
	}

	private Cell getCurrentCell(Cell cell) {
		// TODO Auto-generated method stub
		return null;
	}

}
