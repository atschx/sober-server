package im.cia.sober.server.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import im.cia.sober.server.api.protocol.SoberApps;
import im.cia.sober.server.core.domain.model.SoberApp;

@RestController
//@EnableAutoConfiguration
public class SoberStoreController {
	
	
	@RequestMapping("/store/apps")
	SoberApps apps(){
		
		SoberApps apps = new SoberApps();
		
		SoberApp youjiaApp = new SoberApp();
		youjiaApp.setAppName("友加");
		youjiaApp.setAppDesc("全世界陪你说话");
		youjiaApp.setBid("cn.youja.uplus");
		
		apps.getApps().add(youjiaApp);
		
		SoberApp jdApp = new SoberApp();
		jdApp.setAppName("京东");
		jdApp.setAppDesc("我就是大卖场");
		jdApp.setBid("com.jd.store");
		
		apps.getApps().add(jdApp);
		
		return apps;
	}
	
	
	

}
