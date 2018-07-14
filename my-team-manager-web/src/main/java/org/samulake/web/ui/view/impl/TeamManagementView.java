package org.samulake.web.ui.view.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.impl.TeamService;
import org.samulake.web.ui.component.CrudPanel;
import org.samulake.web.ui.component.EventDetailsPanel;
import org.samulake.web.ui.component.MatchDetailsPanel;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.TeamManagementController;
import org.samulake.web.ui.view.FormWindowHandler;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.window.form.AbstractFormWindow;
import org.samulake.web.ui.window.form.TeamMemberForm;
import org.samulake.web.ui.window.form.WindowUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.addon.calendar.Calendar;

import java.util.List;
import java.util.Observable;
import java.util.Set;

import static org.samulake.web.ui.view.layout.LayoutFactory.getTeamManagementLayout;
import static org.samulake.web.ui.window.form.WindowUtils.addWindow;

@UIScope
@SpringView(name = ITeamManagementView.VIEW_URL)
public class TeamManagementView extends AbstractView<TeamManagementController, TeamService> implements ITeamManagementView, FormWindowHandler<PersonDto> {

    @ViewComponent(name = "squadGrid")
    private Grid<PersonDto> squadGrid;

    @ViewComponent(name = "calendar")
    private Calendar calendar;

    @ViewComponent(name = "teamMemberCrudPanel")
    private CrudPanel crudPanel;

    @ViewComponent(name = "nextMatchPanel")
    EventDetailsPanel<? extends EventDto> nextMatchPanel;

    private AbstractFormWindow<PersonDto> teamMemberForm;

    @Autowired
    @Qualifier()
    private IEventService<? extends EventDto> eventService;

    @Autowired
    public TeamManagementView(TeamManagementController controller, TeamService model) {
        super(controller,model, getTeamManagementLayout());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        showOncomingEvents();
        showTeamSquad();
    }

    @Override
    public void showTeamSquad() {
        List<PersonDto> squad = getModel().getUserTeam().getMembers();
        squadGrid.setItems(squad);
    }

    @Override
    public void showOncomingEvents() {

    }

    @Override
    public String getUrl() {
        return ITeamManagementView.VIEW_URL;
    }

    @Override
    public void initViewComponents() {
        crudPanel = new CrudPanel.CrudPanelBuilder(new HorizontalLayout()).withAddEditDeleteButtons().build();

        squadGrid = new Grid<>("Squad");
        squadGrid.addColumn(PersonDto::getFirstName).setCaption("Name");
        squadGrid.addColumn(PersonDto::getLastName).setCaption("Surname");

        nextMatchPanel = new MatchDetailsPanel(new MatchDto(),getController());

        calendar = new Calendar();
        addListenersToCrudButtons();
    }

    private void addListenersToCrudButtons() {
        crudPanel.getAddButton().addClickListener(event -> getController().onAddClicked());
        crudPanel.getEditButton().addClickListener(event -> getController().onEditClicked());
        crudPanel.getDeleteButton().addClickListener(event -> getController().onDeleteClicked());
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
