package com.hdorRegistrationProcess;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.EventsPage;
import com.hdorRegistrationProcess.pageobjects.SelectedEventPage;
import com.hdorRegistrationProcess.pageobjects.SelectedEventTicketPage;

public class SelectedEventPageTest extends BaseClass {
	EventsPage eventsPage;
	SelectedEventPage selectedEventPage;
	SelectedEventTicketPage selectedEventTicketPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	@Test
	public void verifyPrice() {
		eventsPage=new EventsPage();
		selectedEventPage=eventsPage.clickOnEventRegistrationButton();
		selectedEventPage.getTicketPrice();
		selectedEventTicketPage=selectedEventPage.clickOnBuyNowButton();
	}
}
