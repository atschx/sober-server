package im.cia.sober.server.core.domain.model;

//对应上架的应用列表
public class SoberApp {

	private String bid;// bunderId唯一
	private String appName;// 关键字
	private String appDesc;// 宣传语言
	private String appIcon;// app图标

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

}
