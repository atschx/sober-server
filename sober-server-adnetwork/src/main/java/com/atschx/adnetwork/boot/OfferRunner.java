package com.atschx.adnetwork.boot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.AdNetwork;
import com.atschx.adnetwork.domain.model.Offer;
import com.atschx.adnetwork.domain.repository.OfferRepository;

@Component
public class OfferRunner implements ApplicationRunner, Ordered {

	@Autowired
	OfferRepository offerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Offer offer = new Offer("QQ", 2.2, "下载注册用户，留存2周算作一个", new Date());
		offer.setClearingCycle(AdNetwork.ClearingCycle.WEEK);
		offerRepository.save(offer);

	}

	@Override
	public int getOrder() {
		return 0;
	}

}
