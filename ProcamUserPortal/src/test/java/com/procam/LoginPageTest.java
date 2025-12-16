package com.procam;

import java.util.HashMap;
import java.util.Map;

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
	public void verifyLogin(Map<String, String> loginData, Map<String, String> personalData) throws InterruptedException {
		loginPage = new LoginPage();
		eventDashboardPage = loginPage.loginByEmail(loginData);
		discountApplyPage = eventDashboardPage.selectEvent();
		// personalDetailsPage=discountApplyPage.withDiscountCode();
		personalDetailsPage = discountApplyPage.withoutDiscountCode();
		eventCriteriaPage = personalDetailsPage.enterDetails(personalData);
		merchandiseDetailsPage = eventCriteriaPage.enterEventDetails();
		orderSummaryPage = merchandiseDetailsPage.enterMerchandiseDetails();
		paymentsOptionPage = orderSummaryPage.enterGstDetails();
		paymentsOptionPage.makePayment();

	}

	@DataProvider(name = "fullFlowData")
	public Object[][] fullFlowData() {

		String loginFile  = "src/test/resources/testdata/LoginData.xlsx";
		String personalFile  = "src/test/resources/testdata/PersonalDetails.xlsx";
		String sheetName = "users";

		int rowCount = ExcelUtils.getRowCount(loginFile, sheetName);

		Object[][] data = new Object[rowCount][2];

		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> loginData = ExcelUtils.getTestData(loginFile, sheetName, i);
			Map<String, String> personalData = ExcelUtils.getTestData(personalFile, sheetName, i);
			
			data[i - 1][0] = loginData;
			data[i - 1][1] = personalData;
		}
		return data;
	}
	
	
	
	//@DataProvider(name = "loginData")
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

	public void personalDetailsDataDrivenTest() {
		String filePath = "src/test/resources/testdata/PersonalDetails.xlsx";
		for (int i = 1; i < 2; i++) {
			Map<String, String> testData = ExcelUtils.getTestData(filePath, "users", i);
			PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
			personalDetailsPage.enterDetails(testData);
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
