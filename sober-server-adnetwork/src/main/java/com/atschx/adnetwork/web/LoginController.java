package com.atschx.adnetwork.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.protocol.response.LoginResult;
import com.atschx.adnetwork.service.LoginService;
import com.atschx.adnetwork.service.MailService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	MailService mailService;

	/**
	 * 1.login(目前仅支持邮箱登录)
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	LoginResult login(
			@RequestParam String email,
			@RequestParam String password,
			HttpServletRequest request) {
		
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		
		System.out.println(remoteAddr);
		System.out.println(remoteHost);
		return loginService.login(email, password);
	}

}
