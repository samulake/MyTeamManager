package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.UserDto;
import org.samulake.web.ui.component.LoginFormComponent;
import org.samulake.web.ui.view.ILoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = ILoginView.VIEW_URL)
public class LoginPage extends VerticalLayout implements ILoginView {
    @Autowired
    private LoginFormComponent loginForm;
    @Autowired
    @Qualifier("loginController")
    private ILoginController loginController;

    @PostConstruct
    private void init() {
        loginController.setView(this);
        loginForm.loginClickListener(event -> login());
        Panel panel = new Panel("Login");
        panel.setContent(loginForm.getContent());
        addComponent(panel);
    }

    @Override
    public void login() {
        loginController.onLoginClicked();
    }

    @Override
    public String getUrl() {
        return ILoginView.VIEW_URL;
    }

    @Override
    public void init(UserDto userDto) {

    }

    @Override
    public UserDto getModel() {
        return new UserDto(loginForm.getUsernameProvided(), loginForm.getPasswordProvided());
    }
}
