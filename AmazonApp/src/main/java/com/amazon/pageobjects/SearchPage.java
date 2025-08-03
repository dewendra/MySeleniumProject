package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class SearchPage extends BaseClass{
	Action action =new Action();
	@FindBy(xpath = "//span[text()='Intel Core i5']")
	private WebElement select_IntelCorei5; 
	@FindBy(xpath = "//span[text()='16 GB']")
	private WebElement select_Ram16GB;//span[text()='Dell']
	@FindBy(xpath = "//span[text()='Dell']")
	private WebElement select_Dell;
	@FindBy(xpath = "//div[@class='a-row']/a/span[@class='a-price']")
	private WebElement all_priceList;

	
	
	
	public SearchPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectOptions() throws InterruptedException {
		action.click(getDriver(), select_IntelCorei5);
		Thread.sleep(2000);
		action.click(getDriver(), select_Ram16GB);
		Thread.sleep(5000);
		action.click(getDriver(), select_Dell);
	}
}
