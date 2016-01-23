package com.atschx.adnetwork.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.protocol.response.SignupResult;
import com.atschx.adnetwork.service.AccountService;

@RestController
public class SignupController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

	private final AccountService accountService;

	@Autowired
	public SignupController(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 供Ajax校验email的唯一性
	 */
	@RequestMapping(value = "check-email",method={RequestMethod.GET})
	public String checkEmail(@RequestParam("email") String email) {
		logger.debug("前端传入登录名称:" + email);
		if (accountService.findUserByEmail(email) == null) {
			return "true";
		} else {
			return "false";
		}
	}

	/** 
	 * 基于邮箱注册
	 * 
	 * @param email
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "signup-with-email", method = { RequestMethod.POST })
	public SignupResult signup(
			@RequestParam("email") String email,
			@RequestParam(value = "name", required = false) String name, 
			@RequestParam("password") String password) {
		
		User user = new User(name, email, password);
		return accountService.register(user);
		
	}

	/**
	 * 注册激活验证
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "signup-verify", method = { RequestMethod.GET })
	public String signupVerify(@RequestParam("token") String token) {
		User user = accountService.active(token);
		return (null != user) ? (String.valueOf(user.getStatus() == 1)) : "false";
	}
}
