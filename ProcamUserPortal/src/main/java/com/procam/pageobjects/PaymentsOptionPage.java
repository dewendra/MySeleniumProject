package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class PaymentsOptionPage extends BaseClass {

	private WebDriver driver;
	WebDriverWait wait;

	// @FindBy(xpath = "//div[@data-value]")
	// private List<WebElement> allPaymentOptions;

	public PaymentsOptionPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void makePayment(Map<String, String> data) {
		waitThread(10000);
		Logs.info("Reached on Payment Page....");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		try {

			// Step 1: wait for Razorpay iframe to be PRESENT in DOM
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.razorpay-checkout-frame")));
			Logs.info("Razorpay iframe present in DOM");

			// Step 2: wait for iframe to be VISIBLE
			WebElement razorpayFrame = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.razorpay-checkout-frame")));
			Logs.info("Razorpay iframe visible");

			// Step 3: switch to iframe
			DriverFactory.getDriver().switchTo().frame(razorpayFrame);
			Logs.info("Switched to Razorpay iframe successfully");

			// Step 4: wait for payment options
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@data-value]")));
			Logs.info("Payment options loaded");

			// Step 5: select payment option
			allPaymentOptions(data.get("paymentOption"));

			if (data.get("paymentOption").equalsIgnoreCase("netbanking")) {
				Logs.info("Wating for the loading the Netbanking Bank options");
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='upi-options']")));
				Logs.info("Calling the selectNetbankingBank method");
				selectNetbankingBank(data.get("NetBank"));
				//selectNetbankingBank2(data.get("NetBank"));
			}
		} catch (Exception e) {
			throw new RuntimeException("Razorpay iframe did not load in time", e);
		}
	}

	private void selectNetbankingBank(String bankName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait for netbank section
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='upi-options']")));

		// Fetch all bank tiles
		List<WebElement> allBanks = driver.findElements(By.cssSelector("label div[data-value]"));
		Logs.info("Banks found: " + allBanks.size());

		for (WebElement bank : allBanks) {
			System.out.println(" → "+bank.getAttribute("data-value"));
		}

		for (WebElement bank : allBanks) {
			String value = bank.getAttribute("data-value").trim();
			String text = bank.getText().trim();
			System.out.println("Candidate -> Value: " + value + " | Visible: " + text);
			if (text.equalsIgnoreCase(bankName) || value.equalsIgnoreCase(bankName)) {
				// scroll to center
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", bank);
				wait.until(ExpectedConditions.elementToBeClickable(bank)).click();
				return;
			}
		}
		throw new RuntimeException("Bank not found: " + bankName);

	}
	private void selectNetbankingBank2(String bankName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	    Logs.info("Selecting Netbanking bank: " + bankName);

	    // Locate via visible text
	    By bankLocator = By.xpath("//*[contains(@role,'button')]//*[contains(text(),'" + bankName + "')]/ancestor::label");

	    WebElement bankElement = wait.until(ExpectedConditions.elementToBeClickable(bankLocator));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", bankElement);
	    bankElement.click();

	    Logs.info("Bank selected: " + bankName);
	}

	public void allPaymentOptions(String paymentOptionToSelect) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List<WebElement> paymentOptions = driver.findElements(By.xpath("//div[@data-value]"));
		System.out.println("All payment options : " + paymentOptions.size());

		for (WebElement paymentOption : paymentOptions) {

			String paymentType = paymentOption.getAttribute("data-value");
			String paymentText = paymentOption.getText().trim();

			System.out.println("Payment Type: " + paymentType);
			System.out.println("Payment Text: " + paymentText);
			System.out.println("--------------------------");

		}
		for (WebElement paymentOption : paymentOptions) {
			String paymentType = paymentOption.getAttribute("data-value");
			String paymentText = paymentOption.getText().trim();

			if (paymentType.equalsIgnoreCase(paymentOptionToSelect.toLowerCase())
					|| paymentText.equalsIgnoreCase(paymentOptionToSelect.toLowerCase())) {
				// Scroll into view (important for Razorpay)
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
						paymentOption);
				wait.until(ExpectedConditions.elementToBeClickable(paymentOption)).click();
				// paymentOption.click();
				System.out.println("Selected payment option: " + paymentOptionToSelect);
				return;
			}

		}
		throw new RuntimeException("Payment option not found: " + paymentOptionToSelect);

	}

	private void waitThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollElementInToTop(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start', inline:'nearest'});",
				element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
				element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'end', inline:'nearest'});",
				element);
	}

}
