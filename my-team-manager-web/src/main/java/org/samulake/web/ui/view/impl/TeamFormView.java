package org.samulake.web.ui.view.impl;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.ui.view.ITeamFormView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@UIScope
@SpringView(name = ITeamFormView.ITeamFormController.VIEW_URL)
public class TeamFormView extends VerticalLayout implements ITeamFormView {
    private TextField teamNameTextField;
    private Button submitButton;
    private Binder<TeamDto> binder;

    private ITeamFormController controller;

    @Autowired
    public TeamFormView(@Qualifier("teamFormController") ITeamFormController controller) {
        this.controller = controller;
        controller.setView(this);
        init(new TeamDto());
    }

    @Override
    public void showTeamForm() {

    }

    @Override
    public String getUrl() {
        return ITeamFormView.ITeamFormController.VIEW_URL;
    }

    @Override
    public final void init(TeamDto teamDto) {
        createFormFields();
        addListenersToFields();
        bindFields(teamDto);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        clearFields();
    }

    private void clearFields() {
        if(teamNameTextField != null) {
            teamNameTextField.setValue("");
        }
    }

    private void bindFields(TeamDto teamDto) {
        binder = new Binder<>();
        binder.forField(teamNameTextField)
                .withValidator(new StringLengthValidator("Team name must be between 3 and 100",3, 100))
                .bind(TeamDto::getName, TeamDto::setName);
        binder.setBean(teamDto);
    }

    private void createFormFields() {
        teamNameTextField = new TextField("Team name");
        submitButton = new Button("Submit");
        addComponents(teamNameTextField, submitButton);
    }

    private void addListenersToFields() {
        submitButton.addClickListener(event -> {
            if(binder.isValid()) {
                controller.onCreateClicked();
            } else Notification.show("Invalid team", Notification.Type.WARNING_MESSAGE);
        });
    }

    @Override
    public TeamDto getModel() {
        return binder.getBean();
    }
}
