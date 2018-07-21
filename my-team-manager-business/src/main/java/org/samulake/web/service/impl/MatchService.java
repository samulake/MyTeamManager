package org.samulake.web.service.impl;

import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.persistence.dao.MatchDao;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.IMatchService;
import org.samulake.web.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MatchService extends AbstractService<MatchDto, MatchDao> implements IMatchService {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private ITeamService teamService;

    @Autowired
    public MatchService(MatchDao matchDao) {
        super(matchDao);
    }

    @Override
    public List<MatchDto> getUserTeamEvents() {
        return null;
    }

    @Override
    public MatchDto getFirstOncomingEvent() {
        return matchDao.getUserTeamNextMatch(teamService.getUserTeam());
    }
}
