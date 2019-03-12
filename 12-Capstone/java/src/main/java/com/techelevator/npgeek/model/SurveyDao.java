package com.techelevator.npgeek.model;

import java.util.Map;

public interface SurveyDao {
	
	Map<Park,Integer> getVoteCount();
	
	Map<Park,Integer> getVoteCount(String state, int activityNum);
	
	Map<Park,Integer> getVoteCount(String state);
	
	Map<Park,Integer> getVoteCount(int activityNum);
	
	void saveSurvey(Survey survey);
	
}
