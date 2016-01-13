package com.atschx.adnetwork.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController  extends AdNetworkController {


	@RequestMapping(value = "/user/reset")
	String resetPassword(String email) {

		// ret = 0,密码已发送至xx邮箱

		return "reset success";
	}

	// status=0&manager=-1&name=m&limit=20&page=1
	@RequestMapping(value = "/advertisers", method = { RequestMethod.GET })
	String advertisers(
			@RequestParam(name = "status") Byte status,
			@RequestParam(name = "manager", required = false) Long manager,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "offset", defaultValue = "0") Integer offset,
			@RequestParam(name = "offset", defaultValue = "20") Integer limit) {

		return "";
	}

}
