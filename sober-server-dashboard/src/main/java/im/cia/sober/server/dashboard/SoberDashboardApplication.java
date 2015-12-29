package im.cia.sober.server.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SoberDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoberDashboardApplication.class, args);
	}

}
