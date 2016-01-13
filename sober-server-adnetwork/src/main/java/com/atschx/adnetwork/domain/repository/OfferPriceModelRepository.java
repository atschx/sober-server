package com.atschx.adnetwork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atschx.adnetwork.domain.model.OfferPriceModel;

public interface OfferPriceModelRepository extends JpaRepository<OfferPriceModel, Long> {
	
	OfferPriceModel findByCode(String code);

}
