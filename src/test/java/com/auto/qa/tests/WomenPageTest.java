package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SignInPage;
import com.auto.qa.pages.WomenPage;

public class WomenPageTest extends BaseClass {

	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	WomenPage womenPage;

	public WomenPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		womenPage = new WomenPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		womenPage = homePage.clickOnWomenButton();
	}

	@Test(priority = 1)
	public void validateWomenPageTitleTest() {
		String title = womenPage.validateWomenPageTitle();
		Assert.assertEquals(title,
				"Women Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites",
				"Women Page title not found");
	}

	@Test(priority = 2)
	public void validateWomenLabelTest() {
		boolean flag = womenPage.validateWomenLabel();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void chooseItemAndAddToCartTest() throws InterruptedException {
		womenPage.hoverOnWomenAndSelect();
		womenPage.sortByProductName();
		womenPage.chooseItem();
		womenPage.addToCart();
		boolean addedMsg = womenPage.validateItemAddedMsg();
		Assert.assertTrue(addedMsg);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
