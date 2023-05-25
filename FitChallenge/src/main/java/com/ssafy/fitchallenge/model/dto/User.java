package com.ssafy.fitchallenge.model.dto;

public class User {
	private String userId;
	private String password;
	private String userName;
	private String nickname;
	private String birthDate;
	private int gender;//0남성 1여성 2선택안함
	private String recentLogin;
	private int continued;
	private String regDate;
	private String joinDate;
	private String userImg;
	private String userImgOrg;
	private int teamId;
	private boolean isOwner;
	
	public User() {
		
	}

	public User(String userId, String password, String userName, String nickname, String birthDate, int gender,
			String recentLogin, int continued, String regDate, String userImg, String userImgOrg, int teamId,
			boolean isOwner) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.nickname = nickname;
		this.birthDate = birthDate;
		this.gender = gender;
		this.recentLogin = recentLogin;
		this.continued = continued;
		this.regDate = regDate;
		this.userImg = userImg;
		this.userImgOrg = userImgOrg;
		this.teamId = teamId;
		this.isOwner = isOwner;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getRecentLogin() {
		return recentLogin;
	}

	public void setRecentLogin(String recentLogin) {
		this.recentLogin = recentLogin;
	}

	public int getContinued() {
		return continued;
	}

	public void setContinued(int continued) {
		this.continued = continued;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserImgOrg() {
		return userImgOrg;
	}

	public void setUserImgOrg(String userImgOrg) {
		this.userImgOrg = userImgOrg;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userName=" + userName + ", nickname=" + nickname
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", recentLogin=" + recentLogin + ", continued="
				+ continued + ", regDate=" + regDate + ", userImg=" + userImg + ", userImgOrg=" + userImgOrg
				+ ", teamId=" + teamId + ", isOwner=" + isOwner + "]";
	}
	
}
