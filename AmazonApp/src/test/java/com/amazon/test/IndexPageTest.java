package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;
import com.amazon.pageobjects.IndexPage;
import com.amazon.pageobjects.SearchPage;

public class IndexPageTest extends BaseClass {
	Action action = new Action();
	private IndexPage indexPage;
	private SearchPage searchPage;

	@BeforeMethod
	public void setup() {

		launchApp();

	}

	//@Test
	public void verifiyLogo() throws Throwable {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test
	public void verifyAccountAndListOption() throws Throwable {
		indexPage=new IndexPage();
		//indexPage.clickOnUpadteLocationOption();
		searchPage=indexPage.clickOnSearchBoxOption();
		searchPage.selectOptions();
		//indexPage.clickOnLangageButton();
		//indexPage.clickOnReturnsAndOrders();
		//indexPage.clickOnCart();
		//indexPage.clickOnNavHamBurgerMenu();
		//indexPage.clickOnAccountAndListOption();
		//indexPage.clickOnSignInOption();
	}

	//@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
