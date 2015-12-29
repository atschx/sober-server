package im.cia.sober.server.core.domain.model;

//对应上架的应用列表
public class SoberApp {

	private String bid;// bunderId唯一
	private String name;// 关键字
	private String desc;// 宣传语言
	private String icon;// app图标

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
