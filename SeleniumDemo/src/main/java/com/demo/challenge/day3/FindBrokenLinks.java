package com.demo.challenge.day3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {
	public static void main(String[] args) throws InterruptedException {
		int brokenLink=0;
		int validLink=0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);
		List<WebElement> links_list = driver.findElements(By.tagName("a"));
		System.out.println("Total links:" + links_list.size());
		
		for (WebElement link : links_list) {
			String url = link.getAttribute("href");
			
			// Skip invalid links
			if (url == null || url.isEmpty()||url.startsWith("javascript")|| url.startsWith("mailto")
                    || url.startsWith("#")) {
				continue;
			}
			// System.out.println("Link Text : "+link.getText());
			// System.out.println("Link URL : "+url);

			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				connection.setConnectTimeout(5000);
				connection.connect();
				int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println("Broken Link:" + url + "Response Code:" + responseCode);
					brokenLink++;
				} else {
					System.out.println("Valid Link:" + url + "Response Code:" + responseCode);
					validLink++;
				}
			} catch (Exception e) {
				System.out.println("Skipping Invalid URL: " + url);
				e.printStackTrace();
			}
		}
		System.out.println("Total broken Links: "+brokenLink);
		System.out.println("Total valid Links: "+validLink);
	}

}
