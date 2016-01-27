package com.atschx.adnetwork.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 广告组（针对广告主而言统一管理投放的广告）
 */

@Entity
@Table(name = "ad_group")
public class AdGroup {

	private Long id;
	private String name;
	private User advertiser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(User advertiser) {
		this.advertiser = advertiser;
	}

}
