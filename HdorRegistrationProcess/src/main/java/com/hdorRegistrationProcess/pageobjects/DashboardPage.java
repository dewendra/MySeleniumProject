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

	@FindBy(xpath = "//h6[text()='Tour De 100 2024']")
	private WebElement Tour_De_100_2024;
	
	
	
	@FindBy(xpath = "//h6[text()='India Gate to Gateway of India Run Challenge 2024']")
	private WebElement IG2GI_2024;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SelectedEventPage clickOnEvent() {
		action.click(driver, Tour_De_100_2024);
		System.out.println(" Event Tour_De_100_2024 selected");
		return new SelectedEventPage();
	}

}
