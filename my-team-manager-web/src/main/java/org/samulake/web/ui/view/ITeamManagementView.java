package org.samulake.web.ui.view;

import org.samulake.web.core.dto.PersonDto;

public interface ITeamManagementView extends FormWindowHandler<PersonDto> {
    void showTeamSquad();

    void showOncomingEvents();

    String VIEW_URL = "teamManagement";
}
