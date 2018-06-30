package org.samulake.web.ui.view;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;

public interface ITeamManagementView<CONTROLLER extends AbstractController, MODEL extends Model> extends IView<CONTROLLER, MODEL> {
    void showTeamSquad();

    void showOncomingEvents();

    void showTeamMemberForm(PersonDto formData);

    String VIEW_URL = "teamManagement";
}
