package com.procam.pageobjects;

import java.rmi.server.ExportException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.procam.actiondriver.Action;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class DiscountApplyPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	WaitHelper wait;
	String parentWindow;

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
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}

	public void readMore() {
		parentWindow = driver.getWindowHandle();
		wait.waitForVisible(read_More);
		wait.waitForClickable(read_More);
		Logs.info("Clicking Read More");
		read_More.click();
		// action.click(driver, read_More);
		Logs.info("Clicked on Read More link");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		verifyReadMorePageAndReturn();
		//driver.switchTo().window(parentWindow);
	}

	private void verifyReadMorePageAndReturn() {
		try {
			String newPage_actualTitle = driver.getTitle();
			System.out.println("Read More link Page Title:" + newPage_actualTitle);
			Assert.assertTrue(newPage_actualTitle.contains("Group Applications"),
					"Expected title to contain 'Group Applications' but found: " + newPage_actualTitle);

		} finally {
			// Always clean up even if assertion fails
			driver.close();
			driver.switchTo().window(parentWindow);
			Logs.info("Switched back to parent window");
		}
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
