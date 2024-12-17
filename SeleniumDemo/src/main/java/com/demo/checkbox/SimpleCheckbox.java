package com.demo.checkbox;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleCheckbox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//select 1 checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		//select all checkbox
		List<WebElement> allCheckBox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		/*
		 * for(int i=0;i<allCheckBox.size();i++) { allCheckBox.get(i).click(); }
		 */
		//select last 3 checkbox
		int last3=allCheckBox.size()-3;
		for(int i=last3;i<allCheckBox.size();i++) {
			allCheckBox.get(i).click();
		}
	}

}
