package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SearchItemPage;
import com.auto.qa.pages.SignInPage;

public class SearchItemPageTest extends BaseClass {

	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	SearchItemPage searchItemPage;

	public SearchItemPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		searchItemPage = new SearchItemPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		searchItemPage = homePage.searchForItem(prop.getProperty("itemToSearch"));
	}

	@Test
	public void validateSearchResultPageTitleTest() {
		String title = searchItemPage.validateSearchResultPageTitle();
		Assert.assertEquals(title,
				"Search results for: 'tops' Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites",
				"SearchResult Page title not found");
	}

	@Test
	public void validateSearchResultsLMsgTest() {
		boolean msg = searchItemPage.validateSearchResultsMsg();
		Assert.assertTrue(msg);
	}

	@Test
	public void validateSearchResultItemsTest() {
		boolean items = searchItemPage.validateSearchResultItems();
		Assert.assertTrue(items);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
