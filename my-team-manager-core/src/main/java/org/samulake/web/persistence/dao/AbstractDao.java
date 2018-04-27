package org.samulake.web.persistence.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.samulake.web.core.converter.AbstractConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractDao<ENTITY, DTO, ID extends Number> {
    JpaRepository<ENTITY, ID> repository;
    AbstractConverter<ENTITY, DTO> converter;

    public AbstractDao(JpaRepository<ENTITY, ID> repository, AbstractConverter<ENTITY, DTO> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public DTO get(ID id) {
        return converter.toDto(repository.findOne(id));
    }

    public void delete(DTO dto) {
        repository.delete(converter.toEntity(dto));
    }

    public void save(DTO dto) {
        repository.save(converter.toEntity(dto));
    }

    public List<DTO> findAll() {
        return repository.findAll().stream().map(converter::toDto).collect(Collectors.toList());
    }


}

