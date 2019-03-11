package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class SurveyJdbcDao implements SurveyDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SurveyJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Map<String,Integer> getVoteCount() {
		Map<String,Integer> map = new HashMap<String,Integer>();
		String selectParkCodes = "SELECT parkcode FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectParkCodes);
		List<String> parkCodesList = new ArrayList<String>();
		while(results.next()) {
			parkCodesList.add(results.getString("parkcode"));
		}
		for (String parkcode: parkCodesList) {
			map.put(parkcode,getVoteCountForPark(parkcode));
		}
		return map;
	}

	@Override
	public void saveSurvey(Survey survey) {
		String insertSurveyResults = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) "
								   + "Values (?,?,?,?)";
		jdbcTemplate.update(insertSurveyResults, survey.getParkCode(), survey.getEmail(),
																	survey.getState(), survey.getActivityLevel());
	}
	
	private int getVoteCountForPark(String parkcode) {
		String selectSurveysForPark = "SELECT COUNT(*) AS totalvotes FROM survey_result WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSurveysForPark, parkcode);
		if (results.next()) {
			return results.getInt("totalvotes");
		}
		return 0;
	}

}
