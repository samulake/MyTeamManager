package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.ui.controller.TeamFormController;
import org.samulake.web.ui.view.ITeamFormView;
import org.samulake.web.ui.window.MyTeamManagerUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@UIScope
@SpringView(name = ITeamFormView.ITeamFormController.VIEW_URL)
public class TeamFormView extends VerticalLayout implements ITeamFormView {
    private TextField teamNameTextField;
    private Button submitButton;

    private ITeamFormController controller;

    @Autowired
    public TeamFormView(@Qualifier("teamFormController") ITeamFormController controller) {
        this.controller = controller;
        controller.setView(this);
        init(null);
        showTeamForm();
    }

    @Override
    public void showTeamForm() {

    }

    @Override
    public String getUrl() {
        return ITeamFormView.ITeamFormController.VIEW_URL;
    }

    @Override
    public void init(TeamDto teamDto) {

        teamNameTextField = new TextField("Team name");
        submitButton = new Button("Submit");
        addComponents(teamNameTextField, submitButton);
        submitButton.addClickListener(event -> controller.onCreateClicked());
    }

    @Override
    public TeamDto getModel() {
        TeamDto teamDto = new TeamDto();
        teamDto.setName(teamNameTextField.getValue());
        return teamDto;
    }
}
