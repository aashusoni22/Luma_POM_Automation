package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;

public class SignInPage extends BaseClass {

	LandingPage landingPage;

	// PageFactory
	@FindBy(xpath = "//span[contains(text(), 'Customer Login')]")
	WebElement customerLoginTitle;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(name = "send")
	WebElement signInBtn;

	@FindBy(xpath = "//span[contains(text(),'Forgot Your Password?')]")
	WebElement forgotYourPasswordBtn;

	@FindBy(xpath = "//span[contains(text(),'Create an Account')]")
	WebElement createAnAccountBtn;

	@FindBy(xpath = "//div[contains(text(),\"sign-in was incorrect or your account is disabled\")]")
	WebElement signInWithWrongCredentials;

	// Initializing driver objects:
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String loginPageTitle() {
		return driver.getTitle();
	}

	public boolean customerLoginTitle() {
		return customerLoginTitle.isDisplayed();
	}

	public HomePage login(String em, String pwd) {
		email.sendKeys(em);
		password.sendKeys(pwd);
		signInBtn.click();

		return new HomePage();
	}

	public void forgetPasswordButton() {
		forgotYourPasswordBtn.click();
	}

	public void createAnAccountButton() {
		createAnAccountBtn.click();
	}

}
