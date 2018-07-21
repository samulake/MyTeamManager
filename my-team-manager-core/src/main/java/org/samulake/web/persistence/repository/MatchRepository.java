package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.MatchEntity;
import org.samulake.web.core.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {

    List<MatchEntity> findByHomeTeam(@Param("homeTeam") TeamEntity homeTeam);
}
