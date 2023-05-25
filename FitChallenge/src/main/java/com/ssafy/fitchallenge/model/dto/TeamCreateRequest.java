package com.ssafy.fitchallenge.model.dto;

public class TeamCreateRequest {
	private String teamName;
	private int maxCapacity;
	private String info;
	private String userId;
	
	public TeamCreateRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public TeamCreateRequest(String teamName, int maxCapacity, String info, String userId) {
		super();
		this.teamName = teamName;
		this.maxCapacity = maxCapacity;
		this.info = info;
		this.userId = userId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TeamCreateRequest [teamName=" + teamName + ", maxCapacity=" + maxCapacity + ", info=" + info
				+ ", userId=" + userId + "]";
	}
	
	
	
	
	
}
