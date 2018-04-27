package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.TreningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreningRepository extends JpaRepository<TreningEntity, Long> {
}
