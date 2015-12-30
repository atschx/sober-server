package im.cia.sober.server.core.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import im.cia.sober.server.core.domain.model.base.SoberIdEntity;

@Entity
@Table(name = "sober_app_fields")
public class SoberAppField extends SoberIdEntity {

	private static final long serialVersionUID = -8365677754916472133L;

}
