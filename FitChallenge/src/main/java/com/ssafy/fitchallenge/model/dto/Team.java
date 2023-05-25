package com.ssafy.fitchallenge.model.dto;

public class Team {
	private int teamId;
	private String teamName;
	private String createTime;
	private int maxCapacity;
	private int curCapacity=1;
	private String info;
	private String announce;
	private String teamImg = "null";
	private String teamImgOrg = "null";
	private int teamArchieve;

	public Team() {
		
	}
	
	
	

	public Team(String teamName, int maxCapacity, String info) {
		super();
		this.teamName = teamName;
		this.maxCapacity = maxCapacity;
		this.info = info;
	}




	public Team(int teamId, String teamName, String createTime, int maxCapacity, int curCapacity, String info,
			String announce, String teamImg, String teamImgOrg, int teamArchieve) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.createTime = createTime;
		this.maxCapacity = maxCapacity;
		this.curCapacity = curCapacity;
		this.info = info;
		this.announce = announce;
		this.teamImg = teamImg;
		this.teamImgOrg = teamImgOrg;
		this.teamArchieve = teamArchieve;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurCapacity() {
		return curCapacity;
	}

	public void setCurCapacity(int curCapacity) {
		this.curCapacity = curCapacity;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAnnounce() {
		return announce;
	}

	public void setAnnounce(String announce) {
		this.announce = announce;
	}

	public String getTeamImg() {
		return teamImg;
	}

	public void setTeamImg(String teamImg) {
		this.teamImg = teamImg;
	}

	public String getTeamImgOrg() {
		return teamImgOrg;
	}

	public void setTeamImgOrg(String teamImgOrg) {
		this.teamImgOrg = teamImgOrg;
	}

	public int getTeamArchieve() {
		return teamArchieve;
	}

	public void setTeamArchieve(int teamArchieve) {
		this.teamArchieve = teamArchieve;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", createTime=" + createTime + ", maxCapacity="
				+ maxCapacity + ", curCapacity=" + curCapacity + ", info=" + info + ", announce=" + announce
				+ ", teamImg=" + teamImg + ", teamImgOrg=" + teamImgOrg + ", teamArchieve=" + teamArchieve + "]";
	}

	
	
	

}
