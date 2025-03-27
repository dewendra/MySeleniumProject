package com.demo.datadriven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.demo.utils.ExcelUtils;

import dev.failsafe.internal.util.Assert;

public class DataDrivenFDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement principleAmountField = driver.findElement(By.xpath("//input[@id='principal']"));
		WebElement rateOfInterestField = driver.findElement(By.xpath("//input[@id='interest']"));
		WebElement period1Field = driver.findElement(By.xpath("//input[@id='tenure']"));
		Select period2Field = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
		Select frequencyField = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
		WebElement btnCalculate = driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
		WebElement btnClear = driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]"));

		
		// double act_maturityValue = Double.parseDouble(act_maturityValueField);
		

		// working with the excel file
		String filePath = System.getProperty("user.dir") + "\\testData\\calculateRateOfInterest.xlsx";

		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		// int cellCount = ExcelUtils.getCellCount(filePath, "Sheet1", rowCount);

		for (int r = 1; r <= rowCount; r++) {
			// read data from excel sheet
			String principleAmount = ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", r, 1);
			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", r, 2);
			String period2 = ExcelUtils.getCellData(filePath, "Sheet1", r, 3);
			String frequency = ExcelUtils.getCellData(filePath, "Sheet1", r, 4);
			String exp_maturityValue = ExcelUtils.getCellData(filePath, "Sheet1", r, 5);
			// double exp_maturityValue1 = Double.parseDouble(exp_maturityValue);

			/*
			 * System.out.println("principleAmount: " + principleAmount + "rateOfInterest :"
			 * + rateOfInterest + "period1 : " + period1 + "period2 : " + period2 +
			 * "frequency : " + frequency + "exp_maturityValue :" + exp_maturityValue);
			 */

			// pass above data into application
			principleAmountField.sendKeys(principleAmount);
			rateOfInterestField.sendKeys(rateOfInterest);
			period1Field.sendKeys(period1);
			period2Field.selectByVisibleText(period2);
			frequencyField.selectByVisibleText(frequency);
			btnCalculate.click();
			
			String act_maturityValueField = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			System.out.println(act_maturityValueField);
			// validation the data
			if (Double.parseDouble(exp_maturityValue) == Double.parseDouble(act_maturityValueField)) {
				System.out.println("Test Pass");
				ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Passed");
				ExcelUtils.fillGreenColorInCell(filePath, "Sheet1", r, 7);

			} else {
				System.out.println("Test Fail");
				ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Faild");
				ExcelUtils.fillRedColorInCell(filePath, "Sheet1", r, 7);

			}
			Thread.sleep(3000);
			btnClear.click();
		}
		driver.quit();
	}

}
