package org.samulake.web.core.converter;

import org.samulake.web.core.entity.EventEntity;
import org.samulake.web.core.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventConverter extends AbstractConverter<EventEntity, EventDto> {
    @Autowired
    private PlaceConverter placeConverter;

    @Override
    public EventEntity toEntity(EventDto eventDto) {
        return toEntity(new EventEntity(), eventDto);
    }

    @Override
    public EventDto toDto(EventEntity eventEntity) {
        return toDto(eventEntity,new EventDto());
    }

    public <ENTITY extends EventEntity, DTO extends EventDto> ENTITY toEntity(ENTITY eventEntity, DTO dto) {
        eventEntity.setId(dto.getId());
        eventEntity.setDateTime(dto.getDateTime());
        eventEntity.setPlace(placeConverter.toEntity(dto.getPlace()));
        return eventEntity;
    }

    public <ENTITY extends EventEntity, DTO extends EventDto> DTO toDto(ENTITY entity, DTO eventDto) {
        eventDto.setId(entity.getId());
        eventDto.setDateTime(entity.getDateTime());
        eventDto.setPlace(placeConverter.toDto(entity.getPlace()));
        return eventDto;
    }
}
