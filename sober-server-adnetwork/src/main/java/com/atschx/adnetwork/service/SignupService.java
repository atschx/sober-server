package com.atschx.adnetwork.service;

import org.springframework.stereotype.Service;

import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.protocol.response.SignupResult;


@Service
public class SignupService {
	
	public SignupResult signup(User user){
		
		
		return new SignupResult();
	}

}
