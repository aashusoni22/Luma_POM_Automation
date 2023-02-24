package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SignInPage;
import com.auto.qa.pages.CreateAnAccountPage;

public class LandingPageTest extends BaseClass {

	LandingPage landingPage;
	SignInPage loginPage;
	CreateAnAccountPage registerPage;
	
	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
	}

	@Test(priority=0)
	public void landingPageTitleTest() {
		String landingTitle = landingPage.validateLandingPageTitle();
		Assert.assertEquals(landingTitle, "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
	}

	@Test(priority=1)
	public void pageLogoTest() {
		boolean flag = landingPage.validatepageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void clickLoginButtonTest() throws InterruptedException {
		loginPage = landingPage.clickLoginButton();
		landingPage.clickLoginButton();
	}
	
	@Test(priority=3)
	public void clickRegisterButtonTest() {
		registerPage = landingPage.clickRegisterButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
