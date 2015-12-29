package im.cia.sober.server.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import im.cia.sober.server.api.protocol.SoberStoreApps;
import im.cia.sober.server.api.service.SoberStoreService;

@RestController
public class SoberStoreController {
	
	
	@Autowired
	SoberStoreService storeService;

	@RequestMapping("/store/apps")
	SoberStoreApps apps() {
		return storeService.pageFetchApps(0);
	}

}
