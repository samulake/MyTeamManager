package org.samulake.web.core.converter;

import org.samulake.web.core.entity.TeamEntity;
import org.samulake.web.core.entity.UserEntity;
import org.samulake.web.persistence.repository.UserRepository;
import org.samulake.web.core.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamConverter extends AbstractConverter<TeamEntity, TeamDto> {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PersonConverter personConverter;
	
	@Override
	public TeamEntity toEntity(TeamDto dto) {
		TeamEntity team = new TeamEntity();
		team.setId(dto.getId());
		team.setName(dto.getName());
		team.setMembers(personConverter.toEntityCollection(dto.getMembers()));
		team.setLeader(new UserEntity());
		return team;
	}

	@Override
	public TeamDto toDto(TeamEntity entity) {
		TeamDto teamDto = new TeamDto();
		teamDto.setId(entity.getId());
		teamDto.setName(entity.getName());
		teamDto.setName(entity.getLeader().getUsername());
		teamDto.setMembers(personConverter.toDtoCollection(entity.getMembers()));
		return teamDto;
	}

}
