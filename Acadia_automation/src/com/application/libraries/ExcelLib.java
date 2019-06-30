package com.application.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	
	
	FileInputStream filepath;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	
	public void getFile()
	{
		try
		{
			this.filepath = new FileInputStream("G:\\Automation\\IU_automation\\data\\data.xlsx");
			this.workbook = WorkbookFactory.create(filepath);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		
		}
		catch(IllegalFormatException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public String readFileData(String sheetname, int rowIndex, int cellIndex)
	{
		String cell_value = null;
		this.sheet = workbook.getSheet(sheetname);
		this.row = sheet.getRow(rowIndex);
		this.cell = row.getCell(cellIndex);
		DataFormatter formatter = new DataFormatter();
		cell_value = formatter.formatCellValue(cell);
		
		//cell_value = cell.getStringCellValue();
		
		//System.out.println(cell_value.getClass().getName());
		return cell_value;
	}
	
	
	public int 	getRowCount (String sheetName)
	{
//		System.out.println("*****************************");
//		System.out.println(s.getLastRowNum());
		getFile();
		this.sheet = workbook.getSheet(sheetName);
		return sheet.getLastRowNum();
	
	}
	
	
}
