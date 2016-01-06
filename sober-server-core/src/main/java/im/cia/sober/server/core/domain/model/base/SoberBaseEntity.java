package im.cia.sober.server.core.domain.model.base;

import java.sql.Timestamp;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SoberBaseEntity extends SoberIdEntity {

	private static final long serialVersionUID = 5828949333104667982L;
	
	protected Timestamp createdAt;
	protected Long createdBy;
	protected Timestamp updatedAt;
	protected Long updatedBy;

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
