package org.samulake.web.service.impl;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.PlaceDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.IPersonService;
import org.samulake.web.service.IPlaceService;
import org.samulake.web.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventModelService {
    @Autowired
    @Qualifier("placeService")
    private IPlaceService placeService;

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Autowired
    @Qualifier("personService")
    private IPersonService personService;

    public List<PlaceDto> getEventPlaces() {
        return placeService.getAllData();
    }

    public List<TeamDto> getAllTeams() {
        return teamService.getAllData();
    }

    public List<PersonDto> getUserTeamSquad() {
        return teamService.getUserTeam().getMembers();
    }
}
