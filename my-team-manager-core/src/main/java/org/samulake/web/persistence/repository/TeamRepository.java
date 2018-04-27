package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    TeamEntity findByName(String name);
}
