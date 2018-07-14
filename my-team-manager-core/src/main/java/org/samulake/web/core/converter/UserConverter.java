package org.samulake.web.core.converter;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.core.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConverter extends AbstractConverter<UserEntity, UserDto> {
    @Autowired
    private TeamConverter teamConverter;
    @Autowired
    private PersonConverter personConverter;

    public UserEntity toEntity(UserDto dto) {
        if(dto == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        if(dto.getTeam() != null)
            userEntity.setTeam(teamConverter.toEntity(dto.getTeam()));
        return personConverter.toEntity(userEntity, dto);
    }

    public UserDto toDto(UserEntity entity) {
        UserDto userDto = new UserDto();
        userDto.setUsername(entity.getUsername());
        userDto.setPassword(entity.getPassword());
        if(entity.getTeam() != null) {
            userDto.setTeam(teamConverter.toDto(entity.getTeam()));
        }
        return personConverter.toDto(entity, userDto);
    }

}
