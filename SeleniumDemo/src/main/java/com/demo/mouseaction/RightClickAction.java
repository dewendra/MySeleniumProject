package com.demo.mouseaction;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/3.x/demo.html");
		driver.manage().window().maximize();
		WebElement rightClickButton=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions actions=new Actions(driver);
		//Right click action
		actions.contextClick(rightClickButton).perform();
		//click on copy option
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		//actions.click(copyButton);
		Thread.sleep(2000);
		//closing the alert window
		driver.switchTo().alert().accept();

	
	}

}
