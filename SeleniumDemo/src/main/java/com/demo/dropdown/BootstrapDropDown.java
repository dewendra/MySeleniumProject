package com.demo.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		// select the single option
		// driver.findElement(By.xpath("//input[@value='Java']")).click();

		// capture all option in the dropdown
		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("Total options : " + allOptions.size());
		for (int i = 0; i < allOptions.size(); i++) {

			System.out.println("Options : " + allOptions.get(i).getText());
		}
		// select multiple options

		for (WebElement op : allOptions) {
			String option = op.getText();
			if (option.equals("Java") || option.equals("MySQL")) {
				op.click();
			}
		}
	}

}
