package org.samulake.web.ui.view.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.component.CrudPanel;
import org.samulake.web.ui.controller.TeamManagementController;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.window.form.AbstractFormWindow;
import org.samulake.web.ui.window.form.TeamMemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.addon.calendar.Calendar;

import java.util.List;
import java.util.Observable;
import java.util.Set;

@UIScope
@SpringView(name = ITeamManagementView.VIEW_URL)
public class TeamManagementView extends GridLayout implements ITeamManagementView<TeamManagementController, ITeamService> {
    private Grid<PersonDto> squadGrid;
    private Calendar calendar;
    private AbstractFormWindow<PersonDto> teamMemberForm;

    @Autowired
    private TeamManagementController controller;

    @Autowired
    private ITeamService model;

    private CrudPanel crudPanel;

    @Autowired
    public TeamManagementView(TeamManagementController controller, @Qualifier("teamService") ITeamService model) {
        super(2,4);
        initModel(model);
        initController(controller);
        initComponents();
        addListenersToCrudButtons();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        showOncomingEvents();
        showTeamSquad();
    }

    @Override
    public void showTeamSquad() {
        List<PersonDto> squad = model.getData().getMembers();
        squadGrid.setItems(squad);
    }

    @Override
    public void showOncomingEvents() {

    }

    @Override
    public void showTeamMemberForm(PersonDto formData) {
        teamMemberForm = new TeamMemberForm(formData, controller);
        UI.getCurrent().addWindow(teamMemberForm);
    }

    @Override
    public String getUrl() {
        return ITeamManagementView.VIEW_URL;
    }

    @Override
    public void initModel(ITeamService model) {
        this.model = model;
        ((Observable) model).addObserver(this);
    }

    @Override
    public void initController(TeamManagementController controller) {
        this.controller = controller;
        controller.init(this, model);
    }

    private void addListenersToCrudButtons() {
        crudPanel.getAddButton().addClickListener(event -> controller.onAddClicked());
        crudPanel.getEditButton().addClickListener(event -> controller.onEditClicked());
        crudPanel.getDeleteButton().addClickListener(event -> controller.onDeleteClicked());
    }

    private void initComponents() {
        addComponent(new Label("Team management"));

        crudPanel = new CrudPanel.CrudPanelBuilder(new HorizontalLayout()).withAddEditDeleteButtons().build();
        crudPanel.setWidth("500px");
        addComponent(crudPanel,0,1);

        squadGrid = new Grid<>("Squad");
        squadGrid.addColumn(PersonDto::getFirstName).setCaption("Name");
        squadGrid.addColumn(PersonDto::getLastName).setCaption("Surname");
        addComponent(squadGrid, 0,2);
        Panel nextEventPanel = new Panel("Next event panel");
        addComponent(nextEventPanel, 1, 1, 1, 2);
        nextEventPanel.setWidth("300px");
        
        calendar = new Calendar();
        calendar.setWidth("950px");

        addComponent(calendar, 0 ,3, 1, 3);
    }

    @Override
    public void update(Observable o, Object arg) {
        ITeamService observedModel = (ITeamService)o;
        squadGrid.setItems(observedModel.getData().getMembers());
    }

    public Set<PersonDto> getSelectedTeamMembers() {
        return squadGrid.getSelectedItems();
    }

    public TeamDto getFormData() {
        TeamDto team = model.getData();
        PersonDto newMember = teamMemberForm.getFormData();
        if(team.getMembers().contains(newMember)) {
            team.getMembers().remove(newMember);
        }
        team.getMembers().add(newMember);
        return team;
    }
}
