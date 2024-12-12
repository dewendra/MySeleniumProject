package com.demo.table;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// count total rows in a table
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total Rows : "+rows);
		// count total columns in a table
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr/th")).size();
		System.out.println("Total Columns : "+cols);
		//Select specific row and column data
		//String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		//System.out.println("Data : "+data);
		//Select all data in table
		/*
		 * System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		 * for(int r=2;r<=rows; r++){ for(int c=1; c<=cols;c++) { String
		 * allData=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+
		 * "]/td["+c+"]")).getText(); System.out.print(allData+"\t"); }
		 * System.out.println(); }
		 */
		//Print book name which Author is Mukesh
		/*
		 * for(int r=2;r<=rows;r++) { String
		 * authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+
		 * "]/td[2]")).getText(); if(authorName.equals("Mukesh")) { String
		 * booksName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+
		 * "]/td[1]")).getText(); System.out.println(booksName); } }
		 */
		//Find the total price of books
		int totalPrice=0;
		for(int r=2;r<=rows;r++) {
			String bookPrice=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
			//System.out.println(bookPrice);
			totalPrice=totalPrice+Integer.parseInt(bookPrice);
		}
		System.out.println(totalPrice);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
