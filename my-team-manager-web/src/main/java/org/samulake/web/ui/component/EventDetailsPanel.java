package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import org.samulake.web.core.dto.EventDto;

public abstract class EventDetailsPanel<T extends EventDto> extends Panel {
    private Label placeLabel;
    private Label dateTimeLabel;
    private AbstractComponent otherEventDetailsComponent;
    private CrudPanel editDeletePanel;

    public EventDetailsPanel(T event) {
        initComponents(event);
        setLayout();
    }

    private void setLayout() {
        GridLayout layout = new GridLayout(2,3);
        setContent(layout);
        layout.addComponent(placeLabel, 0,0);
        layout.addComponent(dateTimeLabel, 1,0);
        layout.addComponent(otherEventDetailsComponent, 0, 1, 1, 1);
        layout.addComponent(editDeletePanel, 0,2,1,2);
    }

    private void initComponents(T event) {
        setCaption(event.getTitle());
        placeLabel = new Label(event.getPlace().getPlaceDetails());
        dateTimeLabel = new Label(event.getDateTime().toString());
        editDeletePanel = new CrudPanel.CrudPanelBuilder(new HorizontalLayout()).withEditButton().withDeleteButton().build();
        otherEventDetailsComponent = getOtherEventDetailsComponent();
        setOtherEventDetails(event);
    }

    public void setEvent(T event) {
        placeLabel.setValue(event.getPlace().getPlaceDetails());
        dateTimeLabel.setValue(event.getDateTime().toString());
        setOtherEventDetails(event);
    }

    protected abstract void setOtherEventDetails(T event);

    protected abstract AbstractComponent getOtherEventDetailsComponent();
}
