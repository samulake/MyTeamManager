package org.samulake.web.core.converter;

import java.util.List;

public interface IConverter<ENTITY, DTO>  {
	ENTITY toEntity(DTO dto);
	
	DTO toDto(ENTITY entity);
	
	List<ENTITY> toEntityCollection(List<DTO> dtos);
	
	List<DTO> toDtoCollection(List<ENTITY> entities);
}
