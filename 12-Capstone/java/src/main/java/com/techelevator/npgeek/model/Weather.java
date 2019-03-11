package com.techelevator.npgeek.model;

public class Weather {

	private int parkCode;
	private int forecastDay;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	
	public int getParkCode() {
		return parkCode;
	}
	public void setParkCode(int parkCode) {
		this.parkCode = parkCode;
	}
	public int getForecastDay() {
		return forecastDay;
	}
	public void setForecastDay(int forecastDay) {
		this.forecastDay = forecastDay;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
}
