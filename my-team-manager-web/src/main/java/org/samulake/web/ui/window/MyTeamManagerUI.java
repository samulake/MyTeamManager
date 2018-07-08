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
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.service.security.UserService;
import org.samulake.web.ui.component.HeaderLayout;
import org.samulake.web.ui.component.MenuLayout;
import org.samulake.web.ui.view.IMatchesView;
import org.samulake.web.ui.view.ITeamFormView;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.view.ITreningView;
import org.samulake.web.ui.view.impl.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.security.core.context.SecurityContextHolder.MODE_GLOBAL;

@SpringUI(path = "my-team-manager")
@Theme("valo")
@Widgetset("AppWidgetset")
public class MyTeamManagerUI extends UI {
	private static final long serialVersionUID = 1L;

    private AbstractLayout headerLayout;

	private AbstractLayout menuLayout;

	private AbstractLayout contentLayout;

	private VerticalLayout layout;

	@Autowired
	private SpringViewProvider viewProvider;

    public Map<String, String> menuUrlMap;

    @Autowired
    private UserService userService;

    {
        menuUrlMap = new HashMap<>();
        menuUrlMap.put(MenuLayout.TRENING_MENU_OPTION, ITreningView.TRENING_VIEW_URL);
        menuUrlMap.put(MenuLayout.MATCHES_MENU_OPTION, IMatchesView.MATCH_VIEW_URL);
        menuUrlMap.put(MenuLayout.MY_TEAM_MENU_OPTION, ITeamManagementView.VIEW_URL);
        menuUrlMap.put(MenuLayout.LOG_OUT_MENU_OPTION, LoginView.VIEW_URL);
        menuUrlMap.put(MenuLayout.CREATE_TEAM_MENU_OPTION, ITeamFormView.VIEW_URL);
    }
	
	@Override
    protected final void init(VaadinRequest vaadinRequest) {
        SecurityContextHolder.setStrategyName(MODE_GLOBAL);
        if(!userService.isLoggedIn())
            setContent(getLoginPage());
        else {
            setUserContent();
        }
    }

    private Component getLoginPage() {
        return viewProvider.getView(LoginView.VIEW_URL).getViewComponent();
    }

    public void setUserContent() {
        if(layout != null) return;
        layout = new VerticalLayout();
        layout.setMargin(false);
        headerLayout = new HeaderLayout();
        contentLayout = new VerticalLayout();
        menuLayout = buildMenuLayout();


        AbstractLayout menuAndContentLayout = new HorizontalLayout();
        menuAndContentLayout.addComponents(menuLayout, contentLayout);
        layout.addComponents(headerLayout, menuAndContentLayout);
        initNavigator();
        setSizeFull();
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
            menuLayoutBuilder
                .withTeamManagementView()
                .withMatchView()
                .withTreningView();
        } else menuLayoutBuilder.withTeamFormView();
        return menuLayoutBuilder.withLogoutMenuOption().build();
    }

    @WebServlet(urlPatterns = "/my-team-manager/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyTeamManagerUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
    }

    public void navigateTo(Tree.ItemClick menuItem) {
        if(menuItem.getItem() == MenuLayout.LOG_OUT_MENU_OPTION) {
            SecurityContextHolder.getContextHolderStrategy().clearContext();
            getLoginPage();
            Page.getCurrent().reload();
        } else {
            getNavigator().navigateTo(menuUrlMap.get(menuItem.getItem()));
        }
    }
}

