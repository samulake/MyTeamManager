package org.samulake.web.service.impl;

import org.samulake.web.persistence.dao.TeamDao;
import org.samulake.web.service.ITeamManagementService;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamManagementService extends AbstractService<TeamDto, TeamDao> implements ITeamManagementService {

    @Autowired
    public TeamManagementService(TeamDao teamDao) {
        super(teamDao);
    }

    @Override
    public void renameTeam(TeamDto teamDto, String newName) {
        teamDto.setName(newName);
        getDao().save(teamDto);
    }

    @Override
    public TeamDto getLeaderTeam(PersonDto leader) {
        return null;
    }
}
