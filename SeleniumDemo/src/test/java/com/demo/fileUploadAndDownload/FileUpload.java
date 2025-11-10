package com.demo.fileUploadAndDownload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {

		String file = "D:\\GithubProject\\TestingFile\\test.txt";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.foundit.in/upload");
		WebElement UploadResumeBtn = driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]"));
		UploadResumeBtn.click();
		Thread.sleep(3000);

		// using sendkeys method
		WebElement fileUploadBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
		// fileUploadBtn.sendKeys(file);

		// using robot options
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", fileUploadBtn);

		// 1) Copy the file path to click board(Ctrl+c)
		StringSelection selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Thread.sleep(3000);
		// 2) Paste the file path in pop window(Ctrl+p)
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);

		// 3) click on return or Enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		System.out.println("File uploaded successfully....");
	}
}
