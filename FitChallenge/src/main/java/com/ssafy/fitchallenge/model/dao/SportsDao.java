
package com.ssafy.fitchallenge.model.dao;

import com.ssafy.fitchallenge.model.dto.Sports;

public interface SportsDao {
    // 스포츠 id에 해당하는 스포츠 가져오기
    public Sports selectSportsbyId(int sportsId);
	
}