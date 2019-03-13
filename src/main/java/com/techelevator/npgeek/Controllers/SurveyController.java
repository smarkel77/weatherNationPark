package com.techelevator.npgeek.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Survey;

@Controller
public class SurveyController {

	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(ModelMap modelHolder) {
		if(! modelHolder.containsAttribute("survey")) {
			modelHolder.put("survey", new Survey());
		}
		return "survey";
	}

	@RequestMapping(path="survey", method=RequestMethod.POST)
	public String processSurvey(@Valid @ModelAttribute Survey survey, BindingResult result,
			RedirectAttributes flash) {
		flash.addFlashAttribute("survey", survey);
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		return "redirect:surveyResults";
	}
}
