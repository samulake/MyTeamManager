package org.samulake.web.ui.controller;

import com.vaadin.ui.Notification;
import org.samulake.web.core.dto.UserDto;
import org.samulake.web.service.security.IUserService;
import org.samulake.web.ui.view.ILoginView;
import org.samulake.web.ui.window.MyTeamManagerUI;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController extends AbstractController<ILoginView, IUserService> {

    public void onLoginClicked(UserDto user) {
        if(getModel().authenticated(user)) {
            MyTeamManagerUI.current().setUserContent();
        } else Notification.show("Bad credentials.");
    }
}
