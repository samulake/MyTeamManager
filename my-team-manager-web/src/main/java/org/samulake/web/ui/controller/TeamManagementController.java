package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.view.impl.TeamManagementView;

import java.util.Optional;
import java.util.Set;

@UIScope
@SpringComponent
public class TeamManagementController extends AbstractController<TeamManagementView, ITeamService> implements CrudEventHandler {

    @Override
    public void onSaveClicked() {
        PersonDto formData = getView().getFormData();
        TeamDto userTeam = getModel().getUserTeam();
        userTeam.getMembers().add(formData);
        getModel().updateData(userTeam);
    }

    @Override
    public void onDeleteClicked() {
        Set<PersonDto> selectedTeamMembers = getView().getSelectedTeamMembers();
        TeamDto team = getModel().getUserTeam();
        team.getMembers().removeAll(selectedTeamMembers);
        getModel().updateData(team);
    }

    @Override
    public void onAddClicked() {
       getView().showFormWindow(new PersonDto());
    }

    @Override
    public void onEditClicked() {
        Set<PersonDto> selectedTeamMembers = getView().getSelectedTeamMembers();
        if(!isOneSelection(selectedTeamMembers)) {
            getView().showWarning("Select one row");
            return;
        }
        PersonDto selection = selectedTeamMembers.iterator().next();
        getView().showFormWindow(selection);
    }

    private boolean isOneSelection(Set<PersonDto> selectedTeamMembers) {
        Optional<Set<PersonDto>> optional = Optional.ofNullable(selectedTeamMembers);
        return optional.filter(selecteMembers -> selecteMembers.size() == 1).isPresent();
    }
}
