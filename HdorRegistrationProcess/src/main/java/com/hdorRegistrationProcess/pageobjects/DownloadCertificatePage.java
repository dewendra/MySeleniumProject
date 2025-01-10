package com.hdorRegistrationProcess.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class DownloadCertificatePage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath = "//h6[normalize-space()='Banner']")
	private WebElement bannerButton;
	
	@FindBy(xpath = "//h6[normalize-space()='Certificate']")
	private WebElement certificateButton;
	
	@FindBy(xpath = "//h6[normalize-space()='Tour de 100 2023']")
	private WebElement eventCertificate;
	
	@FindBy(xpath="//h6[@class='MuiTypography-root MuiTypography-h6 css-1qttl3n']")
	private WebElement allEventsName;
	
	public DownloadCertificatePage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void clickedOnBannerButton() {
		action.click(getDriver(), certificateButton);
		System.out.println("Banner Button clicked");
	}
	
	public void clickedOnCertifacateButton() {
		action.click(getDriver(), certificateButton);
		System.out.println("Certificate Button clicked");
	}
	
	public void gettingAllEventsName() {
		List<WebElement>eventsName =getDriver().findElements(By.xpath("allEventsName"));
		for(int i=0; i<=eventsName.size();i++) {
			System.out.println("Event Name"+eventsName.get(i).getText());
		}
	}
	
}
