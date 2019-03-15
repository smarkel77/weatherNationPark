package com.techelevator.npgeek.cukes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SurveyTest {
	
	private WebDriver webDriver;

	public SurveyTest(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public HomepageTest clickHome() {
		WebElement homepageLink = webDriver.findElement(By.linkText("Home"));
		homepageLink.click();
		return new HomepageTest(webDriver);
	}
	
	public SurveyTest clickSurveyLink() {
		WebElement surveyLink = webDriver.findElement(By.linkText("Take our survey"));
		surveyLink.click();
		return new SurveyTest(webDriver);
	}
	
	public SurveyTest enterFavoritePark(String park) {
		Select parkField = new Select(webDriver.findElement(By.name("parkCode")));
		parkField.selectByVisibleText(park);
		return this;
	}
	
	public SurveyTest enterActivityLevel(String level) {
		Select activityField = new Select(webDriver.findElement(By.name("activityLevel")));
		activityField.selectByVisibleText(level);
		return this;
	}
	
	public SurveyTest enterEmail(String email) {
		WebElement emailField = webDriver.findElement(By.name("email"));
		emailField.sendKeys(email);
		return this;
	}
	
	public SurveyTest enterState(String state) {
		Select stateField = new Select(webDriver.findElement(By.name("state")));
		stateField.selectByVisibleText(state);
		return this;
	}
	
	public SurveyResultsTest submitForm() {
		WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));
		submitButton.click();
		return new SurveyResultsTest(webDriver);
	}

}
