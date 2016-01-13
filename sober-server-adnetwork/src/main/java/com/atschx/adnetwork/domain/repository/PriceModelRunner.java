package com.atschx.adnetwork.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.PriceModel;

@Component
public class PriceModelRunner implements ApplicationRunner, Ordered {
	
	@Autowired
	PriceModelRepository priceModelRepository;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		priceModelRepository.save(new PriceModel("CPA","Cost Per Action"));
		priceModelRepository.findByCode("CPA");
	}

}
