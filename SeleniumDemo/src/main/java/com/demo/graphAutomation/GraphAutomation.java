package com.demo.graphAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GraphAutomation {

	public static void main(String[] args) throws InterruptedException {
		int count=0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		String verticalXpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String toolTipXpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		List<WebElement> verticalBars = driver.findElements(By.xpath(verticalXpath));
		System.out.println("Total element is:" + verticalBars.size());

		Actions actions = new Actions(driver);
		
		for (WebElement bar : verticalBars) {
			actions.moveToElement(bar).perform();
			Thread.sleep(500);
			String barText = driver.findElement(By.xpath(toolTipXpath)).getText();
			System.out.println("Tool Tip Text:" + barText);
			count++;
			System.out.println("Count->"+count);
		}

	}

}
