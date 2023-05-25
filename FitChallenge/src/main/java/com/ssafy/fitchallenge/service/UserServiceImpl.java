package com.ssafy.fitchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fitchallenge.model.dao.UserDao;
import com.ssafy.fitchallenge.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao uDao;

	@Transactional
	@Override
	public int insertUser(User user) {
		return uDao.insertUser(user);
	}

	@Override
	public List<User> selectUserAll() {
		return uDao.selectUserAll();
	}

	@Override
	public User selectUserById(String userId) {
		return uDao.selectUserById(userId);
	}

	@Override
	public List<User> selectUserByTeam(int teamId) {
		return uDao.selectUserByTeam(teamId);
	}

	@Transactional
	@Override
	public int joinTeam(int teamId, String userId) {
		return uDao.joinTeam(teamId, userId);
	}

	@Transactional
	@Override
	public int updateRecentLogin(String userId) {
		return uDao.updateRecentLogin(userId);
	}

	@Transactional
	@Override
	public int ownerTrue(String userId) {
		return uDao.ownerTrue(userId);
	}

	
	
	
}
