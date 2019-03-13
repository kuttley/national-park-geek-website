package com.techelevator.npgeek.tests;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.techelevator.npgeek.model.*;

//Tests for com.techelevator.npgeek.model*
public class NPGeekTests {

	private static SingleConnectionDataSource dataSource;
	
	/* 
	 * Initialize the DataSource
	 */
	@Before
	public void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	/* 
	 * Rollback changes to database
	 * Close the DataSource
	 */
	@After
	public void closeDataSource() throws SQLException {
		dataSource.getConnection().rollback();
		dataSource.destroy();
	}
	
	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private SurveyDao surveyDao;
	
	@Test
	public void npgeek_Park_JdbcDao_GetInfoForPark_Test() {
		Park park = parkDao.getInfoForPark("GNP");
		Assert.assertTrue(park != null);
	}
	
	@Test
	public void npgeek_ParkJdbcDao_GetAllParks_Test() {
		List<Park> parksList = parkDao.getAllParks();
		Assert.assertEquals(parksList.size(),10);
	}
	
	@Test
	public void npgeek_WeatherJdbcDao_Test() {
		List<Weather> weatherForecastTest = weatherDao.getFiveDayForecast("GNP");
		Assert.assertEquals(weatherForecastTest.size(),5);
	}
	
	@Test
	public void npgeek_SurveyJdbcDao_Tests() {
		Survey survey1 = new Survey();
		survey1.setParkCode("GCNP");
		survey1.setEmail("testemail@tester.com");
		survey1.setState("OH");
		survey1.setActivityLevel("2");
		Survey survey2 = new Survey();
		survey1.setParkCode("GNP");
		survey1.setEmail("testemail@tester.com");
		survey1.setState("OH");
		survey1.setActivityLevel("1");
		Survey survey3 = new Survey();
		survey1.setParkCode("GTNP");
		survey1.setEmail("testemail@tester.com");
		survey1.setState("AL");
		survey1.setActivityLevel("2");
		surveyDao.saveSurvey(survey1);
		surveyDao.saveSurvey(survey2);
		surveyDao.saveSurvey(survey3);
		Map<Park,Integer> map = surveyDao.getVoteCount("", -1);
		Assert.assertEquals(map.size(),3);
		map = surveyDao.getVoteCount("OH", -1);
		Assert.assertEquals(map.size(),2);
		map = surveyDao.getVoteCount("", 2);
		Assert.assertEquals(map.size(),2);
		map = surveyDao.getVoteCount("OH", 2);
		Assert.assertEquals(map.size(),1);
	}
	
}
