package im.cia.sober.server.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当前用户正在进行中的任务。
 */
@RestController
public class SoberTaskController {

	@RequestMapping("/sober/task")
	String task() {
		return "";
	}

}
