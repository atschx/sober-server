package im.cia.sober.server.api.protocol;

import java.util.ArrayList;
import java.util.List;

import im.cia.sober.server.core.domain.model.SoberApp;

public class SoberApps extends SoberListProtocol {

	private List<SoberApp> apps = new ArrayList<SoberApp>(10);

	public List<SoberApp> getApps() {
		return apps;
	}

	public void setApps(List<SoberApp> apps) {
		this.apps = apps;
	}

}
