package com.ssafy.fitchallenge.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ssafy.fitchallenge.util.JwtUtil;

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
				return new ResponseEntity<String>("success", HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("same id", HttpStatus.OK);
		
	}
	
	
	@ApiOperation(value="로그인")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		System.out.println("로그인 테스트");
		System.out.println(user);
		Map<String, Object> result = new HashMap<>();
		JwtUtil jwt = new JwtUtil();
		HttpStatus status = null; 
		
		// user를 이용해서 Service -> Dao -> DB를 통해 실제 유저인지 확인해야 한다
		// 구현 필요
		
		User userDB=uService.selectUserById(user.getUserId());
		
		if(userDB==null || userDB.getUserId().length() == 0) {
			result.put("message", "not user");
			status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<Map<String,Object>>(result, status);
		}
			
		
		try {
			if (userDB != null || userDB.getUserId().length() > 0) {
				System.out.println("비번 검증");
					if(!userDB.getPassword().equals(user.getPassword())) {
						result.put("message", "wrong password");
						status = HttpStatus.BAD_REQUEST;
					}
					else {
						result.put("access-token", jwt.createToken("id", user.getUserId()));
						result.put("message", "success");
						
						result.put("userId",userDB.getUserId());
						result.put("nickname",userDB.getNickname());
						result.put("teamId", userDB.getTeamId());
						result.put("isOwner", userDB.isOwner());
						//최근 접속일 업데이트는 후순위 구현
						uService.updateRecentLogin(user.getUserId());
						
						status = HttpStatus.ACCEPTED;
						System.out.println("토큰 반환 완료");
					}
			}
			else {
				result.put("message", "not user");
				status = HttpStatus.NO_CONTENT;
			}
		} 
		catch (UnsupportedEncodingException e) {
			result.put("message", "fail");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} 
		
		return new ResponseEntity<Map<String,Object>>(result, status);
		
	}
	
	
	
	/*
	@ApiOperation(value="로그아웃")
	@PostMapping("/logout")
	public ResponseEntity<?> logout(){
		
	}
	*/
	
	@ApiOperation(value="유저 상세")
	@GetMapping("/detail/{userId}")
	public ResponseEntity<?> detailUser(@PathVariable String userId){
		User user = uService.selectUserById(userId);
		
		user.setPassword(null);
		
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
	}
	
	
	@ApiOperation(value="팀 멤버 목록")
	@GetMapping("/member/{teamId}")
	public ResponseEntity<?> listMembers(@PathVariable int teamId){
		List<User> ulist = uService.selectUserByTeam(teamId);
		
		if (ulist == null || ulist.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else {
			for(int i=0;i<ulist.size();i++) {
				ulist.get(i).setPassword(null);
				ulist.get(i).setUserId(null);
			}
			return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
		}
			
	}
	
	
	@ApiOperation(value="팀 가입")
	@PutMapping("/join/{teamId}")
	public ResponseEntity<?> joinTeam(@RequestBody String userId, @PathVariable int teamId){
		
		User user = uService.selectUserById(userId);
		int userTeamId = user.getTeamId();
		
		// 유저가 이미 팀에 가입되어 있으면
		if (userTeamId != 0) {
			return new ResponseEntity<>("already in a team", HttpStatus.NO_CONTENT);
		}
		else {
			int res = uService.joinTeam(teamId, userId);
		    
		    if (res == 0) 
		        return new ResponseEntity<>("Failed to join teamId", HttpStatus.BAD_REQUEST);
		    else {
		    	tService.addCapacity(teamId);
		        return new ResponseEntity<>("Team joined successfully", HttpStatus.OK);
		    }
		}		
	}
}
