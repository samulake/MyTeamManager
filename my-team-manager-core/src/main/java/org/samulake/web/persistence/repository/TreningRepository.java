package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.TeamEntity;
import org.samulake.web.core.entity.TreningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<TreningEntity, Long> {
    List<TreningEntity> findByTeam(TeamEntity team);
}
