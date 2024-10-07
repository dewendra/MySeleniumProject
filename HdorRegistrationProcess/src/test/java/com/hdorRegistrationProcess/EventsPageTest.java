package com.hdorRegistrationProcess;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.EventsPage;
import com.hdorRegistrationProcess.pageobjects.SelectedEventPage;

public class EventsPageTest extends BaseClass {
	EventsPage eventsPage;
	SelectedEventPage selectedEventPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
	@Test
	public void verifyEventsPage() {
		eventsPage=new EventsPage();
		selectedEventPage=eventsPage.clickOnEventRegistrationButton();
		
		
	}

}
