package org.samulake.web.core.converter;

import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.core.entity.MatchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchConverter extends AbstractConverter<MatchEntity, MatchDto> {
    @Autowired
    private TeamConverter teamConverter;
    @Autowired
    private EventConverter eventConverter;

    public MatchEntity toEntity(MatchDto matchDto) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setHomeTeam(teamConverter.toEntity(matchDto.getHomeTeam()));
        matchEntity.setVisitorTeam(teamConverter.toEntity(matchDto.getVisitorTeam()));
        matchEntity.setResult(matchDto.getResult());
        return eventConverter.toEntity(matchEntity, matchDto);
    }

    public MatchDto toDto(MatchEntity matchEntity) {
        MatchDto matchDto = new MatchDto();
        matchDto.setHomeTeam(teamConverter.toDto(matchEntity.getHomeTeam()));
        matchDto.setVisitorTeam(teamConverter.toDto(matchEntity.getVisitorTeam()));
        matchDto.setResult(matchEntity.getResult());
        return eventConverter.toDto(matchEntity, matchDto);
    }

}
