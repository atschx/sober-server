package com.atschx.adnetwork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atschx.adnetwork.domain.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findRoleByCode(String code);

}
