package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.service.security.IUserService;
import org.samulake.web.ui.component.LoginFormComponent;
import org.samulake.web.ui.controller.LoginController;
import org.samulake.web.ui.view.ILoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.Observable;

@UIScope
@SpringView(name = ILoginView.VIEW_URL)
public class LoginPage extends VerticalLayout implements ILoginView<LoginController, IUserService> {
    private LoginFormComponent loginForm;
    private LoginController controller;
    private IUserService model;

    @Autowired
    public LoginPage(LoginController controller, @Qualifier("userService") IUserService model) {
        initModel(model);
        initController(controller);
    }

    @PostConstruct
    private void init() {
        loginForm = new LoginFormComponent();
        loginForm.loginClickListener(event -> login());
        Panel panel = new Panel("Login");
        panel.setContent(loginForm.getContent());
        addComponent(panel);
    }

    @Override
    public void login() {
        controller.onLoginClicked(loginForm.getProvidedUser());
    }

    @Override
    public String getUrl() {
        return ILoginView.VIEW_URL;
    }

    @Override
    public void initModel(IUserService model) {
        this.model = model;
    }

    @Override
    public void initController(LoginController controller) {
        this.controller = controller;
        controller.init(this, model);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
