package com.ps.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ps.model.Employee;

public class Helper {
	
	public static String[] HEADERS= {
			"Id",
			"First Name",
			"Last Name",
			"Mobile No.",
			"Address",
			"E-mail"
	};
	
	public static String SHEET_NAME="Employee_Data";
	
	public static ByteArrayInputStream dataToExcel(List<Employee> list) throws IOException 
	{
		
		//for creating workbook
		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			
			//create sheet
			Sheet sheet = workbook.createSheet(SHEET_NAME);
			
			//create row: header row
			Row row = sheet.createRow(0);
			
			for(int i = 0; i< HEADERS.length; i++) {
				Cell cell= row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			//value rows
			int rowIndex= 1;
			for(Employee c : list)
			{
				Row dataRow = sheet.createRow(rowIndex);
				rowIndex++;
				
				dataRow.createCell(0).setCellValue(c.getId());
				dataRow.createCell(1).setCellValue(c.getFirstName());
				dataRow.createCell(2).setCellValue(c.getLastName());
				dataRow.createCell(3).setCellValue(c.getMobNo());
				dataRow.createCell(4).setCellValue(c.getAddress());
				dataRow.createCell(5).setCellValue(c.getEmail());
				
			}
			workbook.write(out);
			
			return new ByteArrayInputStream(out.toByteArray());
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error importing data..");
			return null;
		}
		finally {
			workbook.close();
			out.close();
			
		}
	
	}

}
