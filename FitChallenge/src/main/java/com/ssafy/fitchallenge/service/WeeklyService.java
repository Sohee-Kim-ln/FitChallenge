package com.ssafy.fitchallenge.service;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Weekly;

public interface WeeklyService {

	//성취도 계산해서 위클리 가져오기
	//위클리 계산을 위해 유저 id와 팀 id에 맞는 이번주 기록들을 위클리 형태로 가져오기
	public List<Weekly> calcWeekly(DailySearchCondition condition);
	
	//구현 보류. 필요한가? 일단은 후순위
//	//성취도 계산 없이 위클리 가져오기
//	public Weekly getWeekly(DailySearchCondition condition);
//	
	
	// 주 단위로 총 거리, 총 시간 합산 데이터 가져오기
	public List<Weekly> weekStat(DailySearchCondition condition);
	
	// 월 단위로 총 거리, 총 시간 합산 데이터 가져오기
	public List<Weekly> monthStat(DailySearchCondition condition);
	
	// 년 단위로 총 거리, 총 시간 합산 데이터 가져오기
	public List<Weekly> yearStat(DailySearchCondition condition);
	
	//팀에 속한 유저들의, 팀 목표들에 해당하는 이번 주 위클리 전부 가져오기(성취도 계산 안함)
	public List<Weekly> getTeamWeeklysThisWeek(int teamId);
	
	//팀에 속한 유저들의 특정 연월 위클리 전부 가져오기(성취도 계산 안함)
	public List<Weekly> getTeaWeeklysByYM(DailySearchCondition condition);
}
