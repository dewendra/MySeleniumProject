package com.hdorRegistrationProcess;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.DashboardPage;
import com.hdorRegistrationProcess.pageobjects.HomePage;
import com.hdorRegistrationProcess.pageobjects.LoginPage;

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
		homePage = new HomePage();
		loginPage=new LoginPage();
		homePage.emailLogin(prop.getProperty("username"));
		dashboardPage=loginPage.passwordLogin(prop.getProperty("password"));
		System.out.println("Successfully Logged in");
		
	}

}
