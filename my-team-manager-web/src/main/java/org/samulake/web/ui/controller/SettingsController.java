package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.view.impl.SettingsView;
import org.springframework.beans.factory.annotation.Autowired;

@UIScope
@SpringComponent
public class SettingsController extends AbstractController<SettingsView, ITeamService> {
    @Autowired
    private ITeamService teamService;

    @Override
    public void onDeleteClicked() {
        teamService.remove(teamService.getUserTeam());
    }

    @Override
    public void onEditClicked() {
        teamService.getUserTeam();
        super.onEditClicked();
    }
}
