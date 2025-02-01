package com.demo.javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPgae {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		//1)scroll down page by pixel number
		//js.executeScript("window.scrollBy(0,1000)", "");
		//System.out.println(js.executeScript("return window.pageYOffset"));
		
		//2)scroll down page by element visibility 
		//WebElement element=driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		//js.executeScript("arguments[0].scrollIntoView();", element);
		//System.out.println(js.executeScript("return window.pageYOffset"));
		
		//3)scroll the page by end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(3000);
		//scrolling up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
	}

}
