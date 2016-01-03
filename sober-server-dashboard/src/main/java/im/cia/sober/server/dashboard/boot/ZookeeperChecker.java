package im.cia.sober.server.dashboard.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ZookeeperChecker implements ApplicationRunner, Ordered {

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		System.out.println("check zookeeper!");
	}

}
