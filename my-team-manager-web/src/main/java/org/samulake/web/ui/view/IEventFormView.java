package org.samulake.web.ui.view;

import org.samulake.web.core.dto.EventDto;
import org.samulake.web.ui.controller.Controller;

public interface IEventFormView extends View<EventDto> {
    void showEventForm();

    interface IEventFormController extends Controller<IEventFormView> {
        String TRENING_VIEW_URL = "treningForm";
        String MATCH_VIEW_URL = "matchForm";

        void onSubmitClicked();
    }
}
