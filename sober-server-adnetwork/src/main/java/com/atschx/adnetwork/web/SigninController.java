package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.protocol.response.SigninResult;
import com.atschx.adnetwork.service.SigninService;

@RestController
public class SigninController {

	@Autowired
	private SigninService signinService;


	/**
	 * 4.使用邮箱登录。
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/signin-with-email/{role}", method = { RequestMethod.POST })
	SigninResult login(
			@PathVariable String role,
			@RequestParam String email, 
			@RequestParam String password) {

		return signinService.signin(email, password);
	}

}
