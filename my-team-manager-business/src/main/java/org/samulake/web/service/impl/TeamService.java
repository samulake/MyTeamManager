package org.samulake.web.service.impl;

import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.persistence.dao.TeamDao;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TeamService extends AbstractService<TeamDto, TeamDao> implements ITeamService {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    public TeamService(TeamDao userDao) {
        super(userDao);
    }

    public TeamDto getUserTeam() {
        String loggedUserName = userService.getLoggedUserDetails().getUsername();
        return getDao().findByLeader(loggedUserName);
    }
}
