package com.hdor.eventregistration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdor.eventregistration.base.BaseClass;
import com.hdor.eventregistration.pageobjects.DashBoardPage;
import com.hdor.eventregistration.pageobjects.EventDescriptionPage;
import com.hdor.eventregistration.pageobjects.EventQuestionPage;
import com.hdor.eventregistration.pageobjects.EventTicketPage;
import com.hdor.eventregistration.pageobjects.ExploreEventPage;
import com.hdor.eventregistration.pageobjects.HomePage;
import com.hdor.eventregistration.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	ExploreEventPage exploreEventPage;
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
	
	/*
	 * public void verifiyRegistrationCardBanner() throws Throwable { homePage = new
	 * HomePage(); boolean result = homePage.validateRegistrationCardBanner();
	 * Assert.assertTrue(result); }
	 */
	//@Test
	public void verifyRegister() throws Throwable {
		homePage = new HomePage();
		//homePage.findElement();
		eventDescriptionPage=homePage.clickOnRegisterButton();
		eventTicketPage=eventDescriptionPage.clickOnBuyNowButton();
		//eventTicketPage=eventQuestionPage.registrationOnlyTicket();
		eventQuestionPage.enterParticipantsDetails();
		
	}
	@Test
	public void verifiyLogin() throws Throwable {
		loginPage=new LoginPage();
		dashBoardPage=loginPage.loginUser();
		exploreEventPage=dashBoardPage.exploreEvents();
		eventDescriptionPage=exploreEventPage.clickOnRegisterButton();
		eventTicketPage=eventDescriptionPage.clickOnBuyNowButton();
		eventQuestionPage=eventTicketPage.registrationOnlyTicket();
		eventQuestionPage.enterParticipantsDetails();
	}


}
