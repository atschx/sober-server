package com.atschx.adnetwork.protocol.response;

import com.atschx.adnetwork.protocol.Result;

public class LoginResult extends Result {

	private String token;
	private Long expiresIn;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
