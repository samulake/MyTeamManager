package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.ui.view.IEventFormView;

@UIScope
@SpringComponent
public class EventFormController implements IEventFormView.IEventFormController {

    @Override
    public void onSubmitClicked() {

    }

    @Override
    public void setView(IEventFormView iEventFormView) {

    }
}
