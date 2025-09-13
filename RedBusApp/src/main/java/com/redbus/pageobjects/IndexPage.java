package com.redbus.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.actiondriver.Action;
import com.redbus.base.BaseClass;

public class IndexPage extends BaseClass {

	Action action = new Action();
	WebDriverWait wait;

	// Locating the web elements
	@FindBy(xpath = "//img[@title='redBus']")
	private WebElement redbus_Logo;

	@FindBy(xpath = "//div[normalize-space()='From']")
	private WebElement from;

	@FindBy(xpath = "//div[contains(@class,'suggestionsWrapper')]")
	private WebElement searchBox;

	@FindBy(xpath = "//div[contains(@class,'searchCategory')]")
	List<WebElement> searchBoxCategory;

	@FindBy(xpath = "//div[contains(@Class,'listHeader')]")
	List<WebElement> suggestedLocationList;

	@FindBy(xpath = "//img[@title='redBus']")
	private WebElement to;

	@FindBy(xpath = "//button[contains(@class,'primaryButton')]")
	private WebElement searchBusBtn;

	@FindBy(xpath = "//div[contains(text(),'Primo Bus')]")
	private WebElement primoBusBtn;

	@FindBy(xpath = "//div[contains(text(),'NONAC')]")
	private WebElement nonACBtn;

	@FindBy(xpath = "//div[contains(text(),'18:00-24:00')]")
	private WebElement eveningTimeBtn;

	@FindBy(xpath = "//div[contains(@class,'sectionWrapper')]/ul/li")
	List<WebElement> suggestedBusList;

	@FindBy(xpath = "//li[contains(@class,'tupleWrapper')]")
	List<WebElement> numberOfBusListed;

	@FindBy(xpath = "//span[contains(@class,'subtitle')]")
	private WebElement noOfBusCount;

	@FindBy(xpath = "//div[contains(@class,'travelsName')]")
	private WebElement nameOfBus;

	@FindBy(xpath = "//div[contains(@class,'travelsName')]")
	List<WebElement> nameOfBusList;

	@FindBy(xpath = "//span[contains(text(),'End of list')]")
	List<WebElement> endOfList;

	@FindBy(xpath = "//p[contains(@class,'finalFare')]")
	List<WebElement> fairOfBuses;

	@FindBy(xpath = "//div[contains(@class,'timeRow')]")
	List<WebElement> timeingOfBuses;

	@FindBy(xpath = "//span[@class='doj___db963b']")
	private WebElement date;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));// Handle synchronization issue(explicit wait)
	}

	public boolean validateLogo() {
		boolean result = action.isDisplayed(getDriver(), redbus_Logo);
		return result;
	}

	public void enterdetails() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(from));
		action.click(getDriver(), from);

		wait.until(ExpectedConditions.visibilityOf(searchBox));
		WebElement fromSearchTextBox = getDriver().switchTo().activeElement();
		fromSearchTextBox.sendKeys("Mumbai");

		By fromSearchBoxCategoryBy = By.xpath("//div[contains(@class,'searchCategory')]");
		List<WebElement> fromSearchBoxSuggetions = wait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(fromSearchBoxCategoryBy, 1));

		System.out.println("Suggestions found: " + fromSearchBoxSuggetions.size());

		WebElement fromLocationSearch = fromSearchBoxSuggetions.get(0);
		By fromSearchBylocation = By.xpath(".//div[contains(@Class,'listHeader')]");
		List<WebElement> fromSearchBylocationList = fromLocationSearch.findElements(fromSearchBylocation);

		System.out.println(fromSearchBylocationList.size());

		for (WebElement location : fromSearchBylocationList) {
			System.out.println(location.getText());
			String locationName = location.getText();
			if (locationName.equalsIgnoreCase("Mumbai")) {
				action.click(getDriver(), location);
				break;
			} else {
				System.out.println("Given from location not found......");
			}
		}

		// For to search location

		WebElement toSearchTextBox = getDriver().switchTo().activeElement();
		toSearchTextBox.sendKeys("Pune");

		By toSearchBoxCategoryBy = By.xpath("//div[contains(@class,'searchCategory')]");
		List<WebElement> toSearchBoxSuggetions = wait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(toSearchBoxCategoryBy, 2));

		System.out.println("Suggestions found: " + toSearchBoxSuggetions.size());
		WebElement toLocationSearch = toSearchBoxSuggetions.get(0);
		By toSearchBylocation = By.xpath(".//div[contains(@Class,'listHeader')]");
		List<WebElement> toSearchBylocationList = toLocationSearch.findElements(toSearchBylocation);

		System.out.println(toSearchBylocationList.size());

		for (WebElement location : toSearchBylocationList) {
			System.out.println(location.getText());
			String locationName = location.getText();
			if (locationName.equalsIgnoreCase("Pune")) {
				action.click(getDriver(), location);
				break;
			} else {
				System.out.println("Given to location not found......");
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(searchBusBtn));
		action.click(getDriver(), searchBusBtn);

		
		wait.until(ExpectedConditions.elementToBeClickable(primoBusBtn));
		action.click(getDriver(), primoBusBtn);

//		wait.until(ExpectedConditions.elementToBeClickable(eveningTimeBtn));
//		action.click(getDriver(), nonACBtn);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(eveningTimeBtn));
		action.click(getDriver(), eveningTimeBtn);

		if (wait.until(ExpectedConditions.textToBePresentInElement(noOfBusCount, "buses"))) {
			wait.until(ExpectedConditions.visibilityOf(noOfBusCount));
		}
		System.out.println("No of Bus Count : " + noOfBusCount.getText());

		System.out.println("No of Bus in the List.... : " + numberOfBusListed.size());

		//By nameofBusLocater = By.xpath(".//div[contains(@class,'travelsName')]");
		//By allBuses  = By.xpath("//li[contains(@class,'tupleWrapper')]");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		int previousSize = 0;
		
		while (true) {
			List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'tupleWrapper')]")));
			List<WebElement> endofList=getDriver().findElements(By.xpath("//span[contains(text(),'End of list')]"));
			
			if (rowList.size() > previousSize) {
		        System.out.println("No of Bus in the List so far : " + rowList.size());
		        previousSize = rowList.size();
		    }
			
			if (!endofList.isEmpty()) {
				break;
			}
			
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'})",rowList.get(rowList.size() - 3));
			
		}
		
		List<WebElement> allBuses = getDriver().findElements(By.xpath("//li[contains(@class,'tupleWrapper')]"));
		
		for (WebElement bus : allBuses) {
			System.out.println("----------------------------------------");
			String busName = bus.findElement(By.xpath(".//div[contains(@class,'travelsName')]")).getText();
			String busFair = bus.findElement(By.xpath(".//p[contains(@class,'finalFare')]")).getText(); 
			String busTiming = bus.findElement(By.xpath(".//div[contains(@class,'timeRow')]")).getText();
			System.out.println("Bus Name : " + busName);
			System.out.println("Bus Fair : " + busFair);
			System.out.println("Bus Timining : " + busTiming);
		}
		
		System.out.println("No of Bus in the List numberOfBusListed2 : " + allBuses.size());

	}

	public void clickOnDate() {
		// action.click(getDriver(), date);
		// from.sendKeys("ARA");
	}
}
