package com.demo.utils;

import java.text.DateFormatSymbols;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerHelper {
	WebDriver driver;

	WebDriverWait wait;

	public DatePickerHelper() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	}

	public static void selectDate(WebDriver driver, WebElement dateInput, String date) throws InterruptedException {

		// Expected format: DD-MM-YYYY
		String arr[] = date.split("-");
		int day = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[2]);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1. Open the date picker
		//js.executeScript("arguments[0].focus(); arguments[0].click();", dateInput);
		// dateInput.click();

		// 2. Wait for calendar popup
		WebElement calendar = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.calendar")));
		js.executeScript("arguments[0].focus()", calendar);

		// 3. Select year
		WebElement yearDropDown = calendar.findElement(By.cssSelector("select.yearpicker"));
		Select yearToSelect = new Select(yearDropDown);
		yearToSelect.selectByVisibleText(String.valueOf(year));
		// Thread.sleep(5000);

		// 4. Select month
		WebElement monthDropDown = calendar.findElement(By.cssSelector(".monthpicker"));
		Select monthToSelect = new Select(monthDropDown);
		monthToSelect.selectByVisibleText(getMonthName(month));
		// Thread.sleep(5000);

		// 5. Select day
		// Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//div[contains(@class,'normalDates') and not(contains(@class,'disabled')) and normalize-space()='"
						+ day + "']"))
				.click();

	}

	private static String getMonthName(int month) {

		return new DateFormatSymbols().getShortMonths()[month - 1]; // 1 = Jan
	}

}
