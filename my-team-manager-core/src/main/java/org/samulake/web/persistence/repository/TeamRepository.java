package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    TeamEntity findByName(String name);

    @Query("SELECT name FROM TeamEntity")
    Collection<String> findAllTeamsNames();

    TeamEntity findByLeaderUsername(String leaderUserName);
}
