package com.ssafy.fitchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitchallenge.model.dao.PhraseDao;
import com.ssafy.fitchallenge.model.dto.Phrase;

@Service
public class PhraseServiceImpl implements PhraseService{
	@Autowired
	private PhraseDao pDao;

	@Override
	public Phrase selectPhrasebyId(int phraseId) {
		return pDao.selectPhrasebyId(phraseId);
	}

	
	
	
}
