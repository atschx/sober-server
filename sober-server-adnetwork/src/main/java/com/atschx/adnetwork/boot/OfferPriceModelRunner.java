package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.OfferPriceModel;
import com.atschx.adnetwork.domain.repository.OfferPriceModelRepository;

@Component
public class OfferPriceModelRunner implements ApplicationRunner, Ordered {
	
	@Autowired
	OfferPriceModelRepository priceModelRepository;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		priceModelRepository.save(new OfferPriceModel("CPA","Cost Per Action"));
		priceModelRepository.findByCode("CPA");
	}

}
