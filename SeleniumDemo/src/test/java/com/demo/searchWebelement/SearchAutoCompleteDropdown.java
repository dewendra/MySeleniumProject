package com.demo.searchWebelement;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchAutoCompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("sele");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> suggestions = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']/span")));
		for (WebElement suggestion : suggestions) {
			System.out.println("Suggestion: " + suggestion.getText());
		}

		
		  for (WebElement suggestion : suggestions) { if
		  (suggestion.getText().equalsIgnoreCase("selenium")) { suggestion.click(); break;
		  } }
		 
		// Step 5: (Optional) Verify result or continue the test
		 Thread.sleep(2000);
		 driver.quit();
	}

}
