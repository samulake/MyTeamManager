package org.samulake.web.core.converter;

import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.core.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamConverter extends AbstractConverter<TeamEntity, TeamDto> {
	@Autowired
	private PersonConverter personConverter;
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public TeamEntity toEntity(TeamDto dto) {
		TeamEntity team = new TeamEntity();
		team.setName(dto.getName());
		team.setMembers(personConverter.toEntityCollection(dto.getMembers()));
		team.setLeader(userConverter.toEntity(dto.getLeader()));
		return team;
	}

	@Override
	public TeamDto toDto(TeamEntity entity) {
		TeamDto teamDto = new TeamDto();
		teamDto.setId(entity.getId());
		teamDto.setName(entity.getName());
		teamDto.setMembers(personConverter.toDtoCollection(entity.getMembers()));
		return teamDto;
	}

}
