package com.techelevator.npgeek.model;

import java.util.LinkedHashMap;
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
	public Map<Park,Integer> getVoteCount(String state, int activityNum) {
		Map<Park,Integer> map = new LinkedHashMap<Park,Integer>();
		if (!state.isEmpty() && activityNum != -1) {
			String selectSurveysForPark = "SELECT parkcode, COUNT(*) AS totalvotes FROM survey_result WHERE state = ? AND activitylevel = ? GROUP BY parkcode ORDER BY totalvotes DESC, parkcode";
			map = getMap(selectSurveysForPark, state, activityNum);
		}
		else if (!state.isEmpty()) {
			String selectSurveysForPark = "SELECT parkcode, COUNT(*) AS totalvotes FROM survey_result WHERE state = ? GROUP BY parkcode ORDER BY totalvotes DESC, parkcode";
			map = getMap(selectSurveysForPark, state);
		}
		else if (activityNum != -1) {
			String selectSurveysForPark = "SELECT parkcode, COUNT(*) AS totalvotes FROM survey_result WHERE activitylevel = ? GROUP BY parkcode ORDER BY totalvotes DESC, parkcode";
			map = getMap(selectSurveysForPark, activityNum);
		}
		else {
			String selectSurveysForPark = "SELECT parkcode, COUNT(*) AS totalvotes FROM survey_result GROUP BY parkcode ORDER BY totalvotes DESC, parkcode";
			map = getMap(selectSurveysForPark);
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
	
	private Park createPark(String parkcode) {
		String selectPark = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectPark, parkcode);
		Park park = new Park();
		park.setParkCode(parkcode);
		if (results.next()) {
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setAcreage(results.getInt("acreage"));
			park.setElevationInFeet(results.getInt("elevationinfeet"));
			park.setMilesOfTrail(results.getDouble("milesoftrail"));
			park.setCampsites(results.getInt("numberofcampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getInt("yearfounded"));
			park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			park.setInspirationalQuote(results.getString("inspirationalquote"));
			park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			park.setDescription(results.getString("parkdescription"));
			park.setEntryFee(results.getInt("entryfee"));
			park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		}
		return park;
	}
	
	private String getActivityLevelString(int activityNum) {
		String activityLevel = "";
		if (activityNum == 0) {
			activityLevel = "inactive";
		}
		else if (activityNum == 1) {
			activityLevel = "sedentary";
		}
		else if (activityNum == 2) {
			activityLevel = "active";
		}
		else if (activityNum == 2) {
			activityLevel = "extremelyactive";
		}
		return activityLevel;
	}
	
	private Map<Park,Integer> getMap(String selectSurveysForPark) {
		Map<Park,Integer> map = new LinkedHashMap<Park,Integer>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSurveysForPark);
		while (results.next()) {
			String parkcode = results.getString("parkcode");
			map.put(createPark(parkcode), results.getInt("totalvotes"));
		}
		return map;
	}
	
	private Map<Park,Integer> getMap(String selectSurveysForPark, String state, int activityNum) {
		Map<Park,Integer> map = new LinkedHashMap<Park,Integer>();
		String activityLevel = getActivityLevelString(activityNum);
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSurveysForPark, state, activityLevel);
		while (results.next()) {
			String parkcode = results.getString("parkcode");
			map.put(createPark(parkcode), results.getInt("totalvotes"));
		}
		return map;
	}
	
	private Map<Park,Integer> getMap(String selectSurveysForPark, String state) {
		Map<Park,Integer> map = new LinkedHashMap<Park,Integer>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSurveysForPark, state);
		while (results.next()) {
			String parkcode = results.getString("parkcode");
			map.put(createPark(parkcode), results.getInt("totalvotes"));
		}
		return map;
	}
	
	private Map<Park,Integer> getMap(String selectSurveysForPark, int activityNum) {
		Map<Park,Integer> map = new LinkedHashMap<Park,Integer>();
		String activityLevel = getActivityLevelString(activityNum);
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSurveysForPark, activityLevel);
		while (results.next()) {
			String parkcode = results.getString("parkcode");
			map.put(createPark(parkcode), results.getInt("totalvotes"));
		}
		return map;
	}

}
