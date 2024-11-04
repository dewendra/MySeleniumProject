package com.hdorRegistrationProcess;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.DashboardPage;
import com.hdorRegistrationProcess.pageobjects.HomePage;
import com.hdorRegistrationProcess.pageobjects.LoginPage;
import com.hdorRegistrationProcess.utility.Log;

public class EndToEndTest extends BaseClass{

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
