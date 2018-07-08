package org.samulake.web.ui.component;

import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.UserDto;

public class LoginFormComponent extends LoginForm {
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button loginButton;
    private Binder<UserDto> binder;

    public LoginFormComponent() {
        usernameTextField = new TextField("Username:");
        passwordField = new PasswordField("Password:");
        loginButton = new Button("Login");

        binder = new Binder<>();
        binder.setBean(new UserDto());
        binder.bind(usernameTextField, UserDto::getUsername, UserDto::setUsername);
        binder.bind(passwordField, UserDto::getPassword, UserDto::setPassword);
        createContent(usernameTextField, passwordField, loginButton);
    }

    public UserDto getProvidedUser() {
        return binder.getBean();
    }

    @Override
    protected TextField createUsernameField() {
        return usernameTextField;
    }

    @Override
    protected PasswordField createPasswordField() {
        return passwordField;
    }

    @Override
    protected Button createLoginButton() {
        return loginButton;
    }

    public void loginClickListener(Button.ClickListener listener) {
        loginButton.addClickListener(listener);
    }
}
