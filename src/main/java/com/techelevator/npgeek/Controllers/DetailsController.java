package com.techelevator.npgeek.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class DetailsController {
	
	@RequestMapping("/details")
	public String displayDetails() {
		return "details";
	}

}
