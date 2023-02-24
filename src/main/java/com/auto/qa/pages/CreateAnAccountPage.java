package com.auto.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;

public class CreateAnAccountPage extends BaseClass {

	// PageFactory
	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "email_address")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;

	@FindBy(css = "button[class*='submit primary']")
	WebElement createAnAccountBtn;

	@FindBy(xpath = "//div[contains(text(),\"Thank you for registering with Fake Online Clothing Store.\")]")
	WebElement accountCreatedMsg;
	
	@FindBy(xpath = "//div[contains(text(),\"There is already an account with this email address. If you are sure that it is your email address\")]")
	WebElement accountAlreadyExistsMsg;

	// Initializing pageFactory objects
	public CreateAnAccountPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateCreateAccPageTitle() {
		return driver.getTitle();
	}

	public Integer validateCreateAnAccountLabel() {
		List<WebElement> label = driver
				.findElements(By.xpath("//span[contains(text(), \"Create New Customer Account\")]"));
		return label.size();
	}

	public HomePage createAccount(String fn, String ln, String em, String pwd, String cpwd) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(em);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cpwd);
		createAnAccountBtn.click();
		return new HomePage();
	}

	public boolean accountCreatedMsg() {
		return accountCreatedMsg.isDisplayed();
	}
	
	public boolean accountAlreadyExistsMsg() {
		return accountAlreadyExistsMsg.isDisplayed();
	}
	
	

}
