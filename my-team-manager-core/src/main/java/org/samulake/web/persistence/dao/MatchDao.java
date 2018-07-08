package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.core.entity.MatchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class MatchDao extends AbstractDao<MatchEntity, MatchDto, Long> {
    @Autowired
    public MatchDao(JpaRepository<MatchEntity, Long> repository, AbstractConverter<MatchEntity, MatchDto> converter) {
        super(repository, converter);
    }
}
