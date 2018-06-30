package org.samulake.web.ui.view;

import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;

public interface ITeamFormView<CONTROLLER extends AbstractController, MODEL extends Model> extends IView<CONTROLLER, MODEL> {
    String VIEW_URL = "newTeam";

    void showTeamForm();
}
