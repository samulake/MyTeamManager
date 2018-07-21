package org.samulake.web.service.impl;

import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.core.entity.TreningEntity;
import org.samulake.web.persistence.dao.TreningDao;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.ITreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TreningService extends AbstractService<TreningDto, TreningDao> implements ITreningService{
    @Autowired
    public TreningService(TreningDao treningDao) {
        super(treningDao);
    }

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Override
    public List<TreningDto> getUserTeamEvents() {
        return getDao().getByTeam(teamService.getUserTeam());
    }

    @Override
    public TreningDto getFirstOncomingEvent() {
        return null;
    }
}
