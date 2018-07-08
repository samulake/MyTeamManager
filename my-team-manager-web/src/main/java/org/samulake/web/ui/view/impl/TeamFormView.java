package org.samulake.web.ui.view.impl;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.controller.TeamFormController;
import org.samulake.web.ui.view.ITeamFormView;
import org.samulake.web.ui.view.layout.LayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Observable;

import static org.samulake.web.ui.view.layout.LayoutFactory.getTeamFormLayout;

@UIScope
@SpringView(name = ITeamFormView.VIEW_URL)
public abstract class TeamFormView extends AbstractView<TeamFormController, ITeamService> implements ITeamFormView<TeamFormController, ITeamService> {
    private TextField teamNameTextField;
    private Button submitButton;
    private Binder<TeamDto> binder;

    private AbstractLayout layout;

    @Autowired
    public TeamFormView(@Qualifier("teamFormController") TeamFormController controller, @Qualifier("teamService") ITeamService model) {
        super(controller, model, getTeamFormLayout());
    }

    @Override
    public void showTeamForm() {

    }

    @Override
    public String getUrl() {
        return ITeamFormView.VIEW_URL;
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
        layout.addComponents(teamNameTextField, submitButton);
    }

    private void addListenersToFields() {
        submitButton.addClickListener(event -> {
            if(binder.isValid()) {
                //controller.onCreateClicked();
            } else Notification.show("Invalid team", Notification.Type.WARNING_MESSAGE);
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
