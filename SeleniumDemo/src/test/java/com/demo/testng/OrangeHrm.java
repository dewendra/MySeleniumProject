package com.demo.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1) Open application
2) test logo presence
3) Login application
4) Logout application

*/
public class OrangeHrm {
	
	
	WebDriver driver;
	@Test(priority = 1)
	public void openApplication() {
		System.out.println("Opening  Application");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 2)
	public void testLogo() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Testing logo");
		boolean logo=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo displayed: "+logo);

		
	}

	@Test(priority = 3)
	public void loginApplaction() {
		System.out.println("Login to Application");
		driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 4)
	public void logoutApplaction() {
		System.out.println("Logout from Application");
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
	}
}
