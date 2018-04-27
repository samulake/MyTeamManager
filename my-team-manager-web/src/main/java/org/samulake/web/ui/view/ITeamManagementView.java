package org.samulake.web.ui.view;

import org.samulake.web.core.dto.TeamDto;

public interface ITeamManagementView extends View<TeamDto> {
    void showTeamSquad();

    void showOncomingEvents();

    String VIEW_URL = "teamManagement";

    interface ITeamManagementController<TeamDto> {

    }
}
