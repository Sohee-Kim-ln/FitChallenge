package com.ssafy.fitchallenge.service;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.Daily;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;

public interface DailyService {
	//데일리 등록
	public int insertDaily(Daily daily);
	
	//데일리 여러개 등록
	public int insertDailies(List<Daily> dailies);
	
	//유저 id와 기간에 맞는 데일리 기록 가져오기
	public List<Daily> selectDailyByUser(DailySearchCondition condition);
	
	//팀 id와 기간에 맞는 데일리 기록 가져오기
	public List<Daily> selectDailyByTeam(DailySearchCondition condition);
	
	//데일리 id로 데일리 1개 정보 가져오기
	public Daily selectDaily(int dailyId);
}
