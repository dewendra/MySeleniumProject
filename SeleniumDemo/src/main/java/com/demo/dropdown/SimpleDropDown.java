package com.demo.dropdown;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleDropDown {
	// Using Select class
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement drpdwnCountryElement = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpdwnCountry = new Select(drpdwnCountryElement);
		// Three option for selecting the dropdown item
		//  drpdwnCountry.selectByVisibleText("France");
		// drpdwnCountry.selectByValue("india");
		// drpdwnCountry.selectByIndex(2);

		   //How to get total no of dropdoen items
		   List<WebElement> totalOptions=drpdwnCountry.getOptions();
		   System.out.println("Total items:" +totalOptions.size());
		   //Print all options
		   for (int i = 0; i <totalOptions.size(); i++) {
			System.out.println("Option "+i+": "+totalOptions.get(i).getText());
		}
		   //enhanced for loop
		   for(WebElement op:totalOptions) {
			   System.out.println("Option : "+op.getText());
		   }
	}
}
