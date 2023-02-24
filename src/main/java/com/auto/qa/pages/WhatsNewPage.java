package com.auto.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;

public class WhatsNewPage extends BaseClass {

	// PageFactory
	@FindBy(xpath = "//span[contains(text(), \"What's New\")]")
	WebElement whatsNewLabel;

	// Initializing page objects:
	public WhatsNewPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateWhatsNewPageTitle() {
		return driver.getTitle();
	}

	public boolean validateWhatsNewLabel() {
		return whatsNewLabel.isDisplayed();
	}

	public Integer categoriesList() {
		List<WebElement> categories = driver.findElements(By.xpath("//div[@class='categories-menu']/ul/li/a"));
		return categories.size();
	}
}
