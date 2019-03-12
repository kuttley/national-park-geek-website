package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.WeatherDao;

@Controller
public class NPGeekController {
	
	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private SurveyDao surveyDao;
	
	private List<Park> parksList;
	
	@RequestMapping("/") 
	public String displayHomePage(HttpSession session) {
		populateParksList(session);
		return "homepage";
	}
	
	@RequestMapping("/park")
	public String displayParkDetailPage(@RequestParam String id, ModelMap modelMap, HttpSession session) {
		if (session.getAttribute("tempScale") == null) {
			session.setAttribute("tempScale", "F");
		}
		modelMap.addAttribute("park", parkDao.getInfoForPark(id));
		modelMap.addAttribute("weather", weatherDao.getFiveDayForecast(id));
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(ModelMap modelHolder, ModelMap modelMap, HttpSession session) {
		if( ! modelHolder.containsAttribute("survey")){
            modelHolder.put("survey", new Survey());
		}
		populateParksList(session);
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String handleSurveyPost(@Valid @ModelAttribute Survey survey, BindingResult result,
									RedirectAttributes flash) {
        flash.addFlashAttribute("survey", survey);
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
        }
		surveyDao.saveSurvey(survey);
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping("/favoriteParks")
	public String displayFavoriteParksPage(ModelMap modelMap) {
		modelMap.addAttribute("surveys", surveyDao.getVoteCount());
		return "favoriteParks";
	}
	
	private void populateParksList(HttpSession session) {
		if (parksList == null || parksList.isEmpty()) {
			parksList = parkDao.getAllParks();
			if (session.getAttribute("parksList") == null) {
				session.setAttribute("parksList", parksList);
			}
		}
	}
}
