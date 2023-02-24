package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;

public class SearchItemPage extends BaseClass{

	@FindBy(className = "base")
	WebElement searchResultsMsg;
	
	@FindBy(className = "product-item-info")
	WebElement searchResultItems;
	
	public SearchItemPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSearchResultPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateSearchResultsMsg() {
		return searchResultsMsg.isDisplayed();
	}
	
	public boolean validateSearchResultItems() {
		return searchResultItems.isDisplayed();
	}
}
