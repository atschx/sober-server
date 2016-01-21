package com.atschx.adnetwork.protocol.response;

import com.atschx.adnetwork.protocol.Result;

public class SigninResult extends Result {

	private String token;
	private Long expires;

	public SigninResult() {
		super();
	}

	public SigninResult(String ret) {
		super.setRet(ret);
	}

	public SigninResult(String token, Long expires) {
		super();
		this.token = token;
		this.expires = expires;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

}
