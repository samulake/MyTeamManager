package org.samulake.web.core.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<ENTITY, DTO> implements IConverter<ENTITY, DTO> {

	@Override
	public List<ENTITY> toEntityCollection(List<DTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public List<DTO> toDtoCollection(List<ENTITY> entities) {
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}
	
		

}
