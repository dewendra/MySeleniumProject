package com.demo.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// switch to frame1
		
		  WebElement
		  frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		  driver.switchTo().frame(frame1);
		  driver.findElement(By.xpath("//input[@name='mytext1']")).
		  sendKeys("Welcome Frame 1");
		 driver.switchTo().defaultContent();//coame back to main frame

		// switch to frame2
		
		  WebElement frame2 =
		  driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		  driver.switchTo().frame(frame2);
		  driver.findElement(By.xpath("//input[@name='mytext2']")).
		  sendKeys("Welcome Frame 2");
		  driver.switchTo().defaultContent();//coame back to main frame

		// switch to frame3
		
		  WebElement frame3 =driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		  driver.switchTo().frame(frame3);
		  driver.findElement(By.xpath("//input[@name='mytext3']")).
		  sendKeys("Welcome Frame 3");
		  //inner iframe part of frame 3
		  driver.switchTo().frame(0);//switching to the frame by using index because there is only one frame under frame3
		 //driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		  //By javaexecutescriot
		  WebElement radioButton=driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']"));
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", radioButton);
		  driver.switchTo().defaultContent();//coame back to main frame

		// switch to frame4
		/*
		 * WebElement frame4 =
		 * driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		 * driver.switchTo().frame(frame4);
		 * driver.findElement(By.xpath("//input[@name='mytext4']")).
		 * sendKeys("Welcome Frame 4");
		 * driver.switchTo().defaultContent();//coame back to main frame
		 */
		
		// switch to frame5
		/*
		 * WebElement frame5 =
		 * driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		 * driver.switchTo().frame(frame5);
		 * driver.findElement(By.xpath("//input[@name='mytext5']")).
		 * sendKeys("Welcome Frame 5");
		 */

	}

}
