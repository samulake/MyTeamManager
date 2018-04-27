package org.samulake.web.core.converter;

import org.samulake.web.core.entity.PlaceEntity;
import org.samulake.web.core.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceConverter extends AbstractConverter<PlaceEntity, PlaceDto> {
    @Autowired
    private CityConverter cityConverter;

    @Override
    public PlaceEntity toEntity(PlaceDto placeDto) {
        PlaceEntity entity = new PlaceEntity();
        entity.setId(placeDto.getId());
        entity.setCity(cityConverter.toEntity(placeDto.getCity()));
        return entity;
    }

    @Override
    public PlaceDto toDto(PlaceEntity placeEntity) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(placeEntity.getId());
        placeDto.setCity(cityConverter.toDto(placeEntity.getCity()));
        placeDto.setStreetAndNr(placeEntity.getStreetAndNr());
        return placeDto;
    }
}
