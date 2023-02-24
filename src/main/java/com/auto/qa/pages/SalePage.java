package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;

public class SalePage extends BaseClass{

	@FindBy(xpath = "//span[contains(text(), 'Sale')]")
	WebElement customerLoginLabel;
	
	@FindBy(xpath = "//span[contains(text(), \"Deals\")]")
	WebElement dealsText;
	
	@FindBy(css = "a[class='block-promo sale-20-off']")
	WebElement promoOffer;
	
	public SalePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSalePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateSaleLabel() {
		return customerLoginLabel.isDisplayed();
	}
	
	public boolean validateDealsText() {
		return dealsText.isDisplayed();
	}
	
	public boolean validatePromoOffer() {
		return promoOffer.isDisplayed();
	}
}
