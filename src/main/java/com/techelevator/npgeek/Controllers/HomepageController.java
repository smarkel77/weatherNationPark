package com.techelevator.npgeek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.techelevator.npgeek.DAO.JDBC.JDBCParkDAO;

@Controller
public class HomepageController {
	
	@Autowired
	JDBCParkDAO parkDao;
	
	@RequestMapping("/")
	public String displayHomepage(ModelMap modelHolder) {
		modelHolder.addAttribute("parks", parkDao.getAllParks());
		return "homepage";
	}

}

