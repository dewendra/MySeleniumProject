package com.demo.datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDatePicker {

	public static void main(String[] args)  {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		String expectedYear = "2025";
		String expectedMonth = "June";
		String expectedDate = "15";
		futureDatePicker(driver, expectedYear, expectedMonth, expectedDate);
		//pastDatePicker(driver, expectedYear, expectedMonth, expectedDate);
	}
	public static void futureDatePicker( WebDriver driver, String expectedYear, String expectedMonth, String expectedDate) {
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentYear.equals(expectedYear) && currentMonth.equals(expectedMonth)) {
				break;
			}
			// For Future Date
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement>allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		  for(WebElement dt:allDates) {
			  
		  if(dt.getText().equals(expectedDate)) {
			  dt.click();
			  break;
		  }
			  
		  }
	}
	
public static void pastDatePicker( WebDriver driver, String expectedYear, String expectedMonth, String expectedDate) {
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentYear.equals(expectedYear) && currentMonth.equals(expectedMonth)) {
				break;
			}
			// For Past Date
			 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		List<WebElement>allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		  for(WebElement dt:allDates) {
			  
		  if(dt.getText().equals(expectedDate)) {
			  dt.click();
			  break;
		  }
			  
		  }
	}

}
