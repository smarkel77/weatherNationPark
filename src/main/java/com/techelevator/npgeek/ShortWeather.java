package com.techelevator.npgeek;

public class ShortWeather {
	
	private String parkCode;
	private int day;
	private int lowTemp;
	private int highTemp;
	private String forecast;


	public ShortWeather(Weather weather) {
		parkCode = weather.getParkCode();
		day = weather.getDay();
		lowTemp = weather.getLowTemp();
		highTemp = weather.getHighTemp();
		forecast = weather.getForecast();
	}
	
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}


	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}

	public String getParkCode() {
		return parkCode;
	}
	public int getDay() {
		return day;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public String getForecast() {
		return forecast;
	}
}
