package org.samulake.web.ui.window.form;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import org.samulake.web.ui.window.MyTeamManagerUI;

public class WindowUtils {
    public static void addWindow(Window window) {
        UI.getCurrent().addWindow(window);
    }

    public static MyTeamManagerUI currentUI() {
        return (MyTeamManagerUI) MyTeamManagerUI.getCurrent();
    }
}
