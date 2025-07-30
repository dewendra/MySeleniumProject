package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class IndexPage extends BaseClass {

	Action action = new Action();
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	private WebElement amazon_Logo;
	@FindBy(xpath = "//a[@id='nav-global-location-popover-link']")
	private WebElement update_location;
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement search_box;
	@FindBy(xpath = "//div[@id='icp-nav-flyout']")
	private WebElement language_button;
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement account_And_List;
	@FindBy(xpath = "//a[@id='nav-orders']")
	private WebElement returnaAnd_orders;
	@FindBy(xpath = "//a[@id='nav-cart']")
	private WebElement cart_Option;
	@FindBy(xpath = "//div[@id='nav-link-accountList']//a[contains(@class,'nav-progressive-attribute')]")
	private WebElement signIn_option;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateLogo() throws Throwable {
		boolean result = action.isDisplayed(getDriver(), amazon_Logo);
		return result;
	}

	public void clickOnUpadteLocationOption() throws Throwable {
		Thread.sleep(2000);
		action.click(getDriver(), update_location);
		System.out.println("Update Location Option Clicked");
		return;
	}

	public void clickOnSearchBoxOption() throws Throwable {
		Thread.sleep(2000);
		action.click(getDriver(), search_box);
		System.out.println("Search Box Option Clicked");
		return;
	}

	public void clickOnLangageButton() throws Throwable {
		Thread.sleep(2000);
		action.mouseover(getDriver(), language_button);
		System.out.println("Language button Option Selected");
		return;
	}

	public void clickOnAccountAndListOption() throws Throwable {
		Thread.sleep(2000);
		action.mouseover(getDriver(), account_And_List);
		System.out.println("AccountAndList Option Clicked");
		return;
	}
	public void clickOnReturnsAndOrders() throws InterruptedException {
		Thread.sleep(2000);
		action.click(getDriver(), returnaAnd_orders);
		System.out.println("Return And Orders Option Clicked");

	}
	public void clickOnCart() throws InterruptedException {
		Thread.sleep(2000);
		action.click(getDriver(), cart_Option);
		System.out.println("Cart Option Clicked");

	}


	public void clickOnSignInOption() throws InterruptedException {
		Thread.sleep(2000);
		action.click(getDriver(), signIn_option);
		System.out.println("signIn Option Clicked");

	}

}
