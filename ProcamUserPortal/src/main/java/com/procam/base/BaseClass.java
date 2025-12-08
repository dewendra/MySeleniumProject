package com.procam.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.procam.utils.DriverFactory;

/**
 * @author Dewendra Singh
 *
 */
public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void loadConfig() {

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

	public void launchApp() {
		String browserName = prop.getProperty("browser");
		DriverFactory.initDriver(browserName);
		DriverFactory.getDriver().get(prop.getProperty("url"));

	}

	public void closeApp() {
		DriverFactory.getDriver().quit();
	}

}
