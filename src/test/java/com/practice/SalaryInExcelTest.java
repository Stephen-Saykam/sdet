package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class SalaryInExcelTest {
	
	@Test
	public void salaryInExcelTest() throws Throwable
	{
		FileInputStream fis = new FileInputStream("./Data/testdata.xlsx");
		Workbook wrkbook = WorkbookFactory.create(fis);
		int lastRow = wrkbook.getSheet("sheet2").getLastRowNum();
		
		for(int i=1; i<lastRow; i++)
		{
			String EmpSalaray = wrkbook.getSheet("sheet2").getRow(i).getCell(2).getStringCellValue();
			
			if(Integer.parseInt(EmpSalaray)>50000)
			{
				System.out.println(wrkbook.getSheet("sheet2").getRow(i).getCell(1).getStringCellValue()+" "+EmpSalaray);
			}
		}
	}

}
