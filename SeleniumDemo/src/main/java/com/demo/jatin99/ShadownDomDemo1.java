package com.demo.jatin99;

import java.util.List;

import org.apache.commons.math3.analysis.function.Divide;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadownDomDemo1 {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(chromeOptions);
		// driver.manage().window().maximize();
		driver.get("https://jatin99.github.io/ShadowDomAssignment/");
		WebElement emailLocator = driver.findElement(By.cssSelector("input#email"));// By cssLocator
		emailLocator.sendKeys("dewendra.singh@yahoo.com");
		
		String headerText = driver.findElement(By.cssSelector("div.header")).getText();
		System.out.println(headerText);
		
		WebElement userNameLocator = driver.findElement(By.cssSelector("input[name='username']"));// By cssLocator
		userNameLocator.clear();
		userNameLocator.sendKeys("Alok");
		
		WebElement btnSubmitLocator = driver.findElement(By.cssSelector("button[type='submit']"));// By cssLocator
		btnSubmitLocator.click();
		// more than one css selector are bind by .
		
		String headerText1 = driver.findElement(By.cssSelector("div.main.header")).getText();
		System.out.println(headerText1);
		
		WebElement liLocator = driver.findElement(By.cssSelector("ul>li"));// By cssLocator
		System.out.println(liLocator.getText());
		
		List<WebElement> liLocators = driver.findElements(By.cssSelector("ul>li"));
		System.out.println(liLocators.size());
		
		WebElement liThreeLocator = driver.findElement(By.cssSelector("ul>li:nth-child(3)"));// By cssLocator
		System.out.println(liThreeLocator.getText());
		
		WebElement spanLocator = driver.findElement(By.cssSelector("div>span"));// By cssLocator
		System.out.println(spanLocator.getText());
		
		WebElement nameLocator = driver.findElement(By.cssSelector("input[placeholder^='your']"));// By cssLocator
		nameLocator.clear();
		nameLocator.sendKeys("aloksingh@gmail.com");
		WebElement name1Locator = driver.findElement(By.cssSelector("input[placeholder$='name']"));// By cssLocator
		name1Locator.clear();
		name1Locator.sendKeys("alok");
		
		//shadow dom //my-component
		WebElement myComponentLocator=driver.findElement(By.xpath("//my-component"));
		SearchContext myComponent =myComponentLocator.getShadowRoot();
		WebElement myComponentShadowDivLocator=myComponent.findElement(By.cssSelector("div.header"));
		System.out.println(myComponentShadowDivLocator.getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
