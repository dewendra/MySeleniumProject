package com.oepncart.test.registration;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.AccountRegistrationPage;
import com.opencart.pageobjects.HomePage;

public class TC001_AccountRegistrationTest  {
	WebDriver driver;

	

	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public void verifyAccountRegistration(String firstName, String lastName, String email, String pwd) {
		HomePage homePage=new HomePage(driver);
		homePage.clickonMyAccount();
		homePage.clickonMyAccount();
		AccountRegistrationPage accountRegistrationPage=new AccountRegistrationPage(driver);
		accountRegistrationPage.setFirstName("John");
		accountRegistrationPage.setLastName("Smith");
		accountRegistrationPage.setEmail("john1@yopmail.com");
		accountRegistrationPage.setPassword("password");
		accountRegistrationPage.clickTermsAndCondition();
		accountRegistrationPage.clickContinue();
		String confmsg=accountRegistrationPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "My Account");
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
