package com.hdor.eventregistration.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdor.eventregistration.actiondriver.Action;
import com.hdor.eventregistration.base.BaseClass;

public class EventTicketPage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[@class='MuiCardContent-root css-1hchkfb']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[2]")
	private WebElement ticketCount;
	
	
	@FindBy(xpath = "//div[contains(@class,'MuiCardContent-root')]//div[contains(@class,'MuiTypography-root MuiTypography-subtitle1 css-nodm54')]")
	private WebElement totalTicketCounts;
	
	
	
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-4px10r']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//*[name()='svg']")
	private WebElement removeButton1;
	
	/*
	 * @FindBy(xpath = "//button[contains(text(),'Next')]") private WebElement
	 * nextButton;
	 */
	@FindBy(xpath = "(//*[name()='path'])[3]")
	private WebElement addButton;
	
	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-1m9kp0'])[1]")
	private WebElement removeButton;
	
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Next'])[1]")
	private WebElement nextButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='EUR'])[1]")
	private WebElement topEURButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='GBP'])[1]")
	private WebElement topGBPButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='INR'])[1]")
	private WebElement topINRButton;
	@FindBy(xpath="(//button[@type='button'][normalize-space()='USD'])[1]")
	private WebElement topUSDButton;
	@FindBy(xpath="//div[contains(text(),'Apply Coupon')]")
	private WebElement applyCoupon;
	
	@FindBy(xpath="//input[@id=':rm:']")
	private WebElement discountCoupon;
	@FindBy(xpath="//button[normalize-space()='Apply']")
	private WebElement discountCouponApplyButton;
	@FindBy(xpath="(//*[name()='path'])[61]")
	private WebElement discountCouponPopUpCloseButton;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-k008qs'])[1]")
	private WebElement entryOnlyTicket;
	
	
	
	
	public EventTicketPage() {
		PageFactory.initElements(driver, this);
	}
	public void totalTicket() {
		List<WebElement> totalTickets=driver.findElements(By.xpath("totalTicketCounts"));
		for(int i=0; i<=totalTickets.size(); i++) {
			System.out.println(totalTickets.get(i).getText());
		}
	}
	
	public void registrationOnlyTicket() {
		action.fluentWait(driver, addButton, 2);
		action.click(driver, addButton);
		
		action.click(driver, nextButton);
	}
	public EventQuestionPage clickOnNext() {
		action.fluentWait(driver, nextButton, 2);
		action.click(driver, nextButton);
		System.out.println("Next Button clicked");
		return new EventQuestionPage();
		
	}
}
