package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.Model;
import org.samulake.web.ui.component.TeamSettingsPanel;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.AbstractController;
import org.samulake.web.ui.controller.SettingsController;
import org.samulake.web.ui.view.layout.CreateLayout;
import org.samulake.web.ui.view.layout.LayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Observable;

@UIScope
@SpringView(name = SettingsView.VIEW_URL)
public class SettingsView extends AbstractView<SettingsController, ITeamService> {
    public static final String VIEW_URL = "settings";

    @ViewComponent(name = "teamSettings")
    private TeamSettingsPanel teamSettingsPanel;

    @Autowired
    SettingsView(SettingsController controller, ITeamService model) {
        super(controller, model, LayoutFactory.getSettingsLayout());
        controller.init(this,model);
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public void initViewComponents() {
        teamSettingsPanel = new TeamSettingsPanel();
    }

    @Override
    public void update(Observable o, Object arg) {

    }


}
