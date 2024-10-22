package com.hdorRegistrationProcess;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.DashboardPage;
import com.hdorRegistrationProcess.pageobjects.HomePage;
import com.hdorRegistrationProcess.pageobjects.LoginPage;
import com.hdorRegistrationProcess.pageobjects.SelectedEventPage;

public class DashboardPageTest extends BaseClass {
	private HomePage homePage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private SelectedEventPage selectedEventPage;
	
	@BeforeMethod()
	public void setup() {
		launchApp();
	}

	/*
	 * @AfterMethod() public void tearDown() { driver.quit(); }
	 */
	@Test
	public void verifySelectedEvent() throws Throwable {
		homePage = new HomePage();
		loginPage=new LoginPage();
		homePage.emailLogin(prop.getProperty("username"));
		dashboardPage=loginPage.passwordLogin(prop.getProperty("password"));
		selectedEventPage=dashboardPage.clickOnEvent();
	}

}
