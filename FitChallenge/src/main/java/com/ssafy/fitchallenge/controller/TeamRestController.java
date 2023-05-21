package com.ssafy.fitchallenge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Goal;
import com.ssafy.fitchallenge.model.dto.Team;
import com.ssafy.fitchallenge.model.dto.TeamSearchCondition;
import com.ssafy.fitchallenge.model.dto.Weekly;
import com.ssafy.fitchallenge.service.GoalService;
import com.ssafy.fitchallenge.service.TeamService;
import com.ssafy.fitchallenge.service.WeeklyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/team")
@Api(tags = "팀 컨트롤러")
public class TeamRestController {
	@Autowired
	private TeamService tService;

	@Autowired
	private GoalService gService;

	@Autowired
	private WeeklyService wService;

	@ApiOperation(value = "팀 생성")
	@PostMapping("/create")
	public ResponseEntity<?> createTeam(@RequestBody Team team) {
		int res = tService.insertTeam(team);

		if (res == 0)
			return new ResponseEntity<String>("0 row inserted. wrong request", HttpStatus.OK);
		else
			return new ResponseEntity<Team>(team, HttpStatus.CREATED);
	}

	@ApiOperation(value = "전체 팀 정보 가져오기")
	@GetMapping
	public ResponseEntity<?> listTeam() {
		List<Team> tList = tService.selectTeamAll();

		if (tList == null || tList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Team>>(tList, HttpStatus.OK);
	}

	@ApiOperation(value = "팀 메인에 표시할 팀정보, 팀 목표, 팀에 속한 유저 정보,각 유저의 위클리 정보 가져오기")
	@GetMapping("/team/main/{teamId}")
	public ResponseEntity<?> mainTeam(@PathVariable int teamId) {
		Map<String, Object> map = new HashMap<>();

		// 팀정보
		Team team = tService.selectTeam(teamId);
		
		// 팀 목표
		List<Goal> glist = gService.selectGoals(teamId);

		// 팀에 속한 유저들의, 팀 목표들에 해당하는 이번 주 위클리 전부 가져오기(성취도 계산 아직 안함)
		List<Weekly> wlist = wService.getTeamWeeklysThisWeek(teamId);

		// 목표에 따른 위클리 성취도 계산해서 입력하기
		//위클리 리스트 요소들에 대해 반복
		for (int i = 0; i < wlist.size(); i++) {
			//위클리 1개 지정
			Weekly weekly = wlist.get(i);
			
			//목표 리스트 요소들에 대해 반복
			for (int j = 0; j < glist.size(); j++) {
				//목표 1개 지정
				Goal goal = glist.get(j);
				
				//위클리와 목표의 스포츠id가 같다면(목표에 해당하는 위클리라면) 성취도 계산
				if (weekly.getSportsId() == goal.getSportsId()) {
					int timeSum = weekly.getTimeSum();
					int distanceSum = weekly.getDistanceSum();

					int goalTime = goal.getGoalTime();
					int goalDistance = goal.getGoalDistance();

					int archieve = (timeSum / goalTime + distanceSum / goalDistance) / 2;

					//계산된 성취도 저장
					weekly.setWeeklyAchieve(archieve);
					break;
				}
			}
		}
		
		//팀정보, 팀목표, 성취도 계산된 위클리목록을 맵에 넣기
		map.put("team", team);
		map.put("glist", glist);
		map.put("wlist", wlist);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@ApiOperation(value = "검색 조건에 맞는 팀 리스트 가져오기")
	@GetMapping("/search/{word}/{orderBy}")
	public ResponseEntity<?> searchTeam(@PathVariable String word, @PathVariable String orderBy) {
		TeamSearchCondition condition = new TeamSearchCondition();
		condition.setWord(word);
		condition.setOrderBy(orderBy);
		
		List<Team> teamList = tService.selectTeams(condition);
		
		
		if (teamList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(teamList, HttpStatus.OK);
	}

	@ApiOperation(value = "팀 id에 해당하는 팀 1개 정보 가져오기")
	@GetMapping("/{teamId}")
	public ResponseEntity<?> detailTeam(@PathVariable int teamId) {
		Team team = tService.selectTeam(teamId);

		if (team == null)
			return new ResponseEntity<Team>(team, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Team>(team, HttpStatus.OK);
	}

}
