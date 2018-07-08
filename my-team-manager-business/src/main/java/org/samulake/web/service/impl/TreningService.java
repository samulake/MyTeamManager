package org.samulake.web.service.impl;

import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.core.entity.TreningEntity;
import org.samulake.web.persistence.dao.TreningDao;
import org.samulake.web.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TreningService extends AbstractService<TreningDto, TreningDao> implements IEventService<TreningDto>{
    @Autowired
    public TreningService(TreningDao treningDao) {
        super(treningDao);
    }
}
