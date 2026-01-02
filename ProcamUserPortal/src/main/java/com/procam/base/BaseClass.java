package com.procam.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.procam.utils.DriverFactory;

/**
 * @author Dewendra Singh
 *
 */
public class BaseClass {

	//protected WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(fileInputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Parameters("browser")
	//@BeforeMethod
	public void launchApp() {
		//String browserName = browser != null ? browser : prop.getProperty("browser");
		String browserName = prop.getProperty("browser");
		DriverFactory.initDriver(browserName);
		DriverFactory.getDriver().get(prop.getProperty("url"));

	}

	//@AfterMethod
	public void closeApp() {
		DriverFactory.getDriver().quit();
	}

}
