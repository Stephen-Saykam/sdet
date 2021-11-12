package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

public class ExcelUtility {
	
	@Test
	public String excelUtility(String sheetname, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rownum);
		Cell cl = rw.getCell(cellnum);
		return cl.getStringCellValue();	
	}
	
	public String sendNumericValue(String sheetname, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		int value = (int)cell.getNumericCellValue();
		return String.valueOf(value);
		
		
	}

}
