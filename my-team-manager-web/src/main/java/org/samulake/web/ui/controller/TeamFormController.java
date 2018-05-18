package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.security.UserService;
import org.samulake.web.ui.view.ITeamFormView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@UIScope
@SpringComponent
public class TeamFormController implements ITeamFormView.ITeamFormController{
    private ITeamFormView view;

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Autowired
    private UserService userService;

    @Override
    public void onCreateClicked() {
        TeamDto model = view.getModel();
        model.setLeader(userService.getLoggedUserDetails());
        teamService.createNewTeam(model);
    }

    @Override
    public void setView(ITeamFormView view) {
        this.view = view;
    }
}
