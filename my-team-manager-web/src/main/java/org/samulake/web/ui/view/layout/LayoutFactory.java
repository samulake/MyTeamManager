package org.samulake.web.ui.view.layout;

import com.vaadin.ui.*;
import org.samulake.web.ui.component.MatchDetailsPanel;
import org.samulake.web.ui.component.TreningDetailsPanel;

import java.util.Map;

public class LayoutFactory {
    public static CreateLayout getTeamManagementLayout() {
        return viewComponents -> {
            GridLayout layout = new GridLayout(2,3);

            Component crudPanel = viewComponents.get("dataOperationsPanel");
            crudPanel.setWidth("500px");
            crudPanel.setCaption("Squad");

            layout.addComponent(crudPanel,0,0);
            layout.addComponent(viewComponents.get("squadGrid"), 0,1);

            Component nextMatchPanel = viewComponents.get("nextMatchPanel");
            nextMatchPanel.setCaption("Oncoming match");
            layout.addComponent(nextMatchPanel, 1, 0, 1, 1);
            nextMatchPanel.setWidth("450px");
            nextMatchPanel.setHeight("200px");

            return layout;
        };
    }

    public static CreateLayout getTeamFormLayout() {
        return viewComponents -> {
            VerticalLayout layout = new VerticalLayout();
            layout.addComponents(viewComponents.get("teamNameTextField"));
            layout.addComponent(viewComponents.get("createButton"));

            Panel panel = new Panel("Create team");
            panel.setContent(layout);
            return panel;
        };
    }

    public static CreateLayout getMatchesManagementLayout() {
        return viewComponents -> {
            viewComponents.get("eventsPanel").setCaption("Oncoming matches");
            return getEventManagementLayout(viewComponents);
        };
    }

    public static CreateLayout getSettingsLayout() {
        return viewComponents -> {
            AbstractLayout layout = new VerticalLayout();
            Component teamSettingsPanel = viewComponents.get("teamSettingsPanel");
            teamSettingsPanel.setWidth("600px");
            layout.addComponent(teamSettingsPanel);
            return layout;
        };
    }

    private static AbstractLayout getEventManagementLayout(Map<String, Component> viewComponents) {
        AbstractLayout layout = new VerticalLayout();
        layout.addComponent(viewComponents.get("addDeletePanel"));
        Component eventsPanel = viewComponents.get("eventsPanel");
        eventsPanel.setWidth("600px");
        layout.addComponent(eventsPanel);
        return layout;
    }

    public static CreateLayout getTreningManagementLayout() {
        return viewComponents -> {
            viewComponents.get("eventsPanel").setCaption("Oncoming trenings");
            return getEventManagementLayout(viewComponents);
        };
    }

    public static CreateLayout getLoginViewLayout() {
        return viewComponents -> {
            AbstractLayout layout = new FormLayout();
            Panel panel = new Panel("Login");
            panel.setContent(viewComponents.get("loginForm"));
            layout.addComponent(panel);
            return layout;
        };
    }
}
