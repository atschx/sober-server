package im.cia.sober.server.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoberTaskController {

	@RequestMapping("/sober/tasks")
	String tasks() {
		return "";
	}

}
