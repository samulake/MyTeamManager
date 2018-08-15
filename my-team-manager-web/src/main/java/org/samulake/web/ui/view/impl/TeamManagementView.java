package org.samulake.web.ui.view.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.IMatchService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.impl.TeamService;
import org.samulake.web.ui.component.DataOperationsPanel;
import org.samulake.web.ui.component.MatchDetailsPanel;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.TeamController;
import org.samulake.web.ui.view.FormWindowHandler;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.window.form.AbstractFormWindow;
import org.samulake.web.ui.window.form.TeamMemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Observable;
import java.util.Set;

import static org.samulake.web.ui.view.layout.LayoutFactory.getTeamManagementLayout;
import static org.samulake.web.ui.window.form.WindowUtils.addWindow;

@UIScope
@SpringView(name = ITeamManagementView.VIEW_URL)
public class TeamManagementView extends AbstractView<TeamController, ITeamService> implements ITeamManagementView, FormWindowHandler<PersonDto> {

    @ViewComponent(name = "squadGrid")
    private Grid<PersonDto> squadGrid;

    @ViewComponent(name = "dataOperationsPanel")
    private DataOperationsPanel dataOperationsPanel;

    @ViewComponent(name = "nextMatchPanel")
    private MatchDetailsPanel nextMatchPanel;

    private AbstractFormWindow<PersonDto> teamMemberForm;

    @Autowired
    @Qualifier("matchService")
    private IMatchService matchService;

    @Autowired
    public TeamManagementView(TeamController controller, @Qualifier("teamService") ITeamService model) {
        super(controller,model, getTeamManagementLayout());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        showOncomingEvents();
        showTeamSquad();
    }

    @Override
    public void showTeamSquad() {
        TeamDto userTeam = getModel().getUserTeam();
        List<PersonDto> squad = userTeam.getMembers();
        dataOperationsPanel.setCaption("Team " + userTeam.getName());
        squadGrid.setItems(squad);
    }

    @Override
    public void showOncomingEvents() {
        if(matchService.getFirstOncomingEvent() != null) {
            nextMatchPanel.setEvent(matchService.getFirstOncomingEvent());
        }
    }

    @Override
    public String getUrl() {
        return ITeamManagementView.VIEW_URL;
    }

    @Override
    public void initViewComponents() {
        dataOperationsPanel = new DataOperationsPanel.DataOperationsPanelBuilder(new HorizontalLayout()).withAddEditDeleteButtons().build();

        squadGrid = new Grid<>();
        squadGrid.addColumn(PersonDto::getFirstName).setCaption("Name");
        squadGrid.addColumn(PersonDto::getLastName).setCaption("Surname");

        nextMatchPanel = new MatchDetailsPanel(getController());

        addListenersToCrudButtons();
    }

    private void addListenersToCrudButtons() {
        dataOperationsPanel.getAddButton().addClickListener(event -> getController().onAddClicked());
        dataOperationsPanel.getEditButton().addClickListener(event -> getController().onEditClicked());
        dataOperationsPanel.getDeleteButton().addClickListener(event -> getController().onDeleteClicked());
    }

    @Override
    public void update(Observable o, Object arg) {
        ITeamService observedModel = (TeamService)o;
        squadGrid.setItems(observedModel.getUserTeam().getMembers());
    }

    public Set<PersonDto> getSelectedTeamMembers() {
        return squadGrid.getSelectedItems();
    }

    @Override
    public void showFormWindow(PersonDto formData) {
        teamMemberForm = new TeamMemberForm(formData, getController());
        addWindow(teamMemberForm);
    }

    @Override
    public PersonDto getFormData() {
        TeamDto team = getModel().getUserTeam();
        PersonDto newMember = teamMemberForm.getFormData();
        if(team.getMembers().contains(newMember)) {
            team.getMembers().remove(newMember);
        }
        team.getMembers().add(newMember);
        return teamMemberForm.getFormData();
    }
}
