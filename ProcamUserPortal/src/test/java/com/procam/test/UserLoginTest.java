package com.procam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.procam.base.BaseClass;
import com.procam.pageobjects.LoginPage;
import com.procam.utils.ExcelUtils;
import com.procam.utils.ExtentReportsManager;

@Listeners(ExtentReportsManager.class)
public class UserLoginTest extends BaseClass {
	private static final Logger log = LogManager.getLogger(UserLoginTest.class);
	private LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		log.info("=========Test Started===========");
		launchApp();
	}

	@Test(dataProvider = "loginData")
	public void verifyLogin(Map<String, String> loginData) throws InterruptedException {
		loginPage = new LoginPage();

		loginPage.loginByEmail(loginData);
		ExtentReportsManager.getTest().info("Login successful");
		
		Thread.sleep(5000);
		loginPage.contactDetails();
		ExtentReportsManager.getTest().info("Contact details completed");

		Thread.sleep(5000);
		loginPage.policyDetails();
		ExtentReportsManager.getTest().info("Policy verified");
		
		Thread.sleep(5000);
		loginPage.doingLogout();
		ExtentReportsManager.getTest().info("Logout completed");
	}

	//@Test(dependsOnMethods = { "verifyLogin" })
	public void verifyContactDetails() {
		loginPage.contactDetails();
		ExtentReportsManager.getTest().info("Contact details completed");
	}

	//@Test(dependsOnMethods = { "verifyLogin" })
	public void verifyPolicy() throws InterruptedException {
		loginPage.policyDetails();
		ExtentReportsManager.getTest().info("Policy verified");
	}

	//@Test(dependsOnMethods = { "verifyLogin" })
	public void verifyLogout() {
		loginPage.doingLogout();
		ExtentReportsManager.getTest().info("Logout completed");
	}

	@DataProvider(name = "loginData")
	public Object[][] fullFlowData() {
		String inputFile = prop.getProperty("procam.login.excel.path");
		String loginSheet = "users";

		int rowCount = ExcelUtils.getRowCount(inputFile, loginSheet);
		List<Object> list = new ArrayList<Object>();
		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> loginData = ExcelUtils.getTestData(inputFile, loginSheet, i);
			if (loginData == null || loginData.get("emailId") == null || loginData.get("emailId").trim().isEmpty()) {
				continue;
			}
			list.add(new Object[] { loginData });
		}

		return list.toArray(new Object[0][]);

	}

	@AfterMethod
	public void tearDown() {
		log.info("=========Test Finished==========");
		closeApp();
	}

	@AfterSuite
	public void closeSuit() {
		// extentReports.flush();
	}
}
