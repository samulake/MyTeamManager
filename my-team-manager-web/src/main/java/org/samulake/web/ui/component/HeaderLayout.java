package org.samulake.web.ui.component;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.springframework.stereotype.Component;

@Component
public class HeaderLayout extends CssLayout {

    public HeaderLayout() {
        Label title = new Label("MyTeamManager");
        title.addStyleName("H1");
        addComponent(title);
    }
}
