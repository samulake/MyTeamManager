package org.samulake.web.ui.view.impl;

import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.TeamFormController;
import org.samulake.web.ui.view.ITeamFormView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Observable;

import static org.samulake.web.ui.view.layout.LayoutFactory.getTeamFormLayout;

@UIScope
@SpringView(name = ITeamFormView.VIEW_URL)
public class TeamFormView extends AbstractView<TeamFormController, ITeamService>  implements ITeamFormView<TeamFormController, ITeamService> {
    @ViewComponent(name="formPanel")
    private Panel formPanel;
    @ViewComponent(name = "teamNameTextField")
    private TextField teamNameTextField;
    @ViewComponent(name = "createButton")
    private Button createButton;

    private Binder<TeamDto> binder;

    @Autowired
    public TeamFormView(@Qualifier("teamFormController") TeamFormController controller, @Qualifier("teamService") ITeamService model) {
        super(controller, model, getTeamFormLayout());
    }

    @Override
    public void showTeamForm() {

    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public void initViewComponents() {
        formPanel = new Panel();
        teamNameTextField = new TextField("Name");
        createButton = new Button("Create");
        createButton.addClickListener(event -> getController().onSaveClicked());
        binder = new Binder<>(TeamDto.class);
        binder.setBean(new TeamDto());
        binder.forField(teamNameTextField).bind("name");
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public TeamDto getFormData() {
        return binder.getBean();
    }
}
