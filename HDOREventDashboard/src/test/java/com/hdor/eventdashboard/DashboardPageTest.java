package com.hdor.eventdashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdor.eventdashboard.base.BaseClass;
import com.hdor.eventdashboard.pageobjects.DashboardPage;
import com.hdor.eventdashboard.pageobjects.HomePage;
import com.hdor.eventdashboard.pageobjects.LoginPage;

public class DashboardPageTest extends BaseClass {
	private HomePage homePage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	//private SelectedEventPage selectedEventPage;
	
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
		//selectedEventPage=dashboardPage.clickOnEvent();
	}

}
