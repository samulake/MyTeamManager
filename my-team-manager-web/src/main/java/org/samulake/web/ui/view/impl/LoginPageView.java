package org.samulake.web.ui.view.impl;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = "login")
@Title("Login page")
public class LoginPageView extends VerticalLayout implements View {

    private TextField usernameTextField;
    private PasswordField passwordField;

    public LoginPageView() {
        usernameTextField = new TextField("User");
        passwordField = new PasswordField("Password");

        addComponents(usernameTextField, passwordField);
    }
}
