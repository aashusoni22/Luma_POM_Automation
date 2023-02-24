package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SignInPage;

public class SignInPageTest extends BaseClass {

	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;

	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signinPage = new SignInPage();
		landingPage = new LandingPage();
		landingPage.clickLoginButton();
	}

	@Test(priority = 1)
	public void signInPageTitleTest() {
		String signInTitle = signinPage.loginPageTitle();
		Assert.assertEquals(signInTitle,
				"Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
	}

	@Test(priority = 2)
	public void customerLoginTitleTest() {
		boolean flag = signinPage.customerLoginTitle();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
