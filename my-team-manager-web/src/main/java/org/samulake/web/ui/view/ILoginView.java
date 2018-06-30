package org.samulake.web.ui.view;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;

public interface ILoginView<CONTROLLER extends AbstractController, MODEL extends Model> extends IView<CONTROLLER, MODEL> {

    void login();

    String VIEW_URL = "login";
}
