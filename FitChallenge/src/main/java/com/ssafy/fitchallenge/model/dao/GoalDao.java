package com.ssafy.fitchallenge.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.fitchallenge.model.dto.Goal;

public interface GoalDao {
	//	팀 목표 생성
	public int insertGoal(Goal goal);
	
	//	팀 id에 맞는 목표 리스트 가져오기
	public List<Goal> selectGoals(int teamId);
	
	//	목표 id에 맞는 목표 1개 가져오기(팀 달성인원계산X)
	public Goal selectGoal(int goalId);
	
	//  팀id와 스포츠 id에 맞는 목표 1개 가져오기
	public Goal selectGoalByTeamSports(@Param("teamId") int teamId,@Param("sportsId") int sportsId);
	
	//서버에서 계산
//	//	목표 id에 맞는 목표 1개 정보를 팀 달성인원 계산 후 가져오기
//	public Goal selectGoalCal(int goalId);

	//	목표 id에 맞는 목표 안보이게 함
	public int updateVisible(int goalId);
}
