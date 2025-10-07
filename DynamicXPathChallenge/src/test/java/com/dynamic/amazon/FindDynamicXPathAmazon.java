package com.dynamic.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindDynamicXPathAmazon {

	public static void main(String[] args) {

		// Apple iPhone 15 (128 GB) - Blue
		// 47,999

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		// By.xpath("");
		WebElement searchLocator = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchLocator.sendKeys("iphone 15");
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();

		String xpath = "(//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[contains(@class,'s-card-container')]//span[contains(@class,'a-offscreen')])[1]";
	
		WebElement pricElement=driver.findElement(By.xpath(xpath));
		System.out.println("Price : "+pricElement.getText());
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
