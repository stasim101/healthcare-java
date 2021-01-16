package com.worktrim.healthcare.webservices.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.function.Function;


@Component
public class TokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;
	
	@Value("${app.token.jwtkey}")
	private String secret;
	

	public String getUsernameFromToken(String token) {

		return getClaimFromToken(token, Claims::getSubject);
	}
	

	public Date getExpirationDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getExpiration);
	}


	
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	
	public Claims getAllClaimsFromToken(String token) {
		
		Claims claims;
		claims =  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		
		return claims;
	}
	
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}


	//validate token
	public Boolean isTokenValid(String token) {
		final String username = getUsernameFromToken(token);
		final boolean tokenExpired =  isTokenExpired(token);
		final List<String> authorities = getAuthoritiesFromToken(token);
		final String ssoId =  getssoIdFromToken(token);

		if(!tokenExpired && username != null &&  !authorities.isEmpty()  && ssoId != null){
			return true;
		}

		return false;

	}

	//get authorities
	public List<String> getAuthoritiesFromToken (String token) {
		Claims claims = getAllClaimsFromToken(token);
		List<String> auths = (List<String>) claims.get("authorities");

		return auths;
	}

	//get authorities
	public String getssoIdFromToken (String token) {
		Claims claims = getAllClaimsFromToken(token);
		String ssoId = (String) claims.get("ssoId");

		return ssoId;
	}

	
}
