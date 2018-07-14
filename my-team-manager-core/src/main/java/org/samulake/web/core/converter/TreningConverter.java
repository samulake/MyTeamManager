package org.samulake.web.core.converter;

import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.core.entity.TreningEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreningConverter extends AbstractConverter<TreningEntity, TreningDto> {
    @Autowired
    private TeamConverter teamConverter;
    @Autowired
    private EventConverter eventConverter;

    public TreningEntity toEntity(TreningDto treningDto) {
        TreningEntity treningEntity = new TreningEntity();
        treningEntity.setTeam(teamConverter.toEntity(treningDto.getTeam()));
        return eventConverter.toEntity(treningEntity, treningDto);
    }

    public TreningDto toDto(TreningEntity treningEntity) {
        TreningDto treningDto = new TreningDto();
        treningDto.setTeam(teamConverter.toDto(treningEntity.getTeam()));
        return eventConverter.toDto(treningEntity, treningDto);
    }
}
