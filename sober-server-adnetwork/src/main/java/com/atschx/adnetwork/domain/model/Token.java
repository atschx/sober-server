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
	private Long expires;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt=new Date(); // 创建时间

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt=new Date(); // 修改时间

	public Token() {
		super();
	}

	public Token(String token, Long uid, Long expires) {
		super();
		this.token = token;
		this.uid = uid;
		this.expires = expires;
	}

	@Id
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
