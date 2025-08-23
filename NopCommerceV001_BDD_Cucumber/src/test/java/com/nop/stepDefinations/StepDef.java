package com.nop.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nop.pageObjects.LoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {

	public WebDriver driver;
	public LoginPage loginPage;

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		loginPage=new LoginPage(driver);

	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailId, String password) throws InterruptedException {
		Thread.sleep(3000);	
		loginPage.setEmail(emailId);
		loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		Thread.sleep(3000);	
		loginPage.clickLoginBtn();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
		Thread.sleep(3000);	
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);//pass
		}else {
			Assert.assertTrue(false);//fail
		}

	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		Thread.sleep(3000);	
		loginPage.clickLogoutBtn();
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {
		Thread.sleep(3000);	
//		if (driver != null) {
//			driver.quit();
//		}
		driver.quit();
	}

}
