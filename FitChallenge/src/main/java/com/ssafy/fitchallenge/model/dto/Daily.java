package com.ssafy.fitchallenge.model.dto;

public class Daily {
	private int dailyId;
	private String userId;
	private int sportsId;
	private String date;
	private int dailyTime;
	private int dailyDistance;
	private String comment="null";
	
	public Daily() {
		
	}

	public Daily(int dailyId, String userId, int sportsId, String date, int dailyTime, int dailyDistance,
			String comment) {
		super();
		this.dailyId = dailyId;
		this.userId = userId;
		this.sportsId = sportsId;
		this.date = date;
		this.dailyTime = dailyTime;
		this.dailyDistance = dailyDistance;
		this.comment = comment;
	}

	public int getDailyId() {
		return dailyId;
	}

	public void setDailyId(int dailyId) {
		this.dailyId = dailyId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDailyTime() {
		return dailyTime;
	}

	public void setDailyTime(int dailyTime) {
		this.dailyTime = dailyTime;
	}

	public int getDailyDistance() {
		return dailyDistance;
	}

	public void setDailyDistance(int dailyDistance) {
		this.dailyDistance = dailyDistance;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Daily [dailyId=" + dailyId + ", userId=" + userId + ", sportsId=" + sportsId + ", date=" + date
				+ ", dailyTime=" + dailyTime + ", dailyDistance=" + dailyDistance + ", comment=" + comment + "]";
	}

	
	
}


