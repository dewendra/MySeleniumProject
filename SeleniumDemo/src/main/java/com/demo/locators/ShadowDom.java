package com.demo.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		WebElement root=driver.findElement(By.tagName("book-app"));//shadow host or root element
		//javascript for reading the shadow dom element
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//WebElement shadow=(WebElement)js.executeScript("return arguments[0].shadowRoot", root);
		//System.out.println(shadow.getText());
		SearchContext shadowDom1=(SearchContext)js.executeScript("return arguments[0].shadowRoot", root);
		System.out.println(shadowDom1.toString());
		//after getting shadow dom then we traverse the element one by one to reach the final locators
		WebElement appHeader=shadowDom1.findElement(By.tagName("app-header"));
		WebElement appToolbar=appHeader.findElement(By.tagName("app-toolbar"));
		WebElement bookInputDecorator=appToolbar.findElement(By.tagName("book-input-decorator"));
		bookInputDecorator.findElement(By.cssSelector("input#input")).sendKeys("testing");
	}

}
