package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Label;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.ui.controller.CrudEventHandler;

public class TreningDetailsPanel extends EventDetailsPanel<TreningDto> {

    public TreningDetailsPanel(TreningDto event, CrudEventHandler eventHandler) {
        super(event, eventHandler);
    }

    @Override
    protected void setOtherEventDetails(TreningDto event) {
    }

    @Override
    protected AbstractComponent getOtherEventDetailsComponent() {
        return null;
    }
}
