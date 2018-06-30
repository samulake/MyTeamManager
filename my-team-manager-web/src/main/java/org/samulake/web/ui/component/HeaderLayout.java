package org.samulake.web.ui.component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.springframework.stereotype.Component;

public class HeaderLayout extends HorizontalLayout {

    public HeaderLayout() {
        Label title = new Label("MyTeamManager");
        title.addStyleName("H1");
        addComponent(title);
    }
}
