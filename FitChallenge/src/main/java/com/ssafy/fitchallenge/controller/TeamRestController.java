package com.ssafy.fitchallenge.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
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

import com.ssafy.fitchallenge.model.dto.Goal;
import com.ssafy.fitchallenge.model.dto.Team;
import com.ssafy.fitchallenge.model.dto.TeamCreateRequest;
import com.ssafy.fitchallenge.model.dto.TeamSearchCondition;
import com.ssafy.fitchallenge.model.dto.User;
import com.ssafy.fitchallenge.model.dto.UserCard;
import com.ssafy.fitchallenge.model.dto.Weekly;
import com.ssafy.fitchallenge.service.GoalService;
import com.ssafy.fitchallenge.service.TeamService;
import com.ssafy.fitchallenge.service.UserService;
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

	@Autowired
	private UserService uService;

	@ApiOperation(value = "팀 생성")
	@PostMapping("/create")
	public ResponseEntity<?> createTeam(@RequestBody TeamCreateRequest req) {
		String teamName = req.getTeamName();
		int maxCapacity = req.getMaxCapacity();
		String info = req.getInfo();
		String userId = req.getUserId();

		Team team = new Team(teamName, maxCapacity, info);
		System.out.println(team);
		System.out.println(userId);

		User user = uService.selectUserById(userId);

		// 유저가 팀에 가입되어 있으면
		if (user.getTeamId() != 0) {
			return new ResponseEntity<>("already in a team", HttpStatus.NO_CONTENT);
		} else {
			// team 테이블에 새로운 행 추가
			int res = tService.insertTeam(team);

			if (res != 0) {
				// user 테이블의 teamId 업데이트
				int teamId = team.getTeamId();
				uService.joinTeam(teamId, userId);
				uService.ownerTrue(userId);
				return new ResponseEntity<>(teamId, HttpStatus.CREATED);
			} else
				return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
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
	@GetMapping("/main/{teamId}")
	public ResponseEntity<?> mainTeam(@PathVariable int teamId) {
		// 응답에 데이터 담을 Map
		Map<String, Object> map = new HashMap<>();

		// 팀정보
		Team team = tService.selectTeam(teamId);

		// 팀 목표
		List<Goal> glist = gService.selectGoals(teamId);

		// 팀 유저목록 가져오기
		List<User> ulist = uService.selectUserByTeam(teamId);

		// 팀 유저수만큼 유저카드 만들기
		List<UserCard> clist = new LinkedList<UserCard>();

		if (ulist != null)
			for (int i = 0; i < ulist.size(); i++) {
				User thisUser = ulist.get(i);
				UserCard thisCard = new UserCard(thisUser.getUserId(), thisUser.getNickname(), thisUser.getUserImg(),
						new LinkedList<Weekly>());
				thisCard.setRegDate(thisUser.getRegDate());
				clist.add(thisCard);
			}

		// 팀에 속한 유저들의, 팀 목표들에 해당하는 이번 주 위클리 전부 가져오기(성취도 계산 아직 안함)
		List<Weekly> wlist = wService.getTeamWeeklysThisWeek(teamId);

		// 목표에 따른 위클리 성취도 계산해서 입력하기
		// 위클리 리스트 요소들에 대해 반복
		if (wlist != null)
			for (int i = 0; i < wlist.size(); i++) {
				// 위클리 1개 지정
				Weekly weekly = wlist.get(i);

				// 목표 리스트 요소들에 대해 반복
				for (int j = 0; j < glist.size(); j++) {
					// 목표 1개 지정
					Goal goal = glist.get(j);

					// 위클리와 목표의 스포츠id가 같다면(목표에 해당하는 위클리라면) 성취도 계산
					if (weekly.getSportsId() == goal.getSportsId()) {
						double timeSum = weekly.getTimeSum();
						double distanceSum = weekly.getDistanceSum();

						double goalTime = goal.getGoalTime();
						double goalDistance = goal.getGoalDistance();

						double timePer=((timeSum / goalTime) * 100>100)? 100:(timeSum / goalTime) * 100;
						double goalPer=((distanceSum / goalDistance) * 100>100)? 100:(distanceSum / goalDistance) * 100;
						
						int archieve = (int) ((timePer+goalPer)/2);
						// 계산된 성취도 저장
						weekly.setWeeklyAchieve(archieve);
						break;
					}
				}
				// 유저 수만큼 비교하면서 유저 아이디와 위클리 정보가 일치하는지 찾음
				// 일치하면 카드에 넣음
				for (int j = 0; j < ulist.size(); j++) {
					if (ulist.get(j).getUserId().equals(weekly.getUserId())) {
						clist.get(j).addWeekly(weekly);
						break;
					}
				}
			}

		// 팀 성취도 계산용 임시변수
		int teamArchieveSum = 0;

		// 카드 별 개인 성취도 계산
		if (ulist != null) {
			for (int i = 0; i < clist.size(); i++) {
				UserCard thisCard = clist.get(i);
				List<Weekly> thisWeekly = thisCard.getPersonalWeekly();
				int userArchieveSum = 0;
				for (int j = 0; j < thisWeekly.size(); j++) {
					int thisArchieve = thisWeekly.get(j).getWeeklyAchieve();
					if (thisArchieve > 100)
						userArchieveSum += 100;
					else
						userArchieveSum += thisArchieve;
				}
				if (glist.size() != 0) {
					int thisUserArchieve = userArchieveSum / glist.size();
					thisCard.setTotalArchieve(thisUserArchieve);
					teamArchieveSum += thisUserArchieve;
				}
				else thisCard.setTotalArchieve(0);
			}

			// 팀 성취도 계산해서 팀 정보에 저장
			team.setTeamArchieve(teamArchieveSum / ulist.size());

			// 개인 성취도가 큰 순으로 카드 정렬
			Collections.sort(clist);
		}
		// 팀정보, 팀목표, 성취도 계산된 위클리목록을 맵에 넣기
		map.put("team", team);
		map.put("glist", glist);
		map.put("wlist", wlist);
		map.put("clist", clist);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@ApiOperation(value = "검색 조건에 맞는 팀 리스트 가져오기")
	@GetMapping("/search/{word}/{orderBy}")
	public ResponseEntity<?> searchTeam(@PathVariable String word, @PathVariable String orderBy) {
		TeamSearchCondition condition = new TeamSearchCondition();
		System.out.println(word);

		// 팀 이름을 공백으로 두고 검색 버튼을 눌렀을 때 404 에러가 나오는 것을 해결하기 위해
		// 프론트단에서 word를 "this is empty word"로 초기화 하고, 백단에서 변환
		if (word.equals("this is empty word")) {
			word = "";
		}

		condition.setWord(word.trim());
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
