package com.procam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.procam.base.BaseClass;
import com.procam.pageObjects.LoginPage;
import com.procam.pageObjects.EventDashboardPage;
import com.procam.utils.ExcelUtils;
import com.procam.utils.Logs;

public class VolunteerLoginPageTest extends BaseClass {
	public static ExtentReports extentReports;
	private LoginPage loginPage;
	private EventDashboardPage eventDashboardPage;

	@BeforeSuite
	public void setupSuit() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
	}

	@BeforeClass
	public void setup() {
		Logs.info("===== Test Started =====");
		launchApp();

	}

	@Test(dataProvider = "fullFlowData")
	public void verifiyVoulnteerLogin(Map<String, String> loginData) throws InterruptedException {
		loginPage = new LoginPage();
		eventDashboardPage=loginPage.loginByEmail(loginData);

	}

	// ---------------------------------------All sheet data provider IN USE --------------------------------//
	@DataProvider(name = "fullFlowData")
	public Object[][] fullFlowData() {

		String registrationFile = prop.getProperty("tmm.registration.excel.path");

		// String registrationFile =
		// "src/test/resources/testdata/RegistrationData_TMM.xlsx";
		String loginSheet = "Login";
		String eventDashboard = "EventDashboard";
		String personalSheet = "Personal";
		String eventCriteriaSheet = "EventCriteria";
		String merchandiseSheet = "Merchandise";
		String gstSheet = "GSTData";
		String paymentsSheet = "Payments";

		int rowCount = ExcelUtils.getRowCount(registrationFile, "Login");

		List<Object[]> list = new ArrayList<>();

		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> loginData = ExcelUtils.getTestData(registrationFile, loginSheet, i);
			if (loginData == null || loginData.get("emailId") == null || loginData.get("emailId").trim().isEmpty()) {
				continue;
			}
			Map<String, String> eventDashboardData = ExcelUtils.getTestData(registrationFile, eventDashboard, i);
			//Map<String, String> personalData = ExcelUtils.getTestData(registrationFile, personalSheet, i);
			//Map<String, String> eventCriteriaData = ExcelUtils.getTestData(registrationFile, eventCriteriaSheet, i);
			//Map<String, String> merchandiseData = ExcelUtils.getTestData(registrationFile, merchandiseSheet, i);
			//Map<String, String> gstData = ExcelUtils.getTestData(registrationFile, gstSheet, i);
			//Map<String, String> PaymentsData = ExcelUtils.getTestData(registrationFile, paymentsSheet, i);

			list.add(new Object[] { loginData,  eventDashboardData, /*
					 *personalData, eventCriteriaData, merchandiseData,
												 * gstData, PaymentsData
												 */});

		}
		return list.toArray(new Object[0][]);
	}

	// @AfterMethod
	public void tearDown() {
		Logs.info("===== Test Finished =====");
		closeApp();
	}

	@AfterSuite
	public void closeSuite() {
		extentReports.flush();
	}

}
