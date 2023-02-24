package com.auto.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;
import com.auto.qa.util.TestUtil;

public class MenPage extends BaseClass {
	
	TestUtil testUtil;
	
	//PageFactory	
	@FindBy(linkText = "Tops")
	WebElement topsCategory;
	
	@FindBy(className = "product-image-photo")
	WebElement topsFirstItem;
	
	@FindBy(xpath = "//div[contains(text(),\"M\") and @id='option-label-size-143-item-168']")
	WebElement topSize;
	
	@FindBy(xpath = "(//div[@class='swatch-option color'])[1]")
	WebElement colorOption;
	
	@FindBy(css = "button[title='Add to Cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[contains(text(), \"You added\")]")
	WebElement itemAddedMsg;
	
	//Initializing PageFactory objects:
	public MenPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateMenPageTitle() {
		return driver.getTitle();
	}
	
	public Integer validateMenLabel() {
		List<WebElement> labelSize = driver.findElements(By.cssSelector("h1[id='page-title-heading'] span"));
		return labelSize.size();
	}
	
	public void chooseItemAndAddToCart() {
		topsFirstItem.click();
		topSize.click();
		colorOption.click();
		addToCartBtn.click();
	}
	
	public boolean validateItemAddedMsg() {
		return itemAddedMsg.isDisplayed();
	}
}
