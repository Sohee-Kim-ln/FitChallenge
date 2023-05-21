//package com.ssafy.fitchallenge.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
//import com.ssafy.fitchallenge.model.dto.Weekly;
//import com.ssafy.fitchallenge.service.WeeklyService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@RestController
//@RequestMapping("/weekly")
//@Api(tags = "위클리 컨트롤러")
//public class WeeklyRestController {
//	@Autowired
//	WeeklyService wService;
//
//	@ApiOperation(value = "조건에 맞는 데일리를 서버에서 합산 + 성취도 계산 후 반환. 팀에 속해있고 목표성취도가 필요할 때 사용")
//	@GetMapping("/calc/{userId}/{teamId}/{year}/{month}")
//	public ResponseEntity<?> calculateWeekly(@PathVariable String userId, @PathVariable int teamId,
//			@PathVariable int year, @PathVariable int month) {
//
//		DailySearchCondition condition = new DailySearchCondition();
//		condition.setUserId(userId);
//		condition.setTeamId(teamId);
//		condition.setYear(year);
//		condition.setMonth(month);
//		
//		System.out.println(condition);
//
//		Weekly weekly = wService.calcWeekly(condition);
//		return new ResponseEntity<>(weekly, HttpStatus.OK);
//	}
//	
//	//구현 보류. 필요한가? 일단은 후순위
////	@ApiOperation(value = "조건에 맞는 데일리를 서버에서 합산 후 반환. 목표성취도가 필요없을 때 사용")
////	@GetMapping("/get/{userId}/{year}/{month}")
////	public ResponseEntity<?> getWeekly(@PathVariable String userId, @PathVariable int teamId,
////			@PathVariable int year, @PathVariable int month) {
////
////		return ;
////	}
//
//}
