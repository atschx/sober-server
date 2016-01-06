package im.cia.sober.server.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im.cia.sober.server.core.domain.model.SoberUser;

@Repository
public interface SoberUserRepository extends JpaRepository<SoberUser, Long> {

	@Modifying
	@Transactional
	@Query("delete from SoberUser u where u.active = false")
	void deleteInactiveUsers();

}
