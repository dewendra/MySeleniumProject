package com.procam.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	WaitHelper wait;

	@FindBy(xpath = "//div[@data-value]")
	private List<WebElement> allPaymentOptions;

	public PaymentsOptionPage() {
		
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait = new WaitHelper(DriverFactory.getDriver());
	}

	
	public void makePayment() {
		Logs.info("Reached on Payment Page....");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		//WebElement razorpayFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.razorpay-checkout-frame")));
		       

		//DriverFactory.getDriver().switchTo().frame(razorpayFrame);

		Logs.info("Switching to Razor pay Page....");
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.razorpay-checkout-frame")));

		Logs.info("Reached on Razor pay Page....");
		Logs.info("Getting all card options which is available....");
		allPaymentOptions("card");
	}

	public void allPaymentOptions(String paymentOptionToSelect) {
		List<WebElement> paymentOptions = DriverFactory.getDriver().findElements(By.xpath("//div[@data-value]"));
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

			if (paymentText.equalsIgnoreCase(paymentOptionToSelect)) {
				// Scroll into view (important for Razorpay)
				((JavascriptExecutor) DriverFactory.getDriver())
						.executeScript("arguments[0].scrollIntoView({block:'center'});", paymentOption);

				paymentOption.click();
				System.out.println("Clicked on: " + paymentOptionToSelect);
				return;
			}

		}
		throw new RuntimeException("Payment option not found: " + paymentOptionToSelect);
		// DriverFactory.getDriver().findElement(By.xpath("//div[@data-value='card']")).click();

	}

}
