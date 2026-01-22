package com.procam.pageObjects;

import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class EventDashboardPage{
	private WebDriver driver;
	//WaitHelper wait;
	WebDriverWait wait;

	@FindBy(xpath = "//img[contains(@src,'tmm_2026_logo_v1.png')]/ancestor::div[contains(@class,'event-box')]")
	private WebElement tmm_2026;

	@FindBy(xpath = "//img[contains(@src,'tcsb26_logo.png')]/ancestor::div[contains(@class,'event-box')]")
	private WebElement tcsb_2025;
	
	@FindBy(xpath = "//img[contains(@src,'vdhm26_logo.png')]/ancestor::div[contains(@class,'event-box')]")
	private WebElement vdhm_2025;
	
	@FindBy(xpath = "//img[contains(@src,'tsk25k25.png')]/ancestor::div[contains(@class,'event-box')]")
	private WebElement tswk_2025;

	public EventDashboardPage() {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	}

	public VolunteerRegistrationPage selectEvent(Map<String, String> dashboardData) {

		String eventKey = dashboardData.get("eventKey");
		Logs.info("Selecting event : " + eventKey);

		switch (eventKey.toUpperCase()) {
		case "TMM_2026":
			Logs.info("Clicking on event");
			wait.until(ExpectedConditions.elementToBeClickable(tmm_2026)).click();
			Logs.info("Event Selected -> "+tmm_2026);
			break;
			
		case "TCSB_2025":
			Logs.info("Clicking on event");
			wait.until(ExpectedConditions.elementToBeClickable(tcsb_2025)).click();
			Logs.info("Event Selected -> "+tcsb_2025);
			break;
			
		case "VDHM_2025":
			Logs.info("Clicking on event");
			wait.until(ExpectedConditions.elementToBeClickable(vdhm_2025)).click();
			Logs.info("Event Selected -> "+vdhm_2025);
			break;
			
		case "TSWK_2025":
			Logs.info("Clicking on event");
			wait.until(ExpectedConditions.elementToBeClickable(tswk_2025)).click();
			Logs.info("Event Selected -> "+tswk_2025);
			break;

		default:
			throw new RuntimeException("Invalid eventKey in Excel: " + eventKey);
		}

		return new VolunteerRegistrationPage();

	}
}
