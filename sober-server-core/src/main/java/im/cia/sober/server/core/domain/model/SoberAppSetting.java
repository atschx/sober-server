package im.cia.sober.server.core.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sober_app_settings")
public class SoberAppSetting extends IdEntity {

	private static final long serialVersionUID = 8960513560937580720L;

}
