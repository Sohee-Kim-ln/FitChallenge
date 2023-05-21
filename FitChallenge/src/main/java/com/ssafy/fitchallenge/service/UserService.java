package com.ssafy.fitchallenge.service;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.User;

public interface UserService {
	// 회원가입
	public int insertUser(User user);

	// 로그인 : 컨트롤러에서 처리? JWT면 유저 목록 확인을 위해 유저 id에 맞는 유저 정보 가져오기 사용

	// 로그아웃

	// 최근 접속일 업데이트
	public int updateRecentLogin(int userId);
		
	// 유저 전체 가져오기
	public List<User> selectUserAll();

	// 유저 id에 맞는 유저 정보 가져오기
	public User selectUserById(String userId);

	
	//팀 id에 맞는 유저들 목록 가져오기
	public List<User> selectUserByTeam(int teamId);
	
	//팀 가입(유저 정보에 팀id 입력)
	public int joinTeam(int teamId, String userId);
	
	//팀 생성시 팀리더 유저의 isOwner true로 바꿈
	public int ownerTrue(String userId);
	
	// 이하 기능 구현은 후순위
	
	// 팀 탈퇴
	
	// 회원정보 수정

	// 회원 탈퇴
	
	// 아이디 찾기

	// 비밀번호 찾기
}
