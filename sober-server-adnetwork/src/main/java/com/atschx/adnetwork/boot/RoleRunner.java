package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.Role;
import com.atschx.adnetwork.domain.repository.RoleRepository;

@Component
public class RoleRunner implements ApplicationRunner, Ordered {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		roleRepository.save(new Role("ROLE_SUPERVISOR"));
		// Advertiser(sell traffic)
		roleRepository.save(new Role("ROLE_ADVERTISER"));
		// Publisher(buy traffic)
		roleRepository.save(new Role("ROLE_PUBLISHER"));

	}

}
