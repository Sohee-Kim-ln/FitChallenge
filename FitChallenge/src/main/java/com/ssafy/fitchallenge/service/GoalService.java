package com.ssafy.fitchallenge.service;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.Daily;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Goal;

public interface GoalService {
	//	팀 목표 생성
	public int insertGoal(Goal goal);
	
	//	팀 id에 맞는 목표 리스트 가져오기
	public List<Goal> selectGoals(int teamId);
	
	//	목표 id에 맞는 목표 1개 가져오기(팀 달성인원계산X)
	public Goal selectGoal(int goalId);
	
//	//	목표 id에 맞는 목표 1개 정보를 팀 달성인원 계산 후 가져오기
//	public Goal selectGoalCal(int goalId);

	//	목표 id에 맞는 목표 안보이게 함
	public int updateVisible(int goalId);
}
