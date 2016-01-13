package com.atschx.adnetwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.atschx.adnetwork.protocol.response.LoginResult;

@Service
public class LoginService {

	private Logger logger = LoggerFactory.getLogger(LoginService.class);

	public LoginResult login(String email, String password) {

		logger.debug(email + "登录!");
		
		return new LoginResult();
	}

}
