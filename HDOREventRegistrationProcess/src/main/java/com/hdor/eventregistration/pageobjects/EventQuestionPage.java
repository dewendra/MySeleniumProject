package com.hdor.eventregistration.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventQuestionPage extends BaseClass{
	Action action = new Action();
	
	
	
	public EventQuestionPage() {
		PageFactory.initElements(driver, this);
	}
}
