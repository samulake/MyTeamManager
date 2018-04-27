package org.samulake.web.service;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;

public interface ITeamManagementService {
    void renameTeam(TeamDto teamDto, String newName);

    TeamDto getLeaderTeam(PersonDto leader);


}
