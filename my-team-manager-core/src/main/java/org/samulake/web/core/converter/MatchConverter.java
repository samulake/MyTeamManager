package org.samulake.web.core.converter;

import org.samulake.web.core.entity.MatchEntity;
import org.samulake.web.core.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchConverter extends EventConverter {
    @Autowired
    private TeamConverter teamConverter;

    public MatchEntity toEntity(MatchDto matchDto) {
        MatchEntity matchEntity = (MatchEntity) super.toEntity(matchDto);
        matchEntity.setHomeTeam(teamConverter.toEntity(matchDto.getHomeTeam()));
        matchEntity.setVisitorTeam(teamConverter.toEntity(matchDto.getVisitorTeam()));
        matchEntity.setResult(matchDto.getResult());
        return matchEntity;
    }

    public MatchDto toDto(MatchEntity matchEntity) {
        MatchDto treningDto = (MatchDto) super.toDto(matchEntity);
        treningDto.setHomeTeam(teamConverter.toDto(matchEntity.getHomeTeam()));
        treningDto.setVisitorTeam(teamConverter.toDto(matchEntity.getVisitorTeam()));
        treningDto.setResult(matchEntity.getResult());
        return treningDto;
    }

}
