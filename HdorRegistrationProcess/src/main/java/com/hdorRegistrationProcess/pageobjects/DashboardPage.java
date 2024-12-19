package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class DashboardPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//div[@class='MuiBox-root css-0' and contains(.,'Active Events')]")
	private WebElement activeEvents;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-0' and contains(.,'Completed Events')]")
	private WebElement completedEvents;

	@FindBy(xpath = "//h6[text()='Tour De 100 2024']")
	private WebElement Tour_De_100_2024;
	
	@FindBy(xpath = "//div//h6[@class='MuiTypography-root MuiTypography-subtitle1 css-1q0u4w1']")
	private WebElement allEventsList;
	
	@FindBy(xpath = "//h6[normalize-space()='Shriram One - Mission Health']")
	private WebElement Shriram_One;
	//h6[normalize-space()='Shriram One - Mission Health']
	
	@FindBy(xpath = "//h6[text()='India Gate to Gateway of India Run Challenge 2024']")
	private WebElement IG2GI_2024;

	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	/*
	 * public void getAllEventsList() {
	 * allEvents=action.getDriver().findElements(By.xpath("allEventsList")); }
	 */
	
	public SelectedEventDashboardPage clickOnEvent() throws InterruptedException {
		//Thread.sleep(3000);
		action.click(getDriver(), Shriram_One);
		System.out.println(" Event Shriram_One selected");
		return new SelectedEventDashboardPage();
	}

}
