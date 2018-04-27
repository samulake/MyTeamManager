package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.ui.view.ITeamManagementView;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.calendar.Calendar;

@UIScope
@SpringView(name = ITeamManagementView.VIEW_URL)
public class TeamManagementView extends VerticalLayout implements ITeamManagementView {
    private Grid<PersonDto> squadGrid;
    private Calendar calendar;

    @Autowired
    public TeamManagementView() {
        init(new TeamDto());
    }

    @Override
    public void showTeamSquad() {

    }

    @Override
    public void showOncomingEvents() {

    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public final void init(TeamDto teamDto) {
        setCaption("Team management");
        squadGrid = new Grid<>("Squad");
        squadGrid.addColumn(PersonDto::getFirstName).setCaption("Name");
        squadGrid.addColumn(PersonDto::getLastName).setCaption("Surname");

        calendar = new Calendar();
        calendar.setWidth("900px");
        addComponents(squadGrid, calendar);

        showTeamSquad();
        showOncomingEvents();
    }

    @Override
    public TeamDto getModel() {
        return new TeamDto();
    }
}
