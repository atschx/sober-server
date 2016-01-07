package im.cia.sober.server.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import im.cia.sober.server.core.domain.model.SoberAppSetting;

@Repository
public interface SoberAppSettingRepository extends JpaRepository<SoberAppSetting, Long> {

}
