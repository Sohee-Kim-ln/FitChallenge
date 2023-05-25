package com.ssafy.fitchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitchallenge.model.dto.Daily;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Weekly;
import com.ssafy.fitchallenge.service.DailyService;
import com.ssafy.fitchallenge.service.WeeklyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;

@RestController
@RequestMapping("/daily")
@Api(tags = "데일리 컨트롤러")
public class DailyRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	DailyService dService;
	
	@Autowired
	WeeklyService wService;

	@ApiOperation(value = "데일리 기록 생성")
	@PostMapping("/create")
	public ResponseEntity<?> createDaily(@RequestBody Daily dailyDto) {
		int result = dService.insertDaily(dailyDto);
		if (result != 0)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);

	}
	
	@ApiOperation(value = "데일리 기록 생성")
	@PostMapping("/create/dailies")
	public ResponseEntity<?> createDailies(@RequestBody List<Daily> dailies) {
		System.out.println(dailies);
		int result = dService.insertDailies(dailies);
		if (result != 0)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);

	}

	@ApiOperation(value = "유저 id와 기간에 맞는 운동 기록 가져오기")
	@GetMapping("/user/{userId}/{year}/{month}")
	public ResponseEntity<?> searchByUserId(@PathVariable String userId, @PathVariable int year,
			@PathVariable int month) {
		DailySearchCondition condition = new DailySearchCondition();
		condition.setUserId(userId);
		condition.setYear(year);
		condition.setMonth(month);

		List<Daily> dailyList = dService.selectDailyByUser(condition);
		return new ResponseEntity<>(dailyList, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "유저메인의 총 거리, 총 시간 차트를 위한 기간별 합산 데이터 가져오기")
//	@GetMapping("/user/chart/{userId}")
//	public ResponseEntity<?> statByUserId(@PathVariable String userId) {
//		DailySearchCondition condition = new DailySearchCondition();
//		
//		condition.setUserId(userId);
////		condition.setYear(year);
////		condition.setMonth(month);
//
//		
//		List<Weekly> weeklyList = wService.weekStat(condition);
//		List<Weekly> monthlyList = wService.monthStat(condition);
//		List<Weekly> yearList = wService.yearStat(condition);
//		
//		
//		
//		return new ResponseEntity<>(weeklyList, HttpStatus.OK);
//	}
	

	@ApiOperation(value = "팀id와 기간에 맞는 운동 기록 가져오기")
	@GetMapping("/team/{teamId}/{year}/{month}")
	public ResponseEntity<?> searchBySportsId(@PathVariable int teamId, @PathVariable int year,
			@PathVariable int month) {
		DailySearchCondition condition = new DailySearchCondition();
		condition.setTeamId(teamId);
		condition.setYear(year);
		condition.setMonth(month);

		List<Daily> dailyList = dService.selectDailyByTeam(condition);
		return new ResponseEntity<>(dailyList, HttpStatus.OK);
	}

	@ApiOperation(value = "데일리 상세. 데일리 id에 맞는 운동 기록 가져오기")
	@GetMapping("/{dailyId}")
	public ResponseEntity<?> deteilDaily(@PathVariable int dailyId) {
		Daily daily = dService.selectDaily(dailyId);
		return new ResponseEntity<>(daily, HttpStatus.OK);
	}
	
	
}
