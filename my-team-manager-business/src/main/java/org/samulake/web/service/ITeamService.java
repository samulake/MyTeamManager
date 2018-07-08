package org.samulake.web.service;

import org.samulake.web.core.dto.TeamDto;

public interface ITeamService extends Model<TeamDto> {

    TeamDto getUserTeam();
}
