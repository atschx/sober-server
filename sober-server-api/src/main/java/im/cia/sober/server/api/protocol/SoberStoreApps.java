package im.cia.sober.server.api.protocol;

import java.util.ArrayList;
import java.util.List;

import im.cia.sober.server.api.protocol.vo.SoberStoreApp;

/**
 * 商店中的App列表。
 * 
 * @author albert
 *
 */
public class SoberStoreApps extends SoberListProtocol {

	private List<SoberStoreApp> apps = new ArrayList<SoberStoreApp>(10);

	public List<SoberStoreApp> getApps() {
		return apps;
	}

	public void setApps(List<SoberStoreApp> apps) {
		this.apps = apps;
	}

}
