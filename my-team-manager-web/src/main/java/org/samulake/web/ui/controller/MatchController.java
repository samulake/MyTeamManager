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

    private MatchDto formData;

    @Override
    public void onDeleteClicked() {
        getModel().remove(formData);
    }

    @Override
    public void onAddClicked() {
        formData = new MatchDto();
        formData.setHomeTeam(teamService.getUserTeam());
        getView().showFormWindow(new MatchDto());
    }

    @Override
    public void onEditClicked() {
        getView().showFormWindow(formData);
    }

    @Override
    public void onSaveClicked() {
        MatchDto match = getView().getFormData();
        match.setHomeTeam(teamService.getUserTeam());
        getModel().create(match);
    }

    @Override
    public <T> void setFormData(T formData) {
        this.formData = (MatchDto) formData;
    }
}
