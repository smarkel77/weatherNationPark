package com.techelevator.npgeek.cukes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SurveyResultsTest {
	
	private WebDriver webDriver;

	public SurveyResultsTest(WebDriver webDriver) {
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
	public String getURL() {
		return webDriver.getCurrentUrl();
	}

}
