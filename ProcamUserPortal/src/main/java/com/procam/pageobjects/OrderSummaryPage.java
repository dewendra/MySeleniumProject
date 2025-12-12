package com.procam.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.WaitHelper;

public class OrderSummaryPage extends BaseClass {

	WaitHelper wait;

	@FindBy(xpath = "//input[@id='gstbox1']")
	private WebElement gstOptionYes;

	@FindBy(xpath = "//input[@id='gstbox2']")
	private WebElement gstOptionNo;

	@FindBy(xpath = "//input[@name='gstNum']")
	private WebElement gstNumber;

	@FindBy(xpath = "//input[@formcontrolname='gstName']")
	private WebElement gstName;

	@FindBy(xpath = "//input[@formcontrolname='waiver']")
	private WebElement waiver1;

	@FindBy(xpath = "//input[@formcontrolname='waiver2']")
	private WebElement waiver2;

	@FindBy(xpath = "//input[@formcontrolname='waiver4']")
	private WebElement waiver4;

	@FindBy(xpath = "//input[@formcontrolname='waiver5']")
	private WebElement waiver5;

	@FindBy(xpath = "//input[@formcontrolname='waiver3']")
	private WebElement waiver3;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Back']")
	private WebElement downBackBtn;

	@FindBy(xpath = "//button[@type='submit' and normalize-space()='Proceed']")
	private WebElement proceedBtn;

	public OrderSummaryPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public  OrderSummaryPage enterGstDetails() {
		wait.waitForVisible(gstOptionYes);
		wait.waitForClickable(gstOptionYes);
		gstOptionYes.click();

		wait.waitForVisible(gstNumber);
		wait.waitForClickable(gstNumber);
		gstNumber.sendKeys("21PIHUF2222F9Z4");
		

		wait.waitForVisible(gstName);
		wait.waitForClickable(gstName);
		gstName.sendKeys("Pihu Five Traders");
	
		wait.waitForClickable(waiver1);
		waiver1.click();
		
		wait.waitForClickable(waiver2);
		waiver2.click();
		
		wait.waitForClickable(waiver4);
		waiver4.click();
		
		wait.waitForClickable(waiver5);
		waiver5.click();
		
		wait.waitForClickable(waiver3);
		waiver3.click();
		
		wait.waitForVisible(proceedBtn);
		wait.waitForClickable(proceedBtn);
		proceedBtn.click();
		
		
		
		return new OrderSummaryPage();
	}

}
