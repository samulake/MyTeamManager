package org.samulake.web.ui.component;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.ui.window.form.WindowUtils;

public class MenuLayout extends VerticalLayout {
    public static final String MY_TEAM_MENU_OPTION = "Team management";
    public static final String MATCHES_MENU_OPTION = "Matches";
    public static final String TRENING_MENU_OPTION = "Trening";
    public static final String CREATE_TEAM_MENU_OPTION = "Create team";
    public static final String LOG_OUT_MENU_OPTION = "Log out";

    private TreeData<String> menuTreeData;

    private MenuLayout(MenuLayoutBuilder builder) {
        this.menuTreeData = builder.menuTreeData;
        init();
    }

    private void init() {
        setWidth("300px");
        Tree<String> menuTree = new Tree<>();
        TreeDataProvider inMemoryDataProvider = new TreeDataProvider<>(menuTreeData);
        menuTree.setDataProvider(inMemoryDataProvider);
        setItemClickListener(menuTree);
        Panel panel = new Panel("Menu");
        panel.setContent(menuTree);
        panel.setHeight("500px");
        addComponent(panel);
    }

    private void setItemClickListener(Tree<String> tree) {
        Tree.ItemClickListener listener = selection -> {
            try {
                WindowUtils.currentUI().navigateTo(selection);
            } catch (NullPointerException e) {

            }
        };
        tree.addItemClickListener(listener);
    }

    public static class MenuLayoutBuilder {
        private TreeData<String> menuTreeData = new TreeData<>();

        public MenuLayoutBuilder withTeamManagementView() {
            menuTreeData.addItem(null,MY_TEAM_MENU_OPTION);
            return this;
        }

        public MenuLayoutBuilder withMatchView() {
            menuTreeData.addItem(null, MATCHES_MENU_OPTION);
            return this;
        }

        public MenuLayoutBuilder withTeamFormView() {
            menuTreeData.addItem(null, CREATE_TEAM_MENU_OPTION);
            return this;
        }

        public MenuLayoutBuilder withTreningView() {
            menuTreeData.addItem(null, TRENING_MENU_OPTION);
            return this;
        }

        public MenuLayoutBuilder withLogoutMenuOption() {
            menuTreeData.addItem(null, LOG_OUT_MENU_OPTION);
            return this;
        }

        public MenuLayout build() {
            return new MenuLayout(this);
        }
    }
}
