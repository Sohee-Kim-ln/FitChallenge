package com.ssafy.fitchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fitchallenge.model.dao.GoalDao;
import com.ssafy.fitchallenge.model.dto.Goal;

@Service
public class GoalServiceImpl implements GoalService{
	@Autowired
	private GoalDao gDao;

	@Transactional
	@Override
	public int insertGoal(Goal goal) {
		return gDao.insertGoal(goal);
	}

	@Override
	public List<Goal> selectGoals(int teamId) {
		return gDao.selectGoals(teamId);
	}

	@Override
	public Goal selectGoal(int goalId) {
		return gDao.selectGoal(goalId);
	}

//	@Override
//	public Goal selectGoalCal(int goalId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Transactional
	@Override
	public int updateVisible(int goalId) {
		return gDao.updateVisible(goalId);
	}

	
	
	
}
