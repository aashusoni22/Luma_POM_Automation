package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.GearPage;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SignInPage;

public class GearPageTest extends BaseClass {

	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	GearPage gearPage;

	public GearPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		gearPage = new GearPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		gearPage = homePage.clickOnGearButton();
	}
	
	@Test(priority=1)
	public void validateGearPageTitleTest() {
		String title = gearPage.validateGearPageTitle();
		Assert.assertEquals(title, "Gear Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites", "Gear Page title not found");
	}

	@Test(priority=2)
	public void validateGearLabelTest() {
		boolean flag = gearPage.validateGearLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void chooseItemAndAddToCartTest() {
		gearPage.hoverOnGear();
		gearPage.clickOnWatches();
		gearPage.validateWatchesLable();
		gearPage.chooseCategoryFilter();
		gearPage.chooseElectronicFilter();
		gearPage.hoverOnFirstItem();
		gearPage.addToCart();
		gearPage.validateItemAddedMsg();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
