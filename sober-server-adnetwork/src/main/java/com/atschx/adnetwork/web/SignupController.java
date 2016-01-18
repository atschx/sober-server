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

	@Autowired
	private AccountService accountService;

	/**
	 * 供Ajax校验email的唯一性
	 */
	@RequestMapping(value = "checkEmail")
	// @ResponseBody
	public String checkEmail(@RequestParam("email") String email) {
		logger.debug("前端传入登录名称:" + email);
		if (accountService.findUserByEmail(email) == null) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * 注册用户基础字段：email password mobile
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "signup", method = { RequestMethod.POST })
	public SignupResult signup(User user) {
		return accountService.register(user);
	}

	// signup-verify/?token=60025f12efde97c3afac2fdde5fb2af277608a5d
	@RequestMapping(value = "signup-verify", method = { RequestMethod.GET })
	public String signupVerify(@RequestParam("token") String token) {
		User user = accountService.active(token);
		return (null != user) ? (String.valueOf(user.getStatus().equals(1))) : "false";
	}

}
