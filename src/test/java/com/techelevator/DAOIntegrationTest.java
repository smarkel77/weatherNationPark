package com.techelevator;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.DAO.JDBC.JDBCParkDAO;

public abstract class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	
	//Test Park
	private static final String TEST_PARK_PARKCODE = "ZZZ";
	private static final String TEST_PARK_PARKNAME = "Cheese Park";
	private static final String TEST_PARK_STATE = "Hotdog State";
	private static final int TEST_PARK_ACREAGE = 999999999;
	private static final int TEST_PARK_ELEVATION = 888888888;
	private static final double TEST_PARK_MILESOFTRAIL = 777777777.0;
	private static final int TEST_PARK_NUMOFCAMPSITES = 666666666;
	private static final String TEST_PARK_CLIMATE = "Temperate";
	private static final int TEST_PARK_YEARFOUNDED = 1999;
	private static final int TEST_PARK_ANNUALVISITORS = 555555555;
	private static final String TEST_PARK_QUOTE = "They're greeeaaaattt!";
	private static final String TEST_PARK_QUOTESOURCE = "Tony the Tiger";
	private static final String TEST_PARK_DESCRIPTION = "Pretty lame";
	private static final int TEST_PARK_ENTRYFEE = 444444444;
	private static final int TEST_PARK_NUMOFSPECIES = 333333333;
	
	//TEST SURVEY
	private static final long TEST_SURVEY_SURVEYID = 999999;
	private static final String TEST_SURVEY_PARKCODE = "ZZZ";
	private static final String TEST_SURVEY_EMAIL = "xxx@MMM.com";
	private static final String TEST_SURVEY_EMAILCONFIRMATION = "xxx@MMM.com";
	private static final String TEST_SURVEY_STATE = "Frankfurt Land";
	private static final String TEST_SURVEY_ACTIVITYLEVEL = "active";
	
	//TEST WEATHER
	private static final String TEST_WEATHER_PARKCODE = "ZZZ";
	private static final int TEST_WEATHER_DAY = 1;
	private static final int TEST_WEATHER_LOWTEMP = 20;
	private static final int TEST_WEATHER_HIGHTTEMP = 80;
	private static final String TEST_WEATHER_FORECAST = "cloudy";
	private static final String TEST_WEATHER_RECOMMENDATION = "";
	private static final String TEST_WEATHER_FORECASTIMAGE = TEST_WEATHER_FORECAST;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/historygeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	protected Park makeTestPark(String parkCode, String parkName, String state, int acreage, 
					int elevation, int numOfCampsites, long milesOfTrail, String climate, 
					int yearFounded, int annualVisitors, String quote, String quoteSource,
					String description, int entryFee, int numOfSpecies) {
		Park testPark = new Park();
		testPark.setParkCode(parkCode);
		testPark.setParkName(parkName);
		testPark.setState(state);
		testPark.setAcreage(acreage);
		testPark.setElevation(elevation);
		testPark.setMilesOfTrail(milesOfTrail);
		testPark.setNumOfCampsites(numOfCampsites);
		testPark.setClimate(climate);
		testPark.setYearFounded(yearFounded);
		testPark.setAnnualVisitors(annualVisitors);
		testPark.setQuote(quote);
		testPark.setQuoteSource(quoteSource);
		testPark.setDescription(description);
		testPark.setEntryFee(entryFee);
		testPark.setNumOfSpecies(numOfSpecies);
		return testPark;
	}
	
	public void insertPark() {
		String sql = "INSERT INTO park (parkcode, parkname " + 
				"state, acreage, elevationinfeet, milesoftrail, numberofcampsites " + 
				"climate, yearfounded, annualvisitorcount, inspirationalquote " + 
				"inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sql, TEST_PARK_PARKCODE, TEST_PARK_PARKNAME, TEST_PARK_STATE, 
				TEST_PARK_ACREAGE, TEST_PARK_ELEVATION, TEST_PARK_MILESOFTRAIL, TEST_PARK_NUMOFCAMPSITES, 
				TEST_PARK_CLIMATE, TEST_PARK_YEARFOUNDED, TEST_PARK_ANNUALVISITORS, TEST_PARK_QUOTE, 
				TEST_PARK_QUOTESOURCE, TEST_PARK_DESCRIPTION, TEST_PARK_ENTRYFEE, TEST_PARK_NUMOFSPECIES);
	}

	protected Survey makeTestSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setSurveyID(TEST_SURVEY_SURVEYID);
		testSurvey.setParkCode(TEST_SURVEY_PARKCODE);
		testSurvey.setEmail(TEST_SURVEY_EMAIL);
		testSurvey.setEmailConfirmation(TEST_SURVEY_EMAILCONFIRMATION);
		testSurvey.setState(TEST_PARK_STATE);
		testSurvey.setActivityLevel(TEST_SURVEY_ACTIVITYLEVEL);
		return testSurvey;
	}
	
	protected Weather makeTestWeather() {
		Weather testWeather = new Weather(TEST_WEATHER_PARKCODE, TEST_WEATHER_DAY,TEST_WEATHER_LOWTEMP,
				TEST_WEATHER_HIGHTTEMP, TEST_WEATHER_FORECAST);
		testWeather.setForecastImage(TEST_WEATHER_FORECASTIMAGE);
		testWeather.setRecommendation(TEST_WEATHER_RECOMMENDATION);
		return testWeather;
	}
	
}
