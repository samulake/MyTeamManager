package org.samulake.web.service.impl;

import org.samulake.web.persistence.dao.TeamDao;
import org.samulake.web.persistence.validation.ValidTeam;
import org.samulake.web.service.ITeamService;
import org.samulake.web.core.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public void createNewTeam(@ValidTeam TeamDto teamDto) {
        teamDao.save(teamDto);
    }
}
