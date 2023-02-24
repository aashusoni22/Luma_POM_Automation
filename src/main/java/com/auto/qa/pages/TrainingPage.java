package com.auto.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.BaseClass;
import com.auto.qa.util.TestUtil;

public class TrainingPage extends BaseClass {

	TestUtil testUtil = new TestUtil();

	@FindBy(xpath = "(//span[contains(text(), \"Training\")])[2]")
	WebElement trainingLabel;

	@FindBy(id = "ui-id-7")
	WebElement hoverOnTraining;

	@FindBy(id = "ui-id-28")
	WebElement videoDownloadOption;

	@FindBy(xpath = "(//span[contains(text(), \"Video Download\")])[2]")
	WebElement videoDownloadLabel;

	
	//Actions:
	public TrainingPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateTrainingPageTitle() {
		return driver.getTitle();
	}

	public boolean validateTraningLable() {
		return trainingLabel.isDisplayed();
	}

	public void hoverOnTraining() {
		testUtil.action(hoverOnTraining);
	}

	public void clickVideoDownloadOption() {
		videoDownloadOption.click();
	}

	public boolean validateVideoDownloadLabel() {
		return videoDownloadLabel.isDisplayed();
	}

	public Integer validateNoMatchingProductMsg() {
		List<WebElement> msg = driver.findElements(By.cssSelector("div[class='message info empty']"));
		return msg.size();
	}

}
