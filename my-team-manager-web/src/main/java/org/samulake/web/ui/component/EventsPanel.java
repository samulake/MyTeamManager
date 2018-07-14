package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.samulake.web.core.dto.EventDto;

import java.util.ArrayList;
import java.util.List;

public class EventsPanel extends Panel {
    private List<? extends EventDetailsPanel<? extends EventDto>> eventsPanels = new ArrayList<>();

    public <T extends EventDto> void addEvents(List<? extends EventDetailsPanel<T>> eventsPanels) {
        AbstractLayout layout = new VerticalLayout();
        this.eventsPanels = eventsPanels;
        eventsPanels.stream().forEach(eventPanel -> layout.addComponent(eventPanel));
        setContent(layout);
    }
}
