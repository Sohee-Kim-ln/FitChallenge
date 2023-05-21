package com.ssafy.fitchallenge.model.dto;

public class Goal {
	private int goalId;
	private int teamId;
	private int sportsId;
	private int goalTime;
	private int goalDistance;

	
	public Goal() {
		
	}


	public Goal(int goalId, int teamId, int sportsId, int goalTime, int goalDistance) {
		super();
		this.goalId = goalId;
		this.teamId = teamId;
		this.sportsId = sportsId;
		this.goalTime = goalTime;
		this.goalDistance = goalDistance;
	}


	public int getGoalId() {
		return goalId;
	}


	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}


	public int getTeamId() {
		return teamId;
	}


	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


	public int getSportsId() {
		return sportsId;
	}


	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}


	public int getGoalTime() {
		return goalTime;
	}


	public void setGoalTime(int goalTime) {
		this.goalTime = goalTime;
	}


	public int getGoalDistance() {
		return goalDistance;
	}


	public void setGoalDistance(int goalDistance) {
		this.goalDistance = goalDistance;
	}


	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", teamId=" + teamId + ", sportsId=" + sportsId + ", goalTime=" + goalTime
				+ ", goalDistance=" + goalDistance + "]";
	}

	
}
