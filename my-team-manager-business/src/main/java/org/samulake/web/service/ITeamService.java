package org.samulake.web.service;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.core.dto.UserDto;

import java.util.Collection;

public interface ITeamService extends Model<TeamDto> {
    void createNewTeam(TeamDto teamDto);

    void addMember(PersonDto newMember);

    Collection<String> getAllTeamsNames();
}
