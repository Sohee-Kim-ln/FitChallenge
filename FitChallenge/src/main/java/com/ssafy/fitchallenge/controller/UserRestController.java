package com.ssafy.fitchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitchallenge.model.dto.User;
import com.ssafy.fitchallenge.service.TeamService;
import com.ssafy.fitchallenge.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private TeamService tService;

	
	@ApiOperation(value="회원가입(유저 생성)")
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user){
		User uTemp = uService.selectUserById(user.getUserId());
		
		if(uTemp == null) {
			int res = uService.insertUser(user);
			
			if(res == 0)
				return new ResponseEntity<String>("0 row inserted. wrong request", HttpStatus.OK);
			else
				return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("same id exists", HttpStatus.OK);
		
	}
	
	/*
	@ApiOperation(value="로그인")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User userDto){
		//구현 필요
		
	}
	
	
	@ApiOperation(value="로그아웃")
	@PostMapping("/logout")
	public ResponseEntity<?> logout(){
		
	}
	*/
	
	@ApiOperation(value="유저 상세")
	@GetMapping("/detail/{userId}")
	public ResponseEntity<?> detailUser(@PathVariable String userId){
		User user = uService.selectUserById(userId);
		
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
	}
	
	
	@ApiOperation(value="팀 멤버 목록")
	@GetMapping("/member/{teamId}")
	public ResponseEntity<?> listMembers(@PathVariable int teamId){
		List<User> uList = uService.selectUserByTeam(teamId);
		
		if (uList == null || uList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<User>>(uList, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="팀 가입")
	@PutMapping("/join/{teamId}")
	public ResponseEntity<?> joinTeam(@RequestBody String userId, @PathVariable int teamId){
		
		int res = uService.joinTeam(teamId, userId);
	    
	    if (res == 0) 
	        return new ResponseEntity<>("Failed to update teamId", HttpStatus.BAD_REQUEST);
	    else {
	    	tService.addCapacity(teamId);
	        return new ResponseEntity<>("Team joined successfully", HttpStatus.OK);
	    }
			
	}
}
