package com.ssafy.fitchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fitchallenge.model.dao.TeamDao;
import com.ssafy.fitchallenge.model.dto.Team;
import com.ssafy.fitchallenge.model.dto.TeamSearchCondition;

@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao tDao;

	@Transactional
	@Override
	public int insertTeam(Team team) {
		return tDao.insertTeam(team);
	}

	@Override
	public List<Team> selectTeamAll() {
		return tDao.selectTeamAll();
	}

	@Override
	public List<Team> selectTeams(TeamSearchCondition condition) {
		return tDao.selectTeams(condition);
	}

	@Override
	public Team selectTeam(int teamId) {
		return tDao.selectTeam(teamId);
	}

	@Transactional
	@Override
	public int addCapacity(int teamId) {
		return tDao.addCapacity(teamId);
	}

	@Transactional
	@Override
	public int substractCapacity(int teamId) {
		return tDao.substractCapacity(teamId);
	}

	
	
	
}
