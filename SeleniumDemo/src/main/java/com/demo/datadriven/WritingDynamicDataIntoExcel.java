package com.demo.datadriven;

import java.awt.Window;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myFileDynamic.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of row : ");
		int numberOfRow=sc.nextInt();
		
		System.out.println("Enter the number of cell : ");
		int numberOfCell=sc.nextInt();
		
		for(int r=0; r<=numberOfRow;r++) {
			XSSFRow currentRow = sheet.createRow(r);
			
			for(int c=0;c<=numberOfCell;c++) {
				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next());
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created");

	}

}
