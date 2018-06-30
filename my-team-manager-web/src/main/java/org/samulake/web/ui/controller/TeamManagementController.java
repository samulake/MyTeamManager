package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.predicates.OnlyOnePredicate;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.view.impl.TeamManagementView;
import org.samulake.web.ui.window.form.AbstractFormWindow;
import org.samulake.web.ui.window.form.TeamMemberForm;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@UIScope
@SpringComponent
public class TeamManagementController extends AbstractController<TeamManagementView, ITeamService> implements CrudEventHandler {

    @Override
    public void onSaveClicked() {
        getModel().updateData(getView().getFormData());
    }

    @Override
    public void onDeleteClicked() {
        Set<PersonDto> selectedTeamMembers = getView().getSelectedTeamMembers();
        TeamDto team = getModel().getData();
        team.getMembers().removeAll(selectedTeamMembers);
        getModel().updateData(team);
    }

    @Override
    public void onAddClicked() {
       getView().showTeamMemberForm(new PersonDto());
    }

    @Override
    public void onEditClicked() {
        Set<PersonDto> selectedTeamMembers = getView().getSelectedTeamMembers();
        if(!isOneSelection(selectedTeamMembers)) {
            getView().showWarning("Select one row");
        }
        PersonDto selection = selectedTeamMembers.iterator().next();
        getView().showTeamMemberForm(selection);
    }

    private boolean isOneSelection(Set<PersonDto> selectedTeamMembers) {
        Optional<Set<PersonDto>> optional = Optional.ofNullable(selectedTeamMembers);
        return optional.filter(selecteMembers -> selecteMembers.size() == 1).isPresent();
    }
}
