package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.service.security.IUserService;
import org.samulake.web.ui.component.LoginFormComponent;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.LoginController;
import org.samulake.web.ui.view.ILoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Observable;

import static org.samulake.web.ui.view.layout.LayoutFactory.getLoginViewLayout;

@UIScope
@SpringView(name = ILoginView.VIEW_URL)
public class LoginView extends AbstractView<LoginController, IUserService> implements ILoginView {
    @ViewComponent(name = "loginForm")
    private LoginFormComponent loginForm;

    @Autowired
    public LoginView(LoginController controller, @Qualifier("userService") IUserService model) {
        super(controller, model, getLoginViewLayout());
    }

    @Override
    public void login() {
        getController().onLoginClicked(loginForm.getProvidedUser());
    }

    @Override
    public String getUrl() {
        return ILoginView.VIEW_URL;
    }

    @Override
    public void initViewComponents() {
        loginForm = new LoginFormComponent();
        loginForm.loginClickListener(event -> getController().onLoginClicked(loginForm.getProvidedUser()));
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
