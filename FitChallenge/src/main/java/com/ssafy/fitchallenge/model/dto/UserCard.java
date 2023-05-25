package com.ssafy.fitchallenge.model.dto;

import java.util.List;

public class UserCard implements Comparable<UserCard>{
	private String userId;
	private String nickname;
	private String userImg;
	private String regDate;
	private List<Weekly> personalWeekly;
	private int totalArchieve;

	
	//위클리 추가 메서드
	public void addWeekly(Weekly weekly) {
		this.personalWeekly.add(weekly);
	}
	
	//생성자
	public UserCard() {
	}

	public UserCard(String userId, String nickname, String userImg) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.userImg = userImg;
	}

	public UserCard(String userId, String nickname, String userImg, List<Weekly> personalWeekly) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.userImg = userImg;
		this.personalWeekly = personalWeekly;
	}



	public UserCard(String userId, String nickname, String userImg, String regDate, List<Weekly> personalWeekly,
			int totalArchieve) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.userImg = userImg;
		this.regDate = regDate;
		this.personalWeekly = personalWeekly;
		this.totalArchieve = totalArchieve;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public List<Weekly> getPersonalWeekly() {
		return personalWeekly;
	}

	public void setPersonalWeekly(List<Weekly> personalWeekly) {
		this.personalWeekly = personalWeekly;
	}

	public int getTotalArchieve() {
		return totalArchieve;
	}

	public void setTotalArchieve(int totalArchieve) {
		this.totalArchieve = totalArchieve;
	}

	
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	
	@Override
	public String toString() {
		return "UserCard [userId=" + userId + ", nickname=" + nickname + ", userImg=" + userImg + ", regDate=" + regDate
				+ ", personalWeekly=" + personalWeekly + ", totalArchieve=" + totalArchieve + "]";
	}

	@Override
	public int compareTo(UserCard o) {
		return o.totalArchieve-this.totalArchieve;
	}

}
