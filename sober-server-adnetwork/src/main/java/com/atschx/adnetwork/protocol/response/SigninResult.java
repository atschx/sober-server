package com.atschx.adnetwork.protocol.response;

import java.util.HashSet;
import java.util.Set;

import com.atschx.adnetwork.domain.model.Role;
import com.atschx.adnetwork.protocol.Result;

public class SigninResult extends Result {

	private Long uid;
	private String token;
	private Long expires;
	private Set<Role> roles = new HashSet<Role>(0);

	public SigninResult() {
		super();
	}

	public SigninResult(String ret) {
		super.setRet(ret);
	}

	public SigninResult(String token, Long expires) {
		this(token, expires, null);
	}

	public SigninResult(String token, Long expires, Set<Role> roles) {
		super();
		this.token = token;
		this.expires = expires;
		this.setRoles(roles);
	}
	

	public SigninResult(Long uid, String token, Long expires, Set<Role> roles) {
		super();
		this.uid = uid;
		this.token = token;
		this.expires = expires;
		this.roles = roles;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}
