package com.ssafy.fitchallenge.service;

import com.ssafy.fitchallenge.model.dto.Sports;

public interface SportsService {
    // 스포츠 id에 해당하는 스포츠 가져오기
    public Sports selectSportsbyId(int sportsId);
}
