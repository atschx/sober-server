package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.Category;
import com.atschx.adnetwork.domain.repository.CategoryRepository;

@Component
public class OfferCategoryRunner implements ApplicationRunner, Ordered {

	@Autowired
	CategoryRepository offerCategoryRepository;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Category education = new Category("教育", 1);
		Category life = new Category("生活", 1);
		Category trip = new Category("旅游", 1);
		Category game = new Category("游戏", 1);
		Category enjoy = new Category("娱乐", 1);

		offerCategoryRepository.save(education);
		offerCategoryRepository.save(life);
		offerCategoryRepository.save(trip);
		offerCategoryRepository.save(game);
		offerCategoryRepository.save(enjoy);

		Category onlineCourse = new Category("网络课程", 2);
		onlineCourse.setParent(education);
		offerCategoryRepository.save(onlineCourse);

	}

}
