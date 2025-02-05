package com.demo.shadowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// added implicit wait
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");

		// 1) The element is inside single shadow DOM
		SearchContext shadowHost = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		WebElement shadowElement = shadowHost.findElement(By.cssSelector("#shadow-element"));
		System.out.println("shadowElement : " + shadowElement.getText());

		// 2) The element is inside second or inner shadow DOM
		SearchContext shadowHost1 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadowHost2 = shadowHost1.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		WebElement shadowElement2 = shadowHost2.findElement(By.cssSelector("#nested-shadow-element"));
		System.out.println("shadowElement : " + shadowElement2.getText());

		// 3) The element is inside multiple shadow DOM
		SearchContext shadowHost3 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadowHost4 = shadowHost3.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadowHost5 = shadowHost4.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		WebElement shadowElement3 = shadowHost5.findElement(By.cssSelector("#multi-nested-shadow-element"));
		System.out.println("shadowElement : " + shadowElement3.getText());

	}

}
