package org.samulake.web.persistence.dao;

import org.samulake.web.core.converter.AbstractConverter;
import org.samulake.web.core.dto.UserDto;
import org.samulake.web.core.entity.UserEntity;
import org.samulake.web.persistence.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDao extends AbstractDao<UserEntity, UserDto, Long> {

    public UserDao(JpaRepository<UserEntity, Long> repository, AbstractConverter<UserEntity, UserDto> converter) {
        super(repository, converter);
    }

    public UserDto getByName(String name) {
        return converter.toDto(((UserRepository) repository).findByUsername(name));
    }
}
