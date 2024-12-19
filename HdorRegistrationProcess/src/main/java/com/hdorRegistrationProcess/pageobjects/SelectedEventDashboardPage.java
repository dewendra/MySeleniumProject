package com.hdorRegistrationProcess.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hdorRegistrationProcess.actiondriver.Action;
import com.hdorRegistrationProcess.base.BaseClass;

public class SelectedEventDashboardPage extends BaseClass {
	// WebDriver driver=new ChromeDriver();
	Action action = new Action();

	@FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-1r81vhm']")
	private WebElement event_name;

	@FindBy(xpath = "//button[normalize-space()='My Progress']")
	private WebElement my_progress_tab;

	@FindBy(xpath = "//button[normalize-space()='Reports']")
	private WebElement report_tab;

	@FindBy(xpath = "//button[normalize-space()='Overall']")
	private WebElement overall_tab;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	private WebElement stages_tab;

	@FindBy(xpath = "//button[normalize-space()='My Team']")
	private WebElement my_team_tab;

	@FindBy(xpath = "//button[normalize-space()='Activities']")
	private WebElement activities_tab;

	@FindBy(xpath = "//button[normalize-space()='Results']")
	private WebElement reports_results_tab;

	@FindBy(xpath = "//button[normalize-space()='Leaders']")
	private WebElement reports_leaders_tab;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	private WebElement reports_stages_tab;

	@FindBy(xpath = "//button[normalize-space()='Teams']")
	private WebElement reports_teams_tab;

	@FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-1xm6851']")
	private WebElement findingTotalPointsDiv;

	
	@SuppressWarnings("static-access")
	List<WebElement>allPoints=action.getDriver().findElements(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 css-1xm6851']"));

	

	public SelectedEventDashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void verifyEventName() {
		boolean eventNameDisplayed = action.isDisplayed(getDriver(), event_name);
		System.out.println("Event Name Displayed :" + eventNameDisplayed);
	}

	public void overallStats() {
		action.click(getDriver(), my_progress_tab);
		action.click(getDriver(), overall_tab);
	}

	public void validateOverallStats() throws InterruptedException {
		System.out.println(" validateOverallStats");
		Thread.sleep(5000);
		verifyTotalPoints();
	}

	public void verifyAgeGroupRank() {

	}

	public void verifyGenderRank() {

	}

	public void verifyTotalPoints() throws InterruptedException {
		System.out.println(" verifyTotalPoints");
		Thread.sleep(5000);
		// List<WebElement>allPoints=driver.findElements(By.xpath("//h6[@class='MuiTypography-root
		// MuiTypography-h6 css-1xm6851']"));
		// List<WebElement>allPoints=action.getDriver().findElements(By.xpath("//h6[@class='MuiTypography-root
		// MuiTypography-h6 css-1xm6851']"));//working
		// int
		// allPoints=action.getDriver().findElements(By.xpath("//h6[@class='MuiTypography-root
		// MuiTypography-h6 css-1xm6851']")).size();
		String points=allPoints.get(0).getText();
		System.out.println("Total Points1 : " + points);
		double total_Points = Double.parseDouble(allPoints.get(0).getText());
		System.out.println("Total Points2 : " + total_Points);
		/*
		 * for(int i=0; i<allPoints1.size();i++) {
		 * System.out.println("Total Div Points : "+allPoints1.get(i).getText()); }
		 * System.out.println("Points2 : "+allPoints1.get(0).getText());
		 */

		// Logic for check the Total points

	}

	public void verifyChallengePoints() {

	}

	public void verifyMilagePoints() {

	}

	public void verifyActivityBonusPoints() {

	}

	public void verifyElevationPoints() {

	}

	public void verifyTotalDistance() {

	}

	public void verifyMaximumDistance() {

	}

	public void verifyAverageDistance() {

	}

	public void verifyChallengesDone() {

	}

}
