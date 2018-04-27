package org.samulake.web.core.converter;

import org.samulake.web.core.entity.PersonEntity;
import org.samulake.web.core.dto.PersonDto;
import org.springframework.stereotype.Service;
@Service
public class PersonConverter extends AbstractConverter<PersonEntity, PersonDto> {

	@Override
	public PersonEntity toEntity(PersonDto dto) {
		PersonEntity person = new PersonEntity();
		person.setId(dto.getId());
		person.setFirstName(dto.getFirstName());
		person.setLastName(dto.getLastName());
		return person;
	}

	@Override
	public PersonDto toDto(PersonEntity entity) {
		PersonDto personDto = new PersonDto();
		personDto.setId(entity.getId());
		personDto.setFirstName(entity.getFirstName());
		personDto.setLastName(entity.getLastName());
		return personDto;
	}

}
