package com.ssafy.fitchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitchallenge.model.dto.Goal;
import com.ssafy.fitchallenge.service.GoalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goal")
@Api(tags = "목표 컨트롤러")
public class GoalRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	GoalService gService;

	@ApiOperation(value = "팀 목표 생성")
	@PostMapping("/create")
	public ResponseEntity<?> createGoal(@RequestBody Goal goal) {
		System.out.println(goal);
		
		int result = gService.insertGoal(goal);
		if (result != 0)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "팀 id에 맞는 목표 리스트 가져오기")
	@GetMapping("/search/{teamId}")
	public ResponseEntity<?> searchGoal(@PathVariable int teamId) {
		List<Goal> goalList = gService.selectGoals(teamId);
		return new ResponseEntity<>(goalList, HttpStatus.OK);
	}

	@ApiOperation(value = "목표 id에 맞는 목표 1개 가져오기(달성도 계산X)")
	@GetMapping("/{goalId}")
	public ResponseEntity<?> detailGoal(@PathVariable int goalId) {
		Goal goal=gService.selectGoal(goalId);
		return new ResponseEntity<>(goal,HttpStatus.OK);
	}

	//후순위 구현
//	@ApiOperation(value = "목표 id에 맞는 목표 1개 정보를 팀 달성도 계산 후 가져오기")
//	@GetMapping("/achieve/{goalId}")
//	public ResponseEntity<?> detailGoalCal(@PathVariable int goalId) {
//
//	}

	@ApiOperation(value = "목표 id에 맞는 목표 안보이게 함")
	@PutMapping("/invisible/{goalId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<?> hideGoal(@PathVariable int goalId) {
		int result = gService.updateVisible(goalId);
		if (result != 0)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
