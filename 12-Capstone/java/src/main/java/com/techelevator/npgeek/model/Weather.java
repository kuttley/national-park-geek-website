package com.techelevator.npgeek.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Weather {
	@NotBlank
	@Size(min=1,max=10)
	private String parkCode;
	@NotNull
	@Range(min=1,max=5)
	private Integer forecastDay;
	@NotNull
	private Double lowTempF;
	@NotNull
	private Double lowTempC;
	@NotNull
	private Double highTempF;
	@NotNull
	private Double highTempC;
	@NotBlank
	@Size(min=1,max=100)
	private String forecast;
	@NotBlank
	@Size(min=1,max=20)
	private String day;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getForecastDay() {
		return forecastDay;
	}
	public void setForecastDay(int forecastDay) {
		this.forecastDay = forecastDay;
	}
	public double getLowTempF() {
		return lowTempF;
	}
	public void setLowTempF(double lowTempF) {
		this.lowTempF = lowTempF;
	}
	public double getHighTempF() {
		return highTempF;
	}
	public void setHighTempF(double highTempF) {
		this.highTempF = highTempF;
	}
	public double getLowTempC() {
		return lowTempC;
	}
	public void setLowTempC(double lowTempF) {
		this.lowTempC = (lowTempF - 32)/1.8;
	}
	public double getHighTempC() {
		return highTempC;
	}
	public void setHighTempC(double highTempF) {
		this.highTempC = (highTempF - 32)/1.8;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getDay() {
		return day;
	}
	public void setDay() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		if (forecastDay == 1) {
			day = "Today";
		}
		else if (forecastDay == 2) {
			day = "Tomorrow";
		}
		else {
			day = DayOfWeek.of(dayOfWeek.getValue() - (forecastDay - 2)).toString();
		}
	}
}
