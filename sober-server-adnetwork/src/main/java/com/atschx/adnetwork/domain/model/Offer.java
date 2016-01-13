package com.atschx.adnetwork.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 广告
 */
@Entity
@Table(name = "offers")
public class Offer implements Serializable {

	private static final long serialVersionUID = -6037020426406852806L;

	private Long id;
	private String logo;// logo资源url
	private String name;// 广告名称
	private String clearingCycle;// 结算周期：周结 月结
	private Double price;// 单价
	private Byte countingWay = 0;// 计价方式 0 CPA 默认
	private String effDef;// 有效定义 effectiveDefinition
	private Byte platform;// 投放平台
	private Byte status = 0;// offer状态 0 等待审核 1通过审核 -1 驳回

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt; // 创建时间

	@Id
	@GeneratedValue(generator = "sober_id_gen")
	@GenericGenerator(name = "sober_id_gen", strategy = "enhanced-table", parameters = {
			@Parameter(name = "table_name", value = "sober_id_generator"),
			@Parameter(name = "value_column_name", value = "next"),
			@Parameter(name = "segment_column_name", value = "segment_name"),
			@Parameter(name = "segment_value", value = "sober_ads_seq"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "10"),
			@Parameter(name = "optimizer", value = "pooled-lo") })
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClearingCycle() {
		return clearingCycle;
	}

	public void setClearingCycle(String clearingCycle) {
		this.clearingCycle = clearingCycle;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Byte getCountingWay() {
		return countingWay;
	}

	public void setCountingWay(Byte countingWay) {
		this.countingWay = countingWay;
	}

	public String getEffDef() {
		return effDef;
	}

	public void setEffDef(String effDef) {
		this.effDef = effDef;
	}

	public Byte getPlatform() {
		return platform;
	}

	public void setPlatform(Byte platform) {
		this.platform = platform;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
