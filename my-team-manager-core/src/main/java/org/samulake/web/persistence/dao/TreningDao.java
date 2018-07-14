package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.converter.TeamConverter;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.core.entity.TreningEntity;
import org.samulake.web.persistence.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TreningDao extends AbstractDao<TreningEntity, TreningDto, Long> {
    @Autowired
    private TeamConverter teamConverter;

    @Autowired
    public TreningDao(JpaRepository<TreningEntity, Long> repository, AbstractConverter<TreningEntity, TreningDto> converter) {
        super(repository, converter);
    }

    public List<TreningDto> getByTeam(TeamDto dto) {
        TreningRepository treningRepository = (TreningRepository) this.repository;
        List<TreningEntity> trenings = treningRepository.findByTeam(teamConverter.toEntity(dto));
        return converter.toDtoCollection(trenings);
    }
}
