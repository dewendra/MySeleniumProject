package com.demo.fileUploadAndDownload;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownloadInDifferentBrowser {

	public static void main(String[] args) throws InterruptedException {
		String eventName = "Tour De 100 - 2025";
		ChromeOptions chromeOptions = new ChromeOptions();
		 // ✅ Chrome preferences to disable password popups and leak detection
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("password_manager_leak_detection_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        
		
		//chromeOptions.addArguments("--incognito");
//		chromeOptions.setExperimentalOption("prefs", prefs);
//		chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--disable-infobars");
       // chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //chromeOptions.setExperimentalOption("useAutomationExtension", false);
///
//        // Disable Chrome password manager popups
//        chromeOptions.addArguments("--disable-save-password-bubble");
//        chromeOptions.addArguments("--disable-password-manager-reauthentication");
//        chromeOptions.addArguments("--disable-features=PasswordManagerEnabled,AutofillEnableAccountWalletStorage,PasswordLeakDetection");
//        chromeOptions.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerOnboarding");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://app-uat.hdor.com/auth/#/login");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement email=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@name='email']"))));
		email.clear();
		email.sendKeys("john2@yopmail.com");
		System.out.println("Entered email successfully");
		
		WebElement continueBtn=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[@type='submit']"))));
		continueBtn.click();
		

		WebElement password=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@type='password']"))));
		password.clear();
		password.sendKeys("password");
		System.out.println("Entered password successfully");
		
		WebElement loginBtn=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[@type='submit']"))));
		loginBtn.click();
		
		
		// Step 1: Locate the shadow host
		
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("app-header-nav[data-currentapp='USER'][data-userroles='ROLE_RUNNER']")));

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);

		WebElement settingsMenu = shadowRoot.findElement(By.cssSelector("label[for='settings'] li.nav-item"));
		settingsMenu.click(); // expands the dropdown if needed
		WebElement settingsSubLink = wait.until(d -> shadowRoot
				.findElement(By.cssSelector("ul.nav-sub-item-container li.nav-sub-item a[href*='user']")));

		js.executeScript("arguments[0].click();", settingsSubLink);
		
		WebElement bannerAndCertificate=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//h6[text()='Banner & Certificates']"))));
		try {
		    bannerAndCertificate.click();
		} catch (Exception e) {
		    js.executeScript("arguments[0].click();", bannerAndCertificate);
		}
		
		WebElement certificate=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//h6[text()='Certificate']"))));
		try {
			certificate.click();
		} catch (Exception e) {
		    js.executeScript("arguments[0].click();", certificate);
		}
		
		WebElement downloadCertificate=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//h6[text()='"+eventName+"']/following-sibling::div/div/button[text()='Download']"))));
		try {
			downloadCertificate.click();
		} catch (Exception e) {
		    js.executeScript("arguments[0].click();", downloadCertificate);
		}
	}
	
	//Add here to check that file is downloaded or not

}
