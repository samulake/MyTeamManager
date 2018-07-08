package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.view.impl.MatchView;
import org.samulake.web.ui.window.form.WindowUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@UIScope
@SpringComponent
public class MatchController extends AbstractController<MatchView, IEventService<MatchDto>> implements CrudEventHandler {

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Override
    public void onDeleteClicked() {

    }

    @Override
    public void onAddClicked() {
        MatchDto newMatch = new MatchDto();
        newMatch.setHomeTeam(teamService.getUserTeam());
        getView().showFormWindow(new MatchDto());
    }

    @Override
    public void onEditClicked() {

    }

    @Override
    public void onSaveClicked() {

    }
}
