package com.techelevator.npgeek.model;

import java.util.Map;

public interface SurveyDao {
	
	Map<String,Integer> getVoteCount();
	
	void saveSurvey(Survey survey);
	
}
