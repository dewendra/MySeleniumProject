package com.demo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demo.base.BaseClass;
import com.demo.utils.DriverFactory;
import com.demo.utils.EmailUtils;
import com.demo.utils.ExtentReport;

public class BaseClass {


	private static final Logger log = LogManager.getLogger(BaseClass.class);

	protected WebDriver driver;
	protected ExtentReports extentReports;
	protected ExtentTest test;
	public static Properties prop;

	@BeforeSuite
	public void loadConfig() {

		log.info("Reading configuration file...");
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

	@BeforeSuite
	public void setupReport() {
		extentReports = ExtentReport.getReportInstance();
	}


	@Parameters("browser")
	// @BeforeMethod
	public void launchApp() {
		log.info("launching app...");
		// String browserName = browser != null ? browser : prop.getProperty("browser");
		String browserName = prop.getProperty("browser");
		DriverFactory.initDriver(browserName);
		DriverFactory.getDriver().get(prop.getProperty("url"));

	}

	// @AfterMethod
	public void closeApp() {
		DriverFactory.getDriver().quit();
	}

	@AfterSuite
	public void tearDownReport() {
		extentReports.flush();
		String reportPath=ExtentReport.reportPath;
		EmailUtils.sendTestReport(reportPath);
	}


}
