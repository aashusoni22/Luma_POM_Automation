package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SalePage;
import com.auto.qa.pages.SignInPage;

public class SalePageTest extends BaseClass {

	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	SalePage salePage;

	public SalePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		salePage = new SalePage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		salePage = homePage.clickOnSaleButton();
	}

	@Test(priority=1)
	public void validateSalePageTitleTest() {
		String title = salePage.validateSalePageTitle();
		Assert.assertEquals(title,
				"Sale Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites",
				"Sale Page title not found");
	}

	@Test(priority=2)
	public void validateSaleLabelTest() {
		boolean label = salePage.validateSaleLabel();
		Assert.assertTrue(label);
	}

	@Test(priority=3)
	public void validateDealsTextAndPromoOfferTest() {
		boolean dealsTxt = salePage.validateDealsText();
		Assert.assertTrue(dealsTxt);

		boolean promoOffer = salePage.validatePromoOffer();
		Assert.assertTrue(promoOffer);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
