package im.cia.sober.server.api.protocol.vo;

import java.util.HashMap;
import java.util.Map;

import im.cia.sober.server.core.domain.model.SoberApp;

public class SoberStoreApp {

	private SoberApp app;// app基础属性
	private Map<String, Object> extras = new HashMap<String, Object>();

	public SoberStoreApp() {
		this(null);
	}

	public SoberStoreApp(SoberApp app) {
		this(app, null);
	}

	public SoberStoreApp(SoberApp app, Map<String, Object> extras) {
		super();
		this.app = app;
		this.extras = extras;
	}

	public SoberApp getApp() {
		return app;
	}

	public void setApp(SoberApp app) {
		this.app = app;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}

}
