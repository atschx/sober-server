package com.atschx.adnetwork.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atschx.adnetwork.domain.model.SoberUser;

@Controller
public class UserController {
	
	/**
	 * 注册(signup)
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/signup", method = { RequestMethod.PUT })
	@ResponseBody
	String signup(SoberUser user) {

		return "signup success";
	}
	
	/**
	 * 登录(signin)
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/signin", method = { RequestMethod.POST })
	@ResponseBody
	String signin(SoberUser user) {

		return "signin success";

	}
	
	

	@RequestMapping(value = "/user/reset")
	@ResponseBody
	String resetPassword(String email) {

		// ret = 0,密码已发送至xx邮箱

		return "reset success";
	}

	

}
