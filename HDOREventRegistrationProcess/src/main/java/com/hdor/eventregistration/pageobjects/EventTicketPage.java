package com.hdor.eventregistration.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventTicketPage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[@class='MuiCardContent-root css-1hchkfb']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[2]")
	private WebElement ticketCount;
	
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[@class='MuiCardContent-root css-1hchkfb']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M18 13H6c-')]")
	private WebElement removeButton;
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[@class='MuiCardContent-root css-1hchkfb']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[3]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M18 13h-5v')]")
	private WebElement addButton;
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//*[name()='svg']")
	private WebElement removeButton1;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;
	
	
	public EventTicketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void registrationOnlyTicket() {
		action.fluentWait(driver, addButton, 2);
		action.click(driver, addButton);
	}
	public EventQuestionPage clickOnNext() {
		action.fluentWait(driver, nextButton, 2);
		action.click(driver, nextButton);
		System.out.println("Next Button clicked");
		return new EventQuestionPage();
		
	}
}
