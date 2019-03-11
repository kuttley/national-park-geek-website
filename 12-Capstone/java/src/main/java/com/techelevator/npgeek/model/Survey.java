package com.techelevator.npgeek.model;

import java.util.regex.Pattern;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	@NotBlank(message="*")
	@Size(max=10)
	private String parkCode;
	@NotBlank(message="*")
	@Email
	@Size(max=100)
	private String email;
	@NotBlank(message="*")
	@Size(min=2,max=2)
	private String state;
	@NotBlank(message="*")
	@Size(min=6,max=15)
	private String activityLevel;
	
	@AssertTrue(message="* Valid Email Required")
	public boolean isEmailValid() {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pattern = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		return pattern.matcher(email).matches();
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
