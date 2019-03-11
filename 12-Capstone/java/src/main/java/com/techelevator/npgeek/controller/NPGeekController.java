package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NPGeekController {
	
	@RequestMapping("/") 
	public String displayHomePage() {
		return "homepage";
	}
	
	@RequestMapping("/park")
	public String displayParkDetailPage(@RequestParam String id) {
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurveyPage() {
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String handleSurveyPost() {
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping("/favoriteParks")
	public String displayFavoriteParksPage() {
		return "favoriteParks";
	}
	
}
