package org.samulake.web.ui.component;

import com.vaadin.ui.*;

public class TeamSettingsPanel extends Panel {

    public TeamSettingsPanel() {
        VerticalLayout mainLayout = new VerticalLayout();
        setCaption("Team settings");
        mainLayout.addComponent(new TextField("New team name:"));
        mainLayout.addComponent(new Button("Submit"));
        Button deleteTeam = new Button("Delete team");
        deleteTeam.setStyleName("delete");
        deleteTeam.setWidth("150px");
        mainLayout.addComponent(new Label());
        mainLayout.addComponent(deleteTeam);
        setContent(mainLayout);
    }
}
