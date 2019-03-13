package com.techelevator.npgeek.DAO;

import java.util.List;
import java.util.Map;

import com.techelevator.npgeek.Survey;

public interface SurveyDAO {

	List<Survey> getAllSurveys();
	List<Survey> getAllSurveyForms();
	void create(Survey newSurveyForm);
	Map getSurveyResults();
}
