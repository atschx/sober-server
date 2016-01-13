package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.SoberUser;
import com.atschx.adnetwork.protocol.response.SignupResult;
import com.atschx.adnetwork.service.SignupService;

@RestController
public class SignupController {

	@Autowired
	SignupService signupService;

	@RequestMapping(value = "signup", method = { RequestMethod.POST })
	SignupResult signup(SoberUser user) {

		return signupService.signup(user);

	}

}
