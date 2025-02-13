package com.demo.datadriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDyanmicDataIntoSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myFileDynamic.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		XSSFRow createdRow = sheet.createRow(4);
		XSSFCell CreatedCell = createdRow.createCell(6);
		CreatedCell.setCellValue("value added");
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created");

	}

}
