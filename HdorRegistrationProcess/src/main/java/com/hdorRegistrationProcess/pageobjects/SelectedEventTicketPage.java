package com.hdorRegistrationProcess.pageobjects;

import com.hdorRegistrationProcess.base.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;

public class SelectedEventTicketPage extends BaseClass {
	Action action= new Action();
	
	@FindBy(xpath = "//div[text()='Registration']")
	private WebElement onlyRegistration;
	
	@FindBy(xpath = "//div[text()='Entry with Jersey']")
	private WebElement entryWithJersey;
	
	@FindBy(xpath = "//div[text()='Entry with Medal']")
	private WebElement entryWithMedal;

	@FindBy(xpath = "//div[text()='Entry with Medal and Jersey']")
	private WebElement entryWithMedalAndJersey;
	
	@FindBy(xpath = "//div[text()='Entry with Medal and T-shirt']")
	private WebElement entryWithMedalAndTshirt;
	
	@FindBy(xpath = "//div[text()='Entry with T-shirt']")
	private WebElement entryWithTshirt;
	
	@FindBy(xpath = "//div[text()='Jersey']")
	private WebElement onlyJersey;
	
	@FindBy(xpath = "//div[text()='Medal']")
	private WebElement onlyMedal;
	
	@FindBy(xpath = "//div[text()='T-Shirt']")
	private WebElement onlyTshirt;
	
	@FindBy(xpath = "//*[@id=\"ticketingRoot\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/svg")
	private WebElement removeButton;
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[@class='MuiCardContent-root css-1hchkfb']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[3]//div[1]//*[name()='svg']")
	private WebElement addButton;
	
	
	public SelectedEventTicketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void buyTicket() {
		String countTemp=addButton.getText();
		System.out.println("countTemp"+countTemp);
		action.click(driver, addButton);
		String countAfter=addButton.getText();
		System.out.println("countAfter"+countAfter);
		
	}
	
	
	
	
}
