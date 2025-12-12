package com.procam.utils;

import java.nio.channels.SelectableChannel;
import java.text.DateFormatSymbols;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerHelper {
	
	WaitHelper wait;
	
	public static void selectDate(WebDriver driver, WebElement dateInput, String date) throws InterruptedException {
		
		// Expected format: DD-MM-YYYY
		String arr[]=date.split("-");
		int day=Integer.parseInt(arr[0]);
		int month=Integer.parseInt(arr[1]);
		int year=Integer.parseInt(arr[2]);
		
		// 1. Open the date picker
		dateInput.click();
		
		// 2. Wait for calendar popup
		//WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".datepicker-container")));
		
		// 3. Select year
		WebElement yearDropDown=driver.findElement(By.cssSelector("select.yearpicker"));
		Select yearToSelect=new Select(yearDropDown);
		yearToSelect.selectByVisibleText(String.valueOf(year));
		Thread.sleep(5000);
		
		// 4. Select month
		WebElement monthDropDown=driver.findElement(By.cssSelector(".monthpicker"));
		Select monthToSelect=new Select(monthDropDown);
		monthToSelect.selectByVisibleText(getMonthName(month));
		Thread.sleep(5000);
		
		// 5. Select day
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'normalDates') and not(contains(@class,'disabled')) and normalize-space()='" + day + "']")).click();


		
	}

	private static String getMonthName(int month) {
		
		return new DateFormatSymbols().getShortMonths()[month - 1]; // 1 = Jan
	}

}
