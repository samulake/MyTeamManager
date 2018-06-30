package org.samulake.web.ui.view;

import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;

public interface IEventFormView<CONTROLLER extends AbstractController, MODEL extends Model> extends IView<CONTROLLER, MODEL> {
    void showEventForm();

    String TRENING_VIEW_URL = "treningForm";
    String MATCH_VIEW_URL = "matchForm";
}
