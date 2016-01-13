package com.atschx.adnetwork.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer_price_model")
public class PriceModel implements Serializable {

	private static final long serialVersionUID = 3062045571216489434L;

	private Long id;
	private String code;
	private String description;

	public PriceModel() {
	}

	public PriceModel(String code) {
		this(code, null);
	}

	public PriceModel(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return code + "(" + description + ")";
	}

}
