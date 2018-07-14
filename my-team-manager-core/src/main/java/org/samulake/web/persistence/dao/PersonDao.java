package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonDao extends AbstractDao<PersonEntity, PersonDto, Long>{
    @Autowired
    public PersonDao(JpaRepository<PersonEntity, Long> repository, AbstractConverter<PersonEntity, PersonDto> converter) {
        super(repository, converter);
    }
}
