package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.AdNetwork;
import com.atschx.adnetwork.domain.model.Offer;
import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.OfferRepository;
import com.atschx.adnetwork.domain.repository.UserRepository;

@Component
public class OfferRunner implements ApplicationRunner, Ordered {

	@Autowired
	OfferRepository offerRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		User user = userRepository.findByEmail("atschx@gmail.com");
		for (int i = 0; i < 10; i++) {
			Offer offer = new Offer("下载并注册QQ" + i, 2.2, "下载注册用户，留存2周算作一个");
			offer.setClearingCycle(AdNetwork.ClearingCycle.WEEK);
			offer.setPriceModel(AdNetwork.OfferPriceModel.CPA);
			offer.setPlatform(AdNetwork.Platform.ANDROID);
			offer.setCreatedBy(user);
			offer.setLastModifiedBy(user);
			offerRepository.save(offer);
		}

	}

	@Override
	public int getOrder() {
		return 1;
	}

}
