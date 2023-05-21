package com.ssafy.fitchallenge.service;

import java.util.List;

import com.ssafy.fitchallenge.model.dto.Daily;
import com.ssafy.fitchallenge.model.dto.DailySearchCondition;
import com.ssafy.fitchallenge.model.dto.Phrase;

public interface PhraseService {
    // 문구 아이디에 해당하는 문구 가져오기
    public Phrase selectPhrasebyId(int phraseId);
    
}
