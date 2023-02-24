package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.auto.qa.base.BaseClass;
import com.auto.qa.util.TestUtil;

public class GearPage extends BaseClass {

	TestUtil testUtil = new TestUtil();

	@FindBy(xpath = "(//span[contains(text(), \"Gear\")])[2]")
	WebElement gearLabel;

	@FindBy(id = "ui-id-6")
	WebElement hoverDropDown;

	@FindBy(id = "ui-id-27")
	WebElement watchesOption;
	
	@FindBy(xpath = "(//span[contains(text(), \"Watches\")])[2]")
	WebElement watchesLabel;

	@FindBy(xpath = "//div[contains(text(), \"Category\")]")
	WebElement categoryFilter;

	@FindBy(xpath = "(//li[@class='item'])[1]")
	WebElement electronicWatchFilter;

	@FindBy(css = "//span[contains(text(), \"Electronic\") and @class='filter-value']")
	WebElement electronicCategorySelected;

	@FindBy(xpath = "(//img[@class='product-image-photo'])[1]")
	WebElement firstItem;

	@FindBy(css = "button[title='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[contains(text(), \"You added\")]")
	WebElement itemAddedToCartMsg;

	public GearPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateGearPageTitle() {
		return driver.getTitle();
	}

	public boolean validateGearLabel() {
		return gearLabel.isDisplayed();
	}

	public void hoverOnGear() {
		testUtil.action(hoverDropDown);
	}

	public void clickOnWatches() {
		watchesOption.click();
	}
	
	public boolean validateWatchesLable() {
		return watchesLabel.isDisplayed();
	}

	public void chooseCategoryFilter() {
		categoryFilter.click();
	}

	public void chooseElectronicFilter() {
		electronicWatchFilter.click();
	}

	public void hoverOnFirstItem() {
		testUtil.action(firstItem);
	}

	public void addToCart() {
		addToCartBtn.click();
	}

	public boolean validateItemAddedMsg() {
		return itemAddedToCartMsg.isDisplayed();
	}
}
