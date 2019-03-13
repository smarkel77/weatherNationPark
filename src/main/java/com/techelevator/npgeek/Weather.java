package com.techelevator.npgeek;

public class Weather {
	
	private String parkCode;
	private int day;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	private String recommendation;
	
	public Weather() {
		switch(forecast) {
		case "snow" :
			recommendation = "Pack Snowshoes!";
			break;
		case "partly cloudy" :
			recommendation = "";
			break;
		case "cloudy" :
			recommendation = "";
			break;
		case "rain" :
			recommendation = "Pack rain gear and wear waterproof shoes";
			break;
		case "thunderstorms" :
			recommendation = "Seek shelter and avoid hiking on exposed ridges";
			break;
		case "sunny" :
			recommendation = "Pack sunblock";
			break;
		default:
			break;
		}
		if(highTemp > 75) {
			if(recommendation.length() > 0) {
				recommendation += "\n";
			}
			recommendation += "Bring an extra gallon of water";
		}
		if(lowTemp < 20) {
			if(recommendation.length() > 0) {
				recommendation += "\n";
			}
			recommendation += "Be careful of frigid temperatures";
		}
		if(highTemp - lowTemp > 20) {
			if(recommendation.length() > 0) {
				recommendation += "\n";
			}
			recommendation += "Wear breathable layers";
		}
	}
	
	
	public String getRecommendation() {
		return recommendation;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

}
