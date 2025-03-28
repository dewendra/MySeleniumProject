package com.demo.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		/*
		 * Alert myalert=driver.switchTo().alert(); Thread.sleep(5000);
		 * myalert.sendKeys("welcome"); myalert.accept();//for clicking on ok
		 */		//myalert.dismiss();//for clicking on cancle
		//Handlealert using ecplicit wait
		Alert myalert2=mywait.until(ExpectedConditions.alertIsPresent());//capture alert
		myalert2.sendKeys("Handlealert using ecplicit wait");
		myalert2.accept();
	}

}
