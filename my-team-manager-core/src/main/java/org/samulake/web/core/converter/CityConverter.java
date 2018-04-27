package org.samulake.web.core.converter;

import org.samulake.web.core.entity.CityEntity;
import org.samulake.web.core.dto.CityDto;
import org.springframework.stereotype.Service;

@Service
public class CityConverter extends AbstractConverter<CityEntity, CityDto> {

    @Override
    public CityEntity toEntity(CityDto cityDto) {
        CityEntity cityEntity = new CityEntity();
        cityDto.setId(cityDto.getId());
        cityDto.setName(cityDto.getName());
        return cityEntity;
    }

    @Override
    public CityDto toDto(CityEntity cityEntity) {
        CityDto cityDto = new CityDto();
        cityDto.setId(cityEntity.getId());
        cityDto.setName(cityEntity.getName());
        return cityDto;
    }
}
