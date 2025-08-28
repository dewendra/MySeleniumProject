package com.nop.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCustomerPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement searchEmailBox;

	@FindBy(id = "SearchFirstName")
	WebElement searchFirstName;

	@FindBy(id = "SearchLastName")
	WebElement searchLastName;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement btnSearch;

	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement searchresult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableCols;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmail(String email) {
		searchEmailBox.sendKeys(email);
	}
	
	public void setFirstName(String fName) {
		searchFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		searchLastName.sendKeys(lName);
	}

	public void clickOnSearchBtn() {
		btnSearch.click();
	}

	public boolean searchCustomerByEmail(String searchEmailAdd) {
		boolean found = false;
		// totla no of rows
		int totalRows = tableRows.size();

		// total no of cols
		int totalCols = tableCols.size();

		for (int i = 1; i < totalRows; i++) {
			WebElement actualemail = driver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd = actualemail.getText();

			if (actualEmailAdd.equals(searchEmailAdd)) {
				found = true;
				break;
			}
		}

		return found;

	}
	
	public boolean searchCustomerByName(String searchName) {
		boolean found = false;
		// totla no of rows
		int totalRows = tableRows.size();

		// total no of cols
		int totalCols = tableCols.size();

		for (int i = 1; i < totalRows; i++) {
			WebElement actualName = driver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			String actual_Name = actualName.getText();

			if (actual_Name.equals(searchName)) {
				found = true;
				break;
			}
		}

		return found;

	}

}
