package com.hdorRegistrationProcess;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.HomePage;
import com.hdorRegistrationProcess.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	private HomePage homePage;
	private LoginPage loginPage;

	@BeforeMethod()
	public void setup() {
		launchApp();
	}

	/*
	 * @AfterMethod() public void tearDown() { driver.quit(); }
	 */

	
	public void verifiyLogo() throws Throwable {
		homePage = new HomePage();
		boolean result = homePage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test
	public void verifyLogin() throws Throwable {
		homePage = new HomePage();
		loginPage=homePage.emailLogin(prop.getProperty("username"));
		
		
	}

}
