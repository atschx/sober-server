package im.cia.sober.server.api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import im.cia.sober.server.api.protocol.SoberStoreApps;
import im.cia.sober.server.api.protocol.vo.SoberStoreApp;
import im.cia.sober.server.core.domain.model.SoberApp;

@Service("storeService")
public class SoberStoreService {

	public SoberStoreApps pageFetchApps(int page) {

		SoberStoreApps apps = new SoberStoreApps();

		SoberApp youjiaApp = new SoberApp();
		youjiaApp.setName("友加");
		youjiaApp.setDesc("全世界陪你说话");
		youjiaApp.setBid("cn.youja.uplus");

		Map<String, Object> youjaExtras = new HashMap<String, Object>();
		youjaExtras.put("price", "6元");
		youjaExtras.put("words", "秀场");
		apps.getApps().add(new SoberStoreApp(youjiaApp, youjaExtras));

		SoberApp jdApp = new SoberApp();
		jdApp.setName("京东");
		jdApp.setDesc("我就是大卖场");
		jdApp.setBid("com.jd.store");
		Map<String, Object> jdExtras = new HashMap<String, Object>();
		jdExtras.put("price", "3元");
		jdExtras.put("words", "购物");
		apps.getApps().add(new SoberStoreApp(jdApp, jdExtras));

		return apps;
	}

}
