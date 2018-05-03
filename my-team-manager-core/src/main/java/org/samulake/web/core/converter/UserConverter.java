package org.samulake.web.core.converter;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.core.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConverter extends PersonConverter<UserEntity, UserDto> {
    @Autowired
    private PersonConverter personConverter;

    public UserEntity toEntity(UserDto dto) {
        super.toEntity(dto);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        return userEntity;
    }

    public UserDto toDto(UserEntity entity) {
        super.toDto(entity);
        UserDto userDto = new UserDto();
        userDto.setUsername(entity.getUsername());
        userDto.setPassword(entity.getPassword());
        return userDto;
    }
}
