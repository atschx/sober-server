package im.cia.sober.server.core.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//对应上架的应用列表

@Entity
@Table(name = "sober_apps")
public class SoberApp extends SoberBaseEntity {

	private static final long serialVersionUID = 8836027668574889084L;

	private String name;// 关键字

	@Column(name = "slug")
	private String slug;// app宣传语

	private String bunderId;// bunderId唯一
	private String icon;// app图标
	private String cover;// 封面图标
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBunderId() {
		return bunderId;
	}

	public void setBunderId(String bunderId) {
		this.bunderId = bunderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
