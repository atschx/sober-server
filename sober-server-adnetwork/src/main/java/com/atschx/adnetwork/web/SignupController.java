package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.protocol.response.SignupResult;
import com.atschx.adnetwork.service.SignupService;

@RestController
public class SignupController {

	@Autowired
	SignupService signupService;

	//http://www.exoclick.com/signup-verify/?token=60025f12efde97c3afac2fdde5fb2af277608a5d
	//https://www.exoclick.com/signup-verify/?token=60025f12efde97c3afac2fdde5fb2af277608a5d
	@RequestMapping(value = "signup", method = { RequestMethod.POST })
	SignupResult signup(User user) {

		return signupService.signup(user);

	}

}
