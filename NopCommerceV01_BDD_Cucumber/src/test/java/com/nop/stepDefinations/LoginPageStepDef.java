package com.nop.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.nop.pageObjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageStepDef {

	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	//@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		//loginPage=new LoginPage(driver);
		//driver.manage().window().maximize();
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		loginPage=new LoginPage(driver);
		
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		Thread.sleep(3000);	
		loginPage.setEmail(email);
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
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
			
		}else {
			String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, 
	            "Page title did not match!");
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
		driver.quit();
	}

	@Given("User enters invalid {string} and {string}")
	public void user_enters_invalid_and(String string, String string2) {
	    
	}

	@Then("user should seen an error message indicating {string}")
	public void user_should_seen_an_error_message_indicating(String err_msg) {
	    
	}

	@When("user click on {string} link")
	public void user_click_on_link(String forget_pwd_link) {
	    
	}

	@Then("User should be redirect to the password reset page")
	public void user_should_be_redirect_to_the_password_reset_page() {
	    
	}

}
