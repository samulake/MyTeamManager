package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.view.impl.TreningView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@UIScope
@SpringComponent
public class TreningController extends AbstractController<TreningView, IEventService<TreningDto>> implements CrudEventHandler {
    @Autowired
    @Qualifier("teamService")
    ITeamService teamService;

    private TreningDto formData;

    @Override
    public void onAddClicked() {
        formData = new TreningDto();
        formData.setTeam(teamService.getUserTeam());
        getView().showFormWindow(formData);
    }

    @Override
    public void onEditClicked() {
        getView().showFormWindow(formData);
    }

    @Override
    public void onSaveClicked() {
        getModel().updateData(formData);
    }

    @Override
    public <T> void setFormData(T formData) {
        this.formData = (TreningDto) formData;
    }

    @Override
    public void onDeleteClicked() {
        getModel().remove(formData);
    }
}
