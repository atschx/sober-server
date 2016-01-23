package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.protocol.response.SigninResult;
import com.atschx.adnetwork.service.AuthService;

/**
 * 相关鉴权服务。
 * 
 */
@RestController
public class AuthController {

	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	// 登录

	/**
	 * 4.使用邮箱登录。
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/signin-with-email/{role}", method = { RequestMethod.POST })
	SigninResult signin(
			@PathVariable String role, 
			@RequestParam String email, 
			@RequestParam String password) {

		return authService.signin(email, password);
	}

	/**
	 * 用户登出。
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/signout", method = { RequestMethod.GET })
	String signout(
			@RequestParam Long uid,
			@RequestParam String token) {
		authService.signout(uid);
		//清理token
		return "true";
	}
}
