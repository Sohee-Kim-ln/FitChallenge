package com.ssafy.fitchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fitchallenge.model.dao.DailyDao;
import com.ssafy.fitchallenge.model.dto.Daily;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;

@Service
public class DailyServiceImpl implements DailyService{
	@Autowired
	private DailyDao dDao;

	@Transactional
	@Override
	public int insertDaily(Daily daily) {
		return dDao.insertDaily(daily);
	}

	@Override
	public List<Daily> selectDailyByUser(DailySearchCondition condition) {
		return dDao.selectDailyByUser(condition);
	}

	@Override
	public List<Daily> selectDailyByTeam(DailySearchCondition condition) {
		return dDao.selectDailyByTeam(condition);
	}

	@Override
	public Daily selectDaily(int dailyId) {
		return dDao.selectDaily(dailyId);
	}

	
	
	
}
