package com.atschx.adnetwork.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.atschx.adnetwork.domain.AdNetwork;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 广告
 */
@Entity
@Table(name = "offers")
public class Offer implements Serializable {

	private static final long serialVersionUID = -6037020426406852806L;

	private Long id;
	private String name;// 广告名称
	private String url;// offer URL

	private String logo;// logo资源url
	private Double price;// 单价
	private AdNetwork.PriceModel priceModel;// 计价方式 0 CPA 默认
	private AdNetwork.ClearingCycle clearingCycle;// 结算周期：周结 月结
	private AdNetwork.Platform platform;// 投放平台
	private String effDef;// 有效定义 effectiveDefinition
	private Byte status = 0;// offer状态 0 pending 等待审核 1 active 通过审核 -1 rejected -2 blocked

	private User createdBy;
	private Date createdDate;
	private User lastModifiedBy;
	private Date lastModifiedDate;

	public Offer() {
		super();
	}

	public Offer(String name, Double price, String effDef) {
		super();
		this.name = name;
		this.price = price;
		this.effDef = effDef;
		this.setCreatedDate(new Date());
		this.setLastModifiedDate(new Date());
	}

	@Id
	@GeneratedValue(generator = "sober_id_gen")
	@GenericGenerator(name = "sober_id_gen", strategy = "enhanced-table", parameters = {
			@Parameter(name = "table_name", value = "id_generator"),
			@Parameter(name = "value_column_name", value = "next"),
			@Parameter(name = "segment_column_name", value = "segment_name"),
			@Parameter(name = "segment_value", value = "offer_seq"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "10"), @Parameter(name = "optimizer", value = "pooled-lo") })
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Column(name = "logo")
	public String getLogo() {
		return logo;
	}

	public String getName() {
		return name;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "platform")
	public AdNetwork.Platform getPlatform() {
		return platform;
	}

	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	@Enumerated(EnumType.STRING)
	public AdNetwork.PriceModel getPriceModel() {
		return priceModel;
	}

	@Column(name = "status")
	public Byte getStatus() {
		return status;
	}

	@Column(name = "eff_def")
	public String getEffDef() {
		return effDef;
	}

	@Enumerated(EnumType.STRING)
	public AdNetwork.ClearingCycle getClearingCycle() {
		return clearingCycle;
	}

	public void setClearingCycle(AdNetwork.ClearingCycle clearingCycle) {
		this.clearingCycle = clearingCycle;
	}

	public void setEffDef(String effDef) {
		this.effDef = effDef;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlatform(AdNetwork.Platform platform) {
		this.platform = platform;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setPriceModel(AdNetwork.PriceModel priceModel) {
		this.priceModel = priceModel;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	@JsonIgnore
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "last_modified_by")
	@JsonIgnore
	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
