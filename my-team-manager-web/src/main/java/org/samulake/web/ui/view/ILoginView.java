package org.samulake.web.ui.view;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.ui.controller.Controller;

public interface ILoginView extends View<UserDto> {

    void login();

    String VIEW_URL = "login";

    interface ILoginController extends Controller<ILoginView> {
        void onLoginClicked();
    }
}
