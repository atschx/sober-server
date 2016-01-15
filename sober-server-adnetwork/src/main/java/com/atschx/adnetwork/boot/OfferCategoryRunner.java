package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.OfferCategory;
import com.atschx.adnetwork.domain.repository.OfferCategoryRepository;

@Component
public class OfferCategoryRunner implements ApplicationRunner, Ordered {

	@Autowired
	OfferCategoryRepository offerCategoryRepository;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		OfferCategory education = new OfferCategory("教育", 1);
		OfferCategory life = new OfferCategory("生活", 1);
		OfferCategory trip = new OfferCategory("旅游", 1);
		OfferCategory game = new OfferCategory("游戏", 1);
		OfferCategory enjoy = new OfferCategory("娱乐", 1);

		offerCategoryRepository.save(education);
		offerCategoryRepository.save(life);
		offerCategoryRepository.save(trip);
		offerCategoryRepository.save(game);
		offerCategoryRepository.save(enjoy);

		OfferCategory onlineCourse = new OfferCategory("网络课程", 2);
		onlineCourse.setParent(education);
		offerCategoryRepository.save(onlineCourse);

	}

}
