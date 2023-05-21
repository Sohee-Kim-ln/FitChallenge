package com.ssafy.fitchallenge.model.dto;

public class TeamSearchCondition {
	//이름으로만 검색되므로 key 없음
	private String word;
	private String orderBy;

	public TeamSearchCondition() {
		
	}

	public TeamSearchCondition(String word, String orderBy) {
		super();
		this.word = word;
		this.orderBy = orderBy;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "TeamSearchCondition [word=" + word + ", orderBy=" + orderBy + "]";
	}

}
