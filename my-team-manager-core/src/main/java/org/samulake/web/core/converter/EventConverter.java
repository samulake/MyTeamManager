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
        EventEntity eventEntity = new EventEntity() {
        };
        eventEntity.setId(eventDto.getId());
        eventEntity.setDateTime(eventDto.getDateTime());
        eventEntity.setPlace(placeConverter.toEntity(eventDto.getPlace()));
        return eventEntity;
    }

    @Override
    public EventDto toDto(EventEntity eventEntity) {
        EventDto eventDto = new EventDto() {
        };
        eventDto.setId(eventEntity.getId());
        eventDto.setDateTime(eventEntity.getDateTime());
        eventDto.setPlace(placeConverter.toDto(eventEntity.getPlace()));
        return eventDto;
    }
}
