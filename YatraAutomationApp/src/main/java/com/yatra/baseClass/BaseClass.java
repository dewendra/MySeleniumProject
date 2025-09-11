/**
 * 
 */
package com.yatra.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dewendra Singh
 *
 */
public class BaseClass {

	// public static WebDriver driver;
	public static Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static WebDriver getDriver() { // Get Driver from threadLocalmap
		return driver.get();
	}

	// loadConfig method is to load the configuration
	// @BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	@BeforeTest
	public void loadConfig() {
		/*
		 * ExtentManager.setExtent(); DOMConfigurator.configure("log4j.xml");
		 */

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					Paths.get(System.getProperty("user.dir"), "Configuration", "config.properties").toFile());
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static WebDriver getDriver() { // Get Driver from threadLocalmap
	 * return driver.get(); }
	 */

	public void launchApp() {

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--start-maximized"); // Optional: Start browser maximized
			driver.set(new ChromeDriver(chromeOptions));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("dom.webnotifications.enabled", false); // Disable Firefox notifications
			driver.set(new FirefoxDriver(firefoxOptions));
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
			break;

		default:
			throw new IllegalArgumentException("Browser not supported: " + browserName);

		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		getDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));
		
		getDriver().get(prop.getProperty("url"));
	}

	/*
	 * @AfterSuite(groups = { "Smoke", "Regression","Sanity" }) public void
	 * afterSuite() { ExtentManager.endReport(); }
	 */

}
