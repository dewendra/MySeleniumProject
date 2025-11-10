package com.dynamic.moneycontrol;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindDynamicXPathComodities {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.moneycontrol.com/markets/global-indices/");
		By commoditiesLocator =By.xpath("//div[contains(@class,'mainMenu')]/ul/li/a[text()='Commodities']");
		WebElement comoditiesElemnt=wait.until(ExpectedConditions.elementToBeClickable(commoditiesLocator));
		comoditiesElemnt.click();
		
		List<WebElement> commodityNames =driver.findElements(By.xpath("//span[text()='Brent Crude']/ancestor::table[contains(@class,'commodities')]/child::tbody/tr/td[1]//a/span[1]"));
		commodityNames.size();
		List<String> uicommodityName=new ArrayList<String>();		
		for(WebElement name:commodityNames) {
			uicommodityName.add(name.getText().trim());
		}
		System.out.println("ui commodity Names"+uicommodityName);
		List<String>sortedList=new ArrayList<String>(uicommodityName);
		Collections.sort(sortedList);
		System.out.println("After sorting ui commodity Names"+sortedList);
		

		






	}

}
