package org.samulake.web.ui.component;

import com.vaadin.ui.Panel;
import org.samulake.web.core.dto.EventDto;

import java.util.ArrayList;
import java.util.List;

public class EventsPanel extends Panel {
    private List<EventDetailsPanel<? extends EventDto>> eventPanels;

    public EventsPanel() {
        eventPanels = new ArrayList<>();
    }

    public <T extends EventDto> void addEvents(List<? extends EventDetailsPanel<T>> eventPanels) {
        this.eventPanels.addAll(eventPanels);
    }
}
