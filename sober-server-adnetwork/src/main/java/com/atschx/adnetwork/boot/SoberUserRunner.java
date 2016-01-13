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

		SoberUser soberUser = new SoberUser();
		soberUser.setEmail("1" + System.currentTimeMillis() + "@1.com");
		soberUser.setMobile("13818252513");
		soberUser.setQq("34551232");
		userRepository.save(soberUser);

	}

	@Override
	public int getOrder() {
		return 0;
	}

}
