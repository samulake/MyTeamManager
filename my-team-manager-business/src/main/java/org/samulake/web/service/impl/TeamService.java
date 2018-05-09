package org.samulake.web.service.impl;

import org.samulake.web.persistence.dao.TeamDao;
import org.samulake.web.persistence.validation.ValidTeam;
import org.samulake.web.service.ITeamService;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamDao teamDao;

    @Autowired
    private UserService userService;

    @Override
    public void createNewTeam(TeamDto teamDto) {
        teamDao.save(teamDto);
    }

    @Override
    public Collection<String> getAllTeamsNames() {
        return teamDao.findAllTeamsNames();
    }

    @Override
    public TeamDto getUserTeam(String userName) {
        return teamDao.findByLeader(userName);
    }
}
