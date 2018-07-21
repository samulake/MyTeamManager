package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.ui.controller.CrudEventHandler;

public abstract class EventDetailsPanel<T extends EventDto> extends Panel {
    private Label placeLabel;
    private Label dateTimeLabel;
    private AbstractComponent otherEventDetailsComponent;
    private DataOperationsPanel editCancellPanel;
    private T event;

    private GridLayout layout;

    {
        initComponents();
        setLayout();
    }

    public EventDetailsPanel(T event, CrudEventHandler eventHandler) {
        this.event = event;
        init(event);
        addListeners(eventHandler);
    }

    public EventDetailsPanel(CrudEventHandler eventHandler) {
        addListeners(eventHandler);
    }

    private void addListeners(CrudEventHandler eventHandler) {
        editCancellPanel.getCancellButton().addClickListener(e -> {
            eventHandler.setFormData(event);
            eventHandler.onDeleteClicked();
        });
        editCancellPanel.getEditButton().addClickListener(e -> {
            eventHandler.setFormData(event);
            eventHandler.onEditClicked();
        });
    }

    private void setLayout() {
        layout = new GridLayout(2,3);
        layout.setRowExpandRatio(2, 1);
        layout.setWidth("100%");
        setContent(layout);
        layout.addComponent(placeLabel, 0,0);
        layout.addComponent(dateTimeLabel, 1,0);
        layout.addComponent(otherEventDetailsComponent, 0, 1, 1, 1);
        layout.addComponent(editCancellPanel, 0,2,1,2);
    }

    private void init(T event) {
        if(event != null)
            setCaption(event.getTitle());
        placeLabel.setValue(event.getPlace().getPlaceDetails());
        dateTimeLabel.setValue(event.getDateTime().toString());
        setOtherEventDetails(event);
    }

    private void initComponents() {
        placeLabel = new Label();
        dateTimeLabel = new Label();
        CssLayout operationButtonsLayout = new CssLayout();
        operationButtonsLayout.setStyleName("centerLayout");
        editCancellPanel = new DataOperationsPanel.DataOperationsPanelBuilder(operationButtonsLayout).withEditButton().withCancellButton().build();
        otherEventDetailsComponent = getOtherEventDetailsComponent();
    }

    public void setEvent(T event) {
        placeLabel.setValue(event.getPlace().getPlaceDetails());
        dateTimeLabel.setValue(event.getDateTime().toString());
        setOtherEventDetails(event);
    }

    protected abstract void setOtherEventDetails(T event);

    protected abstract AbstractComponent getOtherEventDetailsComponent();

    public T getEvent() {
        return event;
    }
}
