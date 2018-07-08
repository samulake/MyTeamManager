package org.samulake.web.ui.view.layout;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class LayoutFactory {
    public static CreateLayout getTeamManagementLayout() {
        return viewComponents -> {
            GridLayout layout = new GridLayout(2,4);
            layout.addComponent(new Label("Team management"));

            Component crudPanel = viewComponents.get("crudPanel");
            crudPanel.setWidth("500px");

            layout.addComponent(crudPanel,0,1);
            layout.addComponent(viewComponents.get("squadGrid"), 0,2);

            Component nextMatchPanel = viewComponents.get("nextMatchPanel");
            layout.addComponent(nextMatchPanel, 1, 1, 1, 2);
            nextMatchPanel.setWidth("300px");

            Component calendar = viewComponents.get("calendar");
            layout.addComponent(viewComponents.get("calendar"), 0 ,3, 1, 3);
            calendar.setWidth("900px");

            return layout;
        };
    }

    public static CreateLayout getTeamFormLayout() {
        return viewComponents -> {
            return new VerticalLayout();
        };
    }

    public static CreateLayout getEventsManagementLayout() {
        return viewComponents -> {
            AbstractLayout layout = new VerticalLayout();
            layout.addComponent(viewComponents.get("addDeletePanel"));
            layout.addComponent(viewComponents.get("eventsPanel"));
            return layout;
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
