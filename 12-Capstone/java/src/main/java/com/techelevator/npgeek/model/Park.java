package com.techelevator.npgeek.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Park {
	@NotBlank
	@Size(min=1,max=10)
	private String parkCode;
	@NotBlank
	@Size(min=1,max=200)
	private String parkName;
	@NotBlank
	@Size(min=1,max=30)
	private String state;
	@NotNull
	@Min(value=0)
	private Integer acreage;
	@NotNull
	private Integer elevationInFeet;
	@NotNull
	@Min(value=0)
	private Double milesOfTrail;
	@NotNull
	@Min(value=0)
	private Integer campsites;
	@NotBlank
	@Size(min=1,max=100)
	private String climate;
	@NotNull
	@Min(value=0)
	private Integer yearFounded;
	@NotNull
	@Min(value=0)
	private Integer annualVisitorCount;
	@NotBlank
	@Size(min=1)
	private String inspirationalQuote;
	@NotBlank
	@Size(min=1,max=200)
	private String inspirationalQuoteSource;
	@NotBlank
	@Size(min=1)
	private String description;
	@NotNull
	@Min(value=0)
	private Integer entryFee;
	@NotNull
	@Min(value=0)
	private Integer numberOfAnimalSpecies;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAcreage() {
		return acreage;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public int getElevationInFeet() {
		return elevationInFeet;
	}
	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public double getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getCampsites() {
		return campsites;
	}
	public void setCampsites(int campsites) {
		this.campsites = campsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}
	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	
}
