package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class WeatherJdbcDao implements WeatherDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public WeatherJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getFiveDayForecast(String parkcode) {
		List<Weather> fiveDayForecast = new ArrayList<Weather>();
		fiveDayForecast.add(getWeatherForecastForOneDay(parkcode, 1));
		fiveDayForecast.add(getWeatherForecastForOneDay(parkcode, 2));
		fiveDayForecast.add(getWeatherForecastForOneDay(parkcode, 3));
		fiveDayForecast.add(getWeatherForecastForOneDay(parkcode, 4));
		fiveDayForecast.add(getWeatherForecastForOneDay(parkcode, 5));
		return fiveDayForecast;
	}
	
	private Weather getWeatherForecastForOneDay(String parkcode, int day) {
		Weather oneDayForecast = new Weather();
		String selectWeatherForOneDay = "SELECT * FROM weather WHERE parkcode = ? AND fivedayforecastvalue = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectWeatherForOneDay, parkcode, day);
		oneDayForecast.setParkCode(parkcode);
		oneDayForecast.setForecastDay(day);
		while(results.next()) {
			oneDayForecast.setLowTempF(results.getInt("low"));
			oneDayForecast.setHighTempF(results.getInt("high"));
			oneDayForecast.setLowTempC(oneDayForecast.getLowTempF());
			oneDayForecast.setHighTempC(oneDayForecast.getHighTempF());
			oneDayForecast.setForecast(getCamelCaseForecast(results.getString("forecast").split(" ")));
		}
		return oneDayForecast;
	}
	
	private String getCamelCaseForecast(String[] splitForecast) {
		String camelCased = "";
		camelCased += splitForecast[0];
		for (int i = 1; i < splitForecast.length; i++) {
			if (splitForecast[i] != null && !splitForecast[i].isEmpty()) {
				camelCased += splitForecast[i].substring(0, 1).toUpperCase();
				camelCased += splitForecast[i].substring(1).toLowerCase();
			}
		}
		
		return camelCased;
	}

}
