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
import com.hdorRegistrationProcess.utility.EventActivities;

public class SelectedEventDashboardPage extends BaseClass {
	// WebDriver driver=new ChromeDriver();
	EventActivities eventActivities;
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
	
	public void printWebElementList() throws InterruptedException {
		Thread.sleep(5000);
		for(int i=0;i<allPoints.size();i++) {
			System.out.println("Value : "+allPoints.get(i).getText());
		}
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
		verifyChallengePoints();
		verifyMilagePoints();
		verifyActivityBonusPoints();
		verifyElevationPoints();
		verifyTotalDistance();
		verifyMaximumDistance();
		verifyAverageDistance();
		verifyChallengesDone();
	}

	public void verifyAgeGroupRank() {

	}

	public void verifyGenderRank() {

	}

	public void verifyTotalPoints() throws InterruptedException {
		System.out.println(" verifyTotalPoints");
		Thread.sleep(5000);
		String totalPoints=allPoints.get(0).getText();
		System.out.println("Total Points String : " + totalPoints);
		double total_Points = Double.parseDouble(allPoints.get(0).getText());
		System.out.println("Total Points Double : " + total_Points);
		
		// Logic for check the Total points

	}

	public void verifyChallengePoints() {
		System.out.println(" verifyChallengePoints");
		String challengePoints=allPoints.get(1).getText();
		System.out.println("Challenge Points String : " + challengePoints);
		double total_challengePoints = Double.parseDouble(allPoints.get(1).getText());
		System.out.println("Challenge Points Double : " + total_challengePoints);
	}

	public void verifyMilagePoints() {
		System.out.println(" verifyMilagePoints");
		String milagePoints=allPoints.get(2).getText();
		System.out.println("Milage Points String : " + milagePoints);
		double total_milagePoints = Double.parseDouble(allPoints.get(2).getText());
		System.out.println("Milage Points Double : " + total_milagePoints);
	}

	public void verifyActivityBonusPoints() {
		System.out.println(" verifyActivityBonusPoints");
		String activityBonusPoints=allPoints.get(3).getText();
		System.out.println("Activity Bonus Points String : " + activityBonusPoints);
		double total_activityBonusPoints = Double.parseDouble(allPoints.get(3).getText());
		System.out.println("Activity Bonus Points Double : " + total_activityBonusPoints);
	}

	public void verifyElevationPoints() {
		System.out.println(" verifyElevationPoints");
		String elevationPoints=allPoints.get(4).getText();
		System.out.println("Elevation Points String : " + elevationPoints);
		double total_elevationPoints = Double.parseDouble(allPoints.get(4).getText());
		System.out.println("Elevation Points Double : " + total_elevationPoints);
	}

	public void verifyTotalDistance() {
		System.out.println(" verifyTotalDistance");
		String td=allPoints.get(5).getText();
		String totalDistance=td.replaceAll("[^.0-9]","");
		System.out.println("Total Distance String : " + totalDistance);
		double total_totalDistance=Double.parseDouble(totalDistance);
		//float tdd=Float.parseFloat(totalDistance)
		System.out.println("Total Distance Double : " + total_totalDistance);
	}

	public void verifyMaximumDistance() {
		System.out.println(" verifyMaximumDistance");
		String maxDistance=allPoints.get(6).getText();
		String maximumDistance=maxDistance.replaceAll("[^.0-9]","");
		System.out.println("Maximum Distance  String : " + maximumDistance);
		double total_maximumDistance = Double.parseDouble(maximumDistance);
		System.out.println("Maximum Distance Double : " + total_maximumDistance);
	}

	public void verifyAverageDistance() {
		System.out.println(" verifyAverageDistance");
		String avgDistance=allPoints.get(7).getText();
		String averageDistance=avgDistance.replaceAll("[^.0-9]","");
		System.out.println("Average Distance String : " + averageDistance);
		double total_averageDistance = Double.parseDouble(averageDistance);
		System.out.println("Average Distance Double : " + total_averageDistance);
	}

	public void verifyChallengesDone() {
		System.out.println(" verifyChallengesDone");
		String chalgDone=allPoints.get(8).getText();
		String challengesDone=chalgDone.replaceAll("[^0-9]","");
		System.out.println("Challenge Done String : " + challengesDone);
		//double total_challengesDone = Double.parseDouble(challengesDone);
		int total_challengesDone=Integer.parseInt(challengesDone);
		System.out.println("Challenge Done Double : " + total_challengesDone);
	}

	public  EventsMappedActivities verifyMappedActivities() throws InterruptedException {
		System.out.println(" verifyMappedActivities");
		//eventActivities=new EventActivities();
		action.click(getDriver(), activities_tab);
		return new EventsMappedActivities();
		

		
	}
	
}
