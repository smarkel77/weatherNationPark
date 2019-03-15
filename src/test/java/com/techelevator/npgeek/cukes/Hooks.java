package com.techelevator.npgeek.cukes;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.npgeek.cukes.pageObject.DetailsTest;
import com.techelevator.npgeek.cukes.pageObject.HomepageTest;
import com.techelevator.npgeek.cukes.pageObject.SurveyResultsTest;
import com.techelevator.npgeek.cukes.pageObject.SurveyTest;

import cucumber.api.java.Before;

public class Hooks {

	private @Autowired WebDriver webDriver;
	private HomepageTest homepageTest;
	
	@Before
	public void setup() {
		webDriver.manage().deleteAllCookies();
		webDriver.get("http://localhost:8080/m3-java-capstone/");
		homepageTest = new HomepageTest(webDriver);
		
		
	}
	
	@Test
	public void forms_can_be_edited_and_submit() {
		SurveyResultsTest surveyResults = homepageTest.clickSurveyLink()
											.enterFavoritePark("Yellowstone National Park")
											.enterActivityLevel("active")
											.enterEmail("smarkel@gmail.com")
											.enterState("WV")
											.submitForm();
		Assert.assertEquals(surveyResults.getURL(), "http://localhost:8080/m3-java-capstone/surveyResults");
	}
}
