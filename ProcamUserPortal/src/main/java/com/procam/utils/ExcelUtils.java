package com.procam.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static Map<String, String> getTestData(String filePath, String sheetName, int rowNum) {
		Map<String, String> data = new HashMap<String, String>();

		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			Workbook wb = WorkbookFactory.create(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			Row dataRow = sheet.getRow(rowNum);
			
			if(dataRow==null) {
				return data;  // prevents NullPointerException
			}
			
			DataFormatter formatter=new DataFormatter(); 
			
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				String key = formatter.formatCellValue(headerRow.getCell(i));
				String value = formatter.formatCellValue(dataRow.getCell(i));
				data.put(key, value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
	public static int getRowCount(String filePath, String sheetName) {
	    try (FileInputStream fis = new FileInputStream(filePath)) {
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet=wb.getSheet(sheetName);
	        return sheet.getPhysicalNumberOfRows()-1; // exclude header
	        //return wb.getSheet(sheetName).getLastRowNum();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

}
