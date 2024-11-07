/**
 * 
 */
package com.hdorRegistrationProcess.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.hdorRegistrationProcess.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dewendra Singh
 *
 */
public class BaseClass {

	//public static WebDriver driver;
	public static Properties prop;

	 //Declare ThreadLocal Driver
	 public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	 
		  public static WebDriver getDriver() { // Get Driver from threadLocalmap
		  return driver.get(); }
		 

	// loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/*
	 * @BeforeTest public void loadConfigs() throws IOException {
	 * 
	 * ExtentManager.setExtent(); DOMConfigurator.configure("log4j.xml");
	 * 
	 * 
	 * try { prop = new Properties(); FileInputStream ip = new FileInputStream(
	 * System.getProperty("user.dir") + "\\Configuration\\config.properties");
	 * prop.load(ip);
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); } }
	 */

	

	public void launchApp() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
		// PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);
		// Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
