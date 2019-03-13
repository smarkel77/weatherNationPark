package com.techelevator.npgeek;

public class Survey {
	
	private Long surveyID;
	private String parkCode;
	private String email;
	private String state;
	private String activityLevel;
	
	public Long getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(Long surveyID) {
		this.surveyID = surveyID;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	

}
