package com.api.bean;

import java.util.Calendar;

public class User {

	private int userId;
	private String userFirstName;
	private String userLastName;
	private Calendar userBirth;
	private String userCountry;
	
	public User() {}

	public User(int userId, String userFirstName, String userLastName, Calendar userBirth, String userCountry) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userBirth = userBirth;
		this.userCountry = userCountry;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Calendar getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Calendar userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userBirth=" + userBirth + ", userCountry=" + userCountry + "]";
	}
	
}
