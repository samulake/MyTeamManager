package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.ui.controller.EventFormController;

@UIScope
@SpringView(name= EventFormController.MATCH_VIEW_URL)
public class MatchFormView extends EventFormView {
    private ComboBox rivalComboBox;
    private TextField playersPerTeamComboBox;
    private Grid<PersonDto> squadGrid;

    @Override
    public final void showEventForm() {
        rivalComboBox = new ComboBox<>("Rival");
        playersPerTeamComboBox = new TextField("Players per team");
        squadGrid = new Grid<>("Squad");
        addComponent(rivalComboBox);
        addComponent(playersPerTeamComboBox);
        addComponent(squadGrid);

        squadGrid.setItems(new PersonDto());
        squadGrid.addColumn(PersonDto::getFirstName).setCaption("First name");
        squadGrid.addColumn(PersonDto::getLastName).setCaption("Last name");
    }

    @Override
    public String getUrl() {
        return EventFormController.MATCH_VIEW_URL;
    }
}
