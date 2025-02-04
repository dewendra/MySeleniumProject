package com.demo.javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		// upload the single file
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("D:\\SeleniumWorkspace\\DemoTestFile\\seleniumTestFile.txt");
		String uploadedFileName = driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText();
		// validate that file is successfully uploaded or not
		if (uploadedFileName.equals("seleniumTestFile.txt")) {
			System.out.println("File is successfully uploaded");
		} else {
			System.out.println("File is not successfully uploaded");
		}*/

		// upload the multiple file
		String file1="D:\\SeleniumWorkspace\\DemoTestFile\\seleniumTestFile.txt";
		String file2="D:\\SeleniumWorkspace\\DemoTestFile\\seleniumTestFile2.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		int numberOffilesUploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		System.out.println("Number of file is successfully uploaded : "+numberOffilesUploaded);
		
		String uploadedFileName1 = driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText();
		String uploadedFileName2 = driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText();
		// validate that file is successfully uploaded or not
		if (uploadedFileName1.equals("seleniumTestFile.txt")&&uploadedFileName2.equals("seleniumTestFile2.txt")) {
			System.out.println("File is successfully uploaded");
		} else {
			System.out.println("File is not successfully uploaded");
		}

	}

}
