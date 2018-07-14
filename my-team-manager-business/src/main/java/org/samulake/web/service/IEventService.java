package org.samulake.web.service;

import org.samulake.web.core.dto.EventDto;

import java.util.List;

public interface IEventService<DTO extends EventDto> extends Model<DTO> {
    List<DTO> getUserTeamEvents();

    DTO getFirstOncomingEvent();
}
