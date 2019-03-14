package com.techelevator.npgeek.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.DAO.JDBC.JDBCParkDAO;
import com.techelevator.npgeek.DAO.JDBC.JDBCWeatherDAO;

@Controller
public class DetailsController {
	
	@Autowired
	JDBCParkDAO parkDAO;
	@Autowired
	JDBCWeatherDAO weatherDAO;
	
	
	@RequestMapping("/details")
	public String displayDetails(@RequestParam String parkCode, ModelMap modelHandler, HttpSession session) {
		Park park = parkDAO.getPark(parkCode);
		modelHandler.addAttribute("park", park);
		List<Weather> parkWeather= weatherDAO.getAllWeather(parkCode);
		for (Weather w : parkWeather) {
			if(session.getAttribute("temp").equals("c")) {
				w.setHighTemp(((w.getHighTemp() - 32) * 5) / 9);
				w.setLowTemp(((w.getLowTemp() - 32) * 5) / 9);
			}
		}
		modelHandler.addAttribute("parkWeather", parkWeather);
		return "details";
	}

}
