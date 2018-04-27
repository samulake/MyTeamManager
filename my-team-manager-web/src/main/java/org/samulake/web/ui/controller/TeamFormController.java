package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.view.ITeamFormView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
public class TeamFormController implements ITeamFormView.ITeamFormController{
    private ITeamFormView view;

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Override
    public void onCreateClicked() {
        teamService.createNewTeam(view.getModel());
    }

    @Override
    public void setView(ITeamFormView view) {
        this.view = view;
    }
}
