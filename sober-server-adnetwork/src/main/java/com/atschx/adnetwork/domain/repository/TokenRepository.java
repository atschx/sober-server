package com.atschx.adnetwork.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atschx.adnetwork.domain.model.Token;

public interface TokenRepository extends JpaRepository<Token, String> {

	Token findByToken(String token);

	List<Token> findByUid(Long uid);

}
