package im.cia.sober.server.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import im.cia.sober.server.core.domain.model.SoberApp;

@Repository
public interface SoberAppRepository extends JpaRepository<SoberApp, Integer> {

}
