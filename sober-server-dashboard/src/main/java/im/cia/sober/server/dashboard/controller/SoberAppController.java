package im.cia.sober.server.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 供运营管理后台使用。
 */
@Controller
public class SoberAppController {

	/**
	 * @return
	 */
	@RequestMapping(value = "/app", method = { RequestMethod.POST })
	@ResponseBody
	String app() {
		return "Hello World!";
	}

}
