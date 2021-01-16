package com.worktrim.healthcare.webservices.model;

public class TokenRequest {

	private static final long serialVersionID = 1L;

	private String username;
	private String password;

	public TokenRequest() {
	}

	public TokenRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
