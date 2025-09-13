package com.download.file;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileInCustomFolder {

	public static void main(String[] args) throws InterruptedException {

		String downlaodFolderPath = System.getProperty("user.dir") +File.separator+ "JenkinsDownload";
		// String downlaodFolderPath = "C:\\Users\\dewen\\Documents\\Test
		// Folder\\Jenkins Download";
		File folder = new File(downlaodFolderPath);
		// System.out.println(folder.exists());
		if (!folder.exists()) {
			System.out.println("Folder is not present..");
			if (folder.mkdirs()) {
				System.out.println("Now Folder is created...");
			}
		}

		Map<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("download.default_directory", downlaodFolderPath);
		preferences.put("download.prompt_for_download", false);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("prefs", preferences);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://get.jenkins.io/war-stable/2.516.2/jenkins.war");
		
		//Check whether the file is downloaded successfully.........
		
		File downloadFile=new File(folder, "jenkins.war");
		
		int timeOutSeconds=30;
		int elapsedTime=0;
		while(elapsedTime<timeOutSeconds && !downloadFile.exists()) {
			Thread.sleep(4000);
			elapsedTime++;
			System.out.println("Waiting fo download the file..... "+elapsedTime+" Second");
		}
		if(downloadFile.exists()) {
			System.out.println("File downloaded successfully......");
		}else {
			System.out.println("Getting some error......");
		}

	}

}
