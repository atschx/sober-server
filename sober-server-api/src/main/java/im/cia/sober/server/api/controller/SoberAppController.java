package im.cia.sober.server.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SoberAppController {

	
	/**
	 * 分页显示已接入的App列表，用于后期管理。
	 * @return
	 */
    @RequestMapping("/apps")
    @ResponseBody
    String apps() {
        return "Hello World!";
    }
    
}
