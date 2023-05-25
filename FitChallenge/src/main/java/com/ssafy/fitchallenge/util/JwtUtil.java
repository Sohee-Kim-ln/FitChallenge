package com.ssafy.fitchallenge.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	private static final String SALT = "SSAFIT";
	
	// 토큰 생성
	// 인자로 키와 벨류가 넘어왔을 때 (한 가지의 정보만 넣는다고 가정)
	// 여러개의 정보를 넣을 때는 바구니를 만들어서 해야...
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return
			Jwts.builder()
			.setHeaderParam("alg", "HS256")
			.setHeaderParam("typ", "JWT")	// header
			.claim(claimId, data)
			//만료시간 잠시 지움
//			.setExpiration(new Date(System.currentTimeMillis()+3000))	// payload
			.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))	// Signature
			.compact();
	}
	
	// 유효성 검사
	public void valid(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
	}
	
	
}
