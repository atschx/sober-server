package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.SoberUser;
import com.atschx.adnetwork.domain.repository.SoberUserRepository;

@Component
public class SoberUserRunner implements ApplicationRunner, Ordered {

	@Autowired
	SoberUserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		userRepository.save(new SoberUser("astchx", "atschx@gmail.com"));
		userRepository.save(new SoberUser("admin", "admin@atschx.com"));
		userRepository.save(new SoberUser("test", "test@atschx.com"));
		userRepository.save(new SoberUser("service", "service@atschx.com"));

	}

	@Override
	public int getOrder() {
		return 0;
	}

}
