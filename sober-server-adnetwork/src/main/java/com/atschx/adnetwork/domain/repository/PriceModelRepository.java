package com.atschx.adnetwork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atschx.adnetwork.domain.model.PriceModel;

public interface PriceModelRepository extends JpaRepository<PriceModel, Long> {
	
	PriceModel findByCode(String code);

}
