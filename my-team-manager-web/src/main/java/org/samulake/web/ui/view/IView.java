package org.samulake.web.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;

import java.util.Observer;

public interface IView<CONTROLLER extends AbstractController, MODEL extends Model> extends View, Observer {
    String getUrl();

    void initModel(MODEL model);

    void initController(CONTROLLER controller);

    default void showWarning(String message) {
        Notification.show(message, Notification.Type.WARNING_MESSAGE);
    }


}
