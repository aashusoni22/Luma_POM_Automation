package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.auto.qa.base.BaseClass;
import com.auto.qa.util.TestUtil;

public class WomenPage extends BaseClass {

	TestUtil testUtil = new TestUtil();

	// PageFactory
	@FindBy(xpath = "//span[contains(text(), \"Women\") and @class='base']")
	WebElement womenLabel;

	@FindBy(xpath = "(//span[contains(text(), \"Women\")])[1]")
	WebElement womenDropDownBtn;

	@FindBy(id = "ui-id-9")
	WebElement topsOption;

	@FindBy(id = "ui-id-11")
	WebElement jacketsOption;

	@FindBy(id = "sorter")
	WebElement sortByDropDown;

	@FindBy(xpath = "(//img[@class='product-image-photo'])[1]")
	WebElement firstItem;

	@FindBy(id = "option-label-size-143-item-168")
	WebElement jacketSize;

	@FindBy(xpath = "(//div[@class='swatch-option color'])[2]")
	WebElement jacketColor;

	@FindBy(id = "qty")
	WebElement quantity;

	@FindBy(id = "product-addtocart-button")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[contains(text(), \"You added\")]")
	WebElement itemAddedMsg;

	public WomenPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateWomenPageTitle() {
		return driver.getTitle();
	}

	public boolean validateWomenLabel() {
		return womenLabel.isDisplayed();
	}

	public void hoverOnWomenAndSelect() {
		testUtil.action(womenDropDownBtn);
		testUtil.action(topsOption);
		jacketsOption.click();
	}

	public void sortByProductName() {
		sortByDropDown.click();
		Select select = new Select(sortByDropDown);
		select.selectByValue("name");
	}

	public void chooseItem() {
		firstItem.click();
		jacketSize.click();
		jacketColor.click();
		quantity.clear();
		quantity.sendKeys("2");
	}

	public void addToCart() {
		addToCartBtn.click();
	}

	public boolean validateItemAddedMsg() {
		return itemAddedMsg.isDisplayed();
	}
}
