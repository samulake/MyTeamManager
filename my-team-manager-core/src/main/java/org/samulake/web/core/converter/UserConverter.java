package org.samulake.web.core.converter;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.core.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConverter extends PersonConverter<UserEntity, UserDto> {
    @Autowired
    private TeamConverter teamConverter;

    public UserEntity toEntity(UserDto dto) {
        UserEntity userEntity = super.toEntity(dto).cloneProto(new UserEntity());
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        return userEntity;
    }

    public UserDto toDto(UserEntity entity) {
        UserDto userDto = super.toDto(entity).cloneProto(new UserDto());
        userDto.setUsername(entity.getUsername());
        userDto.setPassword(entity.getPassword());
        if(entity.getTeam() != null) {
            userDto.setTeam(teamConverter.toDto(entity.getTeam()));
        }
        return userDto;
    }

}
