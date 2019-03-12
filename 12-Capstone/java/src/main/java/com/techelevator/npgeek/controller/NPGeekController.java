package com.techelevator.npgeek.controller;

import java.util.List;

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
	public String displayHomePage(ModelMap modelMap) {
		populateParksList(modelMap);
		return "homepage";
	}
	
	@RequestMapping(path="/park", method=RequestMethod.GET)
	public String displayParkDetailPage(@RequestParam String id, ModelMap modelMap, HttpSession session) {
		if (session.getAttribute("tempScale") == null) {
			session.setAttribute("tempScale", "F");
		}
		modelMap.addAttribute("park", parkDao.getInfoForPark(id));
		modelMap.addAttribute("weather", weatherDao.getFiveDayForecast(id));
		return "parkDetail";
	}
	
	@RequestMapping(path="/park", method=RequestMethod.POST)
	public String handleParkDetailPage(@RequestParam String id, @RequestParam(required=false) String tempScaleChange, ModelMap modelMap, HttpSession session) {
		if (tempScaleChange != null) {
			session.setAttribute("tempScale", tempScaleChange.substring(tempScaleChange.length() - 1));
		}
		if (session.getAttribute("tempScale") == null) {
			session.setAttribute("tempScale", "F");
		}
		return "redirect:/park?id="+id;
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(ModelMap modelHolder, ModelMap modelMap) {
		if( ! modelHolder.containsAttribute("survey")){
            modelHolder.put("survey", new Survey());
		}
		populateParksList(modelMap);
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
	
	@RequestMapping(path="/favoriteParks", method=RequestMethod.GET)
	public String displayFavoriteParksPage(ModelMap modelHolder, ModelMap modelMap, HttpSession session) {
		if (session.getAttribute("state") == null) {
			session.setAttribute("state", "");
		}
		if (String.valueOf(session.getAttribute("activityNum")).isEmpty()) {
			session.setAttribute("activityNum", "-1");
		}
		if( ! modelHolder.containsAttribute("state")){
			session.setAttribute("state", "");
		}
		if( ! modelHolder.containsAttribute("activityNum")){
			session.setAttribute("activityNum", -1);
		}
		modelMap.addAttribute("surveys", surveyDao.getVoteCount(String.valueOf(session.getAttribute("state")), Integer.parseInt(String.valueOf(session.getAttribute("activityNum")))));
		return "favoriteParks";
	}
	
	@RequestMapping(path="/favoriteParks", method=RequestMethod.POST)
	public String handleFavoriteParksPage(@Valid @ModelAttribute String stateChosen, BindingResult result1,
										@Valid @ModelAttribute String activityNumChosen, BindingResult result2,
										RedirectAttributes flash, HttpSession session) {
		session.setAttribute("state", stateChosen);
		session.setAttribute("activityNum", activityNumChosen);
		flash.addFlashAttribute("state", stateChosen);
		flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "state", result1);
		flash.addFlashAttribute("activityNum", activityNumChosen);
		flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "activityNum", result2);
		return "redirect:/favoriteParks";
	}
	
	private void populateParksList(ModelMap modelMap) {
		if (parksList == null || parksList.isEmpty()) {
			parksList = parkDao.getAllParks();
		}
		modelMap.addAttribute("parksList", parksList);
	}
}
