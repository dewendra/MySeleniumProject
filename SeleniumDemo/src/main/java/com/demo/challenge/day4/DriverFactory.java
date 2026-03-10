package com.demo.challenge.day4;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;

	public WebDriver initDriver(String browserName, Properties properties) {
		System.out.println("Browser name is : " + browserName);
		System.out.println("Property name is :"+properties);
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Given Browser name not found...." + browserName);
			break;
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

}
