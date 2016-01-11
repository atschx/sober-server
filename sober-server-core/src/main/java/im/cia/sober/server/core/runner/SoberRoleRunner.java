package im.cia.sober.server.core.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import im.cia.sober.server.core.domain.model.SoberRole;
import im.cia.sober.server.core.domain.repository.SoberRoleRepository;

@Component
public class SoberRoleRunner implements ApplicationRunner, Ordered {

	@Autowired
	SoberRoleRepository roleRepository;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		roleRepository.save(new SoberRole("ROLE_SUPERVISOR"));
		roleRepository.save(new SoberRole("ROLE_ADVERTISER"));
		roleRepository.save(new SoberRole("ROLE_PUBLISHER"));
		roleRepository.save(new SoberRole("ROLE_DEVELOPER"));

	}

}
