package org.samulake.web.core.converter;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.UserDto;
import org.samulake.web.core.entity.PersonEntity;
import org.samulake.web.core.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserConverter extends PersonConverter {
    @Autowired
    private PersonConverter personConverter;

    public UserEntity toEntity(UserDto dto) {
        UserEntity userEntity = (UserEntity) super.toEntity(dto);
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        return userEntity;
    }

    public UserDto toDto(UserEntity entity) {
        UserDto userDto = (UserDto) super.toDto(entity);
        userDto.setUsername(entity.getUsername());
        userDto.setPassword(entity.getPassword());
        return userDto;
    }
}
