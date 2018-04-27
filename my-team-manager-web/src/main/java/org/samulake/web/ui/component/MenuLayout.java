package org.samulake.web.ui.component;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.ui.controller.EventFormController;
import org.samulake.web.ui.controller.TeamFormController;
import org.samulake.web.ui.view.ITeamFormView;
import org.samulake.web.ui.view.ITeamManagementView;
import org.samulake.web.ui.window.MyTeamManagerUI;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class MenuLayout extends VerticalLayout {
    public static final String MY_TEAM_MENU_OPTION = "My team";
    public static final String CREATE_TEAM_MENU_OPTION = "Create team";
    public static final String CREATE_EVENT_MENU_OPTION = "Create event";
    public static final String CREATE_EVENT_TRENING_MENU_OPTION = "Trening";
    public static final String CREATE_EVENT_MATCH_MENU_OPTION = "Match";
    public static final String LOG_OUT_MENU_OPTION = "Log out";

    public Map<String, String> menuUrlMap;
    {
        menuUrlMap = new HashMap<>();
        menuUrlMap.put(CREATE_EVENT_TRENING_MENU_OPTION, EventFormController.TRENING_VIEW_URL);
        menuUrlMap.put(CREATE_EVENT_MATCH_MENU_OPTION, EventFormController.MATCH_VIEW_URL);
        menuUrlMap.put(CREATE_TEAM_MENU_OPTION, ITeamFormView.ITeamFormController.VIEW_URL);
        menuUrlMap.put(MY_TEAM_MENU_OPTION, ITeamManagementView.VIEW_URL);
    }

    private void setItemClickListener(Tree<String> tree) {
        Tree.ItemClickListener listener = selection -> {
            try {
                MyTeamManagerUI.getCurrent().getNavigator().navigateTo(menuUrlMap.get(selection.getItem()));
            } catch (NullPointerException e) {

            }
        };
        tree.addItemClickListener(listener);
    }

    @PostConstruct
    public void init() {
        setWidth("250px");
        Tree<String> menuTree = new Tree<>();
        TreeData<String> menuTreeData = new TreeData<>();
        TreeDataProvider inMemoryDataProvider = new TreeDataProvider<>(menuTreeData);
        menuTree.setDataProvider(inMemoryDataProvider);
        menuTreeData.addItem(null,MY_TEAM_MENU_OPTION);
        menuTreeData.addItem(null,CREATE_TEAM_MENU_OPTION);

        menuTreeData.addItem(null,CREATE_EVENT_MENU_OPTION);
        menuTreeData.addItem(CREATE_EVENT_MENU_OPTION,CREATE_EVENT_TRENING_MENU_OPTION);
        menuTreeData.addItem(CREATE_EVENT_MENU_OPTION,CREATE_EVENT_MATCH_MENU_OPTION);
        menuTreeData.addItem(null, LOG_OUT_MENU_OPTION);
        setItemClickListener(menuTree);

        Panel panel = new Panel();
        addComponents(panel);
        panel.setContent(menuTree);
        panel.setCaption("Menu");
    }


}
