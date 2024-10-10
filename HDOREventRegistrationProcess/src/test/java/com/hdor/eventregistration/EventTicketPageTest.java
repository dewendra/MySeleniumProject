package com.hdor.eventregistration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdor.eventregistration.base.BaseClass;
import com.hdor.eventregistration.pageobjects.EventDescriptionPage;
import com.hdor.eventregistration.pageobjects.EventQuestionPage;
import com.hdor.eventregistration.pageobjects.EventTicketPage;
import com.hdor.eventregistration.pageobjects.HomePage;

public class EventTicketPageTest extends BaseClass{
	HomePage homePage;
	EventDescriptionPage eventDescriptionPage;
	EventTicketPage eventTicketPage;
	EventQuestionPage eventQuestionPage;
	
	@BeforeMethod()
	public void setup() {
		launchApp();
	}

	/*
	 * @AfterMethod() public void tearDown() { driver.quit(); }
	 */
	
	@Test
	public void verifySelectTicket() throws Throwable {
		homePage = new HomePage();
		eventDescriptionPage=homePage.clickOnRegisterButton();
		eventTicketPage=eventDescriptionPage.clickOnBuyNowButton();
		eventTicketPage.registrationOnlyTicket();
		eventQuestionPage=eventTicketPage.clickOnNext();
		
		
	}

}
