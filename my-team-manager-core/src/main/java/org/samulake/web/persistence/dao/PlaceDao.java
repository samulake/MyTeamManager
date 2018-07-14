package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.dto.PlaceDto;
import org.samulake.web.core.entity.PlaceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class PlaceDao extends AbstractDao<PlaceEntity, PlaceDto, Integer> {
    @Autowired
    public PlaceDao(JpaRepository<PlaceEntity, Integer> repository, AbstractConverter<PlaceEntity, PlaceDto> converter) {
        super(repository, converter);
    }
}
