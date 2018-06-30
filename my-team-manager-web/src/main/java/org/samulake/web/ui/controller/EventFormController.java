package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.ui.view.IEventFormView;

@UIScope
@SpringComponent
public class EventFormController extends AbstractController<IEventFormView, IEventService> {

    public void onSubmitClicked() {

    }
}
