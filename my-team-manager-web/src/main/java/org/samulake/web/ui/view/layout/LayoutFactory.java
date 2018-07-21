package org.samulake.web.ui.view.layout;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.ui.component.MatchDetailsPanel;
import org.samulake.web.ui.component.TreningDetailsPanel;

import java.util.Map;

public class LayoutFactory {
    public static CreateLayout getTeamManagementLayout() {
        return viewComponents -> {
            GridLayout layout = new GridLayout(2,3);
            layout.addComponent(new Label("Team management"));

            Component crudPanel = viewComponents.get("dataOperationsPanel");
            crudPanel.setWidth("500px");

            layout.addComponent(crudPanel,0,1);
            layout.addComponent(viewComponents.get("squadGrid"), 0,2);

            Component nextMatchPanel = viewComponents.get("nextMatchPanel");
            nextMatchPanel.setCaption("Oncoming match");
            layout.addComponent(nextMatchPanel, 1, 1, 1, 2);
            nextMatchPanel.setWidth("450px");

            return layout;
        };
    }

    public static CreateLayout getTeamFormLayout() {
        return viewComponents -> {
            VerticalLayout layout = new VerticalLayout();
            layout.addComponents(viewComponents.get("teamNameTextField"));
            layout.addComponent(viewComponents.get("createButton"));
            return layout;
        };
    }

    public static CreateLayout getMatchesManagementLayout() {
        return viewComponents -> {
            viewComponents.get("eventsPanel").setCaption("Oncoming matches");
            return getEventManagementLayout(viewComponents);
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
