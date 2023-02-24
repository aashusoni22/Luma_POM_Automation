package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.auto.qa.base.BaseClass;
import com.auto.qa.util.TestUtil;

public class HomePage extends BaseClass {

	TestUtil testUtil = new TestUtil();

	@FindBy(xpath = "//span[contains(text(), 'Welcome, John Smith!')]")
	WebElement userNameLabel;

	@FindBy(id = "ui-id-3")
	WebElement whatsNewBtn;

	@FindBy(id = "ui-id-4")
	WebElement womenBtn;

	@FindBy(id = "ui-id-5")
	WebElement menBtn;

	@FindBy(id = "ui-id-6")
	WebElement gearBtn;

	@FindBy(id = "ui-id-7")
	WebElement trainingBtn;

	@FindBy(id = "ui-id-8")
	WebElement saleBtn;
	
	@FindBy(id = "search")
	WebElement searchBar;
	
	@FindBy(css = "button[class='action search']")
	WebElement searchBtn;

	// Initializing the page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateUserNameLabel() {
		return userNameLabel.isDisplayed();
	}

	public WhatsNewPage clickOnWhatsNewButton() {
		whatsNewBtn.click();
		return new WhatsNewPage();
	}

	public WomenPage clickOnWomenButton() {
		testUtil.action(womenBtn);
		womenBtn.click();
		return new WomenPage();
	}

	public MenPage clickOnMenButton() {
		testUtil.action(menBtn);
		menBtn.click();
		return new MenPage();
	}

	public GearPage clickOnGearButton() {
		testUtil.action(gearBtn);
		gearBtn.click();
		return new GearPage();
	}

	public TrainingPage clickOnTrainingButton() {
		testUtil.action(trainingBtn);
		trainingBtn.click();
		return new TrainingPage();
	}

	public SalePage clickOnSaleButton() {
		saleBtn.click();
		return new SalePage();
	}
	
	public SearchItemPage searchForItem(String a) {
		searchBar.click();
		searchBar.sendKeys(a);
		searchBtn.click();
		return new SearchItemPage();
	}

}
