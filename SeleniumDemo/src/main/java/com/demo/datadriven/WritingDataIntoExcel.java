package com.demo.datadriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myFile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("Age");
		row1.createCell(2).setCellValue("Dept.");
		row1.createCell(3).setCellValue("salary");
		row1.createCell(4).setCellValue("Bonus");
		// create 2nd row
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Rahul");
		row2.createCell(1).setCellValue("32");
		row2.createCell(2).setCellValue("Logistics");
		row2.createCell(3).setCellValue("65000");
		row2.createCell(4).setCellValue("15000");
		// create 3rd row
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Manish");
		row3.createCell(1).setCellValue("27");
		row3.createCell(2).setCellValue("Development");
		row3.createCell(3).setCellValue("85000");
		row3.createCell(4).setCellValue("25000");
		// create 4th row
		XSSFRow row4 = sheet.createRow(3);
		row4.createCell(0).setCellValue("Sohan");
		row4.createCell(1).setCellValue("25");
		row4.createCell(2).setCellValue("Testing");
		row4.createCell(3).setCellValue("55000");
		row4.createCell(4).setCellValue("12000");
		// create 5th row
		XSSFRow row5 = sheet.createRow(4);
		row5.createCell(0).setCellValue("Radhika");
		row5.createCell(1).setCellValue("28");
		row5.createCell(2).setCellValue("Services");
		row5.createCell(3).setCellValue("95000");
		row5.createCell(4).setCellValue("22000");
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created");

	}

}
