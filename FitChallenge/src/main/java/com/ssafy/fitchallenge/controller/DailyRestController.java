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
import com.ssafy.fitchallenge.service.DailyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/daily")
@Api(tags = "데일리 컨트롤러")
public class DailyRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	DailyService dService;

	@ApiOperation(value = "데일리 기록 생성")
	@PostMapping
	public ResponseEntity<?> createDaily(@RequestBody Daily dailyDto) {
		int result = dService.insertDaily(dailyDto);
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

	@ApiOperation(value = "팀id와 기간에 맞는 운동 기록 가져오기")
	// URI 수정 필요
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

	@ApiOperation(value = "데일리 상세")
	@GetMapping("/{dailyId}")
	public ResponseEntity<?> deteilDaily(@PathVariable int dailyId) {
		Daily daily = dService.selectDaily(dailyId);
		return new ResponseEntity<>(daily, HttpStatus.OK);
	}

}
