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
	public Map<Park,Integer> getVoteCount() {
		Map<Park,Integer> map = new HashMap<Park,Integer>();
		String selectParkCodes = "SELECT parkcode FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectParkCodes);
		List<String> parkCodesList = new ArrayList<String>();
		while(results.next()) {
			parkCodesList.add(results.getString("parkcode"));
		}
		for (String parkcode: parkCodesList) {
			map.put(createPark(parkcode),getVoteCountForPark(parkcode));
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

}
