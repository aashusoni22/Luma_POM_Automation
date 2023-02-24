package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;

public class LandingPage extends BaseClass {

	// Page Factory - OR(Object Repository):
	@FindBy(css = "a[class='logo'] img")
	WebElement pageLogo;

	@FindBy(linkText = "Sign In")
	WebElement loginBtn;

	@FindBy(linkText = "Create an Account")
	WebElement registerBtn;

	@FindBy(xpath = "//span[contains(text(), 'Customer Login')]")
	WebElement customerLoginTitle;

	// Initializing the page objects:
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}

	public boolean validatepageLogo() {
		return pageLogo.isDisplayed();
	}

	public SignInPage clickLoginButton() {
		loginBtn.click();
		customerLoginTitle.isDisplayed();
		return new SignInPage();
	}

	public CreateAnAccountPage clickRegisterButton() {
		registerBtn.click();
		return new CreateAnAccountPage();
	}
}
