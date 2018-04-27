package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.entity.TeamEntity;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.persistence.repository.TeamRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TeamDao extends AbstractDao<TeamEntity, TeamDto, Long> {

    public TeamDao(JpaRepository<TeamEntity, Long> repository, AbstractConverter<TeamEntity, TeamDto> converter) {
        super(repository, converter);
    }

    public TeamDto findByName(String name) {
        return converter.toDto(((TeamRepository)repository).findByName(name));
    }
}
