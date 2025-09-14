package com.fast;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://fast.com/");
		WebElement speed_value = driver.findElement(By.id("speed-value"));
		WebElement speed_unit = driver.findElement(By.id("speed-units"));
		String className;
		while (true) {
			WebElement speedValue = wait.until(ExpectedConditions.visibilityOf(speed_value));
			WebElement speedUnit = wait.until(ExpectedConditions.visibilityOf(speed_unit));

			System.out.println(speedValue.getText() + " " + speedUnit.getText());
			className = speedValue.getAttribute("class");
			System.out.println(className);
			if (className != null && className.contains("succeeded")) {
				break;
			}
		}
		WebElement speedValue = wait.until(ExpectedConditions.visibilityOf(speed_value));
		WebElement speedUnit = wait.until(ExpectedConditions.visibilityOf(speed_unit));
		System.out.println("----------------Final Speed----------------");
		System.out.println(speedValue.getText() + " : " + speedUnit.getText());

	}

}
