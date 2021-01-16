package com.worktrim.healthcare.webservices.model;

public class TokenResponse {

	private static final long serialVersionID = 1L;

	private final String token;

	public TokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
