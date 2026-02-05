package com.procam.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.procam.pageobjects.DiscountApplyPage;
import com.procam.utils.DriverFactory;
import com.procam.utils.EmailUtils;
import com.procam.utils.ExtentReport;
import com.procam.utils.Logs;

/**
 * @author Dewendra Singh
 *
 */
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
		log.info("Report configuration file...");
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
