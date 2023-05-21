package com.ssafy.fitchallenge.model.dao;

import com.ssafy.fitchallenge.model.dto.Phrase;

public interface PhraseDao {
    // 문구 아이디에 해당하는 문구 가져오기
    public Phrase selectPhrasebyId(int phraseId);
    
}
