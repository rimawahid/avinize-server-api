package bd.com.deepsense.avinize.utils;

import bd.com.deepsense.avinize.exception.JwtTokenMalformedException;
import bd.com.deepsense.avinize.exception.JwtTokenMissingException;
import io.jsonwebtoken.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtUtil {

	private static String JWT_SECRET = "avinize-jwt-token";

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public void validateToken(final String token) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException("JWT claims string is empty.");
		}
	}

	public String getTokenFromRequest(ServerHttpRequest request) {
		String token = null;
		String headerAuth = request.getHeaders().get("Authorization").get(0);
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			token = headerAuth.substring(7);
		}
		return token;
	}

}
