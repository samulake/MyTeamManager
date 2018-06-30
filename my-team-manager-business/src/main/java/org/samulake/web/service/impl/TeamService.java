package org.samulake.web.service.impl;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.persistence.dao.TeamDao;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Observable;

@Service
public class TeamService extends Observable implements ITeamService {
    @Autowired
    private TeamDao teamDao;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Override
    public void createNewTeam(TeamDto teamDto) {
        teamDao.save(teamDto);
        notifyObservers();
    }

    @Override
    public void addMember(PersonDto newMember) {

    }

    @Override
    public Collection<String> getAllTeamsNames() {
        return teamDao.findAllTeamsNames();
    }

    @Override
    public TeamDto getData() {
        String loggedUserName = userService.getLoggedUserDetails().getUsername();
        return teamDao.findByLeader(loggedUserName);
    }

    @Override
    public void updateData(TeamDto data) {
        teamDao.save(data);
        notifyObservers();
    }
}
