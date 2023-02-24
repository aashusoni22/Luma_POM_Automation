package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.MenPage;
import com.auto.qa.pages.SignInPage;

public class MenPageTest extends BaseClass{
	
	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	MenPage menPage;
	
	public MenPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		menPage = new MenPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		menPage = homePage.clickOnMenButton();
	}
	
	@Test(priority=1)
	public void validateMenPageTitleTest() {
		String title = menPage.validateMenPageTitle();
		Assert.assertEquals(title, "Men Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
	}
	
	@Test(priority=2)
	public void validateMenLabelTest() {
		Integer labelSize = menPage.validateMenLabel();
		Assert.assertTrue(labelSize>0);
	}
	
	@Test(priority=3)
	public void chooseItemAndAddToCartTest() {
		menPage.chooseItemAndAddToCart();
		boolean addedMsg = menPage.validateItemAddedMsg();
		Assert.assertTrue(addedMsg);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
