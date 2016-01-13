package com.atschx.adnetwork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atschx.adnetwork.domain.model.SoberRole;

@Repository
public interface SoberRoleRepository extends JpaRepository<SoberRole, Long> {


}
