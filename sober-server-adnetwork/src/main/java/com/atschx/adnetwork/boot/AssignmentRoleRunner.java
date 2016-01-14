package com.atschx.adnetwork.boot;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.SoberRole;
import com.atschx.adnetwork.domain.model.SoberUser;
import com.atschx.adnetwork.domain.repository.SoberRoleRepository;
import com.atschx.adnetwork.domain.repository.SoberUserRepository;

@Component
public class AssignmentRoleRunner implements ApplicationRunner, Ordered {

	@Autowired
	SoberRoleRepository roleRepository;

	@Autowired
	SoberUserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		SoberRole supervisorRole = roleRepository.findRoleByCode("ROLE_SUPERVISOR");
		HashSet<SoberRole> roles = new HashSet<SoberRole>();
		roles.add(supervisorRole);
		
		List<SoberUser> users = userRepository.findAll();
		for (SoberUser soberUser : users) {
			soberUser.setRoles(roles);
			userRepository.saveAndFlush(soberUser);
		}
		
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
