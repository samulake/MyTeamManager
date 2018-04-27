package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.entity.EventEntity;
import org.samulake.web.core.dto.EventDto;
import org.springframework.data.jpa.repository.JpaRepository;

public class EventDao extends AbstractDao<EventEntity, EventDto, Long> {

    public EventDao(JpaRepository<EventEntity, Long> repository, AbstractConverter<EventEntity, EventDto> converter) {
        super(repository, converter);
    }
}
