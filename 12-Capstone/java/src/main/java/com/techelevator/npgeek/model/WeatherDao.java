package com.techelevator.npgeek.model;

import java.util.List;

public interface WeatherDao {
	
	List<Weather> getFiveDayForecast(String parkcode);
	
}
