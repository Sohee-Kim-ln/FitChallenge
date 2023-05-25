import java.io.UnsupportedEncodingException;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// 토큰 생성
		String token = 
				Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")	// header
				.claim("userId", "ssafy")
				.setExpiration(new Date(System.currentTimeMillis()+3000))	// payload
				.signWith(SignatureAlgorithm.HS256, "SSAFIT".getBytes("UTF-8"))	// Signature
				.compact();
		
		// 유효성 검사
		Jws<Claims> claims = Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
		
		
	}
}
