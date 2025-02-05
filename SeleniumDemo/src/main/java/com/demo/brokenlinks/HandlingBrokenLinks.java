package com.demo.brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrokenLinks {

	public static void main(String[] args) {
		int totalBrokenLink = 0;
		int totalNotBrokenLink=0;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//added implicit wait
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("Total links : "+links.size());
		for(WebElement linkElement:links) {
			String hrefAttributeValue = linkElement.getAttribute("href");
			if(hrefAttributeValue==null || hrefAttributeValue.isEmpty()) {
				System.out.println("Not possible to check");
				continue;
			}else {
				System.out.println("possible to check");
				try {
				URL linkUrl=new URL(hrefAttributeValue);//convert string to url format
				HttpURLConnection openLinkUrlConnection = (HttpURLConnection) linkUrl.openConnection();//open connection to the server
				openLinkUrlConnection.connect();//connect to the server and sent request to the server
				int responseCode = openLinkUrlConnection.getResponseCode();
				if(responseCode>=400) {
					System.out.println(hrefAttributeValue+"======> Broken Link");
					totalBrokenLink++;
				}else {
					System.out.println(hrefAttributeValue+"======>Not a Broken Link");
					totalNotBrokenLink++;
					
				}}
				catch (Exception e) {
					
				}
			}
			
		}
		System.out.println("Total Broken Link"+totalBrokenLink);
		System.out.println("Total Not Broken Link"+totalNotBrokenLink);

	}

}
