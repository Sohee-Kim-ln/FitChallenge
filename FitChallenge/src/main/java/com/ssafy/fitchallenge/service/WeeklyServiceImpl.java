package com.ssafy.fitchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitchallenge.model.dao.DailyDao;
import com.ssafy.fitchallenge.model.dao.GoalDao;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Goal;
import com.ssafy.fitchallenge.model.dto.Weekly;

@Service
public class WeeklyServiceImpl implements WeeklyService{
	@Autowired
	private DailyDao dDao;
	
	@Autowired
	private GoalDao gDao;

	@Override
	public List<Weekly> calcWeekly(DailySearchCondition condition) {
//		System.out.println("inner con="+condition);
//		List<Weekly> wlist=dDao.selectWeeklyToday(condition);
//		System.out.println(wlist);
//		Goal goal = gDao.selectGoalByTeamSports(condition.getTeamId(), condition.getSportsId());
//		
//		int timeSum=weekly.getTimeSum();
//		int distanceSum = weekly.getDistanceSum();
//		
//		int goalTime=goal.getGoalTime();
//		int goalDistance = goal.getGoalDistance();
//		
//		int archieve = (timeSum/goalTime + distanceSum/goalDistance)/2;
//		
//		weekly.setWeeklyAchieve(archieve);
//				
//		return weekly;
		return null;
	}

	//팀에 속한 유저들의, 팀 목표들에 해당하는 이번 주 위클리 전부 가져오기(성취도 계산 안함)
	@Override
	public List<Weekly> getTeamWeeklysThisWeek(int teamId) {
		List<Weekly> wlist=dDao.selectWeeklysThisWeek(teamId);
		return wlist;
	}

	//팀에 속한 유저들의 특정 연월 위클리 전부 가져오기(성취도 계산 안함)
	@Override
	public List<Weekly> getTeaWeeklysByYM(DailySearchCondition condition) {
		List<Weekly> wlist=dDao.selectWeeklysByYM(condition);
		return null;
	}
	
	
}
