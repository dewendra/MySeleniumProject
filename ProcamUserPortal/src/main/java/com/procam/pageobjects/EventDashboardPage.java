package com.procam.pageobjects;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class EventDashboardPage{
	private WebDriver driver;
	WaitHelper wait;

	@FindBy(xpath = "//img[contains(@src,'tmm26_logo.png')]/ancestor::div[contains(@class,'event-box')]")
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
		wait = new WaitHelper(driver);
	}

	public DiscountApplyPage selectEvent(Map<String, String> dashboardData) {

		String eventKey = dashboardData.get("eventKey");
		Logs.info("Selecting event : " + eventKey);

		switch (eventKey.toUpperCase()) {
		case "TMM_2026":
			wait.waitForVisible(tmm_2026);
			wait.waitForClickable(tmm_2026);
			Logs.info("Clicking on event");
			tmm_2026.click();
			Logs.info("Event Selected -> "+tmm_2026);
			break;
		case "TCSB_2025":
			wait.waitForVisible(tcsb_2025);
			wait.waitForClickable(tcsb_2025);
			Logs.info("Clicking on event");
			tcsb_2025.click();
			break;
		case "VDHM_2025":
			wait.waitForVisible(vdhm_2025);
			wait.waitForClickable(vdhm_2025);
			Logs.info("Clicking on event");
			vdhm_2025.click();
			break;
		case "TSWK_2025":
			wait.waitForVisible(tswk_2025);
			wait.waitForClickable(tswk_2025);
			Logs.info("Clicking on event");
			tswk_2025.click();
			break;

		default:
			throw new RuntimeException("Invalid eventKey in Excel: " + eventKey);
		}

		return new DiscountApplyPage();

	}
}
