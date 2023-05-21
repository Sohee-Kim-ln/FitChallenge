package com.ssafy.fitchallenge.model.dto;

public class DailySearchCondition {
	private String userId=null;
	private int sportsId;
	private int teamId;
	private int year;
	private int month;
	private int week;
	
	public DailySearchCondition() {
		
	}

	public DailySearchCondition(String userId, int sportsId, int teamId, int year, int month, int week) {
		super();
		this.userId = userId;
		this.sportsId = sportsId;
		this.teamId = teamId;
		this.year = year;
		this.month = month;
		this.week = week;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSportsId() {
		return sportsId;
	}

	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "DailySearchCondition [userId=" + userId + ", sportsId=" + sportsId + ", teamId=" + teamId + ", year="
				+ year + ", month=" + month + ", week=" + week + "]";
	}

	

	
	
}


