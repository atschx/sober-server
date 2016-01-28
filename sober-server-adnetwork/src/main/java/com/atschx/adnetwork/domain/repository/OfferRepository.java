package com.atschx.adnetwork.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atschx.adnetwork.domain.model.Offer;


public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	/**
	 * 查询某个用户创建的offer.
	 */
	@Query("select offer from Offer offer  where offer.createdBy.id = ?1")
	Page<Offer> findByCreatedBy(Pageable pageable,Long owner);

}
