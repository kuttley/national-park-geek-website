package com.techelevator.npgeek.model;

import java.util.Map;

public interface SurveyDao {
	
	Map<Park,Integer> getVoteCount();
	
	void saveSurvey(Survey survey);
	
}
