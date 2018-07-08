package org.samulake.web.core.converter;

import org.samulake.web.core.dto.EventDto;
import org.samulake.web.core.entity.EventEntity;
import org.samulake.web.core.entity.TreningEntity;
import org.samulake.web.core.dto.TreningDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreningConverter extends AbstractConverter<TreningEntity, TreningDto> {
    @Autowired
    private TeamConverter teamConverter;

    public TreningEntity toEntity(TreningDto treningDto) {
        TreningEntity treningEntity = new TreningEntity();
        treningEntity.setTeam(teamConverter.toEntity(treningDto.getTeam()));
        return treningEntity;
    }

    public TreningDto toDto(TreningEntity treningEntity) {
        TreningDto treningDto = new TreningDto();
        treningDto.setTeam(teamConverter.toDto(treningEntity.getTeam()));
        return treningDto;
    }
}
