package org.samulake.web.ui.view;

import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.ui.controller.Controller;

public interface ITeamFormView extends View<TeamDto>{

    void showTeamForm();

    interface ITeamFormController extends Controller<ITeamFormView> {
        String VIEW_URL = "teamForm";

        void onCreateClicked();
    }
}
