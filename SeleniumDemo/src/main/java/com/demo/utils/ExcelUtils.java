package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream inputFile;
	public static FileOutputStream outputFile;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle cellStyle;

	public static int getRowCount(String excelFile, String excelSheet) throws IOException {
		inputFile = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(inputFile);
		sheet = workbook.getSheet(excelSheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		inputFile.close();
		return rowCount;
	}

	public static int getCellCount(String excelFile, String excelSheet, int rowNum) throws IOException {
		inputFile = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(inputFile);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		inputFile.close();
		return cellCount;
	}

	public static String getCellData(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		inputFile = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(inputFile);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);// Returns the formatted value of a cell as a string regardless of a cell type.
		} catch (Exception e) {
			data = "";//handling if the blank cell or empty cell it returns blank data not null
		}
		workbook.close();
		inputFile.close();
		return data;

	}
	public static void setCellData(String excelFile, String excelSheet, int rowNum, int cellNum, String data) throws IOException {
		inputFile = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(inputFile);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		outputFile=new FileOutputStream(excelFile);
		workbook.write(outputFile);
		workbook.close();
		inputFile.close();
		outputFile.close();
		
		
	}
	public static void fillGreenColorInCell(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		inputFile = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(inputFile);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);
		outputFile=new FileOutputStream(excelFile);
		workbook.write(outputFile);
		workbook.close();
		inputFile.close();
		outputFile.close();
	}
	
	public static void fillRedColorInCell(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		inputFile = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(inputFile);
		sheet = workbook.getSheet(excelSheet);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);
		outputFile=new FileOutputStream(excelFile);
		workbook.write(outputFile);
		workbook.close();
		inputFile.close();
		outputFile.close();
	}

}
