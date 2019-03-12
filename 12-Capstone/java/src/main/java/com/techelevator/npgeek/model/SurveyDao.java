package com.techelevator.npgeek.model;

import java.util.Map;

public interface SurveyDao {
	
	Map<Park,Integer> getVoteCount(String state, int activityNum);
	
	void saveSurvey(Survey survey);
	
}
