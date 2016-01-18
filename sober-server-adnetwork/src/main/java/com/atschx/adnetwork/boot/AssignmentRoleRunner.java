package com.atschx.adnetwork.boot;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.Role;
import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.RoleRepository;
import com.atschx.adnetwork.domain.repository.UserRepository;

@Component
public class AssignmentRoleRunner implements ApplicationRunner, Ordered {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Role supervisorRole = roleRepository.findByCode("ROLE_SUPERVISOR");
		
		HashSet<Role> roles = new HashSet<Role>();
		roles.add(supervisorRole);
		
		
		Iterable<User> findUsersByEmail = userRepository.findUsersByEmail("%@gmail.com");
		for (User soberUser : findUsersByEmail) {
			soberUser.setRoles(roles);
			userRepository.saveAndFlush(soberUser);
		}
		
		roles.remove(supervisorRole);
		Role advertiserRole = roleRepository.findByCode("ROLE_ADVERTISER");
		roles.add(advertiserRole);
		Iterable<User> advertisers = userRepository.findUsersByEmail("%@advertiser.com");
		for (User soberUser : advertisers) {
			soberUser.setRoles(roles);
			userRepository.saveAndFlush(soberUser);
		}
		
		roles.remove(advertiserRole);
		Role publisherRole = roleRepository.findByCode("ROLE_PUBLISHER");
		roles.add(publisherRole);
		Iterable<User> publishers = userRepository.findUsersByEmail("%@publisher.com");
		for (User soberUser : publishers) {
			soberUser.setRoles(roles);
			userRepository.saveAndFlush(soberUser);
		}
		
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
