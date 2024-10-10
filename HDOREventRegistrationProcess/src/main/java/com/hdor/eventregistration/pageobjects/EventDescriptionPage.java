package com.hdor.eventregistration.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventDescriptionPage extends BaseClass{
	Action action = new Action();
	
	
	
	public EventDescriptionPage() {
		PageFactory.initElements(driver, this);
	}
}
