package com.techelevator.npgeek.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.DAO.SurveyDAO;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public List<Survey> getAllSurveys(){
		String sql ="SELECT surveyid, parkcode, emailaddress, state, "
				+ "activitylevel  FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		List<Survey> newSurveyForm = new ArrayList<Survey>();
		
		while(results.next()){
			newSurveyForm.add(mapRowToSurvey(results));
		}
		return newSurveyForm;
	}
	
	private Survey mapRowToSurvey(SqlRowSet row) {
		Long surveyId = row.getLong("surveyid");
		String parkCode = row.getString("parkcode");
		String emailAddress =row.getString("emailaddress");
		String state = row.getString("state");
		String activityLevel =row.getNString("activitylevel");
		
		Survey newSurvey = new Survey();
		
		newSurvey.setSurveyID(surveyId);
		newSurvey.setParkCode(parkCode);
		newSurvey.setEmail(emailAddress);
		newSurvey.setState(state);
		newSurvey.setActivityLevel(activityLevel);
		
		return newSurvey;
	}

	@Override
	public List<Survey> getAllSurveyForms() {
		String sql ="SELECT surveyid, parkcode, emailaddress, state, "
				+ "activitylevel  FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		List<Survey> newSurveyRequest = new ArrayList<Survey>();
		
		while(results.next()){
			newSurveyRequest.add(mapRowToSurvey(results));
		}
		return newSurveyRequest;
	}

	@Override
	public void create(Survey newSurveyForm) {
		String sql ="INSERT INTO survey_result(surveyid, parkcode, emailaddress, state,"
				+ "activitylevel) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql, newSurveyForm.getSurveyID(), newSurveyForm.getParkCode(),
		newSurveyForm.getEmail(), newSurveyForm.getState(), newSurveyForm.getActivityLevel());
		
	}
}
