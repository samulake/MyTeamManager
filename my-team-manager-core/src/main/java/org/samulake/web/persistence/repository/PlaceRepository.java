package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {
}
