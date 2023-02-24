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
import com.auto.qa.pages.TrainingPage;

public class TrainingPageTest extends BaseClass{
	
	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	TrainingPage trainingPage;
	
	public TrainingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		homePage = new HomePage();
		trainingPage = new TrainingPage();
		landingPage.clickLoginButton();
		homePage = signinPage.login(prop.getProperty("email"), prop.getProperty("password"));
		trainingPage = homePage.clickOnTrainingButton();
	}
	
	@Test(priority=1)
	public void validateTrainingPageTitleTest() {
		String title = trainingPage.validateTrainingPageTitle();
		Assert.assertEquals(title, "Training Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites", "Training Page title not found");
	}
	
	@Test(priority=2)
	public void validateTrainingLabelTest() {
		boolean flag = trainingPage.validateTraningLable();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void chooseWatchesAndAddtoCartTest() {
		trainingPage.hoverOnTraining();
		trainingPage.clickVideoDownloadOption();
		boolean flag2 = trainingPage.validateVideoDownloadLabel();
		Assert.assertTrue(flag2);
		Integer msgSize = trainingPage.validateNoMatchingProductMsg();
		Assert.assertTrue(msgSize>0);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
	
}
