package com.nop.stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputFilter.Config;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.nop.base.BaseClass;
import com.nop.pageObjects.AddCustomerPage;
import com.nop.pageObjects.LoginPage;
import com.nop.pageObjects.SearchCustomerPage;
import com.nop.utilities.CommonMethod;
import com.nop.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {

	// ReadConfig readConfig;
	// execute before every scenario
	// we can set priority by using order value for more than one before method
	// We can use @sanity or @ regression etc like conditional hook
	@Before(value="@sanity",order = 0)
	public void setup1() {

		log = LogManager.getLogger("StepDef");// initialize logger
		System.out.println("Setup method executed..");
		String browser = readConfig.getBrowser();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			log.warn("Browser not recognized: {}. Launching Chrome as default.", browser);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		log.info("Browser launched: {}", browser);

		// Initialize Page Objects
		loginPage = new LoginPage(driver);
		addCustomerPage = new AddCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
	}

	// @Before(value = "@regression", order = 1)
	public void setup2() {
		System.out.println("Setup method executed..");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		log.info("User launch chrome browser........");
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("User opens url........");

	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailId, String password) {
		loginPage.setEmail(emailId);
		loginPage.setPassword(password);
		log.info("User enters email and password........");
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPage.clickLoginBtn();
		log.info("Click on Login........");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			log.warn("Test pass : Loginf Feature : Page title matched");
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
			log.warn("Test fail : Loginf Feature : Page title not matched");
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {

		loginPage.clickLogoutBtn();
		log.info("Click on Logout........");
	}

	/////////// Add new Customer /////////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String dashboardPage = "Dashboard / nopCommerce administration";
		String actualTitle = addCustomerPage.pageTitle();
		if (actualTitle.equals(dashboardPage)) {
			Assert.assertTrue(true);// pass
			log.info("Page Title matched........");
		} else {
			Assert.assertTrue(false);// fail
			log.warn("Page Title not matched........");
		}
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		addCustomerPage.clickOnCustomerMenu();
		log.info("User click on customers menu........");
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addCustomerPage.clickOnCustomerSubMenu();
		log.info("User click on customers Menu Item........");
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		addCustomerPage.clickOnAddNewButton();
		log.info("Click on Add new button........");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String dashboardPage = "Add a new customer / nopCommerce administration";
		String actualTitle = addCustomerPage.pageTitle();
		if (actualTitle.equals(dashboardPage)) {
			Assert.assertTrue(true);// pass
			log.info("Page Title matched........");
		} else {
			Assert.assertTrue(false);// fail
			log.warn("Page Title not matched........");
		}
	}

	@When("User enter customer information")
	public void user_enter_customer_information() {
		// addCustomerPage.setEmail("dewendra1.singh@gmail.com");
		addCustomerPage.setEmail(generateRandomString() + "@gmail.com");
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
		log.info("User enter customer information........");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		addCustomerPage.clickOnSaveBtn();
		log.info("click on Save button........");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String ecpectedConfirmationMsg) {
		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		if (bodyTag.contains(ecpectedConfirmationMsg)) {
			Assert.assertTrue(true);// pass
			log.info("view confirmation message........");
		} else {
			Assert.assertTrue(false);// fail
			log.warn("Not view confirmation message........");
		}

	}

	//////////// Search Customer by email id///////////////////////

	@When("User enter an email")
	public void user_enter_an_email() {
		searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
		log.info("User enter an email........");
	}

	@When("click on seach button")
	public void click_on_seach_button() {
		searchCustomerPage.clickOnSearchBtn();
		log.info("click on seach button........");
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		// Assert.assertTrue(searchCustomerPage.searchCustomerByEmail(expectedEmail));
		// //we can write like this or we can use if else block
		if (searchCustomerPage.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);// pass
			log.info("email found in search table........");
		} else {
			Assert.assertTrue(false);// fail
			log.warn("email not found in search table........");
		}
	}

////////////Search Customer by name///////////////////////

	@When("User enter an First name")
	public void user_enter_an_first_name() {
		searchCustomerPage.setFirstName("Victoria");
		log.info("User enter an First name........");
	}

	@When("User enter an Last name")
	public void user_enter_an_last_name() {
		searchCustomerPage.setLastName("Terces");
		log.info("User enter an Last name........");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";
		Assert.assertTrue(searchCustomerPage.searchCustomerByName(expectedName));
		log.info("name found in search table........");
	}

	// @BeforeStep
	public void befoerStepMethodDemo() {
		System.out.println("Before Step Method executed..");
	}

	@AfterStep
	public void addScreenshots(Scenario sc) {
		
		CommonMethod commonMethod = new CommonMethod(driver);
        String relativePath = commonMethod.takeScreenshots(sc.getName()); // returns "screenshots/xyz.png"
        
        try {
            File file = new File(relativePath);
            if (file.exists()) {
                // This makes Spark HTML render the screenshot properly
                sc.attach(Files.readAllBytes(file.toPath()), "image/png", sc.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
			//final byte[] screenshots=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//CommonMethod commonMethod = new CommonMethod(driver);
			//commonMethod.takeScreenshots(sc.getName());
			//sc.attach(screenshots, "image/png", sc.getName());
		
	}

	@After // execute after every scenario we can set priority by using order value for
			// more than one after method higher value executed first
	public void tearDown(Scenario sc) {

		System.out.println("Tear down method executed..");
		/*
		 * if (sc.isFailed()) { // initialize CommonMethod with same driver CommonMethod
		 * commonMethod = new CommonMethod(driver);
		 * commonMethod.takeScreenshots(sc.getName()); }
		 */

		if (driver != null) {
			driver.quit();
		}

	}
}
