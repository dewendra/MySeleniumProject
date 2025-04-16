package com.demo.dataProviderDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class DataProviderTest {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1, dataProvider = "loginData")
	void login(String email, String password) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=affiliate/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(1000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if (status == true) {
			System.out.println("My account text visible...........");
			driver.findElement(
					By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"))
					.click();
			Assert.assertTrue(status);
		} else {
			Assert.fail();
		}
		Thread.sleep(1000);
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "loginData", indices = {0,2})
	Object[][] dataProvider() {
		Object data[][] = { { "abcd@gmail.com", "password" },
				            { "dewendra.singh@yahoo.com", "password" },
				            { "dewendra1.singh@yahoo.com", "password" } 
				
		
		
		};
		return data;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
