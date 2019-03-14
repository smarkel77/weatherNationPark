package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.DAO.JDBC.JDBCSurveyDAO;



public class JDBCSurveyDAOTest extends DAOIntegrationTest {
	private JDBCSurveyDAO dao;
	
	@Before
	public void setup() {
		dao = new JDBCSurveyDAO(getDataSource());
	}
	
	@Test
	public void get_all_surveys() {
		Survey survey = makeTestSurvey(TEST_SURVEY_SURVEYID, TEST_SURVEY_PARKCODE, TEST_SURVEY_STATE, 
				TEST_SURVEY_EMAIL, TEST_SURVEY_EMAILCONFIRMATION, TEST_SURVEY_ACTIVITYLEVEL);
		insertSurvey(survey);
		List<Survey> listOfSurveys = dao.getAllSurveys();
		assertSurveysAreEqual(survey, listOfSurveys.get(listOfSurveys.size() - 1));
	}
	
	
	private void assertSurveysAreEqual(Survey expected, Survey actual) {
		Assert.assertEquals(expected.getParkCode(), actual.getParkCode());
		Assert.assertEquals(expected.getSurveyID(), actual.getSurveyID());
		Assert.assertEquals(expected.getActivityLevel(), actual.getActivityLevel());
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
		Assert.assertEquals(expected.getEmailConfirmation(), actual.getEmailConfirmation());
		Assert.assertEquals(expected.getState(), actual.getState());
	}

}
