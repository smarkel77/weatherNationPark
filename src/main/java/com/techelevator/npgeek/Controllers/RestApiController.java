package com.techelevator.npgeek.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ShortWeather;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.DAO.ParkDAO;
import com.techelevator.npgeek.DAO.SurveyDAO;
import com.techelevator.npgeek.DAO.WeatherDAO;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	@Autowired
	ParkDAO parkDao;
	
	@Autowired
	WeatherDAO weatherDao;
	
	@Autowired
	SurveyDAO surveyDao;
	
	@RequestMapping("/parks")
	public List getParksAsJson() {
		return parkDao.getAllParks();
	}
	
	@RequestMapping("/weather")
	public List getParkWeatherAsJson(@RequestParam String parkCode) {
		List<Weather> weather = weatherDao.getAllWeather(parkCode);
		List<ShortWeather> shortWeather = new ArrayList<ShortWeather>();
		for (Weather each : weather) {
			shortWeather.add(new ShortWeather(each));
		}
		return shortWeather;
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public List getSurveysAsJson() {
		return surveyDao.getAllSurveys();
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public void saveSurvey() {
		
	}
}
