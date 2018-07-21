package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.converter.TeamConverter;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.core.entity.EventEntity;
import org.samulake.web.core.entity.MatchEntity;
import org.samulake.web.persistence.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class MatchDao extends AbstractDao<MatchEntity, MatchDto, Long> {
    @Autowired
    private TeamConverter teamConverter;

    @Autowired
    public MatchDao(JpaRepository<MatchEntity, Long> repository, AbstractConverter<MatchEntity, MatchDto> converter) {
        super(repository, converter);
    }

    public MatchDto getUserTeamNextMatch(TeamDto teamDto) {
        List<MatchEntity> nextMatches = ((MatchRepository) repository).findByHomeTeam(teamConverter.toEntity(teamDto));
        if(nextMatches.size() < 1) {
            return null;
        }
        nextMatches.sort(Comparator.comparing(EventEntity::getDateTime));
        return converter.toDtoCollection(nextMatches).get(0);
    }
}
