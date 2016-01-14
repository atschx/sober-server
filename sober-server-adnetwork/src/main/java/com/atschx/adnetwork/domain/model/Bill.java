package com.atschx.adnetwork.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 账单
 */
@Entity
@Table(name = "pay_bill")
public class Bill implements Serializable {

	private static final long serialVersionUID = 8557775482829283773L;

	private Long id;

	@Id
	@GeneratedValue(generator = "sober_id_gen")
	@GenericGenerator(name = "sober_id_gen", strategy = "enhanced-table", parameters = {
			@Parameter(name = "table_name", value = "id_generator"),
			@Parameter(name = "value_column_name", value = "next"),
			@Parameter(name = "segment_column_name", value = "segment_name"),
			@Parameter(name = "segment_value", value = "bill_seq"),
			@Parameter(name = "initial_value", value = "10000"), @Parameter(name = "increment_size", value = "10"),
			@Parameter(name = "optimizer", value = "pooled-lo") })
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
