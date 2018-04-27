package org.samulake.web.core.converter;

import org.samulake.web.core.entity.TreningEntity;
import org.samulake.web.core.dto.TreningDto;
import org.springframework.beans.factory.annotation.Autowired;

public class TreningConverter extends EventConverter {
    @Autowired
    private TeamConverter teamConverter;

    public TreningEntity toEntity(TreningDto treningDto) {
        TreningEntity treningEntity = (TreningEntity) super.toEntity(treningDto);
        treningEntity.setTeam(teamConverter.toEntity(treningDto.getTeam()));
        return treningEntity;
    }

    public TreningDto toDto(TreningEntity treningEntity) {
        TreningDto treningDto = (TreningDto) super.toDto(treningEntity);
        treningDto.setTeam(teamConverter.toDto(treningEntity.getTeam()));
        return treningDto;
    }
}
