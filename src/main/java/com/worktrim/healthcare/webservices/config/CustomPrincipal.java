package com.worktrim.healthcare.webservices.config;

import java.io.Serializable;

public class CustomPrincipal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String ssoId;

	public CustomPrincipal(String username, String ssoId) {
		this.username = username;
		this.ssoId = ssoId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}
}