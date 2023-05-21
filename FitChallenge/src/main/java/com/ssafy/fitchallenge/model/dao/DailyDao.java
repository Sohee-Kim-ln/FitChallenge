package com.ssafy.fitchallenge.model.dao;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.Daily;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Weekly;

public interface DailyDao {
	//데일리 등록
	public int insertDaily(Daily daily);
	
	//유저 id와 기간에 맞는 데일리 기록 가져오기
	public List<Daily> selectDailyByUser(DailySearchCondition condition);
	
	//팀 id와 기간에 맞는 데일리 기록 가져오기
	public List<Daily> selectDailyByTeam(DailySearchCondition condition);
	
	//위클리 계산을 위해 유저 id와 팀 id에 맞는 이번주 기록들을 위클리 형태로 가져오기
	public List<Weekly> selectWeeklyToday(DailySearchCondition condition);
	
	//팀에 속한 유저들의, 팀 목표들에 해당하는 이번 주 위클리 전부 가져오기(성취도 계산 안함)
	public List<Weekly> selectWeeklysThisWeek(int teamId);
	
	//팀에 속한 유저들의 특정 연월 위클리 전부 가져오기(성취도 계산 안함)
	public List<Weekly> selectWeeklysByYM(DailySearchCondition condition);
	
	//데일리 id로 데일리 1개 정보 가져오기
	public Daily selectDaily(int dailyId);
}
