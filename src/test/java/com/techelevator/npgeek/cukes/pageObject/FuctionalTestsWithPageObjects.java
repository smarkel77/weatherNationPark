package com.techelevator.npgeek.cukes.pageObject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FuctionalTestsWithPageObjects {
	
	private static WebDriver webDriver;
	private HomepageTest homepageTest;
	
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
		homepageTest = new HomepageTest(webDriver);
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
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
