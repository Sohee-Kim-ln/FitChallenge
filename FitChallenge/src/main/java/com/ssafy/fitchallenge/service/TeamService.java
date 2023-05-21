package com.ssafy.fitchallenge.service;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.Team;
import com.ssafy.fitchallenge.model.dto.TeamSearchCondition;

public interface TeamService {
	//	팀 생성
	public int insertTeam(Team team);
	
	//	전체 팀 정보 가져오기
	public List<Team> selectTeamAll();
	
	//	검색 조건에 맞는 팀 리스트 가져오기
	public List<Team> selectTeams(TeamSearchCondition condition);
	
	//	팀 id에 해당하는 팀 1개 정보 가져오기
	public Team selectTeam(int teamId);
	
//	//후순위
//	//	팀 id에 해당하는 팀 정보 수정
//	public int updateTeam(int teamId);
	
	//	팀 id에 해당하는 팀 현재 인원 ++
	public int addCapacity(int teamId);
	
	//	팀 id에 해당하는 팀 현재 인원 --
	public int substractCapacity(int teamId);
	
//	//후순위
//	//	팀 id에 해당하는 팀 삭제
//	public int deleteTeamById(int teamId);
}
