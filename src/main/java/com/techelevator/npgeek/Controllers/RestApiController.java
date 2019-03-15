package com.techelevator.npgeek.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.DAO.ParkDAO;
import com.techelevator.npgeek.DAO.WeatherDAO;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	@Autowired
	ParkDAO parkDao;
	
	@Autowired
	WeatherDAO weatherDao;
	
	@RequestMapping("/parks")
	public Map getParksAsJson() {
		Map<String, Object> json = new HashMap<String, Object>();
		List<Park> parks = parkDao.getAllParks();
		json.put("parks", parks);
		return json;
	}
	
	@RequestMapping("/weather")
	public Map getParkWeather(@RequestParam String parkCode) {
		Map<String, Object> json = new HashMap<String, Object>();
		List<Weather> weather = weatherDao.getAllWeather(parkCode);
		json.put("weather", weather);
		return json;
	}
}
