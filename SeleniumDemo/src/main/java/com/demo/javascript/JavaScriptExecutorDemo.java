package com.demo.javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//using sendkeys option
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Dewendra Singh");
		//using java script executor
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Dewendra Singh')", name);
		
		//how to handle click action using java script executor
		WebElement maleButton=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", maleButton);
	}

}
