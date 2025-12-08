package com.procam.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class DiscountApplyPage extends BaseClass {
	private Action action;
	WaitHelper wait;

	@FindBy(xpath = "//div[contains(@class,'fs-3')]//span[contains(@class,'btn-fa-color')]")
	private WebElement backBtn;

	@FindBy(xpath = "//a[contains(text(),'Read More')]")
	private WebElement read_More;

	@FindBy(xpath = "//input[@id='flexRadioDefault1']")
	private WebElement yesRadioBtn;

	@FindBy(xpath = "//input[@id='flexRadioDefault2']")
	private WebElement noRadioBtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	private WebElement proceedBtn;

	@FindBy(xpath = "//input[@id='discountCode']")
	private WebElement discountCode;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	private WebElement applyBtn;

	public DiscountApplyPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	public void readMore() {
		wait.waitForVisible(read_More);
		Logs.info("Clicking Read More");
		action.click(driver, read_More);
	}

	public PersonalDetailsPage withDiscountCode() {
		Logs.info("Clicking yesRadioBtn");
		wait.waitForVisible(yesRadioBtn).click();
		wait.waitForVisible(discountCode);
		discountCode.clear();
		Logs.info("Applying Discount Code");
		discountCode.sendKeys("123456");
		wait.waitForClickable(applyBtn);
		Logs.info("Clicking applyBtn");
		applyBtn.click();
		wait.waitForClickable(proceedBtn);
		Logs.info("Clicking proceedBtn");
		proceedBtn.click();
		return new PersonalDetailsPage();
	}

	public PersonalDetailsPage withoutDiscountCode() {
		Logs.info("Clicking noRadioBtn");
		wait.waitForVisible(noRadioBtn);
		wait.waitForClickable(proceedBtn);
		Logs.info("Clicking proceedBtn");
		proceedBtn.click();
		return new PersonalDetailsPage();
	}
}
