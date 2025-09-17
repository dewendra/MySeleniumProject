package com.demo.jatin99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssLocatersDemo1 {


	public static void main(String[] args) {
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://jatin99.github.io/ShadowDomAssignment/");
		driver.findElement(By.id("email"));//By id locater
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your email\"]"));//By cssLocator
		WebElement emailLocator = driver.findElement(By.cssSelector("input#email"));//By cssLocator
		emailLocator.sendKeys("dewendra.singh@yahoo.com");
	}

}
