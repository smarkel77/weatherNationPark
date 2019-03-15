package com.techelevator.npgeek.cukes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomepageTest {
	
	private WebDriver webDriver;

	public HomepageTest(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public SurveyTest clickSurveyLink() {
		WebElement surveyLink = webDriver.findElement(By.linkText("Take our survey"));
		surveyLink.click();
		return new SurveyTest(webDriver);
	}
	
	public DetailsTest clickPark() {
		WebElement detailsLink = webDriver.findElement(By.id("park-image"));
		detailsLink.click();
		return new DetailsTest(webDriver);
	}
	
	public HomepageTest clickHome() {
		WebElement homepageLink = webDriver.findElement(By.linkText("Home"));
		homepageLink.click();
		return new HomepageTest(webDriver);
	}
	
	public HomepageTest switchToFahrenheit() {
		WebElement tempSelectElement = webDriver.findElement(By.name("temp"));
		Select dropdown = new Select(tempSelectElement);
		dropdown.selectByValue("f");
		WebElement submit = webDriver.findElement(By.className("formSubmitButton"));
		submit.click();
		return this;
	}
	
	public HomepageTest switchToCelsius() {
		WebElement tempSelectElement = webDriver.findElement(By.name("temp"));
		Select dropdown = new Select(tempSelectElement);
		dropdown.selectByValue("c");
		WebElement submit = webDriver.findElement(By.className("formSubmitButton"));
		submit.click();
		return this;
	}

}

