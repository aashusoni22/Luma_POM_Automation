package com.auto.qa.tests;

import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.qa.base.BaseClass;
import com.auto.qa.pages.CreateAnAccountPage;
import com.auto.qa.pages.HomePage;
import com.auto.qa.pages.LandingPage;
import com.auto.qa.pages.SignInPage;
import com.auto.qa.util.TestUtil;

public class CreateAnAccountTest extends BaseClass {

	LandingPage landingPage;
	SignInPage signinPage;
	HomePage homePage;
	CreateAnAccountPage createAnAccPage;
	TestUtil testUtil;

	String sheetName = "account";

	public CreateAnAccountTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		signinPage = new SignInPage();
		createAnAccPage = landingPage.clickRegisterButton();
	}

	@Test(priority = 1)
	public void validateCreateAccPageTitleTest() {
		String title = createAnAccPage.validateCreateAccPageTitle();
		Assert.assertEquals(title,
				"Create New Customer Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites",
				"Create An Account Page title not found");
	}

	@Test(priority = 2)
	public void validateCreateAnAccountLabelTest() {
		Integer labelSize = createAnAccPage.validateCreateAnAccountLabel();
		Assert.assertTrue(labelSize > 0);
	}

	@DataProvider
	public Object[][] getAccountCreationData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	String email;

	@Test(priority = 3, dataProvider = "getAccountCreationData")
	public void createAccountTest(String firstName, String lastName, String email, String password,
			String confirmPassword) throws InterruptedException {
		char randomChar = (char) (new Random().nextInt(26) + 'a');
		this.email = randomChar + email;
		homePage = createAnAccPage.createAccount(firstName, lastName, this.email, password, confirmPassword);
		boolean success = createAnAccPage.accountCreatedMsg();
		Assert.assertTrue(success, "Account Creation Success Message not found");
	}

	@Test(priority = 4, dataProvider = "getAccountCreationData")
	public void createAccountWithSameDataTest(String firstName, String lastName, String email, String password,
			String confirmPassword) throws InterruptedException {
		homePage = createAnAccPage.createAccount(firstName, lastName, this.email, password, confirmPassword);
		boolean alreadyExists = createAnAccPage.accountAlreadyExistsMsg();
		Assert.assertTrue(alreadyExists,
				"There is already an account with this email address. If you are sure that it is your email address");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
