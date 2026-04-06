package com.procam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	// public static WebDriver driver;
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public static WebDriver initDriver(String browserName) {
		WebDriver driver;

		switch (browserName.toLowerCase()) {
		case "chrome": {
			ChromeOptions options = new ChromeOptions();

		    // 🔥 Remove "Chrome is being controlled..." infobar
		    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

		    // 🔥 Disable automation extension
		    options.setExperimentalOption("useAutomationExtension", false);

		    // Optional (helps in some cases)
		    options.addArguments("--disable-blink-features=AutomationControlled");
			driver = new ChromeDriver(options);
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
		threadLocalDriver.set(driver);
		return getDriver();

	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	public static void quitDriver() {
		if(threadLocalDriver.get()!=null) {
			threadLocalDriver.get().quit();
			threadLocalDriver.remove();
		}
	}
}
