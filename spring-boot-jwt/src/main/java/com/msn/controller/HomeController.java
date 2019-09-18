package com.msn.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/token")
	public String getToken() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("username", "USERNAME");
		return createToken("msnawaz444@gmail.com", claims);
	}
	
	private String createToken(String email, Map<String, Object> claims) {
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(email)
				   .setIssuedAt(new Date())
				   .setExpiration(new Date(System.currentTimeMillis()+30000))
				   .signWith(SignatureAlgorithm.HS256, "secret")
				   .compact();
	}
	
	@GetMapping("/parse")
	public String parseTocken(HttpServletRequest req) {
		String token = req.getHeader("token");
		LOGGER.info("Token", token);
		Claims claims = Jwts.parser()
				.setSigningKey("secret")
				.parseClaimsJws(token)
				.getBody();
		LOGGER.info("Subject", claims.getSubject());
		return claims.getSubject();
	}
	
	
	
}
 


























