package com.procam;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.procam.base.BaseClass;
import com.procam.pageobjects.DiscountApplyPage;
import com.procam.pageobjects.EventCriteriaPage;
import com.procam.pageobjects.EventDashboardPage;
import com.procam.pageobjects.LoginPage;
import com.procam.pageobjects.PersonalDetailsPage;
import com.procam.utils.Logs;

public class LoginPageTest extends BaseClass {
	public static ExtentReports extentReports;
	private LoginPage loginPage;
	private EventDashboardPage eventDashboardPage;
	private DiscountApplyPage discountApplyPage;
	private PersonalDetailsPage personalDetailsPage;
	private EventCriteriaPage eventCriteriaPage;

	//@BeforeSuite
	public void setupSuit() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
	}

	@BeforeMethod
	public void setup() {
		Logs.info("===== Test Started =====");
		launchApp();
	}

	@Test
	public void verifyLogin() throws InterruptedException {
		loginPage = new LoginPage();
		eventDashboardPage = loginPage.loginByEmail();
		discountApplyPage = eventDashboardPage.selectEvent();
		// personalDetailsPage=discountApplyPage.withDiscountCode();
		personalDetailsPage = discountApplyPage.withoutDiscountCode();
		eventCriteriaPage=personalDetailsPage.enterDetails();
		eventCriteriaPage.enterEventDetails();

	}

	//@AfterMethod
	public void tearDown() {
		Logs.info("===== Test Finished =====");
		closeApp();
	}

	@AfterSuite
	public void closeSuite() {
		extentReports.flush();
	}
}
