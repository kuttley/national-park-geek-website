package com.techelevator.npgeek.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.WeatherDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class NPGeekController {
	
	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping("/") 
	public String displayHomePage(ModelMap modelMap) {
		modelMap.addAttribute("parksList", parkDao.getAllParks());
		return "homepage";
	}
	
	@RequestMapping("/park")
	public String displayParkDetailPage(@RequestParam String id, ModelMap modelMap) {
		modelMap.addAttribute("park", parkDao.getInfoForPark(id));
		modelMap.addAttribute("weather", weatherDao.getFiveDayForecast(id));
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(ModelMap modelMap) {
		modelMap.addAttribute("parksList", parkDao.getAllParks());
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String handleSurveyPost(@ModelAttribute Survey survey, BindingResult result) {
		if (result.hasErrors() || survey.getParkCode().isEmpty() || survey.getState().isEmpty() || survey.getActivityLevel().isEmpty()) {
			return "survey";
		}
		surveyDao.saveSurvey(survey);
		return "redirect:favoriteParks";
	}
	
	@RequestMapping("/favoriteParks")
	public String displayFavoriteParksPage(ModelMap modelMap) {
		modelMap.addAttribute("parksList", parkDao.getAllParks());
		modelMap.addAttribute("surveys", surveyDao.getVoteCount());
		return "favoriteParks";
	}
	
}
