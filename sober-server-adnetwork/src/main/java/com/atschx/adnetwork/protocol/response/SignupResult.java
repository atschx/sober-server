package com.atschx.adnetwork.protocol.response;

import com.atschx.adnetwork.protocol.Result;

public class SignupResult extends Result {

	private Long uid;

	public SignupResult() {
	}

	public SignupResult(Long uid) {
		super();
		this.uid = uid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}
