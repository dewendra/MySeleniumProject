package com.demo.keyboardactions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		WebElement regLink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		//regLink.click();
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		List<String>ids=new ArrayList (driver.getWindowHandles());
		System.out.println("window ids"+ids);
		driver.switchTo().window(ids.get(1));//going forward page
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Dewendra");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Singh");
		driver.switchTo().window(ids.get(0));//going back to previous page
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("laptop");
		

	}

}
