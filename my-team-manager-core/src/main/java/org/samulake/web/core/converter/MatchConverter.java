package org.samulake.web.core.converter;

import org.samulake.web.core.dto.EventDto;
import org.samulake.web.core.entity.EventEntity;
import org.samulake.web.core.entity.MatchEntity;
import org.samulake.web.core.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchConverter extends AbstractConverter<MatchEntity, MatchDto> {
    @Autowired
    private TeamConverter teamConverter;

    public MatchEntity toEntity(MatchDto matchDto) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setHomeTeam(teamConverter.toEntity(matchDto.getHomeTeam()));
        matchEntity.setVisitorTeam(teamConverter.toEntity(matchDto.getVisitorTeam()));
        matchEntity.setResult(matchDto.getResult());
        return matchEntity;
    }

    public MatchDto toDto(MatchEntity matchEntity) {
        MatchDto treningDto = new MatchDto();
        treningDto.setHomeTeam(teamConverter.toDto(matchEntity.getHomeTeam()));
        treningDto.setVisitorTeam(teamConverter.toDto(matchEntity.getVisitorTeam()));
        treningDto.setResult(matchEntity.getResult());
        return treningDto;
    }

}
