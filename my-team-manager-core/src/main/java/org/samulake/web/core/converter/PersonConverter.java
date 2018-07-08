package org.samulake.web.core.converter;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.entity.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonConverter extends AbstractConverter<PersonEntity, PersonDto>{

	public <ENTITY extends PersonEntity, DTO extends PersonDto> ENTITY toEntity(ENTITY entity, DTO dto) {
		if(dto == null) {
			return null;
		}
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		return entity;
	}

	public <ENTITY extends PersonEntity, DTO extends PersonDto> DTO toDto(ENTITY entity, DTO dto) {
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		return dto;
	}

	@Override
	public PersonEntity toEntity(PersonDto personDto) {
		return toEntity(new PersonEntity(),personDto);
	}

	@Override
	public PersonDto toDto(PersonEntity entity) {
		return toDto(entity, new PersonDto());
	}
}
