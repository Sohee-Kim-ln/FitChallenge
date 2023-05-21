package com.ssafy.fitchallenge.model.dto;

public class Sports {
	private int sportsId;
	private String sportsName;
	
	public Sports() {
	}

	public Sports(int sportsId, String sportsName) {
		super();
		this.sportsId = sportsId;
		this.sportsName = sportsName;
	}

	public int getSportsId() {
		return sportsId;
	}

	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	@Override
	public String toString() {
		return "Sports [sportsId=" + sportsId + ", sportsName=" + sportsName + "]";
	}
	
	
}
