package org.samulake.web.ui.view.impl;

import com.vaadin.ui.Button;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;
import org.samulake.web.ui.controller.EventFormController;
import org.samulake.web.ui.view.IEventFormView;

public abstract class EventFormView extends VerticalLayout implements IEventFormView<EventFormController, IEventService> {
    private TextField eventTitleTextField;
    private DateTimeField dateTimeField;
    private Button submitButton;

    public EventFormView() {
        init(new TreningDto());
        showEventForm();
        addComponent(new Button("Create"));
    }

    public void init(EventDto eventDto) {
        eventTitleTextField = new TextField("Title");
        dateTimeField = new DateTimeField("Date and time");
        addComponents(eventTitleTextField, dateTimeField);

    }

    public EventDto getModel() {
        return new TreningDto();
    }
}
