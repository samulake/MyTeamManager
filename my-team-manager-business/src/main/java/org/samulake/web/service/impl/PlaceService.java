package org.samulake.web.service.impl;

import org.samulake.web.core.dto.PlaceDto;
import org.samulake.web.persistence.dao.PlaceDao;
import org.samulake.web.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService extends AbstractService<PlaceDto, PlaceDao> implements IPlaceService{
    @Autowired
    public PlaceService(PlaceDao placeDao) {
        super(placeDao);
    }
}
