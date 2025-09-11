package com.yatra.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yatra.actionDriver.Action;
import com.yatra.baseClass.BaseClass;

public class IndexPage extends BaseClass {
	Action action = new Action();

	// Here we locating the web elements of the index page...
	@FindBy(xpath = "//div[contains(@class,'style_popup')]")
	private WebElement yatraPopup;
	
	@FindBy(xpath = "//img[@alt='cross']")
	private WebElement yatraPopupCloseBtn;

	@FindBy(xpath = "//img[@aria-label='Yatra Logo']")
	private WebElement yatraLogo;

	@FindBy(xpath = "//div[@aria-label='Departure Date inputbox' and @role='button']")
	private WebElement btnDepartureDate;

	@FindBy(xpath = "//div[@class='react-datepicker__month']")
	private List<WebElement> calanderMonthsList;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	public boolean validateLogo() {

		try {
			wait.until(ExpectedConditions.visibilityOf(yatraPopup));
			action.click(getDriver(), yatraPopupCloseBtn);
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Timeout exception....");
		}

		boolean result = action.isDisplayed(getDriver(), yatraLogo);
		return result;

	}

	public void clickOnDepartureDate() {

		wait.until(ExpectedConditions.elementToBeClickable(btnDepartureDate));
		action.click(getDriver(), btnDepartureDate);

		WebElement currentMonthWebElement = selectTheMonthFromTheCalander(0);// current month
		WebElement nextMonthWebElement = selectTheMonthFromTheCalander(1);// next month

		String currentMonth_lowest_price = getLowestPrice(currentMonthWebElement);
		String nextMonth_lowest_price = getLowestPrice(nextMonthWebElement);

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println(currentMonth_lowest_price);
		System.out.println(nextMonth_lowest_price);

		System.out.println("-------------------------------------------------------------------------------");

		compareTwoMonthPrice(currentMonth_lowest_price, nextMonth_lowest_price);

	}

	public static void compareTwoMonthPrice(String currentMonth_lowest_price, String nextMonth_lowest_price) {

		int currentMonthRSIndex = currentMonth_lowest_price.indexOf("Rs");
		int nextMonthRSIndex = nextMonth_lowest_price.indexOf("Rs");
		System.out.println(currentMonthRSIndex);
		System.out.println(nextMonthRSIndex);
		String currentMonthPrice = currentMonth_lowest_price.substring(currentMonthRSIndex + 2);
		String nextMonthPrice = nextMonth_lowest_price.substring(nextMonthRSIndex + 2);

		int currentPrice = Integer.parseInt(currentMonthPrice);
		int nextPrice = Integer.parseInt(nextMonthPrice);

		System.out.println(currentPrice);
		System.out.println(nextPrice);
		if (currentPrice < nextPrice) {
			System.out.println("The lowest price of the two month is : " + currentPrice);
		} else {
			System.out.println("The lowest price of the two month is : " + nextPrice);
		}

	}

	public WebElement selectTheMonthFromTheCalander(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(calanderMonthsList));
		System.out.println("No. of months visible: " + calanderMonthsList.size());
		WebElement calanderMonthWebElement = calanderMonthsList.get(index);
		return calanderMonthWebElement;

	}

	public String getLowestPrice(WebElement monthWebElement) {
		List<WebElement> currentMonthDatePrice = monthWebElement
				.findElements(By.xpath(".//span[contains(@class, 'custom-day-content')]"));

		int lowest_price = Integer.MAX_VALUE;
		WebElement pricWebElement = null;
		for (WebElement price : currentMonthDatePrice) {

			String priceString = price.getText();
			if (priceString.length() > 0) {
				String priceList = priceString.replaceAll("[₹,]", "");
				System.out.println(priceList);

				int amount = Integer.parseInt(priceList);

				if (amount < lowest_price) {
					lowest_price = amount;
					pricWebElement = price;
				}
			}
		}
		WebElement dateWebElement = pricWebElement.findElement(By.xpath(".//../.."));
		// System.out.println(dateWebElement.getAttribute("aria-label"));
		String result = dateWebElement.getAttribute("aria-label") + "---Price is Rs" + lowest_price;
		return result;
	}

}
