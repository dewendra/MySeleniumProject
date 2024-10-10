package com.hdor.eventregistration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdor.eventregistration.base.BaseClass;
import com.hdor.eventregistration.pageobjects.EventDescriptionPage;
import com.hdor.eventregistration.pageobjects.EventTicketPage;
import com.hdor.eventregistration.pageobjects.HomePage;

public class EventDescriptionPageTest extends BaseClass{
	HomePage homePage;
	EventDescriptionPage eventDescriptionPage;
	EventTicketPage eventTicketPage;
	
	@BeforeMethod()
	public void setup() {
		launchApp();
	}

	/*
	 * @AfterMethod() public void tearDown() { driver.quit(); }
	 */
	
	public void verifiyRegistrationCardBanner() throws Throwable {
		homePage = new HomePage();
		boolean result = homePage.validateRegistrationCardBanner();
		Assert.assertTrue(result);
	}
	@Test
	public void verifyBuyNow() throws Throwable {
		homePage = new HomePage();
		eventDescriptionPage=homePage.clickOnRegisterButton();
		eventTicketPage=eventDescriptionPage.clickOnBuyNowButton();
		
		
	}

}
