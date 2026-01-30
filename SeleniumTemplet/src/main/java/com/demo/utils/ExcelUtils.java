package com.demo.utils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtils {

	public static Map<String, String> getTestData(String filePath, String sheetName, int rowNum) {
		Map<String, String> data = new HashMap<String, String>();

		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			Workbook wb = WorkbookFactory.create(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			Row dataRow = sheet.getRow(rowNum);

			if (headerRow==null|| dataRow == null) {
				return data; // prevents NullPointerException
			}

			DataFormatter formatter = new DataFormatter();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				String key = formatter.formatCellValue(headerRow.getCell(i)).trim();
				Cell cell = dataRow.getCell(i);
				String value = "";
				if (cell != null) {
					switch (cell.getCellType()) {
					case STRING:
						value = cell.getStringCellValue().trim();
						break;

					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							value = simpleDateFormat.format(cell.getDateCellValue());
						} else {
							value = formatter.formatCellValue(cell).trim();
						}
						break;

					case BOOLEAN:
						value = String.valueOf(cell.getBooleanCellValue());
						break;
					default:
						value = formatter.formatCellValue(cell).trim();
					}
					// -------------------------------------------
//					if (DateUtil.isCellDateFormatted(cell)) {
//						value = simpleDateFormat.format(cell.getDateCellValue()); // ✅ FIX
//					} else {
//						value = formatter.formatCellValue(cell).trim();
//					}
					// -------------------------------
				}
				// String value = formatter.formatCellValue(dataRow.getCell(i));
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
			Sheet sheet = wb.getSheet(sheetName);
			return sheet.getPhysicalNumberOfRows() - 1; // exclude header
			// return wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
