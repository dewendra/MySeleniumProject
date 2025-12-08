package com.procam.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String getCellValue(String path, int row, int col) {
		try {
			FileInputStream file = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(file);
			return wb.getSheetAt(0).getRow(row).getCell(col).getStringCellValue();
		} catch (Exception e) {
			return null;
		}

	}
}
