package com.demo.datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Hirearchy  for access the data
//ExcelFile--> Workbook--> sheet---> Rows--> cell

public class DataDrivenDemo {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\testFile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int totalNumberOfRows = sheet.getLastRowNum();
		System.out.println("Total number of rows : " + totalNumberOfRows);

		int totalNumberOfcell = sheet.getRow(1).getLastCellNum();
		System.out.println("Total number of rows : " + totalNumberOfcell);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);

		for (int r = 0; r <= totalNumberOfRows; r++) {

			XSSFRow currentRow = sheet.getRow(r);

			for (int c = 0; c < totalNumberOfcell; c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				String cellData = currentCell.toString();
				System.out.print(cellData + "\t");
			}
			System.out.println();

		}
		workbook.close();
		file.close();
	}

}
