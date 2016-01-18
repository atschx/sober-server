package com.atschx.adnetwork.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.UserRepository;

@Component
public class UserRunner implements ApplicationRunner, Ordered {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// 测试数据密码采用明文
		User atschx = new User("astchx", "atschx@gmail.com", "atschx");
		User admin = new User("admin", "admin@gmail.com", "admin");
		admin.setMobile("13800001101");
		atschx.setMobile("13800001101");
		userRepository.save(atschx);
		userRepository.save(admin);

		// 广告主
		for (int i = 0; i < 8; i++) {
			userRepository.save(new User("advertiser-" + i, "advertiser-" + i + "@advertiser.com", "advertiser"));
		}

		//流量
		for (int i = 0; i < 13; i++) {
			userRepository.save(new User("publisher-" + i, "publisher-" + i + "@publisher.com", "publisher"));
		}

	}

	@Override
	public int getOrder() {
		return 0;
	}

}
