package im.cia.sober.server.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import im.cia.sober.server.core.domain.model.SoberAppField;

@Repository
public interface SoberAppFieldRepository extends JpaRepository<SoberAppField, Long> {

}
