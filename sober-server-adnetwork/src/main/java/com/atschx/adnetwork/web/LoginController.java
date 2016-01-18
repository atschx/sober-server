package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.protocol.response.LoginResult;
import com.atschx.adnetwork.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 1.login(目前仅支持邮箱登录):生成token.
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	LoginResult login(
			@RequestParam String email, 
			@RequestParam String password) {

		return loginService.login(email, password);
	}

}
