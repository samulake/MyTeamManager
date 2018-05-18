package org.samulake.web.ui.controller;

import com.vaadin.ui.Notification;
import org.samulake.web.core.dto.UserDto;
import org.samulake.web.service.security.UserService;
import org.samulake.web.ui.view.ILoginView;
import org.samulake.web.ui.window.MyTeamManagerUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController implements ILoginView.ILoginController {
    private ILoginView view;

    @Autowired
    private UserService userService;

    @Override
    public void setView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void onLoginClicked() {
        UserDto user = view.getModel();
        if(userService.authenticate(user)) {
            MyTeamManagerUI.current().setUserContent();
        } else Notification.show("Bad credentials.");
    }
}
