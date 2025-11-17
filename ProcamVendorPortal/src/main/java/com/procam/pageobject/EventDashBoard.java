package com.procam.pageobject;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.procam.base.BaseClass;

public class EventDashBoard extends BaseClass {

	@FindBy(xpath = "//button[normalize-space()='Participants']")
	private WebElement participantsBtn;

	@FindBy(xpath = "//button[contains(text(),'Corporate')]")
	private WebElement corporateBtn;

	@FindBy(xpath = "//div[contains(@class,'table-responsive')]//tbody//tr[3]//td[6]")
	private WebElement detailsBtn;

	@FindBy(xpath = "//div[contains(@class,'cdk-overlay-pane')]")
	private WebElement detailsPopUp;//button[contains(text(),'Close')]
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement detailsPopUpCloseBtn;//h2[@id='mat-mdc-dialog-title-3']
	
	@FindBy(xpath = "//h2[@id='mat-mdc-dialog-title-3']")
	private WebElement detailsPopUpHeader;

	WebDriverWait wait;

	public EventDashBoard() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void selectParticipantOption() {

	}

	public void selectCorporateOption() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(corporateBtn));
		corporateBtn.click();
		Thread.sleep(5000);
		detailsBtn.click();
		detailsViews();
		
		wait.until(ExpectedConditions.visibilityOf(detailsPopUpCloseBtn));
		detailsPopUpCloseBtn.click();
	}

	public void detailsView() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(detailsPopUp));
		//Thread.sleep(5000);
		System.out.println("Details View : "+detailsPopUpHeader.getText());
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='row']"));
		System.out.println("Total rows: " + rows.size());

		try {
			for (WebElement row : rows) {
				List<WebElement> labels = row.findElements(By.xpath(".//div[contains(@class,'col-sm-5')]"));
				List<WebElement> values = row.findElements(By.xpath(".//div[contains(@class,'col-sm-7')]"));
				
				if (!labels.isEmpty() && !values.isEmpty()) {
					String label = labels.get(0).getText().trim();
					String value = values.get(0).getText().trim();
					System.out.println(label + " : " + value);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Skipped one invalid row.");
		}

	}

	public void detailsViews() {
		wait.until(ExpectedConditions.visibilityOf(detailsPopUp));
		Map<String, String> detailsViewsMap = new HashMap<String, String>();
		List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='row']"));
		System.out.println("Total rows: " + rowsList.size());
		
		for (WebElement row : rowsList) {
			try {
				WebElement labelElement = row.findElement(By.xpath(".//div[contains(@class,'col-sm-5')]"));
				WebElement valueElement = row.findElement(By.xpath(".//div[contains(@class,'col-sm-7')]"));
				String label = labelElement.getText().trim();
				String value = valueElement.getText().trim();
				detailsViewsMap.put(label, value);
				System.out.println(label + " : " + value);
			} catch (Exception e) {
				System.out.println("Skipped one invalid row.");
			}

		}

	}

}
