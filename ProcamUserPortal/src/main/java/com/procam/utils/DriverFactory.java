package com.procam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver initDriver(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome": {
			driver = new ChromeDriver();
			break;
		}
		case "edge": {
			driver = new EdgeDriver();
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			break;
		}
		default:
			System.out.println("Invalid browser provided... running Chrome by default");
			driver = new ChromeDriver();
			// throw new IllegalArgumentException("Unexpected value: " + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}
}
