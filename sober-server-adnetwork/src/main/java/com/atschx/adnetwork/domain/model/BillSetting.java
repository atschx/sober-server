package com.atschx.adnetwork.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pay_bill_settings")
public class BillSetting implements Serializable {

	private static final long serialVersionUID = -6786124795888596376L;

	private SoberUser user;
	private String billAddress;

	@Id
	@OneToOne
	@JoinColumn(name = "uid")
	public SoberUser getUser() {
		return user;
	}

	public void setUser(SoberUser user) {
		this.user = user;
	}

	public String getBillAddress() {
		return billAddress;
	}

	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}

}
