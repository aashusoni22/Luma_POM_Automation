package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SignInPage;
import com.auto.qa.pages.WhatsNewPage;

public class WhatsNewPageTest extends BaseClass {

	WhatsNewPage whatsNewPage;
	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;

	public WhatsNewPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		whatsNewPage = new WhatsNewPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		whatsNewPage = homePage.clickOnWhatsNewButton();
	}

	@Test(priority = 1)
	public void validateWhatsNewPageTitleTest() {
		String whatsNewPageTitle = whatsNewPage.validateWhatsNewPageTitle();
		Assert.assertEquals(whatsNewPageTitle,
				"What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites",
				"WhatsNew Page not found");
	}

	@Test(priority = 2)
	public void validateWhatsNewLabelTest() {
		boolean label = whatsNewPage.validateWhatsNewLabel();
		Assert.assertTrue(label);
	}

	@Test(priority = 3)
	public void categoriesLsitTest() {
		Integer size = whatsNewPage.categoriesList();
		Assert.assertEquals(size, 12);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
