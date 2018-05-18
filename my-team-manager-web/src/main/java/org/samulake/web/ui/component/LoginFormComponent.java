package org.samulake.web.ui.component;

import com.vaadin.ui.*;

@org.springframework.stereotype.Component
public class LoginFormComponent extends LoginForm {
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button loginButton;

    public LoginFormComponent() {
        usernameTextField = new TextField("Username:");
        passwordField = new PasswordField("Password:");
        loginButton = new Button("Log in");
        createContent(usernameTextField, passwordField, loginButton);
    }

    @Override
    public Component getContent() {
        return super.createContent(usernameTextField, passwordField, loginButton);
    }

    public String getUsernameProvided() {
        return usernameTextField.getValue();
    }

    public String getPasswordProvided() {
        return passwordField.getValue();
    }

    public void loginClickListener(Button.ClickListener listener) {
        loginButton.addClickListener(listener);
    }
}
