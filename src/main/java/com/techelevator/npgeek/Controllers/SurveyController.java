package com.techelevator.npgeek.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyController {

	@RequestMapping("/survey")
	public String displaySurvey() {
		return "survey";
	}

}
