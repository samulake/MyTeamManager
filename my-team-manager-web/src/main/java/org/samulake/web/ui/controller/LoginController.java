package org.samulake.web.ui.controller;

import com.vaadin.ui.Notification;
import org.samulake.web.core.dto.UserDto;
import org.samulake.web.service.security.IUserService;
import org.samulake.web.ui.view.impl.LoginView;
import org.springframework.stereotype.Controller;

import static org.samulake.web.ui.window.form.WindowUtils.*;

@Controller
public class LoginController extends AbstractController<LoginView, IUserService> {

    public void onLoginClicked(UserDto user) {
        if(getModel().authenticated(user)) {
            currentUI().setUserContent();
        } else Notification.show("Bad credentials.");
    }
}
