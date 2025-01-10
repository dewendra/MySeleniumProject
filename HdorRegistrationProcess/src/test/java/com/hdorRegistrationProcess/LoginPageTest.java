package com.hdorRegistrationProcess;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.DashboardPage;
import com.hdorRegistrationProcess.pageobjects.DownloadCertificatePage;
import com.hdorRegistrationProcess.pageobjects.EventsMappedActivities;
import com.hdorRegistrationProcess.pageobjects.HomePage;
import com.hdorRegistrationProcess.pageobjects.LoginPage;
import com.hdorRegistrationProcess.pageobjects.SelectedEventDashboardPage;
import com.hdorRegistrationProcess.pageobjects.UserSettingPage;
import com.hdorRegistrationProcess.utility.Log;

public class LoginPageTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SelectedEventDashboardPage selectedEventDashboardPage;
	EventsMappedActivities eventsMappedActivities;
	UserSettingPage userSettingPage;
	DownloadCertificatePage downloadCertificatePage;
	
	
	@BeforeMethod()
	public void setup() {
		launchApp();
	}

	/*
	 * @AfterMethod() public void tearDown() { driver.quit(); }
	 */
	
	@Test
	public void verifyLogin() throws Throwable {
		Log.startTestCase("verifyLogin");
		homePage = new HomePage();
		loginPage=new LoginPage();
		homePage.emailLogin(prop.getProperty("username"));
		Log.info("User entered the username or email id");
		dashboardPage=loginPage.passwordLogin(prop.getProperty("password"));
		userSettingPage=dashboardPage.forDownloadCertificate();
		downloadCertificatePage=userSettingPage.clickOnBannerAndCertificate();
		downloadCertificatePage.clickedOnCertifacateButton();
		downloadCertificatePage.gettingAllEventsName();
		//selectedEventDashboardPage=dashboardPage.clickOnEvent();
		//selectedEventDashboardPage.printWebElementList();
		//selectedEventDashboardPage.validateOverallStats();
		//eventsMappedActivities=selectedEventDashboardPage.verifyMappedActivities();
		//eventsMappedActivities.printWebElementList();
		Log.info("User entered the password");
		Log.info("Successfully Logged in HDOR app");
		Log.endTestCase("verifyLogin");
		
	}

}
