package im.cia.sober.server.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import im.cia.sober.server.core.domain.model.SoberTask;
import im.cia.sober.server.core.domain.repository.SoberTaskRepository;

@SpringBootApplication
public class SoberServerCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoberServerCoreApplication.class, args);
	}

	// @Bean
	public CommandLineRunner demoTask(final SoberTaskRepository repository) {

		final Logger logger = LoggerFactory.getLogger(SoberServerCoreApplication.class);
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i = 0; i < 13; i++) {
					SoberTask soberTask = new SoberTask();
					soberTask.setTid("xxxx");
					soberTask.setAppId("cn.youja.uplus");
					soberTask.setUid(10000L);
					repository.save(soberTask);
					logger.info(soberTask.getId() + "");
				}
			}
		};
	}

}
