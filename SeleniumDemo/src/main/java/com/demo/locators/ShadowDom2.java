package com.demo.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		WebElement root=driver.findElement(By.tagName("shop-app"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement shadowDom=(WebElement) js.executeScript("return arguments[0].shadowRoot", root);
		System.out.println(shadowDom);
		
	}

}
