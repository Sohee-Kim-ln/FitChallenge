package com.ssafy.fitchallenge.model.dto;

public class Weekly {
	private int year;
	private int month;
	private int week;
	private String userId;
	private int sportsId;
	private int timeSum;
	private int distanceSum;
	private int weeklyAchieve;

	
	public Weekly() {
		
	}


	public Weekly(int year, int month, int week, String userId, int sportsId, int timeSum, int distanceSum,
			int weeklyAchieve) {
		super();
		this.year = year;
		this.month = month;
		this.week = week;
		this.userId = userId;
		this.sportsId = sportsId;
		this.timeSum = timeSum;
		this.distanceSum = distanceSum;
		this.weeklyAchieve = weeklyAchieve;
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


	public int getTimeSum() {
		return timeSum;
	}


	public void setTimeSum(int timeSum) {
		this.timeSum = timeSum;
	}


	public int getDistanceSum() {
		return distanceSum;
	}


	public void setDistanceSum(int distanceSum) {
		this.distanceSum = distanceSum;
	}


	public int getWeeklyAchieve() {
		return weeklyAchieve;
	}


	public void setWeeklyAchieve(int weeklyAchieve) {
		this.weeklyAchieve = weeklyAchieve;
	}


	@Override
	public String toString() {
		return "Weekly [year=" + year + ", month=" + month + ", week=" + week + ", userId=" + userId + ", sportsId="
				+ sportsId + ", timeSum=" + timeSum + ", distanceSum=" + distanceSum + ", weeklyAchieve="
				+ weeklyAchieve + "]";
	}

	

	
	
}
