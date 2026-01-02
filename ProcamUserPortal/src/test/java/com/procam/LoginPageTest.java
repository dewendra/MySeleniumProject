package com.procam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.procam.base.BaseClass;
import com.procam.pageobjects.DiscountApplyPage;
import com.procam.pageobjects.EventCriteriaPage;
import com.procam.pageobjects.EventDashboardPage;
import com.procam.pageobjects.LoginPage;
import com.procam.pageobjects.MerchandiseDetailsPage;
import com.procam.pageobjects.OrderSummaryPage;
import com.procam.pageobjects.PaymentsOptionPage;
import com.procam.pageobjects.PersonalDetailsPage;
import com.procam.utils.ExcelUtils;
import com.procam.utils.Logs;

public class LoginPageTest extends BaseClass {
	public static ExtentReports extentReports;
	private LoginPage loginPage;
	private EventDashboardPage eventDashboardPage;
	private DiscountApplyPage discountApplyPage;
	private PersonalDetailsPage personalDetailsPage;
	private EventCriteriaPage eventCriteriaPage;
	private MerchandiseDetailsPage merchandiseDetailsPage;
	private OrderSummaryPage orderSummaryPage;
	private PaymentsOptionPage paymentsOptionPage;

	// @BeforeSuite
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
	public void verifyLogin(Map<String, String> loginData, 
			Map<String, String> eventDashboardData,
			Map<String, String> personalData, 
			Map<String, String> eventCriteriaData,
			Map<String, String> MerchandiseData, 
			Map<String, String> gstData, 
			Map<String, String> PaymentsData)
			throws InterruptedException {
		loginPage = new LoginPage();
		eventDashboardPage = loginPage.loginByEmail(loginData);
		discountApplyPage = eventDashboardPage.selectEvent(eventDashboardData);
		// personalDetailsPage=discountApplyPage.withDiscountCode();
		discountApplyPage.readMore();
		personalDetailsPage = discountApplyPage.withoutDiscountCode();
		eventCriteriaPage = personalDetailsPage.enterDetails(personalData);
		eventCriteriaPage.eventLinkPage();
		merchandiseDetailsPage = eventCriteriaPage.enterEventDetails(eventCriteriaData);
		orderSummaryPage = merchandiseDetailsPage.enterMerchandiseDetails(MerchandiseData);
		paymentsOptionPage = orderSummaryPage.enterGstDetails(gstData);
		paymentsOptionPage.makePayment(PaymentsData);

	}

	// ---------------------------------------All sheet data provider IN USE --------------------------------//

	@DataProvider(name = "fullFlowData")
	public Object[][] fullFlowData() {
		
		String registrationFile=prop.getProperty("tmm.registration.excel.path");

		//String registrationFile = "src/test/resources/testdata/RegistrationData_TMM.xlsx";
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
			Map<String, String> personalData = ExcelUtils.getTestData(registrationFile, personalSheet, i);
			Map<String, String> eventCriteriaData = ExcelUtils.getTestData(registrationFile, eventCriteriaSheet, i);
			Map<String, String> merchandiseData = ExcelUtils.getTestData(registrationFile, merchandiseSheet, i);
			Map<String, String> gstData = ExcelUtils.getTestData(registrationFile, gstSheet, i);
			Map<String, String> PaymentsData = ExcelUtils.getTestData(registrationFile, paymentsSheet, i);

			list.add(new Object[] { loginData, eventDashboardData, personalData, eventCriteriaData, merchandiseData,
					gstData, PaymentsData });

		}
		return list.toArray(new Object[0][]);
	}

	// ----------------------------------------Login data provider NOT IN USE -----------------------------------//
	// @DataProvider(name = "loginData")
	public Object[][] loginData() {
		String filePath = "src/test/resources/testdata/LoginData.xlsx";
		String sheetName = "login";
		int rowCount = ExcelUtils.getRowCount(filePath, sheetName);

		Object[][] data = new Object[rowCount][1];
		for (int i = 1; i <= rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getTestData(filePath, sheetName, i);
		}
		return data;
	}

	// ------------------------------------Personal Details data provider NOT IN USE -----------------------------------//
	public void personalDetailsDataDrivenTest() {
		String filePath = "src/test/resources/testdata/PersonalDetails.xlsx";
		for (int i = 1; i < 2; i++) {
			Map<String, String> testData = ExcelUtils.getTestData(filePath, "users", i);
			PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
			// personalDetailsPage.enterDetails(testData);
		}
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
