package com.hdorRegistrationProcess.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.base.BaseClass;
import com.hdorRegistrationProcess.actiondriver.Action;

public class SelectedEventPage extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath = "//div[contains(text(),'Tour De 100 2024')]")
	private WebElement tourDe1002024;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1dhed5q']//div[@class='MuiBox-root css-k008qs']")
	private WebElement price;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1dhed5q']//button[@type='button'][normalize-space()='INR']")
	private WebElement INR;
	@FindBy(xpath = "//div[@class='MuiBox-root css-1dhed5q']//button[@type='button'][normalize-space()='EUR']")
	private WebElement EUR;
	@FindBy(xpath = "//div[@class='MuiBox-root css-1dhed5q']//button[@type='button'][normalize-space()='GBP']")
	private WebElement GBP;
	@FindBy(xpath = "//div[@class='MuiBox-root css-1dhed5q']//button[@type='button'][normalize-space()='USD']")
	private WebElement USD;
	
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1dhed5q']//button[@type='button'][normalize-space()='Buy Now']")
	private WebElement BuyNow;
	//div//h6[@class='MuiTypography-root MuiTypography-subtitle1 css-1q0u4w1']
	
	public SelectedEventPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public int getTicketPrice() {
		action.fluentWait(getDriver(), price, 2);
		String priceTemp=price.getText();
		String price=priceTemp.replaceAll("[^a-zA-Z0-9]","");
		int finalprice=Integer.parseInt(price);
		System.out.println("Price :"+finalprice);
		return finalprice;
	}
	public SelectedEventTicketPage clickOnBuyNowButton() {
		action.click(getDriver(), BuyNow);
		return new SelectedEventTicketPage();
	}
	/*
	 * public int buyTicket() { action.click(driver, BuyNow);
	 * 
	 * }
	 */

}
