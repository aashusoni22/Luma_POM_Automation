package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.GearPage;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.MenPage;
import com.auto.qa.pages.SalePage;
import com.auto.qa.pages.SignInPage;
import com.auto.qa.pages.TrainingPage;
import com.auto.qa.pages.WhatsNewPage;
import com.auto.qa.pages.WomenPage;

public class HomePageTest extends BaseClass {

	HomePage homePage;
	SignInPage signinPage;
	LandingPage landingPage;
	WhatsNewPage whatsNewPage;
	MenPage menPage;
	WomenPage womenPage;
	GearPage gearPage;
	TrainingPage trainingPage;
	SalePage salePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signinPage = new SignInPage();
		landingPage = new LandingPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle,
				"Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites",
				"Home page title not matched");
	}

	@Test(priority=2)
	public void validateUserNameTest() {
		Assert.assertTrue(homePage.validateUserNameLabel());
	}

	@Test(priority=3)
	public void clickOnWhatsNewButtonTest() {
		whatsNewPage = homePage.clickOnWhatsNewButton();
	}
	
	@Test(priority=4)
	public void clickOnMenButtonTest() {
		menPage = homePage.clickOnMenButton();
		womenPage = homePage.clickOnWomenButton();
		gearPage = homePage.clickOnGearButton();
		trainingPage = homePage.clickOnTrainingButton();
		salePage = homePage.clickOnSaleButton();
		whatsNewPage = homePage.clickOnWhatsNewButton();
	}
	
	@Test(priority=5)
	public void searchForItemAndValidateSearchBtnTest() {
		homePage.searchForItem(prop.getProperty("itemToSearch"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
