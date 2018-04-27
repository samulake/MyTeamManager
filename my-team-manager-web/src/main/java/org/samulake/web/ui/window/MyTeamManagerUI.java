package org.samulake.web.ui.window;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.annotation.WebServlet;

@SpringUI
@Theme("mytheme")
@Widgetset("AppWidgetset")
public class MyTeamManagerUI extends UI {
	private static final long serialVersionUID = 1L;

    @Autowired
    @Qualifier("headerLayout")
    private AbstractLayout headerLayout;

	@Autowired
    @Qualifier("menuLayout")
	private AbstractLayout menuLayout;

	private AbstractLayout contentLayout;

	private VerticalLayout layout;

	@Autowired
	private SpringViewProvider viewProvider;
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {
        layout = new VerticalLayout();
        contentLayout = new VerticalLayout();
        AbstractLayout menuAndContentLayout = new HorizontalLayout();

        menuAndContentLayout.addComponents(menuLayout, contentLayout);
        contentLayout.setWidth(100, Unit.PERCENTAGE);
        layout.addComponents(headerLayout, menuAndContentLayout);
        initNavigator();

        setContent(layout);
    }

    private void initNavigator() {
        Navigator navigator = new Navigator(this, contentLayout);
        navigator.addProvider(viewProvider);
        setNavigator(navigator);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyTeamManagerUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
    }
}

