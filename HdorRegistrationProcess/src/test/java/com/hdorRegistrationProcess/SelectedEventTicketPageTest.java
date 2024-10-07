package com.hdorRegistrationProcess;

import org.testng.annotations.BeforeMethod;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.pageobjects.EventsPage;
import com.hdorRegistrationProcess.pageobjects.SelectedEventPage;

public class SelectedEventTicketPageTest extends BaseClass {
	EventsPage eventsPage;
	SelectedEventPage selectedEventPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	

}
