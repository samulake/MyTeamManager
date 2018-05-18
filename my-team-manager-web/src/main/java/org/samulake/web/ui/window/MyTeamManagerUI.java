package org.samulake.web.ui.window;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.samulake.web.service.security.UserService;
import org.samulake.web.ui.component.MenuLayout;
import org.samulake.web.ui.view.IEventFormView;
import org.samulake.web.ui.view.ILoginView;
import org.samulake.web.ui.view.ITeamFormView;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.view.impl.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringUI
@Theme("valo")
@Widgetset("AppWidgetset")
public class MyTeamManagerUI extends UI {
	private static final long serialVersionUID = 1L;

    @Autowired
    @Qualifier("headerLayout")
    private AbstractLayout headerLayout;

	private AbstractLayout menuLayout;

	private AbstractLayout contentLayout;

	private VerticalLayout layout;

	@Autowired
	private SpringViewProvider viewProvider;

	@Autowired
    LoginPage loginPage;

    public Map<String, String> menuUrlMap;

    @Autowired
    private UserService userService;

    {
        menuUrlMap = new HashMap<>();
        menuUrlMap.put(MenuLayout.CREATE_EVENT_TRENING_MENU_OPTION, IEventFormView.TRENING_VIEW_URL);
        menuUrlMap.put(MenuLayout.CREATE_EVENT_MATCH_MENU_OPTION, IEventFormView.MATCH_VIEW_URL);
        menuUrlMap.put(MenuLayout.CREATE_TEAM_MENU_OPTION, ITeamFormView.ITeamFormController.VIEW_URL);
        menuUrlMap.put(MenuLayout.MY_TEAM_MENU_OPTION, ITeamManagementView.VIEW_URL);
        menuUrlMap.put(MenuLayout.LOG_OUT_MENU_OPTION, LoginPage.VIEW_URL);
    }
	
	@Override
    protected final void init(VaadinRequest vaadinRequest) {
        setContent(getLoginPage());
    }

    private Component getLoginPage() {
        return viewProvider.getView(LoginPage.VIEW_URL).getViewComponent();
    }

    public void setUserContent() {
        layout = new VerticalLayout();
        contentLayout = new VerticalLayout();
        menuLayout = buildMenuLayout();
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

    private AbstractLayout buildMenuLayout() {
        Optional userTeam = Optional.ofNullable(userService.getLoggedUserDetails().getTeam());
        MenuLayout.MenuLayoutBuilder menuLayoutBuilder = new MenuLayout.MenuLayoutBuilder();
        if(userTeam.isPresent()) {
            menuLayoutBuilder.withTeamManagementView();
        } else menuLayoutBuilder.withTeamFormView();
        return menuLayoutBuilder.withCreateEventMenuOption().withLogoutMenuOption().build();
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyTeamManagerUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
    }

    public static MyTeamManagerUI current() {
	    return (MyTeamManagerUI) MyTeamManagerUI.getCurrent();
    }

    public void navigateTo(Tree.ItemClick menuItem) {
        if(menuItem.getItem() == MenuLayout.LOG_OUT_MENU_OPTION) {
            getLoginPage();
            Page.getCurrent().reload();
        } else {
            getNavigator().navigateTo(menuUrlMap.get(menuItem.getItem()));
        }
    }
}

