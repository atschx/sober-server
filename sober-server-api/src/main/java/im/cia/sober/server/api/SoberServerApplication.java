package im.cia.sober.server.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class SoberServerApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SoberServerApplication.class, args);
	}


}
