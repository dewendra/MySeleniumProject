package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class DashboardPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h6[text()='Active Events']")
	private WebElement activeEvents;

	@FindBy(xpath = "//button[text()='login']")
	private WebElement loginButton;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

}
