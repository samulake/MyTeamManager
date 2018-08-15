package org.samulake.web.ui.view.impl;

import com.vaadin.ui.HorizontalLayout;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.service.Model;
import org.samulake.web.ui.component.DataOperationsPanel;
import org.samulake.web.ui.component.EventDetailsPanel;
import org.samulake.web.ui.component.EventsPanel;
import org.samulake.web.ui.component.annotation.ViewComponent;
import org.samulake.web.ui.controller.AbstractController;
import org.samulake.web.ui.view.layout.CreateLayout;

import java.util.List;

public abstract class EventView<CONTROLLER extends AbstractController, MODEL extends Model> extends AbstractView<CONTROLLER, MODEL> {
    @ViewComponent(name="addDeletePanel")
    protected DataOperationsPanel addDeletePanel;
    @ViewComponent(name="eventsPanel")
    private EventsPanel eventsPanel;

    public EventView(CONTROLLER controller, MODEL model, CreateLayout layout) {
        super(controller, model, layout);
        addListenersToComponents();
    }

    protected void addListenersToComponents() {
        addDeletePanel.getAddButton().addClickListener(event -> getController().onAddClicked());
    }

    protected  <T extends EventDto> void addEvents(List<? extends EventDetailsPanel<T>> eventPanels) {
        eventsPanel.addEvents(eventPanels);
    }

    @Override
    public void initViewComponents() {
        addDeletePanel = new DataOperationsPanel.DataOperationsPanelBuilder(new HorizontalLayout()).withAddButton().build();
        eventsPanel = new EventsPanel();
    }
}
