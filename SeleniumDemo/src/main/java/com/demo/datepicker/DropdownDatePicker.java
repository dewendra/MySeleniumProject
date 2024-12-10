package com.demo.datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDatePicker {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.switchTo().frame(0);
		String expectedYear = "2026";
		String expectedMonth = "Jun";
		String expectedDate = "15";
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		WebElement dropdownYear=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear=new Select(dropdownYear);
		selectYear.selectByVisibleText(expectedYear);
		
		WebElement dropdownMonth=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth=new Select(dropdownMonth);
		selectMonth.selectByVisibleText(expectedMonth);
		List<WebElement>allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		  for(WebElement dt:allDates) {
			  
		  if(dt.getText().equals(expectedDate)) {
			  dt.click();
			  break;
		  }
			  
		  }
		/*
		 * while(true) { if(year.equals(expectedYear)) { break; } String
		 * currentMonth=driver.findElement(By.
		 * xpath("//select[@aria-label='Select month']")).getText();
		 * if(currentMonth.equals(expectedMonth)) { break; }
		 * 
		 * }
		 */
	}

}
