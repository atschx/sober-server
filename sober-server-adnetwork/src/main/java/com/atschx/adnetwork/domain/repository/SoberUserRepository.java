package com.atschx.adnetwork.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atschx.adnetwork.domain.model.SoberUser;

@Repository
public interface SoberUserRepository extends JpaRepository<SoberUser, Long> {

	@Modifying
	@Transactional
	@Query("delete from SoberUser u where u.status =:status ")
	void deleteUsersByStatus(@Param("status") String status);
	
	SoberUser findUserByName(String name);
	
	//分页
	@Query("select user from SoberUser user join user.roles role where role.code = ?1")
	Page<SoberUser> findByRoleCode(String code,Pageable pageable);


}
