package org.samulake.web.ui.view.impl;

import com.vaadin.ui.HorizontalLayout;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.service.Model;
import org.samulake.web.ui.component.CrudPanel;
import org.samulake.web.ui.component.EventDetailsPanel;
import org.samulake.web.ui.component.EventsPanel;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.AbstractController;
import org.samulake.web.ui.view.FormWindowHandler;
import org.samulake.web.ui.view.layout.CreateLayout;
import org.samulake.web.ui.window.form.AbstractFormWindow;
import org.samulake.web.ui.window.form.EventForm;
import org.samulake.web.ui.window.form.WindowUtils;

import java.util.List;

public abstract class EventView<CONTROLLER extends AbstractController, MODEL extends Model> extends AbstractView<CONTROLLER, MODEL> {
    @ViewComponent(name="addDeletePanel")
    private CrudPanel addDeletePanel;
    @ViewComponent(name="eventsPanel")
    private EventsPanel eventsPanel;

    public EventView(CONTROLLER controller, MODEL model, CreateLayout layout) {
        super(controller, model, layout);
        addListenersToComponents();
    }

    protected void addListenersToComponents() {
        addDeletePanel.getAddButton().addClickListener(event -> getController().onAddClicked());
        addDeletePanel.getDeleteButton().addClickListener(event -> getController().onDeleteClicked());
    }

    protected  <T extends EventDto> void addEvents(List<? extends EventDetailsPanel<T>> eventPanels) {
        eventsPanel.addEvents(eventPanels);
    }

    @Override
    public void initViewComponents() {
        addDeletePanel = new CrudPanel.CrudPanelBuilder(new HorizontalLayout()).withAddButton().withDeleteButton().build();
        eventsPanel = new EventsPanel();
    }
}
