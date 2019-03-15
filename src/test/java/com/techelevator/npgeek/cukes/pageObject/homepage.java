package com.techelevator.npgeek.cukes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {
	
	private WebDriver webDriver;

	public homepage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public survey clickSurveyLink() {
		WebElement surveyLink = webDriver.findElement(By.linkText("Take our survey"));
		surveyLink.click();
		return new survey(webDriver);
	}
	
	public details clickPark() {
		WebElement detailsLink = webDriver.findElement(By.id("park-image"));
		detailsLink.click();
		return new details(webDriver);
	}

}
