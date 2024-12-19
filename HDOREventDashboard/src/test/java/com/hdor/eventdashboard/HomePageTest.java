package com.hdor.eventdashboard;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdor.eventdashboard.base.BaseClass;
import com.hdor.eventdashboard.pageobjects.HomePage;
import com.hdor.eventdashboard.pageobjects.LoginPage;
import com.hdor.eventdashboard.utility.Log;



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
	
	public void verifyLogin() throws Throwable {
		Log.startTestCase("verifyLogin");
		homePage = new HomePage();
		loginPage=homePage.emailLogin(prop.getProperty("username"));
		Log.info("User entered the username or email id");    
		
		
	}

}
