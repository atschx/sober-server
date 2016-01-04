package im.cia.sober.server.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
	
	@RequestMapping("/dashboard")
	public String dashboard(@RequestParam(value = "name", required = false, defaultValue = "Sober") String name,
			Model model) {
		model.addAttribute("name", name);
		return "dashboard";
	}


}
