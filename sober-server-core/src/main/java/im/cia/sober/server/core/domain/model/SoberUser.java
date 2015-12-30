package im.cia.sober.server.core.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import im.cia.sober.server.core.domain.model.base.SoberIdEntity;

@Entity
@Table(name = "sober_user")
public class SoberUser extends SoberIdEntity{

	private static final long serialVersionUID = -1682971951403080170L;

	private Long uid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}


}
