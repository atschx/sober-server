package com.atschx.adnetwork.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atschx.adnetwork.domain.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	
	User findByEmail(String email);
	
	Iterable<User> findByEmailLike(@Param("email") String email);
	
	//分页
	@Query("select user from User user join user.roles role where role.code = ?1")
	Page<User> findByRoleCode(String code,Pageable pageable);

	@Modifying
	@Transactional
	@Query("delete from User u where u.status =:status ")
	void deleteUsersByStatus(@Param("status") String status);

}
