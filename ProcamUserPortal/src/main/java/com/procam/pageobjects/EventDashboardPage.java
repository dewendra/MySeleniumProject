package com.procam.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.procam.base.BaseClass;
import com.procam.utils.DriverFactory;
import com.procam.utils.Logs;
import com.procam.utils.WaitHelper;

public class EventDashboardPage extends BaseClass{
	
	WaitHelper wait;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[1]//img")
	private WebElement vdhm_2025;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[2]//img")
	private WebElement tmm_2026;
	
	@FindBy(xpath = "//div[contains(@class,'row')]//div[3]//img")
	private WebElement twsk_2025;
	
	
	public EventDashboardPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		wait=new WaitHelper(DriverFactory.getDriver());
	}

	public DiscountApplyPage selectEvent() {
		wait.waitForVisible(tmm_2026);
		wait.waitForClickable(tmm_2026);
		Logs.info("Clicking on event");
		twsk_2025.click();
		return new DiscountApplyPage();
		
	}
}
