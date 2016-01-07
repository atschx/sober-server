package im.cia.sober.server.core;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import im.cia.sober.server.core.domain.model.SoberUser;
import im.cia.sober.server.core.domain.repository.SoberUserRepository;

@SpringBootApplication
public class SoberServerCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoberServerCoreApplication.class, args);
	}

	// 加入测试类数据
//
	@Bean
	public CommandLineRunner demo(final SoberUserRepository repository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

				System.out.println(repository);
				// 创建用户
				SoberUser soberUser = new SoberUser();
				soberUser.setUid(10020001L);
				soberUser.setActive(true);
				repository.save(soberUser);
//				System.out.println(soberUser.getId());
//				List<SoberUser> findAll = repository.findAll();
//				
//				for (SoberUser soberUser2 : findAll) {
//					System.out.println(soberUser2.getId());
//				}
				SoberUser soberUser2 = repository.findByUid(10020001L);
////				
				System.out.println(soberUser2.getId());

			}
		};

	}

}
