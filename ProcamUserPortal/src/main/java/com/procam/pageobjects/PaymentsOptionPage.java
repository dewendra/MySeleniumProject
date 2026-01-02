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
	WaitHelper wait;

	//@FindBy(xpath = "//div[@data-value]")
	//private List<WebElement> allPaymentOptions;

	public PaymentsOptionPage() {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
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
		} catch (Exception e) {
			throw new RuntimeException("Razorpay iframe did not load in time", e);
		}
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

			if (paymentType.equalsIgnoreCase(paymentOptionToSelect.toLowerCase()) || paymentText.equalsIgnoreCase(paymentOptionToSelect.toLowerCase())) {
				// Scroll into view (important for Razorpay)
				((JavascriptExecutor) driver)
						.executeScript("arguments[0].scrollIntoView({block:'center'});", paymentOption);
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
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block: 'start', inline:'nearest'});", element);
	}

	public void scrollElementInToView(WebElement element) {
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
	}

	public void scrollElementInToEnd(WebElement element) {
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block: 'end', inline:'nearest'});", element);
	}

}
