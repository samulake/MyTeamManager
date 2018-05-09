package org.samulake.web.service;

import org.samulake.web.core.dto.TeamDto;

import java.util.Collection;

public interface ITeamService {
    void createNewTeam(TeamDto teamDto);

    Collection<String> getAllTeamsNames();

    TeamDto getUserTeam(String userName);
}
