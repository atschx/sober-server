package com.atschx.adnetwork.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


@Component
public class OfferRunner implements ApplicationRunner,Ordered {

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

	@Override
	public int getOrder() {
		return 0;
	}

}
