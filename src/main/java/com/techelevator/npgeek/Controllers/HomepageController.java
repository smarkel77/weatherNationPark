package com.techelevator.npgeek.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
	
	@RequestMapping("/")
	public String displayHomepage() {
		return "homepage";
	}

}

