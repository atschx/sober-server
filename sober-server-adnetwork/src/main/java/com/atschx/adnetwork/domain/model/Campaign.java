package com.atschx.adnetwork.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 广告Campaign是指广告主在一段明确的期间里(如一年)，推出一系列拥有共同主题或讯息的广告，以期建立广告讯息的累积效果，塑造品牌与企业一致的形象，
 * 并给予目标受众持续而深刻的刺激与冲击。
 *
 */
@Entity
@Table(name = "campaign")
public class Campaign implements Serializable{

	private static final long serialVersionUID = 2636434054520316559L;

	@Id
	private Long id;
}