package com.atschx.adnetwork.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "sober_user")
public class SoberUser implements Serializable {

	private static final long serialVersionUID = -1682971951403080170L;

	protected Long id;
	private String name;// company/用户名
	private String email;
	private String password;
	private String mobile;
	private String qq;
	private Byte status = 0; // 0.Pending 1.Active 2.Rejected 3.Blocked
	private Byte type = 1; // 1.person 2.company
	private SoberUser accountManager;// 账号管理者

	private Set<SoberRole> roles = new HashSet<SoberRole>(0);
	
	public SoberUser() {
	}

	public SoberUser(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	@Id
	@GeneratedValue(generator = "sober_id_gen")
	@GenericGenerator(name = "sober_id_gen", strategy = "enhanced-table", parameters = {
			@Parameter(name = "table_name", value = "sober_id_generator"),
			@Parameter(name = "value_column_name", value = "next"),
			@Parameter(name = "segment_column_name", value = "segment_name"),
			@Parameter(name = "segment_value", value = "sober_user_seq"),
			@Parameter(name = "initial_value", value = "60000"), @Parameter(name = "increment_size", value = "10"),
			@Parameter(name = "optimizer", value = "pooled-lo") })
	@Column(name = "id", unique = true, nullable = false)
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

	@Column(name = "email", length = 50, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "qq", length = 15)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "sober_user_role", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false) })
	public Set<SoberRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SoberRole> roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	public SoberUser getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(SoberUser accountManager) {
		this.accountManager = accountManager;
	}

}
