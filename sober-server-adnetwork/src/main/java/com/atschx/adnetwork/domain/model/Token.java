package com.atschx.adnetwork.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sober_token")
public class Token implements Serializable {

	private static final long serialVersionUID = -7603323230870617113L;

	private String token;
	private Long uid;
	private Long expiresIn;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt; // 创建时间

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt; // 修改时间
	
	public Token() {
		super();
	}
	
	public Token(String token, Long uid, Long expiresIn) {
		super();
		this.token = token;
		this.uid = uid;
		this.expiresIn = expiresIn;
	}

	@Id
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

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
