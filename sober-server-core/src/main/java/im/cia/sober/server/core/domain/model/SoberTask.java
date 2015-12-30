package im.cia.sober.server.core.domain.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import im.cia.sober.server.core.domain.model.base.SoberIdEntity;

//用户点击列表中的SoberApp之后产生的任务，前端拿到expires后开始跑秒。

@Entity
@Table(name = "sober_task")
public class SoberTask extends SoberIdEntity {

	private static final long serialVersionUID = -8747409750997971690L;

	private String tid;// 任务号

	@Column(nullable = false)
	private Long uid;// 领取任务的用户
	@Column(nullable = false)
	private String appId;// 关联App

	private byte status = 0;// 任务状态：0,已领取 1,已完成 -1,未完成

	private Timestamp expires;// 过期时间：任务自创建开始 10分钟
	private Timestamp createTime;// 创建时间
	private Timestamp updateTime;// 最后更新时间

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getExpires() {
		return expires;
	}

	public void setExpires(Timestamp expires) {
		this.expires = expires;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
