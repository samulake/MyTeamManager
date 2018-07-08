package org.samulake.web.persistence.repository;

import org.samulake.web.core.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository<T extends EventEntity> extends JpaRepository<T, Long> {
}
