package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Label;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.ui.controller.CrudEventHandler;

public class TreningDetailsPanel extends EventDetailsPanel<TreningDto> {
    private Label squadLabel;

    public TreningDetailsPanel(TreningDto event, CrudEventHandler eventHandler) {
        super(event, eventHandler);
    }

    @Override
    protected void setOtherEventDetails(TreningDto event) {
        squadLabel.setValue(event.getTeam().getMembers().toString());
    }

    @Override
    protected AbstractComponent getOtherEventDetailsComponent() {
        squadLabel = new Label("Squad");
        return squadLabel;
    }
}
