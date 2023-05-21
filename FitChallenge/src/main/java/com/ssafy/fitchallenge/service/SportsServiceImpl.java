package com.ssafy.fitchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitchallenge.model.dao.SportsDao;
import com.ssafy.fitchallenge.model.dto.Sports;

@Service
public class SportsServiceImpl implements SportsService{
	@Autowired
	private SportsDao sDao;

	@Override
	public Sports selectSportsbyId(int sportsId) {
		return sDao.selectSportsbyId(sportsId);
	}

	
	
	
}
