package com.nop.stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nop.base.BaseClass;
import com.nop.pageObjects.AddCustomerPage;
import com.nop.pageObjects.LoginPage;
import com.nop.pageObjects.SearchCustomerPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

	

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		loginPage = new LoginPage(driver);
		addCustomerPage = new AddCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailId, String password) {
		loginPage.setEmail(emailId);
		loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPage.clickLoginBtn();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}

	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {

		loginPage.clickLogoutBtn();
	}

	@Then("close browser")
	public void close_browser() {
		// if (driver != null) {
		// driver.quit();
		// }
		driver.quit();
	}

	/////////// Add new Customer /////////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String dashboardPage = "Dashboard / nopCommerce administration";
		String actualTitle = addCustomerPage.pageTitle();
		if (actualTitle.equals(dashboardPage)) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		addCustomerPage.clickOnCustomerMenu();
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addCustomerPage.clickOnCustomerSubMenu();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		addCustomerPage.clickOnAddNewButton();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String dashboardPage = "Add a new customer / nopCommerce administration";
		String actualTitle = addCustomerPage.pageTitle();
		if (actualTitle.equals(dashboardPage)) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}
	}

	@When("User enter customer information")
	public void user_enter_customer_information() {
		//addCustomerPage.setEmail("dewendra1.singh@gmail.com");
		addCustomerPage.setEmail(generateRandomString()+"@gmail.com");
		addCustomerPage.setPassword("admin");
		addCustomerPage.setFirstName(generateRandomString());
		addCustomerPage.setLastName("Singh");
		addCustomerPage.selectGender("Male");
		addCustomerPage.setCompanyName("HDFC Bank");
		addCustomerPage.selectTaxExempt();
		addCustomerPage.setNewsLetter("This is a news letter");
		addCustomerPage.enterManagerOfVendor("Vendor 1");
		addCustomerPage.selectActive();
		addCustomerPage.selectCustomerMustChangePassword();
		addCustomerPage.enterAdminContent("Admin content added");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		addCustomerPage.clickOnSaveBtn();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String ecpectedConfirmationMsg) {
		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		if (bodyTag.contains(ecpectedConfirmationMsg)) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}

	}

	//////////// Search Customer by email id///////////////////////

	@When("User enter an email")
	public void user_enter_an_email() {
		searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on seach button")
	public void click_on_seach_button() {
		searchCustomerPage.clickOnSearchBtn();
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		//Assert.assertTrue(searchCustomerPage.searchCustomerByEmail(expectedEmail)); //we can write like this or we can use if else block
		if (searchCustomerPage.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}
	}
	
////////////Search Customer by name///////////////////////

	
	@When("User enter an First name")
	public void user_enter_an_first_name() {
	   searchCustomerPage.setFirstName("Victoria");
	}

	@When("User enter an Last name")
	public void user_enter_an_last_name() {
	    searchCustomerPage.setLastName("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";
		Assert.assertTrue(searchCustomerPage.searchCustomerByName(expectedName));
	}
}
