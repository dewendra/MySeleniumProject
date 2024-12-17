package com.hdor.eventdashboard;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eventdashboard.base.BaseClass;
import com.eventdashboard.pageobjects.DashboardPage;
import com.eventdashboard.pageobjects.HomePage;
import com.eventdashboard.pageobjects.LoginPage;
import com.eventdashboard.utility.Log;

public class LoginPageTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	
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
		Log.info("User entered the password");
		System.out.println("Successfully Logged in");
		Log.info("Successfully Logged in HDOR app");
		Log.endTestCase("verifyLogin");
		
	}

}
