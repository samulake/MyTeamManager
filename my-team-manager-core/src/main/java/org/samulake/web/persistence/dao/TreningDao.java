package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.core.entity.TreningEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class TreningDao extends AbstractDao<TreningEntity, TreningDto, Long> {
    @Autowired
    public TreningDao(JpaRepository<TreningEntity, Long> repository, AbstractConverter<TreningEntity, TreningDto> converter) {
        super(repository, converter);
    }
}
