package com.atschx.adnetwork.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atschx.adnetwork.domain.model.Role;
import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.RoleRepository;
import com.atschx.adnetwork.domain.repository.UserRepository;

@Service
public class UserManagementImpl implements UserManagement {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserManagementImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Transactional
	@Override
	public void addRoleToAllUsers(String roleName) {

		Role role = roleRepository.findByCode(roleName);
		
		for (User user : userRepository.findAll()) {
			user.addRole(role);
			userRepository.save(user);
		}
	}

}
