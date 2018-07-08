package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.service.IEventService;
import org.samulake.web.ui.view.impl.EventView;

@UIScope
@SpringComponent
public class EventController extends AbstractController<EventView, IEventService> implements CrudEventHandler {
    @Override
    public void onDeleteClicked() {

    }

    @Override
    public void onAddClicked() {

    }

    @Override
    public void onEditClicked() {

    }

    @Override
    public void onSaveClicked() {

    }
}
